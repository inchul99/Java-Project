package ztest;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Tsetshadowbtn {
	public static void main(String[] args) {
		// 🔹 프레임 생성
		JFrame frame = new JFrame("이미지 버튼");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLayout(new FlowLayout());

		// 🔹 이미지 불러오기 (절대 경로 사용)
		String imagePath = "C:\\java\\project\\src\\images\\shadowbtn.png"; // 🔥 여기에 네 이미지 경로 넣어줘!
		ImageIcon originalIcon = new ImageIcon(imagePath);

		// 🔹 이미지 크기 조정 (버튼 크기에 맞게)
		Image scaledImage = originalIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);

		// 🔹 버튼 생성 & 이미지 적용
		JButton imageButton = new JButton(resizedIcon);
		imageButton.setBorderPainted(false);
		imageButton.setContentAreaFilled(false);
		imageButton.setFocusPainted(false);

		// 🔹 프레임에 버튼 추가
		frame.add(imageButton);
		frame.pack(); // 🔥 이걸 추가하면 버튼 크기가 자동 조절됨!
		frame.setVisible(true);

	}
}
