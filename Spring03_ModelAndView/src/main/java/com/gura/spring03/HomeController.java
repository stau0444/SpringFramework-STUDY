package com.gura.spring03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	
	//home.do 요청이왔을때 이메소드로 요청을 처리 하게 된다.
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		//리턴하는 문자열은 view 페이지의 위치를 알려주는 것이다.
		//"/WEB-INF/views/"(prefix)+"home"+".jsp"(surfix)
		List<String> noticeList=new ArrayList<String>();
		noticeList.add("장마철");
		noticeList.add("비온다");
		noticeList.add("많이");
		noticeList.add("온다");
		request.setAttribute("noticeList", noticeList);
		return "home";
	}
	
}
