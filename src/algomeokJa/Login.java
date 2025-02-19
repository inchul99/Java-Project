package algomeokJa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import agui.RoundBT;
import agui.RoundPF;
import agui.RoundTF;

public class Login extends JPanel implements ActionListener{
	private MainFR parent;
    private JTextField userField;
	private JPasswordField passField;
    private JButton loginButton, registerButton;
    private JCheckBox rememberMe;
    
    public Login(MainFR parent) {
    	this.parent = parent;
    	setLayout(null);
    	 
         JLabel titleLabel = new JLabel("건강한 식단 관리, 함께 시작해요!", JLabel.CENTER);
         titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
         titleLabel.setBounds(50, 303, 340, 30);
         add(titleLabel);
    	
         JLabel userLabel = new JLabel("로그인");
         userLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         userLabel.setBounds(50, 363, 100, 20);
         add(userLabel);
         
         userField = new RoundTF(10);
         userField.setBounds(50, 393, 315, 40);
         userField.setBackground(new Color(0xD9D9D9));
         add(userField);
         
      // 비밀번호 입력 필드
         JLabel passLabel = new JLabel("비밀번호");
         passLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         passLabel.setBounds(50, 453, 100, 20);
        
         add(passLabel);

         passField = new RoundPF(10);
         passField.setBounds(50, 483, 315, 40);
         passField.setBackground(new Color(0xD9D9D9)); 
         add(passField);

         // Remember me & Forgot password
         rememberMe = new JCheckBox("Remember me");
         rememberMe.setBounds(50, 543, 120, 20);
         add(rememberMe);

         JLabel forgotPass = new JLabel("Forgot password/ID?");
         forgotPass.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
         forgotPass.setForeground(Color.GRAY);
         forgotPass.setBounds(240, 543, 150, 20);
         add(forgotPass);

         // 로그인 버튼
         loginButton = new RoundBT("로그인",10);
         loginButton.setBounds(50,583, 135, 50);
         loginButton.setBackground(new Color(0xC0E993)); 
         loginButton.setFont(new Font("Jua", Font.BOLD, 14));
         loginButton.addActionListener(this);
         add(loginButton);

         // 회원가입 버튼
         registerButton = new RoundBT("회원가입",10);
         registerButton.setBounds(230,583, 135, 50);
         registerButton.setBackground(Color.BLACK);
         registerButton.setForeground(Color.WHITE);
         registerButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         registerButton.addActionListener(this);
         add(registerButton);

         setVisible(true);
     }

     @Override
     public void actionPerformed(ActionEvent e) {
         if (e.getSource() == loginButton) {
            String userId = userField.getText();
            String password = new String(passField.getPassword());
            
            //로그인 검증 호출
            if(Loginservice.verifyLogin(userId, password)) {
         	   //JOptionPane.showMessageDialog(this,"로그인 성공!");
            	System.out.println("로그인 성공, 홈 화면으로 이동 시도");
            	parent.showPanel("base");
            }else {
         	   JOptionPane.showMessageDialog(this, "로그인 실패! 아이디 또는 비밀번호를 확인하세요.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
            }
         } else if (e.getSource() == registerButton) {
             parent.showPanel("register");
         }
     }
   }