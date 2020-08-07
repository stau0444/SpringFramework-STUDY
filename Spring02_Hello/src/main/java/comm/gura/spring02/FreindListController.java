package comm.gura.spring02;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreindListController {
	@RequestMapping("/freind-list")
	public String freinds(HttpServletRequest request) {
		List<String> list =new ArrayList<String>();
		list.add("김구라");
		list.add("김제동");
		list.add("김봉길");
		list.add("김수로");
		request.setAttribute("list", list);
		
		return "freinds";
	}
}
