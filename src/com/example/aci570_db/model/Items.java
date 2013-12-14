package com.example.aci570_db.model;

import java.io.Serializable;

public class Items implements Serializable {
	
	public static final long serialVersionUID = 7526472295622776147L;
	
	private long id;
	private String nameItem;
	private String valorItem;
	private String	cantidad;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameItem() {
		return nameItem;
	}
	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}
	public String getValorItem() {
        return valorItem;
	}
	public void setValorItem(String valorItem) {
        this.valorItem = valorItem;
	}
	public String getCantidad() {
        return cantidad;
	}
	public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
	}
	
	@Override
	  public String toString() {
	    return this.nameItem + " " + this.valorItem;
	  }
}
