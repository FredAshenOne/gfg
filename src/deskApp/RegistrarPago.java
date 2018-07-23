package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;

public class RegistrarPago extends JFrame implements ActionListener, MouseListener {

	JPanel contentPane, pnHeader, pnSemanal;
	Style s = new Style();
	JButton btnNext, btnBack, btnPersonal, btnGrupal, btnRegistrar, btnMensual, btnSemanal;
	int tipoCredito = 1, tipoDuracion = 1;
	JLabel lblNumPago, lblWarning;
	JTextArea txtObservaciones;
	JTextField txtId, txtNumPago;
	Conexion c = new Conexion();
	Alert alOk = new Alert();
	ConfirmacionPago con = new ConfirmacionPago();

	public RegistrarPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 593, 379);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.WHITE);

		pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 593, 100);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);

		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		btnBack.addMouseListener(this);

		s.btnIcon(btnBack, "views/back.png");

		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		btnNext.addMouseListener(this);
		

		btnPersonal = new JButton("Personal");
		btnPersonal.setForeground(Color.WHITE);
		btnPersonal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnPersonal.setBorder(null);
		btnPersonal.setBounds(491, 57, 46, 32);
		s.btnHover(btnPersonal, Color.white, Color.WHITE, s.blue);
		pnHeader.add(btnPersonal);
		btnPersonal.addActionListener(this);
		btnPersonal.addMouseListener(this);

		btnGrupal = new JButton("Grupal");
		btnGrupal.setForeground(Color.WHITE);
		btnGrupal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnGrupal.setBorder(null);
		btnGrupal.setBounds(537, 57, 46, 32);
		pnHeader.add(btnGrupal);
		s.btnHover(btnGrupal, s.blue, s.blue, Color.white);
		btnGrupal.addActionListener(this);
		btnGrupal.addMouseListener(this);

		btnMensual = new JButton("Mensual");
		btnMensual.setForeground(Color.WHITE);
		btnMensual.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnMensual.setBorder(null);
		btnMensual.setBounds(56, 57, 46, 32);
		pnHeader.add(btnMensual);
		btnMensual.addActionListener(this);
		btnMensual.addMouseListener(this);
		s.btnHover(btnMensual, s.blue, s.blue, Color.white);

		btnSemanal = new JButton("Semanal");
		btnSemanal.setForeground(Color.WHITE);
		btnSemanal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnSemanal.setBorder(null);
		s.btnHover(btnSemanal, Color.white, Color.WHITE, s.blue);
		btnSemanal.setBounds(10, 57, 46, 32);
		pnHeader.add(btnSemanal);

		lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblWarning.setBounds(112, 67, 369, 22);
		pnHeader.add(lblWarning);
		btnSemanal.addActionListener(this);
		btnSemanal.addMouseListener(this);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnRegistrar.setBounds(177, 334, 273, 34);
		s.mdButton(btnRegistrar, s.blue);
		mainPanel.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		pnSemanal = new JPanel();
		pnSemanal.setBounds(0, 100, 593, 223);
		mainPanel.add(pnSemanal);
		pnSemanal.setLayout(null);
		s.mdPanel(pnSemanal, Color.white);

		JLabel lblIdCredito = new JLabel("ID Credito");
		lblIdCredito.setBounds(20, 28, 273, 22);
		pnSemanal.add(lblIdCredito);
		lblIdCredito.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));

		txtObservaciones = new JTextArea();
		txtObservaciones.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtObservaciones.setRows(50);
		txtObservaciones.setBounds(347, 60, 220, 113);
		pnSemanal.add(txtObservaciones);
		txtObservaciones.setLineWrap(true);
		txtObservaciones.setBorder(new LineBorder(s.blue, 1, true));

		lblNumPago = new JLabel("Numero de Pago");
		lblNumPago.setBounds(20, 106, 273, 22);
		pnSemanal.add(lblNumPago);
		lblNumPago.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNumPago.setHorizontalAlignment(SwingConstants.CENTER);

		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		txtId.setBounds(20, 61, 273, 34);
		pnSemanal.add(txtId);
		s.mdTextField(txtId, s.blue, Color.white);
		txtId.setColumns(10);

		txtNumPago = new JTextField();
		txtNumPago.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumPago.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		txtNumPago.setBounds(20, 139, 273, 34);
		pnSemanal.add(txtNumPago);
		txtNumPago.setColumns(10);
		s.mdTextField(txtNumPago, s.blue, Color.white);

		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(345, 28, 222, 22);
		pnSemanal.add(lblObservaciones);
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));

		con.btnCancelar.addActionListener(this);
		con.btnConfirmar.addActionListener(this);

		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Datos guardados con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnPersonal) {
			if (tipoCredito == 2) {
				s.btnPointer(btnPersonal);
				s.btnHover(btnPersonal, Color.white, s.blue, Color.WHITE);
			}
		} else if (e.getSource() == btnGrupal) {
			if (tipoCredito == 1) {
				s.btnPointer(btnGrupal);
				s.btnHover(btnGrupal, Color.white, s.blue, Color.WHITE);
			}
		} else if (e.getSource() == btnSemanal) {
			if (tipoDuracion == 2) {
				s.btnPointer(btnSemanal);
				s.btnHover(btnSemanal, Color.white, s.blue, Color.WHITE);
			}
		} else if (e.getSource() == btnMensual) {
			if (tipoDuracion == 1) {
				s.btnPointer(btnMensual);
				s.btnHover(btnMensual, Color.white, s.blue, Color.WHITE);
			}
		}else if(e.getSource() == btnBack) {
			s.btnPointer(btnBack);
			s.hoverBorder(btnBack, Color.WHITE);
		}else if(e.getSource() == btnNext) {
			s.btnPointer(btnNext);
			s.hoverBorder(btnNext, Color.white);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnPersonal) {
			if (tipoCredito == 2) {
				s.btnHover(btnPersonal, s.blue, s.blue, Color.white);
			}
		} else if (e.getSource() == btnGrupal) {
			if (tipoCredito == 1) {
				s.btnHover(btnGrupal, s.blue, s.blue, Color.white);
			}
		} else if (e.getSource() == btnSemanal) {
			if (tipoDuracion == 2) {
				s.btnHover(btnSemanal, s.blue, s.blue, Color.white);
			}
		} else if (e.getSource() == btnMensual) {
			if (tipoDuracion == 1) {
				s.btnHover(btnMensual, s.blue, s.blue, Color.white);
			}
		}

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
		if (e.getSource() == btnMensual) {
			if (tipoDuracion == 1) {
				tipoDuracion = 2;
				s.btnHover(btnSemanal, s.blue, s.blue, Color.white);
				s.btnHover(btnMensual, Color.white, Color.white, s.blue);
				lblNumPago.setText("Cantidad");

			}
		} else if (e.getSource() == btnSemanal) {
			if (tipoDuracion == 2) {
				tipoDuracion = 1;
				s.btnHover(btnMensual, s.blue, s.blue, Color.white);
				s.btnHover(btnSemanal, Color.white, Color.white, s.blue);
				lblNumPago.setText("Numero de Pago");
			}
		}
		if (e.getSource() == btnPersonal) {
			if (tipoCredito == 2) {
				tipoCredito = 1;
				s.btnHover(btnGrupal, s.blue, s.blue, Color.white);
				s.btnHover(btnPersonal, Color.white, Color.white, s.blue);
			}
		} else if (e.getSource() == btnGrupal) {
			if (tipoCredito == 1) {
				tipoCredito = 2;
				s.btnHover(btnPersonal, s.blue, s.blue, Color.white);
				s.btnHover(btnGrupal, Color.white, Color.white, s.blue);
			}
		} else if (e.getSource() == btnRegistrar) {
			ResultSet rs;
			int idCred = Integer.parseInt(txtId.getText());
			int numPago = Integer.parseInt(txtNumPago.getText());
			String fecha = LocalDate.now().toString();
			
			if (tipoDuracion == 1) {
				if (txtNumPago.getText().length() > 0 && txtId.getText().length() > 0) {
					try {
						rs = pagoTarjetonPorCredito(idCred, numPago);
						if (clientePorCredito(idCred).next() && rs.next()) {
							if(rs.getInt("status") == 2) {
								lblWarning.setText("");
								con.lblTexts(true);
								con.setVisible(true);
								con.llenarConfirmacion(clientePorCredito(idCred), pagoTarjetonPorCredito(idCred, numPago),
										tipoCredito, txtObservaciones.getText(), fecha, lblWarning);
							}else {
								lblWarning.setText("Pago ya registrado");
							}
							
						} else {
							lblWarning.setText("No se encontraron resultados,verifique los datos o tipos de credito");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			} else {
				if (txtNumPago.getText().length() > 0 && txtId.getText().length() > 0) {
					try {
						if (clientePorCredito(idCred).next() && creditoMensualPorId(idCred).next()) {
							lblWarning.setText("");
							con.lblTexts(false);
							con.setVisible(true);
							con.llenarConfirmacionMensual(tipoCredito, clientePorCredito(idCred), txtNumPago.getText(),
									LocalDate.now().toString(), idCred);
						} else {
							lblWarning.setText("No se encontraron resultados, verifique los datos o tipos de credito");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					lblWarning.setText("Algunos campos estan vacíos");
				}
			}

		} else if (e.getSource() == con.btnCancelar) {
			con.setVisible(false);
		} else if (e.getSource() == con.btnConfirmar) {
			int idCred = Integer.parseInt(txtId.getText());
			if (tipoDuracion == 1) {
				insertarPagoSemanal();
				con.setVisible(false);
				alOk.setVisible(true);
				clearFields();
			} else {
				insertarPagoMensual(creditoMensualPorId(idCred));
				con.setVisible(false);
				clearFields();
				alOk.setVisible(true);
			}
		} else if (e.getSource() == alOk.btnOk) {
			alOk.setVisible(false);
		}
	}

	public void insertarPagoSemanal() {
		int idCredito = Integer.parseInt(txtId.getText()), numPago = Integer.parseInt(txtNumPago.getText());
		if (tipoCredito == 1) {

			c.update(" UPDATE tarjeton_Personal SET fecha_Pago = CURDATE(),status = 1, observaciones = '"
					+ txtObservaciones.getText() + "' WHERE id_Credito = " + idCredito + " AND numero_pago = " + numPago
					+ " ;");
		} else {
			c.update(" UPDATE tarjeton_Grupal SET fecha_Pago = CURDATE(),status = 1,observaciones = '"
					+ txtObservaciones.getText() + "' WHERE id_Credito = " + idCredito + " AND numero_pago = " + numPago
					+ ";");
		}

	}

	public void insertarPagoMensual(ResultSet rsCredito) {
		con.lblTexts(false);
		int idCredito = 0;
		int cantidad = Integer.parseInt(txtNumPago.getText()), saldoActual, interesesTotales,total=0;
		int pagoIntereses = 0, pagoCapital = 0, cantidadRestante, interesesActuales = 0, capitalActual = 0;
		try {
			if (rsCredito.next()) {
				idCredito = rsCredito.getInt("id");
				saldoActual = rsCredito.getInt("Capital");
				interesesTotales = rsCredito.getInt("intereses");
				if (interesesTotales > cantidad) {
					pagoIntereses = cantidad;

				} else {
					cantidadRestante = cantidad - interesesTotales;
					pagoIntereses = interesesTotales;
					pagoCapital = cantidadRestante;
				}
				interesesActuales = interesesTotales - pagoIntereses;
				capitalActual = saldoActual - pagoCapital;
				total = capitalActual + interesesActuales;
			}
			if (tipoCredito == 1) {
				c.update(
						"INSERT INTO pagos_Personal (id_credito_personal,cantidad,intereses,capital,Fecha_Pago,Observaciones) values ("
								+ idCredito + "," + cantidad + "," + pagoIntereses + "," + pagoCapital + ",'"
								+ LocalDate.now().toString() + "','" + txtObservaciones.getText() + "')");
				c.update("UPDATE credito_personal SET intereses = " + interesesActuales + ",total = "+total+",capital = "
						+ capitalActual + " WHERE id = " + idCredito + ";");
			} else {
				c.update(
						"INSERT INTO pagos_Grupal (id_credito_grupal,cantidad,intereses,capital,Fecha_Pago,Observaciones) values ("
								+ idCredito + "," + cantidad + "," + pagoIntereses + "," + pagoCapital + ",'"
								+ LocalDate.now().toString() + "','" + txtObservaciones.getText() + "')");
				c.update("UPDATE credito_personal SET intereses = " + interesesActuales + ",total = "+total+",capital= "
						+ capitalActual + " WHERE id = " + idCredito + ";");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public ResultSet clientePorCredito(int idCredito) {

		try {
			if (tipoCredito == 1) {
				return c.query(
						"SELECT * FROM clientes_Personal cp LEFT JOIN credito_Personal crep ON cp.id = crep.id_Cliente WHERE crep.id = "
								+ idCredito + " AND crep.status = 1;");
			} else {
				return c.query("SELECT * FROM grupos g LEFT JOIN credito_grupal cg ON g.id = cg.id_Grupo WHERE cg.id = "
						+ idCredito + " AND status = 1;");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public ResultSet pagoTarjetonPorCredito(int idCredito, int numPago) {
		try {
			if (tipoCredito == 1) {
				return c.query("SELECT * FROM Tarjeton_Personal WHERE id_Credito= " + idCredito + " AND numero_Pago = "
						+ numPago + ";");
			} else {
				return c.query("SELECT * FROM tarjeton_grupal  WHERE id_Credito = " + idCredito + " AND numero_Pago = "
						+ numPago + ";");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	public ResultSet creditoMensualPorId(int idCredito) {
		try {
			if (tipoCredito == 1) {
				return c.query("SELECT * FROM credito_Personal WHERE id = " + idCredito
						+ " AND tipo_Credito = 3 AND status = 1; ");
			} else {
				return c.query("SELECT * FROM credito_grupal WHERE id = " + idCredito
						+ " AND tipo_Credito = 3 AND status = 1; ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void clearFields() {
		txtId.setText("");
		txtNumPago.setText("");
	}

	
	
	
	public int getInteresesPorId(int idcredito) {
		ResultSet rs;
		try {
			if(tipoCredito == 1) {
				rs = c.query("SELECT * FROM credito_personal cp LEFT JOIN tipos_interes ti ON cp.tipo_interes = ti.id WHERE cp.id = "+idcredito+" ;");
			}else {
				rs = c.query("SELECT * FROM credito_grupal cp LEFT JOIN tipos_interes ti ON cp.tipo_interes = ti.id WHERE cp.id = "+idcredito+" ;");
			}
			if(rs.next()) {
				
				return rs.getInt("total") * rs.getInt("ti.descripcion") / 100;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	

}
