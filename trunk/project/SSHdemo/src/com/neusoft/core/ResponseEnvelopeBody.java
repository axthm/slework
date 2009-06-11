package com.neusoft.core;

import java.util.HashMap;

public class ResponseEnvelopeBody<K,V> implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4780998934582316014L;
	/**
	 * 存储空间
	 */
	private HashMap<K, V> hashMap = new HashMap<K, V>();

	public HashMap<K, V> getHashMap() {
		return hashMap;
	}

	
	public void add(K key, V value){
		this.hashMap.put(key, value);
	}
	
	public V get(Object key){
		return  this.hashMap.get(key);
		
	}
	
}
