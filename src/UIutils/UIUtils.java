package UIutils;

import javax.swing.*;
import java.awt.*;

public class UIUtils {

    // ✅ 필수 입력 라벨 생성 (* 자동 추가)
    public static JLabel createRequiredLabel(String text, int x, int y) {
        JLabel label = new JLabel(text + " *"); // 자동으로 * 추가
        label.setFont(new Font("Inter", Font.PLAIN, 15));
        label.setBounds(x, y, 120, 21);
        label.setForeground(Color.BLACK);
        return label;
    }

    // ✅ 에러 메시지 라벨 생성
    public static JLabel createErrorLabel(int x, int y, int a) {
        JLabel label = new JLabel();
        label.setFont(new Font("Inter", Font.PLAIN, a));
        label.setForeground(Color.RED);
        label.setBounds(x, y, 350, 20);
        label.setVisible(false);
        return label;
    }

    // ✅ 에러 메시지 표시
    public static void showError(JLabel label, String message) {
        label.setText(message);
        label.setVisible(true);
    }

    // ✅ 에러 메시지 숨기기
    public static void hideError(JLabel label) {
        label.setVisible(false);
    }
    
    // 회원가입 성공 시 텍스트 필드 초기화
    public static void clearFields(RoundedComponent... fields) {
        for (RoundedComponent field : fields) {
            if (field.getComponent() instanceof JTextField) {
                ((JTextField) field.getComponent()).setText("");
            }
        }
    }


}
