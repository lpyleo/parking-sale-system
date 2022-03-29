package com.service.impl;

import com.bean.Bankcard;
import com.dao.BankcardMapper;
import com.dao.DeveloperMapper;
import com.service.BankcardService;
import com.service.DeveloperService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankcardServiceImpl implements BankcardService {
    @Autowired
    private BankcardMapper bankcardMapper;

    @Override
    public List<Bankcard> selectBankcard(String userId){return bankcardMapper.selectBankcard(userId);};

    @Override
    public boolean insertBankcard(Bankcard bandcard){return bankcardMapper.insertBankcard(bandcard);};
}
