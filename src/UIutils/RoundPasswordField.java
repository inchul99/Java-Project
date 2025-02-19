package UIutils;

import javax.swing.*;
import java.awt.*;

public class RoundPasswordField extends JPasswordField {
    private int radius = 10;

    public RoundPasswordField(int columns) {
        super(columns);
        setOpaque(false);
        setFont(new Font("Inter", Font.PLAIN, 14));
        setBackground(new Color(217, 217, 217));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
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
