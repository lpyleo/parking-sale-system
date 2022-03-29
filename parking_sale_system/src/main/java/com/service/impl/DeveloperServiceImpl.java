package com.service.impl;

import com.bean.*;
import com.dao.*;
import com.dao.DeveloperMapper;
import com.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
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

    @Override
    public Developer_administrator login(String username, String password){
        Developer_administrator developer_administrator= developerMapper.login(username,password);
        if(developer_administrator!=null){
            String state=developersMapper.selectState(developer_administrator.getDeveloperId());
            if(state.equals("正常")){
                return developer_administrator;
            }
            else if(state.equals("封号")){
                return null;
            }
        }
        return null;
    }

//    添加上架车位
    @Override
    public boolean insertParkSpace (String residentialQuartersId, String address, String price,String pid){
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(pid);
        parkingSpace.setPrice(Double.parseDouble(price));
        parkingSpace.setAddress(address);
        parkingSpace.setPhoto(pid);
        parkingSpace.setResidentialQuartersId(residentialQuartersId);
        parkingSpace.setState(1);
        parkingSpace.setViews(0);
        parkingSpace.setBuyersId(null);
        parkingSpace.setPreferentialMeasures(null);
        return parkingSpaceMapper.insertParkSpace(parkingSpace);
    }

    @Override
    public List<Order> selectOrder(int pageNum, int pageSize, String search,String did){
        return orderMapper.selectOrder(pageNum,pageSize,search,did);
    }

    //修改处理订单
    @Override
    @Transactional
    public boolean updateOrder(String orderId,String contractInitiator, String contractContent, String finalPrice, String finalPaymentTime,String did,String parkingSpaceId) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        List<Order> list = orderMapper.selectOrder(1,1,orderId,did);
        Order order = (Order) list.get(0);
        if (order==null){
            return false;
        }
        order.setContractInitiator(contractInitiator);
        order.setContractContent(contractContent+".jpg");
