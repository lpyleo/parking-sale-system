package com.service.impl;

import com.bean.Bankcard;
import com.bean.Coupon;
import com.dao.BankcardMapper;
import com.dao.CouponMapper;
import com.service.BankcardService;
import com.service.CouponService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public List<Coupon> selectCoupon(String userId){return couponMapper.selectCoupon(userId);};

    @Override
    public boolean insertCoupon(Coupon coupon){return couponMapper.insertCoupon(coupon);};
}
