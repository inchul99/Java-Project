package algomeokJa;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FavoritePanel extends JPanel {
	public FavoritePanel() {
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
	    add(new JLabel("즐겨찾기", SwingConstants.CENTER), BorderLayout.CENTER);
	}
}
