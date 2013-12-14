package com.example.aci570_db.model;

import java.io.Serializable;

public class Person implements Serializable {
	
	public static final long serialVersionUID = 7526472295622776147L;
	
	private long id;
	private String firstName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	@Override
	  public String toString() {
	    return this.firstName + " " ;
	  }
}
