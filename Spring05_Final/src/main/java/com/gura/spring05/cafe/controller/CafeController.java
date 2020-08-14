package com.gura.spring05.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {

	@Autowired
	private CafeService cafeService;
	
	//글목록 처리
	@RequestMapping("/cafe/list")
	public ModelAndView list(HttpServletRequest request,ModelAndView mView) {
		//cafeService를 이용해서 비지니스 로직을 처리하고 
		cafeService.getList(request, mView); 
		//view 페이지로 forward 이동해서 응답 하기
		mView.setViewName("cafe/list");
		return mView;	
	}
	//글 추가 폼 처리
	@RequestMapping("/cafe/private/insertform")
	public String insertform() {
		return "cafe/private/insertform";
	}
	//글 추가 처리
	@RequestMapping(value="/cafe/private/insert",method = RequestMethod.POST)
	public ModelAndView insert(CafeDto dto,ModelAndView mView,HttpSession session) {
		String id=(String)session.getAttribute("id");
		dto.setWriter(id);
		cafeService.addContent(dto,mView);
		mView.setViewName("cafe/private/insert");
		return mView;
	}
	//글 상세 페이지 처리
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(HttpServletRequest request,ModelAndView mView) {
		cafeService.getContentInfo(request, mView);
		mView.setViewName("cafe/detail");
		return mView;
	}
	//글 수정 폼
	@RequestMapping("/cafe/private/updateform")
	public ModelAndView updateform(HttpServletRequest request ,ModelAndView mView) {
		cafeService.getContentInfo(request, mView);
		mView.setViewName("cafe/private/updateform");
		return mView;
	}
	//글 수정 처리
	@RequestMapping("/cafe/private/update")
	public ModelAndView update(CafeDto dto,ModelAndView mView) {
		cafeService.update(dto, mView);
		mView.setViewName("cafe/private/update");
		return mView;
	}
	//글 삭제
	@RequestMapping("/cafe/private/delete")
	public String delete(HttpServletRequest request,int num) {
		cafeService.delete(request,num);
		return "redirect:/cafe/list.do";
	}
}
