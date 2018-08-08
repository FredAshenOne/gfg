package deskApp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MdHeader extends JPanel{
	IconButton btnBack,btnNext;
	JLabel lblTitle,lblWarning;
	public MdHeader(Color back,Color fore) {
		setBounds(0, 0, 1124, 151);
		setLayout(null);
		setOpaque(true);
		setBackground(back);
		
		btnBack = new IconButton("views/back.png", Color.white);
		btnBack.setBounds(10, 11, 32, 32);
		add(btnBack);

		btnNext = new IconButton("views/next.png", Color.white);
		btnNext.setBounds(1082, 11, 32, 32);
		add(btnNext);
		
		lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 115, 1104, 32);
		add(lblWarning);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		
		lblTitle= new JLabel("");
		lblTitle.setForeground(fore);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(62, 10, 990, 45);
		add(lblTitle);
		lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
	}
}
