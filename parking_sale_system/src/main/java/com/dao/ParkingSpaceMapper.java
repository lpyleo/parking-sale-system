package com.dao;
import com.bean.Order;
import com.bean.User;
import org.apache.ibatis.annotations.Param;
import com.bean.ParkingSpace;

import java.util.List;

public interface ParkingSpaceMapper {
    ParkingSpace selectParkingSpaceById(@Param("id") String id);

    boolean insertParkSpace(ParkingSpace parkingSpace);
    boolean updateParkSpaceState(@Param("state") int state,@Param("id") String id);

    Integer countParkSpace(@Param("did") String did);

    List<ParkingSpace> selectParkSpace(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("search") String search, @Param("did") String did);

    List<ParkingSpace> selectAllParkSpace(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    List<ParkingSpace> selectAllSpace();

}
