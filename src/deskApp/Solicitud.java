package deskApp;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Solicitud extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnReferencias;
	MdTextField txtNombre, txtAp1, txtAp2, txtNacimiento, txtOcupacion, txtDomicilio, txtExterior, txtInterior,
			txtColonia, txtTiempo, txtCelular, txtNumFijo, txtSueldo, txtCiudad, txtCantidad, txtDireccion,
			txtExteriorEmpleo, txtInteriorEmpleo, txtTelefonoEmpleo, txtDescripcion, txtNombreRef1, txtNombreRef2,
			txtPaternoRef1, txtPaternoRef2, txtMaternoRef1, txtMaternoRef2, txtDireccionRef1, txtDireccionRef2,
			txtExteriorRef1, txtExteriorRef2, txtInteriorRef1, txtInteriorRef2, txtTelefonoRef1, txtTelefonoRef2;
	private JComboBox cbEstadoCivil, cbTipoDom, cbTipo;
	int idUser, tipoUsuario;
	JLabel lblDomicilio, lblExterior, lblInterior, lblNacimiento, lblSueldo, lblCelular, lblWarning, lblNombre, lblAp1,
			lblAp2, lblColonia, lblFijo, lblOcupacion, lblResidencia, lblCiudad, lblTipoDeCasa, lblEstadoCivil,
			lblCantidad, lblDireccion, lblTelefonoEmpleo, lblDescripcion, lblExteriorEmpleo, lblInteriorEmpleo,
			lblInfoEmpleo, lblNombreRef1, lblNombreRef2, lblPaternoRef1, lblPaternoRef2, lblMaternoRef1, lblMaternoRef2,
			lblDireccionRef1, lblDireccionRef2, lblExteriorRef1, lblExteriorRef2, lblInteriorRef1, lblInteriorRef2,
			lblTelefonoRef1, lblTelefonoRef2;
	JButton btnBack, btnNext, btnInfoCliente, btnInfoJob, btnInfoAvales,btnNext2,btnBack2,btnNuevoCliente,btnClienteRegistrado;
	Alert alOk = new Alert();
	NuevoAval ca = new NuevoAval();
	Style s = new Style();
	DatosEmpleo jd = new DatosEmpleo();
	Conexion c = new Conexion();
	String nombre, ap1, ap2;
	ResultSet rs;
	Alert alSave = new Alert(), alNewAval = new Alert();
	JLabel lblHeader;

	public Solicitud() {
		setBounds(100, 100, 1135, 827);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnSolicitud = new JPanel();
		s.mdPanel(pnSolicitud, Color.white);
		pnSolicitud.setBounds(1134, 0, 1134, 800);
		contentPane.add(pnSolicitud);
		pnSolicitud.setLayout(null);
		
		
		
		JPanel pnPrincipal = new JPanel();
		pnPrincipal.setBounds(0, 0, 1134, 800);
		contentPane.add(pnPrincipal);
		pnPrincipal.setLayout(null);
		s.mdPanel(pnPrincipal,Color.white);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 1124, 151);
		pnSolicitud.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);

		JPanel pnHeader2 = new JPanel();
		pnHeader2.setBounds(0, 0, 1124, 151);
		pnPrincipal.add(pnHeader2);
		pnHeader2.setLayout(null);
		s.mdPanel(pnHeader2, s.blue);
		
		btnBack = new JButton("");
		btnBack.setBorder(null);
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		btnBack.addMouseListener(this);

		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(1082, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		
		btnBack2 = new JButton("");
		btnBack2.setBorder(null);
		btnBack2.setBounds(10, 11, 32, 32);
		pnHeader2.add(btnBack2);
		s.btnIcon(btnBack2, "views/back.png");
		btnBack2.addMouseListener(this);

		btnNext2 = new JButton("");
		btnNext2.setBorder(null);
		btnNext2.setBounds(1082, 11, 32, 32);
		pnHeader2.add(btnNext2);
		s.btnIcon(btnNext2, "views/next.png");

		lblHeader = new JLabel("Nuevo Cliente: Datos Personales");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 1020, 32);
		pnHeader.add(lblHeader);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 54, 240, 14);
		pnHeader.add(lblNombre);
		txtNombre = new MdTextField(Color.WHITE, "Nombre", s.blue, Color.white, lblNombre);
		txtNombre.setBounds(10, 69, 240, 35);
		pnHeader.add(txtNombre);

		lblAp1 = new JLabel("Apellido Paterno");
		lblAp1.setBounds(260, 54, 240, 14);
		pnHeader.add(lblAp1);
		txtAp1 = new MdTextField(Color.white, "Apellido Paterno", s.blue, Color.WHITE, lblAp1);
		txtAp1.setBounds(260, 69, 240, 35);
		pnHeader.add(txtAp1);

		lblAp2 = new JLabel();
		lblAp2.setBounds(523, 55, 240, 14);
		pnHeader.add(lblAp2);
		txtAp2 = new MdTextField(Color.WHITE, "Apellido_Materno", s.blue, Color.WHITE, lblAp2);
		txtAp2.setBounds(523, 69, 240, 35);
		pnHeader.add(txtAp2);

		lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 115, 1104, 32);
		pnHeader.add(lblWarning);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));

		lblNacimiento = new JLabel();
		lblNacimiento.setBounds(57, 280, 179, 14);
		pnSolicitud.add(lblNacimiento);
		txtNacimiento = new MdTextField(Color.BLACK, "AAAA-MM-DD", Color.white, s.blue, lblNacimiento);
		lblNacimiento.setText("Fecha Nacimiento");
		txtNacimiento.setBounds(57, 298, 179, 32);
		pnSolicitud.add(txtNacimiento);

		lblOcupacion = new JLabel();
		lblOcupacion.setBounds(71, 553, 170, 14);
		pnSolicitud.add(lblOcupacion);
		txtOcupacion = new MdTextField(Color.BLACK, "Ocupacion", Color.white, s.blue, lblOcupacion);
		txtOcupacion.setBounds(71, 572, 170, 31);
		pnSolicitud.add(txtOcupacion);

		lblDomicilio = new JLabel();
		lblDomicilio.setBounds(246, 280, 197, 14);
		pnSolicitud.add(lblDomicilio);
		txtDomicilio = new MdTextField(Color.BLACK, "Domicilio", Color.white, s.blue, lblDomicilio);
		txtDomicilio.setBounds(246, 298, 197, 32);
		pnSolicitud.add(txtDomicilio);

		lblExterior = new JLabel();
		lblExterior.setBounds(87, 375, 95, 14);
		pnSolicitud.add(lblExterior);
		txtExterior = new MdTextField(Color.BLACK, "No. Exterior", Color.white, s.blue, lblExterior);
		txtExterior.setBounds(87, 393, 95, 32);
		pnSolicitud.add(txtExterior);

		lblInterior = new JLabel();
		lblInterior.setBounds(192, 375, 95, 14);
		pnSolicitud.add(lblInterior);
		txtInterior = new MdTextField(Color.BLACK, "No. Interior", Color.white, s.blue, lblInterior);
		txtInterior.setBounds(192, 393, 95, 32);
		pnSolicitud.add(txtInterior);

		lblColonia = new JLabel("Colonia");
		lblColonia.setBounds(260, 170, 238, 14);
		pnSolicitud.add(lblColonia);
		txtColonia = new MdTextField(Color.BLACK, "Colonia", Color.white, s.blue, lblColonia);
		txtColonia.setBounds(260, 189, 238, 32);
		pnSolicitud.add(txtColonia);

		lblResidencia = new JLabel("Tiempo Residencia");
		lblResidencia.setBounds(297, 375, 115, 14);
		pnSolicitud.add(lblResidencia);
		txtTiempo = new MdTextField(Color.BLACK, "Tiempo de Residencia", Color.white, s.blue, lblResidencia);
		txtTiempo.setBounds(297, 393, 115, 32);
		pnSolicitud.add(txtTiempo);

		lblCelular = new JLabel();
		lblCelular.setBounds(71, 651, 170, 14);
		pnSolicitud.add(lblCelular);
		txtCelular = new MdTextField(Color.BLACK, "Celular", Color.white, s.blue, lblCelular);
		txtCelular.setBounds(71, 667, 170, 34);
		pnSolicitud.add(txtCelular);

		lblFijo = new JLabel();
		lblFijo.setBounds(251, 651, 179, 14);
		pnSolicitud.add(lblFijo);
		txtNumFijo = new MdTextField(Color.BLACK, "Num Fijo", Color.white, s.blue, lblFijo);
		txtNumFijo.setBounds(246, 669, 184, 32);
		pnSolicitud.add(txtNumFijo);

		lblSueldo = new JLabel();
		lblSueldo.setBounds(249, 552, 181, 14);
		pnSolicitud.add(lblSueldo);
		txtSueldo = new MdTextField(Color.BLACK, "Sueldo", Color.white, s.blue, lblSueldo);
		txtSueldo.setBounds(251, 571, 179, 32);
		pnSolicitud.add(txtSueldo);

		lblCiudad = new JLabel();
		lblCiudad.setBounds(10, 171, 240, 14);
		pnSolicitud.add(lblCiudad);
		txtCiudad = new MdTextField(Color.BLACK, "Ciudad", Color.white, s.blue, lblCiudad);
		txtCiudad.setBounds(10, 189, 238, 32);
		pnSolicitud.add(txtCiudad);

		cbTipoDom = new JComboBox();
		cbTipoDom.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbTipoDom.setModel(
				new DefaultComboBoxModel(new String[] { "", "Propia", "Familiar", "Renta", "Hipoteca", "Otra" }));
		cbTipoDom.setBounds(120, 484, 115, 34);
		pnSolicitud.add(cbTipoDom);
		s.mdCombo(cbTipoDom, Color.WHITE, s.blue);
		cbTipoDom.setEditable(false);
		s.mdCombo(cbTipoDom, Color.white, s.blue);
		lblTipoDeCasa = new JLabel("Tipo de Casa");
		lblTipoDeCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeCasa.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTipoDeCasa.setBounds(120, 468, 115, 14);
		pnSolicitud.add(lblTipoDeCasa);

		cbEstadoCivil = new JComboBox();
		cbEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbEstadoCivil.setModel(new DefaultComboBoxModel(
				new String[] { "", "Soltero", "Casado", "Viudo", "Divorciado", "Union Libre", "Otro" }));
		cbEstadoCivil.setBounds(245, 484, 115, 34);
		pnSolicitud.add(cbEstadoCivil);
		cbEstadoCivil.setEditable(false);
		s.mdCombo(cbEstadoCivil, Color.white, s.blue);
		s.mdCombo(cbEstadoCivil, Color.WHITE, s.blue);

		lblEstadoCivil = new JLabel();
		lblEstadoCivil.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoCivil.setText("Estado Civil");
		lblEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblEstadoCivil.setBounds(245, 468, 115, 14);
		pnSolicitud.add(lblEstadoCivil);

		JPanel pnInfoEmpleo = new JPanel();
		pnInfoEmpleo.setBounds(515, 150, 609, 639);
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
		txtDireccion = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, new Color(3, 155, 229), lblDireccion);
		txtDireccion.setBounds(20, 71, 222, 32);
		pnInfoEmpleo.add(txtDireccion);

		lblExteriorEmpleo = new JLabel("");
		lblExteriorEmpleo.setBounds(307, 54, 95, 14);
		pnInfoEmpleo.add(lblExteriorEmpleo);
		txtExteriorEmpleo = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, new Color(3, 155, 229),
				lblExteriorEmpleo);
		txtExteriorEmpleo.setBounds(307, 71, 95, 32);
		pnInfoEmpleo.add(txtExteriorEmpleo);

		lblInteriorEmpleo = new JLabel("");
		lblInteriorEmpleo.setBounds(465, 54, 95, 14);
		pnInfoEmpleo.add(lblInteriorEmpleo);
		txtInteriorEmpleo = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, new Color(3, 155, 229),
				lblInteriorEmpleo);
		txtInteriorEmpleo.setBounds(465, 71, 95, 32);
		pnInfoEmpleo.add(txtInteriorEmpleo);

		lblTelefonoEmpleo = new JLabel("");
		lblTelefonoEmpleo.setBounds(127, 148, 189, 14);
		pnInfoEmpleo.add(lblTelefonoEmpleo);
		txtTelefonoEmpleo = new MdTextField(Color.BLACK, "Tel�fono", Color.WHITE, new Color(3, 155, 229),
				lblTelefonoEmpleo);
		txtTelefonoEmpleo.setBounds(127, 169, 181, 31);
		pnInfoEmpleo.add(txtTelefonoEmpleo);

		lblDescripcion = new JLabel("");
		lblDescripcion.setBounds(324, 148, 181, 14);
		pnInfoEmpleo.add(lblDescripcion);
		txtDescripcion = new MdTextField(Color.BLACK, "Descripcion", Color.WHITE, new Color(3, 155, 229),
				lblDescripcion);
		txtDescripcion.setBounds(316, 168, 181, 32);
		pnInfoEmpleo.add(txtDescripcion);

		pnReferencias = new JPanel();
		pnReferencias.setBounds(0, 211, 609, 428);
		pnInfoEmpleo.add(pnReferencias);
		pnReferencias.setLayout(null);
		s.mdPanel(pnReferencias, Color.white);
		pnReferencias.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, s.blue));

		lblNombreRef1 = new JLabel("");
		lblNombreRef1.setBounds(10, 53, 194, 14);
		pnReferencias.add(lblNombreRef1);
		txtNombreRef1 = new MdTextField(Color.BLACK, "Nombre(s)", Color.WHITE, new Color(3, 155, 229), lblNombreRef1);

		txtNombreRef1.setBounds(10, 68, 194, 31);
		pnReferencias.add(txtNombreRef1);

		lblPaternoRef1 = new JLabel("");
		lblPaternoRef1.setBounds(227, 53, 181, 14);
		pnReferencias.add(lblPaternoRef1);
		txtPaternoRef1 = new MdTextField(Color.BLACK, "A. Paterno", Color.WHITE, new Color(3, 155, 229),
				lblPaternoRef1);
		txtPaternoRef1.setBounds(227, 68, 181, 31);
		pnReferencias.add(txtPaternoRef1);

		lblMaternoRef1 = new JLabel("");
		lblMaternoRef1.setBounds(418, 53, 181, 14);
		pnReferencias.add(lblMaternoRef1);
		txtMaternoRef1 = new MdTextField(Color.BLACK, "A. Materno", Color.WHITE, new Color(3, 155, 229),
				lblMaternoRef1);
		txtMaternoRef1.setBounds(418, 68, 181, 31);
		pnReferencias.add(txtMaternoRef1);

		lblDireccionRef1 = new JLabel("");
		lblDireccionRef1.setBounds(10, 129, 222, 14);
		pnReferencias.add(lblDireccionRef1);
		txtDireccionRef1 = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, new Color(3, 155, 229),
				lblDireccionRef1);
		txtDireccionRef1.setBounds(10, 144, 222, 32);
		pnReferencias.add(txtDireccionRef1);

		lblExteriorRef1 = new JLabel("");
		lblExteriorRef1.setBounds(242, 129, 95, 14);
		pnReferencias.add(lblExteriorRef1);
		txtExteriorRef1 = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, new Color(3, 155, 229),
				lblExteriorRef1);
		txtExteriorRef1.setBounds(242, 144, 95, 32);
		pnReferencias.add(txtExteriorRef1);

		lblInteriorRef1 = new JLabel("");
		lblInteriorRef1.setBounds(347, 129, 95, 14);
		pnReferencias.add(lblInteriorRef1);
		txtInteriorRef1 = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, new Color(3, 155, 229),
				lblInteriorRef1);
		txtInteriorRef1.setBounds(347, 144, 95, 32);
		pnReferencias.add(txtInteriorRef1);

		lblTelefonoRef1 = new JLabel("");
		lblTelefonoRef1.setBounds(452, 129, 147, 14);
		pnReferencias.add(lblTelefonoRef1);
		txtTelefonoRef1 = new MdTextField(Color.BLACK, "Num Fijo", Color.WHITE, new Color(3, 155, 229),
				lblTelefonoRef1);
		txtTelefonoRef1.setBounds(452, 144, 147, 32);
		pnReferencias.add(txtTelefonoRef1);

		lblNombreRef2 = new JLabel("");
		lblNombreRef2.setBounds(10, 262, 194, 14);
		pnReferencias.add(lblNombreRef2);
		txtNombreRef2 = new MdTextField(Color.BLACK, "Nombre(s)", Color.WHITE, new Color(3, 155, 229), lblNombreRef2);
		txtNombreRef2.setBounds(10, 275, 194, 31);
		pnReferencias.add(txtNombreRef2);

		lblDireccionRef2 = new JLabel("");
		lblDireccionRef2.setBounds(10, 336, 222, 14);
		pnReferencias.add(lblDireccionRef2);
		txtDireccionRef2 = new MdTextField(Color.BLACK, "Domicilio", Color.WHITE, new Color(3, 155, 229),
				lblDireccionRef2);
		txtDireccionRef2.setBounds(10, 351, 222, 32);
		pnReferencias.add(txtDireccionRef2);

		lblPaternoRef2 = new JLabel("");
		lblPaternoRef2.setBounds(227, 262, 181, 14);
		pnReferencias.add(lblPaternoRef2);
		txtPaternoRef2 = new MdTextField(Color.BLACK, "A. Paterno", Color.WHITE, new Color(3, 155, 229),
				lblPaternoRef2);
		txtPaternoRef2.setBounds(227, 275, 181, 31);
		pnReferencias.add(txtPaternoRef2);

		lblExteriorRef2 = new JLabel("");
		lblExteriorRef2.setBounds(242, 336, 95, 14);
		pnReferencias.add(lblExteriorRef2);
		txtExteriorRef2 = new MdTextField(Color.BLACK, "No. Exterior", Color.WHITE, new Color(3, 155, 229),
				lblExteriorRef2);
		txtExteriorRef2.setBounds(242, 351, 95, 32);
		pnReferencias.add(txtExteriorRef2);

		lblMaternoRef2 = new JLabel("");
		lblMaternoRef2.setBounds(418, 262, 181, 14);
		pnReferencias.add(lblMaternoRef2);
		txtMaternoRef2 = new MdTextField(Color.BLACK, "A. Materno", Color.WHITE, new Color(3, 155, 229),
				lblMaternoRef2);
		txtMaternoRef2.setBounds(418, 275, 181, 31);
		pnReferencias.add(txtMaternoRef2);

		lblInteriorRef2 = new JLabel("");
		lblInteriorRef2.setBounds(347, 336, 95, 14);
		pnReferencias.add(lblInteriorRef2);
		txtInteriorRef2 = new MdTextField(Color.BLACK, "No. Interior", Color.WHITE, new Color(3, 155, 229),
				lblInteriorRef2);
		txtInteriorRef2.setBounds(347, 351, 95, 32);
		pnReferencias.add(txtInteriorRef2);

		lblTelefonoRef2 = new JLabel("");
		lblTelefonoRef2.setBounds(452, 336, 147, 14);
		pnReferencias.add(lblTelefonoRef2);
		txtTelefonoRef2 = new MdTextField(Color.BLACK, "Num Fijo", Color.WHITE, new Color(3, 155, 229),
				lblTelefonoRef2);
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

		lblCantidad = new JLabel("Tipo de Casa");
		lblCantidad.setBounds(71, 728, 170, 14);
		pnSolicitud.add(lblCantidad);
		txtCantidad = new MdTextField(Color.BLACK, "Cantidad", Color.WHITE, new Color(3, 155, 229), lblCantidad);
		txtCantidad.setBounds(71, 743, 170, 34);
		pnSolicitud.add(txtCantidad);

		JLabel lblTipoCredito = new JLabel("Tipo de Credito");
		lblTipoCredito.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTipoCredito.setBounds(246, 728, 184, 14);
		pnSolicitud.add(lblTipoCredito);

		cbTipo = new JComboBox();
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cbTipo.setModel(new DefaultComboBoxModel(new String[] { "", "13 Semanas", "14 Semanas", "Interes Mensual" }));
		cbTipo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		s.mdCombo(cbTipo, Color.WHITE, s.blue);
		s.mdCombo(cbTipo, Color.WHITE, s.blue);
		cbTipo.setBounds(246, 743, 185, 35);
		pnSolicitud.add(cbTipo);

		btnNext.addActionListener(this);
		btnNext.addMouseListener(this);

		alSave.btnOk.addActionListener(this);
		alSave.btnCancel.addActionListener(this);

		jd.btnNext.addActionListener(this);
		jd.btnOmit.addActionListener(this);

		ca.btnNext.addActionListener(this);
		ca.btnOmit.addActionListener(this);

		alSave.lblMessage.setText("Desea continuar y guardar ?");
		alSave.lblAlertIcon.setIcon(new ImageIcon("views/alert.png"));

		jd.alSave.btnOk.addActionListener(this);

		alNewAval.btnCancel.setText("No");
		alNewAval.btnOk.setText("Si");
		alNewAval.lblAlertIcon.setIcon(new ImageIcon("views/ask.png"));
		alNewAval.lblMessage.setText("Desea agregar otro aval?");
		ca.alSave.btnOk.addActionListener(this);

		alNewAval.btnOk.addActionListener(this);
		alNewAval.btnCancel.addActionListener(this);

		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Cliente registrado con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnNext) {
			s.hoverBorder(btnNext, Color.white);
			s.btnPointer(btnNext);

		} else if (e.getSource() == btnBack) {
			s.hoverBorder(btnBack, Color.WHITE);
			s.btnPointer(btnBack);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnNext) {
			btnNext.setBorder(null);
		} else if (e.getSource() == btnBack) {
			btnBack.setBorder(null);
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

			if (camposPersonalesCompletos() && camposEmpleoCompletos() && camposReferenciasCompletos()) {
				if (!clienteExistente(txtNombre.getText(), txtAp1.getText(), txtAp2.getText())) {
					alSave.setVisible(true);
				} else {
					lblWarning.setText("Cliente ya registrado");
				}
			}
		} else if (e.getSource() == alSave.btnOk) {
			int idClienteActual = getCurrentIdFrom("clientes_personal");
			int idSolicitud = getCurrentIdFrom("solicitudes_personales");
			addClient();
			addSolicitud(idClienteActual);
			addReferencia1(idClienteActual, idSolicitud);
			addReferencia2(idClienteActual, idSolicitud);
			alSave.setVisible(false);
			alOk.setVisible(true);
			this.setVisible(false);

		} else if (e.getSource() == ca.alSave.btnOk) {
			ca.addAval(txtNombre.getText(), txtAp1.getText(), txtAp2.getText());
			ca.alSave.setVisible(false);
			alNewAval.setVisible(true);
			alOk.setVisible(true);
		} else if (e.getSource() == ca.btnOmit) {
			ca.setVisible(false);
			alOk.setVisible(true);
		} else if (e.getSource() == alNewAval.btnOk) {
			ca.clearFields();
			alNewAval.setVisible(false);
		} else if (e.getSource() == alNewAval.btnCancel) {
			alNewAval.setVisible(false);
		} else if (e.getSource() == alSave.btnCancel) {
			this.setVisible(true);
			alSave.setVisible(false);
		} else if (e.getSource() == alOk.btnOk) {
			alOk.setVisible(false);
		}
	}

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
			lblWarning.setText("Algunos campos personales estan Vac�os");
			lblWarning.setForeground(Color.RED);
			return false;
		}
	}

	public Boolean camposEmpleoCompletos() {
		if (txtDireccion.getText().length() > 0 && txtExteriorEmpleo.getText().length() > 0
				&& txtTelefonoEmpleo.getText().length() > 0 && txtDescripcion.getText().length() > 0) {
			return true;
		} else {
			lblWarning.setText("Algunos campos de empleo estan incompletos");
			return false;
		}
	}

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

	public Boolean clienteExistente(String nombre, String ap1, String ap2) {
		ResultSet rs;
		try {
			rs = c.query("SELECT * FROM clientes_personal WHERE Nombre = '" + nombre + "' AND apellido_Paterno = '"
					+ ap1 + "' AND apellido_Materno = '" + ap2 + "';");

			return rs.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

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

	public void addClient() {

		try {
			c.update("INSERT INTO clientes_personal(Nombre,Apellido_Paterno,Apellido_Materno,Telefono_Cel,"
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

	public void addSolicitud(int idCliente) {
		try {
			c.update("INSERT INTO solicitudes_personales(id_Cliente,Cantidad,Tipo_Credito) VALUES (" + idCliente + ","
					+ Integer.parseInt(txtCantidad.getText()) + "," + cbTipo.getSelectedIndex() + ");");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

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

	public ResultSet clientByName(String nombre, String ap1, String ap2) {

		try {
			return c.query("SELECT * FROM clientes_personal WHERE Nombre = '" + nombre + "' AND apellido_Paterno = '"
					+ ap1 + "' AND apellido_Materno = '" + ap2 + "';");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static boolean isNumeric(String cadena) {

		boolean resultado;

		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

	public void limpiarCampos() {
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
}