package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class JobData extends JFrame {
	Style s = new Style();
	private JPanel contentPane;

	public JobData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 593, 380);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.WHITE);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 593, 100);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		
		JButton btnOmit = new JButton("Omitir");
		btnOmit.setForeground(Color.WHITE);
		btnOmit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		btnOmit.setBounds(10, 11, 89, 32);
		pnHeader.add(btnOmit);
		
		JLabel lblNewLabel = new JLabel("Nuevo Cliente: Datos de Empleo");
		lblNewLabel.setBounds(109, 11, 429, 32);
		pnHeader.add(lblNewLabel);
		
		JButton button = new JButton("");
		button.setBounds(551, 11, 32, 32);
		pnHeader.add(button);
		
		
	}
}
