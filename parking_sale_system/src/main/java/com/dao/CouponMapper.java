package com.dao;

import com.bean.Bankcard;
import com.bean.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {
    List<Coupon> selectCoupon(@Param("userId") String userId);
    boolean insertCoupon(Coupon coupon);
}
