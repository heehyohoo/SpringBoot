package com.example.jpacalendarpractice02.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //컨트롤러, 서비스, 리포짓 토리를 지나면 아래와같이 로그를 기록한다.
    @Around(" execution(* com.example.jpacalendarpractice02.controller..*Controller.*(..))" +
            "||  execution(* com.example.jpacalendarpractice02.service..*Controller.*(..))" +
            "|| execution(* com.example.jpacalendarpractice02.repository..*Controller.*(..))")
    public Object logAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName(); // 클래스이름
        String methodName = proceedingJoinPoint.getSignature().getName(); // 메서드이름
        String parameters = Arrays.toString(proceedingJoinPoint.getArgs()); // 파라미터


        logger.info("[[START]]"+className+"."+proceedingJoinPoint.getSignature().getName()+"() <=================");
        logger.info("Argument/Parameter : "+ Arrays.toString(proceedingJoinPoint.getArgs()));//<-파라미터
        logger.info("================[[END : "+proceedingJoinPoint.getSignature().getName()+"()]]==================");



        return proceedingJoinPoint.proceed();
    }



}
