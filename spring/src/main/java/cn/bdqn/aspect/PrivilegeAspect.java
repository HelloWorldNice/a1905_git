package cn.bdqn.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *  权限相关的切面
 */
@Component  // 将这个类纳入到Spring管理中，创建对象的
@Aspect // 标识这个类是一个切面类
public class PrivilegeAspect {

    // 前置通知
    @Before("execution(* cn.bdqn.service.PigServiceImpl.*(..))")
    public void beforePrintLog(){
        System.out.println("前置通知----beforePrintLog---开始权限判断啦....");
    }

//    @AfterReturning // 后置通知
//    @AfterThrowing // 后置通知
//    @AfterThrowing // 异常通知
//    @After         // 最终通知
//    @Around        // 环绕通知
}
