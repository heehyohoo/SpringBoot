package com.example.jpacalendarpractice03.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.w3c.dom.ls.LSOutput;

import javax.servlet.http.HttpSession;


@Aspect  // AOP 객체라는 말이다.
@Component
public class LoginAop {



//    @Pointcut("execution(* com.example.jpacalendarpractice03.controller.*ScheduleController.*(..))")
//    public void cut() {
//
//    }
    @Pointcut("execution(* com.example.jpacalendarpractice03.page.controller.PageController.logout(..))")
    public void cut2() {

    }

//    @Around("cut()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
//
//        if (session.getAttribute("email") == null) { // 로그인을 했을때
//            return 0;
//        } else { // 로그인을 안했을때
//            return joinPoint.proceed();
//        }
//    }


    @Around("cut2()")
    public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

        if (session.getAttribute("email") == null) { // 로그인을 했을때
            return "redirect:/";
        } else { // 로그인을 안했을때
            return joinPoint.proceed();
        }
    }
}



