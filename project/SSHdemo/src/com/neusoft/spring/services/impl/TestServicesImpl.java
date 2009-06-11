package com.neusoft.spring.services.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.neusoft.spring.services.TestService;

public class TestServicesImpl implements TestService {
	DataSourceTransactionManager transactionManager;
	public String test() {
		String result ;
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		
		result =  "spring test";
		transactionManager.commit(status);
		return result;
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService ts = (TestService)ctx.getBean("TestService");
		System.out.println(ts.test());
	}

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(
			DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
}
