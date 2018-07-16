package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;

public class BuscarClienteCreditos extends JFrame implements ActionListener, MouseListener {

	Style s = new Style();
	JButton btnBack, btnNext, btnCreditoGrupal, btnCreditoPersonal;
	JLabel lblHeader;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	JScrollPane scrollPane;
	int idUser;
	NuevoCredito nc = new NuevoCredito();
	Conexion c = new Conexion();
	private JLabel lblWarning;
	Alert alCreate = new Alert();
	Alert alert = new Alert();
	int tipoCredito = 1;
	MostrarTarjeton mt = new MostrarTarjeton();

	public BuscarClienteCreditos() {

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

		lblHeader = new JLabel("Selecciona Cliente");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				llenarTabla();
			}
		});
		txtSearch.setForeground(Color.WHITE);
		txtSearch.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtSearch.setBounds(100, 79, 374, 60);
		pnHeader.add(txtSearch);
		txtSearch.setColumns(10);
		s.mdTextField(txtSearch, Color.white, s.blue);
		txtSearch.setCaretColor(Color.white);
		s.myTextPrompt(txtSearch, "Buscar: (id cliente o Nombre)", Color.WHITE);
		txtSearch.setBorder(BorderFactory.createCompoundBorder(txtSearch.getBorder(),
				BorderFactory.createEmptyBorder(7, 10, 10, 5)));

		JLabel lblSearchIcon = new JLabel("");
		lblSearchIcon.setBounds(54, 77, 46, 62);
		pnHeader.add(lblSearchIcon);
		lblSearchIcon.setIcon(new ImageIcon("views/search2.png"));
		lblSearchIcon.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));

		lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setForeground(s.red);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblWarning.setBounds(52, 54, 495, 24);
		pnHeader.add(lblWarning);

		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		btnNext.addActionListener(this);
		btnNext.addMouseListener(this);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(54, 179, 494, 159);
		mainPanel.add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setBackground(Color.WHITE);
		table = new JTable();

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "Nombre", "A. Paterno", "A. Materno", "Dirección" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setBorder(null);
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		scrollPane.setVisible(false);

		table.addMouseListener(this);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		btnNext.setEnabled(false);

		btnCreditoGrupal = new JButton("Grupal");
		btnCreditoGrupal.setForeground(Color.WHITE);
		btnCreditoGrupal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnCreditoGrupal.setBorder(null);
		btnCreditoGrupal.setBounds(537, 107, 46, 32);
		pnHeader.add(btnCreditoGrupal);
		btnCreditoGrupal.addActionListener(this);
		btnCreditoGrupal.addMouseListener(this);
		s.btnHover(btnCreditoGrupal, s.blue, s.blue, Color.white);

		btnCreditoPersonal = new JButton("Personal");
		btnCreditoPersonal.setForeground(Color.WHITE);
		btnCreditoPersonal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnCreditoPersonal.setBorder(null);
		btnCreditoPersonal.setBounds(491, 107, 46, 32);
		pnHeader.add(btnCreditoPersonal);
		btnCreditoPersonal.addActionListener(this);
		btnCreditoPersonal.addMouseListener(this);

		s.btnHover(btnCreditoGrupal, s.blue, s.blue, Color.white);
		s.btnHover(btnCreditoPersonal, Color.white, Color.WHITE, s.blue);

		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				btnNext.setEnabled(!lsm.isSelectionEmpty());

			}
		});

		alCreate.lblMessage.setText("<html><body>Se guardaran los datos del credito<br>desea continuar?</body></html>");
		alCreate.lblAlertIcon.setIcon(new ImageIcon("views/ask.png"));
		alCreate.btnCancel.addActionListener(this);
		alCreate.btnOk.addActionListener(this);
		
		alert.lblMessage.setText("<html><body>Este cliente ya tiene un credito activo <br> Desea agretar otro?</body></html>");
		alert.lblAlertIcon.setIcon(new ImageIcon("views/alert.png"));		
		alert.btnOk.setText("Si");
		alert.btnOk.addActionListener(this);
		alert.btnCancel.setText("No");
		alert.btnCancel.addActionListener(this);
		
		mt.btnBack.addActionListener(this);
		
		nc.btnNext.addActionListener(this);
		nc.btnBack.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnNext) {
			if (btnNext.isEnabled()) {
				s.hoverBorder(btnNext, Color.white);
				s.btnPointer(btnNext);

			}
		} else if (e.getSource() == btnBack) {
			s.hoverBorder(btnBack, Color.WHITE);
			s.btnPointer(btnBack);
		} else if (e.getSource() == btnCreditoGrupal) {
			if (tipoCredito == 1) {
				s.btnHover(btnCreditoGrupal, Color.WHITE, s.blue, Color.white);
			} else {
				s.btnHover(btnCreditoGrupal, Color.white, Color.WHITE, s.blue);
			}

		} else if (e.getSource() == btnCreditoPersonal) {
			if (tipoCredito == 2) {
				s.btnHover(btnCreditoPersonal, Color.WHITE, s.blue, Color.white);
			} else {
				s.btnHover(btnCreditoPersonal, Color.white, Color.WHITE, s.blue);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnNext) {
			btnNext.setBorder(null);
		} else if (e.getSource() == btnBack) {
			btnBack.setBorder(null);
		} else if (e.getSource() == btnCreditoPersonal) {
			if (tipoCredito == 1) {
				s.btnHover(btnCreditoPersonal, Color.white, Color.WHITE, s.blue);
			} else {
				s.btnHover(btnCreditoPersonal, s.blue, s.blue, Color.white);
			}
		} else if (e.getSource() == btnCreditoGrupal) {
			if (tipoCredito == 2) {
				s.btnHover(btnCreditoGrupal, Color.white, Color.WHITE, s.blue);
			} else {
				s.btnHover(btnCreditoGrupal, s.blue, s.blue, Color.white);
			}
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
			nc.tipoCredito = tipoCredito;
			int index = table.getSelectedRow();
			int idCliente = Integer.parseInt(table.getModel().getValueAt(index, 0).toString());
			if (!nc.creditoActivo(idCliente)) {
				nc.lblHeader.setText("Nuevo Credito para : " + table.getModel().getValueAt(index, 1).toString() + " "
						+ table.getModel().getValueAt(index, 2).toString());
				nc.setVisible(true);
				this.setVisible(false);
			}else {
				alert.setVisible(true);
				
			}

		} else if (e.getSource() == nc.btnNext) {
			if (nc.camposCompletos()) {
				if (s.checarFecha(nc.txtFecha.getText())) {
					alCreate.setVisible(true);
				} else {
					nc.lblWarning.setText("La fecha no es correcta, verifique el formato");
				}
			} else {
				nc.lblWarning.setText("Algunos campos estan vacíos");
			}

		} else if (e.getSource() == alCreate.btnOk) {
			int index = table.getSelectedRow();
			int idCliente = Integer.parseInt(table.getModel().getValueAt(index, 0).toString());
			if (tipoCredito == 1) { // si es credito personal
				nc.lblHeader.setText("Nuevo Credito para : " + table.getModel().getValueAt(index, 1).toString() + " "
						+ table.getModel().getValueAt(index, 2).toString());
				if (nc.cbTipo.getSelectedIndex() < 3) { // si es credito semanal
					nc.crearCreditoPersonal(idCliente);
					if (creditoPersonalRegistrado(idCliente, nc.txtFecha.getText(), nc.txtCantidad.getText())) {
						nc.crearTarjeton(idCliente,
								idCreditoPersonalPorDatos(idCliente, nc.txtFecha.getText(), nc.txtCantidad.getText()));
						alCreate.setVisible(false);
						mt.setVisible(true);
						
					}
				} else {
					
					
					nc.crearCreditoPersonal(idCliente);
					if (creditoPersonalRegistrado(idCliente, nc.txtFecha.getText(), nc.txtCantidad.getText())) {
						alCreate.setVisible(false);
						
						
					}

				}

			} else { // si es credito grupal
				nc.lblHeader.setText("Nuevo Credito para : " + table.getModel().getValueAt(index, 1).toString());
				if (nc.cbTipo.getSelectedIndex() < 3) { // si es credito semanal
					nc.crearCreditoGrupal(idCliente);
					if (creditoGrupalRegistrado(idCliente, nc.txtFecha.getText(), nc.txtCantidad.getText())) {
						nc.crearTarjeton(idCliente,
								idCreditoGrupalPorDatos(idCliente, nc.txtFecha.getText(), nc.txtCantidad.getText()));
						alCreate.setVisible(false);
						mt.setVisible(true);
						mt.llenarTabla(buscarTarjetonGrupal(idCreditoGrupalPorDatos(idCliente,nc.txtFecha.getText(), nc.txtCantidad.getText())));
					}
				} else {
					nc.crearCreditoGrupal(idCliente);
					if (creditoGrupalRegistrado(idCliente, nc.txtFecha.getText(), nc.txtCantidad.getText())) {
						alCreate.setVisible(false);
						
					}
				}

			}
		} else if (e.getSource() == alCreate.btnCancel) {
			alCreate.setVisible(false);
		} else if (e.getSource() == nc.btnBack) {
			this.setVisible(true);
			nc.setVisible(false);
		} else if (e.getSource() == btnCreditoGrupal) {
			if (tipoCredito == 1) {
				tipoCredito = 2;
				table.getColumnModel().getColumn(2).setHeaderValue("Fecha Creacion");
				table.getColumnModel().getColumn(3).setHeaderValue("");
				table.getColumnModel().getColumn(4).setHeaderValue("");
				s.btnHover(btnCreditoPersonal, s.blue, s.blue, Color.white);
				s.btnHover(btnCreditoGrupal, Color.white, Color.WHITE, s.blue);
				btnCreditoGrupal.setSelected(false);
				llenarTabla();
				table.getTableHeader().repaint();
			}
		} else if (e.getSource() == btnCreditoPersonal) {
			if (tipoCredito == 2) {
				table.getColumnModel().getColumn(2).setHeaderValue("A. Paterno");
				table.getColumnModel().getColumn(3).setHeaderValue("A. Materno");
				table.getColumnModel().getColumn(4).setHeaderValue("Dirección");
				tipoCredito = 1;
				s.btnHover(btnCreditoGrupal, s.blue, s.blue, Color.white);
				s.btnHover(btnCreditoPersonal, Color.white, Color.WHITE, s.blue);
				btnCreditoPersonal.setSelected(false);
				llenarTabla();
				table.getTableHeader().repaint();
			}
		}else if(e.getSource() == mt.btnBack) {
			mt.setVisible(false);
			this.setVisible(true);
		}else if(e.getSource() == alert.btnOk) {
			int index = table.getSelectedRow();
			nc.lblHeader.setText("Nuevo Credito para : " + table.getModel().getValueAt(index, 1).toString() + " "
					+ table.getModel().getValueAt(index, 2).toString());
			nc.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == alert.btnCancel) {
			this.setVisible(true);
			alert.setVisible(false);
		}
	}

	public ResultSet searchClient() {
		try {
			String data = txtSearch.getText();
			String[] nombre = data.split(" ");
			if (tipoCredito == 1) {
				if (nombre.length > 2) {
					return c.query("SELECT * FROM clientes_personal WHERE nombre = '" + nombre[0]
							+ "' AND apellido_paterno = '" + nombre[1] + "' AND apellido_materno = '" + nombre[2]
							+ "';");
				} else if (nombre.length == 2) {
					return c.query("SELECT * FROM clientes_personal WHERE  nombre = '" + nombre[0]
							+ "' AND apellido_Paterno = '" + nombre[1] + "' OR (apellido_Paterno = '" + nombre[0]
							+ "' AND apellido_Materno = '" + nombre[1] + "');");
				} else if (nombre.length == 1) {
					try {
						int id = Integer.parseInt(data);
						return c.query("SELECT * FROM clientes_personal WHERE id = " + id + ";");
					} catch (NumberFormatException nfe) {
						return c.query("SELECT * FROM clientes_personal WHERE nombre LIKE '%" + nombre[0]
								+ "%' OR apellido_Paterno LIKE '%" + nombre[0] + "%' OR apellido_Materno LIKE '%"
								+ nombre[0] + "%';");
					}
				} else {
					lblWarning.setText("No se encontraron resultados");
					return null;
				}  
			} else {
				return c.query("SELECT * FROM grupos WHERE nombre LIKE '%" + data + "%';");
			}

		} catch (Exception ex) {
			lblWarning.setText("No se encontraron resultados");
			return null;
		}
	}

	public void llenarTabla() {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		ResultSet res = searchClient();
		ResultSet resv = searchClient();
		if (tipoCredito == 1) {

			try {
				if (resv.next()) {
					while (res.next()) {
						mod.addRow(new Object[] { res.getString("id"), res.getString("nombre"),
								res.getString("apellido_Paterno"), res.getString("apellido_Materno"),
								res.getString("Direccion") });
						scrollPane.setVisible(true);
						lblWarning.setText("");
					}
				} else {
					lblWarning.setText("No se encontraron resultados");
					scrollPane.setVisible(false);
				}
			} catch (SQLException e) {
				lblWarning.setText("No se encontraron resultados");
				scrollPane.setVisible(false);
			}
		} else {
			try {
				if (resv.next()) {
					while (res.next()) {
						mod.addRow(new Object[] { res.getString("id"), res.getString("nombre"),
								res.getString("fecha_Creacion") });
						scrollPane.setVisible(true);
						lblWarning.setText("");
					}
				} else {
					lblWarning.setText("No se encontraron resultados");
					scrollPane.setVisible(false);
				}
			} catch (SQLException e) {
				lblWarning.setText("No se encontraron resultados");
				scrollPane.setVisible(false);
			}
		}

	}

	public ResultSet clientePorId(int id) {
		try {
			return c.query("SELECT * FROM clientes_Personal WHERE id = " + id + ";");
		} catch (Exception ex) {
			ex.printStackTrace();
			lblWarning.setText("No se ha seleccionado algun elemento");
		}
		return null;
	}

	public ResultSet grupoPorId(int id) {
		try {
			return c.query("SELECT * FROM grupos WHERE id = " + id + ";");
		} catch (Exception ex) {
			ex.printStackTrace();
			lblWarning.setText("No se ha seleccionado algun elemento");
		}
		return null;
	}

	public ResultSet creditoGrualPorDatos(int idCliente, String fecha, String cantidad) {
		try {
			return c.query("SELECT * FROM credito_Grupal WHERE id_Grupo =" + idCliente + " AND Fecha_inicio = '" + fecha
					+ "' AND Cantidad_Inicial = " + Integer.parseInt(cantidad) + ";");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public ResultSet creditoPersonalPorDatos(int idCliente, String fecha, String cantidad) {
		try {
			return c.query("SELECT * FROM credito_Personal WHERE id_Cliente =" + idCliente + " AND Fecha_inicio = '"
					+ fecha + "' AND Cantidad_Inicial = " + Integer.parseInt(cantidad) + ";");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Boolean creditoPersonalRegistrado(int idCliente, String fecha, String cantidad) {
		try {
			return c.query("SELECT * FROM credito_Personal WHERE id_Cliente =" + idCliente + " AND Fecha_inicio = '"
					+ fecha + "' AND Cantidad_Inicial = " + Integer.parseInt(cantidad) + ";").next();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Boolean creditoGrupalRegistrado(int idCliente, String fecha, String cantidad) {
		try {
			return c.query("SELECT * FROM credito_Grupal WHERE id_Grupo =" + idCliente + " AND Fecha_inicio = '" + fecha
					+ "' AND Cantidad_Inicial = " + Integer.parseInt(cantidad) + ";").next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public int idCreditoPersonalPorDatos(int idCliente, String fecha, String cantidad) {
		try {
			ResultSet rs = c.query("SELECT * FROM credito_Personal WHERE id_Cliente =" + idCliente
					+ " AND Fecha_inicio = '" + fecha + "' AND Cantidad_Inicial = " + Integer.parseInt(cantidad) + ";");

			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public int idCreditoGrupalPorDatos(int idCliente, String fecha, String cantidad) {
		try {
			ResultSet rs = c.query("SELECT * FROM credito_Grupal WHERE id_Grupo =" + idCliente + " AND Fecha_inicio = '"
					+ fecha + "' AND Cantidad_Inicial = " + Integer.parseInt(cantidad) + ";");

			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public ResultSet buscarTarjetonPersonal(int idCredito) {
		int index = table.getSelectedRow();
		 int id = Integer.parseInt(table.getModel().getValueAt(index,0).toString());
		try {
			return c.query("SELECT * FROM tarjeton_Personal tp LEFT JOIN clientes_personal cp on tp.id_Cliente = cp.id LEFT JOIN credito_Personal cep on cep.id = tp.id_credito WHERE tp.id_Credito = "+idCredito+" ;");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ResultSet buscarTarjetonGrupal(int idCredito) {
		int index = table.getSelectedRow();
		 int id = Integer.parseInt(table.getModel().getValueAt(index,0).toString());
		try {
			return c.query("SELECT * FROM tarjeton_Grupal tp LEFT JOIN grupos cp on tp.id_Grupo = cp.id LEFT JOIN credito_Grupal cep on cep.id = tp.id_credito WHERE tp.id_Credito = "+idCredito+" ;");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
