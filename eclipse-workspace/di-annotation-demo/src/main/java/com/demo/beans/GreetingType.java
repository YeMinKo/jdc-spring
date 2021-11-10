package com.demo.beans;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
@Retention(RUNTIME)
public @interface GreetingType {

	GreetingMode value();

	enum GreetingMode {
		FORMAL, VERBOSE
	}
}
