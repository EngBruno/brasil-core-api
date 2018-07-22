package com.bruno.neighborhood.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.bruno.neighborhood.Neighborhood;
import com.bruno.neighborhood.NeighborhoodFilter;

@Component
public class NeighborhoodRepositoryImpl implements NeighborhoodRepository {

	private final SqlSession sqlSession;
	
	public NeighborhoodRepositoryImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public Page<Neighborhood> listNeighborhoodByFilter(NeighborhoodFilter neighborhoodFilter,Pageable pageable) {
		neighborhoodFilter.setPageNumber(pageable.getPageNumber());
		neighborhoodFilter.setPageSize(pageable.getPageSize());
		List<Neighborhood> list = this.sqlSession.selectList("listNeighborhoodByFilter", neighborhoodFilter);
		return new PageImpl<>(list, pageable, countNeighborhoodByFilter(neighborhoodFilter));
	}

	@Override
	public int countNeighborhoodByFilter(NeighborhoodFilter neighborhoodFilter) {
		int count = this.sqlSession.selectOne("countNeighborhoodByFilter", neighborhoodFilter);
		return count;
	}

}
