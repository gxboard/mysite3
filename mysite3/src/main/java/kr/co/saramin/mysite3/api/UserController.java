package kr.co.saramin.mysite3.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.saramin.mysite3.dto.JsonResult;
import kr.co.saramin.mysite3.service.UserService;
import kr.co.saramin.mysite3.vo.UserVo;

@Controller("userApiController")
@RequestMapping("/user/api")
public class UserController {
    
    @Autowired
    UserService userService;

	@RequestMapping("/checkemail")
	@ResponseBody
	public Object checkEmail(@RequestParam(value="email", required=false, defaultValue="") String email) {
	    UserVo userVo = userService.getUser(email);
	    
	    System.out.println(email);
	    
	    Boolean result = false;
	    String message = "사용할 수 없는 이메일 주소 입니다.";
	    if (userVo == null) {
	        result = true;
	        message = "사용할 수 있습니다.";
	    }

	    return new JsonResult(result, message, userVo);
	}
}
