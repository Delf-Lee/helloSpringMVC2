package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// http://localhost:8080/helloSpringMVC/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome() {
		
		System.out.println("Ȩ���� ���ƿ�");
		return "home"; // view's logical name
	}
}
