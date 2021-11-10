package com.demo;

import com.demo.beans.SpringBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public SpringBean1 springBean1() {
        return new SpringBean1();
    }

    @Bean
    public static CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }

    @Bean
    public static CustomBeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }
}
