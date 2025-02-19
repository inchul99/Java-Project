package agui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MainButton extends JButton{
	private boolean isHovered = false;
	
	public MainButton(String text) {
		super(text);
		setOpaque(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setFont(new Font("맑은 고딕", Font.BOLD,16));
		setForeground(Color.black);
		
		//마우스 이벤트 추가
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				isHovered = true;
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				isHovered = false;
				repaint();
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(isHovered) {
			 int lineWidth = (int) (getWidth()*2);
			 int xPosition = (getWidth() - lineWidth) / 2;
			g.setColor(Color.black);
			g.fillRect(xPosition, getHeight() - 5, lineWidth, 3);
		}
	}

}
