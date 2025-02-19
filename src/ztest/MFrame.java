package ztest;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MFrame extends Frame{
	
	MFrame() {
		this(300, 300, new Color(220, 220, 220));
	}
	
	MFrame(int w, int h) {
		this(w, h, new Color(220, 220, 220));
	}
	
	MFrame(Color c) {
		this(300, 300, c);
	}
	
	MFrame(int w, int h, Color c) {
		//setLayout(new FlowLayout()); //기본값 BoderLayout
		setTitle("제목");
		setSize(w, h);
		setBackground(c);
		setResizable(false);
		setVisible(true);
		//종료기능
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		validate();
	}
	
	public static void main(String[] args) {
		MFrame m1 = new MFrame();
		MFrame m2 = new MFrame(150, 150);
		MFrame m3 = new MFrame(Color.CYAN);
		MFrame m4 = new MFrame(400, 400, Color.MAGENTA);
	}
}


