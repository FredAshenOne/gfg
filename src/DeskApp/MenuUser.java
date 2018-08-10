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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuUser extends JFrame implements ActionListener,MouseListener{
	
	Style s = new Style();
	private JPanel contentPane;
	JPanel pnHeader,pnCliente,pnCredito;
	JLabel lblBack,lblHeader;
	JButton btnBack,btnCredito,btnCliente;
	JTextField txtCredito,txtComentario;
	int tipoCredito = 1;
	ConfirmarPenalizacion cp = new ConfirmarPenalizacion();
	Conexion c = new Conexion();
	Alert alOk = new Alert();
	BuscarCredito bcred = new BuscarCredito();

 MenuUser() {
	 setResizable(false);
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
		pnHeader.setBounds(0, 0, 593, 150);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);

		btnBack = new JButton("");
		btnBack.setBorder(null);
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		btnBack.addMouseListener(this);

		lblHeader = new JLabel("Bienvenido, Selecciona una opci\u00F3n");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);
		 
		pnCredito = new JPanel();
		pnCredito.setLayout(null);
		pnCredito.setBounds(214, 174, 155, 180);
		mainPanel.add(pnCredito);
		s.mdPanel(pnCredito, Color.WHITE);
		JLabel lblIconCredito = new JLabel("");
		lblIconCredito.setIcon(new ImageIcon("views/buscarCredito.png"));
		lblIconCredito.setBounds(10, 11, 135, 135);
		pnCredito.add(lblIconCredito);
		
		JLabel lblCredito = new JLabel("Buscar Credito");
		lblCredito.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblCredito.setBounds(10, 157, 135, 23);
		pnCredito.add(lblCredito);
		
		btnCredito = new JButton("");
		btnCredito.setBounds(0, 0, 155, 180);
		pnCredito.add(btnCredito);
		s.btnTransparent(btnCredito);
		btnCredito.addActionListener(this);
		btnCredito.addMouseListener(this);
		
		pnCliente = new JPanel();
		pnCliente.setLayout(null);
		pnCliente.setBounds(24, 174, 155, 180);
		mainPanel.add(pnCliente);
		s.mdPanel(pnCliente, Color.WHITE);
		
		JLabel lblIconCliente = new JLabel("");
		lblIconCliente.setIcon(new ImageIcon("views/buscarCliente.png"));
		lblIconCliente.setBounds(10, 11, 135, 135);
		pnCliente.add(lblIconCliente);
		
		JLabel lblCliente = new JLabel("Buscar Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblCliente.setBounds(10, 157, 135, 23);
		pnCliente.add(lblCliente);
		
		btnCliente = new JButton("");
		btnCliente.setBounds(0, 0, 155, 180);
		pnCliente.add(btnCliente);
		s.btnTransparent(btnCliente);
		btnCliente.addMouseListener(this);
		btnCliente.addActionListener(this);
		bcred.btnBack.addActionListener(this);
	
	}

@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	if (e.getSource()==btnBack) {
		s.btnPointer(btnBack);
		s.hoverBorder(btnBack, Color.WHITE);
	}else if(e.getSource() == btnCredito) {
		s.imgBtnHover(s.blue,pnCredito);
		s.panelPointer(pnCredito);
	}else if(e.getSource() == btnCliente) {
		s.imgBtnHover(s.blue,pnCliente);
		s.panelPointer(pnCliente);
	}
}

@Override
public void mouseExited(MouseEvent e) {
	if(e.getSource() == btnCredito) {
		pnCredito.setBorder(null);
	}else if(e.getSource() == btnCliente) {
		pnCliente.setBorder(null);
	}else if(e.getSource() == btnBack){
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
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == btnCredito) {
		bcred.setVisible(true);
		this.setVisible(false);
	}else if(e.getSource() == bcred.btnBack) {
		this.setVisible(true);
		bcred.setVisible(false);
	}
}
}
