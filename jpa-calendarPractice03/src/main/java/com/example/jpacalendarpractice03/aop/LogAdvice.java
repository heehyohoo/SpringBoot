package com.example.jpacalendarpractice03.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


@Component
@Aspect
public class LogAdvice {

    //powershell 실시간 보기
    //Get-Content "C:\WorkSpace\boot\jpa-calendarPractice03\src\main\resources\logs\now-logFile.log" -Wait -Tail 10

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(" execution(* com.example.jpacalendarpractice03.controller..*Controller.*(..))"+
            "|| execution(* com.example.jpacalendarpractice03.service..*Service*.*(..))"+
            "|| execution(* com.example.jpacalendarpractice03.repository..*Repository.*(..))")
    public Object logAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName(); // 클래스명
        String methodName = proceedingJoinPoint.getSignature().getName(); // 메소드명
        String parameters = Arrays.toString(proceedingJoinPoint.getArgs()); // 파라미터

        logger.info("================[[start]]================");
        logger.info(""+className+"."+methodName+"() CALLED");
        logger.info("PARAMETERS : " +parameters);
        logger.info("================[[end]]================");

        return proceedingJoinPoint.proceed();
    }
}
