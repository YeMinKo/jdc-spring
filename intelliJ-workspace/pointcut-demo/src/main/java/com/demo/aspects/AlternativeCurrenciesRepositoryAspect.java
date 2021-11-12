package com.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AlternativeCurrenciesRepositoryAspect {

//    @Before("this(com.demo.bls.AlternativeCurrenciesRepository)")
    public void beforeThisCurrenciesRepository(JoinPoint joinPoint) {
        System.out.println("Before this(AlternativeCurrenciesRepository)::" + joinPoint.getSignature());
    }
}
