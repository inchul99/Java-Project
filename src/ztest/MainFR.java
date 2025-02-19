package ztest;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFR extends JFrame {
	private CardLayout cardLayout;
	private JPanel mainPanel;
	
	public MainFR() {
		setTitle("알고먹자");
		setSize(440,956);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		mainPanel.setBackground(Color.WHITE);
		
		// 패널 추가부분
		Login login = new Login(this);
		Register register = new Register(this);
		
		login.setBackground(Color.white);
		
		mainPanel.add(login,"login");
		mainPanel.add(register,"register");
		
		add(mainPanel);
		setVisible(true);
	}
	
	//화면전화
	public void showPanel(String name) {
		cardLayout.show(mainPanel, name);
	}
	
	 public static void main(String[] args) {
		 new MainFR();
	 }

}
