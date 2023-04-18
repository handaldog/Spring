package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 왕따임..
public class BoardController {

	@RequestMapping("/list")
	public ModelAndView list() {
		return new ModelAndView("BoardList");
	}

	@RequestMapping("/write")
	public ModelAndView write() {
		return new ModelAndView("BoardWrite");
	}
}
