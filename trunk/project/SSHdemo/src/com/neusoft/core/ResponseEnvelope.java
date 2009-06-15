package com.neusoft.core;
/**
 * 响应的信封
 * @author lichen6928
 *
 * @param <K>
 * @param <V>
 */
public class ResponseEnvelope<K, V> implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResponseEnvelopeHeader responseEnvelopeHeader;
	private ResponseEnvelopeBody<K, V> responseEnvelopeBody;
	
	public ResponseEnvelope(){
		this.responseEnvelopeBody = new ResponseEnvelopeBody<K, V>();
		this.responseEnvelopeHeader  = new ResponseEnvelopeHeader();
	}

	public ResponseEnvelopeHeader getResponseEnvelopeHeader() {
		return responseEnvelopeHeader;
	}

	public ResponseEnvelopeBody<K, V> getResponseEnvelopeBody() {
		return responseEnvelopeBody;
	}
	
	public void setParameter(K key, V value){
		this.responseEnvelopeBody.add(key, value);
	}
	
	public V getParameter(K key){
		return this.responseEnvelopeBody.get(key);
	}
	public String getMessage() {
		return responseEnvelopeHeader.getMessage();
	}
	public void setMessage(String message) {
		responseEnvelopeHeader.setMessage(message);
	}
	public String getDetalMessage() {
		return responseEnvelopeHeader.getDetalMessage();
	}
	public void setDetalMessage(String detalMessage) {
		responseEnvelopeHeader.setDetalMessage(detalMessage);
	}
	public int getAppCode() {
		return responseEnvelopeHeader.getAppCode();
	}
	public void setAppCode(int appCode) {
		responseEnvelopeHeader.setAppCode(appCode);
	}

}

