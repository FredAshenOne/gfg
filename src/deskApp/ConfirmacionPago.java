package deskApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ConfirmacionPago extends JFrame implements MouseListener {

	private JPanel contentPane;
	JButton btnCancelar, btnConfirmar;
	JTextArea txtObservaciones;
	Style s = new Style();
	JLabel txtCliente, txtIDCredito, txtSemana, txtFechaAsignada, txtFechaDePago,lblSemana,lblFechaAsignada,lblFechaDePago,lblObservaciones,lblCliente,lblIdCredito;
	
	public ConfirmacionPago() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 404, 388);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		JPanel pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 404, 101);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);

		JLabel lblHeader = new JLabel("Confirmacion de Pago");
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblHeader.setBounds(54, 11, 292, 41);
		pnHeader.add(lblHeader);

		JPanel pnBody = new JPanel();
		pnBody.setBounds(0, 102, 404, 287);
		mainPanel.add(pnBody);
		pnBody.setLayout(null);
		s.mdPanel(pnBody, Color.WHITE);

		lblCliente = new JLabel("Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCliente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblCliente.setBounds(10, 11, 132, 24);
		pnBody.add(lblCliente);

		lblIdCredito = new JLabel("ID Credito:");
		lblIdCredito.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblIdCredito.setBounds(10, 46, 132, 24);
		pnBody.add(lblIdCredito);

		txtCliente = new JLabel("");
		txtCliente.setHorizontalAlignment(SwingConstants.LEFT);
		txtCliente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCliente.setBounds(152, 11, 223, 24);
		pnBody.add(txtCliente);

		txtIDCredito = new JLabel("");
		txtIDCredito.setHorizontalAlignment(SwingConstants.LEFT);
		txtIDCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtIDCredito.setBounds(152, 46, 223, 24);
		pnBody.add(txtIDCredito);

		lblSemana = new JLabel("Semana");
		lblSemana.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSemana.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblSemana.setBounds(10, 81, 132, 24);
		pnBody.add(lblSemana);

		lblFechaAsignada = new JLabel("Fecha Asignada:");
		lblFechaAsignada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaAsignada.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblFechaAsignada.setBounds(10, 116, 132, 24);
		pnBody.add(lblFechaAsignada);

		lblFechaDePago = new JLabel("Fecha de Pago:");
		lblFechaDePago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDePago.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblFechaDePago.setBounds(10, 151, 132, 24);
		pnBody.add(lblFechaDePago);

		lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblObservaciones.setBounds(10, 186, 132, 24);
		pnBody.add(lblObservaciones);

		txtSemana = new JLabel("");
		txtSemana.setHorizontalAlignment(SwingConstants.LEFT);
		txtSemana.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtSemana.setBounds(152, 81, 223, 24);
		pnBody.add(txtSemana);
		
		txtFechaAsignada = new JLabel("");
		txtFechaAsignada.setHorizontalAlignment(SwingConstants.LEFT);
		txtFechaAsignada.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtFechaAsignada.setBounds(152, 116, 223, 24);
		pnBody.add(txtFechaAsignada);

		txtFechaDePago = new JLabel("");
		txtFechaDePago.setHorizontalAlignment(SwingConstants.LEFT);
		txtFechaDePago.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtFechaDePago.setBounds(152, 151, 223, 24);
		pnBody.add(txtFechaDePago);

		txtObservaciones = new JTextArea();
		txtObservaciones.setBounds(152, 187, 223, 53);
		pnBody.add(txtObservaciones);
		txtObservaciones.setEditable(false);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btnCancelar.setBounds(49, 251, 139, 23);
		pnBody.add(btnCancelar);
		btnCancelar.addMouseListener(this);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btnConfirmar.setBounds(210, 251, 139, 23);
		pnBody.add(btnConfirmar);
		btnConfirmar.addMouseListener(this);
		
		s.mdButton(btnCancelar, s.red);
		s.mdButton(btnConfirmar, s.blue);
	}

	public void llenarConfirmacion(ResultSet rsCliente, ResultSet rsTarjeton, int tipoCredito,String observaciones,String fecha,JLabel lbl) {
		try {

			if (tipoCredito == 1 && rsCliente.next()) {
				txtCliente.setText(rsCliente.getString("Nombre")+" "+rsCliente.getString("Apellido_Paterno")+" "+rsCliente.getString("Apellido_Materno"));
			}else if( tipoCredito == 2 && rsCliente.next()){
				txtCliente.setText(rsCliente.getString("Nombre"));
			}
			if(rsTarjeton.next()) {
				txtIDCredito.setText(rsTarjeton.getString("id_Credito"));
				txtSemana.setText(rsTarjeton.getString("numero_Pago"));
				txtFechaAsignada.setText(rsTarjeton.getString("fecha_Asignada"));
				txtFechaDePago.setText(fecha);
				txtObservaciones.setText(observaciones);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void llenarConfirmacionMensual(int tipoCredito,ResultSet rsCliente,String cantidad,String fecha,int idCredito) {
		try {
			if(tipoCredito == 1 && rsCliente.next()) {
				txtCliente.setText(rsCliente.getString("Nombre")+" "+rsCliente.getString("Apellido_Paterno")+" "+rsCliente.getString("Apellido_Materno"));
			}else if( tipoCredito == 2 && rsCliente.next()){
				txtCliente.setText(rsCliente.getString("Nombre"));
			}			
			txtIDCredito.setText("'"+idCredito+"'");
			txtSemana.setText(cantidad);
			txtFechaAsignada.setText(fecha);
		}catch(Exception ex) {
				ex.printStackTrace();
		}
			
	}
	
	public void lblTexts(Boolean b) {
		if(b) {
			lblSemana.setText("Semana");
			lblFechaAsignada.setText("Fecha Asignada");
			lblFechaDePago.setVisible(true);
		}else {
			lblSemana.setText("Cantidad:");
			lblFechaAsignada.setText("Fecha de Pago:");
			lblFechaDePago.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnCancelar){
			s.btnPointer(btnCancelar);
			s.btnHover(btnCancelar, s.red, Color.white, s.red);
		}else if(e.getSource() == btnConfirmar) {
			s.btnPointer(btnConfirmar);
			s.btnHover(btnConfirmar, s.blue, Color.white, s.blue);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnCancelar) {
			s.btnHover(btnCancelar, s.red, s.red, Color.WHITE);
		}else if(e.getSource() == btnConfirmar) {
			s.btnHover(btnConfirmar, s.blue, s.blue, Color.white);
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
}
