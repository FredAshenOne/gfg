package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
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

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminClientes extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	JPanel pnNewClient,pnQuery,mainPanel,pnHeader,pnGrupos;
	JButton btnQuery,btnNewClient,btnBack,btnGrupo;
	JLabel lblIconNewClient,lblIconQuery;
	Style s = new Style();
	int idUser;
	BuscarCliente sc = new BuscarCliente();
	Alert alNewAval = new Alert();
	Solicitud nc = new Solicitud();
	
	
	public AdminClientes() {
		setBounds(100,100,1100,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1101, 695);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel,Color.white);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 1091, 151);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		
		pnNewClient = new JPanel();
		pnNewClient.setLayout(null);
		pnNewClient.setBounds(24, 147, 155, 180);
		mainPanel.add(pnNewClient);
		s.mdPanel(pnNewClient, Color.white);
		
		lblIconNewClient = new JLabel("");
		lblIconNewClient.setBounds(10, 11, 135, 135);
		pnNewClient.add(lblIconNewClient);
		lblIconNewClient.setIcon(new ImageIcon("views/add-user.png"));
		
		JLabel lblNewClient = new JLabel("Nuevo Cliente");
		lblNewClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewClient.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewClient.setBounds(0, 157, 155, 23);
		pnNewClient.add(lblNewClient);
		
		btnNewClient = new JButton("");
		btnNewClient.setBounds(0, 0, 155, 180);
		pnNewClient.add(btnNewClient);
		s.btnTransparent(btnNewClient);
		btnNewClient.addActionListener(this);
		btnNewClient.addMouseListener(this);
		
		pnQuery = new JPanel();
		pnQuery.setLayout(null);
		pnQuery.setBounds(223, 147, 155, 180);
		mainPanel.add(pnQuery);
		s.mdPanel(pnQuery, Color.white);
		
		lblIconQuery = new JLabel("");
		lblIconQuery.setBounds(10, 11, 135, 135);
		pnQuery.add(lblIconQuery);
		lblIconQuery.setIcon(new ImageIcon("views/search.png"));
		
		
		JLabel lblQuery = new JLabel("Buscar Cliente");
		lblQuery.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuery.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblQuery.setBounds(0, 157, 155, 23);
		pnQuery.add(lblQuery);
		
		btnQuery = new JButton("");
		btnQuery.setBounds(0, 0, 155, 180);
		pnQuery.add(btnQuery);
		s.btnTransparent(btnQuery);
		btnQuery.addActionListener(this);
		btnQuery.addMouseListener(this);
		
		pnGrupos = new JPanel();
		pnGrupos.setLayout(null);
		pnGrupos.setBounds(414, 147, 155, 180);
		mainPanel.add(pnGrupos);
		s.mdPanel(pnGrupos, Color.white);
		pnGrupos.addMouseListener(this);
		
		JLabel lblIconGrupo = new JLabel("");
		lblIconGrupo.setBounds(10, 11, 135, 135);
		pnGrupos.add(lblIconGrupo);
		
		JLabel lblGrupo = new JLabel("Grupos");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblGrupo.setBounds(0, 157, 155, 23);
		pnGrupos.add(lblGrupo);
		
		btnGrupo = new JButton("");
		btnGrupo.setBounds(0, 0, 155, 180);
		pnGrupos.add(btnGrupo);
		s.mdButton(btnGrupo, Color.WHITE);
		btnGrupo.addMouseListener(this);
		s.btnIcon(btnGrupo, "views/group.png");
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		btnBack.addActionListener(this);
		btnBack.addMouseListener(this);
		
		s.btnIcon(btnBack, "views/back.png");
		JLabel lblHeader = new JLabel("Clientes");
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);
		
		JLabel lblHeader2 = new JLabel("Seleccione una opci\u00F3n");
		lblHeader2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader2.setForeground(Color.WHITE);
		lblHeader2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblHeader2.setBounds(52, 46, 489, 32);
		pnHeader.add(lblHeader2);
		
//		nc.btnBack.addActionListener(this);
		nc.alNewAval.btnCancel.addActionListener(this);
		btnQuery.addActionListener(this);
		btnGrupo.addActionListener(this);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource()==btnBack) {
			s.btnPointer(btnBack);
			s.hoverBorder(btnBack, Color.WHITE);
		}else if(e.getSource() == btnNewClient) {
			s.imgBtnHover(s.blue,pnNewClient);
			s.panelPointer(pnNewClient);
		}else if(e.getSource() == btnQuery) {
			s.imgBtnHover(s.blue,pnQuery);
			s.panelPointer(pnQuery);
		}else if(e.getSource() == btnGrupo){
			btnGrupo.setBorder(null);
			s.imgBtnHover(s.blue, pnGrupos);
			s.panelPointer(pnGrupos);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnNewClient) {
			pnNewClient.setBorder(null);
		}else if(e.getSource() == btnQuery) {
			pnQuery.setBorder(null);
		}else if(e.getSource() == btnBack){
			btnBack.setBorder(null);
		}else if(e.getSource() == btnGrupo){
			pnGrupos.setBorder(null);
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
		if(e.getSource()==btnNewClient) {
//			nc.etiquetasInvisibles(false);
			nc.limpiarCamposSolicitud();
			nc.setVisible(true);
			nc.idUser = idUser;
		}else if(e.getSource() == nc.btnBack) {
			this.setVisible(true);
			nc.setVisible(false);
			nc.limpiarCamposSolicitud();
		}else if(e.getSource() == nc.alNewAval.btnCancel) {
			this.setVisible(true);
			nc.alNewAval.setVisible(false);
			nc.setVisible(false);
		}else if(e.getSource() == btnQuery) {
			sc.setVisible(true);
			sc.idUser = idUser;
			sc.fillTable();			
			this.setVisible(false);
		}else if(e.getSource() == sc.btnBack) {
			this.setVisible(true);
			sc.setVisible(false);
		}
	}
}
