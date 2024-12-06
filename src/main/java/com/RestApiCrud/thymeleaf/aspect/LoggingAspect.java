package com.RestApiCrud.thymeleaf.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    //Set-Up Logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //Set-Up Pointcut declarations for controller package
    @Pointcut("execution(* com.RestApiCrud.thymeleaf.controller.*.*(..))")
    private void forControllerPackage() {}

    //Set-Up Pointcut declarations for service package
    @Pointcut("execution(* com.RestApiCrud.thymeleaf.service.*.*(..))")
    private void forServicePackage() {}

    //Set-Up Pointcut declarations for DAO package
    @Pointcut("execution(* com.RestApiCrud.thymeleaf.dao.*.*(..))")
    private void forDaoPackage() {}

    // Combined Pointcut
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        // Display the method called
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("====> in @Before: calling method: " + theMethod);

        // Display the arguments to the method



    }



}
