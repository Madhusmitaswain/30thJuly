package com.app.Iservice;

import java.util.List;

import com.app.model.Location;
import com.app.model.Vendor;

public interface ILocationservice {
	public int saveLocation(Location loc);
	public void updateLocation(Location loc);
	public void deleteLocation(int locId);
	public Location getLocationById(int locId);
	public List<Location> getAllLocation();
	public List<Object[]>getLocationTypeAndCount();
	
}
