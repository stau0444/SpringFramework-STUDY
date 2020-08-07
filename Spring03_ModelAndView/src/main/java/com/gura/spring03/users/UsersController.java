package com.gura.spring03.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	
	@RequestMapping("/users/signup_form")
	public String users() {
		
		return "users/signup_form";
	}
	
	@RequestMapping("/users/signup2")
	public String signup2(String id,String pwd) {
		System.out.println(id+"|"+pwd);
		return "users/signup";
	}
	
	@RequestMapping("/users/signup3")
	public String signup3(@ModelAttribute UsersDto dto) {
		/*
		 * 알해서 해주는 기능 두가지
		 * -파라미터를 읽어오는것
		 * -읽어온 파라미터를 dto에 넣어주는것 
		 * @ModelAttribute 어노테이션과 함께 dto를 선언해 놓으면
		 * 전송된 파라미터가 추출되고 dto 에 담겨서 전달된다
		 * @ModelAttribute는 생략가능
		 * form 요소의 name 속성의 value와 dto의 필드명이 같아야한다.
		 * get 방식이면 파라미터명과 dto 필드명이 같아야한다.
		 */
		System.out.println(dto.getId()+"|"+dto.getPwd());
		return "users/signup";
	}
}
