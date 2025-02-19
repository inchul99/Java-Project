package main;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import panel.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("알고먹자");
        setSize(440, 956);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(Color.WHITE);

        // 패널 추가
        BodyinfoPanel bodyinfoPanel = new BodyinfoPanel(this);
        LoginPanel loginPanel = new LoginPanel(this);
        JoinPanel joinPanel = new JoinPanel(this);
        
        mainPanel.add(bodyinfoPanel,"bodyinfo");
        mainPanel.add(loginPanel, "login");
        mainPanel.add(joinPanel, "join");

        add(mainPanel);
        setVisible(true);
    }

    // 🔹 화면 전환 메서드
    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
