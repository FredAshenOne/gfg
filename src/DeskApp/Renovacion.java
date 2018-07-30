package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Renovacion extends JFrame  implements ActionListener,MouseListener{
	
	private JPanel contentPane;
	Style s = new Style();
	JButton btnBack, btnNext, btnPersonal, btnGrupal;
	JLabel lblHeader,lblWarning;
	JTable table;
	JScrollPane scrollPane;
	int idCliente,tipoCredito = 1, tipoDuracion = 1,semanas = 0;
	Conexion c = new Conexion();
	Alert alCreate = new Alert();
	JComboBox cbTipo;
	JTextField txtCantidad,txtFecha;
	MostrarTarjeton mt = new MostrarTarjeton();
	Alert alOk = new Alert();
	

	public Renovacion() {

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
		pnHeader.setBounds(0, 0, 593, 150);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);

		btnBack = new JButton("");
		btnBack.setBorder(null);
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		btnBack.addMouseListener(this);

		lblHeader = new JLabel("Renovacion de Credito");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);
		
		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		
		cbTipo = new JComboBox();
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbTipo.getSelectedIndex() > 0) {
					semanas = 14;
					if (cbTipo.getSelectedIndex() > 1) {
						semanas = 15;
						
					}
				}
			}
		});
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"", "13 Semanas", "14 Semanas"}));
		cbTipo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		cbTipo.setBounds(25, 188, 253, 44);
		mainPanel.add(cbTipo);
		s.mdCombo(cbTipo, Color.WHITE, s.blue);
		s.mdCombo(cbTipo, Color.white, s.blue);
		
		txtCantidad = new JTextField();
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtCantidad.setBounds(25, 254, 253, 44);
		mainPanel.add(txtCantidad);
		s.myTextPrompt(txtCantidad, "Cantidad", Color.LIGHT_GRAY);
		txtCantidad.setColumns(10);
		s.mdTextField(txtCantidad, s.blue, Color.WHITE);
		
		txtFecha = new JTextField();
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtFecha.setColumns(10);
		txtFecha.setBounds(25, 325, 253, 44);
		s.myTextPrompt(txtFecha, "AAAA-MM-DD", Color.LIGHT_GRAY);	
		mainPanel.add(txtFecha);
		s.mdTextField(txtFecha, s.blue, Color.white);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblFecha.setBounds(25, 298, 253, 25);
		mainPanel.add(lblFecha);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblCantidad.setBounds(25, 229, 253, 25);
		mainPanel.add(lblCantidad);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblTipo.setBounds(25, 166, 253, 25);
		mainPanel.add(lblTipo);
		alCreate.lblAlertIcon.setIcon(new ImageIcon("views/ask.png"));
		alCreate.lblMessage.setText("<html><body>Se guardara la renovacion de credito <br> Desea Continuar?</body></html>");
		
		btnNext.addActionListener(this);
		btnNext.addMouseListener(this);
		
		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Datos guardados con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);
		
		alCreate.btnCancel.addActionListener(this);
		alCreate.btnOk.addActionListener(this);

}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNext) {
			if(camposLlenos()) {
				alCreate.setVisible(true);
			}
		}else if(e.getSource() == alCreate.btnCancel) {
			alCreate.setVisible(false);
		}else if(e.getSource() == alCreate.btnOk) {
			System.out.println(tipoCredito);
			if(tipoCredito == 1) {
				crearCreditoPersonal(idCliente);
				
			}else {
				crearCreditoGrupal(idCliente);
				
			}
			int idCredito = idCreditoPorDatos(idCliente,Integer.parseInt(txtCantidad.getText()),txtFecha.getText());
			if(idCredito != 0) {
				crearTarjeton(idCliente,idCredito);
				alOk.setVisible(true);
				alCreate.setVisible(false);
				this.setVisible(false);
				mt.tipoCredito = tipoCredito;
				mt.setVisible(true);
				mt.llenarTabla(infoCredito(idCredito));
			}
		}else if(e.getSource() == alOk.btnOk) {
			alOk.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub 
	
	public Boolean camposLlenos(){
		if(s.checarFecha(txtFecha.getText())) {
			return cbTipo.getSelectedIndex() > 0 && txtCantidad.getText().length() > 0 ;		
		}else {
			lblWarning.setText("Algunos campos no son validos");
			return false;
		}		 
	}
	
	public void crearTarjeton(int idCliente, int idCredito) {
		int cantidad = Integer.parseInt(txtCantidad.getText()) / 10, k = 0;
		if (cbTipo.getSelectedIndex() != 3) {
			for (int i = 1; i < semanas; i++) {
				k += 7;
				if (tipoCredito == 1) {
					c.update(
							"INSERT INTO tarjeton_Personal (id_Cliente,id_Credito,numero_Pago,cantidad,fecha_Asignada,status) VALUES ("
									+ idCliente + "," + idCredito + "," + i + "," + cantidad + ",DATE_ADD('"
									+ txtFecha.getText() + "',INTERVAL " + k + " DAY),2);");
				} else {
					c.update(
							"INSERT INTO Tarjeton_Grupal(id_Grupo,id_Credito,numero_Pago,cantidad,fecha_Asignada,status) VALUES ("
									+ idCliente + "," + idCredito + "," + i + "," + cantidad + ",DATE_ADD('"
									+ txtFecha.getText() + "',INTERVAL " + k + " DAY),2);");
				}
			}
		}
	}
	
	
	public void crearCreditoPersonal(int id) {
		int interes = 5,total = 0;
		int cantidad = Integer.parseInt(txtCantidad.getText());
		float intereses = 0;
		try {
			
			c.update(
					"INSERT INTO credito_Personal (id_Cliente,Cantidad_Inicial,total,capital,Tipo_Credito,tipo_interes,intereses,Fecha_inicio,Status) VALUES ("
							+ id + "," + cantidad + "," + total + "," + cantidad + "," + cbTipo.getSelectedIndex() + ","
							+ interes + ","+intereses+",'" + txtFecha.getText() + "',1);");
			c.update("INSERT INTO intereses_mensuales_personal (id_credito,cantidad,fecha) VALUES ("+idCreditoPorDatos(id,cantidad,txtFecha.getText())+","+intereses+",'"+txtFecha.getText()+"');");

		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	public int idCreditoPorDatos(int idCliente,int cantidad,String fecha_inicio) {
		ResultSet rs ;
		try {
			if(tipoCredito == 1) {
				rs = c.query("SELECT * FROM credito_personal WHERE id_Cliente = "+idCliente+" AND cantidad_inicial  = "+cantidad+" AND fecha_inicio = '"+fecha_inicio+"';");	
				
			}else {
				rs = c.query("SELECT * FROM credito_grupal WHERE id_grupo = "+idCliente+" AND cantidad_inicial  = "+cantidad+" AND fecha_inicio = '"+fecha_inicio+"';");
			}
			
			if(rs.next()) {
				return rs.getInt("id");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	

	public void crearCreditoGrupal(int id) {
		float intereses = 0,total = 0;
		int cantidad = Integer.parseInt(txtCantidad.getText());
		int interes = 5;

		try {
			c.update(
					"INSERT INTO credito_Grupal (id_Grupo,Cantidad_Inicial,total,capital,Tipo_Credito,tipo_interes,intereses,Fecha_inicio,Status) VALUES ("
							+ id + "," + cantidad + "," + total + ","+cantidad + "," + cbTipo.getSelectedIndex() + ","
							+ interes + ","+intereses+",'" + txtFecha.getText() + "',1);");
			c.update("INSERT INTO intereses_mensuales_grupal (id_credito,cantidad,fecha) VALUES ("+idCreditoPorDatos(id,cantidad,txtFecha.getText())+","+intereses+",'"+txtFecha.getText()+"');");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean creditoActivo(int idCliente) {
		try {
			if (tipoCredito == 1) {
				return c.query("SELECT * FROM credito_Personal WHERE id_Cliente = " + idCliente + " AND status = 1;")
						.next();
			} else {
				return c.query("SELECT * FROM credito_Grupal WHERE id_Grupo = " + idCliente + " AND status = 1;")
						.next();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public ResultSet infoCredito(int idCredito) {
		try {
			if(tipoCredito == 1) {
				return c.query("SELECT * FROM credito_Personal cep LEFT JOIN clientes_personal cp ON cep.id_Cliente = cp.id LEFT JOIN tarjeton_personal tp ON cep.id = tp.id_Credito WHERE cep.id = "+idCredito+";");
			}else {
				return c.query("SELECT * FROM credito_Grupal cep LEFT JOIN grupos cp ON cep.id_Grupo = cp.id LEFT JOIN tarjeton_grupal tp ON cep.id = tp.id_Credito WHERE cep.id = "+idCredito+";");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	public void completarCredito(int idCredito) {
		try {
			if(tipoCredito == 1) {
				c.update("UPDATE tarjeton_Personal SET status = 3 WHERE id_Credito = "+idCredito+" AND status = 1;");
				c.update("UPDATE credito_personal SET status = 6 WHERE id = "+idCredito+" AND STATUS = 1;");
			}else {
				c.update("UPDATE tarjeton_grupal SET status = 3 WHERE id_Credito = "+idCredito+" AND status = 1;");
				c.update("UPDATE credito_grupal SET status = 6 WHERE id = "+idCredito+" AND status = 1;");
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
