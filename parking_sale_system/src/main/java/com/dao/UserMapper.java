package com.dao;

import com.bean.Developer_administrator;
import com.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author sushuai
 * @date 2019/03/03/21:33
 */
public interface UserMapper {


    /**
     * 通过用户名查询用户信息
     * @param userName
     * @return
     */
    User selectUserByUserName(@Param("userName") String userName);

    User selectUserByUserId(@Param("userIdentity") String userIdentity);


    User userLogin(@Param("userIdentity") String username, @Param("password") String password);


    boolean insertUser(User user);

    boolean updateUserMoney(@Param("money") double money,@Param("userName") String userName);

    boolean insertUserPassword(User user);

    boolean updateUserInfo(User user);

    User selectNameById(@Param("userIdentity") String userIdentity);

    User userAuthentication(@Param("userResidentialQuarters") String userResidentialQuarters,@Param("userBuildingNumber") String userBuildingNumber,@Param("userHouseNum") String userHouseNum);

}
