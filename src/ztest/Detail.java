package ztest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Detail {
	
		static class RoundTF extends JTextField{
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
	    }//--RoundTF
		
			static class RoundPF extends  JPasswordField{
				
				int arcSize;
				
				public  RoundPF(int arcSize) {
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
		}//-- RoundPF
			
	//버튼 모서리 둥글게
	static class RoundBT extends  JButton{
		       
				int arcSize;
				
				public  RoundBT(String text, int arcSize) {
					 super(text);
					this.arcSize = arcSize;
					setOpaque(true);
					setBorder(null);
					setFocusPainted(false);
			        setContentAreaFilled(false);
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
		}//-- RoundBT

	
	
	 
}
