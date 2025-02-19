package algomeokJa;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import algomeokJa.FoodSearchMgr;
import agui.MainButton;
import agui.RoundTF;

public class SearchPanel extends JPanel implements ActionListener {

    private CardLayout contentLayout;
    private JPanel contentPanel;
    private JPanel searchPanel, favoritePanel, mostviewedPanel;
    private JButton tab1, tab2, searchTab;
    private RoundTF searchField;
    private JPanel resultPanel;

    public SearchPanel() {
        setLayout(new BorderLayout());

        // 탭 패널 (항상 유지됨)
        JPanel tabPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        tabPanel.setPreferredSize(new Dimension(440, 30));
        tabPanel.setBackground(new Color(0xA0D468));

        searchTab = new MainButton("검색");
        tab1 = new MainButton("즐겨찾기");
        tab2 = new MainButton("조회수");

        searchTab.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        tab1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        tab2.setFont(new Font("맑은 고딕", Font.BOLD, 12));

        searchTab.addActionListener(this);
        tab1.addActionListener(this);
        tab2.addActionListener(this);

        // 검색 버튼을 가장 왼쪽에 배치
        tabPanel.add(searchTab);
        tabPanel.add(tab1);
        tabPanel.add(tab2);

        add(tabPanel, BorderLayout.NORTH);

        // 검색 패널 & 즐겨찾기 패널을 관리하는 CardLayout
        contentLayout = new CardLayout();
        contentPanel = new JPanel(contentLayout);

        // 검색 패널 (기본 화면)
        searchPanel = new JPanel(new BorderLayout());

        // 검색창
        JPanel searchBox = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchField = new RoundTF(15);
        searchField.setPreferredSize(new Dimension(400, 35));
        searchField.setText("무슨 음식을 드셨나요?...");
        searchField.setForeground(Color.LIGHT_GRAY);

        searchBox.add(searchField);
        searchPanel.add(searchBox, BorderLayout.NORTH);

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateResults();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateResults();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateResults();
            }
        });

        // 기본 검색어 삭제 및 포커스 처리
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("무슨 음식을 드셨나요?...")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().trim().isEmpty()) {
                    searchField.setText("무슨 음식을 드셨나요?...");
                    searchField.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        // 검색 결과 패널
        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(resultPanel);

        searchPanel.add(scrollPane, BorderLayout.CENTER);

        // 즐겨찾기 & 조회수 패널
        favoritePanel = new FavoritePanel();
        mostviewedPanel = new MostViewedPanel();

        // contentPanel에 검색 패널 & 즐겨찾기 패널 추가
        contentPanel.add(searchPanel, "search");
        contentPanel.add(favoritePanel, "favorite");
        contentPanel.add(mostviewedPanel, "mostview");

        add(contentPanel, BorderLayout.CENTER);
    }

    // 검색 결과 업데이트 - 나중에 DB 연결도 해야 함
    private void updateResults() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty() || keyword.equals("무슨 음식을 드셨나요?...")) {
            return;
        }
        //기존 검색 삭제
       resultPanel.removeAll();
       
       //DB에서 검색 실행
       Vector<String[]> results = FoodSearchMgr.searchFood(keyword);
       
       //검색 결과 없을 경우
      if(results.isEmpty()) {
    	  JLabel noResultLabel = new JLabel("검색 결과 없음");
    	  noResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	  resultPanel.add(noResultLabel);
      }else {
    	  for (String[] foodData : results) {
			String foodName = foodData[0];
			String foodKcal = foodData[1];
			
			JLabel foodLabel = new JLabel("음식명: " + foodName + "|"+ foodKcal);
			foodLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
			
			resultPanel.add(foodLabel);
		}
      }
      resultPanel.revalidate();
      resultPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchTab) { 
            showSearchPanel();
        } else if (e.getSource() == tab1) {
            contentLayout.show(contentPanel, "favorite");
        } else if (e.getSource() == tab2) {
            contentLayout.show(contentPanel, "mostview");
        }

        // 탭 전환 시 검색창 초기화 여부 결정 (현재는 초기화됨)
        resetSearchField();
    }

    // 검색 패널로 자동 복귀
    public void showSearchPanel() {
        contentLayout.show(contentPanel, "search");
    }

    private void resetSearchField() {
        searchField.setText("무슨 음식을 드셨나요?...");
        searchField.setForeground(Color.LIGHT_GRAY);
    }
}
