package com.controller;

import com.bean.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author sushuai
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private BankcardService bankcardService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    /**
     * 登录的控制层
     *
     * @param username
     * @param password
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, Model model) {
        User user = userService.userLogin(username,password);
        String name = userService.selectNameById(username).getUserName();
        if (user != null) {
            if (user.getUserPassword().equals(password)) {
                System.out.println("登录成功");
                HttpSession session = request.getSession();
                session.setAttribute("username", name);
                session.setAttribute("userid", username);
                session.setAttribute("userpage", 1);

                model.addAttribute("state","登录成功");
                return "Miao/index";
            } else {
                System.out.println("用户名或密码错误");
                model.addAttribute("failure", "用户名或密码错误！");
                return "Miao/loginError";
            }
        } else {
            System.out.println("用名不存在");
            model.addAttribute("state", "failure");
            model.addAttribute("message", "该用户不存在");
            return "Miao/loginError";
        }
    }


    /**
     * 注册的控制层
     *
     * @param username
     * @param password
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("Email") String email, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("sex") String sex, @RequestParam("phone") String phone, @RequestParam("invitee") String invitee,HttpServletRequest request, Model model) {
        System.out.println("输入的信息"+username+password+sex+invitee+phone+email);
        String id = getUUID();
        User user = new User();
        user.setUserIdentity(email);
        user.setUserName(username);
        user.setUserPassword(password);
        user.setUserPhone(phone);
        user.setUserSex(sex);
        user.setUserInvitee(invitee);

        boolean flag1 = userService.insertUser(user);
        boolean flag2 = userService.insertUserPassword(user);
        System.out.println(flag1&&flag2);
        return "Miao/login";
    }

    /**
     * 用户订单的控制层
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "/userorder")
    public String userOrder(@RequestParam("userid") String userid,HttpServletRequest request, Model model) {
        String name = userService.selectNameById(userid).getUserName();
        List<Order> orderlist = orderService.selectUserOrder(userid);
        HttpSession session = request.getSession();
        session.setAttribute("username", name);
        session.setAttribute("userid", userid);
        session.setAttribute("orderlist", orderlist);
        session.setAttribute("orderFinalState",5);
//        System.out.println(orderlist.get(0).getOrderId());
        return "Miao/order";
    }

    /**
     * 用户信息的控制层
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "/personalinfo")
    public String personalInfo(@RequestParam("userid") String userid,HttpServletRequest request, Model model) {
        //当前时间
        Date nowDate = new Date();
        List<Coupon> couponlist = couponService.selectCoupon(userid);
        for (Coupon coupon : couponlist) {
            //开始时间
            Date startDate = coupon.getStartTime();
            //结束时间
            Date endDate = coupon.getEndTime();
            if (nowDate.getTime() <= startDate.getTime()) {
                coupon.setPercent(0);
            } else if (nowDate.getTime() >= endDate.getTime()) {
                coupon.setPercent(100);
            } else {
                //结束时间和开始时间中间的天数
                Double a = (double) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                //当前时间和开始时间中间的天数
                Double b = (double) ((nowDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                int p = (int) Math.floor(b / a * 100);
                //计算百分比存入
                coupon.setPercent(p);
            }
        }
        User user = userService.selectNameById(userid);
        List<Bankcard> bankcardlist = bankcardService.selectBankcard(userid);
        HttpSession session = request.getSession();
        session.setAttribute("bankcardlist", bankcardlist);
        session.setAttribute("couponlist", couponlist);
        session.setAttribute("user", user);
        session.setAttribute("state", 1);
        session.setAttribute("insertstate", 0);
        session.setAttribute("updatestate", 0);
        return "Miao/personalpage";
    }

    /**
     * 银行卡的控制层
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "/bankcard")
    public String selectBankcard(@RequestParam("userid") String userid,HttpServletRequest request, Model model) {
        //当前时间
        Date nowDate = new Date();
        List<Coupon> couponlist = couponService.selectCoupon(userid);
        for (Coupon coupon : couponlist) {
            //开始时间
            Date startDate = coupon.getStartTime();
            //结束时间
            Date endDate = coupon.getEndTime();
            if (nowDate.getTime() <= startDate.getTime()) {
                coupon.setPercent(0);
            } else if (nowDate.getTime() >= endDate.getTime()) {
                coupon.setPercent(100);
            } else {
                //结束时间和开始时间中间的天数
                Double a = (double) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                //当前时间和开始时间中间的天数
                Double b = (double) ((nowDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                int p = (int) Math.floor(b / a * 100);
                //计算百分比存入
                coupon.setPercent(p);
            }
        }
        User user = userService.selectNameById(userid);
        List<Bankcard> bankcardlist = bankcardService.selectBankcard(userid);
        HttpSession session = request.getSession();
        session.setAttribute("bankcardlist", bankcardlist);
        session.setAttribute("couponlist", couponlist);
        session.setAttribute("user", user);
        session.setAttribute("state", 3);
        session.setAttribute("insertstate", 0);
        session.setAttribute("updatestate", 0);
        return "Miao/personalpage";
    }

    /**
     * 添加银行卡的控制层
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "/addbankcard")
    public String addBankcard(@RequestParam("userid") String userid,@RequestParam("bank") String bank,@RequestParam("bankcardid") String bankcardid,HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        //当前时间
        Date nowDate = new Date();
        List<Coupon> couponlist = couponService.selectCoupon(userid);
        for (Coupon coupon : couponlist) {
            //开始时间
            Date startDate = coupon.getStartTime();
            //结束时间
            Date endDate = coupon.getEndTime();
            if (nowDate.getTime() <= startDate.getTime()) {
                coupon.setPercent(0);
            } else if (nowDate.getTime() >= endDate.getTime()) {
                coupon.setPercent(100);
            } else {
                //结束时间和开始时间中间的天数
                Double a = (double) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                //当前时间和开始时间中间的天数
                Double b = (double) ((nowDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                int p = (int) Math.floor(b / a * 100);
                //计算百分比存入
                coupon.setPercent(p);
            }
        }
        Bankcard bankcard = new Bankcard();
        bankcard.setBank(bank);
        bankcard.setBankcardId(bankcardid);
        bankcard.setUserId(userid);
        List<Bankcard> bankcardlist1 = bankcardService.selectBankcard(userid);
        for (Bankcard i : bankcardlist1) {
            if(bankcard.equals(i.getBankcardId())){
                session.setAttribute("insertstate", 2);
                return "Miao/personalpage";
            }
        }
        boolean flag =bankcardService.insertBankcard(bankcard);
        User user = userService.selectNameById(userid);
        List<Bankcard> bankcardlist = bankcardService.selectBankcard(userid);
        session.setAttribute("couponlist", couponlist);
        session.setAttribute("bankcardlist", bankcardlist);
        session.setAttribute("user", user);
        session.setAttribute("state", 3);
        session.setAttribute("updatestate", 0);
        if (flag){
            session.setAttribute("insertstate", 1);
        }
        else{
            session.setAttribute("insertstate", 2);
        }
        return "Miao/personalpage";
    }

    /**
     * 修改用户信息的控制层
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "/updateuserinfo")
    public String updateUserInfo(@RequestParam("userid") String userid,@RequestParam("useremail") String useremail,@RequestParam("username") String username,@RequestParam("userphone") String userphone,@RequestParam("sex") String sex,@RequestParam("userquarter") String userquarter,@RequestParam("userbuilding") String userbuilding,@RequestParam("userhouse") String userhouse,HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        //当前时间
        Date nowDate = new Date();
        List<Coupon> couponlist = couponService.selectCoupon(userid);
        for (Coupon coupon : couponlist) {
            //开始时间
            Date startDate = coupon.getStartTime();
            //结束时间
            Date endDate = coupon.getEndTime();
            if (nowDate.getTime() <= startDate.getTime()) {
                coupon.setPercent(0);
            } else if (nowDate.getTime() >= endDate.getTime()) {
                coupon.setPercent(100);
            } else {
                //结束时间和开始时间中间的天数
                Double a = (double) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                //当前时间和开始时间中间的天数
                Double b = (double) ((nowDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                int p = (int) Math.floor(b / a * 100);
                //计算百分比存入
                coupon.setPercent(p);
            }
        }
        User user = userService.selectNameById(userid);
        if(!("".equals(useremail.trim())  || useremail==null)){
            user.setUserIdentity(useremail);
        }
        if(!("".equals(username.trim())  || username==null)){
            user.setUserName(username);
        }
        if(!("".equals(userphone.trim())  || userphone==null)){
            user.setUserPhone(userphone);
        }
        if(!("".equals(sex.trim())  || sex==null)){
            user.setUserSex(sex);
        }
        if(!("".equals(userquarter.trim())  || userquarter==null)){
            user.setUserResidentialQuarters(userquarter);
        }
        if(!("".equals(userbuilding.trim())  || userbuilding==null)){
            user.setUserBuildingNumber(userbuilding);
        }
        if(!("".equals(userhouse.trim())  || userhouse==null)){
            user.setUserHouseNumber(userhouse);
            user.setUserFloor(Integer.parseInt(userhouse.substring(0,1)));
        }
        User userAut = userService.userAuthentication(user.getUserResidentialQuarters(),user.getUserBuildingNumber(),user.getUserHouseNumber());
        if(userAut!=null&&!userAut.getUserIdentity().equals(userid)){
            session.setAttribute("state", 2);
            session.setAttribute("updatestate", 2);
            return "Miao/personalpage";
        }

        boolean flag =userService.updateUserInfo(user);

        List<Bankcard> bankcardlist = bankcardService.selectBankcard(userid);
        session.setAttribute("couponlist", couponlist);
        session.setAttribute("bankcardlist", bankcardlist);
        session.setAttribute("user", user);
        session.setAttribute("state", 2);
        session.setAttribute("insertstate", 0);
        if (flag){
            session.setAttribute("updatestate", 1);
        }
        else{
            session.setAttribute("updatestate", 2);
        }
        return "Miao/personalpage";
    }

    /**
     * 添加银行卡的控制层
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "/selectcoupon")
    public String selectCoupon(@RequestParam("userid") String userid,HttpServletRequest request, Model model) {
        //当前时间
        Date nowDate = new Date();
        List<Coupon> couponlist = couponService.selectCoupon(userid);
        for (Coupon coupon : couponlist) {
            //开始时间
            Date startDate = coupon.getStartTime();
            //结束时间
            Date endDate = coupon.getEndTime();
            if (nowDate.getTime() <= startDate.getTime()) {
                coupon.setPercent(0);
            } else if (nowDate.getTime() >= endDate.getTime()) {
                coupon.setPercent(100);
            } else {
                //结束时间和开始时间中间的天数
                Double a = (double) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                //当前时间和开始时间中间的天数
                Double b = (double) ((nowDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
                int p = (int) Math.floor(b / a * 100);
                //计算百分比存入
                coupon.setPercent(p);
            }
        }
        User user = userService.selectNameById(userid);
        List<Bankcard> bankcardlist = bankcardService.selectBankcard(userid);
        HttpSession session = request.getSession();
        session.setAttribute("couponlist", couponlist);
        session.setAttribute("bankcardlist", bankcardlist);
        session.setAttribute("user", user);
        session.setAttribute("state", 4);
        session.setAttribute("insertstate", 0);
        session.setAttribute("updatestate", 0);
        return "Miao/personalpage";
    }

    /**
     * 跳转用户签字的控制层
     *
     * @param orderid
     * @return
     */
    @RequestMapping(value = "/canvasUp")
    public String canvasUp(@RequestParam("orderid") String orderid,HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.setAttribute("orderid", orderid);
        return "Miao/canvas";

    }

    /**
     * 用户签字的控制层
     *
     * @param filename
     * @return
     */
    @RequestMapping(value = "/sign" ,method= RequestMethod.POST)
    public String upload(@RequestParam("filett") String filename, @RequestParam("orderId") String orderId, HttpServletRequest request){
//        //将request转换成文件上传的MultipartHttpServletRequest
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        //获取三张传过来的图片（file）
//        List<MultipartFile> files=multipartRequest.getFiles("file");
//        //获取服务器端路径存放到'updata'路径下
//        String path = request.getSession().getServletContext().getRealPath("/conootract");
//        if (files.isEmpty()) {
//            return "false1";
//        }
//        for (MultipartFile file : files) {
//            String fileName = file.getOriginalFilename();
//            int size = (int) file.getSize();
//            System.out.println(fileName + "-->" + size);
//            if (file.isEmpty()) {
//                return "false2";
//            } else {
//                File dest = new File(path + "/" + fileName);
//                System.out.println(dest.getAbsolutePath());
//                if (!dest.getParentFile().exists()) {
//                    // 判断文件父目录是否存在
//                    dest.getParentFile().mkdir();
//                }
//                try {
//                    //文件上传服务器
//                    file.transferTo(dest);
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                    return "Miao/loginError";
//                }
//            }
//        }
//        return "Miao/loginSuccess";

        HttpSession session = request.getSession();
        String str = filename.substring(22);
        System.out.println(str);
        String path = request.getServletContext().getRealPath("/sign");
        File dir = new File(path);
        System.out.println(dir.getAbsolutePath());
        if (!dir.exists()){
            dir.mkdirs();
        }
        boolean flag = GenerateImage(str, path+"/"+orderId+".png");
        if(flag){
            userService.updateOrderState(3,orderId);
            session.setAttribute("orderFinalState",2);
            return "Miao/order";
        }
        else{
            session.setAttribute("orderFinalState",3);
            return "Miao/order";
        }
    }

    /**
     * 车位管理的控制层
     *
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/manageparkingSpace")
    public String selectParkingSpace(@RequestParam("pageNum") String pageNum,HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if(pageNum.equals("") || pageNum == null || Integer.parseInt(pageNum)<1){
            pageNum="1";
        }

        System.out.println("pageNum:"+pageNum);

        List<ParkingSpace> listmain = userService.selectAllSpace();
        List<ParkingSpace> list = userService.selectAllParkSpace(Integer.parseInt(pageNum),4);

        int maxpage = 1;

        if(listmain.size()%4==0){
            maxpage = listmain.size()/4;
        }
        else{
            maxpage = listmain.size()/4+1;
        }
        System.out.println("maxpage:"+maxpage);
        model.addAttribute("parklist", list);
        session.setAttribute("pageSize","4");
        session.setAttribute("pageNum",Integer.parseInt(pageNum));
        session.setAttribute("maxpage",maxpage);
        return "Miao/properties";

    }
    /**
     * 车位详情的控制层
     *
     * @param parkid
     * @return
     */
    @RequestMapping(value = "/parkspace")
    public String selectParkingSpaceById(@RequestParam("parkid") String parkid,HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        ParkingSpace parkspace = parkingSpaceService.selectParkingSpaceById(parkid);
        String developerid=userService.selectResidentialQuartersById(parkspace.getResidentialQuartersId()).getDeveloperId();
        session.setAttribute("parkspace",parkspace);
        session.setAttribute("developerid",developerid);
        return "Miao/parkinginfo";
    }

    /**
     * 获得随机编码
     *
     * @return
     */
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

    /**
      * 解码
      *
      * @param str
      * @return string
     */
    public byte[] decode(String str) {
        return Base64.getDecoder().decode(str);
    }

    public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
        // 返回Base64编码过的字节数组字符串
    }

    /**
     * 图片码转图片
     *
     * @param imgStr
     * @param imgFilePath
     * @return string
     */
    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) {
            // 图像数据为空
            return false;
        }
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decode(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    // 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
