package com.service.impl;

import com.bean.*;
import com.dao.*;
import com.event.DeveloperRegisterAfterEvent;
import com.service.AdministratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdministratorsServiceImpl implements AdministratorsService {
    @Autowired
    private AdministratorsMapper administratorsMapper;
    @Autowired
    private DevelopersMapper developersMapper;
    @Autowired
    private ExamineApproveMapper examineApproveMapper;
    @Autowired
    private DeveloperMapper developerMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminDeveloperBillMapper adminDeveloperBillMapper;
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private UserAdminBillMapper userAdminBillMapper;

    @Override
    public Administrators selectAdministratorsByName(String administratorsName) {
        return administratorsMapper.selectAdministratorsByName(administratorsName);
    }

    @Override
    public boolean updateAdministratorsMoney(double money, String administratorsName) {
        Administrators administrators;
        administrators=administratorsMapper.selectAdministratorsByName(administratorsName);
        double moneys=administrators.getMoney()+money;
        return administratorsMapper.updateAdministratorsMoney(moneys,administratorsName);
    }

    @Override
    public boolean registerAdministrators(String administratorsName, String administratorsPassword) {
        Administrators administrators=new Administrators();
        administrators.setAdministratorsName(administratorsName);
        administrators.setAdministratorsPassword(administratorsPassword);
        long  timeNew =  System.currentTimeMillis()/ 10000000; // 6位数的时间戳
        String OR="AD"+timeNew;
        administrators.setAdministratorsId(OR);
        administrators.setMoney(0);
        return administratorsMapper.insertAdministrators(administrators);

    }

    @Override
    public boolean addDevelopers(String developerId, String developerName) {
        Developers developers =new Developers();
        developers.setState("正常");
        developers.setDeveloperId(developerId);
        developers.setDeveloperName(developerName);
        developers.setMoney(0);
        return developersMapper.insertDevelopers(developers);
    }

    @Override
    public boolean addDeveloper_administrator(String developerId) {
        Developer_administrator developer_administrator=new Developer_administrator();
        developer_administrator.setRole("管理员");
        developer_administrator.setPassword("123");
        developer_administrator.setDeveloperId(developerId);
        //生成ID号,这里和开发商id同样
        developer_administrator.setId(developerId);
        return developerMapper.insertDeveloper_administrator(developer_administrator);
    }

    @Override
    public boolean updateAdministratorsMoneyMinus(double money, String administratorsName) {
        Administrators administrators;
        administrators=administratorsMapper.selectAdministratorsByName(administratorsName);
        double moneys=administrators.getMoney()-money;
        return administratorsMapper.updateAdministratorsMoney(money, administratorsName);
    }

    @Override
    public boolean cancelOrder(String orderId,String administratorsName) {
        //查询订单信息
        Order order=new Order();
        order=orderMapper.selectOrderById(orderId);
        double deposit=order.getDeposit();
        String userName=order.getContractSignatory();
        String pid=order.getParkingSpaceId();
        //修改车位状态
        if(parkingSpaceMapper.updateParkSpaceState(1,pid)){
            System.out.println("车位状态修改成功");
        }
        else {
            System.out.println("车位状态修改失败");
        }

        //查询用户信息
        User user = new User();
        user=userMapper.selectUserByUserId(userName);
        double userMoney=user.getMoney();
        double moneys=userMoney+deposit;
        //查询后台管理员信息
        Administrators administrators = new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(administratorsName);
        double adminMoney=administrators.getMoney()-deposit;
        String adminId=administrators.getAdministratorsId();
        //生成用户后台管理员账单
        UserAdminBill userAdminBill=new UserAdminBill();
        //生成ID号
        long  timeNew1 =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        String UDB="UDB"+timeNew1;
        userAdminBill.setId(UDB);
        userAdminBill.setType("退还定金");
        userAdminBill.setMoney(deposit);
        userAdminBill.setSnederId(userName);
        userAdminBill.setReceiverId(adminId);
        userAdminBill.setOrderId(orderId);
        Date now = new Date();
        userAdminBill.setTime(now);
        if(userAdminBillMapper.insertUserAdminBill(userAdminBill)){
            System.out.println("用户后台管理员账单插入成功");
        }
        if(orderMapper.updateOrderState(5,orderId)&&userMapper.updateUserMoney(moneys,userName)&&administratorsMapper.updateAdministratorsMoney(adminMoney,administratorsName)){
            System.out.println("状态修改成功");
            System.out.println("用户定金退款成功");
            System.out.println("管理员定金扣除成功");
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean timeoutOrder(String orderId, String administratorsName) {
        return false;
    }

    @Override
    public boolean finishOrder(String orderId, String administratorsName) {
        //查询订单信息
        Order order=new Order();
        order=orderMapper.selectOrderById(orderId);
        double deposit=order.getDeposit();
        double finalPrice=order.getFinalPrice();
        String developerName=order.getContractInitiator();
        String userName=order.getContractSignatory();
        String pid=order.getParkingSpaceId();
        //修改车位状态
        if(parkingSpaceMapper.updateParkSpaceState(3,pid)){
            System.out.println("车位状态修改成功");
        }
        else {
            System.out.println("车位状态修改失败");
        }
        //处理后台抽成
        Administrators administrators = new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(administratorsName);
        String adminId=administrators.getAdministratorsId();
        double adminMoney =administrators.getMoney()-deposit*0.95+finalPrice*0.05;
        double developerMoney=deposit*0.95+finalPrice*0.95;
        double dMoney=developersMapper.selectMoney(developerName);
        double summoney=dMoney+developerMoney;
        //给开发商转钱
        if(developersMapper.updateMoney(developerName,summoney)){
            System.out.println(developerMoney);
            System.out.println("给开发商转钱成功");
        }
        //生成后台管理员和开发商账单信息
        Date now = new Date();
        AdminDeveloperBill adminDeveloperBill=new AdminDeveloperBill();
        adminDeveloperBill.setReceiverId(developerName);
        adminDeveloperBill.setSenderId(adminId);
        adminDeveloperBill.setTime(now);
        adminDeveloperBill.setType("完成订单");
        adminDeveloperBill.setOrderId(orderId);
        //生成ID号
        long  timeNew =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        String ADB="ADB"+timeNew;
        adminDeveloperBill.setId(ADB);
        adminDeveloperBill.setMoney(deposit*0.95+finalPrice*0.95);
        //生成用户后台账单
        UserAdminBill userAdminBill=new UserAdminBill();
        //生成ID号
        long  timeNew1 =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        String UDB="UDB"+timeNew1;
        userAdminBill.setId(UDB);
        userAdminBill.setType("提交尾款");
        userAdminBill.setMoney(finalPrice);
        userAdminBill.setSnederId(userName);
        userAdminBill.setReceiverId(adminId);
        userAdminBill.setOrderId(orderId);
        userAdminBill.setTime(now);
        if(userAdminBillMapper.insertUserAdminBill(userAdminBill)){
            System.out.println("用户后台管理员账单插入成功");
        }
        if(orderMapper.updateOrderState(4,orderId)&&administratorsMapper.updateAdministratorsMoney(adminMoney,administratorsName)&&adminDeveloperBillMapper.insertAdminDeveloperBill(adminDeveloperBill)){
            System.out.println("状态修改成功");
            System.out.println("后台抽成成功");
            System.out.println("后台管理员与开发商账单插入成功");
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public List<ExamineApprove> selectExamineApprove(int pageNum, int pageSize, int state) {
        return examineApproveMapper.selectExamineApprove(pageNum,pageSize,state);
    }

    @Override
    public List<ExamineApprove> selectHisExamineApprove(int pageNum, int pageSize, String adminId, int state1, int state2) {
        Administrators administrators=new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(adminId);
        String id=administrators.getAdministratorsId();
        return examineApproveMapper.selectHisExamineApprove(pageNum,pageSize,id,state1,state2);
    }

    @Override
    public boolean unpassfile(int state, String eId,String adminName) {
        Administrators administrators=new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(adminName);
        String id=administrators.getAdministratorsId();
        return examineApproveMapper.updateExamineApproveState(1,eId,id);
    }

    @Override
    public boolean passfile(int state, String eId,String adminName) {
        ExamineApprove examineApprove=new ExamineApprove();
        examineApprove=examineApproveMapper.selectExamineApproveById(eId);
        //获取申请文件中开发商ID，姓名
        String developerId=examineApprove.getDeveloperId();
        String developerName=examineApprove.getDeveloperName();
        //添加开发商
        Developers developers =new Developers();
        developers.setState("正常");
        developers.setDeveloperId(developerId);
        developers.setDeveloperName(developerName);
        developers.setMoney(0);
        //消息机制，发送邮件通知开发商
        System.out.println("注册成功");
        applicationContext.publishEvent(new DeveloperRegisterAfterEvent(developerId));
        //developersMapper.insertDevelopers(developers);
        //添加开发商管理员
        Developer_administrator developer_administrator=new Developer_administrator();
        developer_administrator.setRole("管理员");
        developer_administrator.setPassword("123");
        developer_administrator.setDeveloperId(developerId);
        developer_administrator.setId(developerId);
        //developerMapper.insertDeveloper_administrator(developer_administrator);
        //修改申请文件状态
        //examineApproveMapper.updateExamineApproveState(2,eId);
        Administrators administrators=new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(adminName);
        String id=administrators.getAdministratorsId();
        return (developersMapper.insertDevelopers(developers)&&developerMapper.insertDeveloper_administrator(developer_administrator)&&examineApproveMapper.updateExamineApproveState(2,eId,id));

    }

    @Override
    public List<Developers> selectDevelopers(int pageNum, int pageSize) {
        return developersMapper.selectDevelopers(pageNum,pageSize);
    }

    @Override
    public boolean unseal(String dId) {
        return developersMapper.updateDevelopersState("封号",dId);
    }

    @Override
    public boolean seal(String dId) {
        return developersMapper.updateDevelopersState("正常",dId);
    }

    @Override
    public boolean offline(String dId) {
        return developersMapper.deleteDevelopers(dId);
    }

    @Override
    public void sendMail(String developerid) {
        System.out.println("注册成功");
        //System.out.println(developerid);
        applicationContext.publishEvent(new DeveloperRegisterAfterEvent(developerid));
    }


}
