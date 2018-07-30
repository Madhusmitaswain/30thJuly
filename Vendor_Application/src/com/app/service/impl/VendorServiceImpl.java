package com.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Idao.IVendorDao;
import com.app.Iservice.IVendorService;
import com.app.model.Location;
import com.app.model.Vendor;
@Service
public class VendorServiceImpl implements IVendorService {
	@Autowired
	private IVendorDao dao;	

	@Override
	public int saveVendor(Vendor ven) {
		return dao.saveVendor(ven);
	}

	@Override
	public void updateVendor(Vendor ven) {
		dao.updateVendor(ven);

	}

	@Override
	public void deleteVendor(int ven) {
        dao.deleteVendor(ven);
	}

	@Override
	public Vendor getVendorById(int venId) {
		
		return dao.getVendorById(venId);
	}

	@Override
	public List<Vendor> getAllVendor() {
		List<Vendor> vens=dao.getAllVendor();
		Collections.sort(vens,new Comparator<Vendor>()
				{
			@Override
			public int compare(Vendor v1,Vendor v2)
			{
				return v1.getVenId() - v2.getVenId();
			}
				});
		return vens;
		
	}

	@Override
	public List<Object[]> getVenCountByLocName() {
		return dao.getVenCountByLocName();
	}

	@Override
	public List<Object[]> getVendorTypeAndCount() {
		
		return dao.getVendorTypeAndCount();
	}
	}


