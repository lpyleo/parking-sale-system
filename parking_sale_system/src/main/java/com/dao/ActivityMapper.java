package com.dao;

import com.bean.Activity;
import com.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {
    List<Activity> selectActivity(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("search") String search, @Param("did") String did);

    boolean addActivity(Activity activity);

    boolean deleteActivity(@Param("activity_id") String activity_id);

    List<Activity> selectAllActivity(@Param("parkingSpaceId") String parkingSpaceId);
}
