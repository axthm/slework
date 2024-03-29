package com.neusoft.spring.services.impl;

import java.util.List;

import com.neusoft.core.GlobalParam;
import com.neusoft.core.RequestEnvelope;
import com.neusoft.core.ResponseEnvelope;
import com.neusoft.core.serviceBase.ServiceBase;
import com.neusoft.hibernate.conf.dao.MenuDAO;


public class MenuServiceImpl extends ServiceBase implements
		com.neusoft.spring.services.MenuService {
	private MenuDAO menuDAO;
	public ResponseEnvelope loadMenu(RequestEnvelope requestEnvelope) {
		ResponseEnvelope responseEnvelope = new ResponseEnvelope();
		try{
			this.begin();
			List menus = menuDAO.findAll();
			
			responseEnvelope.setParameter("menu", menus);
			responseEnvelope.setAppCode(GlobalParam.APP_CODE_SUCCESS);
			this.commit();
		}catch(Exception e){
			responseEnvelope.setAppCode(GlobalParam.APP_CODE_EXCEPTION);
			responseEnvelope.setMessage("加载菜单错误");
			responseEnvelope.setDetalMessage("加载菜单错误"+e.getMessage());
			this.rollback();
		}
		return responseEnvelope;
	}
	public MenuDAO getMenuDAO() {
		return menuDAO;
	}
	public void setMenuDAO(MenuDAO menuDao) {
		this.menuDAO = menuDao;
	}

}
