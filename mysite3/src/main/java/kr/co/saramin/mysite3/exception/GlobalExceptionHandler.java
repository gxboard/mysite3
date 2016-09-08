/**
 * 
 */
package kr.co.saramin.mysite3.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

import kr.co.saramin.mysite3.dto.JsonResult;

/**
 * @author user1
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(HttpServletRequest request,
	                              Exception e)
	{
	    // 리퀘스트에 따라 처리. format,,
	    String accept = request.getHeader("Accept");
	    if (accept.equals("application/json")) {
	        
	        // return new JsonResult(false, e.getMessage(), e);
	    }
	    
		System.out.println("logging: " + e);
		return "error/500";
		
	}

}
