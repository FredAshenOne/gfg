package deskApp;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Solicitud extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel contentPane, pnReferencias, pnSolicitud, pnPrincipal, pnAvales, pnRegistrados, pnPersonal, pnSolicitudReg,
			pnCantidad;
	MdTextField txtNombre, txtAp1, txtAp2, txtNacimiento, txtOcupacion, txtDomicilio, txtExterior, txtInterior,
			txtColonia, txtTiempo, txtCelular, txtNumFijo, txtSueldo, txtCiudad, txtCantidad, txtDireccion,
			txtExteriorEmpleo, txtInteriorEmpleo, txtTelefonoEmpleo, txtDescripcion, txtNombreRef1, txtNombreRef2,
			txtPaternoRef1, txtPaternoRef2, txtMaternoRef1, txtMaternoRef2, txtDireccionRef1, txtDireccionRef2,
			txtExteriorRef1, txtExteriorRef2, txtInteriorRef1, txtInteriorRef2, txtTelefonoRef1, txtTelefonoRef2,
			txtTiempoEmpleo, txtNombreAval, txtPaternoAval, txtMaternoAval, txtDireccionAval, txtExteriorAval,
			txtInteriorAval, txtTelefonoAval, txtOcupacionAval, txtColoniaAval, txtSearch, txtCantidadReg;
	private JComboBox cbEstadoCivil, cbTipoDom, cbTipo, cbTipoReg;
	int idUser, tipoUsuario = 0, idClienteActual, idSolicitud, idCliente;
	private JLabel lblDomicilio, lblExterior, lblInterior, lblNacimiento, lblSueldo, lblCelular, lblWarning, lblNombre,
			lblAp1, lblAp2, lblColonia, lblFijo, lblOcupacion, lblResidencia, lblCiudad, lblTipoDeCasa, lblEstadoCivil,
			lblCantidad, lblDireccion, lblTelefonoEmpleo, lblDescripcion, lblExteriorEmpleo, lblInteriorEmpleo,
			lblInfoEmpleo, lblNombreRef1, lblNombreRef2, lblPaternoRef1, lblPaternoRef2, lblMaternoRef1, lblMaternoRef2,
			lblDireccionRef1, lblDireccionRef2, lblExteriorRef1, lblExteriorRef2, lblInteriorRef1, lblInteriorRef2,
			lblTiempoEmpleo, lblTelefonoRef1, lblTelefonoRef2, lblNombreAval, lblPaternoAval, lblMaternoAval,
			lblDireccionAval, lblExteriorAval, lblInteriorAval, lblColoniaAval, lblOcupacionAval, lblTelefonoAval,
			lblCantidadReg;
	JButton btnBack, btnNext, btnInfoCliente, btnInfoJob, btnInfoAvales;
	MdButton btnNuevoCliente, btnClienteRegistrado, btnOmitirAval;
	MdHeader headerSolicitud, headerPrincipal, headerAval, headerRegistrados, headerSolReg;
	private Alert alOk = new Alert();
	JTable tbRegistrados;
	NuevoAval ca = new NuevoAval();
	private Style s = new Style();
	DatosEmpleo jd = new DatosEmpleo();
	private Conexion c = new Conexion();
	String nombre, ap1, ap2;
	ResultSet rs;
	Alert alSave = new Alert(), alNewAval = new Alert(), alSaveAval = new Alert(), alSave2 = new Alert();
	private JLabel lblHeader, lblSearch, lblSearchIcon;
	JPanel pnRegistrarAval, pnChoice, pnInfoEmpleo, pnReferencias2;
	private JLabel lblNombreReg1, lblRef1, lblRef2, lblPaternoReg1, lblMaternoReg1, lblDomicilioReg1, lblExteriorReg1,
			lblInteriorReg1, lblFijoReg1, lblNombreReg2, lblDomicilioReg2, lblPaternoReg2, lblExteriorReg2,
			lblMaternoReg2, lblInteriorReg2, lblFijoReg2;
	MdTextField nombreRef1, paternoRef1, maternoRef1, domicilioRef1, exteriorRef1, interiorRef1, fijoRef1, nombreRef2,
			domicilioRef2, paternoRef2, exteriorRef2, maternoRef2, interiorRef2, fijoRef2;

	public Solicitud() {
		setBounds(100, 100, 1135, 827);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnPrincipal = new JPanel();
		pnPrincipal.setBounds(0, 0, 1134, 800);
		contentPane.add(pnPrincipal);
		pnPrincipal.setLayout(null);
		s.mdPanel(pnPrincipal, Color.white);

		// Panel de seleccion

		pnChoice = new JPanel();
		pnChoice.setBounds(354, 300, 384, 303);
		pnPrincipal.add(pnChoice);
		pnChoice.setLayout(null);

		btnNuevoCliente = new MdButton(s.blue, Color.WHITE, "Cliente nuevo");
		btnNuevoCliente.setBounds(41, 55, 307, 39);
		pnChoice.add(btnNuevoCliente);
		s.mdPanel(pnChoice, Color.white);
		btnNuevoCliente.addActionListener(this);

		btnClienteRegistrado = new MdButton(s.blue, Color.WHITE, "Cliente Registrado");
		btnClienteRegistrado.setBounds(41, 158, 307, 39);
		pnChoice.add(btnClienteRegistrado);
		s.mdPanel(pnChoice, Color.white);
		btnClienteRegistrado.addActionListener(this);

		// panel de titulo para seleccion

		headerPrincipal = new MdHeader(s.blue, Color.white);
		pnPrincipal.add(headerPrincipal);
		headerPrincipal.lblTitle.setText("Solicitud de credito");
		headerPrincipal.btnNext.setVisible(false);
		headerPrincipal.btnBack.addActionListener(this);

		// Panel de formulario

		pnSolicitud = new JPanel();
		s.mdPanel(pnSolicitud, Color.white);
		pnSolicitud.setBounds(0, 0, 1134, 800);
		contentPane.add(pnSolicitud);
		pnSolicitud.setLayout(null);

		pnPersonal = new JPanel();
		pnPersonal.setLayout(null);
		pnPersonal.setBounds(0, 150, 513, 650);
		pnSolicitud.add(pnPersonal);
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
		lblExterior.setBounds(87, 375, 95, 14);
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
		lblTipoDeCasa = new JLabel("Tipo de Casa");
		lblTipoDeCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeCasa.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTipoDeCasa.setBounds(120, 321, 115, 14);
		pnPersonal.add(lblTipoDeCasa);

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

		// panel de encabeado para formulario

		headerSolicitud = new MdHeader(s.blue, Color.WHITE);
		pnSolicitud.add(headerSolicitud);
		headerSolicitud.lblTitle.setText("Nueva Solicitud de Credito");
		headerSolicitud.lblWarning.setVisible(false);
		headerSolicitud.btnBack.addActionListener(this);
		headerSolicitud.btnNext.addActionListener(this);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 54, 240, 14);
		headerSolicitud.add(lblNombre);
		txtNombre = new MdTextField(Color.WHITE, "Nombre", s.blue, Color.white, lblNombre);
		txtNombre.setBounds(10, 69, 240, 35);
		headerSolicitud.add(txtNombre);

		lblAp1 = new JLabel("Apellido Paterno");
		lblAp1.setBounds(260, 54, 240, 14);
		headerSolicitud.add(lblAp1);
		txtAp1 = new MdTextField(Color.white, "Apellido Paterno", s.blue, Color.WHITE, lblAp1);
		txtAp1.setBounds(260, 69, 240, 35);
		headerSolicitud.add(txtAp1);

		lblAp2 = new JLabel();
		lblAp2.setBounds(523, 55, 240, 14);
		headerSolicitud.add(lblAp2);
		txtAp2 = new MdTextField(Color.WHITE, "Apellido_Materno", s.blue, Color.WHITE, lblAp2);
		txtAp2.setBounds(523, 69, 240, 35);
		headerSolicitud.add(txtAp2);

		lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 115, 1104, 32);
		headerSolicitud.add(lblWarning);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));

		// Panel de informacion de empleo

		pnInfoEmpleo = new JPanel();
		pnInfoEmpleo.setBounds(515, 150, 609, 217);
		pnSolicitud.add(pnInfoEmpleo);
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
		txtTiempoEmpleo = new MdTextField(Color.BLACK, "Descripcion", Color.WHITE, s.blue, lblTiempoEmpleo);
		txtTiempoEmpleo.setBounds(402, 168, 181, 32);
		pnInfoEmpleo.add(txtTiempoEmpleo);

		lblCantidad = new JLabel("Tipo de Casa");
		lblCantidad.setBounds(71, 573, 170, 14);
		pnPersonal.add(lblCantidad);
		txtCantidad = new MdTextField(Color.BLACK, "Cantidad", Color.WHITE, s.blue, lblCantidad);
		txtCantidad.setBounds(71, 588, 170, 34);
		pnPersonal.add(txtCantidad);
		pnSolicitud.setVisible(true);
		JLabel lblTipoCredito = new JLabel("Tipo de Credito");
		lblTipoCredito.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTipoCredito.setBounds(246, 573, 184, 14);
		pnPersonal.add(lblTipoCredito);

		cbTipo = new JComboBox();
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cbTipo.setModel(new DefaultComboBoxModel(new String[] { "", "13 Semanas", "14 Semanas", "Interes Mensual" }));
		cbTipo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		s.mdCombo(cbTipo, Color.WHITE, s.blue);
		s.mdCombo(cbTipo, Color.WHITE, s.blue);
		cbTipo.setBounds(246, 588, 185, 35);
		pnPersonal.add(cbTipo);

		// Panel de informacion de referencias

		pnReferencias = new JPanel();
		pnReferencias.setBounds(515, 368, 609, 432);
		pnSolicitud.add(pnReferencias);
		pnReferencias.setLayout(null);
		s.mdPanel(pnReferencias, Color.white);
		pnReferencias.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, s.blue));

		lblNombreRef1 = new JLabel("");
		lblNombreRef1.setBounds(10, 53, 194, 14);
		pnReferencias.add(lblNombreRef1);
		txtNombreRef1 = new MdTextField(Color.BLACK, "Nombre(s)", Color.WHITE, s.blue, lblNombreRef1);

		txtNombreRef1.setBounds(10, 68, 194, 31);
		pnReferencias.add(txtNombreRef1);

		lblPaternoRef1 = new JLabel("");
		lblPaternoRef1.setBounds(227, 53, 181, 14);
		pnReferencias.add(lblPaternoRef1);
		txtPaternoRef1 = new MdTextField(Color.BLACK, "A. Paterno", Color.WHITE, s.blue, lblPaternoRef1);
		txtPaternoRef1.setBounds(227, 68, 181, 31);
		pnReferencias.add(txtPaternoRef1);

		lblMaternoRef1 = new JLabel("");
		lblMaternoRef1.setBounds(418, 53, 181, 14);
		pnReferencias.add(lblMaternoRef1);
		txtMaternoRef1 = new MdTextField(Color.BLACK, "A. Materno", Color.WHITE, s.blue, lblMaternoRef1);
		txtMaternoRef1.setBounds(418, 68, 181, 31);
		pnReferencias.add(txtMaternoRef1);

		lblDireccionRef1 = new JLabel("");
		lblDireccionRef1.setBounds(10, 129, 222, 14);
		pnReferencias.add(lblDireccionRef1);
		txtDireccionRef1 = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, s.blue, lblDireccionRef1);
		txtDireccionRef1.setBounds(10, 144, 222, 32);
		pnReferencias.add(txtDireccionRef1);

		lblExteriorRef1 = new JLabel("");
		lblExteriorRef1.setBounds(242, 129, 95, 14);
		pnReferencias.add(lblExteriorRef1);
		txtExteriorRef1 = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, s.blue, lblExteriorRef1);
		txtExteriorRef1.setBounds(242, 144, 95, 32);
		pnReferencias.add(txtExteriorRef1);

		lblInteriorRef1 = new JLabel("");
		lblInteriorRef1.setBounds(347, 129, 95, 14);
		pnReferencias.add(lblInteriorRef1);
		txtInteriorRef1 = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, s.blue, lblInteriorRef1);
		txtInteriorRef1.setBounds(347, 144, 95, 32);
		pnReferencias.add(txtInteriorRef1);

		lblTelefonoRef1 = new JLabel("");
		lblTelefonoRef1.setBounds(452, 129, 147, 14);
		pnReferencias.add(lblTelefonoRef1);
		txtTelefonoRef1 = new MdTextField(Color.BLACK, "Num Fijo", Color.WHITE, s.blue, lblTelefonoRef1);
		txtTelefonoRef1.setBounds(452, 144, 147, 32);
		pnReferencias.add(txtTelefonoRef1);

		lblNombreRef2 = new JLabel("");
		lblNombreRef2.setBounds(10, 262, 194, 14);
		pnReferencias.add(lblNombreRef2);
		txtNombreRef2 = new MdTextField(Color.BLACK, "Nombre(s)", Color.WHITE, s.blue, lblNombreRef2);
		txtNombreRef2.setBounds(10, 275, 194, 31);
		pnReferencias.add(txtNombreRef2);

		lblDireccionRef2 = new JLabel("");
		lblDireccionRef2.setBounds(10, 336, 222, 14);
		pnReferencias.add(lblDireccionRef2);
		txtDireccionRef2 = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, s.blue, lblDireccionRef2);
		txtDireccionRef2.setBounds(10, 351, 222, 32);
		pnReferencias.add(txtDireccionRef2);

		lblPaternoRef2 = new JLabel("");
		lblPaternoRef2.setBounds(227, 262, 181, 14);
		pnReferencias.add(lblPaternoRef2);
		txtPaternoRef2 = new MdTextField(Color.BLACK, "A. Paterno", Color.WHITE, s.blue, lblPaternoRef2);
		txtPaternoRef2.setBounds(227, 275, 181, 31);
		pnReferencias.add(txtPaternoRef2);

		lblExteriorRef2 = new JLabel("");
		lblExteriorRef2.setBounds(242, 336, 95, 14);
		pnReferencias.add(lblExteriorRef2);
		txtExteriorRef2 = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, s.blue, lblExteriorRef2);
		txtExteriorRef2.setBounds(242, 351, 95, 32);
		pnReferencias.add(txtExteriorRef2);

		lblMaternoRef2 = new JLabel("");
		lblMaternoRef2.setBounds(418, 262, 181, 14);
		pnReferencias.add(lblMaternoRef2);
		txtMaternoRef2 = new MdTextField(Color.BLACK, "A. Materno", Color.WHITE, s.blue, lblMaternoRef2);
		txtMaternoRef2.setBounds(418, 275, 181, 31);
		pnReferencias.add(txtMaternoRef2);

		lblInteriorRef2 = new JLabel("");
		lblInteriorRef2.setBounds(347, 336, 95, 14);
		pnReferencias.add(lblInteriorRef2);
		txtInteriorRef2 = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, s.blue, lblInteriorRef2);
		txtInteriorRef2.setBounds(347, 351, 95, 32);
		pnReferencias.add(txtInteriorRef2);

		lblTelefonoRef2 = new JLabel("");
		lblTelefonoRef2.setBounds(452, 336, 147, 14);
		pnReferencias.add(lblTelefonoRef2);
		txtTelefonoRef2 = new MdTextField(Color.BLACK, "Num Fijo", Color.WHITE, s.blue, lblTelefonoRef2);
		txtTelefonoRef2.setBounds(452, 351, 147, 32);
		pnReferencias.add(txtTelefonoRef2);

		JLabel lblReferencia1 = new JLabel("Referencia 1");
		lblReferencia1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblReferencia1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReferencia1.setBounds(10, 11, 589, 31);
		pnReferencias.add(lblReferencia1);

		JLabel lblReferencia = new JLabel("Referencia 2");
		lblReferencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblReferencia.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblReferencia.setBounds(10, 202, 589, 31);
		pnReferencias.add(lblReferencia);

		// Panel nuevos Avales
		pnAvales = new JPanel();
		pnAvales.setBounds(0, 0, 1134, 800);
		contentPane.add(pnAvales);
		pnAvales.setLayout(null);
		s.mdPanel(pnAvales, Color.WHITE);
		// Panel encabezado para nuevos avales
		headerAval = new MdHeader(s.blue, Color.WHITE);
		pnAvales.add(headerAval);
		headerAval.lblTitle.setText("Registrar aval");
		headerAval.btnBack.setVisible(false);
		headerAval.btnNext.addActionListener(this);

		// panel de formulario de avales
		pnRegistrarAval = new JPanel();
		pnRegistrarAval.setBounds(188, 247, 737, 399);
		pnAvales.add(pnRegistrarAval);
		pnRegistrarAval.setLayout(null);
		s.mdPanel(pnRegistrarAval, Color.WHITE);

		lblNombreAval = new JLabel();
		lblNombreAval.setBounds(50, 35, 200, 15);
		pnRegistrarAval.add(lblNombreAval);
		txtNombreAval = new MdTextField(Color.BLACK, "Nombre(s)", Color.white, s.blue, lblNombreAval);
		txtNombreAval.setBounds(50, 50, 200, 35);
		pnRegistrarAval.add(txtNombreAval);

		lblPaternoAval = new JLabel();
		lblPaternoAval.setBounds(268, 35, 200, 15);
		pnRegistrarAval.add(lblPaternoAval);
		txtPaternoAval = new MdTextField(Color.BLACK, "A. Paterno", Color.WHITE, s.blue, lblPaternoAval);
		txtPaternoAval.setBounds(268, 50, 200, 35);
		pnRegistrarAval.add(txtPaternoAval);

		lblMaternoAval = new JLabel();
		lblMaternoAval.setBounds(478, 35, 200, 15);
		pnRegistrarAval.add(lblMaternoAval);
		txtMaternoAval = new MdTextField(Color.BLACK, "A.Materno", Color.WHITE, s.blue, lblMaternoAval);
		txtMaternoAval.setBounds(478, 50, 200, 35);
		pnRegistrarAval.add(txtMaternoAval);

		lblDireccionAval = new JLabel();
		lblDireccionAval.setBounds(50, 139, 368, 15);
		pnRegistrarAval.add(lblDireccionAval);
		txtDireccionAval = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, s.blue, lblDireccionAval);
		txtDireccionAval.setBounds(50, 154, 368, 35);
		pnRegistrarAval.add(txtDireccionAval);

		lblExteriorAval = new JLabel();
		lblExteriorAval.setBounds(428, 139, 120, 15);
		pnRegistrarAval.add(lblExteriorAval);
		txtExteriorAval = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, s.blue, lblExteriorAval);
		txtExteriorAval.setBounds(428, 154, 120, 35);
		pnRegistrarAval.add(txtExteriorAval);

		lblInteriorAval = new JLabel();
		lblInteriorAval.setBounds(558, 139, 120, 15);
		pnRegistrarAval.add(lblInteriorAval);
		txtInteriorAval = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, s.blue, lblInteriorAval);
		txtInteriorAval.setBounds(558, 154, 120, 35);
		pnRegistrarAval.add(txtInteriorAval);

		lblColoniaAval = new JLabel();
		lblColoniaAval.setBounds(50, 256, 200, 15);
		pnRegistrarAval.add(lblColoniaAval);
		txtColoniaAval = new MdTextField(Color.BLACK, "Colonia", Color.WHITE, s.blue, lblColoniaAval);
		txtColoniaAval.setBounds(50, 271, 200, 35);
		pnRegistrarAval.add(txtColoniaAval);

		lblTelefonoAval = new JLabel();
		lblTelefonoAval.setBounds(260, 256, 200, 15);
		pnRegistrarAval.add(lblTelefonoAval);
		txtTelefonoAval = new MdTextField(Color.BLACK, "Telefono", Color.WHITE, s.blue, lblTelefonoAval);
		txtTelefonoAval.setBounds(260, 271, 200, 35);
		pnRegistrarAval.add(txtTelefonoAval);

		lblOcupacionAval = new JLabel();
		lblOcupacionAval.setBounds(470, 256, 206, 15);
		pnRegistrarAval.add(lblOcupacionAval);
		txtOcupacionAval = new MdTextField(Color.BLACK, "Ocupacion", Color.WHITE, s.blue, lblOcupacionAval);
		txtOcupacionAval.setBounds(470, 271, 206, 35);
		pnRegistrarAval.add(txtOcupacionAval);

		btnOmitirAval = new MdButton(Color.WHITE, s.blue, "Omitir");
		btnOmitirAval.setBounds(478, 338, 200, 35);
		pnRegistrarAval.add(btnOmitirAval);
		// alert para confirmar aval
		alSaveAval.lblMessage.setText("Desea continuar y guardar ?");
		alSaveAval.lblAlertIcon.setIcon(new ImageIcon("views/alert.png"));
		alSaveAval.btnOk.addActionListener(this);
		alSaveAval.btnCancel.addActionListener(this);
		// alert para confirmar solicitud
		alSave.lblMessage.setText("Desea continuar y guardar ?");
		alSave.lblAlertIcon.setIcon(new ImageIcon("views/alert.png"));
		alSave.btnOk.addActionListener(this);
		alSave.btnCancel.addActionListener(this);
		// alert de confirmacion
		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Cliente registrado con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);

		alNewAval.lblMessage.setText("Desea registrar otro aval? ");
		alNewAval.btnOk.setText("Si");
		alNewAval.btnCancel.setText("No");
		alNewAval.lblAlertIcon.setIcon(new ImageIcon("views/ask.png"));
		alNewAval.btnCancel.addActionListener(this);
		alNewAval.btnOk.addActionListener(this);

		alSave2.lblMessage.setText("Desea continuar y guardar ?");
		alSave2.lblAlertIcon.setIcon(new ImageIcon("views/alert.png"));
		alSave2.btnOk.addActionListener(this);
		alSave2.btnCancel.addActionListener(this);
		
		// Panel para clientes registrados

		pnRegistrados = new JPanel();
		pnRegistrados.setBounds(0, 0, 1134, 800);
		contentPane.add(pnRegistrados);
		pnRegistrados.setLayout(null);
		s.mdPanel(pnRegistrados, Color.white);

		headerRegistrados = new MdHeader(s.blue, Color.WHITE);
		pnRegistrados.add(headerRegistrados);
		headerRegistrados.lblTitle.setText("Clientes Registrados");
		headerRegistrados.btnBack.addActionListener(this);
		headerRegistrados.btnNext.addActionListener(this);

		JScrollPane sc = new JScrollPane();
		sc.setBounds(130, 242, 822, 490);
		pnRegistrados.add(sc);
		sc.getViewport().setBackground(Color.WHITE);
		
		tbRegistrados = new JTable() {
			public boolean isCellEditable(int row, int column) {                
            return false;               
			};
		};
		tbRegistrados.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nombre", "A. Paterno", "A. Materno", "Direccion", "No. Exterior", "Teléfono" }));
		s.mdTable(tbRegistrados, Color.WHITE, Color.WHITE);
		sc.setViewportView(tbRegistrados);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tbRegistrados.setDefaultRenderer(String.class, centerRenderer);
		headerRegistrados.btnNext.setEnabled(false);
		
		ListSelectionModel listSelectionModel = tbRegistrados.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
		        public void valueChanged(ListSelectionEvent e) { 
		            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		            headerRegistrados.btnNext.setEnabled(!lsm.isSelectionEmpty());
		        }
		});

		lblSearch = new JLabel();
		lblSearch.setBounds(175, 162, 822, 15);
		pnRegistrados.add(lblSearch);
		txtSearch = new MdTextField(Color.black, "Busqueda por Nombre", Color.white, s.blue, lblSearch);
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				llenarTbRegistrados(txtSearch.getText(), headerRegistrados.lblWarning);
			}
		});
		txtSearch.setBounds(175, 188, 777, 43);
		pnRegistrados.add(txtSearch);
		txtSearch.setHorizontalAlignment(SwingConstants.LEADING);
		txtSearch.lbl.setHorizontalAlignment(SwingConstants.LEADING);
		txtSearch.tp.setHorizontalAlignment(SwingConstants.LEADING);

		lblSearchIcon = new JLabel("");
		lblSearchIcon.setBounds(131, 188, 46, 43);
		pnRegistrados.add(lblSearchIcon);
		lblSearchIcon.setIcon(new ImageIcon("views/searchBlue.png"));
		lblSearchIcon.setOpaque(true);
		lblSearchIcon.setBackground(Color.WHITE);
		lblSearchIcon.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, s.blue));

		// panel para solicitud de clientes registrados
		pnSolicitudReg = new JPanel();
		s.mdPanel(pnSolicitudReg, Color.white);
		pnSolicitudReg.setBounds(0, 0, 1134, 800);
		contentPane.add(pnSolicitudReg);
		pnSolicitudReg.setLayout(null);

		headerSolReg = new MdHeader(s.blue, Color.white);
		pnSolicitudReg.add(headerSolReg);
		headerSolReg.lblTitle.setText("Solicitud de usuario registrado");
		headerSolReg.btnBack.addActionListener(this);
		headerSolReg.btnNext.addActionListener(this);

		// Panel para referencias de clientes registrados

		pnReferencias2 = new JPanel();
		pnReferencias2.setLayout(null);
		pnReferencias2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, s.blue));
		pnReferencias2.setBounds(448, 288, 609, 432);
		pnSolicitudReg.add(pnReferencias2);
		lblNombreReg1 = new JLabel("");
		lblNombreReg1.setBounds(10, 53, 194, 14);
		pnReferencias2.add(lblNombreReg1);
		s.mdPanel(pnReferencias2, Color.white);

		nombreRef1 = new MdTextField(Color.BLACK, "Nombre(s)", Color.WHITE, new Color(3, 155, 229), lblNombreReg1);
		nombreRef1.setBounds(10, 68, 194, 31);
		pnReferencias2.add(nombreRef1);

		lblPaternoReg1 = new JLabel("");
		lblPaternoReg1.setBounds(227, 53, 181, 14);
		pnReferencias2.add(lblPaternoReg1);

		paternoRef1 = new MdTextField(Color.BLACK, "A. Paterno", Color.WHITE, new Color(3, 155, 229), lblPaternoReg1);
		paternoRef1.setBounds(227, 68, 181, 31);
		pnReferencias2.add(paternoRef1);

		lblMaternoReg1 = new JLabel("");
		lblMaternoReg1.setBounds(418, 53, 181, 14);
		pnReferencias2.add(lblMaternoReg1);

		maternoRef1 = new MdTextField(Color.BLACK, "A. Materno", Color.WHITE, new Color(3, 155, 229), lblMaternoReg1);
		maternoRef1.setBounds(418, 68, 181, 31);
		pnReferencias2.add(maternoRef1);

		lblDomicilioReg1 = new JLabel("");
		lblDomicilioReg1.setBounds(10, 129, 222, 14);
		pnReferencias2.add(lblDomicilioReg1);

		domicilioRef1 = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, new Color(3, 155, 229),
				lblDomicilioReg1);
		domicilioRef1.setBounds(10, 144, 222, 32);
		pnReferencias2.add(domicilioRef1);

		lblExteriorReg1 = new JLabel("");
		lblExteriorReg1.setBounds(242, 129, 95, 14);
		pnReferencias2.add(lblExteriorReg1);

		exteriorRef1 = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, new Color(3, 155, 229),
				lblExteriorReg1);
		exteriorRef1.setBounds(242, 144, 95, 32);
		pnReferencias2.add(exteriorRef1);

		lblInteriorReg1 = new JLabel("");
		lblInteriorReg1.setBounds(347, 129, 95, 14);
		pnReferencias2.add(lblInteriorReg1);

		interiorRef1 = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, new Color(3, 155, 229),
				lblInteriorReg1);
		interiorRef1.setBounds(347, 144, 95, 32);
		pnReferencias2.add(interiorRef1);

		lblFijoReg1 = new JLabel("");
		lblFijoReg1.setBounds(452, 129, 147, 14);
		pnReferencias2.add(lblFijoReg1);

		fijoRef1 = new MdTextField(Color.BLACK, "Num Fijo", Color.WHITE, new Color(3, 155, 229), lblFijoReg1);
		fijoRef1.setBounds(452, 144, 147, 32);
		pnReferencias2.add(fijoRef1);

		lblNombreReg2 = new JLabel("");
		lblNombreReg2.setBounds(10, 262, 194, 14);
		pnReferencias2.add(lblNombreReg2);

		nombreRef2 = new MdTextField(Color.BLACK, "Nombre(s)", Color.WHITE, new Color(3, 155, 229), lblNombreReg2);
		nombreRef2.setBounds(10, 275, 194, 31);
		pnReferencias2.add(nombreRef2);

		lblDomicilioReg2 = new JLabel("");
		lblDomicilioReg2.setBounds(10, 336, 222, 14);
		pnReferencias2.add(lblDomicilioReg2);
		domicilioRef2 = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, new Color(3, 155, 229),
				lblDomicilioReg2);
		domicilioRef2.setBounds(10, 351, 222, 32);
		pnReferencias2.add(domicilioRef2);

		lblPaternoReg2 = new JLabel("");
		lblPaternoReg2.setBounds(227, 262, 181, 14);
		pnReferencias2.add(lblPaternoReg2);

		paternoRef2 = new MdTextField(Color.BLACK, "A. Paterno", Color.WHITE, new Color(3, 155, 229), lblPaternoReg2);
		paternoRef2.setBounds(227, 275, 181, 31);
		pnReferencias2.add(paternoRef2);

		lblExteriorReg2 = new JLabel("");
		lblExteriorReg2.setBounds(242, 336, 95, 14);
		pnReferencias2.add(lblExteriorReg2);

		exteriorRef2 = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, new Color(3, 155, 229),
				lblExteriorReg2);
		exteriorRef2.setBounds(242, 351, 95, 32);
		pnReferencias2.add(exteriorRef2);

		lblMaternoReg2 = new JLabel("");
		lblMaternoReg2.setBounds(418, 262, 181, 14);
		pnReferencias2.add(lblMaternoReg2);

		maternoRef2 = new MdTextField(Color.BLACK, "A. Materno", Color.WHITE, new Color(3, 155, 229), lblMaternoReg2);
		maternoRef2.setBounds(418, 275, 181, 31);
		pnReferencias2.add(maternoRef2);

		lblInteriorReg2 = new JLabel("");
		lblInteriorReg2.setBounds(347, 336, 95, 14);
		pnReferencias2.add(lblInteriorReg2);

		interiorRef2 = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, new Color(3, 155, 229),
				lblInteriorReg2);
		interiorRef2.setBounds(347, 351, 95, 32);
		pnReferencias2.add(interiorRef2);

		lblFijoReg2 = new JLabel("");
		lblFijoReg2.setBounds(452, 336, 147, 14);
		pnReferencias2.add(lblFijoReg2);

		fijoRef2 = new MdTextField(Color.BLACK, "Num Fijo", Color.WHITE, new Color(3, 155, 229), lblFijoReg2);
		fijoRef2.setBounds(452, 351, 147, 32);
		pnReferencias2.add(fijoRef2);

		lblRef1 = new JLabel("Referencia 1");
		lblRef1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRef1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblRef1.setBounds(10, 11, 589, 31);
		pnReferencias2.add(lblRef1);

		lblRef2 = new JLabel("Referencia 2");
		lblRef2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRef2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblRef2.setBounds(10, 202, 589, 31);
		pnReferencias2.add(lblRef2);

		// panel para cantidad de clientes registrados
		pnCantidad = new JPanel();
		pnCantidad.setBounds(119, 294, 246, 256);
		pnSolicitudReg.add(pnCantidad);
		pnCantidad.setLayout(null);
		s.mdPanel(pnCantidad, Color.white);

		lblCantidadReg = new JLabel("Tipo de Casa");
		lblCantidadReg.setBounds(96, 58, 54, 20);
		pnCantidad.add(lblCantidadReg);
		txtCantidadReg = new MdTextField(Color.BLACK, "Cantidad", Color.WHITE, s.blue, lblCantidadReg);
		txtCantidadReg.setBounds(64, 89, 120, 22);
		pnCantidad.add(txtCantidadReg);
		JLabel lblTipoCreditoReg = new JLabel("Tipo de Credito");
		lblTipoCreditoReg.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoCreditoReg.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTipoCreditoReg.setBounds(76, 122, 93, 20);
		pnCantidad.add(lblTipoCreditoReg);

		cbTipoReg = new JComboBox();
		cbTipoReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cbTipoReg
				.setModel(new DefaultComboBoxModel(new String[] { "", "13 Semanas", "14 Semanas", "Interes Mensual" }));
		cbTipoReg.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		s.mdCombo(cbTipoReg, Color.WHITE, s.blue);
		s.mdCombo(cbTipoReg, Color.WHITE, s.blue);
		cbTipoReg.setBounds(61, 153, 123, 26);
		pnCantidad.add(cbTipoReg);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevoCliente) {
			tipoUsuario = 0;
			pnSolicitud.setVisible(true);
			pnPrincipal.setVisible(false);
			limpiarCamposSolicitud();
		} else if (e.getSource() == headerSolicitud.btnNext) {

			if (camposPersonalesCompletos() && camposEmpleoCompletos() && camposReferenciasCompletos()) {
				if (!clienteExistente(txtNombre.getText(), txtAp1.getText(), txtAp2.getText())) {
					alSave.setVisible(true);
				} else {
					lblWarning.setText("Cliente ya registrado");
				}
			}
		} else if (e.getSource() == headerSolicitud.btnBack) {
			pnPrincipal.setVisible(true);
			pnSolicitud.setVisible(false);
		} else if (e.getSource() == alSave.btnOk) {
			idClienteActual = getCurrentIdFrom("clientes_personal");
			addClient();
			addSolicitud(idClienteActual);
			addInfoEmpleo(idClienteActual);
			addReferencia1(idClienteActual, idSolicitud);
			addReferencia2(idClienteActual, idSolicitud);
			alSave.setVisible(false);
			alOk.setVisible(true);
			pnSolicitud.setVisible(false);
			pnAvales.setVisible(true);
			limpiarCamposSolicitud();
		} else if (e.getSource() == alSave.btnCancel) {
			this.setVisible(true);
			alSave.setVisible(false);
		} else if (e.getSource() == alOk.btnOk) {
			alOk.setVisible(false);
		} else if (e.getSource() == btnClienteRegistrado) {
			tipoUsuario = 1;
			pnRegistrados.setVisible(true);
			pnPrincipal.setVisible(false);
		} else if (e.getSource() == headerAval.btnNext) {
			if (camposAvalLlenos()) {
				alSaveAval.setVisible(true);
			} else {
				headerAval.lblWarning.setText("Algunos campos estan Vacíos");
			}
		} else if (e.getSource() == alSaveAval.btnOk) {
			addAval(idSolicitud);
			alNewAval.setVisible(true);
			limpiarCamposAval();
			alSaveAval.setVisible(false);
			;
		} else if (e.getSource() == alSaveAval.btnCancel) {
			alSave.setVisible(false);
		} else if (e.getSource() == alNewAval.btnCancel) {
			pnPrincipal.setVisible(true);
			pnAvales.setVisible(false);
			alNewAval.setVisible(false);
		} else if (e.getSource() == alNewAval.btnOk) {
			alNewAval.setVisible(false);
		} else if (e.getSource() == headerRegistrados.btnBack) {
			pnPrincipal.setVisible(true);
			pnRegistrados.setVisible(false);
		} else if (e.getSource() == headerRegistrados.btnNext) {
			pnSolicitudReg.setVisible(true);
			pnRegistrados.setVisible(false);
			int index = tbRegistrados.getSelectedRow();
			idCliente = Integer.parseInt(tbRegistrados.getValueAt(index, 0).toString());
			limpiarReferenciasReg();
		} else if (e.getSource() == headerSolReg.btnBack) {
			pnRegistrados.setVisible(true);
			pnSolicitudReg.setVisible(false);
		} else if (e.getSource() == headerSolReg.btnNext) {
			if (camposRefRegCompletos()) {
				alSave2.setVisible(true);

			} else {
				headerSolReg.lblWarning.setText("Algunos campos estan vacíos");
			}
		} else if (e.getSource() == alSave2.btnOk) {
			int solicitud = getCurrentIdFrom("solicitudes_personales");
			addSolicitudReg(idCliente);
			addReferenciasReg(solicitud, idCliente);
			alSave2.setVisible(false);
			alOk.setVisible(true);
			pnSolicitudReg.setVisible(false);
			pnAvales.setVisible(true);
			
		}

	}

	// confirma si los campos de informacion 'personal estan llenos

	public boolean camposPersonalesCompletos() {
		if (txtNombre.getText().length() > 0 && txtAp1.getText().length() > 0 && txtAp2.getText().length() > 0
				&& cbEstadoCivil.getSelectedIndex() > 0 && cbTipoDom.getSelectedIndex() > 0
				&& txtNacimiento.getText().length() > 0 && txtOcupacion.getText().length() > 0
				&& txtDomicilio.getText().length() > 0 && txtExterior.getText().length() > 0
				&& txtColonia.getText().length() > 0 && txtTiempo.getText().length() > 0
				&& txtCelular.getText().length() > 0 && txtNumFijo.getText().length() > 0
				&& txtSueldo.getText().length() > 0 && txtCantidad.getText().length() > 0) {
			if (s.checarFecha(txtNacimiento.getText())) {
				if (txtTiempo.getText().length() > 2 || txtCelular.getText().length() > 12
						|| txtNumFijo.getText().length() > 12) {
					lblWarning.setText("Algunos campos exceden el limite de caracteres");
					lblWarning.setForeground(Color.RED);
					return false;
				} else {
					return true;
				}

			} else {
				lblWarning.setText("La fecha introducida no es correcta");
				lblWarning.setForeground(Color.RED);
				return false;
			}
		} else {
			lblWarning.setText("Algunos campos personales estan Vacíos");
			lblWarning.setForeground(Color.RED);
			return false;
		}
	}

	// confirma si los campos de informacion de emple oestan llenos

	public Boolean camposEmpleoCompletos() {
		if (txtDireccion.getText().length() > 0 && txtExteriorEmpleo.getText().length() > 0
				&& txtTelefonoEmpleo.getText().length() > 0 && txtDescripcion.getText().length() > 0) {
			return true;
		} else {
			lblWarning.setText("Algunos campos de empleo estan incompletos");
			return false;
		}
	}

	// confirma si todos los campos de referencia estan llenos

	public Boolean camposReferenciasCompletos() {
		if (txtNombreRef1.getText().length() > 0 && txtPaternoRef1.getText().length() > 0
				&& txtMaternoRef1.getText().length() > 0 && txtExteriorRef1.getText().length() > 0
				&& txtTelefonoRef1.getText().length() > 0 && txtDireccionRef1.getText().length() > 0
				&& txtNombreRef2.getText().length() > 0 && txtPaternoRef2.getText().length() > 0
				&& txtMaternoRef2.getText().length() > 0 && txtDireccionRef2.getText().length() > 0
				&& txtExteriorRef2.getText().length() > 0 && txtTelefonoRef2.getText().length() > 0) {
			return true;
		} else {
			lblWarning.setText("Algunos campos de Referencias estan incompletos");
			return false;
		}
	}

	// buscar si ya existe ese cliente

	public Boolean clienteExistente(String nombre, String ap1, String ap2) {
		ResultSet rs;
		try {
			rs = c.query("SELECT * FROM clientes_personal WHERE Nombre = '" + nombre + "' AND Paterno = '" + ap1
					+ "' AND Materno = '" + ap2 + "';");

			return rs.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	// obtener el siguiente id que se ingresara en la tabla

	public int getCurrentIdFrom(String table) {
		ResultSet rs;
		try {
			rs = c.query(
					"SELECT AUTO_INCREMENT id FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'gfg' AND TABLE_NAME = '"
							+ table + "';");
			if (rs.next()) {
				return rs.getInt("id");
			} else {
				return 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	// agrega la infomacion personal del cliente a la tabla clientes_personal

	public void addClient() {

		try {
			c.update("INSERT INTO clientes_personal(Nombre,Paterno,Materno,Telefono_Cel,"
					+ "Telefono_Fijo,Direccion,Num_Exterior,Num_Interior,Colonia,Fecha_Nacimiento,Tiempo_Residencia,"
					+ "Tipo_Casa,Estado_Civil,Ocupacion,Sueldo_Mensual) VALUES(" + "'" + txtNombre.getText() + "','"
					+ txtAp1.getText() + "','" + txtAp2.getText() + "','" + txtCelular.getText() + "','"
					+ txtNumFijo.getText() + "','" + txtDomicilio.getText() + "','" + txtExterior.getText() + "','"
					+ txtInterior.getText() + "','" + txtColonia.getText() + "','" + txtNacimiento.getText() + "','"
					+ txtTiempo.getText() + "'," + cbTipoDom.getSelectedIndex() + "," + cbEstadoCivil.getSelectedIndex()
					+ ",'" + txtOcupacion.getText() + "'," + Integer.parseInt(txtSueldo.getText()) + ");");

		} catch (NumberFormatException nfe) {
			lblWarning.setText("Algunos campos deben ser numericos");
			lblWarning.setForeground(Color.RED);
		}
	}

	// agrega la informacion de empleo de cliente a la tabla clientes_empleo

	public void addInfoEmpleo(int idCliente) {
		try {
			c.update(
					"INSERT INTO clientes_empleo (id_Cliente,Domicilio,Num_Exterior,Num_Interior,Telefono,Tiempo,Descripcion) VALUES ("
							+ idCliente + ",'" + txtDireccion.getText() + "','" + txtExteriorEmpleo.getText() + "','"
							+ txtInteriorEmpleo.getText() + "','" + txtTelefonoEmpleo.getText() + "','"
							+ Integer.parseInt(txtTiempoEmpleo.getText()) + "','" + txtDescripcion.getText() + "');  ");
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	// agrega la solicitud con los datos a la tabla solicitudes_personal

	public void addSolicitud(int idCliente) {
		try {
			c.update("INSERT INTO solicitudes_personales(id_Cliente,Cantidad,Tipo_Credito,status) VALUES (" + idCliente
					+ "," + Integer.parseInt(txtCantidad.getText()) + "," + cbTipo.getSelectedIndex() + "," + 0 + ");");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// agrega la informacion del aval a la tabla avales

	public void addAval(int idSolicitud) {
		try {
			c.update(
					"INSERT INTO avales (id_Solicitud,Nombre,Apellido_Paterno,Apellido_Materno,Direccion,Num_Exterior,Num_interior,Colonia,Telefono,Ocupacion) VALUES ("
							+ idSolicitud + ",'" + txtNombreAval.getText() + "','" + txtPaternoAval.getText() + "','"
							+ txtMaternoAval.getText() + "','" + txtDireccionAval.getText() + "','"
							+ txtExteriorAval.getText() + "','" + txtInteriorAval.getText() + "','"
							+ txtColoniaAval.getText() + "','" + txtTelefonoAval.getText() + "','"
							+ txtOcupacionAval.getText() + "')");
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	// toma los datos de los campos de la primera referencia y los ingresa a la base
	// a la

	public void addReferencia1(int idCliente, int idSolicitud) {
		try {
			c.update(
					"INSERT INTO referencias(id_Solicitud,id_Cliente,nombre,paterno,Materno,Domicilio,Exterior,Interior,Telefono) VALUES ("
							+ idSolicitud + "," + idCliente + ",'" + txtNombreRef1.getText() + "','"
							+ txtPaternoRef1.getText() + "','" + txtMaternoRef1.getText() + "','"
							+ txtDireccionRef1.getText() + "','" + txtExteriorRef1.getText() + "','"
							+ txtInteriorRef1.getText() + "','" + txtTelefonoRef1.getText() + "');");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// toma los datos de la segunda referencia y los agrega a la tabla referencias
	public void addReferencia2(int idCliente, int idSolicitud) {
		try {
			c.update(
					"INSERT INTO referencias(id_Solicitud,id_Cliente,nombre,paterno,Materno,Domicilio,Exterior,Interior,Telefono) VALUES ("
							+ idSolicitud + "," + idCliente + ",'" + txtNombreRef2.getText() + "','"
							+ txtPaternoRef2.getText() + "','" + txtMaternoRef2.getText() + "','"
							+ txtDireccionRef2.getText() + "','" + txtExteriorRef2.getText() + "','"
							+ txtInteriorRef2.getText() + "','" + txtTelefonoRef2.getText() + "');");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	// toma el modelo de la tabla y añade las filas con el resultado que arroje de
	// la busqueda
	public void llenarTbRegistrados(String txt, JLabel lbl) {
		ResultSet rs;
		DefaultTableModel mod = (DefaultTableModel) tbRegistrados.getModel();
		mod.setRowCount(0);
		try {
			rs = c.query("SELECT * FROM clientes_Personal WHERE nombre LIKE '%" + txt + "%' OR Paterno LIKE '%" + txt
					+ "%' OR Materno LIKE '%" + txt + "%';");
			while (rs.next()) {
				mod.addRow(new Object[] { rs.getString("id"), rs.getString("Nombre"), rs.getString("Paterno"),
						rs.getString("Materno"), rs.getString("Direccion"), rs.getString("Num_Exterior"),
						rs.getString("Telefono_Cel") });
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			lbl.setText("No se encontraron coincidencias");
		}
	}

	// Agrega las referencias de los usuarios registrados

	public void addReferenciasReg(int idSolicitud, int idCliente) {
		try {
			c.update(
					"INSERT INTO referencias (id_Solicitud,id_Cliente,nombre,paterno,Materno,Domicilio,Exterior,Interior,Telefono) VALUES ("
							+ idSolicitud + "," + idCliente + ",'" + nombreRef1.getText() + "','"
							+ paternoRef1.getText() + "','" + maternoRef1.getText() + "','" + domicilioRef1.getText()
							+ "','" + exteriorRef1.getText() + "','" + interiorRef1.getText() + "','"
							+ fijoRef1.getText() + "')");

			c.update(
					"INSERT INTO referencias (id_Solicitud,id_Cliente,nombre,paterno,Materno,Domicilio,Exterior,Interior,Telefono) VALUES ("
							+ idSolicitud + "," + idCliente + ",'" + nombreRef2.getText() + "','"
							+ paternoRef2.getText() + "','" + maternoRef2.getText() + "','" + domicilioRef2.getText()
							+ "','" + exteriorRef2.getText() + "','" + interiorRef2.getText() + "','"
							+ fijoRef2.getText() + "')");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addSolicitudReg(int idCliente) {
		try {
			c.update("INSERT INTO solicitudes_personales (id_Cliente,Cantidad,tipo_Credito,Status,fecha) VALUES ("
					+ idCliente + "," + Integer.parseInt(txtCantidadReg.getText()) + "," + cbTipoReg.getSelectedIndex()
					+ ",0, CURDATE());");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// confirma si los campos de referencias de clientes registrados estan completos
	public Boolean camposRefRegCompletos() {
		if (nombreRef1.getText().length() > 0 && paternoRef1.getText().length() > 0
				&& maternoRef1.getText().length() > 0 && domicilioRef1.getText().length() > 0
				&& exteriorRef1.getText().length() > 0 && fijoRef1.getText().length() > 0
				&& nombreRef2.getText().length() > 0 && paternoRef2.getText().length() > 0
				&& maternoRef2.getText().length() > 0 && domicilioRef2.getText().length() > 0
				&& exteriorRef2.getText().length() > 0 && fijoRef2.getText().length() > 0
				&& txtCantidadReg.getText().length() > 0 && cbTipoReg.getSelectedIndex() > 0) {
			return true;
		}
		return false;
	}

	public void limpiarReferenciasReg() {
		nombreRef1.setText("");
		paternoRef1.setText("");
		maternoRef1.setText("");
		domicilioRef1.setText("");
		exteriorRef1.setText("");
		interiorRef1.setText("");
		fijoRef1.setText("");
		headerSolReg.lblWarning.setText("");
		nombreRef2.setText("");
		paternoRef2.setText("");
		maternoRef2.setText("");
		domicilioRef2.setText("");
		exteriorRef2.setText("");
		interiorRef2.setText("");
		fijoRef2.setText("");
		txtCantidadReg.setText("");
		cbTipoReg.setSelectedIndex(0);
	}

	public void limpiarCamposSolicitud() {
		txtNombre.setText("");
		txtAp1.setText("");
		txtAp2.setText("");
		txtNacimiento.setText("");
		txtOcupacion.setText("");
		txtDomicilio.setText("");
		txtExterior.setText("");
		txtInterior.setText("");
		txtColonia.setText("");
		txtTiempo.setText("");
		txtCelular.setText("");
		txtNumFijo.setText("");
		txtSueldo.setText("");
		cbTipoDom.setSelectedIndex(0);
		cbEstadoCivil.setSelectedIndex(0);
		lblWarning.setText("");
		txtCantidad.setText("");
		cbTipo.setSelectedIndex(0);
		txtDireccion.setText("");
		txtExteriorEmpleo.setText("");
		txtInteriorEmpleo.setText("");
		txtTelefonoEmpleo.setText("");
		txtDescripcion.setText("");
		txtNombreRef1.setText("");
		txtNombreRef2.setText("");
		txtPaternoRef1.setText("");
		txtPaternoRef2.setText("");
		txtMaternoRef1.setText("");
		txtMaternoRef2.setText("");
		txtDireccionRef1.setText("");
		txtDireccionRef2.setText("");
		txtExteriorRef1.setText("");
		txtExteriorRef2.setText("");
		txtInteriorRef1.setText("");
		txtInteriorRef2.setText("");
		txtTelefonoRef1.setText("");
		txtTelefonoRef2.setText("");
	}

	public void limpiarCamposAval() {
		txtNombreAval.setText("");
		txtPaternoAval.setText("");
		txtMaternoAval.setText("");
		txtDireccionAval.setText("");
		txtExteriorAval.setText("");
		txtInteriorAval.setText("");
		txtTelefonoAval.setText("");
		txtOcupacionAval.setText("");
		headerAval.lblWarning.setText("");
	}

	public Boolean camposAvalLlenos() {
		if (txtNombreAval.getText().length() > 0 && txtPaternoAval.getText().length() > 0
				&& txtMaternoAval.getText().length() > 0 && txtDireccionAval.getText().length() > 0
				&& txtExteriorAval.getText().length() > 0 && txtTelefonoAval.getText().length() > 0
				&& txtOcupacionAval.getText().length() > 0) {
			return true;
		}
		return false;
	}
}