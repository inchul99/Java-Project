package panel;

import javax.swing.*;
import java.awt.*;
import ui_n_utils.RoundedComponent;

public class RoundedPanelExample extends JFrame {
	private CardLayout cardLayout;
	
    public RoundedPanelExample() {
        setTitle("Rounded Panel Test");
        setSize(440, 956);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        cardLayout = new CardLayout();

        // ✅ 패널 내부에 컴포넌트 추가
        //RoundedComponent panel = new RoundedComponent(440, 956, 0, "Panel", "배경패널", 
        //		new Color(192, 233, 147), new Color(192, 233, 147), 
        //		Color.BLACK, "Inter", Font.PLAIN, 32);
        //panel.setBounds(0, 0, 440, 956);
        //add(panel);
        
        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 10, 440, 956);
        panel2.setBackground(Color.black);
        
        // ✅ 둥근 패널 생성
        RoundedComponent roundedPanel = new RoundedComponent(
        		440, 100, 0, "panel", "", 
            Color.white, Color.white, Color.BLACK, 
            "Inter", Font.PLAIN, 15
        );
        roundedPanel.setBounds(-10, -10, 440, 100);
        
        
        JLabel label = new JLabel("상단 패널", SwingConstants.CENTER);
        label.setFont(new Font("Inter", Font.BOLD, 20));
        roundedPanel.add(label);
        panel2.add(roundedPanel);
        add(panel2);
        setVisible(true);	
    }

    public static void main(String[] args) {
        new RoundedPanelExample();
    }
}
