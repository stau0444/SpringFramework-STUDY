package comm.gura.spring04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping()
	public String home() {
			
		return "home";
	}
	
}
