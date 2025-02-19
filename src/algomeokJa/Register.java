package algomeokJa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import agui.RoundBT;
import agui.RoundPF;
import agui.RoundTF;

public class Register extends JPanel implements ActionListener {
	
	private MainFR parent;
	private JTextField idField, emailField, passField, passConfirmField, nameField, phoneField, verifyCodeField;
	private JButton checkIdButton, verifyPhoneButton, registerButton, backButton;
	
	  public Register(MainFR parent) {
			this.parent = parent;
	        setLayout(null);
	        // ======== 상단 제목 ========
	        JLabel titleLabel = new JLabel("회원가입", JLabel.LEFT);
	        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 32)); // 폰트 설정
	        titleLabel.setBounds(21, 5, 181, 58); // 위치 및 크기 설정
	        add(titleLabel); // 화면에 추가

	        // ======== 아이디 입력 ========
	        JLabel idLabel = new JLabel("아이디 *");
	        idLabel.setBounds(26, 140, 100, 20);
	        add(idLabel);

	        idField = new RoundTF(10);
	        idField.setBounds(26, 165, 260, 41);
	        add(idField);

	        checkIdButton = new RoundBT("ID중복확인",10);
	        checkIdButton.setBounds(296, 165, 105, 41);
	        checkIdButton.setFont(new Font("Jua", Font.PLAIN, 14));
	        checkIdButton.setBackground(Color.black);
	        checkIdButton.setForeground(Color.WHITE);
	        checkIdButton.addActionListener(this);
	        add(checkIdButton);

	        // ======== 이메일 입력 ========
	        JLabel emailLabel = new JLabel("이메일 *");
	        emailLabel.setBounds(26, 210, 100, 20);
	        add(emailLabel);

	        emailField = new RoundTF(10);
	        emailField.setBounds(26, 235, 376, 41);

	        add(emailField);

	        // ======== 비밀번호 입력 ========
	        JLabel passLabel = new JLabel("비밀번호 *");
	        passLabel.setBounds(26, 280, 100, 20);

	        add(passLabel);

	        passField = new RoundPF(10);
	        passField.setBounds(26, 305, 376, 41);

	        add(passField);

	        // ======== 비밀번호 확인 ========
	        JLabel passConfirmLabel = new JLabel("비밀번호 확인 *");
	        passConfirmLabel.setBounds(26, 350, 120, 20);

	        add(passConfirmLabel);

	        passConfirmField = new RoundPF(10);
	        passConfirmField.setBounds(26, 375, 376, 41);

	        add(passConfirmField);

	        // ======== 이름 입력 ========
	        JLabel nameLabel = new JLabel("이름 *");
	        nameLabel.setBounds(26, 420, 100, 20);

	        add(nameLabel);

	        nameField = new RoundTF(10);
	        nameField.setBounds(26, 445, 376, 41);

	        add(nameField);

	        // ======== 휴대폰 번호 입력 ========
	        JLabel phoneLabel = new JLabel("휴대폰 번호");
	        phoneLabel.setBounds(26, 490, 100, 20);

	        add(phoneLabel);

	        phoneField = new RoundTF(10);
	        phoneField.setBounds(26, 515, 260, 41);
	        phoneField.setBackground(Color.WHITE);
	        add(phoneField);

	        verifyPhoneButton = new RoundBT("인증번호받기", 10);
	        verifyPhoneButton.setBounds(296, 515, 105, 40);
	        verifyPhoneButton.setFont(new Font("Jua", Font.PLAIN, 14));
	        verifyPhoneButton.setBackground(Color.black);
	        verifyPhoneButton.setForeground(Color.WHITE);
	        verifyPhoneButton.addActionListener(this);
	        add(verifyPhoneButton);

	        // ======== 인증번호 입력 ========
	        verifyCodeField = new RoundTF(10);
	        verifyCodeField.setBounds(141, 560, 146, 37);
	        add(verifyCodeField);

	        // ======== 회원가입 버튼 ========
	        registerButton = new RoundBT("회원가입",10);
	        registerButton.setBounds(126, 690, 187, 50);
	        registerButton.setBackground(Color.BLACK);
	        registerButton.setForeground(Color.WHITE);
	        registerButton.setFont(new Font("Jua", Font.BOLD, 20));
	        registerButton.addActionListener(this);
	        add(registerButton);
	        
	        //뒤로가기
	        backButton = new JButton("<");
	        backButton.setBounds(360, 20, 60, 60);
	        backButton.addActionListener(this);
	        backButton.setBorderPainted(false);  
	        backButton.setContentAreaFilled(false);  
	        backButton.setFocusPainted(false);  
	        add(backButton);
	        
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
	        }else if(e.getSource() == backButton) {
	        	parent.showPanel("login");
	        }
	    }

	    /** 프로그램 실행 진입점 (main 메서드)*/
	}

