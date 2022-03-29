package com.service;

import com.bean.ParkingSpace;
import org.apache.ibatis.annotations.Param;

public interface ParkingSpaceService {
    ParkingSpace selectParkingSpaceById(String id);

    boolean updateParkSpaceState(int state,String id);

}
