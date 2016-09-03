package kr.co.saramin.mysite3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.saramin.mysite3.service.GuestBookService;
import kr.co.saramin.mysite3.vo.GuestbookVo;

@Controller
@RequestMapping("/guest-book")
public class GuestBookController {
	
	@Autowired
	private GuestBookService guestBookService;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Model model)
	{
		
		List<GuestbookVo> list = guestBookService.getList();
		model.addAttribute("list", list);
		
		return "" + list;
	}
	
	
	

}
