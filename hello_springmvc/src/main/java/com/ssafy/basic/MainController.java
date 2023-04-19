package com.ssafy.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // 컨트롤러인지 인식시켜주기 위해서.
public class MainController { // controller 는 modelandview 를 리턴해줌.

	// @RequestMapping("/") // 기본값은 get 방식으로 들어감.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index"; // index.jsp까지 할 필요 없음 (servlet-context가 알아서 주소 붙임) :::::default 가 forward로
						// 되어있음.
	}

	// @RequestMapping("/") // 기본값은 get 방식으로 들어감.
	// @RequestMapping(value = "/hello", method = RequestMethod.GET)

	@GetMapping("/hello")
	public ModelAndView hello() { // 데이터도 가져가야 하기 때문에
		// ModelAndView mav = new ModelAndView("basic/result", "msg", "안녕하세요.");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "안녕하세요 유혜빈입니다."); // mav에 msg 라는 이름으로 "안녕하세요 유혜빈"을 넣어주는것임.
		mav.setViewName("basic/result");
		return mav; // default 가 forward로 되어있음.
	}

	@GetMapping("/single")
	public String single() {
		return "single";
	}

	@PostMapping("/single")
	public String single(@RequestParam("userId") String userId, @RequestParam("username") String userName, @RequestParam(name = "area", required = true, defaultValue = "0") int area, Model model) {
		String msg = userName + "(" + userId + ")님의 지역 :: " + area;
		System.out.println(msg);
		model.addAttribute("msg", msg);
		return "basic/result";
	}

	@GetMapping("/multi")
	public String multi() {
		return "multi";
	}
	
	@PostMapping("/multi")
	public String multi(ParamDto paramDto, ModelMap modelmap) {
		modelmap.addAttribute("msg", paramDto);
		return "basic/result";
	}

}