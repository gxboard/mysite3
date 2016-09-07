package kr.co.saramin.mysite3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.saramin.mysite3.exception.UserDaoException;
import kr.co.saramin.mysite3.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	BasicDataSource dataSource;

	public GuestbookVo get( Long no ) {
		return sqlSession.selectOne("guestbook.getByNo", no);
	}
	
	public int insert( GuestbookVo vo ) {
		int count = sqlSession.insert("guestbook.insert", vo);
		System.out.println(count + " row(s) affected.");
		System.out.println("last_insert_id = " + vo.getNo());
		return count;
	}
	
	public Integer delete( GuestbookVo vo ) {
		return sqlSession.delete("guestbook.delete", vo);
	}
	
	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = sqlSession.selectList("guestbook.getList");
		return list;
	}
	
	/**
	 * 회피 - 무의미하고 무책임한 throws (좋지 않은 방법)
	 * 
	 * @return List<GuestbookVo>
	 * @throws SQLException
	 */
	public List<GuestbookVo> getListWithException() throws SQLException {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		
		Connection	conn = dataSource.getConnection();
		Statement	stmt = conn.createStatement();
		String sql = "SELECT no, name, DATE_FORMAT( reg_date, '%Y-%m-%d %p %h:%i:%s' ), message from guestbook ORDER BY reg_date desc";
		ResultSet	rs = stmt.executeQuery( sql );
		while( rs.next() ) {
			Long no = rs.getLong( 1 );
			String name = rs.getString( 2 );
			String regDate = rs.getString( 3 );
			String message = rs.getString( 4 );
		
			GuestbookVo vo = new GuestbookVo();
			vo.setNo( no );
			vo.setName( name );
			vo.setRegDate( regDate );
			vo.setMessage( message );
			
			list.add( vo );
		}
		
		if( rs != null ) {
			rs.close();
		}
		if( stmt != null ) {
			stmt.close();
		}
		if( conn != null ) {
			conn.close();
		}
			
		return list;
	}
}