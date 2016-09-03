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

import kr.co.saramin.mysite3.vo.BoardVo;

@Repository
public class BoardDao {

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
	
	public BoardVo get( Long no ) {
		
		BoardVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT no, name, DATE_FORMAT( reg_date, '%Y-%m-%d %p %h:%i:%s' ), message from board where no = ?";
			pstmt = conn.prepareStatement( sql );
			
			pstmt.setLong( 1, no ); 
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				vo = new BoardVo();

				vo.setNo( rs.getLong( 1 ) );
				vo.setRegDate( rs.getString( 3 ) );
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
	
	public void insert( BoardVo vo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			
			String sql = "INSERT INTO board VALUES( null, ?, ?, 0, now(), ?)";
			pstmt = conn.prepareStatement( sql );
			
			pstmt.setString( 1, vo.getTitle()  );
			pstmt.setString( 2, vo.getContent());
			pstmt.setLong(   3, vo.getUserNo() );

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
	
	public Integer delete( BoardVo vo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer updateCount = 0;
		
		try{
			conn = getConnection();
			String sql = "DELETE FROM board WHERE no = ? AND password = password(?)";
			pstmt = conn.prepareStatement( sql );
			pstmt.setLong( 1,  vo.getNo() );
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
	
	public List<BoardVo> getList() {
		List<BoardVo> list = new ArrayList<BoardVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT no, name, DATE_FORMAT( reg_date, '%Y-%m-%d %p %h:%i:%s' ), message from board ORDER BY reg_date desc";
			rs = stmt.executeQuery( sql );
			while( rs.next() ) {
				Long no = rs.getLong( 1 );
				String regDate = rs.getString( 3 );
			
				BoardVo vo = new BoardVo();
				vo.setNo( no );
				vo.setRegDate( regDate );
				
				list.add( vo );
			}
		} catch( SQLException ex ) {
			System.out.println( "error: " + ex);
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
}