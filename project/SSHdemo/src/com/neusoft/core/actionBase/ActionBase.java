package com.neusoft.core.actionBase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.hibernate.conf.dao.DeptDAO;

public class ActionBase extends DispatchAction {
	 Log log = LogFactory.getLog(this.getClass());
}
