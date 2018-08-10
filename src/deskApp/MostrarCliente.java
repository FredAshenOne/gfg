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
	JButton btnInfoCliente, btnInfoEmpleo;

	// lbls txt para informacion personal
	JLabel lblDomicilio, lblExterior, lblInterior, lblNacimiento, lblNombre, lblAp1, lblAp2, lblCelular, lblOcupacion,
			lblColonia, lblResidencia, lblFijo, lblCiudad, lblEstadoCivil, lblSueldo, lblTipoCasa;
	MdTextField txtNombre, txtAp1, txtAp2, txtDomicilio, txtExterior, txtInterior, txtNacimiento, txtOcupacion,
			txtColonia, txtTiempo, txtCelular, txtNumFijo, txtSueldo, txtCiudad;
	JComboBox cbTipoDom, cbEstadoCivil;
	// componentes para info de empleo
	JLabel lblTelefonoEmpleo, lblDireccion, lblExteriorEmpleo, lblInteriorEmpleo, lblDescripcion, lblInfoEmpleo,
			lblTiempoEmpleo;
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

		lblNombre = new JLabel();
		lblNombre.setBounds(7, 101, 300, 14);
		pnHeader.add(lblNombre);
		txtNombre = new MdTextField(Color.WHITE, "Nombre(s)", s.blue, Color.WHITE, lblNombre);
		txtNombre.setBounds(7, 115, 300, 25);
		pnHeader.add(txtNombre);

		lblAp1 = new JLabel("Apellido Paterno");
		lblAp1.setBounds(317, 101, 245, 14);
		pnHeader.add(lblAp1);
		txtAp1 = new MdTextField(Color.WHITE, "Nombre(s)", s.blue, Color.WHITE, lblAp1);
		txtAp1.setBounds(317, 115, 245, 25);
		pnHeader.add(txtAp1);

		lblAp2 = new JLabel("Apellido Materno");
		lblAp2.setBounds(575, 101, 245, 14);
		pnHeader.add(lblAp2);
		txtAp2 = new MdTextField(Color.WHITE, "Nombre(s)", s.blue, Color.WHITE, lblAp2);
		txtAp2.setBounds(575, 115, 245, 25);
		pnHeader.add(txtAp2);

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

		lblNacimiento = new JLabel();
		lblNacimiento.setBounds(57, 133, 179, 14);
		pnPersonal.add(lblNacimiento);
		txtNacimiento = new MdTextField(Color.BLACK, "AAAA-MM-DD", Color.white, s.blue, lblNacimiento);
		lblNacimiento.setText("Fecha Nacimiento");
		txtNacimiento.setBounds(57, 151, 179, 32);
		pnPersonal.add(txtNacimiento);

		lblOcupacion = new JLabel();
		lblOcupacion.setBounds(71, 406, 170, 14);
		pnPersonal.add(lblOcupacion);
		txtOcupacion = new MdTextField(Color.BLACK, "Ocupacion", Color.white, s.blue, lblOcupacion);
		txtOcupacion.setBounds(71, 425, 170, 31);
		pnPersonal.add(txtOcupacion);

		lblDomicilio = new JLabel();
		lblDomicilio.setBounds(246, 133, 197, 14);
		pnPersonal.add(lblDomicilio);
		txtDomicilio = new MdTextField(Color.BLACK, "Domicilio", Color.white, s.blue, lblDomicilio);
		txtDomicilio.setBounds(246, 151, 197, 32);
		pnPersonal.add(txtDomicilio);

		lblExterior = new JLabel();
		lblExterior.setBounds(87, 228, 95, 14);
		pnPersonal.add(lblExterior);
		txtExterior = new MdTextField(Color.BLACK, "No. Exterior", Color.white, s.blue, lblExterior);
		txtExterior.setBounds(87, 246, 95, 32);
		pnPersonal.add(txtExterior);

		lblInterior = new JLabel();
		lblInterior.setBounds(192, 228, 95, 14);
		pnPersonal.add(lblInterior);
		txtInterior = new MdTextField(Color.BLACK, "No. Interior", Color.white, s.blue, lblInterior);
		txtInterior.setBounds(192, 246, 95, 32);
		pnPersonal.add(txtInterior);

		lblColonia = new JLabel("Colonia");
		lblColonia.setBounds(260, 23, 238, 14);
		pnPersonal.add(lblColonia);
		txtColonia = new MdTextField(Color.BLACK, "Colonia", Color.white, s.blue, lblColonia);
		txtColonia.setBounds(260, 42, 238, 32);
		pnPersonal.add(txtColonia);

		lblResidencia = new JLabel("Tiempo Residencia");
		lblResidencia.setBounds(297, 228, 115, 14);
		pnPersonal.add(lblResidencia);
		txtTiempo = new MdTextField(Color.BLACK, "Tiempo de Residencia", Color.white, s.blue, lblResidencia);
		txtTiempo.setBounds(297, 246, 115, 32);
		pnPersonal.add(txtTiempo);

		lblCelular = new JLabel();
		lblCelular.setBounds(71, 492, 170, 14);
		pnPersonal.add(lblCelular);
		txtCelular = new MdTextField(Color.BLACK, "Celular", Color.white, s.blue, lblCelular);
		txtCelular.setBounds(71, 508, 170, 34);
		pnPersonal.add(txtCelular);

		lblFijo = new JLabel();
		lblFijo.setBounds(251, 492, 179, 14);
		pnPersonal.add(lblFijo);
		txtNumFijo = new MdTextField(Color.BLACK, "Num Fijo", Color.white, s.blue, lblFijo);
		txtNumFijo.setBounds(246, 510, 184, 32);
		pnPersonal.add(txtNumFijo);

		lblSueldo = new JLabel();
		lblSueldo.setBounds(249, 405, 181, 14);
		pnPersonal.add(lblSueldo);
		txtSueldo = new MdTextField(Color.BLACK, "Sueldo", Color.white, s.blue, lblSueldo);
		txtSueldo.setBounds(251, 424, 179, 32);
		pnPersonal.add(txtSueldo);

		lblCiudad = new JLabel();
		lblCiudad.setBounds(10, 24, 240, 14);
		pnPersonal.add(lblCiudad);
		txtCiudad = new MdTextField(Color.BLACK, "Ciudad", Color.white, s.blue, lblCiudad);
		txtCiudad.setBounds(10, 42, 238, 32);
		pnPersonal.add(txtCiudad);

		cbTipoDom = new JComboBox();
		cbTipoDom.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbTipoDom.setModel(
				new DefaultComboBoxModel(new String[] { "", "Propia", "Familiar", "Renta", "Hipoteca", "Otra" }));
		cbTipoDom.setBounds(120, 337, 115, 34);
		pnPersonal.add(cbTipoDom);
		s.mdCombo(cbTipoDom, Color.WHITE, s.blue);
		cbTipoDom.setEditable(false);
		s.mdCombo(cbTipoDom, Color.white, s.blue);
		lblTipoCasa = new JLabel("Tipo de Casa");
		lblTipoCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoCasa.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTipoCasa.setBounds(120, 321, 115, 14);
		pnPersonal.add(lblTipoCasa);

		cbEstadoCivil = new JComboBox();
		cbEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbEstadoCivil.setModel(new DefaultComboBoxModel(
				new String[] { "", "Soltero", "Casado", "Viudo", "Divorciado", "Union Libre", "Otro" }));
		cbEstadoCivil.setBounds(245, 337, 115, 34);
		pnPersonal.add(cbEstadoCivil);
		cbEstadoCivil.setEditable(false);
		s.mdCombo(cbEstadoCivil, Color.white, s.blue);
		s.mdCombo(cbEstadoCivil, Color.WHITE, s.blue);

		lblEstadoCivil = new JLabel();
		lblEstadoCivil.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoCivil.setText("Estado Civil");
		lblEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblEstadoCivil.setBounds(245, 321, 115, 14);
		pnPersonal.add(lblEstadoCivil);

		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Datos guardados con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);
