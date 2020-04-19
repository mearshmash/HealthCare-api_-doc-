package com.paf.healthcaresystm;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Doctor {
	
	
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Doctor [name=" + name + ", id=" + id + "]";
	}
	
}
