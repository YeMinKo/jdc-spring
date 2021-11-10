package com.demo.beans;

import org.springframework.stereotype.Component;

import com.demo.beans.GreetingType.GreetingMode;

@Component()
@GreetingType(GreetingMode.FORMAL)
public class FormalGreeting implements Greeting {

	@Override
	public String greet() {
		return "Hello! How are you?";
	}

}
