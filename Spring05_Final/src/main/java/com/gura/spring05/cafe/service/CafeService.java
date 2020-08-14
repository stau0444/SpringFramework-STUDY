package com.gura.spring05.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeService {
	public void getList(HttpServletRequest request,ModelAndView mView);
	public void getContentInfo(HttpServletRequest request,ModelAndView mView);
	public void addContent(CafeDto dto,ModelAndView mView);
	public void delete(HttpServletRequest request,int num);
	public void update(CafeDto dto,ModelAndView mView);
}
