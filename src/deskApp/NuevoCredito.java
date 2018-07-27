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
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class NuevoCredito extends JFrame implements MouseListener, ActionListener {
	Style s = new Style();
	
	private JPanel contentPane;
	JButton btnBack, btnNext;
	JLabel lblHeader, lblWarning, lblInteres;
	ResultSet rs;
	Conexion c = new Conexion();
	JComboBox cbTipo, cbInteres;
	JTextField txtFecha, txtCantidad;
	int semanas, interes, tipoCredito;
	MostrarTarjeton mt = new MostrarTarjeton();
	

	public NuevoCredito() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		lblHeader = new JLabel("");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);

		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		btnNext.addMouseListener(this);
		s.btnIcon(btnNext, "views/next.png");

		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(52, 54, 489, 22);
		pnHeader.add(lblWarning);

		txtFecha = new JTextField();
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtFecha.setBounds(44, 228, 185, 35);
		mainPanel.add(txtFecha);
		txtFecha.setColumns(10);

		s.myTextPrompt(txtFecha, "AAAA-MM-DD", Color.LIGHT_GRAY);

		txtCantidad = new JTextField();
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(44, 317, 185, 35);
		mainPanel.add(txtCantidad);

		cbTipo = new JComboBox();
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbTipo.getSelectedIndex() > 0) {
					semanas = 14;
					cbInteres.setSelectedIndex(0);
					cbInteres.setVisible(false);
					lblInteres.setVisible(false);
					if (cbTipo.getSelectedIndex() > 1) {
						semanas = 15;
						cbInteres.setSelectedIndex(0);
						if (cbTipo.getSelectedIndex() > 2) {
							cbInteres.setVisible(true);
							lblInteres.setVisible(true);
						} else {
							cbInteres.setVisible(false);
							lblInteres.setVisible(false);

						}
					}
				}
			}
		});
		cbTipo.setModel(new DefaultComboBoxModel(new String[] { "", "13 Semanas", "14 Semanas", "Interes Mensual" }));
		cbTipo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbTipo.setBounds(44, 142, 185, 35);
		s.mdCombo(cbTipo, Color.WHITE, s.blue);
		mainPanel.add(cbTipo);

		JLabel lblFecha = new JLabel("Fecha inicio");
		lblFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblFecha.setBounds(44, 188, 185, 22);
		mainPanel.add(lblFecha);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblCantidad.setBounds(44, 284, 185, 22);
		mainPanel.add(lblCantidad);

		JLabel lblTipo = new JLabel("Tipo de Credito");
		lblTipo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTipo.setBounds(44, 109, 185, 22);
		mainPanel.add(lblTipo);

		s.mdTextField(txtCantidad, s.blue, Color.white);
		s.mdTextField(txtFecha, s.blue, Color.white);
		s.mdCombo(cbTipo, Color.white, s.blue);

		cbInteres = new JComboBox();
		cbInteres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbInteres.getSelectedIndex() > 0) {
					interes = 7;
					if (cbInteres.getSelectedIndex() > 1) {
						interes = 8;
						if (cbInteres.getSelectedIndex() > 2) {
							interes = 9;
							if (cbInteres.getSelectedIndex() > 3)
								interes = 10;
						}
					}
				}
			}
		});
		cbInteres.setModel(new DefaultComboBoxModel(new String[] { "", "7", "8", "9", "10" }));
		cbInteres.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cbInteres.setBounds(269, 142, 185, 35);
		mainPanel.add(cbInteres);
		cbInteres.setVisible(false);
		s.mdCombo(cbInteres, Color.white, s.blue);

		lblInteres = new JLabel("Interes Mensual (% Porcentaje)");
		lblInteres.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblInteres.setBounds(269, 109, 185, 22);
		mainPanel.add(lblInteres);
		lblInteres.setVisible(false);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnBack){
			s.btnPointer(btnBack);
			s.hoverBorder(btnBack, Color.WHITE);
		}else if(e.getSource() == btnNext) {
			s.btnPointer(btnNext);
			s.hoverBorder(btnNext, Color.white);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public Boolean camposCompletos() {
		if (txtCantidad.getText().length() > 0 && cbTipo.getSelectedIndex() > 0 && txtFecha.getText().length() > 0) {
			return true;
		}
		return false;
	}

	public void crearCreditoPersonal(int id) {
		int interes = 5,total = 0;
		int cantidad = Integer.parseInt(txtCantidad.getText());
		float intereses = 0;
		if (cbTipo.getSelectedIndex() == 3) {		
			interes = cbInteres.getSelectedIndex();
			int inter = Integer.parseInt(cbInteres.getSelectedItem().toString());
			intereses = Integer.parseInt(txtCantidad.getText()) * inter / 100;
			total = (int) (cantidad + intereses);
		}
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

	public void crearCreditoGrupal(int id) {
		float intereses = 0,total = 0;
		int cantidad = Integer.parseInt(txtCantidad.getText());
		int interes = 5;
		if (cbTipo.getSelectedIndex() == 3) {
			interes = cbInteres.getSelectedIndex();	
			int inter = Integer.parseInt(cbInteres.getSelectedItem().toString());
			intereses = Integer.parseInt(txtCantidad.getText()) * inter / 100;
			total = cantidad + intereses;
		}

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
	
	public void limpiarCampos() {
		cbTipo.setSelectedIndex(0);
		cbInteres.setSelectedIndex(0);
		txtFecha.setText("");
		txtCantidad.setText("");
	}
}
