package com.neusoft.core.serviceBase;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class ServiceBase {
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

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(
			DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

}
