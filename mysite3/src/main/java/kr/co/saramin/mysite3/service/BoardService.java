package kr.co.saramin.mysite3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saramin.mysite3.dao.BoardDao;
import kr.co.saramin.mysite3.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	
	public List<BoardVo> getList()
	{
		return boardDao.getList();
	}
	
	public void write(BoardVo vo)
	{
	    boardDao.insert(vo);
	}
	
	public Integer delete(BoardVo vo)
	{
	    return boardDao.delete(vo);
	}
	

}
