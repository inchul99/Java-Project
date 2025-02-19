package login;


import javax.swing.*;

import UIutils.RoundedComponent;

import java.awt.*;

public class RoundedFieldExample {
    public static void main(String[] args) {
        // ✅ 프레임 설정
        JFrame frame = new JFrame("RoundedField 테스트");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // ✅ 아이디 입력 필드
        RoundedComponent idField = 
        new RoundedComponent(250, 40, 15, "textfield", "", 
        	Color.black, Color.WHITE, Color.black, "Malgun Gothic", Font.PLAIN, 14);

        
        // ✅ 비밀번호 입력 필드
        RoundedComponent passwordField =
        	new RoundedComponent(250, 40, 15, "password", "", 
        			Color.GRAY, Color.WHITE, Color.BLACK, "Malgun Gothic", Font.PLAIN, 14);

        // ✅ 로그인 버튼
        RoundedComponent loginButton = new RoundedComponent(150, 45, 20, "button", "로그인", 
                Color.BLACK, Color.BLACK, Color.WHITE, 
                "Malgun Gothic", Font.BOLD, 16);

        // 버튼 글씨색 설정

        // ✅ 프레임에 추가
        frame.add(idField);
        frame.add(passwordField);
        frame.add(loginButton);

        frame.setVisible(true);
    }
}

