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

import kr.co.saramin.mysite3.service.BoardService;
import kr.co.saramin.mysite3.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
    public String index()
    {
	    return "forward:/board/list";
    }
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		
		List<BoardVo> list = boardService.getList();
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/board/list.jsp";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
    public String write(@ModelAttribute BoardVo vo)
    {
        // System.out.println(vo);
        boardService.write(vo);
        
        return "redirect:/board/";
    }

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute BoardVo vo, HttpSession session)
	{
	    try {
	        Integer updateCount = boardService.delete(vo);
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

	    return "redirect:/board/";
	}

	
	
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") Integer no, Model model)
	{
	    model.addAttribute("no", no);
	    return "/WEB-INF/views/guestbook/deleteform.jsp";
	}
	
	
	
	
	

}
