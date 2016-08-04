package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Debug {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/aopContext.xml");
		IBaseBusiness business = (IBaseBusiness) context
				.getBean("businessProxy");
		business.delete("è");
	}

}