package com.bruno.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.city.repository.CityRepositoryImpl;

@Service
public class CityService {

	@Autowired
	private CityRepositoryImpl cityRepositoryImpl;
	
	public City getCityByFilter(CityFilter cityFilter) {
		return cityRepositoryImpl.getCity(cityFilter);
	}
	
}
