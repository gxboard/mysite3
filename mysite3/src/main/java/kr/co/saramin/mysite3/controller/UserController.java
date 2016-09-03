package kr.co.saramin.mysite3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.saramin.mysite3.service.UserService;
import kr.co.saramin.mysite3.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public String index()
	{
		return "/WEB-INF/views/main/index.jsp"; 
	}
	
	@RequestMapping("/joinform")
	public String joinform()
	{
		return "/WEB-INF/views/user/joinform.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo)
	{
		userService.join(userVo);
		
		return "redirect:/user/loginform";
	}
	
	@RequestMapping("/loginform")
	public String loginform()
	{
		return "/WEB-INF/views/user/loginform.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute UserVo userVo, HttpSession session)
	{
		UserVo authUser = userService.login(userVo);
		if (authUser == null) {
		    // session.setAttribute("authUser", userVo);
			return "redirect:/user/loginform?result=fail";
		}
		
		// 인증처리
		session.setAttribute("authUser", authUser);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/index";
	}
	
	
	
	
}
