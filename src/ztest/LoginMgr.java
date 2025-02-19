package ztest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;



public class LoginMgr {
	
	private DBConnectionMgr pool;
	
	public LoginMgr() {
		try {
			// Connection 객체를 Vector 미리 10개 만듦. ?왜 백터
			pool = DBConnectionMgr.getInstance();
			System.out.println("성공");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//DB 연동 잘되는지 테스트 하기 위한 메소드 실제 코드에서 사용되지 않음.
	public void selectcnt() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "select count(*) from user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt(1);
				System.out.println("cnt :  "+ cnt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
	}
	/*
	public boolean insertLoing (LoginBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "insert user values (null, ?, ?, ?, ?)";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flag;
	}
	*/

	
	
	public static void main(String[] args) {
		LoginMgr mgr = new LoginMgr();
	}
}
