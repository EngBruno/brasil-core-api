package com.bruno.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.region.repository.RegionRepositoryImpl;

@Service
public class RegionService {
	
	@Autowired
	private RegionRepositoryImpl regionRepositoryImpl;
	
	public Region getRegionById(Long id) {
		return this.regionRepositoryImpl.getRegionById(id);
	}
	
	public List<Region> listRegion(){
		return this.regionRepositoryImpl.listRegion();
	}
}
