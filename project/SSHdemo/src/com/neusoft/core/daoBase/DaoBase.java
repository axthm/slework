package com.neusoft.core.daoBase;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class DaoBase{
	
	DataSourceTransactionManager transactionManager;
	TransactionStatus status;
	
	public void begin(){
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		 status = transactionManager.getTransaction(def);
	}
	
	public void rollback(){
		transactionManager.rollback(status);
	}
	public void commit(){
		transactionManager.commit(status);
	}
}
