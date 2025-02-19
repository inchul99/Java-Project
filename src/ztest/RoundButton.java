package ztest;

import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {
    private int arcSize;

    public RoundButton(String text, Color bgColor, Color textColor, int arcSize) {
        super(text);
        this.arcSize = arcSize;
        setBackground(bgColor);
        setForeground(textColor);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 버튼 배경
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcSize, arcSize);
        
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 테두리 적용
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);
        
        g2.dispose();
    }
}
