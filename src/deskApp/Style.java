package deskApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class Style {
	
	public Color blue = Color.decode("#039BE5");
	public Color green = Color.decode("#26A69A");
	
	public void btnPointer(JButton btn) {
		btn.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		new ImageIcon("views/cursor.png").getImage(),
		new Point(0,0), "custom cursor"));
	}
	
	public void lblPointer(JLabel lbl) {
		lbl.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		new ImageIcon("views/cursor.png").getImage(),
		new Point(0,0), "custom cursor"));
	}
	
	public void panelPointer(JPanel p) {
		p.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		new ImageIcon("views/cursor.png").getImage(),
		new Point(0,0), "custom cursor"));
	}
	
	public void btnHover(JButton btn,Color cbord,Color cb,Color cf) {
		btn.setBackground(Color.white);
		btn.setContentAreaFilled(false);	
		btn.setBorder(new LineBorder(cbord,3,true));
		btn.setOpaque(true);
		btn.setBackground(cb);
		btn.setForeground(cf);
	}
	
	public void imgBtnHover(Color cbord,JPanel pn) {
		pn.setBorder(new LineBorder(cbord,2,true));
	}
	
	public void mdRdbtn(JRadioButton rd) {
		rd.setOpaque(true);
		rd.setBackground(Color.WHITE);
	}
	
	
	public void mdButton(JButton btn,Color c) {
		btn.setOpaque(true);
		btn.setBorder(null);
		btn.setBackground(c);
		btn.setForeground(Color.WHITE);
	}
	
	public void mdPanel(JPanel p,Color c){
		p.setOpaque(true);
		p.setBackground(c);
	
	}
	
	public void btnIcon(JButton btn,String url){
		btn.setOpaque(true);
		btn.setContentAreaFilled(false);
		btn.setIcon(new ImageIcon(url));
		btn.setBackground(null);
		btn.setBorder(null);
		
	}
	
	public void btnTransparent(JButton btn) {
		btn.setOpaque(true);
		btn.setBackground(null);
		btn.setBorder(null);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
	}
	
	public void mdTextField(JTextField txt,Color cbord,Color cback) {
		txt.setBackground(cback);
		txt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, cbord));
		
	}
	
	public void mdCombo(JComboBox cb,Color background,Color border) {
		cb.setOpaque(true);
		cb.setUI(new BasicComboBoxUI() {
		    @Override
		    protected JButton createArrowButton() {
		        JButton b = super.createArrowButton();
		        b.setBackground(background);
		        b.setBorder(BorderFactory.createMatteBorder(0, 0,0, 0,background));
		        return b; 
		   }
		    
		});
		cb.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, border));
		cb.setBackground(background);
	}
	
	public void placeholder(JTextField txt,JLabel lbl,String str) {
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txt.getText().length()>0) {
					lbl.setText(str);
				}else {
					lbl.setText("");
				}
			}
		});
		lbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
	}
	
	public void myTextPrompt(JTextField txt,String str,Color c) {
		TextPrompt tp = new TextPrompt(str, txt);
		tp.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tp.setForeground(c);
	}
}
