package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    private DBConnectionMgr pool;

    public LoginDAO() {
        try {
            pool = DBConnectionMgr.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 로그인 검증 메서드
    public boolean checkLogin(String userId, String userPwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginSuccess = false;

        try {
            conn = pool.getConnection();
            String sql = "SELECT * FROM user WHERE user_id = ? AND user_pwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPwd);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                loginSuccess = true; // 아이디 & 비밀번호 일치
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(conn, pstmt, rs);
        }
        return loginSuccess;
    }
}
