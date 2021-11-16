package com.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class CurrencyServiceAspect {

    @Pointcut("@annotation(com.demo.annotations.InTransaction)")
    public void transactionAnnotationPointcut() {}

    @Pointcut("within(com.demo.bls.*)")
    public void blsPackagePointcut() {}

    @Pointcut("@within(com.demo.annotations.Secured)")
    public void securedClassPointcut() {}

    @Pointcut("bean(currency_service)")
    public void namedBeanPointcut(){}


    @Pointcut("execution(* com.demo.bls.CurrencyService.getExchangeRate(..))")
    public void getExchangeRateMethodPointcut() {}

    @Pointcut("args(String, String, int)")
    public void stringAndIntegerArgumentsMethodPointcut() {}

    @Pointcut("@args(com.demo.annotations.Validated)")
    public void validateArgumentPointcut() {}

    @Pointcut("@target(com.demo.annotations.Secured)")
    public void currencyServiceSecuredTargetPointcut() {}

    @Pointcut("blsPackagePointcut() && transactionAnnotationPointcut()")
    public void blsPackageAndInTransactionPointcut() {}

//    @After("currencyServiceSecuredTargetPointcut()")
    public void afterCurrencyServiceSecuredTarget(JoinPoint joinPoint) {
        System.out.println(" afterCurrencyServiceSecuredTarget: " + joinPoint.getSignature() + " is invoked with : " + Arrays.toString(joinPoint.getArgs()));
    }

//    @After("blsPackageAndInTransactionPointcut()")
    public void afterBlsPackageAndInTransactionAdvice(JoinPoint joinPoint) {
        System.out.println(" afterBlsPackageAndInTransactionAdvice: " + joinPoint.getSignature() + " is invoked with : " + Arrays.toString(joinPoint.getArgs()));
    }

//    @After("stringAndIntegerArgumentsMethodPointcut()")
    public void afterStringAndIntegerArgumentsMethodAdvice(JoinPoint joinPoint) {
        System.out.println(" afterStringAndIntegerArgumentsMethodAdvice: " + joinPoint.getSignature() + " is invoked with : " + Arrays.toString(joinPoint.getArgs()));
    }

//    @After("validateArgumentPointcut()")
    public void afterValidatedArgumentAdvice(JoinPoint joinPoint) {
        System.out.println(" afterValidatedArgumentAdvice: " + joinPoint.getSignature() + " is invoked with : " + Arrays.toString(joinPoint.getArgs()));
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

//    @Around("getExchangeRateMethodPointcut()")
    public Object aroundGetExchangeRateMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        try {
            System.out.println("Before:::aroundGetExchangeRateMethodAdvice" + proceedingJoinPoint.getSignature());
            return proceedingJoinPoint.proceed();
        }  finally {
            System.out.println("After:::aroundGetExchangeRateMethodAdvice");
        }

    }

//    @AfterThrowing(value = "execution(* com.demo.bls.CurrencyService.getCurrencyCountryName(..))", throwing = "exception")
    public void afterThrowingException(Exception exception) {
        System.out.println("Exception was thrown from getCurrencyCounctyName: " + exception.getClass().getSimpleName());
    }

//    @AfterReturning(value = "execution(* com.demo.bls.CurrencyService.getCurrencyCountryName(..))", returning = "value")
    public void afterReturningAdvice(String value) {
        System.out.println("Value returned from getCurrencyCountryName: " + value);
    }
}
