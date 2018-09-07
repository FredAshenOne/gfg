package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MostrarCliente extends JFrame implements ActionListener{

	private JPanel contentPane, pnPersonal, pnInfoEmpleo;
	int idUser, tipoUsuario = 1;
	
	// lbls txt para informacion personal
	MdTextField txtNombre, txtAp1, txtAp2, txtDomicilio, txtExterior, txtInterior, txtNacimiento, txtOcupacion,
			txtColonia, txtTiempo, txtCelular, txtNumFijo, txtSueldo, txtCiudad;
	JComboBox cbTipoDom, cbEstadoCivil;
	
	// componentes para info de empleo
	MdTextField txtTelefonoEmpleo, txtDireccion, txtExteriorEmpleo, txtInteriorEmpleo, txtDescripcion, txtTiempoEmpleo;

	NuevoAval ca = new NuevoAval();
	Style s = new Style();
	MdHeader pnHeader;
	IconButton btnSave, btnInfoPersonal, btnEdit;
	DatosEmpleo jd = new DatosEmpleo();
	Conexion c = new Conexion();
	Alert alOk = new Alert();
	ResultSet rs;
	Alert alUpdate = new Alert();
	MostarDatosEmpleo sjd = new MostarDatosEmpleo();
	BuscarAvales sad = new BuscarAvales();

	public MostrarCliente() {
		setBounds(100, 100, 1135, 827);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel principal de contenido

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1133, 798);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.WHITE);

		// panel de encabezado para info personal

		pnHeader = new MdHeader(s.blue, Color.WHITE);
		pnHeader.setBounds(0, 0, 1123, 151);
		mainPanel.add(pnHeader);
		pnHeader.btnNext.setVisible(false);
		pnHeader.lblTitle.setText("Datos del Cliente");

		txtNombre = new MdTextField(Color.WHITE, "Nombre(s)", s.blue, Color.WHITE,"Nombre(s)");
		txtNombre.setBounds(7, 115, 300, 25);
		pnHeader.add(txtNombre);

		txtAp1 = new MdTextField(Color.WHITE, "Nombre(s)", s.blue, Color.WHITE,"A. Paterno");
		txtAp1.setBounds(317, 115, 245, 25);
		pnHeader.add(txtAp1);
		txtAp1.setLblBounds();

		txtAp2 = new MdTextField(Color.WHITE, "Nombre(s)", s.blue, Color.WHITE,"A. Materno");
		txtAp2.setBounds(575, 115, 245, 25);
		pnHeader.add(txtAp2);
		txtAp2.setLblBounds();

		btnSave = new IconButton("views/saveWhite.png", Color.white);
		btnSave.setBounds(1065, 108, 32, 32);
		pnHeader.add(btnSave);
		btnSave.addActionListener(this);
		btnEdit = new IconButton("views/edit.png", Color.white);
		btnEdit.setBounds(1065, 108, 32, 32);
		if (tipoUsuario == 1) {
			btnEdit.setVisible(true);
		}
		pnHeader.add(btnEdit);
		btnEdit.addActionListener(this);

		// panel para informacion personal

		pnPersonal = new JPanel();
		pnPersonal.setLayout(null);
		pnPersonal.setBounds(0, 150, 513, 650);
		mainPanel.add(pnPersonal);
		s.mdPanel(pnPersonal, Color.white);

		txtNacimiento = new MdTextField(Color.BLACK, "AAAA-MM-DD", Color.white, s.blue,"Nacimiento");
		txtNacimiento.setBounds(62, 181, 179, 32);
		pnPersonal.add(txtNacimiento);
		txtNacimiento.setLblBounds();

		txtOcupacion = new MdTextField(Color.BLACK, "Ocupacion", Color.white, s.blue,"Ocupacion");
		txtOcupacion.setBounds(76, 455, 170, 31);
		pnPersonal.add(txtOcupacion);
		txtOcupacion.setLblBounds();

		txtDomicilio = new MdTextField(Color.BLACK, "Domicilio", Color.white, s.blue,"Domicilio");
		txtDomicilio.setBounds(251, 181, 197, 32);
		pnPersonal.add(txtDomicilio);
		txtDomicilio.setLblBounds();

		txtExterior = new MdTextField(Color.BLACK, "No. Exterior", Color.white, s.blue,"No. Exterior");
		txtExterior.setBounds(92, 276, 95, 32);
		pnPersonal.add(txtExterior);
		txtExterior.setLblBounds();

		txtInterior = new MdTextField(Color.BLACK, "No. Interior", Color.white, s.blue,"No. Interior");
		txtInterior.setBounds(197, 276, 95, 32);
		pnPersonal.add(txtInterior);
		txtInterior.setLblBounds();

		txtColonia = new MdTextField(Color.BLACK, "Colonia", Color.white, s.blue,"Colonia");
		txtColonia.setBounds(265, 72, 238, 32);
		pnPersonal.add(txtColonia);
		txtColonia.setLblBounds();

		txtTiempo = new MdTextField(Color.BLACK, "Tiempo en residencia", Color.white, s.blue,"Tiempo en residencia");
		txtTiempo.setBounds(302, 276, 115, 32);
		pnPersonal.add(txtTiempo);
		txtTiempo.setLblBounds();

		txtCelular = new MdTextField(Color.BLACK, "Celular", Color.white, s.blue,"Celular");
		txtCelular.setBounds(76, 538, 170, 34);
		pnPersonal.add(txtCelular);
		txtCelular.setLblBounds();

		txtNumFijo = new MdTextField(Color.BLACK, "Num Fijo", Color.white, s.blue,"Telefono");
		txtNumFijo.setBounds(251, 540, 184, 32);
		pnPersonal.add(txtNumFijo);
		txtNumFijo.setLblBounds();

		txtSueldo = new MdTextField(Color.BLACK, "Sueldo", Color.white, s.blue,"Sueldo Mensual");
		txtSueldo.setBounds(256, 454, 179, 32);
		pnPersonal.add(txtSueldo);
		txtSueldo.setLblBounds();

		txtCiudad = new MdTextField(Color.BLACK, "Ciudad", Color.white, s.blue,"Ciudad");
		txtCiudad.setBounds(15, 72, 238, 32);
		pnPersonal.add(txtCiudad);
		txtCiudad.setLblBounds();

		cbTipoDom = new JComboBox();
		cbTipoDom.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbTipoDom.setModel(
				new DefaultComboBoxModel(new String[] { "", "Propia", "Familiar", "Renta", "Hipoteca", "Otra" }));
		cbTipoDom.setBounds(125, 367, 115, 34);
		pnPersonal.add(cbTipoDom);
		s.mdCombo(cbTipoDom, Color.WHITE, s.blue);
		cbTipoDom.setEditable(false);
		s.mdCombo(cbTipoDom, Color.white, s.blue);
		JLabel lblTipoCasa = new JLabel("Tipo de Casa");
		lblTipoCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoCasa.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTipoCasa.setBounds(125, 351, 115, 14);
		pnPersonal.add(lblTipoCasa);

		cbEstadoCivil = new JComboBox();
		cbEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbEstadoCivil.setModel(new DefaultComboBoxModel(
				new String[] { "", "Soltero", "Casado", "Viudo", "Divorciado", "Union Libre", "Otro" }));
		cbEstadoCivil.setBounds(250, 367, 115, 34);
		pnPersonal.add(cbEstadoCivil);
		cbEstadoCivil.setEditable(false);
		s.mdCombo(cbEstadoCivil, Color.white, s.blue);
		s.mdCombo(cbEstadoCivil, Color.WHITE, s.blue);

		JLabel lblEstadoCivil = new JLabel();
		lblEstadoCivil.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoCivil.setText("Estado Civil");
		lblEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblEstadoCivil.setBounds(250, 351, 115, 14);
		pnPersonal.add(lblEstadoCivil);
		
		JLabel lblTituloPersonal = new JLabel("Informaci\u00F3n Personal");
		lblTituloPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPersonal.setForeground(Color.BLACK);
		lblTituloPersonal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblTituloPersonal.setBounds(10, 11, 493, 32);
		pnPersonal.add(lblTituloPersonal);

		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Datos guardados con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);
		
		// 	Panel para info de empleo

		pnInfoEmpleo = new JPanel();
		pnInfoEmpleo.setBounds(514, 150, 609, 650);
		mainPanel.add(pnInfoEmpleo);
		pnInfoEmpleo.setLayout(null);
		s.mdPanel(pnInfoEmpleo, Color.white);
		pnInfoEmpleo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, s.blue));

		JLabel lblInfoEmpleo = new JLabel("Informaci\u00F3n Laboral");
		lblInfoEmpleo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoEmpleo.setForeground(new Color(0, 0, 0));
		lblInfoEmpleo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblInfoEmpleo.setBounds(10, 11, 589, 32);
		pnInfoEmpleo.add(lblInfoEmpleo);

		txtDireccion = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, s.blue,"Domicilio");
		txtDireccion.setBounds(20, 71, 222, 32);
		pnInfoEmpleo.add(txtDireccion);
		txtDireccion.setLblBounds();

		txtExteriorEmpleo = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, s.blue,"No. Exterior");
		txtExteriorEmpleo.setBounds(307, 71, 95, 32);
		pnInfoEmpleo.add(txtExteriorEmpleo);
		txtExteriorEmpleo.setLblBounds();

		txtInteriorEmpleo = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, s.blue,"No. Interior");
		txtInteriorEmpleo.setBounds(465, 71, 95, 32);
		pnInfoEmpleo.add(txtInteriorEmpleo);
		txtInteriorEmpleo.setLblBounds();

		txtTelefonoEmpleo = new MdTextField(Color.BLACK, "Teléfono", Color.WHITE, s.blue,"Teléfono");
		txtTelefonoEmpleo.setBounds(20, 169, 177, 31);
		pnInfoEmpleo.add(txtTelefonoEmpleo);
		txtTelefonoEmpleo.setLblBounds();

		txtDescripcion = new MdTextField(Color.BLACK, "Indicaciones", Color.WHITE, s.blue,"Indicaciones");
		txtDescripcion.setBounds(209, 168, 181, 32);
		pnInfoEmpleo.add(txtDescripcion);
		txtDescripcion.setLblBounds();

		txtTiempoEmpleo = new MdTextField(Color.BLACK, "Tiempo en Empleo", Color.WHITE, s.blue,"Tiempo en empleo");
		txtTiempoEmpleo.setBounds(402, 168, 181, 32);
		pnInfoEmpleo.add(txtTiempoEmpleo);
		txtTiempoEmpleo.setLblBounds();

		alUpdate.lblAlertIcon.setIcon(new ImageIcon("views/ask.png"));
		alUpdate.lblMessage
				.setText("<html><body>Se actualizaran los datos del cliente<br>desea continuar?</body></html>");
		alUpdate.btnOk.addActionListener(this);
		alUpdate.btnCancel.addActionListener(this);

		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Cliente registrado con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEdit) {
			btnEdit.setVisible(false);
			btnSave.setVisible(true);
			setEditableFields(true);
		} else if (e.getSource() == btnSave) {
			alUpdate.setVisible(true);
		} else if (e.getSource() == alUpdate.btnOk) {
			actualizarCliente();
			alUpdate.setVisible(false);
			alOk.setVisible(true);
			btnEdit.setVisible(true);
			btnSave.setVisible(false);
		} else if (e.getSource() == alUpdate.btnCancel) {
			alUpdate.setVisible(false);

		} else if (e.getSource() == alOk.btnOk) {
			alOk.setVisible(false);
			setEditableFields(false);
			
		}

	}

	public void fillFields() {
		try {
			if (rs.next()) {
				txtNombre.setText(rs.getString("cp.Nombre"));
				txtAp1.setText(rs.getString("cp.Paterno"));
				txtAp2.setText(rs.getString("cp.Materno"));
				txtDomicilio.setText(rs.getString("cp.Direccion"));
				txtExterior.setText(rs.getString("cp.Num_Exterior"));
				txtInterior.setText(rs.getString("cp.Num_Interior"));
				txtNacimiento.setText(rs.getString("cp.Fecha_Nacimiento"));
				txtColonia.setText(rs.getString("cp.colonia"));
				txtTiempo.setText(rs.getString("cp.Tiempo_Residencia"));
				cbTipoDom.setSelectedIndex(rs.getInt("cp.Tipo_Casa"));
				cbEstadoCivil.setSelectedIndex(rs.getInt("cp.Estado_Civil"));
				txtCelular.setText(rs.getString("cp.Telefono_Cel"));
				txtNumFijo.setText(rs.getString("cp.Telefono_Fijo"));
				txtOcupacion.setText(rs.getString("cp.Ocupacion"));
				txtSueldo.setText(rs.getString("cp.sueldo_Mensual"));
				txtCiudad.setText(rs.getString("cp.ciudad"));
				sjd.idUser = rs.getInt("id");
				
				txtDireccion.setText(rs.getString("ce.Domicilio"));
				txtExteriorEmpleo.setText(rs.getString("ce.Num_Exterior"));
				txtInteriorEmpleo.setText(rs.getString("ce.Num_Interior"));
				txtTelefonoEmpleo.setText(rs.getString("ce.telefono"));
				txtDescripcion.setText(rs.getString("ce.Descripcion"));
				txtTiempoEmpleo.setText(rs.getString("ce.tiempo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarCliente() {

		try {
				c.update("UPDATE clientes_personal SET Nombre = '" + txtNombre.getText() + "',Paterno = "
					+ "'"+txtAp1.getText() + "',Materno = '" + txtAp2.getText() + "' ,Telefono_Cel = '"
					+ txtCelular.getText() + "'," + "Telefono_Fijo = '" + txtNumFijo.getText() + "',Direccion = '"
					+ txtDomicilio.getText() + "',Num_Exterior = '" + txtExterior.getText() + "',Num_Interior = '"
					+ txtInterior.getText() + "',Colonia = '" + txtColonia.getText() + "',Fecha_Nacimiento = '"
					+ txtNacimiento.getText() + "',ciudad = '"+txtCiudad.getText()+"',Tiempo_Residencia = '" + txtTiempo.getText() + "',Tipo_Casa = "
					+ cbTipoDom.getSelectedIndex() + ",Estado_Civil = " + cbEstadoCivil.getSelectedIndex()
					+ ",Ocupacion = '" + txtOcupacion.getText() + "',Sueldo_Mensual = "
					+ Integer.parseInt(txtSueldo.getText()) + " WHERE id = " + rs.getInt("id") + " ;");

			c.update("UPDATE clientes_empleo SET Domicilio = '" + txtDireccion.getText() + "',Num_Exterior = '"
					+ txtExteriorEmpleo.getText() + "', Num_Interior = '" + txtInteriorEmpleo.getText() + "',Telefono ="
					+ txtNumFijo.getText() + ",tiempo = " + txtTiempoEmpleo.getText() + ",Descripcion = '"
					+ txtDescripcion.getText() + "';");

		} catch (NumberFormatException nfe) {
			pnHeader.lblWarning.setText("Algunos campos deben ser numericos");
			pnHeader.lblWarning.setForeground(Color.RED);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setEditableFields(Boolean b) {
		txtNombre.setEditable(b);
		txtAp1.setEditable(b);
		txtAp2.setEditable(b);
		txtNacimiento.setEditable(b);
		txtOcupacion.setEditable(b);
		txtDomicilio.setEditable(b);
		txtExterior.setEditable(b);
		txtInterior.setEditable(b);
		txtColonia.setEditable(b);
		txtTiempo.setEditable(b);
		txtCelular.setEditable(b);
		txtNumFijo.setEditable(b);
		txtSueldo.setEditable(b);
		cbEstadoCivil.setEnabled(b);
		cbTipoDom.setEnabled(b);
		txtCiudad.setEditable(b);
		txtTelefonoEmpleo.setEditable(b);
		txtDireccion.setEditable(b);
		txtExteriorEmpleo.setEditable(b); 
		txtInteriorEmpleo.setEditable(b);
		txtDescripcion.setEditable(b);
		txtTiempoEmpleo.setEditable(b);
	}

	public boolean fullFields() {
		if (txtNombre.getText().length() > 0 && txtAp1.getText().length() > 0 && txtAp2.getText().length() > 0
				&& cbEstadoCivil.getSelectedIndex() > 0 && cbTipoDom.getSelectedIndex() > 0
				&& txtNacimiento.getText().length() > 0 && txtOcupacion.getText().length() > 0
				&& txtDomicilio.getText().length() > 0 && txtExterior.getText().length() > 0
				&& txtColonia.getText().length() > 0 && txtTiempo.getText().length() > 0
				&& txtCelular.getText().length() > 0 && txtNumFijo.getText().length() > 0
				&& txtSueldo.getText().length() > 0) {
			if (s.checarFecha(txtNacimiento.getText())) {

				if (txtTiempo.getText().length() > 2 || txtCelular.getText().length() > 12
						|| txtNumFijo.getText().length() > 12) {
					pnHeader.lblWarning.setText("Algunos campos exceden el limite de caracteres");
					pnHeader.lblWarning.setForeground(Color.RED);
					return false;
				} else {
					return true;
				}

			} else {
				pnHeader.lblWarning.setText("La fecha introducida no es correcta");
				pnHeader.lblWarning.setForeground(Color.RED);
				return false;
			}
		} else {
			pnHeader.lblWarning.setText("Algunos campos estan Vacíos");
			pnHeader.lblWarning.setForeground(Color.RED);
			return false;
		}
	}

	public void etiquetasVisibles(Boolean flag) {
		txtDomicilio.lbl.setVisible(flag);
		txtExterior.lbl.setVisible(flag);
		txtInterior.lbl.setVisible(flag);
		txtNacimiento.lbl.setVisible(flag);
		txtSueldo.lbl.setVisible(flag);
		txtCelular.lbl.setVisible(flag);
		txtNombre.lbl.setVisible(flag);
		txtAp1.lbl.setVisible(flag);
		txtAp2.lbl.setVisible(flag);
	}
}
