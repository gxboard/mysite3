package kr.co.saramin.mysite3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.saramin.mysite3.annotation.Auth;
import kr.co.saramin.mysite3.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor {

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {


        if ((handler instanceof HandlerMethod) == false) {
            // 기본 (Default Servlet 핸들러 일 수가 있다.
            return true;
        }
        
        Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
        if (auth == null) {
            // @Auth  어노테이션이 달리지 않은 핸들러 메소드
            return true;
        }
        
        // 접근 제어
        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/user/loginform");
            return false;
        }
        
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser == null) {
            session.setAttribute("flashMessage", "로그인이 필요합니다.");
            response.sendRedirect(request.getContextPath() + "/user/loginform");
            return false;
        }
        
        // 인증된 사용자
        
        
        
        return true;
    }

}
