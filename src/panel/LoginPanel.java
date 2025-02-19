package panel;

import javax.swing.*;

import DB.LoginDAO;
import main.MainFrame;
import ui_n_utils.CustomDialog;
import ui_n_utils.RoundedComponent;
import ui_n_utils.UIUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener {
	
	private RoundedComponent loginField, passwordField, loginButton, signUpButton;

	private JCheckBox rememberMe;
	private LoginDAO loginDAO;
	private MainFrame mainFrame;

	public LoginPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		loginDAO = new LoginDAO(); // DAO 인스턴스 생성

		setBackground(Color.WHITE);
		setLayout(null);

		// 상단 문구
		JLabel titleLabel = new JLabel("\"건강한 식단 관리, 함께 시작해요!\"", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Inter", Font.BOLD, 22));
		titleLabel.setBounds(48, 263, 345, 59);
		add(titleLabel);

		// 로그인 필드 레이블
		add(UIUtils.createRequiredLabel("아이디", Color.black,64, 360, "Inter",Font.BOLD, 15));
		// 로그인 입력 필드 (둥근 입력 필드 사용)
		loginField = new RoundedComponent(315, 40, 20, "textfield", ""
				, new Color(217, 217, 217), new Color(217, 217, 217), Color.black, 
				"Inter",Font.PLAIN, 14);
		loginField.setBounds(62, 398, 315, 40);
		add(loginField);

		
		// 비밀번호 필드 레이블
		add(UIUtils.createRequiredLabel("비밀번호", Color.black, 62, 459, "Inter", Font.BOLD, 15));
		// 비밀번호 입력 필드 (둥근 입력 필드 사용)
		passwordField = new RoundedComponent(315, 40, 20, "password", "",
				new Color(217, 217, 217), new Color(217, 217, 217), Color.black,
				"Inter", Font.PLAIN, 14);
		passwordField.setBounds(62, 495, 315, 40);
		add(passwordField);

		// Remember me & Forgot password
		rememberMe = new JCheckBox("Remember me");
		rememberMe.setFont(new Font("Inter", Font.PLAIN, 12));
		rememberMe.setBounds(64, 570, 120, 20);
		rememberMe.setBackground(Color.WHITE);
		rememberMe.setFocusPainted(false);
		add(rememberMe);

		JLabel forgotPass = new JLabel("Forgot password/ID?");
		forgotPass.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		forgotPass.setForeground(Color.BLACK);
		forgotPass.setBounds(260, 570, 150, 20);
		add(forgotPass);
		
		// 로그인 버튼 (둥근 버튼 사용)
		loginButton = new RoundedComponent(132, 40, 20, "button", "Login", 
				new Color(192, 233, 147), new Color(192, 233, 147), Color.black, 
				"Inter",Font.BOLD, 14);
		loginButton.setBounds(64, 598, 132, 40);
		loginButton.getButton().addActionListener(this);
		add(loginButton);

		// 회원가입 버튼 (둥근 버튼 사용)
		signUpButton = new RoundedComponent(132, 40, 20, "button", "회원가입", 
				Color.BLACK, Color.BLACK, Color.WHITE, "Inter",Font.BOLD, 14);
		
		signUpButton.setBounds(242, 598, 135, 40);
		signUpButton.getButton().addActionListener(this);
		add(signUpButton);
	}

	// 🔹 버튼 클릭 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton.getButton()) {
			String userId = loginField.getText();
			String userPwd = new String(passwordField.getText());

			if (userId.isEmpty() || userPwd.isEmpty()) {
				CustomDialog.showDialog(mainFrame, "아이디와 비밀번호를 입력하세요.", "로그인 오류");
			} else {
				boolean loginSuccess = loginDAO.checkLogin(userId, userPwd);

				if (loginSuccess) {
					CustomDialog.showDialog(mainFrame, "로그인 성공!", "로그인 완료");
					System.out.println("로그인 성공: " + userId);
				} else {
					CustomDialog.showDialog(mainFrame, "아이디 혹은 비밀번호가 틀렸습니다.", "로그인 실패");
				}
			}
		} else if (e.getSource() == signUpButton.getButton()) {
			mainFrame.showPanel("join"); // 회원가입 패널로 이동		
		}
	}
}
