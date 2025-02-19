package algomeokJa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class DBConnectionMgr {
 private String _driver = "com.mysql.jdbc.Driver";
 private String _url = "jdbc:mysql://localhost:3306/new_user_db?characterEncoding=UTF-8&serverTimezone=UTC";
 private String _user = "root";
 private String _password = "1234";
 
 private Vector<ConnectionObject> connections = new Vector<>(10);
 private int _openConnections = 50;
 private boolean initialized = false;
 private static DBConnectionMgr instance = null;
 
 public static DBConnectionMgr getInstance() {
	 if(instance == null) {
		 synchronized(DBConnectionMgr.class) {
			 if(instance == null) {
				 instance = new DBConnectionMgr();
			 }
		 }
	 }
	 return instance;
 }
 
 private Connection createConnection() throws SQLException{
	 Properties props = new Properties();
	 props.put("user", _user);
	 props.put("password",_password);
	 return DriverManager.getConnection(_url, props);
 }
 
 public synchronized Connection getConnection() throws SQLException {
	 if(!initialized) {
		 try {
			Class.forName(_driver);
		} catch (ClassNotFoundException e) {
			throw new SQLException("JDBC Driver 로드 실패: " + e.getMessage());
		}
		 initialized = true;
	 }
	 
	 Connection c = null;
	 for (ConnectionObject co : connections) {
		 if (!co.inUse) {
	            if (co.connection.isClosed()) { //  닫힌 커넥션 확인 후 재연결
	                System.out.println(" 닫힌 커넥션 발견, 새로 연결합니다.");
	                co.connection = createConnection();
	            }
	            co.inUse = true;
	            return co.connection;
	        }
	    }
	 
	 c = createConnection();
	 connections.add(new ConnectionObject(c, true));
	 return c;
 }
 
 public synchronized void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
	 for (ConnectionObject co : connections) {
		if (con == co.connection) {
			co.inUse = false;
			break;
		}
	}
	 try {
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
 
 class ConnectionObject{
	 public Connection connection;
	 public boolean inUse;
	 
	 public ConnectionObject(Connection c, boolean useFlag) {
		 connection = c;
		 inUse = useFlag;
	 }
 }
 
}
