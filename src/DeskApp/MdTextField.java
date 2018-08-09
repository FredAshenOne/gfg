package deskApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MdTextField extends JTextField {
	Color colorPlaceHolder = Color.LIGHT_GRAY;
	int size = 15;
	Color fore = Color.BLACK;
	JLabel lbl;
	TextPrompt tp;
	public MdTextField(Color fore,String placeHolder,Color back,Color bord,JLabel lbl) {
		this.fore = fore;
		this.lbl = lbl;		
		setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		setColumns(10);
		setForeground(fore);
		setBackground(back);
		setCaretColor(fore);
		setHorizontalAlignment(SwingConstants.CENTER);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, bord));				
		
		lbl.setForeground(fore);
		lbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lbl.setText(placeHolder);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVisible(true);
		
		tp = new TextPrompt(placeHolder, this);
		tp.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, size));
		tp.setForeground(fore);
		tp.setHorizontalAlignment(CENTER);
//		lbl.setVisible(true);
		if(getText().length() == 0) {
			lbl.setVisible(false);
			
		}else{
			lbl.setVisible(true);
		}
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(getText().length() == 0) {
					lbl.setVisible(false);
					
				}else{
					lbl.setVisible(true);
				}
			}
		});
	
	}
}
