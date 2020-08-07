package comm.gura.spring04.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comm.gura.spring04.member.dto.MemberDto;

//dao를 bean으로 만들기 위한 어노테이션
@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert",dto);
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update",dto);
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete",num);
	}

	@Override
	public MemberDto getData(int num) {
		
		
		MemberDto dto=session.selectOne("member.getData", num);
		return dto;
	}

	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list=session.selectList("member.getList");
		return list;
	}

}