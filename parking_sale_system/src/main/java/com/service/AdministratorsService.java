package com.service;

import com.bean.Administrators;
import com.bean.Developers;
import com.bean.ExamineApprove;

import java.util.List;

public interface AdministratorsService {
    Administrators selectAdministratorsByName(String administratorsName);
    boolean updateAdministratorsMoney(double money,String administratorsName);
    boolean registerAdministrators(String administratorsName,String administratorsPassword);
    boolean addDevelopers(String developerId,String developerName);
    boolean addDeveloper_administrator(String developerId);
    boolean updateAdministratorsMoneyMinus(double money,String administratorsName);
    boolean cancelOrder(String orderId,String administratorsName);
    boolean timeoutOrder(String orderId,String administratorsName);
    boolean finishOrder(String orderId,String administratorsName);
    List<ExamineApprove> selectExamineApprove(int pageNum,int pageSize,int state);
    List<ExamineApprove> selectHisExamineApprove(int pageNum,int pageSize,String adminId,int state1,int state2);
    boolean unpassfile(int state,String eId,String adminName);
    boolean passfile(int state,String eId,String adminName);
    List<Developers> selectDevelopers(int pageNum,int pageSize);
    boolean unseal(String dId);
    boolean seal(String dId);
    boolean offline(String dId);
    public void sendMail(String developerid);
    //boolean insertUserAdminBill(String type,String snederId,String receiverId,double money);



}
