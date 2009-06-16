package com.neusoft.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.core.ResponseEnvelope;
import com.neusoft.core.actionBase.ActionBase;
import com.neusoft.hibernate.conf.dao.Menu;
import com.neusoft.spring.services.MenuService;
import com.neusoft.ui.tree.bean.TreeNode;
import com.neusoft.ui.tree.bean.TreeUtil;

public class MenuAction extends ActionBase{
	private MenuService menuService;
	public ActionForward loadMenu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		 if(log.isInfoEnabled()){
			 log.info("调用menuService,加载菜单");
		 }
		 menuService = (MenuService)getBean("menuService");
		response.setCharacterEncoding("UTF-8");
		ResponseEnvelope responseEnvelope = menuService.loadMenu(null);
		List list = (List)responseEnvelope.getParameter("menu");
		String temp = "";
		int k = list.size();
		for (Object o : list){
			temp +=((Menu)o).getId()+((Menu)o).getName()+((Menu)o).getDes();
		}
		// List list1 = new ArrayList();  
		 //list1.add( "first" );  
		 //list1.add( "second" );  
			TreeNode root = TreeUtil.getInstance().generateTree(list);
		 JSONArray jsonArray = JSONArray.fromObject( root );  
		response.getWriter().write(jsonArray.toString());
		return null;
	}
	public static void main(String[] args){
		 List list1 = new ArrayList();  
		 list1.add( "first" );  
		 list1.add( "second" );  
		 JSONArray jsonArray = JSONArray.fromObject( list1 );  
		 System.out.println(list1);
	}
}
