package com.bruno.city.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.bruno.city.City;
import com.bruno.city.CityFilter;

@Component
public class CityRepositoryImpl implements CityRepository{

	private final SqlSession sqlSession;
	
	public CityRepositoryImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public City getCity(CityFilter cityFilter) {
		return sqlSession.selectOne("getCityByFilter", cityFilter);
	}

}
