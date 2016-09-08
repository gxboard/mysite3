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

public class AuthLoginInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor {

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        // TODO Auto-generated method stub
        //return super.preHandle(request, response, handler);
        
        // 인증 처리
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        
        UserService userService = applicationContext.getBean(UserService.class);
        UserVo userVo = new UserVo();
        userVo.setEmail(email);
        userVo.setPassword(password);
        
        UserVo authUser = userService.login(userVo);
        
        if (authUser == null) {
            response.sendRedirect(request.getContextPath() + "/user/loginform");
            return false;
        }
        
        HttpSession session = request.getSession(true);
        session.setAttribute("authUser", authUser);
        System.out.println(authUser);
        
        System.out.println("request.getContextPath() => " + request.getContextPath());
        response.sendRedirect(request.getContextPath() + "/");
        
        return false;
    }

}
