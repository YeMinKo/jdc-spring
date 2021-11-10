package com.demo.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.beans.GreetingType.GreetingMode;

@Component
public class SpringBean1 {

	private SpringBean2 springBean2;

	private SpringBean3 springBean3;

	@Autowired
	@GreetingType(GreetingMode.VERBOSE)
//	@Qualifier("verbose")
	private Greeting greeting;

//	@Autowired // because we have 2 constructors (if 1 no need @Autowired)
	public SpringBean1(final SpringBean2 springBean2, final SpringBean3 springBean3) {
		super();
		this.springBean2 = springBean2;
		this.springBean3 = springBean3;
	}
//
//	public SpringBean1() {
//		System.out.println(getClass().getSimpleName() + "::constructor");
//	}

//	@Autowired
//	public void setSpringBean2(SpringBean2 springBean2) {
//		this.springBean2 = springBean2;
//	}
//
//	@Autowired
//	public void setSpringBean3(SpringBean3 springBean3) {
//		this.springBean3 = springBean3;
//	}

	@PostConstruct
	public void init() {
		System.out.println(String.format("%s postConstruct with %s and %s", getClass().getSimpleName(),
				springBean2.getClass().getSimpleName(), springBean3.getClass().getSimpleName()));
	}

	public void sayHello() {
		System.out.println(greeting.greet());
	}
}
