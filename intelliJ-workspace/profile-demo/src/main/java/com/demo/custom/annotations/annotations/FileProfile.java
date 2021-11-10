package com.demo.custom.annotations.annotations;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Profile("file")
@Retention(RetentionPolicy.RUNTIME)
public @interface FileProfile {
}
