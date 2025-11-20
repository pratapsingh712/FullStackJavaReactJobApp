package com.example.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //execution(return type, class-name.method-name(args)
    @Before("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint joinPoint){
        LOGGER.info("Method called :"+joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint joinPoint){
        LOGGER.info("Method Executed :"+joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodCrashed(JoinPoint joinPoint){
        LOGGER.info("Method has some issue :"+joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint joinPoint){
        LOGGER.info("Method Executed Successfully :"+joinPoint.getSignature().getName());
    }

}
