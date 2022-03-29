package com.service.impl;

import com.bean.Administrators;
import com.bean.Order;
import com.bean.ParkingSpace;
import com.bean.UserAdminBill;
import com.dao.AdministratorsMapper;
import com.dao.OrderMapper;
import com.dao.ParkingSpaceMapper;
import com.dao.UserAdminBillMapper;
import com.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private UserAdminBillMapper userAdminBillMapper;
    @Autowired
    private AdministratorsMapper administratorsMapper;
    @Override
    public boolean insertOrder(String parkingSpaceId,String contractSignatory,String contractInitiator,String AdminName) {
        //查询后台管理员信息
        Administrators administrators = new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(AdminName);
        String adminId=administrators.getAdministratorsId();
        Order order =new Order();
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        //生成订单号
        long  timeNew =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        String OR="OR"+timeNew;
        //计算定金
        double money;
        ParkingSpace parkingSpace;
        parkingSpace = parkingSpaceMapper.selectParkingSpaceById(parkingSpaceId);
        money=parkingSpace.getPrice()*0.3;
        order.setOrderId(OR);
        order.setState(1);
        order.setDeposit(money);
        order.setParkingSpaceId(parkingSpaceId);
        order.setContractSignatory(contractSignatory);
        order.setContractInitiator(contractInitiator);
        order.setOrderTime(now);
        //生成用户管理员账单
        UserAdminBill userAdminBill=new UserAdminBill();
        //生成ID号
        long  timeNew1 =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        String UDB="UDB"+timeNew1;
        userAdminBill.setId(UDB);
        userAdminBill.setType("提交定金");
        userAdminBill.setMoney(money);
        userAdminBill.setSnederId(contractSignatory);
        userAdminBill.setReceiverId(adminId);
        userAdminBill.setOrderId(OR);
        userAdminBill.setTime(now);
        if(orderMapper.insertOrder(order)){
            System.out.println("订单插入成功");
        }
        if(userAdminBillMapper.insertUserAdminBill(userAdminBill)){
            System.out.println("用户后台管理员账单插入成功");
        }
        return true;
    }

    @Override
    public List<Order> selectUserOrder(String userIdentity){return orderMapper.selectUserOrder(userIdentity);};

    @Override
    public Order selectOrderById(String orderId){return orderMapper.selectOrderById(orderId);};
}
