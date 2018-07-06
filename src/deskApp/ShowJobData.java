package deskApp;

import java.awt.Color;
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


public class ShowJobData extends JFrame implements ActionListener,MouseListener{
	Style s = new Style();
	int idUser;
	private JPanel contentPane;
	JButton btnNext,btnSave;
	JLabel lblNumExt, lblDesc, lblTel, lblDom, lblNumInt, lblHeader, lblWarning;
	JTextField txtDom, txtNumExterior, txtTelefono, txtDesc, txtNumInter;
	Conexion c = new Conexion();
	JButton btnBack,btnInfoEmpleo,btnInfoCliente,btnInfoAvales;
	Alert alSave = new Alert();
	
	ResultSet res;
	private JPanel menuPane;
	
	
	public ShowJobData() {
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

		lblHeader = new JLabel("Datos de Empleo");
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(79, 11, 447, 32);
		pnHeader.add(lblHeader);

		btnNext = new JButton("");
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/edit.png");
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		
		txtDom = new JTextField();
		txtDom.setBounds(24, 157, 258, 33);
		mainPanel.add(txtDom);
		txtDom.setColumns(10);
		s.mdTextField(txtDom, s.blue, Color.white);

		txtNumExterior = new JTextField();
		txtNumExterior.setColumns(10);
		txtNumExterior.setBounds(24, 233, 258, 33);
		mainPanel.add(txtNumExterior);
		s.mdTextField(txtNumExterior, s.blue, Color.white);

		lblDom = new JLabel("");
		lblDom.setBounds(24, 138, 258, 14);
		mainPanel.add(lblDom);

		lblNumExt = new JLabel("");
		lblNumExt.setBounds(24, 216, 258, 14);
		mainPanel.add(lblNumExt);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(24, 320, 258, 33);
		mainPanel.add(txtTelefono);
		s.mdTextField(txtTelefono, s.blue, Color.white);

		lblTel = new JLabel("");
		lblTel.setBounds(24, 305, 258, 14);
		mainPanel.add(lblTel);

		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(310, 157, 258, 33);
		mainPanel.add(txtDesc);
		s.mdTextField(txtDesc, s.blue, Color.white);

		txtNumInter = new JTextField();
		txtNumInter.setColumns(10);
		txtNumInter.setBounds(310, 233, 258, 33);
		mainPanel.add(txtNumInter);
		s.mdTextField(txtNumInter, s.blue, Color.white);

		lblNumInt = new JLabel("");
		lblNumInt.setBounds(310, 216, 258, 14);
		mainPanel.add(lblNumInt);

		lblDesc = new JLabel("");
		lblDesc.setBounds(310, 138, 258, 14);
		mainPanel.add(lblDesc);
		btnNext.addActionListener(this);
		btnNext.addMouseListener(this);

		s.myTextPrompt(txtNumExterior, "Numero Exterior", Color.gray);
		s.placeholder(txtNumExterior, lblNumExt, "Numero Exterior");

		s.myTextPrompt(txtNumInter, "Numero Interior", Color.gray);
		s.placeholder(txtNumInter, lblNumInt, "Numero Interior");

		s.myTextPrompt(txtDesc, "Descripcion", Color.gray);
		s.placeholder(txtDesc, lblDesc, "Descripcion");

		s.myTextPrompt(txtTelefono, "Telefono", Color.gray);
		s.placeholder(txtTelefono, lblTel, "Telefono");

		s.myTextPrompt(txtDom, "Domicilio", Color.gray);
		s.placeholder(txtDom, lblDom, "Domicilio");

		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(105, 111, 385, 22);
		mainPanel.add(lblWarning);
		
		menuPane = new JPanel();
		menuPane.setLayout(null);
		menuPane.setBounds(475, 317, 96, 32);
		mainPanel.add(menuPane);
		
		btnInfoCliente = new JButton("");
		btnInfoCliente.setOpaque(true);
		btnInfoCliente.setBackground(new Color(3, 155, 229));
		btnInfoCliente.setBounds(0, 0, 32, 32);
		menuPane.add(btnInfoCliente);
		s.btnIcon(btnInfoCliente, "views/userBlue.png");
		
		btnInfoEmpleo = new JButton("");
		btnInfoEmpleo.setBounds(32, 0, 32, 32);
		menuPane.add(btnInfoEmpleo);
		btnInfoEmpleo.setBackground(s.blue);
		btnInfoEmpleo.setIcon(new ImageIcon("views/jobWhite.png"));
		
		btnInfoAvales = new JButton("");
		btnInfoAvales.setBounds(64, 0, 32, 32);
		menuPane.add(btnInfoAvales);
		s.btnIcon(btnInfoAvales, "views/avales.png");
		
		btnSave = new JButton("");
		btnSave.setBorder(null);
		btnSave.setBounds(551, 11, 32, 32);
		pnHeader.add(btnSave);
		btnSave.setVisible(false);
		btnSave.addActionListener(this);
		btnSave.addMouseListener(this);
		s.btnIcon(btnSave, "views/saveWhite.png");
		
		alSave.lblAlertIcon.setIcon(new ImageIcon("views/alert.png"));
		alSave.lblMessage.setText("Desea guardar los datos y continuar?");
		alSave.setForeground(Color.BLACK);
		btnBack.addMouseListener(this);
		
		btnInfoEmpleo.addMouseListener(this);
		btnInfoCliente.addMouseListener(this);
		btnInfoAvales.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnBack) {
			s.hoverBorder(btnBack, Color.WHITE);
			s.btnPointer(btnBack);
		}else if(e.getSource() == btnNext) {
			s.hoverBorder(btnNext, Color.WHITE);
			s.btnPointer(btnNext);
		}else if(e.getSource() == btnInfoAvales) {
			s.hoverBorder(btnInfoAvales, s.blue);
			s.btnPointer(btnInfoAvales);
		}else if(e.getSource() == btnInfoCliente) {
			s.hoverBorder(btnInfoCliente, s.blue);
			s.btnPointer(btnInfoCliente);
		}else if(e.getSource() == btnInfoEmpleo) {
			s.btnPointer(btnInfoEmpleo);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnInfoCliente) {
			btnInfoCliente.setBorder(null);
		}else if(e.getSource() == btnInfoAvales) {
			btnInfoAvales.setBorder(null);
		}else if(e.getSource() == btnBack) {
			btnBack.setBorder(null);
		}else if(e.getSource() == btnNext) {
			btnNext.setBorder(null);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			fieldsEditable(true);
			btnNext.setVisible(false);
			btnSave.setVisible(true);
		}else if(e.getSource() == btnSave) {
			if(fullFields()) {
				lblWarning.setText("");
				
				alSave.setVisible(true);
			}else {
				lblWarning.setForeground(Color.red);
			}
		}
		
	}
	
	public void clearFields() {
		txtDom.setText("");
		txtDesc.setText("");
		txtTelefono.setText("");
		txtNumExterior.setText("");
		txtNumInter.setText("");
	}
	
	public void addDatosEmpleo(String name, String ap1, String ap2) {
		try {
			c.update(
					"INSERT INTO clientes_empleo (id_cliente,Descripcion,Domicilio,Num_Exterior,Num_Interior,Telefono) VALUES ("
							+ getIdClienteByName(name, ap1, ap2) + ",'" + txtDesc.getText() + "','" + txtDom.getText()
							+ "','" + txtNumExterior.getText() + "','" + txtNumInter.getText() + "','"
							+ txtTelefono.getText() + "');");
		} catch (NumberFormatException nfe) {
			lblWarning.setText("Algunos campos deben ser numericos");
		}

	}

	public int getIdClienteByName(String name, String ap1, String ap2) {
		ResultSet rs = c.query("SELECT * FROM clientes_personal WHERE Nombre = '" + name + "' AND Apellido_Paterno = '"
				+ ap1 + "' AND Apellido_Materno = '" + ap2 + "';");
		try {
			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return (Integer) null;
	}

	public boolean fullFields() {
		if (txtNumExterior.getText().length() > 0 && txtDesc.getText().length() > 0 && txtDom.getText().length() > 0
				&& txtTelefono.getText().length() > 0) {
			return true;
		} else {
			lblWarning.setText("Algunos campos estan vacíos");
			return false;
		}
	}

	public void actulizarDatosEmpleo(String name, String ap1, String ap2) {
		try {
			c.update("UPDATE clientes_empleo SET id_cliente = " + getIdClienteByName(name, ap1, ap2) + ",Descripcion = '"
					+ txtDesc.getText() + "',Domicilio = '" + txtDom.getText() + "',Num_Exterior = '"
					+ txtNumExterior.getText() + "',Num_Interior = '" + txtNumInter.getText() + "',Telefono = '"
					+ txtTelefono.getText() + "' WHERE id_cliente = "+getIdClienteByName(name, ap1, ap2)+";");
		} catch (NumberFormatException nfe) {
			lblWarning.setText("Algunos campos deben ser numericos");
		}
	}	
	
	public void fillJobData() {
		ResultSet rs = c.query("SELECT * FROM clientes_Empleo WHERE id_cliente = "+idUser+";");
		try {
			if(rs.next()) {
				txtDom.setText(rs.getString("Domicilio"));
				txtDesc.setText(rs.getString("Descripcion"));
				txtNumInter.setText(rs.getString("Num_Interior"));
				txtNumExterior.setText(rs.getString("Num_Exterior"));
				txtTelefono.setText(rs.getString("Telefono"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void fieldsEditable(Boolean b) {
		txtDom.setEditable(b);
		txtNumExterior.setEditable(b);
		txtTelefono.setEditable(b);
		txtDesc.setEditable(b);
		txtNumInter.setEditable(b);
	}
	
	public ResultSet isJobDataRegistered(int id){
		try{
			ResultSet rs = c.query("SELECT * FROM clientes_empleo where id_Cliente = "+id+";");
			System.out.println("result listo");
			if(rs.next()) {
			return rs;
			}else {
				return null;
			}
		}catch(Exception ex) {
			System.out.println("aqui si llega pero no hay result");
			ex.printStackTrace();
			return null;
		}
	}
	

}
