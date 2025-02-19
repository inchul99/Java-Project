package ztest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 회원가입 페이지를 구현한 JFrame 클래스.*/
public class RegisterPage extends JFrame implements ActionListener {
    // 입력 필드 및 버튼 선언
    private JTextField idField, emailField, passField, passConfirmField, nameField, phoneField, verifyCodeField;
    private JButton checkIdButton, verifyPhoneButton, registerButton;

    /** RegisterPage 생성자: 회원가입 화면을 구성합니다. */
    public RegisterPage() {
        setTitle("RegisterPage"); // 창 제목 설정
        setSize(440, 956); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램 종료
        setLayout(null); // 절대 위치 사용
        setResizable(false); // 창 크기 변경 불가능

        // 폼의 너비와 중앙 정렬을 위한 좌표 설정
        int formWidth = 376;
        int centerX = (getWidth() - formWidth) / 3;
        int startY = 100; // 시작 Y 위치

        // ======== 상단 제목 ========
        JLabel titleLabel = new JLabel("회원가입", JLabel.LEFT);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 32)); // 폰트 설정
        titleLabel.setBounds(centerX, startY - 95, 181, 58); // 위치 및 크기 설정
        add(titleLabel); // 화면에 추가

        // ======== 아이디 입력 ========
        JLabel idLabel = new JLabel("아이디 *");
        idLabel.setBounds(centerX + 5, startY + 40, 100, 20);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(centerX + 5, startY + 65, 260, 41);
        add(idField);

        checkIdButton = new JButton("ID중복확인");
        checkIdButton.setBounds(centerX + 275, startY + 65, 105, 41);
        checkIdButton.setFont(new Font("Jua", Font.PLAIN, 14));
        checkIdButton.setBackground(Color.black);
        checkIdButton.setForeground(Color.WHITE);
        checkIdButton.addActionListener(this);
        add(checkIdButton);

        // ======== 이메일 입력 ========
        JLabel emailLabel = new JLabel("이메일 *");
        emailLabel.setBounds(centerX + 5, startY + 110, 100, 20);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(centerX + 5, startY + 135, formWidth, 41);
        add(emailField);

        // ======== 비밀번호 입력 ========
        JLabel passLabel = new JLabel("비밀번호 *");
        passLabel.setBounds(centerX + 5, startY + 180, 100, 20);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(centerX + 5, startY + 205, formWidth, 41);
        add(passField);

        // ======== 비밀번호 확인 ========
        JLabel passConfirmLabel = new JLabel("비밀번호 확인 *");
        passConfirmLabel.setBounds(centerX + 5, startY + 250, 120, 20);
        add(passConfirmLabel);

        passConfirmField = new JPasswordField();
        passConfirmField.setBounds(centerX + 5, startY + 275, formWidth, 41);
        add(passConfirmField);

        // ======== 이름 입력 ========
        JLabel nameLabel = new JLabel("이름 *");
        nameLabel.setBounds(centerX + 5, startY + 320, 100, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(centerX + 5, startY + 345, formWidth, 41);
        add(nameField);

        // ======== 휴대폰 번호 입력 ========
        JLabel phoneLabel = new JLabel("휴대폰 번호");
        phoneLabel.setBounds(centerX + 5, startY + 390, 100, 20);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(centerX + 5, startY + 415, 260, 41);
        add(phoneField);

        verifyPhoneButton = new JButton("인증번호받기");
        verifyPhoneButton.setBounds(centerX + 275, startY + 415, 105, 40);
        verifyPhoneButton.setFont(new Font("Jua", Font.PLAIN, 14));
        verifyPhoneButton.setBackground(Color.black);
        verifyPhoneButton.setForeground(Color.WHITE);
        verifyPhoneButton.addActionListener(this);
        add(verifyPhoneButton);

        // ======== 인증번호 입력 ========
        verifyCodeField = new JTextField();
        verifyCodeField.setBounds(centerX + 120, startY + 460, 146, 37);
        add(verifyCodeField);

        // ======== 회원가입 버튼 ========
        registerButton = new JButton("회원가입");
        registerButton.setBounds(centerX + 105, startY + 590, 187, 50);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Jua", Font.BOLD, 20));
        registerButton.addActionListener(this);
        add(registerButton);

        setVisible(true); // 창을 화면에 표시
    }

    /** 버튼 클릭 이벤트 처리*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkIdButton) {
            System.out.println("ID 중복 확인 클릭!");
        } else if (e.getSource() == verifyPhoneButton) {
            System.out.println("인증번호 받기 클릭!");
        } else if (e.getSource() == registerButton) {
            System.out.println("회원가입 버튼 클릭!");
        }
    }

    /** 프로그램 실행 진입점 (main 메서드)*/
    public static void main(String[] args) {
        new RegisterPage(); // 회원가입 페이지 생성
    }
}
