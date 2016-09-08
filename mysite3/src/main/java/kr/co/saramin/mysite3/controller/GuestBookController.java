package kr.co.saramin.mysite3.controller;

import java.util.List;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.saramin.mysite3.service.GuestBookService;
import kr.co.saramin.mysite3.vo.GuestbookVo;

@Controller
@RequestMapping("/guest-book")
public class GuestBookController {
	
	@Autowired
	private GuestBookService guestBookService;
	
	@RequestMapping(value={"/list", "/"})
	public String list(Model model)
	{
		List<GuestbookVo> list = guestBookService.getMessageList();
		model.addAttribute("list", list);
		
		return "guestbook/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
    public String write(@ModelAttribute GuestbookVo vo)
    {
        // System.out.println(vo);
        guestBookService.write(vo);
        
        return "redirect:/guest-book/";
    }

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo, HttpSession session)
	{
	    try {
	        Integer updateCount = guestBookService.delete(vo);
	        if (updateCount > 0) {
	            session.setAttribute("flashMessage", "방명록 삭제 성공 - " + vo.getNo());
	        } else {
	            session.setAttribute("flashMessage", "방명록이 삭제되지 않았습니다.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        session.setAttribute("flashMessage", "방명록 삭제 실패");
	    } finally {
	        
	    }

	    return "redirect:/guest-book/";
	}

	
	
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") Integer no, Model model)
	{
	    model.addAttribute("no", no);
	    return "guestbook/deleteform";
	}
	
	@RequestMapping(value={"/ajax"})
    public String ajax(Model model)
    {
        List<GuestbookVo> list = guestBookService.getMessageList();
        model.addAttribute("list", list);
        
        return "guestbook/ajax";
    }
	
	
	
	

}
