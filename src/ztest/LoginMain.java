package ztest;

import javax.swing.*;

import UIutils.RoundButton;
import UIutils.RoundPasswordField;
import UIutils.RoundTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.LoginDAO;
import login.CustomDialog;


public class LoginMain extends JFrame implements ActionListener {

    private JButton signUpButton, loginButton;
    private JTextField loginField;
    private JPasswordField passwordField;
    private LoginDAO loginDAO;

    public LoginMain() {
        setTitle("로그인(첫 화면)");
        setSize(440, 956);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        loginDAO = new LoginDAO(); // DAO 인스턴스 생성

        // 패널 설정
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);

        // 폰트 설정
        Font interBold22 = new Font("Inter", Font.BOLD, 22);
        Font interBold15 = new Font("Inter", Font.BOLD, 15);
        Font interRegular12 = new Font("Inter", Font.PLAIN, 12);

        // 상단 문구
        JLabel titleLabel = new JLabel("\"건강한 식단 관리, 함께 시작해요!\"", SwingConstants.CENTER);
        titleLabel.setFont(interBold22);
        titleLabel.setBounds(48, 263, 345, 59);
        panel.add(titleLabel);

        // 로그인 필드 레이블
        JLabel loginLabel = new JLabel("로그인");
        loginLabel.setFont(interBold15);
        loginLabel.setBounds(64, 360, 313, 38);
        panel.add(loginLabel);

        // 로그인 입력 필드 (둥근 입력 필드 사용)
        loginField = new RoundTextField(20);
        loginField.setBounds(62, 398, 315, 40);
        panel.add(loginField);

        // 비밀번호 필드 레이블
        JLabel passwordLabel = new JLabel("비밀번호");
        passwordLabel.setFont(interBold15);
        passwordLabel.setBounds(62, 459, 313, 38);
        panel.add(passwordLabel);

        // 비밀번호 입력 필드 (둥근 입력 필드 사용)
        passwordField = new RoundPasswordField(20);
        passwordField.setBounds(62, 495, 315, 40);
        panel.add(passwordField);

        // 로그인 버튼 (둥근 버튼 사용)
        loginButton = new RoundButton("Login", new Color(192, 233, 147), Color.BLACK);
        loginButton.setBounds(64, 598, 132, 40);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        // 회원가입 버튼 (둥근 버튼 사용)
        signUpButton = new RoundButton("회원가입", Color.BLACK, Color.WHITE);
        signUpButton.setBounds(242, 598, 135, 40);
        signUpButton.addActionListener(this);
        panel.add(signUpButton);

        setVisible(true);
    }

    // 🔹 버튼 클릭 이벤트 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userId = loginField.getText();
            String userPwd = new String(passwordField.getPassword());

            if (userId.isEmpty() || userPwd.isEmpty()) {
                CustomDialog.showDialog(this, "아이디와 비밀번호를 입력하세요.", "로그인 오류");
            } else {
                boolean loginSuccess = loginDAO.checkLogin(userId, userPwd);

                if (loginSuccess) {
                    CustomDialog.showDialog(this, "로그인 성공!", "로그인 완료");
                    System.out.println("로그인 성공: " + userId);
                } else {
                    CustomDialog.showDialog(this, "아이디 혹은 비밀번호가 틀렸습니다.", "로그인 실패");
                }
            }
        } else if (e.getSource() == signUpButton) {
            CustomDialog.showDialog(this, "회원가입 창으로 이동합니다.", "회원가입");
        }
    }

    public static void main(String[] args) {
        new LoginMain();
    }
}
