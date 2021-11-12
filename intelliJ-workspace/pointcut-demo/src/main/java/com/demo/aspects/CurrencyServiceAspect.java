package com.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class CurrencyServiceAspect {

    @Pointcut("@annotation(com.demo.annotations.InTransaction)")
    public void transactionAnnotationPointcut() {
    }

    @Pointcut("within(com.demo.bls.*)")
    public void blsPackagePointcut() {
    }

    @Pointcut("@within(com.demo.annotations.Secured)")
    public void securedClassPointcut() {
    }

    @Pointcut("bean(currency_service)")
    public void namedBeanPointcut(){
    }

//    @Before("transactionAnnotationPointcut()")
    public void beforeTransactionAnnotationAdvice(JoinPoint joinPoint) {
        System.out.println(" beforeTransactionAnnotationAdvice: " + joinPoint.getSignature() + " is invoked with : " + Arrays.toString(joinPoint.getArgs()));
    }

//    @Before("blsPackagePointcut()")
    public void beforeBlsPackageAdvice(JoinPoint joinPoint) {
        System.out.println(" beforeBlsPackageAdvice: " + joinPoint.getSignature() + " is invoked with : " + Arrays.toString(joinPoint.getArgs()));
    }

//    @Before("securedClassPointcut()")
    public void beforeSecuredClassAdvice(JoinPoint joinPoint) {
        System.out.println(" beforeSecuredClassAdvice: " + joinPoint.getSignature() + " is invoked with : " + Arrays.toString(joinPoint.getArgs()));
    }

//    @After("namedBeanPointcut()")
    public void afterNamedBeanAdvice(JoinPoint joinPoint) {
        System.out.println(" afterNamedBeanAdvice: " + joinPoint.getSignature() + " is invoked with : " + Arrays.toString(joinPoint.getArgs()));
    }

}
