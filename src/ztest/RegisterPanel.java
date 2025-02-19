package ztest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel implements ActionListener {
    private MainFrame parent;
    private JTextField idField, emailField;
    private JPasswordField passField, passConfirmField;
    private JButton registerButton, backButton;

    public RegisterPanel(MainFrame parent) {
        this.parent = parent;
        setLayout(null);

        JLabel titleLabel = new JLabel("회원가입", JLabel.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        titleLabel.setBounds(120, 50, 200, 30);
        add(titleLabel);

        // 📌 아이디 입력 필드
        idField = new JTextField();
        idField.setBounds(70, 100, 300, 40);
        add(idField);

        // 📌 이메일 입력 필드
        emailField = new JTextField();
        emailField.setBounds(70, 160, 300, 40);
        add(emailField);

        // 📌 비밀번호 입력 필드
        passField = new JPasswordField();
        passField.setBounds(70, 220, 300, 40);
        add(passField);

        // 📌 비밀번호 확인 필드
        passConfirmField = new JPasswordField();
        passConfirmField.setBounds(70, 280, 300, 40);
        add(passConfirmField);

        // 📌 회원가입 버튼
        registerButton = new JButton("회원가입");
        registerButton.setBounds(70, 340, 140, 40);
        registerButton.addActionListener(this);
        add(registerButton);

        // 📌 로그인 화면으로 돌아가기 버튼
        backButton = new JButton("뒤로가기");
        backButton.setBounds(230, 340, 140, 40);
        backButton.addActionListener(this);
        add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            System.out.println("회원가입 완료! 로그인 화면으로 이동");
            parent.showPanel("login"); // 로그인 화면으로 이동
        } else if (e.getSource() == backButton) {
            System.out.println("로그인 화면으로 돌아가기");
            parent.showPanel("login"); // 로그인 화면으로 이동
        }
    }
}
