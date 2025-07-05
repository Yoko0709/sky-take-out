package com.sky.aspect;

import com.sky.annotation.AutoFill;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
custom aspect, autofill
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    /*
    Entry Point
     */
    @Pointcut("execution(*com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut() {
    }
    /*
    Before inform
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("Start AutoFillAspect");
    }
}
