package deskApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class IconButton extends JButton{
	
	public IconButton(String url,Color border) {
		setOpaque(true);
		setBorder(null);
		setContentAreaFilled(false);
		setHorizontalAlignment(SwingConstants.CENTER);
		setIcon(new ImageIcon(url));
		setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				setBorder(new LineBorder(border, 1, true));
				btnPointer();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(null);
			}
		});

	}
	
	public void btnPointer() {
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		new ImageIcon("views/cursor.png").getImage(),
		new Point(0,0), "custom cursor"));
	
	}

}
