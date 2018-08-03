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

public class MostrarCliente extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtNombre, txtAp1, txtAp2, txtNacimiento, txtOcupacion, txtDomicilio, txtExterior, txtInterior,
			txtColonia, txtTiempo, txtNumCel, txtNumFijo, txtSueldo;
	private JComboBox cbEstadoCivil, cbTipoDom;
	int idUser,tipoUsuario = 1;
	JLabel lblDomicilio, lblExterior, lblInterior, lblNacimiento, lblSueldo, lblNumCel, lblWarning, lblNombre, lblAp1,
			lblAp2;
	JButton btnBack, btnNext, btnSave, btnInfoCliente, btnInfoEmpleo, btnInfoAvales;
	NuevoAval ca = new NuevoAval();
	Style s = new Style();
	DatosEmpleo jd = new DatosEmpleo();
	Conexion c = new Conexion();
	Alert alOk = new Alert();
	ResultSet rs;
	Alert alUpdate = new Alert();
	MostarDatosEmpleo sjd = new MostarDatosEmpleo();
	BuscarAvales sad = new BuscarAvales();

	public MostrarCliente() {
		setResizable(false);
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

		JLabel lblHeader = new JLabel("Nuevo Cliente: Datos Personales");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtNombre.setBounds(10, 69, 194, 25);
		pnHeader.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setForeground(Color.WHITE);
		s.mdTextField(txtNombre, Color.white, s.blue);
		TextPrompt tpName = new TextPrompt("Nombre", txtNombre);
		tpName.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpName.setForeground(Color.white);

		txtAp1 = new JTextField();
		txtAp1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtAp1.setColumns(10);
		txtAp1.setBounds(214, 69, 140, 25);
		txtAp1.setForeground(Color.WHITE);
		pnHeader.add(txtAp1);
		s.mdTextField(txtAp1, Color.WHITE, s.blue);
		TextPrompt tpAp1 = new TextPrompt("Apellido Paterno", txtAp1);
		tpAp1.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpAp1.setForeground(Color.white);

		txtAp2 = new JTextField();
		txtAp2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtAp2.setColumns(10);
		txtAp2.setBounds(364, 69, 140, 25);
		pnHeader.add(txtAp2);
		txtAp2.setForeground(Color.WHITE);
		s.mdTextField(txtAp2, Color.white, s.blue);
		s.myTextPrompt(txtAp2, "Apellido Materno", Color.white);

		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/edit.png");

		lblNombre = new JLabel("Nombre(s)");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNombre.setBounds(7, 54, 197, 14);
		pnHeader.add(lblNombre);

		lblAp1 = new JLabel("Apellido Paterno");
		lblAp1.setForeground(Color.WHITE);
		lblAp1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblAp1.setBounds(214, 54, 140, 14);
		pnHeader.add(lblAp1);

		lblAp2 = new JLabel("Apellido Materno");
		lblAp2.setForeground(Color.WHITE);
		lblAp2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblAp2.setBounds(364, 54, 140, 14);
		pnHeader.add(lblAp2);

		txtNacimiento = new JTextField();
		txtNacimiento.setBounds(446, 122, 137, 25);
		mainPanel.add(txtNacimiento);
		txtNacimiento.setColumns(10);
		s.mdTextField(txtNacimiento, s.blue, Color.white);
		s.myTextPrompt(txtNacimiento, "AAAA-MM-DD", Color.GRAY);

		txtOcupacion = new JTextField();
		txtOcupacion.setColumns(10);
		txtOcupacion.setBounds(370, 248, 170, 25);
		mainPanel.add(txtOcupacion);
		s.mdTextField(txtOcupacion, s.blue, Color.white);
		s.myTextPrompt(txtOcupacion, "Ocupacion", Color.GRAY);

		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(10, 122, 197, 25);
		mainPanel.add(txtDomicilio);
		txtDomicilio.setColumns(10);
		s.mdTextField(txtDomicilio, s.blue, Color.white);
		s.myTextPrompt(txtDomicilio, "Domicilio", Color.GRAY);

		txtExterior = new JTextField();
		txtExterior.setBounds(217, 122, 95, 25);
		mainPanel.add(txtExterior);
		txtExterior.setColumns(10);
		s.mdTextField(txtExterior, s.blue, Color.white);
		s.myTextPrompt(txtExterior, "Num. Exterior", Color.GRAY);

		txtInterior = new JTextField();
		txtInterior.setColumns(10);
		txtInterior.setBounds(330, 122, 95, 25);
		mainPanel.add(txtInterior);
		s.mdTextField(txtInterior, s.blue, Color.white);
		s.myTextPrompt(txtInterior, "Num. Interior", Color.GRAY);

		txtColonia = new JTextField();
		txtColonia.setBounds(10, 186, 170, 25);
		mainPanel.add(txtColonia);
		txtColonia.setColumns(10);
		s.mdTextField(txtColonia, s.blue, Color.white);
		s.myTextPrompt(txtColonia, "Colonia", Color.GRAY);

		txtTiempo = new JTextField();
		txtTiempo.setColumns(10);
		txtTiempo.setBounds(197, 186, 115, 25);
		mainPanel.add(txtTiempo);
		s.mdTextField(txtTiempo, s.blue, Color.white);
		s.myTextPrompt(txtTiempo, "Tiempo de Residencia", Color.gray);

		JLabel lblTiempoDeResidencia = new JLabel("Tiempo de Residencia");
		lblTiempoDeResidencia.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblTiempoDeResidencia.setBounds(197, 167, 115, 14);
		mainPanel.add(lblTiempoDeResidencia);
		s.placeholder(txtTiempo, lblTiempoDeResidencia);

		cbTipoDom = new JComboBox();
		cbTipoDom.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbTipoDom.setModel(
				new DefaultComboBoxModel(new String[] { "", "Propia", "Familiar", "Renta", "Hipoteca", "Otra" }));
		cbTipoDom.setBounds(330, 186, 115, 25);
		mainPanel.add(cbTipoDom);
		s.mdCombo(cbTipoDom, Color.WHITE, s.blue);

		cbEstadoCivil = new JComboBox();
		cbEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbEstadoCivil.setModel(new DefaultComboBoxModel(
				new String[] { "", "Soltero", "Casado", "Viudo", "Divorciado", "Union Libre", "Otro" }));
		cbEstadoCivil.setBounds(456, 186, 115, 25);
		mainPanel.add(cbEstadoCivil);
		s.mdCombo(cbEstadoCivil, Color.white, s.blue);

		JLabel lblTipoDeCasa = new JLabel("Tipo de Casa");
		lblTipoDeCasa.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblTipoDeCasa.setBounds(330, 167, 115, 14);
		mainPanel.add(lblTipoDeCasa);

		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblEstadoCivil.setBounds(456, 167, 115, 14);
		mainPanel.add(lblEstadoCivil);

		txtNumCel = new JTextField();
		txtNumCel.setColumns(10);
		txtNumCel.setBounds(10, 248, 170, 25);
		mainPanel.add(txtNumCel);
		s.mdTextField(txtNumCel, s.blue, Color.white);
		s.myTextPrompt(txtNumCel, "Celular", Color.gray);

		txtNumFijo = new JTextField();
		txtNumFijo.setColumns(10);
		txtNumFijo.setBounds(190, 248, 170, 25);
		mainPanel.add(txtNumFijo);
		s.mdTextField(txtNumFijo, s.blue, Color.white);
		s.myTextPrompt(txtNumFijo, "Tel Casa", Color.GRAY);

		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(10, 317, 115, 25);
		mainPanel.add(txtSueldo);
		s.mdTextField(txtSueldo, s.blue, Color.white);
		s.myTextPrompt(txtSueldo, "Sueldo Mensual", Color.gray);

		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblDomicilio.setBounds(10, 107, 197, 14);
		mainPanel.add(lblDomicilio);
		s.placeholder(txtDomicilio, lblDomicilio);

		lblExterior = new JLabel("Num. Exterior");
		lblExterior.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblExterior.setBounds(217, 108, 95, 14);
		mainPanel.add(lblExterior);
		s.placeholder(txtExterior, lblExterior);

		lblInterior = new JLabel("Num. Interior");
		lblInterior.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblInterior.setBounds(330, 107, 95, 14);
		mainPanel.add(lblInterior);
		s.placeholder(txtInterior, lblInterior);

		lblNacimiento = new JLabel("Fecha Nacimiento");
		lblNacimiento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNacimiento.setBounds(446, 108, 137, 14);
		mainPanel.add(lblNacimiento);
		s.placeholder(txtNacimiento, lblNacimiento);

		JLabel lblColonia = new JLabel("Colonia");
		lblColonia.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblColonia.setBounds(10, 167, 170, 14);
		mainPanel.add(lblColonia);
		s.placeholder(txtColonia, lblColonia);

		JLabel lblNumFijo = new JLabel("Tel Casa");
		lblNumFijo.setBounds(190, 232, 170, 14);
		mainPanel.add(lblNumFijo);
		s.placeholder(txtNumFijo, lblNumFijo);

		JLabel lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setBounds(370, 232, 170, 14);
		mainPanel.add(lblOcupacion);
		s.placeholder(txtOcupacion, lblOcupacion);

		lblSueldo = new JLabel("Sueldo Mensual");
		lblSueldo.setBounds(10, 302, 115, 14);
		mainPanel.add(lblSueldo);
		s.placeholder(txtSueldo, lblSueldo);

		lblNumCel = new JLabel("Num Celular");
		lblNumCel.setBounds(10, 232, 170, 14);
		mainPanel.add(lblNumCel);
		s.placeholder(txtNumCel, lblNumCel);

		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblWarning.setBounds(135, 310, 222, 32);
		mainPanel.add(lblWarning);
		btnNext.addActionListener(this);
		btnNext.addMouseListener(this);
		s.placeholder(txtNombre, lblNombre);
		s.placeholder(txtAp1, lblAp1);
		s.placeholder(txtAp2, lblAp2);

		btnSave = new JButton("");
		btnSave.setBorder(null);
		btnSave.setBounds(551, 11, 32, 32);
		pnHeader.add(btnSave);
		btnSave.setVisible(false);
		btnSave.addActionListener(this);
		btnSave.addMouseListener(this);
		s.btnIcon(btnSave, "views/saveWhite.png");
		jd.btnNext.addActionListener(this);
		jd.btnOmit.addActionListener(this);

		JPanel menuPane = new JPanel();
		menuPane.setBounds(475, 317, 96, 32);
		mainPanel.add(menuPane);
		menuPane.setLayout(null);
		s.mdPanel(menuPane, Color.white);

		btnInfoCliente = new JButton("");
		btnInfoCliente.setBounds(0, 0, 32, 32);
		menuPane.add(btnInfoCliente);
		btnInfoCliente.addMouseListener(this);
		s.btnIcon(btnInfoCliente, "views/userWhite.png");
		btnInfoCliente.setOpaque(true);
		btnInfoCliente.setBackground(s.blue);

		btnInfoEmpleo = new JButton("");
		btnInfoEmpleo.setBounds(32, 0, 32, 32);
		menuPane.add(btnInfoEmpleo);
		btnInfoEmpleo.addMouseListener(this);
		s.btnIcon(btnInfoEmpleo, "views/job.png");
		btnInfoEmpleo.addActionListener(this);

		btnInfoAvales = new JButton("");
		btnInfoAvales.setBounds(64, 0, 32, 32);
		menuPane.add(btnInfoAvales);
		btnInfoAvales.addMouseListener(this);
		s.btnIcon(btnInfoAvales, "views/avales.png");

		ca.btnNext.addActionListener(this);
		ca.btnOmit.addActionListener(this);
		
		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Datos guardados con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);

		jd.alSave.btnOk.addActionListener(this);
		btnNext.addActionListener(this);
		ca.alSave.btnOk.addActionListener(this);
		btnInfoAvales.addActionListener(this);
		alUpdate.btnCancel.addActionListener(this);
		alUpdate.lblAlertIcon.setIcon(new ImageIcon("views/ask.png"));
		alUpdate.lblMessage
				.setText("<html><body>Se actualizaran los datos del cliente<br>desea continuar?</body></html>");

		sad.btnInfoCliente.addActionListener(this);
		sad.btnInfoEmpleo.addActionListener(this);
		sjd.btnInfoCliente.addActionListener(this);
		sjd.btnInfoAvales.addActionListener(this);
		sjd.alSave.btnOk.addActionListener(this);
		sad.alAnother.btnOk.addActionListener(this);
		sad.alAnother.btnCancel.addActionListener(this);
		
		
		
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
		} else if (e.getSource() == btnSave) {
			s.hoverBorder(btnSave, Color.white);
			s.btnPointer(btnSave);
		} else if (e.getSource() == btnInfoEmpleo) {
			s.btnPointer(btnInfoEmpleo);
			s.hoverBorder(btnInfoEmpleo, s.blue);
		} else if (e.getSource() == btnInfoAvales) {
			s.btnPointer(btnInfoAvales);
			s.hoverBorder(btnInfoAvales, s.blue);
		} else if (e.getSource() == btnInfoCliente) {
			s.btnPointer(btnInfoCliente);
		} else if (e.getSource() == btnInfoEmpleo) {

		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnNext) {
			btnNext.setBorder(null);
		} else if (e.getSource() == btnBack) {
			btnBack.setBorder(null);
		} else if (e.getSource() == btnSave) {
			btnSave.setBorder(null);
		} else if (e.getSource() == btnInfoEmpleo) {
			btnInfoEmpleo.setBorder(null);
		} else if (e.getSource() == btnInfoAvales) {
			btnInfoAvales.setBorder(null);
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			setEnabledFields(true);
			btnNext.setVisible(false);
			btnSave.setVisible(true);

		} else if (e.getSource() == btnSave) {
			if (fullFields()) {
				alUpdate.setVisible(true);
				lblWarning.setText("");
			}
		} else if (e.getSource() == alUpdate.btnCancel) {
			alUpdate.setVisible(false);
		} else if (e.getSource() == btnInfoEmpleo) {
			
			sjd.setVisible(true);
			sjd.fillJobData();
			sjd.fieldsEditable(false);
			this.setVisible(false);
			if(tipoUsuario == 1) {
				sjd.btnNext.setVisible(true);
				sjd.btnSave.setVisible(false);
			}else {
				sjd.btnNext.setVisible(false);
			}
		} else if (e.getSource() == btnInfoAvales) {
			sad.setVisible(true);
			this.setVisible(false);
			sad.fillTableAvales(searchAvalesByIdCliente());
		} else if (e.getSource() == sad.btnInfoCliente) {
			this.setVisible(true);
			sjd.fieldsEditable(false);
			if(tipoUsuario == 1) {
				this.btnSave.setVisible(false);
				this.btnNext.setVisible(true);	
			}else {
				btnNext.setVisible(false);
			}
			setEnabledFields(false);
			sad.setVisible(false);
		} else if (e.getSource() == sad.btnInfoEmpleo) {
			sjd.fieldsEditable(false);
			if(tipoUsuario == 1) {
				sjd.btnNext.setVisible(true);
				sjd.btnSave.setVisible(false);
			}else {
				sjd.btnNext.setVisible(false);
			}
			sad.setVisible(false);
			sjd.setVisible(true);
			sjd.fillJobData();
			
		} else if (e.getSource() == sjd.btnInfoAvales) {
			sad.setVisible(true);
			sad.fillTableAvales(searchAvalesByIdCliente());
			sjd.setVisible(false);
			
			
		} else if (e.getSource() == sjd.btnInfoCliente) {
			this.setVisible(true);
			sjd.setVisible(false);
			if(tipoUsuario == 1) {
				this.btnSave.setVisible(false);
				this.btnNext.setVisible(true);
			}else {
				btnNext.setVisible(false);
			}
			setEnabledFields(false);
		} else if (e.getSource() == sjd.alSave.btnOk) {
			try {
				if (sjd.isJobDataRegistered(rs.getInt("id")) == null) {
					sjd.addDatosEmpleo(rs.getString("Nombre"), rs.getString("Apellido_Paterno"),
							rs.getString("Apellido_Materno"));
					sjd.alSave.setVisible(false);
					alOk.setVisible(true);
					sjd.btnSave.setVisible(false);
					sjd.btnNext.setVisible(true);
					sjd.fieldsEditable(false);
				} else {
					sjd.actulizarDatosEmpleo(rs.getString("Nombre"), rs.getString("Apellido_Paterno"),
					rs.getString("Apellido_Materno"));
					sjd.alSave.setVisible(false);
					alOk.setVisible(true);
					sjd.fieldsEditable(false);
					sjd.btnSave.setVisible(false);
					sjd.btnNext.setVisible(true);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource() == sad.alAnother.btnCancel) {
			sad.fillTableAvales(searchAvalesByIdCliente());
			sad.setVisible(true);
			sad.alAnother.setVisible(false);
		}else if (e.getSource() == alOk.btnOk) {
			alOk.setVisible(false);
			
		}
	}

	public void fillFields() {
		try {
			if (rs.next()) {
				txtNombre.setText(rs.getString("Nombre"));
				txtAp1.setText(rs.getString("Apellido_Paterno"));
				txtAp2.setText(rs.getString("Apellido_Materno"));
				txtDomicilio.setText(rs.getString("Direccion"));
				txtExterior.setText(rs.getString("Num_Exterior"));
				txtInterior.setText(rs.getString("Num_Interior"));
				txtNacimiento.setText(rs.getString("Fecha_Nacimiento"));
				txtColonia.setText(rs.getString("colonia"));
				txtTiempo.setText(rs.getString("Tiempo_Residencia"));
				cbTipoDom.setSelectedIndex(rs.getInt("Tipo_Casa"));
				cbEstadoCivil.setSelectedIndex(rs.getInt("Estado_Civil"));
				txtNumCel.setText(rs.getString("Telefono_Cel"));
				txtNumFijo.setText(rs.getString("Telefono_Fijo"));
				txtOcupacion.setText(rs.getString("Ocupacion"));
				txtSueldo.setText(rs.getString("sueldo_Mensual"));
				sjd.idUser = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCliente() {

		try {
			c.update("UPDATE clientes_personal SET Nombre = '" + txtNombre.getText() + "',Apellido_Paterno = '"
					+ txtAp1.getText() + "',Apellido_Materno = '" + txtAp2.getText() + "' ,Telefono_Cel = '"
					+ txtNumCel.getText() + "'," + "Telefono_Fijo = '" + txtNumFijo.getText() + "',Direccion = '"
					+ txtDomicilio.getText() + "',Num_Exterior = '" + txtExterior.getText() + "',Num_Interior = '"
					+ txtInterior.getText() + "',Colonia = '" + txtColonia.getText() + "',Fecha_Nacimiento = '"
					+ txtNacimiento.getText() + "',Tiempo_Residencia = '" + txtTiempo.getText() + "'," + "Tipo_Casa = "
					+ cbTipoDom.getSelectedIndex() + ",Estado_Civil = " + cbEstadoCivil.getSelectedIndex()
					+ ",Ocupacion = '" + txtOcupacion.getText() + "',Sueldo_Mensual = "
					+ Integer.parseInt(txtSueldo.getText()) + ",Editado = " + idUser + " WHERE id =" + rs.getInt("id")
					+ " ;");

		} catch (NumberFormatException nfe) {
			lblWarning.setText("Algunos campos deben ser numericos");
			lblWarning.setForeground(Color.RED);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setEnabledFields(Boolean b) {
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
		txtNumCel.setEditable(b);
		txtNumFijo.setEditable(b);
		txtSueldo.setEditable(b);
		cbEstadoCivil.setEnabled(b);
		cbTipoDom.setEnabled(b);
	}

	public boolean fullFields() {
		if (txtNombre.getText().length() > 0 && txtAp1.getText().length() > 0 && txtAp2.getText().length() > 0
				&& cbEstadoCivil.getSelectedIndex() > 0 && cbTipoDom.getSelectedIndex() > 0
				&& txtNacimiento.getText().length() > 0 && txtOcupacion.getText().length() > 0
				&& txtDomicilio.getText().length() > 0 && txtExterior.getText().length() > 0
				&& txtColonia.getText().length() > 0 && txtTiempo.getText().length() > 0
				&& txtNumCel.getText().length() > 0 && txtNumFijo.getText().length() > 0
				&& txtSueldo.getText().length() > 0) {
			if (s.checarFecha(txtNacimiento.getText())) {

				if (txtTiempo.getText().length() > 2 || txtNumCel.getText().length() > 12
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
			lblWarning.setText("Algunos campos estan Vacíos");
			lblWarning.setForeground(Color.RED);
			return false;
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

	public ResultSet searchAvalesByIdCliente() {
		try {
			return c.query("SELECT * FROM avales WHERE id_Cliente = " + rs.getInt("id") + " ;");

		} catch (Exception ex) {
			ex.printStackTrace();
			lblWarning.setText("No se encontraron resultados");
			return null;
		}
	}

	public void etiquetasVisibles(Boolean flag) {
		lblDomicilio.setVisible(flag);
		lblExterior.setVisible(flag);
		lblInterior.setVisible(flag);
		lblNacimiento.setVisible(flag);
		lblSueldo.setVisible(flag);
		lblNumCel.setVisible(flag);
		lblNombre.setVisible(flag);
		lblAp1.setVisible(flag);
		lblAp2.setVisible(flag);
	}

}
