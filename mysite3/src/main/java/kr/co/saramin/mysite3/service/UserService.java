package kr.co.saramin.mysite3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saramin.mysite3.dao.UserDao;
import kr.co.saramin.mysite3.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public void join(UserVo userVo)
	{
		userDao.insert(userVo);
		System.out.println("UserService.join()");
	}
	
	public void modifyUser(UserVo vo)
	{
		// userDao.update(vo);
		System.out.println("UserService.update()");
	}
	
	public UserVo login(UserVo userVo)
	{
		UserVo authUser = userDao.get(userVo);
		
		return authUser;
		
		//System.out.println("UserService.login()");
	}
	
	public UserVo getUser(String email) {
	    return userDao.get(email);
	}
	
	public UserVo getUser(Long no) {
	    return userDao.get(no);
	}

}
