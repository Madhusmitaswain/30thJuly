package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ventab")
public class Vendor {
@Id
@Column(name="vid")
private int venId;
@Column(name="vcode")
private String venCode;
@Column(name="vname")
private String venName;
@Column(name="vtype")
private String venType;
@Column(name="vaddr")
private String  addr;
@Column(name="vidtype")
private String idType;
@Column(name="vidnum")
private String idNum;
@Column(name="vdsc")
private String dsc;
@ManyToOne
@JoinColumn(name="locIdFk")
private Location loc;
public Vendor() {
	super();
}

public Vendor(int venId) {
	super();
	this.venId = venId;
}

public int getVenId() {
	return venId;
}

public void setVenId(int venId) {
	this.venId = venId;
}

public String getVenCode() {
	return venCode;
}

public void setVenCode(String venCode) {
	this.venCode = venCode;
}

public String getVenName() {
	return venName;
}

public void setVenName(String venName) {
	this.venName = venName;
}

public String getVenType() {
	return venType;
}

public void setVenType(String venType) {
	this.venType = venType;
}

public String getAddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}

public String getIdType() {
	return idType;
}

public void setIdType(String idType) {
	this.idType = idType;
}

public String getIdNum() {
	return idNum;
}

public void setIdNum(String idNum) {
	this.idNum = idNum;
}

public String getDsc() {
	return dsc;
}

public void setDsc(String dsc) {
	this.dsc = dsc;
}

public Location getLoc() {
	return loc;
}

public void setLoc(Location loc) {
	this.loc = loc;
}

@Override
public String toString() {
	return "Vendor [venId=" + venId + ", venCode=" + venCode + ", venName=" + venName + ", venType=" + venType
			+ ", addr=" + addr + ", idType=" + idType + ", idNum=" + idNum + ", dsc=" + dsc + ", loc=" + loc + "]";
}



}
