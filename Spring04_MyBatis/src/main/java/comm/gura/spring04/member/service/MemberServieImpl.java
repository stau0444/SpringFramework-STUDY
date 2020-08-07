package comm.gura.spring04.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import comm.gura.spring04.member.dao.MemberDao;
import comm.gura.spring04.member.dto.MemberDto;

/*
 * 비지니스 로직을 처리할 서비스 클래스 정의
 */
@Service
public class MemberServieImpl implements MemberService{

	//의존객체 주입 받기
	@Autowired
	private MemberDao dao;
	//회원추가
	@Override
	public void addMember(MemberDto dto) {
		dao.insert(dto);
	}
	//회원정보수정
	@Override
	public void updateMember(MemberDto dto) {
		dao.update(dto);
	}
	//회원삭제
	@Override
	public void deleteMember(int num) {
		dao.delete(num);
	}
	//회원한명정보
	@Override
	public void getMember(int num, ModelAndView mView) {
		MemberDto dto=dao.getData(num);
		mView.addObject("dto", dto);
	}
	//회원목록
	@Override
	public void getList(ModelAndView mView) {
		List<MemberDto> list=dao.getList();
		mView.addObject("list", list);
	}

}
