package com.bruno.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.state.repository.StateRepositoryImpl;

@Service
public class StateService {
	
	@Autowired
	private StateRepositoryImpl stateRepositoryImpl;
	
	public List<State> listStateByFilter(StateFilter stateFilter) {
		return this.stateRepositoryImpl.listStateByFilter(stateFilter);
	}
	
}
