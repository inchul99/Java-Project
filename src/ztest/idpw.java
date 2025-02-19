package ztest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class idpw extends MFrame implements ActionListener {
    private TextField userField, passField;
    private Button loginButton, registerButton;
    private Checkbox rememberMe;

    public idpw() {
        super(440, 956, Color.WHITE); // 창 크기 및 배경색 설정
        setTitle("idpw");
        setLayout(null); // 절대 위치 설정

        int formWidth = 340;  // 입력 필드 및 버튼 너비
        int formHeight = 350; // 로그인 폼 높이 (대략)
        int centerX = (440 - formWidth) / 2; // 좌우 중앙
        int centerY = (956 - formHeight) / 2; // 상하 중앙

        // 상단 메시지 라벨
        Label titleLabel = new Label("건강한 식단 관리, 함께 시작해요!", Label.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        titleLabel.setBounds(centerX, centerY, formWidth, 30);
        add(titleLabel);

        // 아이디 입력 필드
        Label userLabel = new Label("로그인");
        userLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        userLabel.setBounds(centerX, centerY + 60, 100, 20);
        add(userLabel);

        userField = new TextField();
        userField.setBounds(centerX, centerY + 90, formWidth, 40);
        add(userField);

        // 비밀번호 입력 필드
        Label passLabel = new Label("비밀번호");
        passLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        passLabel.setBounds(centerX, centerY + 150, 100, 20);
        add(passLabel);

        passField = new TextField();
        passField.setEchoChar('*'); // 비밀번호 숨김 처리
        passField.setBounds(centerX, centerY + 180, formWidth, 40);
        add(passField);

        // Remember me & Forgot password
        rememberMe = new Checkbox("Remember me");
        rememberMe.setBounds(centerX, centerY + 240, 120, 20);
        add(rememberMe);

        Label forgotPass = new Label("Forgot password/ID?");
        forgotPass.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        forgotPass.setForeground(Color.GRAY);
        forgotPass.setBounds(centerX + 190, centerY + 240, 150, 20);
        add(forgotPass);

        // 로그인 버튼
        loginButton = new Button("Login");
        loginButton.setBounds(centerX, centerY + 280, 160, 50);
        loginButton.setBackground(new Color(180, 230, 150)); // 연한 녹색
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        loginButton.addActionListener(this);
        add(loginButton);

        // 회원가입 버튼
        registerButton = new Button("회원가입");
        registerButton.setBounds(centerX + 180, centerY + 280, 160, 50);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        registerButton.addActionListener(this);
        add(registerButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            System.out.println("로그인 버튼 클릭!");
            System.exit(0);
        } else if (e.getSource() == registerButton) {
            System.out.println("회원가입 버튼 클릭!");
        }
    }

    public static void main(String[] args) {
        new idpw();
    }
}
