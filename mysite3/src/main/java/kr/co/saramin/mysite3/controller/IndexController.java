package kr.co.saramin.mysite3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("hello")
	@ResponseBody
	public String hello()
	{
		return "hello, 안녕하세요? !@#$%^&*()_+|";
	}
}
