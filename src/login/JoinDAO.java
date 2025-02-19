package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JoinDAO {
    
    private DBConnectionMgr pool; // DB 연결 관리 객체

    public JoinDAO() {
        try {
            pool = DBConnectionMgr.getInstance(); // 🔹 예외 처리 추가
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DBConnectionMgr 인스턴스 생성 실패");
        }
    }

    // 🔹 회원가입 정보 DB에 저장
    public boolean joinUser(LoginBean user) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO user (user_id, user_pwd, user_name, user_phone, user_email, user_createdtime) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = pool.getConnection(); // 🔹 예외 발생 가능 코드 → try-catch 추가
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUser_id());
            pstmt.setString(2, user.getUser_pwd());
            pstmt.setString(3, user.getUser_name());
            pstmt.setString(4, user.getUser_phone());
            pstmt.setString(5, user.getUser_email());
            pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis())); // 현재 시간 저장

            int result = pstmt.executeUpdate();
            return result > 0; // 성공하면 true 반환

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("회원가입 데이터 저장 중 오류 발생!");
            return false;
        } catch (Exception e) { // 🔹 DB 연결 오류 예외 처리
            e.printStackTrace();
            System.out.println("DB 연결 중 오류 발생!");
            return false;
        } finally {
            if (con != null && pstmt != null) {
                pool.freeConnection(con, pstmt);
            }
        }
    } //--registerUser
    
    // 🔹 ID 중복 확인 기능
    public boolean isUserIdExists(String userId) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        String sql = "SELECT COUNT(*) FROM user WHERE user_id = ?";

        try {
            con = pool.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return true; // ID가 이미 존재함
            }
            return false; // 사용 가능한 ID

        } catch (SQLException e) {
            e.printStackTrace();
            return true; // 예외 발생 시 중복된 것으로 간주
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
    } // --isUserIdExists
    
}
