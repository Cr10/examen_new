package com.example.aci570_db.model;

import java.io.Serializable;

public class Items2 implements Serializable {
	
	public static final long serialVersionUID = 7526472295622776147L;
	
	private long id;
	private String nameItem2;
	private String valorItem2;
	private String	cantidad2;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameItem2() {
		return nameItem2;
	}
	public void setNameItem2(String nameItem2) {
		this.nameItem2 = nameItem2;
	}
	public String getValorItem2() {
        return valorItem2;
	}
	public void setValorItem2(String valorItem2) {
        this.valorItem2 = valorItem2;
	}
	public String getCantidad2() {
        return cantidad2;
	}
	public void setCantidad2(String cantidad2) {
        this.cantidad2 = cantidad2;
	}
	
	@Override
	  public String toString() {
	    return this.nameItem2 + " " + this.valorItem2 + " " + this.cantidad2;
	  }
}
