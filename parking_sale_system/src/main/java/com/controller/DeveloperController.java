package com.controller;

import com.bean.*;
import com.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, Model model) {
        Developer_administrator developer_administrator= developerService.login(username, password);
        if (developer_administrator!=null) {
            System.out.println("登录成功");
            HttpSession session = request.getSession();
            session.setAttribute("did", developer_administrator.getDeveloperId());
            session.setAttribute("uid",developer_administrator.getId());
            model.addAttribute("message", "登录成功");
            return "Qiang/index";

        }
        else {
            System.out.println("用户名或密码错误,或被封号");
            HttpSession session = request.getSession();
            session.setAttribute("message", "用户名或密码错误,或被封号！");
//            model.addAttribute("message", "用户名或密码错误！");
            return "Qiang/login";
        }

    }

//    开发商添加车位
    @RequestMapping(value = "/addpark_pace", method = RequestMethod.POST)
    public String addpark_pace(@RequestParam("residential_quarters_id") String residential_quarters_id, @RequestParam("address") String address,
                        @RequestParam("price") String price, @RequestParam("photo") MultipartFile photo, HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String did = (String)session.getAttribute("did");
        if(did==null || did.equals("")){
            session.setAttribute("message", "非法添加！");
            return "Qiang/residential";
        }
        String path = request.getServletContext().getRealPath("/img");
//        自动获取车位的id号
        long  timeNew =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        String PS="PS"+timeNew;

        System.out.println(residential_quarters_id);
        System.out.println(address);
        System.out.println(photo.getName());
        if (!photo.isEmpty()) {
            try {
                // 文件存放服务端的位置
                File dir = new File(path);
                System.out.println(dir.getAbsolutePath());
                if (!dir.exists()){
                    dir.mkdirs();
                }
                File serverFile = new File(dir.getAbsolutePath() + File.separator +PS+".jpg");
                photo.transferTo(serverFile);
                if(developerService.insertParkSpace(residential_quarters_id,address,price,PS)){
                    session.setAttribute("message", "上架成功！");
                    return "Qiang/addparklist";
                }
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
                session.setAttribute("message", "添加失败！");
                return "Qiang/addparklist";
            }
        }
        session.setAttribute("message", "添加失败！");
        return "Qiang/addparklist";
    }

    //查询订单界面
    @RequestMapping(value = "/now_orderlist", method = RequestMethod.POST)
    public String now_orderlist(@RequestParam("search") String search ,@RequestParam("pageSize") String pageSize ,@RequestParam("pageNum") String pageNum,HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if(pageNum.equals("") || pageNum == null || Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        if(pageSize.equals("") || pageSize == null){
            pageSize="5";
        }
        String did = (String)session.getAttribute("did");
        if(did==null || did.equals(""))
            did="zjut";
        System.out.println("did:"+did);
        System.out.println("search:"+search);
        System.out.println("pageSize:"+pageSize);
        System.out.println("pageNum:"+pageNum);

        List<Order> list = developerService.selectOrder(Integer.parseInt(pageNum),Integer.parseInt(pageSize),search,did);
        session.setAttribute("orderlist", list);
        session.setAttribute("pageSize",pageSize);
        session.setAttribute("pageNum",pageNum);
        return "Qiang/orderlist";

    }

    //处理订单界面
    @RequestMapping(value = "/modify_orderlist", method = RequestMethod.POST)
    public String modify_orderlist(@RequestParam("orderId") String orderId,
                               @RequestParam("contractInitiator") String contractInitiator,
                               @RequestParam("parkingSpaceId") String parkingSpaceId,
                               @RequestParam("contractContent") MultipartFile contractContent,
                               @RequestParam("finalPrice") String finalPrice , @RequestParam("finalPaymentTime")String finalPaymentTime,
                               HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String path = request.getServletContext().getRealPath("/contract");
        String did = (String)session.getAttribute("did");
        System.out.println(orderId);
        System.out.println(contractInitiator);
        System.out.println(contractContent.getOriginalFilename());
        System.out.println(finalPrice);
        System.out.println(finalPaymentTime);
        if (!contractContent.isEmpty()) {
            try {
                // 文件存放服务端的位置
                File dir = new File(path);
                System.out.println(dir.getAbsolutePath());
                if (!dir.exists()){
                    dir.mkdirs();
                }
                File serverFile = new File(dir.getAbsolutePath() + File.separator + orderId+".jpg");
                contractContent.transferTo(serverFile);
                if(developerService.updateOrder(orderId,contractInitiator,orderId,finalPrice,finalPaymentTime,did,parkingSpaceId)){
                    session.setAttribute("message", "处理成功！");
                    return "Qiang/orderlist";
                }
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
                session.setAttribute("message", "处理失败！没有相应的权限！");
                return "Qiang/orderlist";
            }
        }
        session.setAttribute("message", "处理失败！");
        return "Qiang/orderlist";
    }


    //提交申请
    @RequestMapping(value = "/examine", method = RequestMethod.POST)
    public String add_examine(@RequestParam("developer_id") String developer_id, @RequestParam("developer_name") String developer_name,
                               @RequestParam("file") MultipartFile file,
                               HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String path = request.getServletContext().getRealPath("/file");
        System.out.println(developer_id);
        System.out.println(developer_name);
        System.out.println(file.getOriginalFilename());
        //        自动获取申请的id号
        long  timeNew =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        String EAA="EAA"+timeNew;
        if (!file.isEmpty()) {
            try {
                // 文件存放服务端的位置
                File dir = new File(path);
                System.out.println(dir.getAbsolutePath());
                if (!dir.exists()){
                    dir.mkdirs();
                }
                File serverFile = new File(dir.getAbsolutePath() + File.separator + EAA+".jpg");
                file.transferTo(serverFile);
                if(developerService.insertExamineApprove(EAA,developer_id,developer_name)){
                    session.setAttribute("message", "申请成功！");
                    return "Qiang/login";
                }
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
                session.setAttribute("message", "处理失败！");
                return "Qiang/login";
            }
        }
        session.setAttribute("message", "处理失败！");
        return "Qiang/login";
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public String get_statistic(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String did = (String)session.getAttribute("did");
        if(did==null || did.equals("")){
            session.setAttribute("message", "非法查看！");
            return "Qiang/index";
        }
        List<Integer> data = developerService.selectStatics(did);
        List<OrderStatistic> data1 = developerService.selectStatistic1(did,1);
        List<OrderStatistic> data2 = developerService.selectStatistic1(did,2);
        List<OrderStatistic> data3 = developerService.selectStatistic1(did,3);
        List<OrderStatistic> data4 = developerService.selectStatistic1(did,4);
        List<OrderStatistic> data5 = developerService.selectStatistic1(did,5);
        model.addAttribute("parking_space", data.get(0));
        model.addAttribute("money", data.get(1));
        model.addAttribute("order_wait", data.get(2));
        model.addAttribute("order_ing", data.get(3));
        model.addAttribute("order_finish", data.get(4));
        model.addAttribute("order_stop", data.get(5));
        model.addAttribute("data1",data1);
        model.addAttribute("data2",data2);
        model.addAttribute("data3",data3);
        model.addAttribute("data4",data4);
        model.addAttribute("data5",data5);
        return "Qiang/index";
    }

//    管理车位
    @RequestMapping(value = "/manage_parkingSpace", method = RequestMethod.POST)
    public String manage_parkingSpace(@RequestParam("search") String search ,@RequestParam("pageSize") String pageSize ,@RequestParam("pageNum") String pageNum,HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if(pageNum.equals("") || pageNum == null || Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        if(pageSize.equals("") || pageSize == null){
            pageSize="5";
        }
        String did = (String)session.getAttribute("did");
        if(did==null || did.equals(""))
            did="zjut";
        System.out.println("did:"+did);
        System.out.println("search:"+search);
        System.out.println("pageSize:"+pageSize);
        System.out.println("pageNum:"+pageNum);

        List<ParkingSpace> list = developerService.selectParkingSpace(Integer.parseInt(pageNum),Integer.parseInt(pageSize),search,did);
        model.addAttribute("parklist", list);
        session.setAttribute("pageSize",pageSize);
        session.setAttribute("pageNum",pageNum);
        return "Qiang/parklist";

    }

//    管理活动
    @RequestMapping(value = "/select_Activity", method = RequestMethod.POST)
    public String selectActivity(@RequestParam("search") String search ,@RequestParam("pageSize") String pageSize ,@RequestParam("pageNum") String pageNum,HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if(pageNum.equals("") || pageNum == null || Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        if(pageSize.equals("") || pageSize == null){
            pageSize="5";
        }
        String did = (String)session.getAttribute("did");
        if(did==null || did.equals(""))
            did="zjut";
        System.out.println("did:"+did);
        System.out.println("search:"+search);
        System.out.println("pageSize:"+pageSize);
        System.out.println("pageNum:"+pageNum);
        List<Activity> list = developerService.selectActivity(Integer.parseInt(pageNum),Integer.parseInt(pageSize),search,did);
        model.addAttribute("activity_list", list);
        session.setAttribute("pageSize",pageSize);
        session.setAttribute("pageNum",pageNum);
        return "Qiang/activitylist";
    }

//    添加活动
    @RequestMapping(value = "/add_Activity", method = RequestMethod.POST)
    public String add_Activity(@RequestParam("activity_name") String activity_name,
                               @RequestParam("activity_category") String activity_category,
                               @RequestParam("activity_residential_quarters_id") String activity_residential_quarters_id,
                               @RequestParam("activity_discount") String activity_discount,
                               @RequestParam("activity_content") String activity_content,HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String did = (String)session.getAttribute("did");
        if(did==null || did.equals("")){
            session.setAttribute("message", "非法添加！");
            return "Qiang/residential";
        }
        if(activity_content==null || activity_content.equals("")){
            activity_content="0";
        }
        if(developerService.addActivity(activity_name,Integer.parseInt(activity_content),activity_category,Double.parseDouble(activity_discount),did,activity_residential_quarters_id)){
            session.setAttribute("message", "添加成功！");
            return "Qiang/activitylist";
        }
        session.setAttribute("message", "添加失败！");
        return "Qiang/activitylist";
    }

//    删除活动
    @RequestMapping(value = "/delete_Activity", method = RequestMethod.GET)
    public String delete_Activity(@RequestParam("activity_id") String activity_id,HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        if(developerService.deleteActivity(activity_id)){
            session.setAttribute("message", "删除成功！");
            return "Qiang/activitylist";
        }
        session.setAttribute("message", "删除失败！");
        return "Qiang/activitylist";
    }

//    删除小区
    @RequestMapping(value = "/update_ResidentialQuarters", method = RequestMethod.GET)
    public String delete_ResidentialQuarters(@RequestParam("residential_quarters_id") String residential_quarters_id,
                                             @RequestParam("state") String state,
                                             HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        if(developerService.updateResidentialQuarters_del(residential_quarters_id,state)){
            session.setAttribute("message", "更改成功！");
            return "Qiang/residential";
        }
        session.setAttribute("message", "更改失败！");
        return "Qiang/residential";
    }



//    添加小区
    @RequestMapping(value = "/add_ResidentialQuarters", method = RequestMethod.POST)
    public String add_ResidentialQuarters(@RequestParam("residential_quarters_name") String residential_quarters_name,
                                          @RequestParam("residential_quarters_state") String residential_quarters_state,
                               HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String did = (String)session.getAttribute("did");
        if(did==null || did.equals("")){
            session.setAttribute("message", "非法添加！");
            return "Qiang/residential";
        }
        if(developerService.addResidentialQuarters(did,residential_quarters_name,residential_quarters_state)){
            session.setAttribute("message", "添加成功！");
            return "Qiang/residential";
        }
        session.setAttribute("message", "添加失败！");
        return "Qiang/residential";
    }

//    查询小区
    @RequestMapping(value = "/select_ResidentialQuarters", method = RequestMethod.POST)
    public String select_ResidentialQuarters(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String did = (String)session.getAttribute("did");
        if(did==null || did.equals(""))
            did="zjut";
        System.out.println("did:"+did);
        List<ResidentialQuarters> list = developerService.selectAllResidentialQuarters(did);
        model.addAttribute("ResidentialQuarters_list", list);
        session.setAttribute("pageSize",10);
        session.setAttribute("pageNum",1);
        return "Qiang/residential";
    }


    //    查询开发商信息
    @RequestMapping(value = "/select_developerInfo", method = RequestMethod.GET)
    public String select_developerInfo(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String uid = (String)session.getAttribute("uid");
        String did = (String)session.getAttribute("did");
        if(uid==null || uid.equals("")){
            session.setAttribute("message", "非法查看！");
            return "Qiang/info";
        }
        Developers developerInfo1 = developerService.selectDeveloperInfo1(did);
        Developer_administrator developerInfo2 = developerService.selectDeveloperInfo2(uid);
        model.addAttribute("developerInfo1", developerInfo1);
        model.addAttribute("developerInfo2", developerInfo2);
        return "Qiang/info";
    }

    //    修改密码
    @RequestMapping(value = "/modify_pwd", method = RequestMethod.POST)
    public String modify_pwd(@RequestParam("old_pwd") String old_pwd,
                             @RequestParam("new_pwd1") String new_pwd1,
                             @RequestParam("new_pwd2") String new_pwd2,
                             HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String uid = (String)session.getAttribute("uid");
        if(uid==null || uid.equals("")){
            session.setAttribute("message", "非法修改！");
            return "Qiang/info";
        }
        if(developerService.modifyPassword(uid,old_pwd,new_pwd1,new_pwd2)){
            session.setAttribute("message", "修改成功！");
            return "Qiang/info";
        }
        else{
            session.setAttribute("message", "原密码错误或两次输入不一致！");
            return "Qiang/info";

        }
    }
}
