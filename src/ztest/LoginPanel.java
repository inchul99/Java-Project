package ztest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener {
    private MainFrame parent;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton, registerButton;

    public LoginPanel(MainFrame parent) {
        this.parent = parent;

        JLabel titleLabel = new JLabel("로그인", JLabel.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        titleLabel.setBounds(120, 100, 200, 30);
        add(titleLabel);

        // 📌 아이디 입력 필드
        userField = new JTextField();
        userField.setBounds(70, 200, 300, 40);
        add(userField);

        // 📌 비밀번호 입력 필드
        passField = new JPasswordField();
        passField.setBounds(70, 260, 300, 40);
        add(passField);

        // 📌 로그인 버튼
        loginButton = new JButton("로그인");
        loginButton.setBounds(70, 320, 140, 40);
        loginButton.addActionListener(this);
        add(loginButton);

        // 📌 회원가입 버튼 (화면 전환)
        registerButton = new JButton("회원가입");
        registerButton.setBounds(230, 320, 140, 40);
        registerButton.addActionListener(this);
        add(registerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            System.out.println("로그인 버튼 클릭");
        } else if (e.getSource() == registerButton) {
            System.out.println("회원가입 화면으로 이동");
            parent.showPanel("register"); // 회원가입 화면으로 이동
        }
    }
}
