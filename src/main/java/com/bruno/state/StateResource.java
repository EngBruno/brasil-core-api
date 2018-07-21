package com.bruno.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class StateResource {

	@Autowired
	private StateService stateService;
	
	@GetMapping
	public ResponseEntity<List<State>>listStateByFilter(StateFilter stateFilter){
	List<State> list = stateService.listStateByFilter(stateFilter);
	
	return (list!=null)? ResponseEntity.ok(list):ResponseEntity.notFound().build();
	
	}
	
}
