package com.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean3 {

    @Value("${app.name}")
    private String appName;

    @Value("${app.envid}")
    private int appId;

    @Value("${external.service}")
    private String externalService;

    public SpringBean3() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Prototype Bean");
    }

    public void printProperties() {
        System.out.println("app.name =" + appName);
        System.out.println("app.envid =" + appId);
        System.out.println("external.service  =" + externalService);
    }
}
