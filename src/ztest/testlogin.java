package ztest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class testlogin {
	private String _driver = "com.mysql.cj.jdbc.Driver";
	private static final String _url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String _user = "root";
	private static final String _password = "1234";
	
	public static void testlogin() {
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력 받기
        System.out.print("회원 아이디: ");
        String user_id = scanner.nextLine();

        System.out.print("회원 비밀번호: ");
        String user_pwd = scanner.nextLine();

        System.out.print("이름: ");
        String user_name = scanner.nextLine();

        System.out.print("전화번호: ");
        String user_phone = scanner.nextLine();

        System.out.print("이메일: ");
        String user_email = scanner.nextLine();

        // 회원가입 시간은 현재 시간으로 설정
        java.sql.Timestamp user_createdtime = new java.sql.Timestamp(System.currentTimeMillis());

        // 데이터베이스에 입력된 정보 삽입
        try (Connection connection = DriverManager.getConnection(_url, _user, _password)) {
            String sql = "INSERT INTO 회원 (user_id, user_pwd, user_name, user_phone, user_email, user_createdtime) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            
            // PreparedStatement 사용 (SQL Injection 방지)
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user_id);
                statement.setString(2, user_pwd);
                statement.setString(3, user_name);
                statement.setString(4, user_phone);
                statement.setString(5, user_email);
                statement.setTimestamp(6, user_createdtime);

                // SQL 실행
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("회원가입이 완료되었습니다!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		testlogin();
	}
}
