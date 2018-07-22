package com.bruno.neighborhood.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bruno.neighborhood.Neighborhood;
import com.bruno.neighborhood.NeighborhoodFilter;

public interface NeighborhoodRepository {
	
	public Page<Neighborhood> listNeighborhoodByFilter(NeighborhoodFilter neighborhoodFilter,Pageable pageable);
	public int countNeighborhoodByFilter(NeighborhoodFilter neighborhoodFilter);
}
