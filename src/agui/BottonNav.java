package agui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BottonNav extends JButton {
    private ImageIcon defaultIcon;  // 기본 아이콘
    private ImageIcon selectedIcon; // 선택 시 아이콘
    private boolean isSelected = false;
    private JLabel iconLabel;
    private JLabel textLabel; 

    public BottonNav(String text, String defaultIconPath, String selectedIconPath) {
    	super();
    	setLayout(new BorderLayout());
    	setPreferredSize(new Dimension(80, 80));
        setBackground(Color.WHITE); 
        setFocusPainted(false); 
        setBorderPainted(false); 
        
        // 아이콘 로드
        defaultIcon = loadImage(defaultIconPath,40,40);
        selectedIcon =  loadImage(selectedIconPath,40,40);
       // setIcon(defaultIcon); // 기본 아이콘 설정
        
        JLabel iconLabel = new JLabel(defaultIcon, SwingConstants.CENTER);
        JLabel icon2Label = new JLabel(selectedIconPath, SwingConstants.CENTER);
        iconLabel.setText(null);
        icon2Label.setText(null);
        textLabel = new JLabel(text, SwingConstants.CENTER);
        setFont(new Font("맑은 고딕", Font.BOLD,11));
        
        add(iconLabel, BorderLayout.CENTER);
        add(icon2Label, BorderLayout.CENTER);
        add(textLabel, BorderLayout.SOUTH);
        setHorizontalAlignment(SwingConstants.CENTER);
       // setVerticalAlignment(SwingConstants.BOTTOM);
    }
    
    private ImageIcon loadImage(String path, int width, int height) {
        File file = new File(path);
        if (file.exists()) {
            return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        }

        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        }

        System.out.println("이미지를 찾을 수 없음: " + path);
        return null;
    }

    // 버튼 선택 상태 변경 (아이콘 교체)
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    	if (isSelected) {
            setIcon(selectedIcon);
            textLabel.setForeground(Color.BLACK);
        } else {
            setIcon(defaultIcon);
            textLabel.setForeground(Color.gray);
        }
    }
 }