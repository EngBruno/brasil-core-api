package com.bruno.region.repository;

import java.util.List;

import com.bruno.region.Region;

public interface RegionRepository {
	public Region getRegionById(Long id);
	public List<Region> listRegion();
}
