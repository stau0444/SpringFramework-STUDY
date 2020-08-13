package com.gura.spring05.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.file.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao{
	@Autowired
	private SqlSession session;
	
	public List<FileDto> getList(FileDto dto){
		List<FileDto> list=session.selectList("file.getList",dto);
		return list;
	}
	//검색 키워드에  맞는 row의 갯수를 리턴하는 메소드
	@Override
	public int getCount(FileDto dto) {
		return session.selectOne("file.getCount",dto);
	}
	@Override
	public void insert(FileDto dto) {
		session.insert("file.insert",dto);
	}
	//인자로 전달되는 int를 이용하여 해당 파일 정보를 가져옴 
	@Override
	public FileDto getData(int num) {
		return session.selectOne("file.getData",num);
	}
	@Override
	public boolean delete(int num) {
		int isDelete=session.delete("file.delete",num);
		if(isDelete<0) {
			return false;
		}else {
			return true;
		}
	}
}
