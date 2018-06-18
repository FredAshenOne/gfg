package deskApp;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Style {
	
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
	
	public void mdPanel(JPanel p){
		p.setOpaque(true);
		p.setBackground(Color.WHITE);
	
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
	
	public void gBorders() {
		
	}
	
	public void mdCombo(JComboBox cb) {
		cb.setBackground(Color.WHITE);
		cb.setOpaque(true);
		cb.setBorder(null);
	}
		
}
