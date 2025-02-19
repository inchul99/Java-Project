package ui_n_utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextField;

public class RoundTF extends JTextField {
	int arcSize;
	public  RoundTF(int arcSize) {
		this.arcSize = arcSize;
		setOpaque(false);
		setBorder(null);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		 if(getBackground() != null) {
			 g2.setColor(getBackground());
			 g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcSize, arcSize);
		 }
		 
		super.paintComponent(g);
		g2.dispose();
	}
}
