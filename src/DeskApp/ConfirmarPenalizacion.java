package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class ConfirmarPenalizacion extends JFrame implements ActionListener,MouseListener{

	Style s = new Style();
	private JPanel contentPane;
	JPanel pnHeader,mainPanel;
	JLabel lblBack;
	JButton btnCancelar,btnConfirmar,btnGrupal,btnPersonal;
	private JLabel lblHeader;
	JLabel lblComentarios,txtCliente,txtCredito;
	JTextArea txtComentarios;

	public ConfirmarPenalizacion() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 291, 309);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.WHITE);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		btnCancelar.setBounds(10, 265, 132, 23);
		mainPanel.add(btnCancelar);
		s.mdButton(btnCancelar, s.red);
		btnCancelar.addMouseListener(this);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		btnConfirmar.setBounds(152, 265, 132, 23);
		mainPanel.add(btnConfirmar);
		btnConfirmar.addMouseListener(this);
		s.mdButton(btnConfirmar, s.blue);
		
		lblHeader = new JLabel("Confirmacion Penalizaci\u00F3n");
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(10, 11, 271, 23);
		mainPanel.add(lblHeader);
		
		txtComentarios = new JTextArea();
		txtComentarios.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtComentarios.setBounds(31, 178, 226, 63);
		mainPanel.add(txtComentarios);
		txtComentarios.setEditable(false);
		
		lblComentarios = new JLabel("Comentarios");
		lblComentarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentarios.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblComentarios.setBounds(10, 153, 271, 14);
		mainPanel.add(lblComentarios);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCliente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblCliente.setBounds(10, 70, 110, 14);
		mainPanel.add(lblCliente);
		
		JLabel lblCredito = new JLabel("Credito:");
		lblCredito.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblCredito.setBounds(10, 95, 110, 14);
		mainPanel.add(lblCredito);
		
		txtCliente = new JLabel("");
		txtCliente.setHorizontalAlignment(SwingConstants.LEFT);
		txtCliente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCliente.setBounds(130, 71, 151, 14);
		mainPanel.add(txtCliente);
		
		txtCredito = new JLabel("");
		txtCredito.setHorizontalAlignment(SwingConstants.LEFT);
		txtCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCredito.setBounds(130, 96, 151, 14);
		mainPanel.add(txtCredito);
		
		
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void llenarDatos(ResultSet rs) {
		try {
			if(rs.next()) {
				txtCredito.setText(rs.getString("cp.id"));
				txtCliente.setText(rs.getString("clp.id"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
