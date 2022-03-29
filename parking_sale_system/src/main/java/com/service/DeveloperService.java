package com.service;

import com.bean.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface DeveloperService {
    Developer_administrator login(String username,String password);

    boolean insertParkSpace (String residentialQuartersId, String address, String price, String did);

    List<Order> selectOrder(int pageNum,int pageSize,String search,String did);

    boolean updateOrder(String orderId,String contractInitiator, String contractContent, String finalPrice, String finalPaymentTime, String did,String parkingSpaceId) throws ParseException;

    boolean insertExamineApprove(String id,String developer_id, String developerName);

    ArrayList<Integer> selectStatics(String did);

    List<OrderStatistic> selectStatistic1(String did,int state);

    List<ParkingSpace> selectParkingSpace(int pageNum, int pageSize, String search, String did);

    List<Activity> selectActivity(int pageNum,int pageSize,String search,String did);

    boolean addActivity(String activity_name,Integer activity_content,String activity_category,Double activity_discount,String did,String activity_residential_quarters_id);

    boolean deleteActivity(String activity_id);

    List<Activity> selectAllActivity(String did);

    List<ResidentialQuarters> selectAllResidentialQuarters(String did);

    boolean addResidentialQuarters(String developer_id,String residential_quarters_name,String state);

    boolean updateResidentialQuarters_del(String id,String state);

    Developers selectDeveloperInfo1(String id);

    Developer_administrator selectDeveloperInfo2(String id);

    boolean modifyPassword(String uid,String old_pwd,String pwd1,String pwd2);

}
