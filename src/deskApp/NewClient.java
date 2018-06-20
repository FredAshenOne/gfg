package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

public class NewClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre,txtAp1,txtAp2;
	JButton btnBack;
	Style s = new Style();
	private JTextField txtNacimiento,txtOcupacion,txtDomicilio,txtExterior,txtInterior,txtColonia,txtTiempo,txtNumCel,txtNumFijo,txtSueldo;
	private JLabel lblDomicilio;
	private JLabel lblExterior;
	private JLabel lblInterior;
	private JLabel lblNacimiento;
	
	public NewClient() {
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
		s.btnTransparent(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtNombre.setBounds(10, 69, 194, 25);
		pnHeader.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setForeground(Color.WHITE);
		s.mdTextField(txtNombre,Color.white, s.blue);
		TextPrompt tpName = new TextPrompt("Nombre",txtNombre);
		tpName.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpName.setForeground(Color.white);
		
		txtAp1 = new JTextField();
		txtAp1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtAp1.setColumns(10);
		txtAp1.setBounds(214, 69, 140, 25);
		txtAp1.setForeground(Color.WHITE);
		pnHeader.add(txtAp1);
		s.mdTextField(txtAp1, Color.WHITE, s.blue);
		TextPrompt tpAp1= new TextPrompt("Apellido Paterno",txtAp1);
		tpAp1.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpAp1.setForeground(Color.white);
		
		txtAp2 = new JTextField();
		txtAp2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtAp2.setColumns(10);
		txtAp2.setBounds(364, 69, 140, 25);
		pnHeader.add(txtAp2);
		txtAp2.setForeground(Color.WHITE);
		s.mdTextField(txtAp2, Color.white,s.blue);
		TextPrompt tpAp2 = new TextPrompt("Apellido Materno",txtAp2);
		tpAp2.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpAp2.setForeground(Color.white);
		
		txtNacimiento = new JTextField();
		txtNacimiento.setBounds(446, 122, 137, 25);
		mainPanel.add(txtNacimiento);
		txtNacimiento.setColumns(10);
		s.mdTextField(txtNacimiento, s.blue, Color.white);
		
		txtOcupacion = new JTextField();
		txtOcupacion.setColumns(10);
		txtOcupacion.setBounds(370, 248, 170, 25);
		mainPanel.add(txtOcupacion);
		s.mdTextField(txtOcupacion, s.blue, Color.white);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 210, 137, 14);
		mainPanel.add(label);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(10, 122, 197, 25);
		mainPanel.add(txtDomicilio);
		txtDomicilio.setColumns(10);
		s.mdTextField(txtDomicilio, s.blue, Color.white);
		s.myTextPrompt(txtDomicilio, "Domicilio", Color.LIGHT_GRAY);
		
		txtExterior = new JTextField();
		txtExterior.setBounds(217, 122, 95, 25);
		mainPanel.add(txtExterior);
		txtExterior.setColumns(10);
		s.mdTextField(txtExterior, s.blue, Color.white);
		
		txtInterior = new JTextField();
		txtInterior.setColumns(10);
		txtInterior.setBounds(330, 122, 95, 25);
		mainPanel.add(txtInterior);
		s.mdTextField(txtInterior, s.blue, Color.white);
		
		txtColonia = new JTextField();
		txtColonia.setBounds(10, 186, 170, 25);
		mainPanel.add(txtColonia);
		txtColonia.setColumns(10);
		s.mdTextField(txtColonia, s.blue, Color.white);
		
		txtTiempo = new JTextField();
		txtTiempo.setColumns(10);
		txtTiempo.setBounds(197, 186, 115, 25);
		mainPanel.add(txtTiempo);
		s.mdTextField(txtTiempo, s.blue, Color.white);
		
		JLabel lblTiempoDeResidencia = new JLabel("Tiempo de Residencia");
		lblTiempoDeResidencia.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblTiempoDeResidencia.setBounds(197, 167, 115, 14);
		mainPanel.add(lblTiempoDeResidencia);
		
		JComboBox cbTipoDom = new JComboBox();
		cbTipoDom.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbTipoDom.setModel(new DefaultComboBoxModel(new String[] {"", "Propia", "Familiar", "Renta", "Hipoteca", "Otra"}));
		cbTipoDom.setBounds(330, 186, 115, 25);
		mainPanel.add(cbTipoDom);
		s.mdCombo(cbTipoDom);
		final Color ba = cbTipoDom.getBackground();
		cbTipoDom.setUI(new BasicComboBoxUI() {
		    @Override
		    protected JButton createArrowButton() {
		        JButton b = super.createArrowButton();
		        b.setBackground(ba);
		        b.setBorder(BorderFactory.createMatteBorder(0, 0,0, 0,Color.white));
		     	
		        return b; 
		   }
		    
		});
		cbTipoDom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, s.blue));
		
		JComboBox cbEstadoCivil = new JComboBox();
		cbEstadoCivil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"", "Soltero", "Casado", "Viudo", "Divorciado", "Union Libre", "Otro"}));
		cbEstadoCivil.setBounds(456, 186, 115, 25);
		mainPanel.add(cbEstadoCivil);
		s.mdCombo(cbEstadoCivil);
		final Color bg = cbEstadoCivil.getBackground();
		cbEstadoCivil.setUI(new BasicComboBoxUI() {
		    @Override
		    protected JButton createArrowButton() {
		        JButton b = super.createArrowButton();
		        b.setBackground(bg);
		        b.setForeground(s.blue);
		        b.setBorder(BorderFactory.createMatteBorder(0, 0,0, 0,Color.white));
		        return b; 
		   }
		    
		});
		cbEstadoCivil.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, s.blue));
		
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
		
		txtNumFijo = new JTextField();
		txtNumFijo.setColumns(10);
		txtNumFijo.setBounds(190, 248, 170, 25);
		mainPanel.add(txtNumFijo);
		s.mdTextField(txtNumFijo, s.blue, Color.white);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(10, 317, 115, 25);
		mainPanel.add(txtSueldo);
		s.mdTextField(txtSueldo, s.blue, Color.white);
		
		lblDomicilio = new JLabel("");
		lblDomicilio.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblDomicilio.setBounds(10, 107, 197, 14);
		mainPanel.add(lblDomicilio);
		s.placeholder(txtDomicilio, lblDomicilio, "Domicilio");
		lblExterior = new JLabel("");
		lblExterior.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblExterior.setBounds(217, 108, 95, 14);
		mainPanel.add(lblExterior);
		
		lblInterior = new JLabel("");
		lblInterior.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblInterior.setBounds(330, 107, 95, 14);
		mainPanel.add(lblInterior);
		
		lblNacimiento = new JLabel("");
		lblNacimiento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNacimiento.setBounds(446, 108, 137, 14);
		mainPanel.add(lblNacimiento);
		
		
	}
}
