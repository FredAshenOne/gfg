package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminCreditos extends JFrame implements ActionListener,MouseListener{
	
	private JPanel contentPane;
	JPanel pnNewCredit,pnQuery,mainPanel;
	JButton btnQuery,btnNuevoCredito,btnBack;
	JLabel lblIconNewCredit,lblIconQuery;
	Style s = new Style();
	int idUser;
	BuscarCliente bc = new BuscarCliente();
	Alert alNewAval = new Alert();
	NewClient nc = new NewClient(); 
	public AdminCreditos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 600, 380);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.white);
		
		pnNewCredit = new JPanel();
		pnNewCredit.setLayout(null);
		pnNewCredit.setBounds(24, 147, 155, 180);
		mainPanel.add(pnNewCredit);
		s.mdPanel(pnNewCredit, Color.white);
		
		lblIconNewCredit = new JLabel("");
		lblIconNewCredit.setBounds(10, 11, 135, 135);
		pnNewCredit.add(lblIconNewCredit);
		lblIconNewCredit.setIcon(new ImageIcon("views/addFile.png"));
		
		JLabel lblNewCredit = new JLabel("Nuevo Credito");
		lblNewCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewCredit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewCredit.setBounds(10, 157, 135, 23);
		pnNewCredit.add(lblNewCredit);
		
		btnNuevoCredito = new JButton("");
		btnNuevoCredito.setBounds(0, 0, 155, 180);
		pnNewCredit.add(btnNuevoCredito);
		s.btnTransparent(btnNuevoCredito);
		btnNuevoCredito.addActionListener(this);
		btnNuevoCredito.addMouseListener(this);
		
		pnQuery = new JPanel();
		pnQuery.setLayout(null);
		pnQuery.setBounds(223, 147, 155, 180);
		mainPanel.add(pnQuery);
		s.mdPanel(pnQuery, Color.white);
		
		lblIconQuery = new JLabel("");
		lblIconQuery.setBounds(10, 11, 135, 135);
		pnQuery.add(lblIconQuery);
		lblIconQuery.setIcon(new ImageIcon("views/search.png"));
		
		
		JLabel lblQuery = new JLabel("BuscarCredito");
		lblQuery.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuery.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblQuery.setBounds(10, 157, 135, 23);
		pnQuery.add(lblQuery);
		
		btnQuery = new JButton("");
		btnQuery.setBounds(0, 0, 155, 180);
		pnQuery.add(btnQuery);
		s.btnTransparent(btnQuery);
		btnQuery.addActionListener(this);
		btnQuery.addMouseListener(this);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(414, 147, 155, 180);
		mainPanel.add(panel_3);
		s.mdPanel(panel_3, Color.white);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(10, 11, 135, 135);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("Clientes");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		label_5.setBounds(10, 157, 135, 23);
		panel_3.add(label_5);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(0, 0, 155, 180);
		panel_3.add(button_2);
		s.mdButton(button_2, Color.WHITE);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 603, 100);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		btnBack.addActionListener(this);
		btnBack.addMouseListener(this);
		
		s.btnIcon(btnBack, "views/back.png");
		JLabel lblHeader = new JLabel("");
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);
		
		btnQuery.addActionListener(this);
		bc.btnBack.addActionListener(this);
		bc.btnNext.addActionListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource()==btnBack) {
			s.btnPointer(btnBack);
			s.hoverBorder(btnBack, Color.WHITE);
		}else if(e.getSource() == btnNuevoCredito) {
			s.imgBtnHover(s.blue,pnNewCredit);
			s.panelPointer(pnNewCredit);
		}else if(e.getSource() == btnQuery) {
			s.imgBtnHover(s.blue,pnQuery);
			s.panelPointer(pnQuery);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnNuevoCredito) {
			pnNewCredit.setBorder(null);
		}else if(e.getSource() == btnQuery) {
			pnQuery.setBorder(null);
		}else if(e.getSource() == btnBack){
			btnBack.setBorder(null);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNuevoCredito) {
			bc.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == bc.btnBack) {
			this.setVisible(true);
			bc.setVisible(false);
		}
	}
}
