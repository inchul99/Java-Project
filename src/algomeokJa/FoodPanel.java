package algomeokJa;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import agui.MainButton;
import agui.RoundTF;

public class FoodPanel extends JPanel implements ActionListener {
    
    private CardLayout contentLayout;
    private JPanel contentPanel, tabPanel;
    private JButton tab1, tab2;
    private SavePL savePanel;
	private SearchPanel searchPanel;

    public FoodPanel() {
        setLayout(new BorderLayout());

        // 1. 탭 패널 (검색 / 담은 목록)
        tabPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        tabPanel.setPreferredSize(new Dimension(440, 35));

        tab1 = new MainButton("검색");
        tab2 = new MainButton("담은 목록");
        
        
        tab1.addActionListener(this);
        tab2.addActionListener(this);

        tabPanel.add(tab1);
        tabPanel.add(tab2);

        add(tabPanel, BorderLayout.NORTH);

        contentLayout = new CardLayout();
        contentPanel = new JPanel(contentLayout);
        
        searchPanel = new SearchPanel();
        savePanel = new SavePL();
        
        contentPanel.add(searchPanel, "search");
        contentPanel.add(savePanel, "save");

        add(contentPanel, BorderLayout.CENTER);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tab1) { 
            contentLayout.show(contentPanel, "search"); // 검색 화면
        } else if (e.getSource() == tab2) { 
            contentLayout.show(contentPanel, "save"); // 담은 목록
    }
}
    }
