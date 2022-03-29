package com.service;

import com.bean.Bankcard;
import com.bean.Coupon;

import java.util.List;

public interface CouponService {
    List<Coupon> selectCoupon(String userId);
    boolean insertCoupon(Coupon coupon);
}
