package com.bruno.neighborhood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bruno.neighborhood.repository.NeighborhoodRepositoryImpl;

@Service
public class NeighborhoodService {

	@Autowired
	private NeighborhoodRepositoryImpl neighborhoodRepositoryImpl;
	

	public Page<Neighborhood> listNeighborhoodByFilter(NeighborhoodFilter neighborhoodFilter,Pageable pageable){
		return this.neighborhoodRepositoryImpl.listNeighborhoodByFilter(neighborhoodFilter,pageable);
	}
	
}
