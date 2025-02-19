package ui_n_utils;

import javax.swing.*;
import java.awt.*;

public class RoundedComponent extends JComponent {
    private int width, height, arcSize;
    private String type, text;
    private Color borderColor, backgroundColor, foregroundColor;
    private JComponent component;

    public RoundedComponent(int width, int height, int arcSize, String type, String text,
                            Color borderColor, Color backgroundColor, Color foregroundColor,
                            String fontName, int fontStyle, int fontSize) {
        this.width = width;
        this.height = height;
        this.arcSize = arcSize;
        this.type = type;
        this.text = text;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;

        setLayout(new BorderLayout());

        // ✅ 버튼, 텍스트 필드, 패스워드 필드 구분하여 처리
        switch (type.toLowerCase()) {
            case "textfield":
                component = new JTextField(text);
                break;
            case "password":
                component = new JPasswordField(text);
                break;
            case "button":
                JButton button = new JButton(text);
                button.setFocusPainted(false);
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                component = button;
                break;
            case "panel":
                JPanel panel = new JPanel();
                panel.setOpaque(false);
                panel.setLayout(new BorderLayout());
                component = panel;
                break;
            default:
                throw new IllegalArgumentException("지원되지 않는 타입: " + type);
        }

        // ✅ 사용자 정의 폰트 적용
        if (!(component instanceof JPanel)) {
            Font customFont = new Font(fontName, fontStyle, fontSize);
            component.setFont(customFont);
            component.setForeground(foregroundColor);
            component.setOpaque(false);
        }
        
        
        component.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(component, BorderLayout.CENTER);
    }

    public String getText() {
        if (component instanceof JTextField) {
            return ((JTextField) component).getText();
        } else if (component instanceof JPasswordField) {
            return new String(((JPasswordField) component).getPassword());
        }
        return "";
    }

    public JButton getButton() {
        return (component instanceof JButton) ? (JButton) component : null;
    }
    
    public JPanel getPanel() {
        return (component instanceof JPanel) ? (JPanel) component : null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

     // ✅ 패널 배경색 적용
        if (backgroundColor != null) {
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, width, height, arcSize, arcSize);
        }

        // ✅ 테두리 색상 적용
        if (borderColor != null) {
            g2.setColor(borderColor);
            g2.drawRoundRect(0, 0, width - 1, height - 1, arcSize, arcSize);
        }
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public JComponent getComponent() {
        return component;
    }
	
}
