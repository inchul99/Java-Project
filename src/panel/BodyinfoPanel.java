package panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.MainFrame;
import ui_n_utils.BottonNav;

public class BodyinfoPanel extends JPanel implements ActionListener {
    
	private CardLayout mainCardLayout;
	private JPanel homePanel, calendarPanel, workoutPanel, profilePanel;
	private JPanel bottomNav, mainPanel;
    private BottonNav[] buttons;
    private BottonNav btnHome, btnCalendar, btnWorkout, btnProfile;
    private MainFrame mainFrame;
    private JButton tabStatus, tabMeal, tabGoal;

    
    public BodyinfoPanel(MainFrame mainFrame) {
    	this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        //카드레이아웃 화면 전환
        mainCardLayout = new CardLayout();
        mainPanel = new JPanel(mainCardLayout);
        
        //패널 생성
        homePanel = new HomePanel();
        //calendarPanel = new CalendarPanel();
       //workoutPanel = new WorkoutPanel();
       //profilePanel = new ProfilePanel();
       
        mainPanel.add(homePanel, "home");
        //mainPanel.add(calendarPanel, "calendar");
        //mainPanel.add(workoutPanel, "workout");
       // mainPanel.add(profilePanel, "profile");
        
        add(mainPanel, BorderLayout.CENTER);
        
        // 상단 패널 추가
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(440, 109));
        topPanel.setBackground(Color.white);

        // 제목
        JLabel titleLabel = new JLabel("알고먹자");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
        titleLabel.setHorizontalAlignment(JLabel.LEFT);
        titleLabel.setForeground(new Color(0xC0E993));
        titleLabel.setBorder(new EmptyBorder(0, 20, 0, 0));

        // 공지사항
        JLabel notice = new JLabel("<html>공지<br>사항</html>");
        notice.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        notice.setHorizontalAlignment(JLabel.RIGHT);
        notice.setForeground(new Color(0xC0E993));
        notice.setBorder(new EmptyBorder(0, 0, 0, 20));
       
        // 상단 패널 추가 - 탑패널
        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(notice, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);
        
        
        //하단 네비게이션 바 (4등분)
        bottomNav = new JPanel(new GridLayout(1, 4));
        bottomNav.setPreferredSize(new Dimension(440, 100));
        bottomNav.setBackground(Color.WHITE);

        //  버튼 추가 (아이콘 경로는 실제 이미지 파일 경로로 변경해야 함)
        btnHome = new BottonNav("홈","C:\\Java\\myJava\\algomeokJa\\home1.png","C:\\Java\\myJava\\algomeokJa\\home.png");
        btnCalendar = new BottonNav("캘린더", "C:\\Java\\myJava\\algomeokJa\\calender1.png","C:\\Java\\myJava\\algomeokJa\\calender.png");
        btnWorkout = new BottonNav("운동", "C:\\Java\\myJava\\algomeokJa\\gym1.png", "C:\\Java\\myJava\\algomeokJa\\gym.png");
        btnProfile = new BottonNav("내 정보","C:\\Java\\myJava\\algomeokJa\\profile1.png", "C:\\Java\\myJava\\algomeokJa\\profile.png");

        // 버튼 배열로 관리
        buttons = new BottonNav[]{btnHome, btnCalendar, btnWorkout, btnProfile};

        //이벤트 리스너 추가 및 하단 패널에 버튼 추가
        for (BottonNav btn : buttons) {
            btn.addActionListener(this);
            bottomNav.add(btn);
        }

        // 기본 선택값 (홈 버튼 선택)
        setSelectedButton(btnHome);

        // 하단 네비게이션 바 추가
        add(bottomNav, BorderLayout.SOUTH);

        setVisible(true);
    }

    //버튼 선택 시 아이콘 변경
    private void setSelectedButton(BottonNav selectedBtn) {
        for (BottonNav btn : buttons) {
            btn.setSelected(btn == selectedBtn);
        }
        //버튼 선택에 따른 패널 전환
        if(selectedBtn == btnHome) {
        	mainCardLayout.show(mainPanel,"home");
        }else if(selectedBtn == btnCalendar) {
        	mainCardLayout.show(mainPanel,"calendar");
        }else if(selectedBtn == btnWorkout) {
        	mainCardLayout.show(mainPanel,"workout");
        }else if(selectedBtn == btnProfile) {
        	mainCardLayout.show(mainPanel,"profile");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (BottonNav btn : buttons) {
            if (e.getSource() == btn) {
                setSelectedButton(btn);
                return;
            }
        }
        
        if (e.getSource() == tabStatus) {
            mainCardLayout.show(mainPanel, "status");
        } else if (e.getSource() == tabMeal) {
            mainCardLayout.show(mainPanel, "meal");
        } else if (e.getSource() == tabGoal) {
            mainCardLayout.show(mainPanel, "goal");
        }
    }
}