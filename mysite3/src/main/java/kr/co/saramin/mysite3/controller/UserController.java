package kr.co.saramin.mysite3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.saramin.mysite3.annotation.Auth;
import kr.co.saramin.mysite3.annotation.AuthUser;
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
		return "main/index"; 
	}
	
	@RequestMapping("/joinform")
	public String joinform()
	{
		return "user/joinform";
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
		return "user/loginform";
	}
	
	@Auth
	@RequestMapping("/modifyform")
	public String modifyform(HttpSession session)
	{
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			session.setAttribute("flashMessage", "로그인이 필요합니다.");
			return "redirect:/user/loginform";
		}
		
		return "user/modifyform";
	}
	
	@Auth
	@RequestMapping("/updateform")
	public String updateform(@AuthUser UserVo authUser) {
	    
	    System.out.println(authUser);
	    // UserVo authUser = (UserVo) session.getAttribute("authUser");
	    // UserVo userVo = userService.getUser(authUser.getNo());
	    
	    return "user/updateform"; 
	    
	}
	
	
	@RequestMapping("/update")
	public String update(HttpSession session, @ModelAttribute UserVo vo)
	{
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			session.setAttribute("flashMessage", "로그인이 필요합니다.");
			return "redirect:/user/loginform";
		}
		
		vo.setNo(authUser.getNo());
		
		userService.modifyUser(vo);
		
		return "redirect:/index";
	}
	
}
