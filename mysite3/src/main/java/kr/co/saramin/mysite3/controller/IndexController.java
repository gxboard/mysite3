package kr.co.saramin.mysite3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index()
	{
		return "main/index"; 
	}
	
	@RequestMapping("/")
	public String main()
	{
	    return "main/index"; 
	}
}
