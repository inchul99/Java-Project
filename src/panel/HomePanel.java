package panel;
import javax.swing.*;

import ui_n_utils.MainButton;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class HomePanel extends JPanel implements ActionListener {
		
		private JButton tab1, tab2, tab3;
		private JPanel tabPanel, contentPanel;
		private CardLayout contentLayout;
		 
	    public HomePanel() {
	        setLayout(new BorderLayout());
	        setBackground(new Color(0xC0E993));
	        
	        // 탭 패널 (중앙)
	        tabPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
	        tabPanel.setPreferredSize(new Dimension(440, 50));
	        tabPanel.setOpaque(false);

	        tab1 = new MainButton("일일 현황");
	        tab2 = new MainButton("식단 기록");
	        tab3 = new MainButton("목표달성");
	        
	        tab1.addActionListener(this);
	        tab2.addActionListener(this);
	        tab3.addActionListener(this);

	        tabPanel.add(tab1);
	        tabPanel.add(tab2);
	        tabPanel.add(tab3);
	        
	        add(tabPanel, BorderLayout.NORTH);   
	        
	        //3가지 패널
	        contentLayout = new CardLayout();
	        contentPanel = new JPanel(contentLayout);
	        
	        //contentPanel.add(new DailyPanel(), "daily");
	        contentPanel.add(new Home_mealPanel(), "meal");
	        //contentPanel.add(new GoalPanel(), "goal");
	        
	        add(contentPanel, BorderLayout.CENTER);
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	if(e.getSource() == tab1) {
	    		//contentLayout.show(contentPanel,"daily");
	    	}else if(e.getSource() == tab2) {
	    		contentLayout.show(contentPanel,"meal");
	    	}else if(e.getSource() == tab3) {
	    		//contentLayout.show(contentPanel,"goal");
	    	}
	    }
	    
	}
	

