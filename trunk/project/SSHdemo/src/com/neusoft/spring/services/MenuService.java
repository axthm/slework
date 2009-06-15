package com.neusoft.spring.services;

import com.neusoft.core.RequestEnvelope;
import com.neusoft.core.ResponseEnvelope;

public interface MenuService {
	/**
	 * 加载菜单
	 * @param requestEnvelope
	 * @return
	 */
	public ResponseEnvelope loadMenu(RequestEnvelope requestEnvelope);

}
