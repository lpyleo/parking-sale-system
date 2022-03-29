package com.service;


import com.bean.ParkingSpace;
import com.bean.ResidentialQuarters;
import com.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    User selectUserByUserName(String username);

    User selectUserByUserId(String userIdentity);

    User selectNameById(String userIdentity);

    User userLogin(String username, String password);


    boolean insertUser(User user);

    boolean insertUserPassword(User user);

    boolean updateUserInfo(User user);

    boolean updateUserMoney(double money,String userName);

    List<ParkingSpace> selectParkingSpace(int pageNum, int pageSize, String search, String did);

    List<ParkingSpace> selectAllParkSpace(int pageNum,int pageSize);

    List<ParkingSpace> selectAllSpace();

    ResidentialQuarters selectResidentialQuartersById(String did);

    User userAuthentication(String userResidentialQuarters,String userBuildingNumber,String userHouseNum);

    boolean updateOrderState(int state,String orderId);


}
