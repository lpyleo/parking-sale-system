package com.controller;
import com.bean.*;
import com.service.AdministratorsService;
import com.service.OrderService;
import com.service.ParkingSpaceService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/administrators")
public class AdministratorsController {
    @Autowired
    private AdministratorsService administratorsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "adminName") String adminName,@RequestParam(value = "adminPassword") String adminPassword, HttpServletRequest request, Model model){
        Administrators administrators=administratorsService.selectAdministratorsByName(adminName);
        System.out.println(adminName+adminPassword);
        System.out.println(administrators.getAdministratorsName()+administrators.getAdministratorsPassword());
        if(administrators !=null){
            if(administrators.getAdministratorsPassword().equals(adminPassword)){
                System.out.println("登陆成功");
                HttpSession session=request.getSession();
                session.setAttribute("adminName",adminName);
                request.getSession().getServletContext().setAttribute("adminName", adminName);
                model.addAttribute("state","登陆成功");
                return "Da/index";
            }
            else {
                System.out.println("登录失败，用户名或密码错误！");
                return "Da/login";
            }
        }
        else {
            System.out.println("用户不存在");
            return "Da/login";
        }
    }
    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String Register(@RequestParam(value = "adminName") String adminName,@RequestParam(value = "adminPassword") String adminPassword){
        if(administratorsService.registerAdministrators(adminName,adminPassword)){
            System.out.println("注册成功");
            return "Da/RegisterSuccess";
        }
        else {
            System.out.println("注册失败");
            return "Da/login";
        }
    }
    //生成订单
    @RequestMapping(value = "/GenerateOrder")
    public String GenerateOrder(@RequestParam(value = "parkingSpaceId") String parkingSpaceId,@RequestParam(value = "contractSignatory") String contractSignatory,@RequestParam(value = "contractInitiator") String contractInitiator,HttpServletRequest request){
        HttpSession session = request.getSession();

        String adminName= (String)request.getSession().getServletContext().getAttribute("adminName");

        System.out.println(adminName);
        User user = userService.selectNameById(contractSignatory);
        Double usermoney = user.getMoney();
        double money;
        ParkingSpace parkingSpace;
        parkingSpace = parkingSpaceService.selectParkingSpaceById(parkingSpaceId);
        money=parkingSpace.getPrice()*0.3;
        if(usermoney<money){
            //余额不足
            session.setAttribute("orderstate",1);
            return "Miao/parkinginfo";
        }
        else{
            usermoney = usermoney-money;
            System.out.println(usermoney);
            userService.updateUserMoney(usermoney,user.getUserIdentity());
        }
        if(orderService.insertOrder(parkingSpaceId,contractSignatory,contractInitiator,adminName)){
            System.out.println("生成订单成功");
            System.out.println("用户管理员账单生成成功");
//            return "Miao/properties";
        }
        else {
            System.out.println("订单生成失败");
//            return "Miao/properties";
        }
        if(parkingSpaceService.updateParkSpaceState(2,parkingSpaceId)){
            System.out.println("车位状态修改成功");
        }

        if(administratorsService.updateAdministratorsMoney(money,adminName)){
            session.setAttribute("orderstate",2);
            System.out.println("定金入账成功");
            return "Miao/parkinginfo";
        }
        else {
            session.setAttribute("orderstate",3);
            System.out.println("定金入账失败");
            return "Miao/parkinginfo";
        }

    }
    //取消订单
    @RequestMapping(value = "/CancelOrder",method = RequestMethod.GET)
    public String CancelOrder(@RequestParam(value = "OrderId") String orderId,HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println("OrderId:"+orderId);
        String adminName= (String)request.getSession().getServletContext().getAttribute("adminName");
        if(administratorsService.cancelOrder(orderId,adminName)){
            System.out.println("订单取消成功");
            session.setAttribute("orderFinalState",2);
            return "Miao/order";
        }
        else {
            System.out.println("订单取消失败");
            session.setAttribute("orderFinalState",3);
            return "Miao/order";
        }

    }
    //完成订单
    @RequestMapping(value = "/FinishOrder")
    public String FinishOrder(@RequestParam(value = "OrderId") String orderId,@RequestParam(value = "userId") String userId,HttpServletRequest request){
        HttpSession session = request.getSession();
        String adminName= (String)request.getSession().getServletContext().getAttribute("adminName");
        User user = userService.selectNameById(userId);
        Double usermoney = user.getMoney();
        Order order=orderService.selectOrderById(orderId);
        double finalPrice=order.getFinalPrice();
        if(usermoney<finalPrice){
            //余额不足
            session.setAttribute("orderFinalState",1);
            return "Miao/order";
        }
        else{
            usermoney = usermoney-finalPrice;
            userService.updateUserMoney(usermoney,user.getUserIdentity());
        }
        if(administratorsService.finishOrder(orderId,adminName)){
            System.out.println("订单完成");
            session.setAttribute("orderFinalState",2);
            return "Miao/order";
        }
        else {
            System.out.println("订单完成失败");
            session.setAttribute("orderFinalState",3);
            return "Miao/order";
        }
    }
    //查看已审批文件
    @RequestMapping(value = "/readfile",method = RequestMethod.POST)
    public String readfile(@RequestParam("pageSize") String pageSize ,@RequestParam("pageNum") String pageNum,HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String adminName=(String) session.getAttribute("adminName");
        if(pageNum.equals("") || pageNum == null || Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        if(pageSize.equals("") || pageSize == null){
            pageSize="5";
        }
        System.out.println("adminName:"+adminName);
        System.out.println("pageSize:"+pageSize);
        System.out.println("pageNum:"+pageNum);
        //List<ExamineApprove> list=administratorsService.selectExamineApprove(Integer.parseInt(pageNum),Integer.parseInt(pageSize),adminName,2);
        List<ExamineApprove> list=administratorsService.selectHisExamineApprove(Integer.parseInt(pageNum),Integer.parseInt(pageSize),adminName,1,2);
        session.setAttribute("examineApprovelist", list);
        session.setAttribute("pageSize",pageSize);
        session.setAttribute("pageNum",pageNum);
        return "/Da/approvalFileList";
    }
    //审批未完成申请文件
    @RequestMapping(value = "/unreadfile",method = RequestMethod.POST)
    public String unreadfile(@RequestParam("pageSize") String pageSize ,@RequestParam("pageNum") String pageNum,HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String adminName=(String) session.getAttribute("adminName");
        if(pageNum.equals("") || pageNum == null || Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        if(pageSize.equals("") || pageSize == null){
            pageSize="5";
        }
        System.out.println("adminName:"+adminName);
        System.out.println("pageSize:"+pageSize);
        System.out.println("pageNum:"+pageNum);
        List<ExamineApprove> list=administratorsService.selectExamineApprove(Integer.parseInt(pageNum),Integer.parseInt(pageSize),3);
        session.setAttribute("examineApprovelist", list);
        session.setAttribute("pageSize",pageSize);
        session.setAttribute("pageNum",pageNum);
        return "/Da/unapprovalFileList";
    }
    //通过申请文件
    @RequestMapping(value = "/passfile",method = RequestMethod.POST)
    public String passfile(@RequestParam("eid") String eid,HttpServletRequest request){
        System.out.println(eid);
        HttpSession session = request.getSession();
        String adminName=(String) session.getAttribute("adminName");
        try{
            if(administratorsService.passfile(2,eid,adminName)){
                String message="通过成功";
                session.setAttribute("message",message);
                return "/Da/unapprovalFileList";
            }
        }
        catch (Exception e){
            session.setAttribute("message", "处理失败！");
            return "/Da/unapprovalFileList";
        }
        session.setAttribute("message", "处理失败！");
        return "/Da/unapprovalFileList";

    }
    //不通过申请文件
    @RequestMapping(value = "/unpassfile",method = RequestMethod.POST)
    public String unpassfile(@RequestParam("eid") String eid,HttpServletRequest request){
        System.out.println(eid);
        HttpSession session = request.getSession();
        String adminName=(String) session.getAttribute("adminName");
        administratorsService.unpassfile(1,eid,adminName);
        return "/Da/unapprovalFileList";
    }
    //查询开发商信息
    @RequestMapping(value = "developerinfo",method = RequestMethod.POST)
    public String developerinfo(@RequestParam("pageSize") String pageSize ,@RequestParam("pageNum") String pageNum,HttpServletRequest request){
        HttpSession session = request.getSession();
        if(pageNum.equals("") || pageNum == null || Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        if(pageSize.equals("") || pageSize == null){
            pageSize="5";
        }
        System.out.println("pageSize:"+pageSize);
        System.out.println("pageNum:"+pageNum);
        List<Developers> list=administratorsService.selectDevelopers(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
        session.setAttribute("developerlist", list);
        session.setAttribute("pageSize",pageSize);
        session.setAttribute("pageNum",pageNum);
        return "/Da/developerlist";
    }
    //封号处理
    @RequestMapping(value = "/unseal",method = RequestMethod.POST)
    public String unseal(@RequestParam("did") String did){
        System.out.println(did);
        administratorsService.unseal(did);
        return "/Da/developerlist";
    }
    //解封处理
    @RequestMapping(value = "/seal",method = RequestMethod.POST)
    public String seal(@RequestParam("did") String did){
        System.out.println(did);
        administratorsService.seal(did);
        return "/Da/developerlist";
    }
    //开发商下线处理
    @RequestMapping(value = "/offline",method = RequestMethod.POST)
    public String offline(@RequestParam("did") String did){
        System.out.println(did);
        administratorsService.offline(did);
        return "/Da/developerlist";
    }
    //显示管理员信息
    @RequestMapping(value = "/admininfo",method = RequestMethod.POST)
    public String admininfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        String adminName=(String) session.getAttribute("adminName");
        System.out.println(adminName);
        Administrators administrators=new Administrators();
        administrators=administratorsService.selectAdministratorsByName(adminName);
        session.setAttribute("administrators",administrators);
        return "/Da/admininfo";
    }
    //发送邮件
    @RequestMapping(value = "/sendmail", method = RequestMethod.GET)
    public void sendmail(){
        administratorsService.sendMail("1051549920@qq.com");
    }








}
