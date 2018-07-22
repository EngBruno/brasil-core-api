package com.bruno.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regiao")
public class RegionResource {

	@Autowired
	private RegionService regionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Region> getRegionById(@PathVariable Long id){
		Region region = this.regionService.getRegionById(id);
		return (region!=null)? ResponseEntity.ok(region):ResponseEntity.notFound().build();
	}
	
	
	@GetMapping
	public List<Region> lisRegionById(){
		return this.regionService.listRegion();
	}
}
