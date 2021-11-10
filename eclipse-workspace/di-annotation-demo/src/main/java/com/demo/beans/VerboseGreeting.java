package com.demo.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.demo.beans.GreetingType.GreetingMode;

@Component()
@Primary
@GreetingType(GreetingMode.VERBOSE)
public class VerboseGreeting implements Greeting {

	@Override
	public String greet() {
		return "Hay! Mate! How're you doing?";
	}
}
