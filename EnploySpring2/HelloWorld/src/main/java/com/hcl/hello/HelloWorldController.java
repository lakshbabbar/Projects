package com.hcl.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@RequestMapping("/hello")
	public ModelAndView helloWorld(){
		return new ModelAndView("result","message","Welcome to spring" );
	}
	
	@RequestMapping("/laksh")
	public ModelAndView hellolaksh(){
		return new ModelAndView("result1","message1","My name is Laksh" );
	}
}
