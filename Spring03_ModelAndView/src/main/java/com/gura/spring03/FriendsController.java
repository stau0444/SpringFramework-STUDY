package com.gura.spring03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendsController {
	
	@RequestMapping("/friends")
	public String friends(HttpServletRequest request){
		List<String> list=new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		
		request.setAttribute("list", list);
		return "friends";
		
	}
	
	@RequestMapping("/friends2")
	public ModelAndView friends2() {
		List<String> list=new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		//model과 view 페이지 정보를 함게 담을 수 있는 ModelAndView 객체 생성
		ModelAndView mView= new ModelAndView();
		//request영역에 담을 내용을 addObject() 메소드를 이용해서 담는다.
		mView.addObject("list",list);
		//view 페이지 정보를 setViewName 을 이용해서 담는다
		mView.setViewName("friends");
		// ModelAndView 타입의 mView를 리턴한다.
		return mView;
		
	}
	
	//ModelAndView를 직접 생성하지 않고 스프링이 생성한 것을 사용하는 방법 
	@RequestMapping("/friends3")
	public ModelAndView friends3(ModelAndView mView) {
		List<String> list=new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		//request영역에 담을 내용을 addObject() 메소드를 이용해서 담는다.
		mView.addObject("list",list);
		//view 페이지 정보를 setViewName 을 이용해서 담는다
		mView.setViewName("friends");
		// ModelAndView 타입의 mView를 리턴한다.
		return mView;
		
	}
	@RequestMapping("/delete")
	public String delete() {
		//가상의 삭제 비지니스 로직 수행
		System.out.println("친구 정보를 삭제 합니다.");
		
		//삭제후 친구 목록 보기로 redirect이동
		return "redirect:/friends.do";
	}
	@RequestMapping("/delete2")
	public ModelAndView delete2(ModelAndView mView) {
		//가상의 삭제 비지니스 로직 수행
		System.out.println("친구 정보를 삭제 합니다.");
		//리다일렉트 이동 정보를 담아서 
		mView.setViewName("redirect:/friends.do");
		//리턴해 준다.
		return mView;
	}
}
