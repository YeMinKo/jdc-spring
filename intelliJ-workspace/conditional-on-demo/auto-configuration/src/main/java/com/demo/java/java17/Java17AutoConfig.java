package com.demo.java.java17;

import com.demo.java.JavaEnvInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnJava(JavaVersion.SEVENTEEN)
public class Java17AutoConfig {

    @Bean
    public JavaEnvInfo javaEnvInfo() {
        return new Java17EnvInfo();
    }
}
