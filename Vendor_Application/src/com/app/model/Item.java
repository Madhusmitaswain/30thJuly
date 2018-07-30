package com.app.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/*@ElementCollection
@CollectionTable(name="emp_data", //table
joinColumns=@JoinColumn(name="eidFk")) //key col
@OrderColumn(name="pos") //index col
@Column(name="prjs") //element col
private List<String> data=new ArrayList<String>(0);*/

@Entity
@Table(name="item_tab")
public class Item {
	@Id
	@Column(name="item_id")
	private int itemId;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_code")	
	private String itemCode;
	@Column(name="item_mrp")	
	private double itemMrp;
	@Column(name="item_discount")	
	private double maxDiscount;
	@Column(name="item_mfg")	
	private String itemMfg;
	//@Column(name="item_models")
	//@ElementCollection
	
	//private List<String> models;
	//private String models;
	@Column(name="cust_id")
	private int custId;
	
	
	public Item() {
		super();
	}
	public int getItemId() {
		return itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public double getItemMrp() {
		return itemMrp;
	}
	public void setItemMrp(double itemMrp) {
		this.itemMrp = itemMrp;
	}
	public double getMaxDiscount() {
		return maxDiscount;
	}
	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	public String getItemMfg() {
		return itemMfg;
	}
	public void setItemMfg(String itemMfg) {
		this.itemMfg = itemMfg;
	}
	/*public List<String> getModels() {
		return models;
	}
	public void setModels(List<String> models) {
		this.models = models;
	}*/
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCode=" + itemCode + ", itemMrp=" + itemMrp
				+ ", maxDiscount=" + maxDiscount + ", itemMfg=" + itemMfg + ",  custId=" + custId
				+ "]";
	}
	

}
