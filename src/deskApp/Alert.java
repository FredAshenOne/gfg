package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;

public class Alert extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JPanel mainPanel = new JPanel();
	JLabel lblAlertIcon,lblMessage;
	JButton btnOk,btnCancel;
	Style s = new Style();

	public Alert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mainPanel.setBounds(0, 0, 319, 107);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.white);
		
		
		btnCancel = new JButton("");
		btnCancel.setBounds(10, 67, 128, 29);
		mainPanel.add(btnCancel);
		s.mdButton(btnCancel, Color.decode("#D32F2F"));
		
		btnOk = new JButton("");
		btnOk.setBounds(181, 67, 128, 29);
		mainPanel.add(btnOk);
		s.mdButton(btnOk, s.blue);
		
		lblMessage = new JLabel("");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblMessage.setBounds(48, 23, 261, 33);
		mainPanel.add(lblMessage);
		
		lblAlertIcon = new JLabel("");
		lblAlertIcon.setBounds(10, 23, 32, 32);
		mainPanel.add(lblAlertIcon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnOk) {
			
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
