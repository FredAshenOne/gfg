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

	JPanel contentPane, mainPanel = new JPanel();
	JLabel lblAlertIcon,lblMessage;
	JButton btnOk,btnCancel;
	Style s = new Style();

	public Alert() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 335, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mainPanel.setBounds(0, 0, 319, 107);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.white);
		
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btnCancel.setBounds(10, 67, 128, 29);
		mainPanel.add(btnCancel);
		s.mdButton(btnCancel, Color.decode("#D32F2F"));
		
		btnOk = new JButton("Guardar");
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
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
		
		btnOk.addMouseListener(this);
		btnCancel.addMouseListener(this);
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
			s.btnHover(btnOk, s.blue, Color.WHITE, s.blue);
			s.btnPointer(btnOk);
		}else if(e.getSource() == btnCancel) {
			s.btnHover(btnCancel, s.red, Color.WHITE, s.red);
			s.btnPointer(btnCancel);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnOk) {
			s.mdButton(btnOk, s.blue);
		}else if(e.getSource() == btnCancel) {
			s.mdButton(btnCancel, s.red);
		}
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
