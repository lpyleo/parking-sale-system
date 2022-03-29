package dao;

import com.bean.Bankcard;
import com.bean.Order;
import com.bean.User;
import com.dao.*;
import com.service.CouponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class DaoTestMiao {

    @Autowired
    private AdministratorsMapper administratorsMapper;
    //private UserMapper userMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeveloperMapper developerMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private BankcardMapper bankcardMapper;
    @Autowired
    private CouponMapper couponMapper;



    /**
     * 1、登录时通过用户名来确认用户名是否存在
     *
     * 提示：如果username是中文，则查询为null
     * 解决方法：在jdbc.url后面添加  useUnicode=true&characterEncoding=utf-8  即可解决
     */



    @Test
    public void selectUserByUserName() {
        System.out.println("dao测试开始。。。。");
        User user = new User();
        user = userMapper.selectUserByUserName("miao");
        System.out.println(user.getUserAge());
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectNameById() {
        System.out.println("dao测试开始。。。。");
        User user = new User();
        user = userMapper.selectNameById("001");
        System.out.println(user.getUserName());
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectUserOrder() {
        System.out.println("dao测试开始。。。。");
        List<Order> order = orderMapper.selectUserOrder("huangyimiao666@gmail.com");
        System.out.println(order.get(0).getOrderId());
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void selectBankcard() {
        System.out.println("dao测试开始。。。。");
        List<Bankcard> bankcard = bankcardMapper.selectBankcard("huangyimiao666@gmail.com");
        System.out.println(bankcard.get(0).getBankcardId());
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void insertUser() {
        System.out.println("dao测试开始。。。。");
        User user = new User();
        user.setUserIdentity("002");
        user.setUserName("哈哈");
        user.setUserPassword("123456");
        user.setUserPhone("15557565532");
        user.setUserSex("男");
        user.setUserInvitee("778");
        boolean flag1 = userMapper.insertUser(user);
        boolean flag2 = userMapper.insertUserPassword(user);
        System.out.println(flag1&&flag2);
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void insertBankcard() {
        System.out.println("dao测试开始。。。。");
        Bankcard bankcard = new Bankcard();
        bankcard.setBankcardId("32112381");
        bankcard.setUserId("huangyimiao666@gmail.com");
        bankcard.setBank("建设银行");

        boolean flag1 = bankcardMapper.insertBankcard(bankcard);
        System.out.println(flag1);
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void userLogin() {
        System.out.println("dao测试开始。。。。");
        User user = new User();
        user = userMapper.userLogin("001","123456");
        System.out.println(user.getUserPassword());
        System.out.println("dao测试结束。。。。");
    }
    @Test
    public void selectdeveloper() {
        System.out.println("dao测试开始。。。。");
        System.out.println(developerMapper.login("zjut","123"));
        System.out.println("dao测试结束。。。。");
    }

    @Test
    public void updateUserInfo(){
        User user = new User();
        user.setUserIdentity("huangyimiao666@gmail.com");
        user.setUserSex("女");
        user.setUserPhone("15700190560");
        user.setUserName("huangmm");
        user.setUserResidentialQuarters("15区");
        user.setUserBuildingNumber("6");
        user.setUserHouseNumber("401");
        boolean flag = userMapper.updateUserInfo(user);
        System.out.println(flag);
    }

    @Test
    public void updateUserMoney(){
        boolean flag = userMapper.updateUserMoney(20000,"huangyimiao666@gmail.com");
        System.out.println(flag);
    }

    @Test
    public void userAuthentication(){
        User user1 = userMapper.userAuthentication("15区","6","401");
        if(user1==null){
            System.out.println("fuifufi");
        }
        else{
            System.out.println(user1.getUserName());
        }
    }


    /**
     * 2、注册时往user表里面插入数据
     */

//    @Test
//    public void insertUser(){
//        System.out.println("dao测试开始。。。。");
//        User user = new User();
//        user.setUsername("王浩");
//        user.setPassword("123");
//        System.out.println(userMapper.insertUser(user));
//        System.out.println("到测试结束。。。。");
//    }

//    @Test
//    public void selectUserByAdministratorsName(){
//        System.out.println("测试开始");
//        Administrators administrators =new Administrators();
//        administrators =administratorsMapper.selectAdministratorsByName("lihua");
//        System.out.println(administrators.getAdministratorsName()+administrators.getAdministratorsPassword());
//    }

//    @Test
//    public void updateAdministratorsMoney(){
//        System.out.println("修改开始");
//        Administrators administrators =new Administrators();
//        administrators =administratorsMapper.selectAdministratorsByName("lihua");
//        double moneys=3000+administrators.getMoney();
//        System.out.println(moneys);
//
//        administratorsMapper.updateAdministratorsMoney(moneys,"lihua");
//    }



    /**
     * 2、注册时往user表里面插入数据
     */
//    @Test
//    public void insertUser(){
//        System.out.println("dao测试开始。。。。");
//        User user = new User();
//        user.setUsername("王浩");
//        user.setPassword("123");
//        System.out.println(userMapper.insertUser(user));
//        System.out.println("到测试结束。。。。");
//    }


}
