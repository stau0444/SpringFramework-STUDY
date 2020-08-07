package comm.gura.spring04.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import comm.gura.spring04.member.dto.MemberDto;

@Controller
public class MemberController {
	

	@RequestMapping("/member/insert")
	public ModelAndView insert(MemberDto dto) {
		
		
		return null;
	}
	
}
