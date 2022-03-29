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
public class DaoTest {

    //private UserMapper userMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeveloperMapper developerMapper;
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ExamineApproveMapper examineApproveMapper;
    @Autowired
    private DevelopersMapper developersMapper;
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ResidentialQuartersMapper residentialQuartersMapper;
    /**
     * 1、登录时通过用户名来确认用户名是否存在
     * <p>
     * 提示：如果username是中文，则查询为null
     * 解决方法：在jdbc.url后面添加  useUnicode=true&characterEncoding=utf-8  即可解决
     */

//    @Test
//    public void selectUserByUserName() {
//        System.out.println("dao测试开始。。。。");
//        System.out.println(userMapper.selectUserByUserName("123"));
//        System.out.println("dao测试结束。。。。");
//    }
    @Test
    public void selectdeveloper() {
        System.out.println("dao测试开始。。。。");
        System.out.println(developerMapper.login("zjut", "123"));
        System.out.println("dao测试结束。。。。");
    }
    @Test
    public void insertParkSpace() {
        System.out.println("dao测试开始。。。。");
        ParkingSpace parkingSpace=new ParkingSpace();
        parkingSpace.setId("0004");
        parkingSpace.setAddress("123");
        parkingSpace.setPrice(123);
        System.out.println(parkingSpaceMapper.insertParkSpace(parkingSpace));
        System.out.println("dao测试结束。。。。");
    }
    @Test
    public void selectOrder() {
        System.out.println("dao测试开始。。。。");
        List<Order> list=orderMapper.selectOrder(1,2,"","zjut");
        System.out.println(list.get(0).getOrderId());
        System.out.println(list.get(1).getOrderId());
        System.out.println("dao测试结束。。。。");
    }
    @Test
    public void updateOrder() {
        System.out.println("dao测试开始。。。。");
        Date now = new Date();
        Order order =new Order();
        order.setOrderId("111");
        order.setContractInitiator("小强");
        order.setContractContent("content_image");
        order.setFinalPrice(10000);
        order.setState(2);
        order.setFinalPaymentTime(now);
        System.out.println(orderMapper.updateOrder(order));
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void insertExamine() {
        System.out.println("dao测试开始。。。。");
        ExamineApprove examineApprove=new ExamineApprove();
        examineApprove.setId("2");
        examineApprove.setDeveloperId("123@123");
        examineApprove.setDeveloperName("英雄联盟");
        examineApprove.setFile("zzz");
        examineApprove.setState(0);
        examineApproveMapper.insertExamineApprove(examineApprove);
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectAllOrder() {
        System.out.println("dao测试开始。。。。");
        List<Order> list= orderMapper.selectAllOrderByDid("zjut");
        System.out.println(list.get(1).getOrderId()
        );
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectMoney() {
        System.out.println("dao测试开始。。。。");
        Double money =new Double(0);
        money =  developersMapper.selectMoney("zjut");
        System.out.println(money);
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectCount() {
        System.out.println("dao测试开始。。。。");
        int count = parkingSpaceMapper.countParkSpace("zjut");
        System.out.println(count);
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectStatisticOrder() {
        System.out.println("dao测试开始。。。。");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        System.out.println(dateFormat.format(date));
        List<OrderStatistic> list = orderMapper.selectStatisticOrder("zjut",1);
        System.out.println(list.get(0).getDate());
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectParkingSpace() {
        System.out.println("dao测试开始。。。。");
        parkingSpaceMapper.selectParkSpace(1,5,"","zjut");
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void addActivity() {
        System.out.println("dao测试开始。。。。");
        Activity activity = new Activity();
        activity.setActivityId("002");
        activity.setActivityName("开业盛典");
        activity.setActivityDeveloperId("zjut");
        activity.setActivityContent(300);
        activity.setActivityDiscount(0.8);
        activityMapper.addActivity(activity);
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void deleteActivity() {
        System.out.println("dao测试开始。。。。");
        activityMapper.deleteActivity("001");
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectActivity() {
        System.out.println("dao测试开始。。。。");
        List<Activity> list = activityMapper.selectActivity(1,5,"","zjut");
        System.out.println(list.get(0).getActivityContent());
        System.out.println(list.get(1).getActivityId());
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectState() {
        System.out.println("dao测试开始。。。。");
        String state = developersMapper.selectState("zjut");
        System.out.println(state);
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectResidentialQuarters() {
        System.out.println("dao测试开始。。。。");
        ResidentialQuarters residentialQuarters = new ResidentialQuarters();
        residentialQuarters.setId("1");
        residentialQuarters.setResidentialQuartersName("夏树山庄");
        residentialQuarters.setState("运营");
        residentialQuarters.setDeveloperId("zjut");
        System.out.println(residentialQuartersMapper.insertResidentialQuarters(residentialQuarters));
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectRole() {
        System.out.println("dao测试开始。。。。");
        System.out.println(developerMapper.select_roleInfo("zjut"));
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void modify_password() {
        System.out.println("dao测试开始。。。。");
        System.out.println(developerMapper.modify_password("1234","1234"));
        System.out.println("dao测试结束。。。。");
    }
}