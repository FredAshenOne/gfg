package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
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
	JButton btnBack,btnPagos,btnPenalizacion;
	Penalizacion p = new Penalizacion();
	RegistrarPago rp = new RegistrarPago();
	JLabel lblIconPenalizacion,lblPenalizaciones;
	JPanel pnPagos,pnPenalizacion;
	public AdminMovimientos() {
		setResizable(false);
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
		
		JLabel lblHeader = new JLabel("Movimientos");
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblHeader.setBounds(65, 11, 456, 32);
		pnHeader.add(lblHeader);
		
		JLabel lblHeader2 = new JLabel("Seleccione una opci\u00F3n");
		lblHeader2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader2.setForeground(Color.WHITE);
		lblHeader2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblHeader2.setBounds(65, 57, 456, 32);
		pnHeader.add(lblHeader2);
		
		pnPagos = new JPanel();		
		pnPagos.setLayout(null);
		pnPagos.setBounds(24, 156, 155, 180);
		mainPanel.add(pnPagos);
		pnPagos.addMouseListener(this);
		s.mdPanel(pnPagos, Color.white);
		pnPagos.setBorder(null);
		
		JLabel lblIconPagos = new JLabel("");
		lblIconPagos.setBounds(10, 11, 135, 135);
		pnPagos.add(lblIconPagos);
		lblIconPagos.setIcon(new ImageIcon("views/pay.png"));
		
		JLabel lblPagos = new JLabel("Registrar Pago");
		lblPagos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagos.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblPagos.setBounds(10, 157, 135, 23);
		pnPagos.add(lblPagos);
		
		btnPagos = new JButton("");
		btnPagos.setBounds(0, 0, 155, 180);
		pnPagos.add(btnPagos);
		s.btnTransparent(btnPagos);
		btnPagos.addActionListener(this);
		btnPagos.addMouseListener(this);
		
		pnPenalizacion = new JPanel();
		pnPenalizacion.setLayout(null);
		pnPenalizacion.setBounds(212, 156, 155, 180);
		mainPanel.add(pnPenalizacion);
		s.mdPanel(pnPenalizacion, Color.white);
		pnPenalizacion.setBorder(null);
		
		lblIconPenalizacion = new JLabel("");
		lblIconPenalizacion.setBounds(10, 11, 135, 135);
		pnPenalizacion.add(lblIconPenalizacion);
		lblIconPenalizacion.setIcon(new ImageIcon("views/referee.png"));
		
		lblPenalizaciones = new JLabel("Penalizaciones");
		lblPenalizaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblPenalizaciones.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblPenalizaciones.setBounds(10, 157, 135, 23);
		pnPenalizacion.add(lblPenalizaciones);
		
		btnPenalizacion = new JButton("");
		btnPenalizacion.setBounds(0, 0, 155, 180);
		pnPenalizacion.add(btnPenalizacion);
		s.btnTransparent(btnPenalizacion);
		btnPenalizacion.addActionListener(this);
		btnPenalizacion.addMouseListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(404, 156, 155, 180);
		mainPanel.add(panel_2);
		panel_2.setVisible(false);
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
		rp.btnBack.addActionListener(this);
		
		p.btnBack.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnBack) {
			s.hoverBorder(btnBack, Color.WHITE);
			s.btnPointer(btnBack);
		} else if(e.getSource() == btnPagos){
			s.imgBtnHover(s.blue,pnPagos);
			s.panelPointer(pnPagos);
		} else if(e.getSource() == btnPenalizacion){
			s.imgBtnHover(s.blue,pnPenalizacion);
			s.panelPointer(pnPenalizacion);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnBack) {
			btnBack.setBorder(null);
		}else if(e.getSource() == btnPagos) {
			pnPagos.setBorder(null);
		}else if(e.getSource() == btnPenalizacion) {
			pnPenalizacion.setBorder(null);
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPagos) {
			rp.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == rp.btnBack) {
			rp.setVisible(false);
			this.setVisible(true);
		}else if(e.getSource() == btnPenalizacion) {
			p.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == p.btnBack) {
			this.setVisible(true);
			p.setVisible(false);
		}
	}
}
