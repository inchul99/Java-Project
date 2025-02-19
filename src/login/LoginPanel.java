package login;

import javax.swing.*;

import UIutils.RoundButton;
import UIutils.RoundPasswordField;
import UIutils.RoundTextField;
import UIutils.UIUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener {

	private JButton signUpButton, loginButton;
	private JTextField loginField;
	private JPasswordField passwordField;
	private JCheckBox rememberMe;
	private LoginDAO loginDAO;
	private MainFrame mainFrame;

	public LoginPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		loginDAO = new LoginDAO(); // DAO 인스턴스 생성

		setBackground(Color.WHITE);
		setLayout(null);

		// 폰트 설정
		Font interBold22 = new Font("Inter", Font.BOLD, 22);
		Font interBold15 = new Font("Inter", Font.BOLD, 15);
		Font interRegular12 = new Font("Inter", Font.PLAIN, 12);

		// 상단 문구
		JLabel titleLabel = new JLabel("\"건강한 식단 관리, 함께 시작해요!\"", SwingConstants.CENTER);
		titleLabel.setFont(interBold22);
		titleLabel.setBounds(48, 263, 345, 59);
		add(titleLabel);

		// 로그인 필드 레이블
		JLabel loginLabel = new JLabel("로그인");
		loginLabel.setFont(interBold15);
		loginLabel.setBounds(64, 360, 313, 38);
		add(loginLabel);

		// 로그인 입력 필드 (둥근 입력 필드 사용)
		loginField = new RoundTextField(20);
		loginField.setBounds(62, 398, 315, 40);
		add(loginField);

		// 비밀번호 필드 레이블
		JLabel passwordLabel = new JLabel("비밀번호");
		passwordLabel.setFont(interBold15);
		passwordLabel.setBounds(62, 459, 313, 38);
		add(passwordLabel);

		// 비밀번호 입력 필드 (둥근 입력 필드 사용)
		passwordField = new RoundPasswordField(20);
		passwordField.setBounds(62, 495, 315, 40);
		add(passwordField);

		// Remember me & Forgot password
		rememberMe = new JCheckBox("Remember me");
		rememberMe.setFont(interRegular12);
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
		loginButton = new RoundButton("Login", new Color(192, 233, 147), Color.BLACK);
		loginButton.setBounds(64, 598, 132, 40);
		loginButton.addActionListener(this);
		add(loginButton);

		// 회원가입 버튼 (둥근 버튼 사용)
		signUpButton = new RoundButton("회원가입", Color.BLACK, Color.WHITE);
		signUpButton.setBounds(242, 598, 135, 40);
		signUpButton.addActionListener(this);
		add(signUpButton);
	}

	// 🔹 버튼 클릭 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			String userId = loginField.getText();
			String userPwd = new String(passwordField.getPassword());

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
		} else if (e.getSource() == signUpButton) {
			mainFrame.showPanel("join"); // 회원가입 패널로 이동
			
		}
	}
}
