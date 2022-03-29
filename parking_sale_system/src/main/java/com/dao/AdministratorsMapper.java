package com.dao;
import org.apache.ibatis.annotations.Param;
import com.bean.Administrators;
public interface AdministratorsMapper {
    Administrators selectAdministratorsByName(@Param("administratorsName") String administratorsName);
    boolean updateAdministratorsMoney(@Param("money") double money,@Param("administratorsName") String administratorsName);
    boolean insertAdministrators(Administrators administrators);

}
