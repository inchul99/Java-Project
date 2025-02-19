package ztest;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("로그인 & 회원가입");
        setSize(440, 956);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 📌 CardLayout 설정
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // 📌 로그인 화면과 회원가입 화면 추가
        LoginPanel loginPanel = new LoginPanel(this);
        RegisterPanel registerPanel = new RegisterPanel(this);

        mainPanel.add(loginPanel, "login");
        mainPanel.add(registerPanel, "register");

        add(mainPanel);
        setVisible(true);
    }

    // 📌 화면 전환 메서드
    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public static void main(String[] args) {
        new MainFrame(); // 메인 프레임 실행
    }
}
