package com.service.impl;

import com.bean.ParkingSpace;
import com.dao.ParkingSpaceMapper;
import com.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;

    @Override
    public ParkingSpace selectParkingSpaceById(String id) {
        return parkingSpaceMapper.selectParkingSpaceById(id);
    }

    @Override
    public boolean updateParkSpaceState(int state, String id) {
        return parkingSpaceMapper.updateParkSpaceState(state,id);
    }
}
