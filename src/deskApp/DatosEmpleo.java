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

public class DatosEmpleo extends JFrame implements ActionListener, MouseListener {
	Style s = new Style();
	private JPanel contentPane;
	JButton btnNext;
	JLabel lblNumExt, lblDesc, lblTel, lblDom, lblNumInt, lblHeader, lblWarning;
	JTextField txtDom, txtNumExterior, txtTelefono, txtDesc, txtNumInter;
	Conexion c = new Conexion();
	JButton btnOmit, btnBack;
	Alert alSave = new Alert();

	public DatosEmpleo() {
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

		lblHeader = new JLabel("Nuevo Cliente: Datos de Empleo");
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(79, 11, 447, 32);
		pnHeader.add(lblHeader);

		btnNext = new JButton("");
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");

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

		btnOmit = new JButton("Omitir");
		btnOmit.setBounds(501, 337, 67, 32);
		mainPanel.add(btnOmit);
		btnOmit.setForeground(s.blue);
		btnOmit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		btnOmit.addMouseListener(this);
		btnOmit.setBackground(null);
		btnOmit.setBorder(null);
		
		alSave.lblAlertIcon.setIcon(new ImageIcon("views/alert.png"));
		alSave.lblMessage.setText("Desea guardar los datos y continuar?");
		alSave.setForeground(Color.BLACK);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnOmit) {
			s.hoverBorder(btnOmit, s.blue);
			s.btnPointer(btnOmit);
		} else if (e.getSource() == btnNext) {
			s.btnPointer(btnNext);
			s.hoverBorder(btnNext, Color.white);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnOmit) {
			btnOmit.setBorder(null);
		} else if (e.getSource() == btnNext) {
			btnNext.setBorder(null);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (fullFields()) {
				alSave.setVisible(true);
			}
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

}
