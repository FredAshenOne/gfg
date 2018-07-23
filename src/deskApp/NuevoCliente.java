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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class NuevoCliente extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre, txtAp1, txtAp2, txtNacimiento, txtOcupacion, txtDomicilio, txtExterior, txtInterior,
			txtColonia, txtTiempo, txtNumCel, txtNumFijo, txtSueldo;
	private JComboBox cbEstadoCivil, cbTipoDom;
	int idUser;
	JLabel lblDomicilio, lblExterior, lblInterior, lblNacimiento, lblSueldo, lblNumCel, lblWarning, lblNombre, lblAp1,
			lblAp2,lblColonia,lblNumFijo,lblOcupacion,lblTiempoDeResidencia;
	JButton btnBack, btnNext,btnInfoCliente,btnInfoJob,btnInfoAvales;
	
	NuevoAval ca = new NuevoAval();
	Style s = new Style();
	UploadFiles uf = new UploadFiles();
	DatosEmpleo jd = new DatosEmpleo();
	Conexion c = new Conexion();
	ResultSet rs;
	Alert alSave = new Alert();
	Alert alNewAval = new Alert();
	public NuevoCliente() {

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
		s.btnIcon(btnNext, "views/next.png");

		lblNombre = new JLabel("Nombre");
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

		lblTiempoDeResidencia = new JLabel("Tiempo Residencia");
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
		cbTipoDom.setEditable(false);
		
		cbEstadoCivil = new JComboBox();
		cbEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbEstadoCivil.setModel(new DefaultComboBoxModel(
				new String[] { "", "Soltero", "Casado", "Viudo", "Divorciado", "Union Libre", "Otro" }));
		cbEstadoCivil.setBounds(456, 186, 115, 25);
		mainPanel.add(cbEstadoCivil);
		cbEstadoCivil.setEditable(false);
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

		lblExterior = new JLabel("No. Exterior");
		lblExterior.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblExterior.setBounds(217, 108, 95, 14);
		mainPanel.add(lblExterior);
		s.placeholder(txtExterior, lblExterior);

		lblInterior = new JLabel("No. Interior");
		lblInterior.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblInterior.setBounds(330, 107, 95, 14);
		mainPanel.add(lblInterior);
		s.placeholder(txtInterior, lblInterior);

		lblNacimiento = new JLabel("Fecha Nacimiento");
		lblNacimiento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNacimiento.setBounds(446, 108, 137, 14);
		mainPanel.add(lblNacimiento);
		s.placeholder(txtNacimiento, lblNacimiento);

		lblColonia = new JLabel("Colonia");
		lblColonia.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblColonia.setBounds(10, 167, 170, 14);
		mainPanel.add(lblColonia);
		s.placeholder(txtColonia, lblColonia);

		lblNumFijo = new JLabel("Telefono Fijo");
		lblNumFijo.setBounds(190, 232, 170, 14);
		mainPanel.add(lblNumFijo);
		s.placeholder(txtNumFijo, lblNumFijo);

		lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setBounds(370, 232, 170, 14);
		mainPanel.add(lblOcupacion);
		s.placeholder(txtOcupacion, lblOcupacion);

		lblSueldo = new JLabel("Sueldo Mensual");
		lblSueldo.setBounds(10, 302, 115, 14);
		mainPanel.add(lblSueldo);
		s.placeholder(txtSueldo, lblSueldo);

		lblNumCel = new JLabel("Celular");
		lblNumCel.setBounds(10, 232, 170, 14);
		mainPanel.add(lblNumCel);
		s.placeholder(txtNumCel, lblNumCel);

		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblWarning.setBounds(135, 317, 222, 32);
		mainPanel.add(lblWarning);
		btnNext.addActionListener(this);
		btnNext.addMouseListener(this);
		alSave.btnOk.addActionListener(this);
		s.placeholder(txtNombre, lblNombre);
		s.placeholder(txtAp1, lblAp1);
		s.placeholder(txtAp2, lblAp2);
		
		
		
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
			rs = clientByName(txtNombre.getText(), txtAp1.getText(), txtAp2.getText());
			if (fullFields()) {
				try {
					if (!rs.next()) {
						alSave.setVisible(true);

					} else {
						lblWarning.setText("Cliente ya registrado en la base de datos");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		} else if (e.getSource() == alSave.btnOk) {
			addClient();
			alSave.setVisible(false);
			jd.setVisible(true);
			this.setVisible(false);

		} else if (e.getSource() == jd.alSave.btnOk) {
			jd.addDatosEmpleo(txtNombre.getText(), txtAp1.getText(), txtAp2.getText());
			ca.setVisible(true);
			jd.setVisible(false);
			jd.alSave.setVisible(false);
		} else if (e.getSource() == jd.btnOmit) {
			jd.setVisible(false);
			ca.setVisible(true);			
		} else if (e.getSource() == ca.alSave.btnOk) {
			ca.addAval(txtNombre.getText(), txtAp1.getText(), txtAp2.getText());
			ca.alSave.setVisible(false);
			alNewAval.setVisible(true);
		} else if (e.getSource() == ca.btnOmit) {
			ca.setVisible(false);
		}else if(e.getSource() == alNewAval.btnOk) {
			ca.clearFields();
			alNewAval.setVisible(false);
		}else if(e.getSource() == alNewAval.btnCancel) {
			alNewAval.setVisible(false);
			
		}
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

	public void addClient() {

		try {
			c.update("INSERT INTO clientes_personal(Nombre,Apellido_Paterno,Apellido_Materno,Telefono_Cel,"
					+ "Telefono_Fijo,Direccion,Num_Exterior,Num_Interior,Colonia,Fecha_Nacimiento,Tiempo_Residencia,"
					+ "Tipo_Casa,Estado_Civil,Ocupacion,Sueldo_Mensual,Editado) VALUES(" + "'" + txtNombre.getText()
					+ "','" + txtAp1.getText() + "','" + txtAp2.getText() + "','" + txtNumCel.getText() + "','"
					+ txtNumFijo.getText() + "','" + txtDomicilio.getText() + "','" + txtExterior.getText() + "','"
					+ txtInterior.getText() + "','" + txtColonia.getText() + "','" + txtNacimiento.getText() + "','"
					+ txtTiempo.getText() + "'," + cbTipoDom.getSelectedIndex() + "," + cbEstadoCivil.getSelectedIndex()
					+ ",'" + txtOcupacion.getText() + "'," + Integer.parseInt(txtSueldo.getText()) + "," + idUser
					+ ");");

		} catch (NumberFormatException nfe) {
			lblWarning.setText("Algunos campos deben ser numericos");
			lblWarning.setForeground(Color.RED);
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
	
	 public void etiquetasInvisibles(Boolean b) {
		 lblDomicilio.setVisible(b);
		 lblExterior.setVisible(b);
		 lblInterior.setVisible(b);
		 lblNacimiento.setVisible(b);
		 lblSueldo.setVisible(b);
		 lblNumCel.setVisible(b);
		 lblNombre.setVisible(b);
		 lblAp1.setVisible(b);		 
		 lblAp2.setVisible(b);
		 lblOcupacion.setVisible(b);
		 lblNumFijo.setVisible(b);
		 lblColonia.setVisible(b);
		 lblTiempoDeResidencia.setVisible(b);		 
	 }
	

}
