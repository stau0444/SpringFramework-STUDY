package com.gura.spring05.file.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.exception.NotDeleteException;

//예외 컨트롤러를 bean 으로 만들기 위한 어노테이션
@ControllerAdvice
public class ExceptionController {
	//이런 타입의 예외가 발생할 경우에 실행 순서가 여기로 들어오게됨
	@ExceptionHandler(NotDeleteException.class)
	public ModelAndView notDelete(NotDeleteException nde) {
		ModelAndView mView=new ModelAndView();
		mView.addObject("exception",nde);
		mView.setViewName("error/info");
		return mView;
	}
}
