package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//from ui
@Entity
@Table(name="custtab")
public class Customer {
@Id
@Column(name="cust_id")
private int custId;
@Column(name="cust_name")
private String custName;
@Column(name="cust_type")
private String custType;
@Column(name="cust_email")
private String custEmail;
@Column(name="cust_addr")
private String custAddr;
//auto generate
@Column(name="pwd")
private String password;//save in enc
private String custaccTock;////save in enc---deco
@ManyToOne
@JoinColumn(name="locIdFk")
private Location loc;
public Customer() {
	super();
}
public Customer(int custId) {
	super();
	this.custId = custId;
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getCustType() {
	return custType;
}
public void setCustType(String custType) {
	this.custType = custType;
}
public String getCustEmail() {
	return custEmail;
}
public void setCustEmail(String custEmail) {
	this.custEmail = custEmail;
}
public String getCustAddr() {
	return custAddr;
}
public void setCustAddr(String custAddr) {
	this.custAddr = custAddr;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCustaccTock() {
	return custaccTock;
}
public void setCustaccTock(String custaccTock) {
	this.custaccTock = custaccTock;
}
public Location getLoc() {
	return loc;
}
public void setLoc(Location loc) {
	this.loc = loc;
}
@Override
public String toString() {
	return "Customer [custId=" + custId + ", custName=" + custName + ", custType=" + custType + ", custEmail="
			+ custEmail + ", custAddr=" + custAddr + ", password=" + password + ", custaccTock=" + custaccTock
			+ ", loc=" + loc + "]";
}




}