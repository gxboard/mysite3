package kr.co.saramin.mysite3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saramin.mysite3.dao.GuestbookDao;
import kr.co.saramin.mysite3.vo.GuestbookVo;

@Service
public class GuestBookService {
	
	@Autowired
	GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getMessageList()
	{
		// GuestbookVo vo = guestbookDao.get(1L);
		// System.out.println(vo);
		
		return guestbookDao.getList();
	}
	
	
	public List<GuestbookVo> getList()
	{
		return guestbookDao.getList();
	}
	
	public void write(GuestbookVo vo)
	{
	    guestbookDao.insert(vo);
	}
	
	public Integer delete(GuestbookVo vo)
	{
	    return guestbookDao.delete(vo);
	}
	

}
