package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Pruebas extends JFrame {

	JPanel contentPane,pnSolicitudRegistrado,pnReferencias;
	MdHeader headerRegistrados;
	MdTextField txtSearch,txtNombreRef1Reg, txtNombreRef2Reg,
	txtPaternoRef1Reg, txtPaternoRef2Reg, txtMaternoRef1Reg, txtMaternoRef2Reg, txtDireccionRef1Reg, txtDireccionRef2Reg,
	txtExteriorRef1Reg, txtExteriorRef2Reg, txtInteriorRef1Reg, txtInteriorRef2Reg, txtTelefonoRef1Reg, txtTelefonoRef2Reg,txtCantidad2;
	Style s = new Style();
	JComboBox cbTipo2;
	JLabel lblSearch,lblNombreRef1Reg, lblNombreRef2Reg, lblPaternoRef1Reg, lblPaternoRef2Reg,
	lblMaternoRef1Reg, lblMaternoRef2Reg, lblDireccionRef1Reg, lblDireccionRef2Reg, lblExteriorRef1Reg, lblExteriorRef2Reg,
	lblInteriorRef1Reg, lblInteriorRef2Reg, lblTiempoEmpleo, lblTelefonoRef1Reg, lblTelefonoRef2Reg,lblCantidad2;
	Conexion c  = new Conexion();
	JLabel lblCantidadReg;
	JComboBox cbTipoReg;
	MdTextField txtCantidadReg;
	 private JPanel pnCantidad;
	public Pruebas() {
		setBounds(100, 100, 1135, 827);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnSolicitudRegistrado = new JPanel();
		pnSolicitudRegistrado.setBounds(0, 0, 1134, 800);
		contentPane.add(pnSolicitudRegistrado);
		pnSolicitudRegistrado.setLayout(null);
		s.mdPanel(pnSolicitudRegistrado, Color.white);
		
		headerRegistrados = new MdHeader(s.blue,Color.WHITE);
		pnSolicitudRegistrado.add(headerRegistrados);
		
		pnCantidad = new JPanel();
		pnCantidad.setBounds(119, 294, 246, 256);
		pnSolicitudRegistrado.add(pnCantidad);
		pnCantidad.setLayout(null);
	

		lblCantidadReg = new JLabel("Tipo de Casa");
		lblCantidadReg.setBounds(96, 58, 54, 20);
		pnCantidad.add(lblCantidadReg);
		
		txtCantidadReg = new MdTextField(Color.BLACK, "Cantidad", Color.WHITE, s.blue,"Cantidad");
		txtCantidadReg.setBounds(64, 89, 120, 22);
		pnCantidad.add(txtCantidadReg);
		txtCantidadReg.setLblBounds();
		
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
		cbTipoReg.setModel(new DefaultComboBoxModel(new String[] { "", "13 Semanas", "14 Semanas", "Interes Mensual" }));
		cbTipoReg.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		s.mdCombo(cbTipoReg, Color.WHITE, s.blue);
		s.mdCombo(cbTipoReg, Color.WHITE, s.blue);
		cbTipoReg.setBounds(61, 153, 123, 26);
		pnCantidad.add(cbTipoReg);
		
		
		
		// Panel de informacion de referencias
		

	}
	
	
	
}
