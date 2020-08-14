package com.gura.spring05.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.cafe.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao {

	@Autowired
	private SqlSession session;

	@Override
	public List<CafeDto> getList(CafeDto dto) {
		List<CafeDto> list=session.selectList("cafe.getList", dto);
		return list;
	}

	@Override
	public int getCount(CafeDto dto) {
		
		return session.selectOne("cafe.getCount",dto);
	}

	@Override
	public boolean insert(CafeDto dto) {
		int insertNum=session.insert("cafe.insert",dto);
		if(insertNum>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public CafeDto getData(int num) {
		return session.selectOne("cafe.getData", num);
	}

	@Override
	public void addViewCount(int num) {
		 session.update("cafe.addViewCount",num);
	}

	@Override
	public void delete(int num) {
		 session.delete("cafe.delete",num);
	}

	@Override
	public boolean update(CafeDto dto) {
		 int updateNum=session.update("cafe.update", dto);
		 if(updateNum>0) {
			 return true;
		 }else {
			 return false;
		 }
	}

	@Override
	public CafeDto getData(CafeDto dto) {
		
		return session.selectOne("cafe.getData2",dto);
	}
	
}
