package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AdminMenuPrincipal extends JFrame implements ActionListener,MouseListener {
	Style s = new Style();
	private JPanel contentPane;
	JPanel pnClientes,pnMovimientos,pnCreditos,pnHeader,pnSolicitud;
	JLabel lblBack;
	JButton btnClient,btnMoves,btnCredits,btnBack,btnSettings,btnSolicitud;
	int idUser;
	PaneButton pbSolicitud;
	AdminCreditos acre = new AdminCreditos();
	AdminClientes ac = new AdminClientes();
	AdminMovimientos am = new AdminMovimientos();
	public AdminMenuPrincipal() {
		setBounds(100,100,1135,827);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1134, 800);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel,Color.white);
		
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 1124, 151);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		
		pnClientes = new JPanel();
		pnClientes.setBounds(21, 367, 155, 180);
		mainPanel.add(pnClientes);
		pnClientes.setLayout(null);
		s.mdPanel(pnClientes,Color.WHITE);
		
		JLabel lblClientIcon = new JLabel("");
		lblClientIcon.setBounds(10, 11, 135, 135);
		pnClientes.add(lblClientIcon);
		lblClientIcon.setIcon(new ImageIcon("views/users.png"));
		
		JLabel lblClient = new JLabel("Clientes");
		lblClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblClient.setBounds(10, 157, 135, 23);
		pnClientes.add(lblClient);
		lblClient.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		
		btnClient = new JButton("");
		btnClient.setBounds(0, 0, 155, 180);
		pnClientes.add(btnClient);
		s.btnTransparent(btnClient);
		btnClient.addActionListener(this);
		btnClient.addMouseListener(this);
		
		pnCreditos = new JPanel();
		pnCreditos.setBounds(196, 367, 155, 180);
		mainPanel.add(pnCreditos);
		pnCreditos.setLayout(null);
		s.mdPanel(pnCreditos,Color.white);
		
		JLabel lblCredits = new JLabel("Creditos");
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredits.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblCredits.setBounds(10, 157, 135, 23);
		pnCreditos.add(lblCredits);
		
		JLabel lblIconCredits = new JLabel("");
		lblIconCredits.setBounds(10, 11, 135, 135);
		pnCreditos.add(lblIconCredits);
		lblIconCredits.setIcon(new ImageIcon("views/file.png"));
		
		btnCredits = new JButton("");
		btnCredits.setBounds(0, 0, 155, 180);
		pnCreditos.add(btnCredits);
		s.btnTransparent(btnCredits);
		btnCredits.addActionListener(this);
		btnCredits.addMouseListener(this);
		
		pnMovimientos = new JPanel();
		pnMovimientos.setBounds(376, 366, 155, 181);
		mainPanel.add(pnMovimientos);
		pnMovimientos.setLayout(null);
		s.mdPanel(pnMovimientos,Color.white);
		
		JLabel lblIconMoves = new JLabel("");
		lblIconMoves.setBounds(10, 11, 135, 135);
		pnMovimientos.add(lblIconMoves);
		lblIconMoves.setIcon(new ImageIcon("views/checklist.png"));
		JLabel lblMoves = new JLabel("Movimientos");
		lblMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoves.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblMoves.setBounds(10, 157, 135, 23);
		pnMovimientos.add(lblMoves);
		
		btnMoves = new JButton("");
		btnMoves.setBounds(0, 0, 155, 180);
		pnMovimientos.add(btnMoves);
		s.btnTransparent(btnMoves);
		btnMoves.addActionListener(this);
		btnMoves.addMouseListener(this);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		btnBack.addMouseListener(this);
		s.btnIcon(btnBack, "views/back.png");
		
		btnSettings = new JButton("");
		btnSettings.setBounds(1082, 11, 32, 32);
		pnHeader.add(btnSettings);
		s.btnTransparent(btnSettings);
		btnSettings.setIcon(new ImageIcon("views/settings.png"));
		
		JLabel lblHeader = new JLabel("Bienvenido ");
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(52, 11, 1020, 49);
		pnHeader.add(lblHeader);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		
		JLabel lblTitle = new JLabel("Selecciona una opci\u00F3n");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTitle.setBounds(52, 54, 1020, 32);
		pnHeader.add(lblTitle);
		
		pbSolicitud = new PaneButton("Solicitud","views/addFile.png");
		mainPanel.add(pbSolicitud);
		pbSolicitud.setBounds(21, 162, 155, 180);
		pbSolicitud.btn.addMouseListener(this);
		pbSolicitud.btn.addActionListener(this);
		
		
		
		
		btnSettings.addActionListener(this);
		btnSettings.addMouseListener(this);
		
		ac.btnBack.addActionListener(this);
		acre.btnBack.addActionListener(this);
		am.btnBack.addActionListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btnClient){
			s.imgBtnHover(s.blue,pnClientes);
			s.panelPointer(pnClientes);
		}else if(e.getSource()==btnCredits){
			s.imgBtnHover(s.blue,pnCreditos);
			s.panelPointer(pnCreditos);
		}else if(e.getSource()==btnMoves){
			s.panelPointer(pnMovimientos);
			s.imgBtnHover(s.blue,pnMovimientos);
		}else if(e.getSource() == btnBack) {
			s.btnPointer(btnBack);
			s.hoverBorder(btnBack, Color.white);
		}else if(e.getSource() == pbSolicitud.btn){
			s.panelPointer(pbSolicitud);
			s.imgBtnHover(s.blue,pbSolicitud);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnClient){
			pnClientes.setBorder(null);
		}else if(e.getSource()==btnCredits){
			pnCreditos.setBorder(null);
		}else if(e.getSource()==btnMoves){
			pnMovimientos.setBorder(null);
		}else if(e.getSource() == btnBack) {
			btnBack.setBorder(null);
		}else if(e.getSource() == pbSolicitud.btn){
			pbSolicitud.setBorder(null);
		}
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnClient) {
			ac.setVisible(true);
			ac.idUser = idUser;
			this.setVisible(false);
		}else if(e.getSource() == ac.btnBack) {
			this.setVisible(true);
			ac.setVisible(false);
		}else if(e.getSource() == btnCredits) {
			acre.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == acre.btnBack) {
			this.setVisible(true);
			acre.setVisible(false);
		}else if(e.getSource() == btnMoves) {
			am.setVisible(true);
			this.setVisible(false);			
		}else if(e.getSource() == am.btnBack ) {
			this.setVisible(true);
			am.setVisible(false);
		}
	}
}
