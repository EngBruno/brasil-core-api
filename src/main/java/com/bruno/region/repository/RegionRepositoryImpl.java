package com.bruno.region.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.bruno.region.Region;

@Component
public class RegionRepositoryImpl implements RegionRepository{

	private final SqlSession sqlSession;
	
	public RegionRepositoryImpl(SqlSession sqlSession) {
	this.sqlSession = sqlSession;
	}
	
	@Override
	public Region getRegionById(Long id) {
		return this.sqlSession.selectOne("getRegionById", id);
	}

	@Override
	public List<Region> listRegion() {
		return this.sqlSession.selectList("listRegion");
	}

}
