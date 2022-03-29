package service;

import com.bean.*;
import com.service.DeveloperService;
import com.service.ParkingSpaceService;
import com.service.UserService;
import dao.DaoTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @RunWith就是一个运行器
 * SpringJUnit4ClassRunner.class 就是指用SpringJUnit4ClassRunner来运行，让测试运行于spring测试环境
 *@ContextConfiguration Spring整合JUnit4测试时，使用注解引入多个配置文件
 *
 * @author sushuai
 * @date 2019/03/03/22:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class ServiceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @Test
    public void loginDeveloper(){
        System.out.println("service测试开始。。。");
        System.out.println( developerService.login("zjut","123"));
    }
    @Test
    public void insertParkSpace(){
        System.out.println("service测试开始。。。");
        boolean b=developerService.insertParkSpace("001","1234","1234","n123");
        System.out.println(b);
        System.out.println("测试结束");
    }
    @Test
    public void selectOrder(){
        System.out.println("service测试开始。。。");
        List<Order> list = developerService.selectOrder(1,10,"","zjut");
        System.out.println(list.get(0).getOrderId());
        System.out.println("测试结束");
    }
    @Test
    public void updateOrder() throws ParseException {
        System.out.println("service测试开始。。。");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        Date date =new Date();
        System.out.println(developerService.updateOrder("123","小强","HT21312","123456", dateFormat.format(date),"zjut","001"));
        System.out.println("测试结束");
    }
    @Test
    public void insertExamineApprove(){
        System.out.println("service测试开始。。。");
        developerService.insertExamineApprove("EAA1234","zcq@zcq","牛逼集团");
        System.out.println("测试结束");
    }
    @Test
    public void statistic(){
        System.out.println("service测试开始。。。");
        List list = developerService.selectStatics("zjut");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println("测试结束");
    }

    @Test
    public void  selectStatistic1(){
        List<OrderStatistic> list = developerService.selectStatistic1("zjut",1);
        System.out.println(list.get(0).getDate());
        System.out.println(list.get(1).getDate());
        System.out.println(list.get(2).getDate());
        System.out.println(list.get(3).getDate());
        System.out.println(list.get(4).getDate());
        System.out.println(list.get(5).getDate());
        System.out.println(list.get(6).getDate());
    }
    @Test
    public void  selectActivity(){
        List<Activity> list = developerService.selectActivity(1,5,"","zjut");
        System.out.println(list.get(0).getActivityId());
        System.out.println(list.get(1).getActivityContent());
    }
}
