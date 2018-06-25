package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CreateAval extends JFrame implements ActionListener,MouseListener{
	Style s = new Style();
	JButton btnNext;
	JLabel lblWarning;
	Conexion c = new Conexion();
	private JPanel contentPane;
	JTextField txtName,txtAp1,txtAp2,txtDireccion,txtNumInt,txtNumExt,txtTelefono;
	private JLabel lblColonia;
	private JTextField txtColonia;
	JButton btnOmit,btnBack;

	public CreateAval() {
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
		
		JLabel label = new JLabel("Nuevo Cliente: Datos de Empleo");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		label.setBounds(87, 10, 447, 32);
		pnHeader.add(label);
		
		btnNext = new JButton("");
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		
		txtName = new JTextField();
		txtName.setForeground(Color.WHITE);
		txtName.setBounds(10, 69, 168, 20);
		pnHeader.add(txtName);
		txtName.setColumns(10);
		s.mdTextField(txtName, Color.white,s.blue);
		s.myTextPrompt(txtName, "Nombre", Color.white);
		
		txtAp1 = new JTextField();
		txtAp1.setForeground(Color.WHITE);
		txtAp1.setColumns(10);
		txtAp1.setBounds(188, 69, 160, 20);
		pnHeader.add(txtAp1);
		s.mdTextField(txtAp1, Color.white, s.blue);
		s.myTextPrompt(txtAp1, "Apellido Paterno",Color.white);
		
		txtAp2 = new JTextField();
		txtAp2.setForeground(Color.WHITE);
		txtAp2.setColumns(10);
		txtAp2.setBounds(358, 69, 160, 20);
		pnHeader.add(txtAp2);
		s.mdTextField(txtAp2, Color.white, s.blue);
		s.myTextPrompt(txtAp2, "Apellido Materno", Color.white);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNombre.setBounds(10, 54, 168, 14);
		pnHeader.add(lblNombre);
		
		JLabel lblAp1 = new JLabel("");
		lblAp1.setForeground(Color.WHITE);
		lblAp1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblAp1.setBounds(188, 54, 160, 14);
		pnHeader.add(lblAp1);
		
		JLabel lblAp2 = new JLabel("");
		lblAp2.setForeground(Color.WHITE);
		lblAp2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblAp2.setBounds(358, 54, 160, 14);
		pnHeader.add(lblAp2);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(27, 143, 200, 33);
		mainPanel.add(txtDireccion);
		s.mdTextField(txtDireccion, s.blue, Color.WHITE);
		s.myTextPrompt(txtDireccion, "Direccion", Color.GRAY);
		
		JLabel lblDireccion = new JLabel("");
		lblDireccion.setForeground(Color.BLACK);
		lblDireccion.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblDireccion.setBounds(27, 126, 200, 14);
		mainPanel.add(lblDireccion);
		
		txtNumInt = new JTextField();
		txtNumInt.setColumns(10);
		txtNumInt.setBounds(336, 214, 200, 33);
		mainPanel.add(txtNumInt);
		s.mdTextField(txtNumInt, s.blue, Color.white);
		s.myTextPrompt(txtNumInt, "Numero Interior", Color.gray);
		
		JLabel lblNumInt = new JLabel("");
		lblNumInt.setForeground(Color.BLACK);
		lblNumInt.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNumInt.setBounds(336, 202, 200, 14);
		mainPanel.add(lblNumInt);
		
		txtNumExt = new JTextField();
		txtNumExt.setColumns(10);
		txtNumExt.setBounds(27, 214, 200, 33);
		mainPanel.add(txtNumExt);
		s.mdTextField(txtNumExt, s.blue, Color.white);
		s.myTextPrompt(txtNumExt, "Numero Exterior", Color.GRAY);
		
		JLabel lblNumExt = new JLabel("");
		lblNumExt.setForeground(Color.BLACK);
		lblNumExt.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNumExt.setBounds(27, 202, 200, 14);
		mainPanel.add(lblNumExt);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(27, 298, 200, 33);
		mainPanel.add(txtTelefono);
		s.mdTextField(txtTelefono, s.blue, Color.WHITE);
		s.myTextPrompt(txtTelefono, "Teléfono", Color.GRAY);
		
		JLabel lblTelefono = new JLabel("");
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblTelefono.setBounds(27, 281, 200, 14);
		mainPanel.add(lblTelefono);
		
		btnNext.addMouseListener(this);
		
		s.placeholder(txtName, lblNombre, "Nombre");
		s.placeholder(txtAp1, lblAp1, "Apellido Paterno");
		s.placeholder(txtAp2, lblAp2, "Apellido Materno");
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 10, 32, 32);
		pnHeader.add(btnBack);
		s.btnIcon(btnBack, "views/btnBack.png");
		
		s.placeholder(txtDireccion, lblDireccion, "Direccion");
		s.placeholder(txtNumExt, lblNumExt, "Numero Exterior");
		s.placeholder(txtNumInt, lblNumInt, "Numero Interior");
		s.placeholder(txtTelefono, lblTelefono, "Telefono");
		
		lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblWarning.setBounds(129, 326, 341, 21);
		mainPanel.add(lblWarning);
		
		lblColonia = new JLabel("");
		lblColonia.setForeground(Color.BLACK);
		lblColonia.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblColonia.setBounds(336, 126, 200, 14);
		mainPanel.add(lblColonia);
		
		txtColonia = new JTextField();
		txtColonia.setColumns(10);
		txtColonia.setBounds(336, 143, 200, 33);
		mainPanel.add(txtColonia);
		s.placeholder(txtColonia, lblColonia, "Colonia");
		s.mdTextField(txtColonia, s.blue, Color.WHITE);
		s.myTextPrompt(txtColonia, "Colonia", Color.gray);
		
		btnOmit = new JButton("Omitir");
		btnOmit.setForeground(Color.WHITE);
		btnOmit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		btnOmit.setBounds(516, 337, 67, 32);
		mainPanel.add(btnOmit);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnNext) {
			s.hoverBorder(btnNext, Color.white);
			s.btnPointer(btnNext);
		}else if(e.getSource() == btnOmit) {
			s.hoverBorder(btnOmit, Color.white);
			s.btnPointer(btnOmit);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnNext) {
			btnNext.setBorder(null);
		}else if(e.getSource() == btnOmit) {
			btnOmit.setBorder(null);
		}		
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
		
		
	}
	
	public boolean fullFields() {
		if(txtNumExt.getText().length()>0 && txtName.getText().length()>0 && txtAp1.getText().length()>0 && txtAp2.getText().length()>0&&txtTelefono.getText().length()>0 && txtDireccion.getText().length()>0) {
			return true;
		}else {
			lblWarning.setText("Algunos campos estan vacíos");
			return false;	
		}
	}
	
	public void addAval(String name,String ap1,String ap2) {
		try {
			c.update("INSERT INTO avales (id_Cliente,Nombre,Apellido_Paterno,Apellido_Materno,Direccion,Num_Exterior,Num_Interior,Colonia,Telefono) VALUES ("+getIdClienteByName(name,ap1,ap2)+",'"+txtName.getText()+"','"+txtAp1.getText()+"','"+txtAp2.getText()+"','"+txtDireccion.getText()+"','"+txtNumExt.getText()+"','"+txtNumInt.getText()+"','"+txtColonia.getText()+"','"+txtTelefono.getText()+"');");
			
		}catch(NumberFormatException nfe) {
			lblWarning.setText("Algunos campos deben ser numericos");
		}
	}
	
	public int getIdClienteByName(String name,String ap1,String ap2) {
		try {
			ResultSet rs = c.query("SELECT * FROM clientes_personal where nombre = '"+name+"' AND Apellido_Paterno = '"+ap1+"' AND Apellido_Materno ='"+ap2+"';");
			if(rs.next()) { 
				return rs.getInt("id");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return (Integer) null;
	}
		
	
}
