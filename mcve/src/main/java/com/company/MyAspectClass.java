package com.company;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import rx.Single;

@Aspect
public class MyAspectClass {

    @Around("@annotation(myLogger) && execution(* *(..))")
    public Object performElfLogging(ProceedingJoinPoint pjp, MyLogger myLogger) throws Throwable {

        Object methodCall = pjp.proceed();

        Single<Response> single = (Single<Response>) methodCall;

        return single
                .doOnSubscribe(() -> System.out.println("doOnSubscribe within aspect: " + Thread.currentThread().getName()))
                .doOnUnsubscribe(() -> System.out.println("doOnSubscribe within aspect: " + Thread.currentThread().getName()));
    }
}
