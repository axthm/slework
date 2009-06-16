package com.neusoft.core.actionBase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.core.factory.ServiceFactory;

public class ActionBase extends DispatchAction {
	protected static Log log = LogFactory.getLog(ActionBase.class);

	protected Object getBean(String beanid) {
		Object result = null;
		result = ServiceFactory.getBean(beanid);
		if (result == null) {
			if (log.isInfoEnabled()) {
				log.info("没有找到bean");
			}
			throw new RuntimeException("没有找到bean");
		}
		return result;
	}
}
