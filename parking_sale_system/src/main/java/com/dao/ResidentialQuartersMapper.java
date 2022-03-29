package com.dao;

import com.bean.ResidentialQuarters;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResidentialQuartersMapper {

    boolean insertResidentialQuarters(ResidentialQuarters residentialQuarters);
    List<ResidentialQuarters> selectResidentialQuarters(@Param("did") String did);
    boolean updateResidentialQuarters(@Param("did") String did,@Param("state") String state);
    ResidentialQuarters selectResidentialQuartersById(@Param("did") String did);

}
