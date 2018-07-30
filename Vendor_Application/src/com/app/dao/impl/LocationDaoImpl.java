package com.app.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.Idao.ILocationDao;
import com.app.model.Location;

@Repository
public class LocationDaoImpl implements ILocationDao {

	@Autowired
	private HibernateTemplate ht;

	public int saveLocation(Location loc) {
		return (Integer) ht.save(loc);

	}

	@Override
	public void updateLocation(Location loc) {
		ht.update(loc);
	}

	@Override
	public void deleteLocation(int locId) {
		Location location = new Location();
		location.setLocId(locId);
		ht.delete(location);

	}

	@Override
	public Location getLocationById(int locId) {
		Location location = ht.get(Location.class, locId);

		return location;
	}

	@Override
	public List<Location> getAllLocation() {
		List<Location> locations = ht.loadAll(Location.class);
		return locations;
	}

	@Override
	public List<Object[]> getLocationTypeAndCount() {
		String hql="select locType,count(locId) "+"from " +Location.class.getName()+" group by locType";
				
		List<Object[]> locTypeCount=ht.find(hql);
		return locTypeCount;
	}

}
