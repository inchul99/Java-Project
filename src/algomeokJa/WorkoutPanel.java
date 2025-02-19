package algomeokJa;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WorkoutPanel extends JPanel {

	public WorkoutPanel() {
		 setLayout(new BorderLayout()); // 패널 레이아웃 설정
	        setBackground(Color.green); // 패널 배경색 설정
	        add(new JLabel("운동", SwingConstants.CENTER));
	}
	
}
