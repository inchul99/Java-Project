package ztest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindIDPWPage extends JFrame implements ActionListener {
    private JTextField nameField1, phoneField1, verifyField1;
    private JTextField nameField2, idField2, phoneField2, verifyField2;
    private JButton sendCodeButton1, findIdButton;
    private JButton sendCodeButton2, findPwButton;
    private JButton phoneTabButton, emailTabButton;

    public FindIDPWPage() {
        setTitle("FindIDPWPage");
        setSize(440, 956);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        int formWidth = 270;
        int centerX = (getWidth() - formWidth) / 3;
        int startY = 100;

        // 상단 제목
        JLabel titleLabel = new JLabel("ID/PW 찾기", JLabel.LEFT);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 32));
        titleLabel.setBounds(centerX-30, startY-95, 200, 58);
        add(titleLabel);
        
        // 구분선
        JSeparator divider = new JSeparator();
        divider.setBounds(centerX-60, startY -30, 440, 2);
        add(divider);

        // 탭 버튼 (휴대전화/이메일)
        phoneTabButton = new JButton("휴대전화로 찾기");
        phoneTabButton.setBounds(centerX, startY + 25, 150, 40);
        phoneTabButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        phoneTabButton.setBackground(Color.BLACK);
        phoneTabButton.setForeground(Color.WHITE);
        add(phoneTabButton);

        emailTabButton = new JButton("이메일로 찾기");
        emailTabButton.setBounds(centerX + 170, startY + 25, 150, 40);
         emailTabButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        emailTabButton.setBackground(Color.LIGHT_GRAY);
        add(emailTabButton);

        // ID 찾기 섹션
        JLabel findIdLabel = new JLabel("아이디 찾기", JLabel.CENTER);
        findIdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        findIdLabel.setBounds(centerX+15, startY + 100, formWidth, 30);
        add(findIdLabel);

        addInputField("이름", centerX-10, startY + 165, formWidth);
        nameField1 = new JTextField();
        nameField1.setBounds(centerX+50, startY + 165, formWidth, 30);
        add(nameField1);

        addInputField("휴대전화", centerX-10, startY + 225, formWidth);
        phoneField1 = new JTextField();
        phoneField1.setBounds(centerX+50, startY + 225, 170, 30);
        add(phoneField1);

        sendCodeButton1 = new JButton("인증 전송");
        sendCodeButton1.setBounds(centerX + 230, startY + 225, 90, 30);
        sendCodeButton1.setBackground(Color.BLACK);
        sendCodeButton1.setForeground(Color.WHITE);
        sendCodeButton1.addActionListener(this);
        add(sendCodeButton1);

        verifyField1 = new JTextField();
        verifyField1.setBounds(centerX+50, startY + 265, formWidth, 30);
        add(verifyField1);

        findIdButton = new JButton("아이디 찾기");
        findIdButton.setBounds(centerX+50, startY + 320, 198, 44);
        findIdButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        findIdButton.setBackground(new Color(180, 230, 150));
        findIdButton.setForeground(Color.WHITE);
        findIdButton.addActionListener(this);
        add(findIdButton);

        // 구분선
        JSeparator divider1 = new JSeparator();
        divider1.setBounds(centerX-60, startY + 390, 440, 2);
        add(divider1);

        // 비밀번호 찾기 섹션
        JLabel findPwLabel = new JLabel("비밀번호 찾기", JLabel.CENTER);
        findPwLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        findPwLabel.setBounds(centerX+18, startY + 410, formWidth, 30);
        add(findPwLabel);

        addInputField("이름", centerX-10, startY + 475, formWidth);
        nameField2 = new JTextField();
        nameField2.setBounds(centerX+50, startY + 475, formWidth, 30);
        add(nameField2);

        addInputField("아이디", centerX-10, startY + 535, formWidth);
        idField2 = new JTextField();
        idField2.setBounds(centerX+50, startY + 535, formWidth, 30);
        add(idField2);

        addInputField("휴대전화", centerX-10, startY + 595, formWidth);
        phoneField2 = new JTextField();
        phoneField2.setBounds(centerX+50, startY + 595, 170, 30);
        add(phoneField2);

        sendCodeButton2 = new JButton("인증 전송");
        sendCodeButton2.setBounds(centerX + 230, startY + 595, 90, 30);
        sendCodeButton2.addActionListener(this);
        sendCodeButton2.setBackground(Color.BLACK);
        sendCodeButton2.setForeground(Color.WHITE);
        add(sendCodeButton2);

        verifyField2 = new JTextField();
        verifyField2.setBounds(centerX+50, startY + 635, formWidth, 30);
        add(verifyField2);

        findPwButton = new JButton("비밀번호 찾기");
        findPwButton.setBounds(centerX+50, startY + 700, 198, 44);
        findPwButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        findPwButton.setBackground(new Color(180, 230, 150));
        findPwButton.setForeground(Color.WHITE);
        findPwButton.addActionListener(this);
        add(findPwButton);

        setVisible(true);
    }

    private void addInputField(String labelText, int x, int y, int width) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, 100, 20);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendCodeButton1) {
            System.out.println("ID 찾기 - 인증번호 전송 클릭!");
        } else if (e.getSource() == findIdButton) {
            System.out.println("아이디 찾기 버튼 클릭!");
        } else if (e.getSource() == sendCodeButton2) {
            System.out.println("비밀번호 찾기 - 인증번호 전송 클릭!");
        } else if (e.getSource() == findPwButton) {
            System.out.println("비밀번호 찾기 버튼 클릭!");
        }
    }

    public static void main(String[] args) {
        new FindIDPWPage();
    }
}

