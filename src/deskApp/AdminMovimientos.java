package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminMovimientos extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane,pnHeader;
	Style s = new Style();
	JButton btnBack,btnNext;
	
	public AdminMovimientos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 593, 379);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel,Color.WHITE);
		
		pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 593, 100);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		btnBack.addMouseListener(this);
		
		s.btnIcon(btnBack, "views/back.png");
		
		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		
		JPanel pnPagos = new JPanel();
		pnPagos.setLayout(null);
		pnPagos.setBounds(24, 156, 155, 180);
		mainPanel.add(pnPagos);
		
		JLabel lblIconPagos = new JLabel("");
		lblIconPagos.setBounds(10, 11, 135, 135);
		pnPagos.add(lblIconPagos);
		
		JLabel lblPagos = new JLabel("Registrar Pago");
		lblPagos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagos.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblPagos.setBounds(10, 157, 135, 23);
		pnPagos.add(lblPagos);
		
		JButton btnPagos = new JButton("");
		btnPagos.setBounds(0, 0, 155, 180);
		pnPagos.add(btnPagos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(212, 156, 155, 180);
		mainPanel.add(panel_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(10, 11, 135, 135);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Nuevo Credito");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		label_3.setBounds(10, 157, 135, 23);
		panel_1.add(label_3);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(0, 0, 155, 180);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(404, 156, 155, 180);
		mainPanel.add(panel_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(10, 11, 135, 135);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Nuevo Credito");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		label_5.setBounds(10, 157, 135, 23);
		panel_2.add(label_5);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(0, 0, 155, 180);
		panel_2.add(button_2);
		btnNext.addActionListener(this);
		btnNext.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnNext) {
			if (btnNext.isEnabled()) {
				s.hoverBorder(btnNext, Color.white);
				s.btnPointer(btnNext);

			}
		} else if (e.getSource() == e) {
			s.hoverBorder(btnBack, Color.WHITE);
			s.btnPointer(btnBack);
		} 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnNext) {
			btnNext.setBorder(null);
		} else if (e.getSource() == btnBack) {
			btnBack.setBorder(null);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
