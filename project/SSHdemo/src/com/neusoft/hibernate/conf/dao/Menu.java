package com.neusoft.hibernate.conf.dao;

/**
 * Menu entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String location;
	private String module;
	private String des;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(Long id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	/** full constructor */
	public Menu(Long id, String name, String location, String module, String des) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.module = module;
		this.des = des;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}