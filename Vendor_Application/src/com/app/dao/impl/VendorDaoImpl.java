package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.Idao.IVendorDao;
import com.app.model.Location;
import com.app.model.Vendor;
@Repository
public class VendorDaoImpl implements IVendorDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveVendor(Vendor ven) {
		return (Integer) ht.save(ven);
	}

	@Override
	public void updateVendor(Vendor ven) {
		ht.update(ven);
	}

	@Override
	public void deleteVendor(int ven) {
		Vendor vendor = new Vendor();
		vendor.setVenId(ven);
		ht.delete(vendor);

	}

	@Override
	public Vendor getVendorById(int venId) {
		Vendor vendor = ht.get(Vendor.class, venId);
		return vendor;
	}

	@Override
	public List<Vendor> getAllVendor() {
		List<Vendor> vendors = ht.loadAll(Vendor.class);
		return vendors;
	}
	@Override
	public List<Object[]> getVenCountByLocName() {
		String hql= " select loc.locName,count(loc.locName) " +
					" from com.app.model.Vendor ven " +
					" inner join " +
					" ven.loc as loc " +
					" group by loc.locName ";
		List<Object[]> vens=ht.find(hql);
		return vens;
	}

	@Override
	public List<Object[]> getVendorTypeAndCount() {
		String hql="select venType,count(venId) "+"from " +Vendor.class.getName()+" group by venType";
		
		List<Object[]> venTypeCount=ht.find(hql);
		return venTypeCount;
	}

}
