package login;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    public MainFrame() {
        setTitle("알고먹자");
        setSize(440, 956);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // 로그인 & 회원가입 패널 추가
        LoginPanel loginPanel = new LoginPanel(this);
        JoinPanel joinPanel = new JoinPanel(this);

        mainPanel.add(loginPanel, "login");
        mainPanel.add(joinPanel, "join");

        add(mainPanel);
        setVisible(true);
    }

    // 패널 변경 메서드
    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
