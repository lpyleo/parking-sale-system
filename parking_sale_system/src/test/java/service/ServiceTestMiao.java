package service;

import com.bean.Order;
import com.bean.User;
import com.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class ServiceTestMiao {

    @Autowired
    //private UserService userService;
    private AdministratorsService administratorsService;

    @Autowired
    private UserService userService;
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CouponService couponService;


    /**
     * 1、登录时通过用户名来确认用户名是否存在
     */
/*
=======
//    @Test
//    public void selectUserByUserName() {
//        System.out.println("service测试开始。。。。");
//
//        System.out.println(userService.selectUserByUserName("张三"));
//
//        System.out.println("service测试结束。。。。");
//    }

>>>>>>> 4dd7ee6ca105cdf57a484258332e5adb3a8e9a41
    @Test
    public void developer_login(){
        System.out.println("service测试开始。。。。");

<<<<<<< HEAD
        System.out.println(userService.selectUserByUserName("王浩"));
=======
        System.out.println(developerService.login("zjut","123"));
>>>>>>> 4dd7ee6ca105cdf57a484258332e5adb3a8e9a41

        System.out.println("service测试结束。。。。");
    }
 */

//    @Test
//    public void selectAdministratorsByName(){
//        System.out.println("service测试开始。。。");
//        User user = new User();
//        user = userService.selectUserByUserName("miao");
//        System.out.println(user.getUserAge());
//        System.out.println("service测试结束。。。");
//    }

//    @Test
//    public void userLogin(){
//        System.out.println("service测试开始。。。");
//        User user = new User();
//        user = userService.userLogin("001","123456");
//        System.out.println(user.getUserPassword());
//        System.out.println("service测试结束。。。");
//    }

//    @Test
//    public void insertUser() {
//        System.out.println("dao测试开始。。。。");
//        User user = new User();
//        user.setUserIdentity("003");
//        user.setUserName("哈哈");
//        user.setUserPassword("123456");
//        user.setUserPhone("15557565532");
//        user.setUserSex("男");
//        user.setUserInvitee("778");
//        boolean flag1 = userService.insertUser(user);
//        boolean flag2 = userService.insertUserPassword(user);
//        System.out.println(flag1&&flag2);
//        System.out.println("dao测试结束。。。。");
//    }

    @Test
    public void selectUserOrder() {
        System.out.println("dao测试开始。。。。");
        List<Order> order = orderService.selectUserOrder("huangyimiao666@gmail.com");
        System.out.println(order.get(0).getOrderId());
        System.out.println("dao测试结束。。。。");
    }



    /**
     * 2、注册时往user表里面插入用户名和密码
     */
    /*
    @Test
    public void insertUser(){
        System.out.println("service测试开始。。。。");

        User user = new User();
        user.setUsername("王浩");
        user.setPassword("123");
        System.out.println(userService.insertUser(user));

        System.out.println("service测试结束。。。。");
    }

     */
}
