package main;

import javax.swing.*;

import ui_n_utils.RoundedComponent;

import java.awt.*;

public class MainUserFrame extends JFrame {
    
    public MainUserFrame() {
        setTitle("알고먹자");
        setSize(440, 956);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        RoundedComponent roundedPanel = new RoundedComponent(
        	    300, 200, 20, "panel", "",
        	    new Color(192,233,147), new Color(192,233,147), new Color(192,233,147), "Inter", Font.PLAIN, 15
        	);
        JPanel panel = roundedPanel.getPanel();
        panel.add(new JLabel("둥근 패널 내부 요소"), BorderLayout.CENTER);
        	
       
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainUserFrame().setVisible(true);
        });
    }
}
