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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JFrame implements ActionListener {
	Style s = new Style();
	Solicitud solicitud = new Solicitud();
	BuscarCliente bc = new BuscarCliente();
	AdminMovimientos am = new AdminMovimientos();
	Grupos g = new Grupos();		
	BuscarCredito bcred = new BuscarCredito();
	private JPanel contentPane;	
	MdHeader pnHeader;
	int idUser;
	PaneButton pbSolicitud,pbGrupos,pbBuscarCliente,pbAprobacion,pbBuscarCred,pbMovimientos;
	
	public MenuPrincipal() {
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
		
		//header
		
		pnHeader = new MdHeader(s.blue,Color.WHITE);
		pnHeader.setBounds(0, 0, 1124, 151);
		pnHeader.btnNext.setVisible(false);
		pnHeader.lblTitle.setText("Bienvenido");
		pnHeader.lblSubTitle.setText("Selecciona una opción");
		mainPanel.add(pnHeader);			
		
		//Menu
		
		//Nuevas Solicitudes
		pbSolicitud = new PaneButton("Nueva Solicitud","views/addFile.png",s.blue);
		mainPanel.add(pbSolicitud);
		pbSolicitud.setBounds(21, 162, 155, 180);
		pbSolicitud.btn.addActionListener(this);
		
		solicitud.alSave.btnOk.addActionListener(this);
		solicitud.headerPrincipal.btnBack.addActionListener(this);
		
		//Aprobacion de creditos
		pbAprobacion = new PaneButton("Aprobación","views/approve.png",s.blue);
		pbAprobacion.setBounds(560, 162, 155, 180);
		mainPanel.add(pbAprobacion);
		pbAprobacion.btn.addActionListener(this);
		
		
		//Creditos
		pbBuscarCred = new PaneButton("Creditos","views/buscarCredito.png",s.blue);
		pbBuscarCred.setBounds(741, 162, 155, 180);
		mainPanel.add(pbBuscarCred);
		pbBuscarCred.btn.addActionListener(this);
		
		//Movimientos
		pbMovimientos = new PaneButton("Movimientos","views/checklist.png",s.blue);
		pbMovimientos.setBounds(376, 366, 155, 181);
		mainPanel.add(pbMovimientos);
		pbMovimientos.btn.addActionListener(this);
		
		
		//Grupos
		
		pbGrupos = new PaneButton("Grupos","views/group.png",s.blue);
		mainPanel.add(pbGrupos);
		pbGrupos.setBounds(196, 162, 155, 180);
		pbGrupos.btn.addActionListener(this);
		
		g.pnHeader.btnBack.addActionListener(this);
		
		//Buscar Clientes
		pbBuscarCliente = new PaneButton("Buscar Cliente","views/search.png",s.blue);
		mainPanel.add(pbBuscarCliente);
		pbBuscarCliente.setBounds(376,162, 155, 180);
		pbBuscarCliente.btn.addActionListener(this);
		
		bc.pnHeader.btnBack.addActionListener(this);		
		am.btnBack.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pbMovimientos.btn) {
			am.setVisible(true);
			this.setVisible(false);			
		}else if(e.getSource() == am.btnBack ) {
			this.setVisible(true);
			am.setVisible(false);
		}else if(e.getSource() == pbSolicitud.btn) {
			this.setVisible(false);
			solicitud.setVisible(true);
			solicitud.limpiarCamposSolicitud();			
			solicitud.pnSolicitud.setVisible(false);
			solicitud.pnPrincipal.setVisible(true);
			solicitud.pnAvales.setVisible(false);
			solicitud.pnRegistrados.setVisible(false);
			solicitud.pnSolicitudReg.setVisible(false);
			solicitud.idSolicitud = solicitud.getCurrentIdFrom("solicitudes_personales");
		}else if(e.getSource() == solicitud.headerPrincipal.btnBack) {
			this.setVisible(true);
			solicitud.setVisible(false); 
		}else if(e.getSource() == pbGrupos.btn) {
			g.setVisible(true);
			this.setVisible(false);						
		}else if(e.getSource() == g.pnHeader.btnBack) {
			g.setVisible(false);
			this.setVisible(true);
		}else if(e.getSource() == pbBuscarCliente.btn) {
			bc.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == bc.pnHeader.btnBack) {
			bc.setVisible(true);			
			this.setVisible(true);
		}else if(e.getSource() == pbBuscarCred.btn) {
			bcred.setVisible(true);
			this.setVisible(false);
		}
	}
}
