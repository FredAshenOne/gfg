package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminCreditos extends JFrame implements ActionListener,MouseListener{
	
	private JPanel contentPane;
	JPanel pnNewCredit,pnQuery,mainPanel,pnRenovacion;
	JButton btnQuery,btnNuevoCredito,btnBack,btnRenovacion;
	JLabel lblIconNewCredit,lblIconQuery,lblIconRenovacion;
	Style s = new Style();
	int idUser;
	BuscarRenovacion br = new BuscarRenovacion();
	BuscarClienteCreditos bcc = new BuscarClienteCreditos();
	BuscarCredito buscarCred = new BuscarCredito();
	
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
		
		pnRenovacion = new JPanel();
		pnRenovacion.setLayout(null);
		pnRenovacion.setBounds(414, 147, 155, 180);
		mainPanel.add(pnRenovacion);
		s.mdPanel(pnRenovacion, Color.white);
		
		 lblIconRenovacion = new JLabel("");
		lblIconRenovacion.setBounds(10, 11, 135, 135);
		lblIconRenovacion.setIcon(new ImageIcon("views/update.png"));
		pnRenovacion.add(lblIconRenovacion);
		
		JLabel lblRenovacion = new JLabel("Renovaciones");
		lblRenovacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblRenovacion.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblRenovacion.setBounds(10, 157, 135, 23);
		pnRenovacion.add(lblRenovacion);
		
		btnRenovacion = new JButton("");
		btnRenovacion.setBounds(0, 0, 155, 180);
		pnRenovacion.add(btnRenovacion);
		s.btnTransparent(btnRenovacion);
		btnRenovacion.addActionListener(this);
		btnRenovacion.addMouseListener(this);
		
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
		bcc.btnBack.addActionListener(this);
		bcc.btnNext.addActionListener(this);
		buscarCred.btnBack.addActionListener(this);
		br.btnBack.addActionListener(this);
		
		
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
		}else if(e.getSource() == btnRenovacion) {
			s.imgBtnHover(s.blue,pnRenovacion);
			s.panelPointer(pnRenovacion);
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
		}else if(e.getSource() == btnRenovacion) {
			pnRenovacion.setBorder(null);
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
			bcc.setVisible(true);
			this.setVisible(false);
			bcc.llenarTabla();
		}else if(e.getSource() == bcc.btnBack) {
			this.setVisible(true);
			bcc.setVisible(false);
		}else if(e.getSource() == btnQuery) {
			buscarCred.setVisible(true);
			this.setVisible(false);
			buscarCred.fillTable();
		}else if(e.getSource() == buscarCred.btnBack) {
			 this.setVisible(true);
			 buscarCred.setVisible(false);
		}else if(e.getSource() == btnRenovacion) {
			br.setVisible(true);
			this.setVisible(false);
			br.fillTable(br.searchCredito());
		}else if(e.getSource() == br.btnBack) {
			br.setVisible(false);
			this.setVisible(true);			
		}
	}
}
