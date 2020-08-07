package comm.gura.spring02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//컨트롤러를 만들대 사용하는 어노테이션
@Controller
public class HomeController {
	
	//해당 메소드가 어떤 요청을 처리할지 결정하는 어노테이션
	@RequestMapping("/home.nhn")//.nhn생략가능
	public String home() {
		
		//forward 이동될 jsp 페이지의 위치를 리턴해 준다
		//"/WEB-INF/views/"+"home"+".jsp" 형식으로 자동으로 리턴해준다
		return "home";
	}
}
