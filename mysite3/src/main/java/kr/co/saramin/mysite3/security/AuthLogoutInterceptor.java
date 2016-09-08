package kr.co.saramin.mysite3.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.saramin.mysite3.service.UserService;
import kr.co.saramin.mysite3.vo.UserVo;

public class AuthLogoutInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor {

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        // TODO Auto-generated method stub
        //return super.preHandle(request, response, handler);
        
        // 인증 처리
        
        HttpSession session = request.getSession(true);
        if (session != null) {
            session.removeAttribute("authUser");
            session.invalidate(); // 세션 아이디 재발급
        }
        
        response.sendRedirect(request.getContextPath());
        
        return false;
    }

}
