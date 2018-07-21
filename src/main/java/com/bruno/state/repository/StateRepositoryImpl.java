package com.bruno.state.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.bruno.state.State;
import com.bruno.state.StateFilter;

@Component
public class StateRepositoryImpl implements StateRepository {

	private final SqlSession sqlSession;
	
	public StateRepositoryImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<State> listStateByFilter(StateFilter stateFilter) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
