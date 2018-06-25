package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UploadFiles extends JFrame {

	private JPanel contentPane;
	JButton btnNext,btnOmit,btnBack;
	Style s = new Style();

	public UploadFiles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 593, 375);
		contentPane.add(mainPanel);
		s.mdPanel(mainPanel, Color.WHITE);
		mainPanel.setLayout(null);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 593, 100);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		
		JLabel label = new JLabel("Nuevo Cliente: Datos de Empleo");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		label.setBounds(87, 10, 447, 32);
		pnHeader.add(label);
		
		btnNext = new JButton("");
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 10, 32, 32);
		pnHeader.add(btnBack);
		s.btnIcon(btnBack, "views/btnBack.png");
		
		btnOmit = new JButton("Omitir");
		btnOmit.setForeground(Color.WHITE);
		btnOmit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		btnOmit.setBounds(516, 332, 67, 32);
		mainPanel.add(btnOmit);
	}

}
