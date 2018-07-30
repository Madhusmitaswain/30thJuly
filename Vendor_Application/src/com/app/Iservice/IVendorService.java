package com.app.Iservice;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorService {
	public int saveVendor(Vendor ven);
	public void updateVendor(Vendor ven);
	public void deleteVendor(int ven);
	public Vendor getVendorById(int venId);
	public List<Vendor> getAllVendor();
	public List<Object[]> getVenCountByLocName();
	public List<Object[]>getVendorTypeAndCount();
	
}
