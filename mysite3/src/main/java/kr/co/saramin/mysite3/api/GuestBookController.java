package kr.co.saramin.mysite3.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.saramin.mysite3.dto.JsonResult;
import kr.co.saramin.mysite3.service.GuestBookService;
import kr.co.saramin.mysite3.service.UserService;
import kr.co.saramin.mysite3.vo.GuestbookVo;
import kr.co.saramin.mysite3.vo.UserVo;

@Controller("guestbookApiController")
@RequestMapping("/api/guestbook")
public class GuestBookController {
    
    @Autowired
    GuestBookService guestbookService;

	@RequestMapping(value={"/insert", ""})
	@ResponseBody
	public Object insert(@RequestBody GuestbookVo vo) {
	    System.out.println(vo);
	    guestbookService.write(vo);
	    
	    // GuestbookVo guestVo = guestbookService.getList(vo.getNo());

	    return new JsonResult(true, null);
	}
}
