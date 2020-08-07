package comm.gura.spring02;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * HttpServletRequest or HttpServletResponse or HttpSession
 * 객체가 필요하면 메소드의 인자에 선언해 놓으면 자동으로 실행 시점에 참조값이 전달된다.
 */
@Controller
public class FortuneController {
	
	@RequestMapping("/fortune")
	public String fortune(HttpServletRequest request) {
		//비지니스 로직 처리
		String fortuneToday="동쪽 귀인";
		//모델을 리퀘스트 영역에 담는다
		request.setAttribute("fortuneToday", fortuneToday);
		//포춘.jsp로 포워드 이동시킴
		return "fortune";
		
	}
}