//        如果传来的价格为空
        if(finalPrice == null || finalPrice.equals("")){
            //        通过活动优惠计算价格
            System.out.println("通过活动计算价格");
            ParkingSpace parkingSpace = parkingSpaceMapper.selectParkingSpaceById(parkingSpaceId);
            Double price =  parkingSpace.getPrice();
            List<Activity> list_activity = activityMapper.selectAllActivity(parkingSpaceId);
            Iterator<Activity> it = list_activity.iterator();
            while(it.hasNext()) {
                Activity activity =it.next();
                if(activity.getActivityCategory().equals("打折")){
                    price = price*activity.getActivityDiscount();
                }
                else if(activity.getActivityCategory().equals("满减")){
//                向下取整
                    int del= (int) Math.floor(price/activity.getActivityContent());
                    price=price-activity.getActivityDiscount()*del;
                }
            }
            order.setFinalPrice(price-order.getDeposit());
        }
        else{
//            传过来的价格不为空则按照传过来的价格计算
            System.out.println("通过值计算价格");
            order.setFinalPrice(Double.parseDouble(finalPrice));
        }
        order.setFinalPaymentTime(dateFormat.parse(finalPaymentTime));
        order.setState(2);
        if(orderMapper.updateOrder(order)){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean insertExamineApprove(String id,String developer_id, String developerName) {
        ExamineApprove examineApprove=new ExamineApprove();
        //用于设置开发者的邮箱
        examineApprove.setDeveloperId(developer_id);
        //用于设置开发者的名字
        examineApprove.setDeveloperName(developerName);
        examineApprove.setId(id);
        examineApprove.setFile(id+".jpg");
        examineApprove.setState(3);
        if(examineApproveMapper.insertExamineApprove(examineApprove)){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public ArrayList<Integer> selectStatics(String did){
//        订单信息统计
        List<Order> list = orderMapper.selectAllOrderByDid(did);
        ArrayList<Integer> result = new ArrayList<>();
        Iterator<Order> it = list.iterator();
        int order_wait = 0;
        int order_ing = 0;
        int order_finish = 0;
        int order_stop = 0;
        while(it.hasNext()) {
            int s =it.next().getState();
            if(s==1){
                order_wait=order_wait+1;
            }
            else if(s==2){
                order_ing=order_ing+1;
            }
            else if(s==3) {
                order_finish=order_finish+1;
            }
            else if(s>3){
                order_stop=order_stop+1;
            }
        }
//        账户金额统计
        int money= developersMapper.selectMoney(did).intValue();
//        商品数量统计
        int parking_space =parkingSpaceMapper.countParkSpace(did);
//        加入返回列表
        result.add(parking_space);
        result.add(money);
        result.add(order_wait);
        result.add(order_ing);
        result.add(order_finish);
        result.add(order_stop);
        return result;
    }

    @Override
    @Transactional
    public List<OrderStatistic> selectStatistic1(String did,int state){
//        订单信息统计
        List<OrderStatistic> list = orderMapper.selectStatisticOrder(did,state);
        return list;

    }

//    车位管理
    @Override
    @Transactional
    public List<ParkingSpace> selectParkingSpace(int pageNum, int pageSize, String search,String did){
        return parkingSpaceMapper.selectParkSpace(pageNum,pageSize,search,did);
    }

//    活动管理
    @Override
    @Transactional
    public List<Activity> selectActivity(int pageNum,int pageSize,String search,String did){
        return activityMapper.selectActivity(pageNum,pageSize,search,did);
    }
//    活动添加
    @Override
    @Transactional
    public boolean addActivity(String activity_name,Integer activity_content,String activity_category,Double activity_discount,String did,String activity_residential_quarters_id){
        Activity activity=new Activity();
        //生成活动编号
        long  timeNew =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        String AC="AC"+timeNew;
        activity.setActivityId(AC);
        if(activity_content != null && activity_content != 0){
            activity.setActivityContent(activity_content);
        }
        activity.setActivityName(activity_name);
        activity.setActivityDiscount(activity_discount);
        activity.setActivityCategory(activity_category);
        activity.setActivityDeveloperId(did);
        if(activity_residential_quarters_id!=null && !activity_residential_quarters_id.equals("")){
            activity.setActivityResidentialQuartersId(activity_residential_quarters_id);
        }
        return activityMapper.addActivity(activity);
    }

//    活动删除
    @Override
    @Transactional
    public boolean deleteActivity(String activity_id){
        return activityMapper.deleteActivity(activity_id);
    }

//    活动应用查找所有活动
    @Override
    @Transactional
    public List<Activity> selectAllActivity(String did){
    return activityMapper.selectAllActivity(did);
}

//查询所有小区
    @Override
    @Transactional
    public List<ResidentialQuarters> selectAllResidentialQuarters(String did){
        return residentialQuartersMapper.selectResidentialQuarters(did);
    }

//    添加小区
    @Override
    @Transactional
    public boolean addResidentialQuarters(String developer_id,String residential_quarters_name,String state){
        long  timeNew =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        String RQ="RQ"+timeNew;
        ResidentialQuarters residentialQuarters = new ResidentialQuarters();
        residentialQuarters.setId(RQ);
        residentialQuarters.setDeveloperId(developer_id);
        residentialQuarters.setResidentialQuartersName(residential_quarters_name);
        residentialQuarters.setState(state);
        if(residentialQuartersMapper.insertResidentialQuarters(residentialQuarters)){
            return true;
        }
        return false;
    }

//    更改小区状态
    @Override
    @Transactional
    public boolean updateResidentialQuarters_del(String id,String state){
        return residentialQuartersMapper.updateResidentialQuarters(id,state);
    }

    //查询开发商个人信息一
    @Override
    @Transactional
    public Developers selectDeveloperInfo1(String id){
        return developersMapper.selectDeveloper(id);
    }

    //查询登录账号个人西信息二
    @Override
    @Transactional
    public Developer_administrator selectDeveloperInfo2(String id){
        return developerMapper.select_roleInfo(id);
    }

    @Override
    @Transactional
    public boolean modifyPassword(String uid,String old_pwd,String new_pwd1,String new_pwd2){
        if(developerMapper.login(uid,old_pwd)!=null){
            if(new_pwd1.equals(new_pwd2)){
                return developerMapper.modify_password(uid,new_pwd1);
            }
            return false;
        }
        return false;


    }
}


