package com.aspect;
import com.bean.Developer_administrator;
import com.dao.DeveloperMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;

@Component
@Aspect
public class DiscountHandler {
    @Autowired
    private DeveloperMapper developerMapper;
    /** 定义 Pointcut,Pointcut 的名称是 modify，

     *此方法不能有返回值和参数，该方法只是一个标识*/
    @Pointcut("execution(* com.service.impl.DeveloperServiceImpl.updateOrder(..))")
    private void discount(){};


    /** 定义 Advice，标识在那个切入点何处织入此方法 */ @Around("discount()")
    private Object checkSecurity(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session=attr.getRequest().getSession(true);
        String uid = (String)session.getAttribute("uid");
        if(uid ==null || uid.equals("")){
            System.out.println("---没有相应的权限()---");
            return null;
        }
        Developer_administrator developer_administrator = developerMapper.select_roleInfo(uid);
        if(developer_administrator.getRole().equals("管理员")){
            System.out.println("---管理员通过()---");
            return joinPoint.proceed();
        }
        else{
            System.out.println("---没有相应的权限()---");
            return null;
        }
    }
}
