package com.dao;

import com.bean.Bankcard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankcardMapper {
    List<Bankcard> selectBankcard(@Param("userId") String userId);
    boolean insertBankcard(Bankcard bandcard);
}
