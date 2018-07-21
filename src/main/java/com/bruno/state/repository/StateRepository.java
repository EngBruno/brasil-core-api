package com.bruno.state.repository;

import java.util.List;

import com.bruno.state.State;
import com.bruno.state.StateFilter;

public interface StateRepository {
	public List<State> listStateByFilter(StateFilter stateFilter);
}
