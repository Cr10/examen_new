package com.example.aci570_db.model;

import java.io.Serializable;

public class Molist4  implements Serializable {
	
	public static final long serialVersionUID = 7526472295622776147L;
	
	private long id;
	private String nameList4;
	private String valorList4;
	private String	cantidadList4;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameList4() {
		return nameList4;
	}
	public void setNameList4(String nameList4) {
		this.nameList4 = nameList4;
	}
	public String getValorList4() {
        return valorList4;
	}
	public void setValorList4(String valorList4) {
        this.valorList4 = valorList4;
	}
	public String getCantidadList4() {
        return cantidadList4;
	}
	public void setCantidadList4(String cantidadList4) {
        this.cantidadList4 = cantidadList4;
	}
	
	@Override
	  public String toString() {
	    return this.nameList4 + " " + this.valorList4 + " " + this.cantidadList4;
	  }
}
