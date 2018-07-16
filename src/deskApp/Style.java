package deskApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;

public class Style {
	
	public Color blue = Color.decode("#039BE5");
	public Color green = Color.decode("#26A69A");
	public Color red = Color.decode("#C62828");
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
	
	public void hoverBorder(JComponent c, Color col) {
		c.setBorder(new LineBorder(col,1,true));
	}
	
	public void placeholder(JTextField txt,JLabel lbl) {
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txt.getText().length()>0) {
					lbl.setVisible(true);
				}else {
					lbl.setVisible(false);
				}
			}
		});
		lbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
	}
	
	public void myTextPrompt(JTextField txt,String str,Color c) {
		TextPrompt tp = new TextPrompt(str, txt);
		tp.setFont(txt.getFont());
		tp.setForeground(c);
		tp.setHorizontalAlignment(txt.getHorizontalAlignment());
	}
	
	
	public boolean checarFecha(String text) {
	    if (text == null || !text.matches("\\d{4}-[01]\\d-[0-3]\\d"))
	        return false;
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    df.setLenient(false);
	    try {
	        df.parse(text);
	        return true;
	    } catch (ParseException ex) {
	        return false;
	    }
	}
	
	public void mdTable(JTable table,Color colBackView,Color colHeader) {
		table.setBorder(null);
		table.getTableHeader().setBackground(colHeader);
		table.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		table.setBackground(colBackView);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
	}
}
