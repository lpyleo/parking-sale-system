package com.dao;

import com.bean.Developers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DevelopersMapper {
    boolean insertDevelopers(Developers developers);
    Double selectMoney(@Param("did") String did);
    boolean updateDevelopersState(@Param("state") String state,@Param("id") String id);
    List<Developers> selectDevelopers(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
    boolean deleteDevelopers(@Param("id") String id);
    String selectState(@Param("id") String id);
    Developers selectDeveloper(@Param("developerId") String developerId);
    boolean updateMoney(@Param("did") String did,@Param("money") double money);
}
