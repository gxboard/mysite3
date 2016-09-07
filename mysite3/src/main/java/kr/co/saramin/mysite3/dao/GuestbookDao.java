package kr.co.saramin.mysite3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.saramin.mysite3.exception.UserDaoException;
import kr.co.saramin.mysite3.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			String url = "jdbc:mysql://localhost/webdb";
		
			connection = DriverManager.getConnection(url, "webdb", "webdb");
		
		} catch( ClassNotFoundException ex ) {
			ex.printStackTrace();
		}
		
		return connection;
	}
	
	public GuestbookVo get( Long no ) {
		
		GuestbookVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT no, name, DATE_FORMAT( reg_date, '%Y-%m-%d %p %h:%i:%s' ), message from guestbook where no = ?";
			pstmt = conn.prepareStatement( sql );
			
			pstmt.setLong( 1, no ); 
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				vo = new GuestbookVo();

				vo.setNo( rs.getLong( 1 ) );
				vo.setName( rs.getString( 2 ) );
				vo.setRegDate( rs.getString( 3 ) );
				vo.setMessage( rs.getString( 4 ) );				
			}
			
			return vo;
			
		} catch( SQLException ex ) {
			System.out.println( "error:" + ex );
			return null;
		} finally {
			try{
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
	}
	
	public void insert( GuestbookVo vo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			
			String sql = "INSERT INTO guestbook VALUES( null, ?, now(), ?, password(?) )";
			pstmt = conn.prepareStatement( sql );
			
			pstmt.setString( 1,  vo.getName() );
			pstmt.setString( 2, vo.getMessage() );
			pstmt.setString( 3, vo.getPassword() );

			pstmt.executeUpdate();
			
		} catch( SQLException ex ) {
			ex.printStackTrace();
		} finally {
			try{
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			}catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
	}
	
	public Integer delete( GuestbookVo vo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer updateCount = 0;
		
		try{
			conn = getConnection();
			String sql = "DELETE FROM guestbook WHERE no = ? AND password = password(?)";
			pstmt = conn.prepareStatement( sql );
			pstmt.setLong( 1,  vo.getNo() );
			pstmt.setString( 2, vo.getPassword() );
			pstmt.executeUpdate();
			updateCount = pstmt.getUpdateCount();
		} catch( SQLException ex ) {
			ex.printStackTrace();
		} finally {
			try{
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			}catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
		
		return updateCount;
	}
	
	public List<GuestbookVo> getList() throws UserDaoException {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT no, name, DATE_FORMAT( reg_date, '%Y-%m-%d %p %h:%i:%s' ), message from guestbook ORDER BY reg_date desc";
			rs = stmt.executeQuery( sql );
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
		} catch( SQLException ex ) {
			ex.printStackTrace();
			System.out.println( "error: " + ex);
			throw new UserDaoException(ex.getMessage());
		} finally {
			try{
				if( rs != null ) {
					rs.close();
				}
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			}catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
		
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
		
		Connection	conn = getConnection();
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