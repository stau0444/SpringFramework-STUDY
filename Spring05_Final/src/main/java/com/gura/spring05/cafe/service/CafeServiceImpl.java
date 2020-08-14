package com.gura.spring05.cafe.service;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dao.CafeDao;
import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.exception.NotDeleteException;
import com.gura.spring05.file.dto.FileDto;
import com.gura.spring05.users.dao.UsersDao;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeDao cafeDao;
	@Autowired
	private UsersDao usersDao;
	//한 페이지에 나타낼 row 의 갯수
	final int PAGE_ROW_COUNT=5;
	//하단 디스플레이 페이지 갯수
	final int PAGE_DISPLAY_COUNT=5;
	
	@Override
	public void getList(HttpServletRequest request, ModelAndView mView) {
		
		String id=(String)request.getSession().getAttribute("id");
 		
 		//보여줄 페이지의 번호
 		int pageNum=1;
 		//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어와 본다.	
 		String strPageNum=request.getParameter("pageNum");
 		
 		if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
 			//페이지 번호를 설정한다.
 			pageNum=Integer.parseInt(strPageNum);
 		}
 		//보여줄 페이지 데이터의 시작 ResultSet row 번호
 		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
 		//보여줄 페이지 데이터의 끝 ResultSet row 번호
 		int endRowNum=pageNum*PAGE_ROW_COUNT;
 		
		
 		/*
 			검색 키워드에 따른 페이징 처리
 		*/
 		String keyword=request.getParameter("keyword");
 		String condition=request.getParameter("condition");
 		
 		if(keyword==null){
 			keyword="";
 			condition="";
 			
 		}
 			
 			String encodedK=URLEncoder.encode(keyword);
 		
 		
 		//검색 키워드와 startRowNum,endRowNum 을 담을 FileDto 객체 생성
 		CafeDto dto= new CafeDto();
 		dto.setStartRowNum(startRowNum);
 		dto.setEndRowNum(endRowNum);
 		
 		if(!keyword.equals("")){//키워드가 있다면
 			if(condition.equals("title_content")){
 				//검색 키워드를 FileDto 객체의 필드에 담는다.
 				dto.setTitle(keyword);
 				dto.setContent(keyword);
 			}else if(condition.equals("title")){
 				dto.setTitle(keyword);
 			}else if(condition.equals("writer")){
 				dto.setWriter(keyword);
 			}
 		}
 		//파일 목록 얻어오기
 		List<CafeDto> list =cafeDao.getList(dto);
 		//전체 ROW의 갯수 구하기 //검색키워드가 dto에 있는지 없는지에 따라 동적쿼리가 작동한다.  
 		int totalRow=cafeDao.getCount(dto);
 		//전체 페이지의 갯수 구하기
 		//(double) 쓰는 이유 정수로 나누면 소수점이 안 나옴으로 올림을 할 수 없다.
 		int totalPageCount=
 				(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
 		//시작 페이지 번호
 		int startPageNum=
 			1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
 		//끝 페이지 번호
 		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
 		//끝 페이지 번호가 잘못된 값이라면 
 		if(totalPageCount < endPageNum){
 			endPageNum=totalPageCount; //보정해준다. 
 		}
 		//jstl에서 사용할 list를 request에 담는다
 		request.setAttribute("list", list);
 		
 		//jstl에서 사용할 변수들을 request에 담는다.
 		request.setAttribute("startPageNum", startPageNum);
 		request.setAttribute("endPageNum", endPageNum);
 		request.setAttribute("pageNum", pageNum);
 		request.setAttribute("totalPageCount", totalPageCount);
 		request.setAttribute("condition", condition);
 		request.setAttribute("keyword", keyword);
 		request.setAttribute("encodedK", encodedK);
	}

	@Override
	public void addContent(CafeDto dto, ModelAndView mView) {
		boolean isSuccess=cafeDao.insert(dto);
		mView.addObject("isSuccess", isSuccess);
	}

	@Override
	public void getContentInfo(HttpServletRequest request, ModelAndView mView) {
		
		int num=Integer.parseInt(request.getParameter("num"));
		//보여줄 페이지의 번호
 		int pageNum=1;
 		//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어와 본다.	
 		String strPageNum=request.getParameter("pageNum");
 		
 		if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
 			//페이지 번호를 설정한다.
 			pageNum=Integer.parseInt(strPageNum);
 		}
 		//보여줄 페이지 데이터의 시작 ResultSet row 번호
 		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
 		//보여줄 페이지 데이터의 끝 ResultSet row 번호
 		int endRowNum=pageNum*PAGE_ROW_COUNT;
 		
		
 		/*
 			검색 키워드에 따른 페이징 처리
 		*/
 		String keyword=request.getParameter("keyword");
 		String condition=request.getParameter("condition");
 		
 		if(keyword==null){
 			keyword="";
 			condition="";
 			
 		}
 			
 			String encodedK=URLEncoder.encode(keyword);
 		
 		
 		//글번호와 검색 키워드를 담을 CafeDto 객체
 		CafeDto dto= new CafeDto();
 		dto.setNum(num);
 		
 		if(!keyword.equals("")){//키워드가 있다면
 			if(condition.equals("title_content")){
 				//검색 키워드를 FileDto 객체의 필드에 담는다.
 				dto.setTitle(keyword);
 				dto.setContent(keyword);
 			}else if(condition.equals("title")){
 				dto.setTitle(keyword);
 			}else if(condition.equals("writer")){
 				dto.setWriter(keyword);
 			}
 		}
 		//자세히 보기 글정보 
 		cafeDao.addViewCount(num);
 		CafeDto resultDto=cafeDao.getData(dto);
		mView.addObject("dto", resultDto);
		mView.addObject("keyword", keyword);
		mView.addObject("condition", condition);
		mView.addObject("encodedK", encodedK);
	}

	@Override
	public void update(CafeDto dto, ModelAndView mView) {
		boolean isSuccess=cafeDao.update(dto);
		mView.addObject("num",dto.getNum());
		mView.addObject("isSuccess",isSuccess);
	}

	@Override
	public void delete(HttpServletRequest request,int num) {
		CafeDto dto=cafeDao.getData(num);
		String writer=dto.getWriter();
		String id=(String) request.getSession().getAttribute("id");
		if(!writer.equals(id)) {
			int warnNum=usersDao.getData(id).getWarnNum();
			System.out.println(warnNum+id);
			if(warnNum>3) {
				usersDao.delete(id);
				request.getSession().invalidate();
			}
			usersDao.updateWarnNum(id);
			throw new NotDeleteException("죽인다 남은기회"+warnNum);
			
		}
			cafeDao.delete(num);
		
	}
}
