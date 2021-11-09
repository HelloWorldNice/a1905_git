package cn.bdqn.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *  事务的切面
 */
@Component // 注册Bean到容器
@Aspect     // 这个类是一个切面类
public class TransactionAspect {

    // 去定义切入点表达式
    @Pointcut("execution(* cn.bdqn.service.PigServiceImpl.*(..))")
    private void pointCut(){};

    @Before("pointCut()")
    public void beginTx(){
        System.out.println("前置增强....开启事务啦....");
    }

    @AfterReturning("pointCut()")
    public void commitTx(){
        System.out.println("后置增强....提交事务啦....");
    }

//    @AfterReturning // 后置增强
//    @AfterThrowing // 异常增强
//    @After // 最终增强
//    @Around // 环绕增强
}
