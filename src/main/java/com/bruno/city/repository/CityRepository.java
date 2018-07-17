package com.bruno.city.repository;

import com.bruno.city.City;
import com.bruno.city.CityFilter;

public interface CityRepository {
	
	public City getCity(CityFilter cityFilter);
	
}
