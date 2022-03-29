package com.service;

import com.bean.Bankcard;

import java.util.List;

public interface BankcardService {
    List<Bankcard> selectBankcard(String userId);
    boolean insertBankcard(Bankcard bandcard);
}
