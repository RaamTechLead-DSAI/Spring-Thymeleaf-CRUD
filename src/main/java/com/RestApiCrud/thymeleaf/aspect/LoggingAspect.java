package com.RestApiCrud.thymeleaf.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * LoggingAspect: An aspect to provide logging functionality for the application.
 *
 * This aspect logs method calls, their arguments, and the return values in the
 * Controller, Service, and DAO layers of the application, offering better visibility
 * into application behavior.
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * Logger instance for this aspect. Uses Java's built-in logging API.
     */
    private Logger myLogger = Logger.getLogger(getClass().getName());

    /**
     * Pointcut to match all methods in the Controller package.
     *
     * This pointcut is used to target logging for all classes within
     * the `com.RestApiCrud.thymeleaf.controller` package.
     */
    @Pointcut("execution(* com.RestApiCrud.thymeleaf.controller.*.*(..))")
    private void forControllerPackage() {}

    /**
     * Pointcut to match all methods in the Service package.
     *
     * This pointcut is used to target logging for all classes within
     * the `com.RestApiCrud.thymeleaf.service` package.
     */
    @Pointcut("execution(* com.RestApiCrud.thymeleaf.service.*.*(..))")
    private void forServicePackage() {}

    /**
     * Pointcut to match all methods in the DAO package.
     *
     * This pointcut is used to target logging for all classes within
     * the `com.RestApiCrud.thymeleaf.dao` package.
     */
    @Pointcut("execution(* com.RestApiCrud.thymeleaf.dao.*.*(..))")
    private void forDaoPackage() {}

    /**
     * Combined pointcut that includes methods in the Controller, Service, and DAO packages.
     *
     * This allows advice to be applied across all major layers of the application.
     */
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    /**
     * Before advice that runs before methods matched by the `forAppFlow` pointcut.
     *
     * Logs the method being called and its arguments before execution.
     *
     * @param theJoinPoint JoinPoint instance providing reflective access to the method being advised.
     */
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        // Get the name of the method being called
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("====> in @Before: calling method: " + theMethod);

        // Get the arguments passed to the method
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            myLogger.info("====> argument: " + tempArg);
        }
    }

    /**
     * AfterReturning advice that runs after methods matched by the `forAppFlow` pointcut.
     *
     * Logs the method that returned and the result of the method.
     *
     * @param theJoinPoint JoinPoint instance providing reflective access to the method being advised.
     * @param theResult    The object returned by the method execution.
     */
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
        // Get the name of the method that returned
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("====> in @AfterReturning: from method: " + theMethod);

        // Log the result returned by the method
        if (Objects.nonNull(theResult)) {
            myLogger.info("====> result: " + theResult);
        } else {
            myLogger.info("====> result: null");
        }
    }
}
