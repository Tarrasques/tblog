package com.tblog.tlog.utils;

import com.tblog.tlog.entity.TblogLog;
import com.tblog.tlog.mapper.TblogLogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class LogAspect {

    @Autowired
    private TblogLogMapper mapper;

    private Method method;


    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    //@annotation表示标注了某个注解的所有方法
    @Pointcut("@annotation(com.tblog.tlog.utils.TLog)")
    public void LogAspect() {

    }

    //配置后置通知,使用在方法aspect()上注册的切入点
    @After("LogAspect()")
    public void After(JoinPoint joinPoint) {
        System.out.println("---------After方法开始执行");
    }

    //配置前置通知,使用在方法aspect()上注册的切入点
    //同时接受JoinPoint切入点对象,可以没有该参数
    @Before("LogAspect()")
    public void Before() {
        System.out.println("---------Before方法开始执行");
    }

    //最终通知
    //returning能够将目标方法的返回值传到切面增强方法里
    //声明rvt时指定的类型会限制目标方法必须返回指定类型(String)的值或没有返回值
    //此处将rvt的类型声明为Object，意味着对目标方法的返回值不加限制
    @AfterReturning(pointcut = "LogAspect()", returning = "rvt")
    public void AfterReturning(Object rvt) {
        System.out.println("--------AfterReturning方法开始执行:---" + rvt.toString());
        //获取自定义注解里面的值
        TLog logAnnotation = (TLog) method.getAnnotation(TLog.class);
        TblogLog tblogLog = new TblogLog();
        tblogLog.setId(UUIDUtils.UUID());
        tblogLog.setCreateTime(new Date());
        tblogLog.setContent(logAnnotation.operateClass() + ">>>" + logAnnotation.operateMethod() + ">>>" + rvt.toString());
        UserDetails currentUserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String currentUserDetails = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (currentUserDetails != null) {
            tblogLog.setUserName(currentUserDetails.getUsername());
        }
        mapper.insert(tblogLog);
    }

    //异常通知
    //声明e时指定的类型会限制目标方法必须抛出指定类型的异常
    //此处将e的类型声明为Throwable，意味着对目标方法抛出的异常不加限制
    @AfterThrowing(pointcut = "LogAspect()", throwing = "e")
    public void AfterThrowing(Throwable e) {
        System.out.println("--------AfterThrowing方法开始执行:" + e);
        //获取自定义注解里面的值
        TLog logAnnotation = (TLog) method.getAnnotation(TLog.class);
        TblogLog tblogLog = new TblogLog();
        tblogLog.setId(UUIDUtils.UUID());
        UserDetails currentUserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (currentUserDetails != null) {
            tblogLog.setUserName(currentUserDetails.getUsername());
        }
        tblogLog.setCreateTime(new Date());
        tblogLog.setContent(logAnnotation.operateClass() + ">>>" + logAnnotation.operateMethod() + ">>>" + e.getMessage());
        mapper.insert(tblogLog);
    }


    //@Around注解可以用来在调用一个具体方法前和调用后来完成一些具体的任务。
    //功能很强大，可以深入了解下
    @Around("LogAspect()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------Around方法开始执行");
//        //获取自定义注解里面的值
        method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        TLog logAnnotation = (TLog) method.getAnnotation(TLog.class);
        System.err.println("operateType:------" + logAnnotation.operateClass());
        System.err.println("operateExplain:------" + logAnnotation.operateMethod());

        //获取入参
        Object[] objs = joinPoint.getArgs();
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames(); // 参数名
        Map<String, Object> paramMap = new HashMap<String, Object>();
        for (int i = 0; i < objs.length; i++) {
            paramMap.put(argNames[i], objs[i]);
        }
        System.err.println("入参:" + paramMap.toString());

        //获取出参
        Object result = joinPoint.proceed();
        System.err.println("出参:" + result.toString());
        return result;
    }

}
