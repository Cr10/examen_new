package com.example.aci570_db.model;

import java.io.Serializable;

public class Molist3  implements Serializable {
	
	public static final long serialVersionUID = 7526472295622776147L;
	
	private long id;
	private String nameList3;
	private String valorList3;
	private String	cantidadList3;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameList3() {
		return nameList3;
	}
	public void setNameList3(String nameList3) {
		this.nameList3 = nameList3;
	}
	public String getValorList3() {
        return valorList3;
	}
	public void setValorList3(String valorItem) {
        this.valorList3 = valorItem;
	}
	public String getCantidadList3() {
        return cantidadList3;
	}
	public void setCantidadList3(String cantidadList3) {
        this.cantidadList3 = cantidadList3;
	}
	
	@Override
	  public String toString() {
	    return this.nameList3 + " " + this.valorList3 + " " + this.cantidadList3;
	  }
}
