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
import javax.swing.JTextField;

public class MostrarCreditoMensual extends JFrame implements ActionListener,MouseListener{

	Style s = new Style();
	JPanel pnHeader;
	JButton  btnBack;
	private JPanel contentPane;
	JTextField txtIdCredito,txtCantidad,txtFecha,txtCliente,txtIntereses;
	JLabel lblCantidad;
	public MostrarCreditoMensual() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 593, 379);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.WHITE);

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

		
		JLabel lblNewLabel = new JLabel("Credito Mensual");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblNewLabel.setBounds(65, 11, 476, 32);
		pnHeader.add(lblNewLabel);
		
		txtIdCredito = new JTextField();
		txtIdCredito.setEditable(false);
		txtIdCredito.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtIdCredito.setBounds(10, 134, 245, 33);
		mainPanel.add(txtIdCredito);
		s.mdTextField(txtIdCredito, s.blue, Color.white);
		txtIdCredito.setColumns(10);
		
		JLabel lblIdCredito = new JLabel("ID Credito");
		lblIdCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblIdCredito.setBounds(10, 109, 245, 14);
		mainPanel.add(lblIdCredito);
		
		lblCantidad = new JLabel("Prestamo por:");
		lblCantidad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblCantidad.setBounds(10, 178, 245, 14);
		mainPanel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(10, 203, 245, 33);
		s.mdTextField(txtCantidad, s.blue, Color.white);
		mainPanel.add(txtCantidad);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblFecha.setBounds(10, 247, 245, 14);
		mainPanel.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtFecha.setColumns(10);
		txtFecha.setBounds(10, 272, 245, 33);
		s.mdTextField(txtFecha, s.blue, Color.WHITE);
		mainPanel.add(txtFecha);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblCliente.setBounds(298, 111, 245, 14);
		mainPanel.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCliente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtCliente.setColumns(10);
		txtCliente.setBounds(298, 136, 245, 33);
		s.mdTextField(txtCliente, s.blue, Color.white);
		mainPanel.add(txtCliente);
		
		JLabel lblIntereses = new JLabel("Intereses generados al corte");
		lblIntereses.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblIntereses.setBounds(298, 178, 245, 14);
		mainPanel.add(lblIntereses);
		
		txtIntereses = new JTextField();
		txtIntereses.setEditable(false);
		txtIntereses.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntereses.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtIntereses.setColumns(10);
		txtIntereses.setBounds(298, 203, 245, 33);
		s.mdTextField(txtIntereses, s.blue, Color.WHITE);
		mainPanel.add(txtIntereses);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnBack) {
			s.btnPointer(btnBack);
			s.hoverBorder(btnBack, Color.WHITE);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnBack) {
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
	
	public void llenarDatos(String credito,String cliente,String cantidad,String intereses,String fecha) {
		txtIdCredito.setText(credito);
		txtCliente.setText(cliente);
		txtCantidad.setText(cantidad);
		txtIntereses.setText(intereses);
		txtFecha.setText(fecha);
	}
	
	

}

