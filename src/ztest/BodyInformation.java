package ztest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.*;

public class BodyInformation extends JFrame implements ActionListener {
    // 입력 필드 및 버튼 선언
    private JTextField idField, emailField, passField, passConfirmField, nameField, phoneField, verifyCodeField;
    private JButton checkIdButton, verifyPhoneButton, registerButton;

    public BodyInformation() {
        setTitle("BodyInformation"); 
        setSize(440, 956); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 
        setResizable(false);

        int formWidth = 308;
        int centerX = (getWidth() - formWidth) / 3;
        int startY = 100; // 시작 Y 위치

        JLabel titleLabel = new JLabel("신체정보", JLabel.LEFT);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 32)); // 폰트 설정
        titleLabel.setBounds(centerX-20, startY - 95, 181, 58); // 위치 및 크기 설정
        add(titleLabel); // 화면에 추가
        
        // 구분선
        JSeparator divider1 = new JSeparator();
        divider1.setBounds(centerX-60, startY -30, 440, 2);
        add(divider1);

        JLabel idLabel = new JLabel("키");
        idLabel.setBounds(centerX + 15, startY + 70, 100, 20);
        add(idLabel);

        idField = new JTextField();
        idField.setText("CM");
        idField.setBounds(centerX + 15, startY + 95, 308, 41);
        System.out.println();
        idField.setText("cm");
        add(idField);

        JLabel emailLabel = new JLabel("몸무게");
        emailLabel.setBounds(centerX + 15, startY + 140, 100, 20);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(centerX + 15, startY + 165, formWidth, 41);
        add(emailField);

        JLabel passLabel = new JLabel("체지방률");
        passLabel.setBounds(centerX + 15, startY + 210, 100, 20);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(centerX + 15, startY + 235, formWidth, 41);
        add(passField);

        JLabel passConfirmLabel = new JLabel("체지방량");
        passConfirmLabel.setBounds(centerX + 15, startY + 280, 120, 20);
        add(passConfirmLabel);

        passConfirmField = new JPasswordField();
        passConfirmField.setBounds(centerX + 15, startY + 305, formWidth, 41);
        add(passConfirmField);

        JLabel nameLabel = new JLabel("골격근량");
        nameLabel.setBounds(centerX + 15, startY + 350, 100, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(centerX + 15, startY + 375, formWidth, 41);
        add(nameField);

        JLabel phoneLabel = new JLabel("나이");
        phoneLabel.setBounds(centerX + 15, startY + 420, 100, 20);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(centerX + 15, startY + 445, 308, 41);
        add(phoneField);

        registerButton = new JButton("확인");
        registerButton.setBounds(centerX + 105, startY + 600, 135, 46);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Jua", Font.BOLD, 24));
        registerButton.addActionListener(this);
        add(registerButton);

        setVisible(true); 
    }

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

    public static void main(String[] args) {
        new BodyInformation(); // 회원가입 페이지 생성
    }
}