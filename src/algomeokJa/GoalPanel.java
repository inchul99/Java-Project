package algomeokJa;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GoalPanel extends JPanel {
	public GoalPanel() {
		setLayout(new BorderLayout()); // 패널 레이아웃 설정
	     setBackground(Color.red); // 패널 배경색 설정
	     add(new JLabel("목표", SwingConstants.CENTER)); // 라벨 추가
	}

}
