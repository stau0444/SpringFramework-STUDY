package comm.gura.spring04.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import comm.gura.spring04.member.dao.MemberDao;
import comm.gura.spring04.member.dto.MemberDto;
import comm.gura.spring04.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		  service.getList(mView);
	      mView.setViewName("member/list");
	      return mView;
	}
	
	@RequestMapping("/member/insert_form")
	public String insert_from() {
	      return "member/insert_form";
	}
	
	@RequestMapping("/member/insert")
	public String insert(MemberDto dto) {
		service.addMember(dto);
	      return "redirect:/member/list.do";
	}
	
	@RequestMapping("home")
	public String home() {
	      return "home";
	}
	
	//get방식 /member/updatform 요청 처리
	@RequestMapping(value = "/member/update_form", method = RequestMethod.GET)
	public ModelAndView update_from(@RequestParam int num , ModelAndView mView) {
		service.getMember(num, mView);
		mView.setViewName("member/update_form");
	      return mView;
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String update(MemberDto dto) {
		service.updateMember(dto);
	      return "member/update";
	}
	
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		service.deleteMember(num);
	      return "redirect:/member/list.do";
	}
	
	
}