// 	Panel para info de empleo

		pnInfoEmpleo = new JPanel();
		pnInfoEmpleo.setBounds(515, 150, 609, 217);
		mainPanel.add(pnInfoEmpleo);
		pnInfoEmpleo.setLayout(null);
		s.mdPanel(pnInfoEmpleo, Color.white);
		pnInfoEmpleo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, s.blue));

		lblInfoEmpleo = new JLabel("Informaci\u00F3n Laboral");
		lblInfoEmpleo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoEmpleo.setForeground(new Color(0, 0, 0));
		lblInfoEmpleo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblInfoEmpleo.setBounds(10, 11, 589, 32);
		pnInfoEmpleo.add(lblInfoEmpleo);

		lblDireccion = new JLabel("");
		lblDireccion.setBounds(20, 54, 222, 14);
		pnInfoEmpleo.add(lblDireccion);
		txtDireccion = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, s.blue, lblDireccion);
		txtDireccion.setBounds(20, 71, 222, 32);
		pnInfoEmpleo.add(txtDireccion);

		lblExteriorEmpleo = new JLabel("");
		lblExteriorEmpleo.setBounds(307, 54, 95, 14);
		pnInfoEmpleo.add(lblExteriorEmpleo);
		txtExteriorEmpleo = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, s.blue, lblExteriorEmpleo);
		txtExteriorEmpleo.setBounds(307, 71, 95, 32);
		pnInfoEmpleo.add(txtExteriorEmpleo);

		lblInteriorEmpleo = new JLabel("");
		lblInteriorEmpleo.setBounds(465, 54, 95, 14);
		pnInfoEmpleo.add(lblInteriorEmpleo);
		txtInteriorEmpleo = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, s.blue, lblInteriorEmpleo);
		txtInteriorEmpleo.setBounds(465, 71, 95, 32);
		pnInfoEmpleo.add(txtInteriorEmpleo);

		lblTelefonoEmpleo = new JLabel("");
		lblTelefonoEmpleo.setBounds(20, 148, 177, 14);
		pnInfoEmpleo.add(lblTelefonoEmpleo);
		txtTelefonoEmpleo = new MdTextField(Color.BLACK, "Teléfono", Color.WHITE, s.blue, lblTelefonoEmpleo);
		txtTelefonoEmpleo.setBounds(20, 169, 177, 31);
		pnInfoEmpleo.add(txtTelefonoEmpleo);

		lblDescripcion = new JLabel("");
		lblDescripcion.setBounds(207, 148, 183, 14);
		pnInfoEmpleo.add(lblDescripcion);
		txtDescripcion = new MdTextField(Color.BLACK, "Descripcion", Color.WHITE, s.blue, lblDescripcion);
		txtDescripcion.setBounds(209, 168, 181, 32);
		pnInfoEmpleo.add(txtDescripcion);

		lblTiempoEmpleo = new JLabel("");
		lblTiempoEmpleo.setBounds(400, 148, 183, 14);
		pnInfoEmpleo.add(lblTiempoEmpleo);
		txtTiempoEmpleo = new MdTextField(Color.BLACK, "Tiempo Empleo", Color.WHITE, s.blue, lblTiempoEmpleo);
		txtTiempoEmpleo.setBounds(402, 168, 181, 32);
		pnInfoEmpleo.add(txtTiempoEmpleo);

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
		lblDomicilio.setVisible(flag);
		lblExterior.setVisible(flag);
		lblInterior.setVisible(flag);
		lblNacimiento.setVisible(flag);
		lblSueldo.setVisible(flag);
		lblCelular.setVisible(flag);
		lblNombre.setVisible(flag);
		lblAp1.setVisible(flag);
		lblAp2.setVisible(flag);
	}
}
