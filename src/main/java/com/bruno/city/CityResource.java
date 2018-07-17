package com.bruno.city;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityResource {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/{id}")
	public ResponseEntity<City> getCity(@PathVariable(name="id", required=true) @Range(min=1) Long id){
		
		CityFilter cityFilter = new CityFilter();
		cityFilter.setId(id);
		
		City city = cityService.getCityByFilter(cityFilter);
		
		return (city!=null) ? ResponseEntity.ok(city):ResponseEntity.notFound().build();
	}
	
}
