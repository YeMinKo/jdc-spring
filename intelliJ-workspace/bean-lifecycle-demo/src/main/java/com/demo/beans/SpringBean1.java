package com.demo.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringBean1 implements InitializingBean, DisposableBean {

    private SpringBean2 springBean2;

    public SpringBean1() {
        System.out.println("Creating : " + getClass().getSimpleName());
    }

    @Autowired
    public void setSpringBean2(SpringBean2 springBean2) {
        System.out.println("setting property on : " + getClass().getSimpleName() + " to inject " + springBean2.getClass().getSimpleName());
        this.springBean2 = springBean2;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct " + getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy " + getClass().getSimpleName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean::afterPropertiesSet " + getClass().getSimpleName());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean::destroy " + getClass().getSimpleName());
    }

    private void initMethod() {
        System.out.println("Custom @Bean(initMethod) " + getClass().getSimpleName());
    }

    private void destroyMethod() {
        System.out.println("Custom @Bean(destroyMethod) " + getClass().getSimpleName());
    }

    public void greeting() {
        System.out.println("Hello");
    }
}
