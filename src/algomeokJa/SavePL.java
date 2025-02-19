package algomeokJa;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SavePL extends JPanel{
	
	 private JPanel savePanel;
	 
public SavePL() {
	setLayout(new BorderLayout());
	setBackground(Color.LIGHT_GRAY);
    add(new JLabel("📦 담은 목록", SwingConstants.CENTER), BorderLayout.CENTER);
     
     

}
}
