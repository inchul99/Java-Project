package algomeokJa;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ProfilePanel extends JPanel {
	public ProfilePanel() {
		 setLayout(new BorderLayout()); // 패널 레이아웃 설정
	        setBackground(Color.yellow); // 패널 배경색 설정
	        add(new JLabel("내정보", SwingConstants.CENTER));
	}
}
