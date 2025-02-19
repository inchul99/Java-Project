package ztest;

import javax.swing.*;
import java.awt.*;

public class CustomInputField {
    public static void main(String[] args) {
        // 프레임 설정
        JFrame frame = new JFrame("아이디 입력 폼");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        // ✅ 아이디 라벨 (폰트 및 스타일 적용)
        JLabel label = new JLabel("아이디 ");
        label.setFont(new Font("Malgun Gothic", Font.BOLD, 16));

        // ✅ 빨간색 * 표시 추가
        JLabel starLabel = new JLabel("*");
        starLabel.setForeground(Color.RED);
        starLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 16));

        // ✅ 텍스트 필드 (둥근 모서리 & 안쪽 여백)
        JTextField textField = new RoundedTextField(20); // 사용자 정의 둥근 텍스트 필드
        textField.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        textField.setPreferredSize(new Dimension(250, 40));

        // ✅ 둥근 버튼 (스타일 적용)
        JButton button = new RoundedButton("ID 중복확인");
        button.setPreferredSize(new Dimension(120, 40));

        // ✅ 패널에 요소 추가
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(label);
        panel.add(starLabel);
        panel.add(textField);
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }

    // ✅ [커스텀] 둥근 텍스트 필드 클래스
    static class RoundedTextField extends JTextField {
        public RoundedTextField(int columns) {
            super(columns);
            setOpaque(false); // 배경 투명
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 내부 여백
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            g2.setColor(Color.BLACK);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            super.paintComponent(g);
            g2.dispose();
        }
    }

    // ✅ [커스텀] 둥근 버튼 클래스
    static class RoundedButton extends JButton {
        public RoundedButton(String text) {
            super(text);
            setFont(new Font("Malgun Gothic", Font.BOLD, 14));
            setForeground(Color.WHITE);
            setBackground(Color.BLACK);
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            g2.setColor(Color.BLACK);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            g2.setColor(Color.WHITE);
            FontMetrics fm = g2.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(getText())) / 2;
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
            g2.drawString(getText(), x, y);
            g2.dispose();
        }
    }
}

