package cn.bdqn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *      作用：
 *          日志功能
 */
public class Logger {

    // 功能的增强，功能的增强是在业务方法执行之前进行调用
    public void beforePrintLog(){
        System.out.println("前置通知（before）日志打印啦....");
    }

    //  该方法的作用是在切入点方法执行之后执行
    public void afterReturningPrintLog(){
        System.out.println("后置通知(afterReturningPrintLog)：业务方法执行完了，日志打印");
    }

    //  该方法的作用是在切入点方法执行出错后执行
    public void afterThrowingPrintLog(){
        System.out.println("异常通知(afterThrowingPrintLog)：业务方法出现异常了，日志打印");
    }

    //  该方法的作用是在切入点方法执行之后不管有没有错误，都最终要执行
    public void afterPrintLog(){
        System.out.println("最终通知(afterPrintLog)：业务方法不管有没有异常了，日志打印");
    }

    // 环绕通知
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object result = null;
        try{

            // 获取目标方法的参数的
            Object[] args = pjp.getArgs();
            if(args != null && args.length > 0){
                for (Object arg : args) {
                    System.out.println(arg);
                }
            }

            // 获取目标方法的方法名称
            String methodName = pjp.getSignature().getName();
            System.out.println("方法名称:" + methodName);

            // 前置通知
            System.out.println("前置通知的代码执行了....");
            // 调用目标方法
            result = pjp.proceed();
            // 后置通知
            System.out.println("后置通知执行了....");
        }catch (Throwable e){
            e.printStackTrace();
            // 异常通知
            System.out.println("异常通知执行啦.....");
        }finally {
            // 最终通知
            System.out.println("最终通知执行啦.....");
        }
        return result;
    }
}
