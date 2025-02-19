package UIutils;

import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {
    private int radius = 15;

    public RoundButton(String text, Color bgColor, Color textColor) {
        super(text);
        setFont(new Font("Inter", Font.BOLD, 15));
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
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {}
}
