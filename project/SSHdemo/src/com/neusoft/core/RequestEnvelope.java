package com.neusoft.core;

public class RequestEnvelope<K, V> implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequestEnvelopeHeader requestEnvelopeHeader;
	private RequestEnvelopeBody<K, V> requestEnvelopeBody;
	
	public RequestEnvelope(){
		this.requestEnvelopeBody = new RequestEnvelopeBody<K, V>();
		this.requestEnvelopeHeader  = new RequestEnvelopeHeader();
	}

	public RequestEnvelopeHeader getRequestEnvelopeHeader() {
		return requestEnvelopeHeader;
	}

	public RequestEnvelopeBody<K, V> getRequestEnvelopeBody() {
		return requestEnvelopeBody;
	}
	
	public void setParameter(K key, V value){
		this.requestEnvelopeBody.add(key, value);
	}
	
	public V getParameter(K key){
		return this.requestEnvelopeBody.get(key);
	}

}
