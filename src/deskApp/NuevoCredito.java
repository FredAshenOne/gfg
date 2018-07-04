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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NuevoCredito extends JFrame implements MouseListener,ActionListener{
	Style s = new Style();
	private JPanel contentPane;
	JButton btnBack,btnNext;
	JLabel lblHeader,lblWarning;
	ResultSet rs;
	Conexion c = new Conexion();
	JComboBox cbTipo;
	JTextField txtFecha,txtCantidad;
	public NuevoCredito() {
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
		pnHeader.setBounds(0, 0, 593, 100);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);

		btnBack = new JButton("");
		btnBack.setBorder(null);
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		btnBack.addMouseListener(this);

		lblHeader = new JLabel("");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);
		
		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		
		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(52, 54, 489, 22);
		pnHeader.add(lblWarning);
		
		txtFecha = new JTextField();
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtFecha.setBounds(202, 135, 185, 35);
		mainPanel.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(202, 216, 185, 35);
		mainPanel.add(txtCantidad);
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"", "13 Semanas", "14 Semanas", "Interes Mensual"}));
		cbTipo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbTipo.setBounds(202, 296, 185, 35);
		mainPanel.add(cbTipo);
		
		JLabel lblFecha = new JLabel("Fecha inicio");
		lblFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblFecha.setBounds(202, 111, 185, 22);
		mainPanel.add(lblFecha);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblCantidad.setBounds(202, 194, 185, 22);
		mainPanel.add(lblCantidad);
		
		JLabel lblTipo = new JLabel("Tipo de Credito");
		lblTipo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTipo.setBounds(202, 272, 185, 22);
		mainPanel.add(lblTipo);
		
		s.mdTextField(txtCantidad, s.blue, Color.white);
		s.mdTextField(txtFecha, s.blue, Color.white);
		s.mdCombo(cbTipo, Color.white, s.blue);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Boolean fullFields() {
		if(txtCantidad.getText().length()>0 && cbTipo.getSelectedIndex()>0) {
			return true;			
		}
		return false;
	}
	
	public void createCredito(int id) {
		int cantidad = Integer.parseInt(txtCantidad.getText());
		
		try {
			c.update("INSERT INTO credito (id_Cliente,Cantidad_Inicial,Cantidad_Actual,Tipo_Credito,Fecha_inicio,Status) VALUES ("+id+","+cantidad+","+cantidad+","+cbTipo.getSelectedIndex()+",'"+txtFecha.getText()+"',1);");
		}catch(Exception ex) {
			
		}
	}
}
