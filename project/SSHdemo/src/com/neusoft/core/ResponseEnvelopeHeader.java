package com.neusoft.core;

public class ResponseEnvelopeHeader {
	private String message;
	private String detalMessage;
	private int appCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDetalMessage() {
		return detalMessage;
	}
	public void setDetalMessage(String detalMessage) {
		this.detalMessage = detalMessage;
	}
	public int getAppCode() {
		return appCode;
	}
	public void setAppCode(int appCode) {
		this.appCode = appCode;
	}
	

}
