package com.neusoft.core.factory;

import org.springframework.context.ApplicationContext;

public class ServiceFactory {
	private static ApplicationContext applicationContext;
	
	public static Object getService(String serviceName){
		return applicationContext.getBean(serviceName);
	}
	
	public static Object getBean(String beanName){
		return getService(beanName);
	}
	
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	public static void setApplicationContext(ApplicationContext ac){
		applicationContext = ac;
	}
}
