package dao;

import com.bean.*;
import com.dao.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 记住@Test前往不要忘写
 * @RunWith就是一个运行器
 * SpringJUnit4ClassRunner.class 就是指用SpringJUnit4ClassRunner来运行，让测试运行于spring测试环境
 *@ContextConfiguration Spring整合JUnit4测试时，使用注解引入多个配置文件
 *
 * @author sushuai
 * @date 2019/03/03/22:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class DATEST_DAO {

    //private UserMapper userMapper;
    @Autowired
    private AdministratorsMapper administratorsMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private DevelopersMapper developersMapper;
    @Autowired
    private ExamineApproveMapper examineApproveMapper;
    @Autowired
    private DeveloperMapper developerMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminDeveloperBillMapper adminDeveloperBillMapper;

    @Test
    public void selectAdministratorsByName(){
        System.out.println("dao测试开始。。。。");
        Administrators administrators=administratorsMapper.selectAdministratorsByName("lihua");
        System.out.println(administrators.getAdministratorsName()+administrators.getAdministratorsPassword());
    }
    @Test
    public void updateAdministratorsMoney(){
        System.out.println("dao测试开始。。。。");
        Administrators administrators=administratorsMapper.selectAdministratorsByName("lihua");
        double moneys=administrators.getMoney()+1000;
        System.out.println(moneys);
        if(administratorsMapper.updateAdministratorsMoney(moneys,"lihua")){
            System.out.println("修改成功");
        }
    }
    @Test
    public void insertOrder(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        String hehe = dateFormat.format(now);
        System.out.println(hehe);
        System.out.println("dao测试开始。。。。");
        Order order=new Order();
        order.setOrderId("001");
        order.setParkingSpaceId("001");
        order.setContractSignatory("001");
        order.setContractInitiator("001");
        order.setContractContent("001");
        order.setOrderTime(now);
        order.setPaymentMethod("001");
        order.setDeposit(20);
        order.setFinalPrice(50);
        order.setPurchaseMethod("001");
        order.setState(1);
        Date now1 =new Date();
        String hoho =dateFormat.format(now1);
        System.out.println(hoho);
        order.setFinalPaymentTime(now1);
        if(orderMapper.insertOrder(order)){
            System.out.println("插入成功");
        }
    }
    @Test
    public void selectParkingSpaceById(){
        System.out.println("dao测试开始。。。。");
        ParkingSpace parkingSpace =parkingSpaceMapper.selectParkingSpaceById("001");
        System.out.println(parkingSpace.getAddress());
    }
    @Test
    public void insertAdministrators(){
        System.out.println("dao测试开始。。。。");
        Administrators administrators=new Administrators();
        administrators.setAdministratorsId("003");
        administrators.setAdministratorsName("nihao");
        administrators.setAdministratorsPassword("123456");
        administrators.setMoney(0);
        if(administratorsMapper.insertAdministrators(administrators)){
            System.out.println("插入成功");
        }
        else {
            System.out.println("插入失败");
        }
    }
    @Test
    public void insertDevelopers(){
        System.out.println("dao测试开始。。。。");
        Developers developers =new Developers();
        developers.setDeveloperId("001");
        developers.setDeveloperName("恒大");
        developers.setMoney(0);
        developers.setState("正常");
        if(developersMapper.insertDevelopers(developers)){
            System.out.println("插入成功");
        }
    }
    @Test
    public void insertDeveloper_administrator(){
        System.out.println("dao测试开始。。。。");
        Developer_administrator developer_administrator=new Developer_administrator();
        developer_administrator.setDeveloperId("001");
        developer_administrator.setId("001");
        developer_administrator.setPassword("123");
        developer_administrator.setRole("总管");
        if(developerMapper.insertDeveloper_administrator(developer_administrator)){
            System.out.println("插入成功");
        }
    }
    @Test
    public void insertExamineApprove(){
        System.out.println("dao测试开始。。。。");
        ExamineApprove examineApprove=new ExamineApprove();
        examineApprove.setAdId("1");
        examineApprove.setFile("***");
        examineApprove.setId("001");
        examineApprove.setState(1);
        examineApprove.setDeveloperName("恒大");
        examineApprove.setDeveloperId("001");
        if(examineApproveMapper.insertExamineApprove(examineApprove)){
            System.out.println("插入成功");
        }

    }
    //修改订单状态
    @Test
    public void updateOrderState(){
        System.out.println("dao测试开始。。。。");
        if(orderMapper.updateOrderState(4,"001")){
            System.out.println("状态修改成功");
        }

    }
    @Test
    public void updateUserMoney(){
        System.out.println("dao测试开始。。。。");
        if(userMapper.updateUserMoney(20,"011")){
            System.out.println("钱修改成功");
        }
    }
    //插入账单
    @Test
    public void insertAdminDeveloperBill(){
        System.out.println("dao测试开始。。。。");
        AdminDeveloperBill adminDeveloperBill=new AdminDeveloperBill();
        adminDeveloperBill.setId("001");
        adminDeveloperBill.setMoney(20);
        adminDeveloperBill.setType("未知");
        adminDeveloperBill.setSenderId("001");
        adminDeveloperBill.setReceiverId("001");
        adminDeveloperBill.setOrderId("001");
        Date now = new Date();
        adminDeveloperBill.setTime(now);
        if(adminDeveloperBillMapper.insertAdminDeveloperBill(adminDeveloperBill)){
            System.out.println("插入成功");
        }
    }
    //查询申请
    @Test
    public void selectExamineApprove(){
        System.out.println("dao测试开始。。。。");
        List<ExamineApprove> list=examineApproveMapper.selectExamineApprove(2,2,3);
        System.out.println(list.get(0).getDeveloperName());
        System.out.println(list.get(1).getDeveloperName());
        System.out.println("dao测试结束。。。。");

    }
    //查询历史申请
    @Test
    public void selectHisExamineApprove(){
        System.out.println("dao测试开始。。。。");
        List<ExamineApprove> list=examineApproveMapper.selectHisExamineApprove(2,2,"001",1,2);
        System.out.println(list.get(0).getDeveloperName());
        System.out.println(list.get(1).getDeveloperName());
        System.out.println("dao测试结束。。。。");

    }
    //修改车位状态
    @Test
    public void updateParkSpaceState(){
        System.out.println("dao测试开始。。。。");
        if(parkingSpaceMapper.updateParkSpaceState(2,"001")){
            System.out.println("修改成功");
        }
        else {
            System.out.println("修改失败");
        }
    }
    //修改申请状态
    @Test
    public void updateExamineApproveState(){
        System.out.println("dao测试开始。。。。");
        if(examineApproveMapper.updateExamineApproveState(1,"001","001")){
            System.out.println("修改成功");
        }
        else{
            System.out.println("修改失败");
        }
    }
    //查询申请文件one
    @Test
    public void selectExamineApproveById(){
        System.out.println("dao测试开始。。。。");
        ExamineApprove examineApprove=new ExamineApprove();
        examineApprove=examineApproveMapper.selectExamineApproveById("001");
        System.out.println(examineApprove.getDeveloperName());
    }
    //修改开发商状态
    @Test
    public void updateDevelopersState(){
        System.out.println("dao测试开始。。。。");
        developersMapper.updateDevelopersState("封号","001");

    }
    //查询开发商
    @Test
    public void selectDevelopers(){
        System.out.println("dao测试开始。。。。");
        List<Developers> list=developersMapper.selectDevelopers(1,2);
        System.out.println(list.get(0).getDeveloperName());
        System.out.println(list.get(1).getDeveloperName());
        System.out.println("dao测试结束。。。。");
    }
    //开发商下线
    @Test
    public void deleteDevelopers(){
        System.out.println("dao测试开始。。。。");
        developersMapper.deleteDevelopers("014");
        System.out.println("dao测试结束。。。。");
    }
    //给开发商充钱
    @Test
    public void updateMoney(){
        System.out.println("dao测试开始。。。。");
        developersMapper.updateMoney("1015678266@qq.com",200);
    }


}