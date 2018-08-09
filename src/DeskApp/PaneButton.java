package deskApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PaneButton extends JPanel{
	Style s = new Style();
	JLabel icon,title;
	JButton btn;
	public PaneButton(String titulo,String url,Color border) {
		
		
		setLayout(null);
		s.mdPanel(this,Color.WHITE);
		
		icon = new JLabel("");
		icon.setBounds(10, 11, 135, 135);
		add(icon);
		icon.setIcon(new ImageIcon(url));
		
		title = new JLabel(titulo);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 149, 155, 31);
		add(title);
		title.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		
		btn = new JButton("");
		btn.setBounds(0, 0, 155, 180);
		add(btn);
		s.btnTransparent(btn);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("views/cursor.png").getImage(),
				new Point(0,0), "custom cursor"));
				setBorder(new LineBorder(border,2,true));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(null);
			}
		});
	}
}
