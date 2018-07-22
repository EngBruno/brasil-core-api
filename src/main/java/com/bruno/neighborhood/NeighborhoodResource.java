package com.bruno.neighborhood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bairros")
public class NeighborhoodResource {
	
	@Autowired
	private NeighborhoodService neighborhoodService;
	
	@GetMapping
	public Page<Neighborhood> listNeighborhoodByFilter(NeighborhoodFilter neighborhoodFilter,Pageable pageable){
		return neighborhoodService.listNeighborhoodByFilter(neighborhoodFilter,pageable);
	}
	
}
