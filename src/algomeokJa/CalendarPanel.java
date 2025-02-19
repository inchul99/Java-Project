package algomeokJa;

import javax.swing.*;
import java.awt.*;

public class CalendarPanel extends JPanel {
    public CalendarPanel() {
        setLayout(new BorderLayout()); // 패널 레이아웃 설정
        setBackground(Color.CYAN); // 패널 배경색 설정
        add(new JLabel("📅 캘린더 화면", SwingConstants.CENTER)); // 라벨 추가
    }
}
