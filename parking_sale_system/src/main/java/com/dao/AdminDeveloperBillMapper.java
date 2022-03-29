package com.dao;
import com.bean.AdminDeveloperBill;
import org.apache.ibatis.annotations.Param;
public interface AdminDeveloperBillMapper {
    boolean insertAdminDeveloperBill(AdminDeveloperBill adminDeveloperBill);
}
