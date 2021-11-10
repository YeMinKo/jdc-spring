package com.demo;

import com.demo.beans.SpringBean1;
import com.demo.beans.SpringBean2;
import com.demo.beans.SpringBean3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(lazyInit = true)
public class AppConfig {

    @Bean
    @Autowired
    public SpringBean1 springBean1(SpringBean2 springBean2, SpringBean3 app3) {
        return new SpringBean1(springBean2, app3);
    }

    @Bean
    public SpringBean2 springBean2() {
        return new SpringBean2();
    }

    @Bean({"app3", "spring3", "ttl3"})
    public SpringBean3 springBean3() {
        return new SpringBean3();
    }
}
