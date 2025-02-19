package algomeokJa;

import java.awt.CardLayout;

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
		
		// 패널 추가부분 구현
		Login login = new Login(this);
		Register register = new Register(this);
		BaseLayout base = new BaseLayout(this);
		
		
		//mainPanel.add(login,"login");
		//mainPanel.add(register,"register");
		mainPanel.add(base,"base");
		
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
