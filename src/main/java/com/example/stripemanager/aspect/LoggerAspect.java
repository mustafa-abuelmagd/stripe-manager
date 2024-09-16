package com.example.stripemanager.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This class is an Aspect component used for logging method executions and exceptions in the application.
 * It uses Aspect-Oriented Programming (AOP) .
 * <p>
 * The {@code LoggerAspect} class contains two main aspects:
 * <ul>
 *    1-  <li>{@code logAfterThrowing}: Logs information about exceptions thrown by methods in the
 *     {@code com.example.senderemail.service} package.</li>
 *     <br>
 *    2- <li>{@code loggerAround}: Logs entry, exit, and execution time for the
 *     {@code sendEmail} method in the {@code EmailService} class.</li>
 * </ul>
 */
@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);


    /**
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(* com.example.stripemanager.services.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        LOGGER.error("Exception: From method : From method : ' {} ' in class : ' {} '  , message exception : {}",
                methodName, className, ex.getMessage());
    }


//    /**
//     * @param joinPoint
//     * @throws Throwable
//     */
//    @Around("execution( * com.example.stripemanager.services.EmailService.validateEmailAndSend(..) )")
//    public void loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String methodName = joinPoint.getSignature().getName();
//
//        LOGGER.info("Beginning to check if the data is valid in method: {} of class: {}.", methodName, className);
//
//        joinPoint.proceed();
//
//        LOGGER.info("Data validation completed successfully. The email data is valid and will now be sent.");
//
//    }


}