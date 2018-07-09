package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
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

public class MostarAval extends JFrame implements ActionListener,MouseListener{
	Style s = new Style();
	JButton btnNext;
	JLabel lblWarning;
	Conexion c = new Conexion();
	private JPanel contentPane;
	JTextField txtName,txtAp1,txtAp2,txtDireccion,txtNumInt,txtNumExt,txtTelefono,txtColonia;
	JLabel lblColonia,lblNombre,lblAp1,lblAp2,lblDireccion,lblNumInt,lblNumExt,lblTelefono,lblHeader;
	JButton btnBack;
	Alert alSave = new Alert(); 
	Alert alNewAaval = new Alert();
	public MostarAval() {
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
		
		lblHeader = new JLabel("Aval");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblHeader.setBounds(87, 10, 447, 32);
		pnHeader.add(lblHeader);
		
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
		
		lblNombre = new JLabel("");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNombre.setBounds(10, 54, 168, 14);
		pnHeader.add(lblNombre);
		
		lblAp1 = new JLabel("");
		lblAp1.setForeground(Color.WHITE);
		lblAp1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblAp1.setBounds(188, 54, 160, 14);
		pnHeader.add(lblAp1);
		
		lblAp2 = new JLabel("");
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
		
		lblDireccion = new JLabel("");
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
		
		lblNumInt = new JLabel("");
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
		
		lblNumExt = new JLabel("");
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
		
		lblTelefono = new JLabel("");
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblTelefono.setBounds(27, 281, 200, 14);
		mainPanel.add(lblTelefono);
		
		btnNext.addMouseListener(this);
		
		s.placeholder(txtName, lblNombre, "Nombre");
		s.placeholder(txtAp1, lblAp1, "Apellido Paterno");
		s.placeholder(txtAp2, lblAp2, "Apellido Materno");
		
	
		s.placeholder(txtDireccion, lblDireccion, "Direccion");
		s.placeholder(txtNumExt, lblNumExt, "Numero Exterior");
		s.placeholder(txtNumInt, lblNumInt, "Numero Interior");
		s.placeholder(txtTelefono, lblTelefono, "Telefono");
		
		lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblWarning.setBounds(134, 348, 341, 21);
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
		
		alSave.lblAlertIcon.setIcon(new ImageIcon("views/ask.png"));
		alSave.lblMessage.setText("Desea guardar los datos y continuar ?");
		alSave.lblMessage.setForeground(Color.black);
		alSave.btnOk.addActionListener(this);
		alSave.btnCancel.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnNext) {
			s.hoverBorder(btnNext, Color.white);
			s.btnPointer(btnNext);
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnNext) {
			btnNext.setBorder(null);
		}else if(e.getSource() == btnBack) {
			btnBack.setBorder(null);
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
		if(e.getSource() == btnNext) {
			if(fullFields()) {
				alSave.setVisible(true);
			}
		}else if(e.getSource() == alSave.btnCancel) {
			alSave.setVisible(false);
		}
		
	}
	
	public boolean fullFields() {
		if(txtNumExt.getText().length()>0 && txtName.getText().length()>0 && txtAp1.getText().length()>0 && txtAp2.getText().length()>0&&txtTelefono.getText().length()>0 && txtDireccion.getText().length()>0) {
			return true;
		}else {
			lblWarning.setText("Algunos campos estan vacíos");
			return false;	
		}
	}
	
	public void updateAval(String name,String ap1,String ap2) {
		try {
			c.update(" UPDATE avales SET id_Cliente = "+getIdClienteByName(name,ap1,ap2)+",Nombre = '"+txtName.getText()+"',Apellido_Paterno = '"+txtAp1.getText()+"',Apellido_Materno = '"+txtAp2.getText()+"',Direccion = '"+txtDireccion.getText()+"',"
					+ "Num_Exterior = '"+txtNumExt.getText()+"',Num_Interior = '"+txtNumInt.getText()+"',Colonia = '"+txtColonia.getText()+"',Telefono = '"+txtTelefono.getText()+"';"); 
					
			
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
	
	public void fillAvalData(String name,String ap1,String ap2) {
		try {
			ResultSet rs = c.query("SELECT * FROM avales WHERE nombre = '"+name+"' AND apellido_Paterno = '"+ap1+"' AND apellido_Materno = '"+ap2+"';");
			rs.next();
			txtName.setText(rs.getString("nombre"));
			txtAp1.setText(rs.getString("apellido_Paterno"));
			txtAp2.setText(rs.getString("apellido_Materno"));
			txtDireccion.setText(rs.getString("Direccion"));
			txtNumExt.setText(rs.getString("Num_Exterior"));
			txtNumInt.setText(rs.getString("Num_Interior"));
			txtColonia.setText(rs.getString("Colonia"));
			txtTelefono.setText(rs.getString("Telefono"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void clearFields() {
		txtName.setText("");txtAp1.setText("");txtAp2.setText("");
		txtDireccion.setText("");txtNumInt.setText("");txtNumExt.setText("");
		txtTelefono.setText("");txtColonia.setText("");
		lblColonia.setText("");lblDireccion.setText("");lblTelefono.setText("");
		lblNumExt.setText("");lblNumInt.setText("");lblNombre.setText("");
		lblAp1.setText("");lblAp2.setText("");
	}
}
