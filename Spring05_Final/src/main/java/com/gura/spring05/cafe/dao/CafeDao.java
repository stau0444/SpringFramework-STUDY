package com.gura.spring05.cafe.dao;

import java.util.List;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeDao {
	//글목록
	public List<CafeDto> getList(CafeDto dto);
	//글 갯수
	public int getCount(CafeDto dto);	
	//글 추가
	public boolean insert(CafeDto dto);
	//키워드를 활용한 글 정보 얻어오기
	public CafeDto getData(CafeDto dto);
	//글 정보
	public CafeDto getData(int num);
	//조회수 증가 시키기
	public void addViewCount(int num);
	//글 삭제
	public void delete(int num);
	//글 수정
	public boolean update(CafeDto dto);
}
