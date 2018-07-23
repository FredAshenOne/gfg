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

public class BuscarCredito extends JFrame implements ActionListener, MouseListener {

	Style s = new Style();
	JButton btnBack, btnNext, btnPersonal, btnGrupal;
	JLabel lblHeader;
	private JPanel contentPane;
	public JTextField txtSearch;
	private JTable table;
	JScrollPane scrollPane;
	int idUser;
	int tipoCredito = 1,tipoDuracion = 1;
	MostrarCreditoMensual mcm = new MostrarCreditoMensual();
	Conexion c = new Conexion();
	private JLabel lblWarning;
	Alert alCreate = new Alert();
	MostrarTarjeton mt = new MostrarTarjeton();
	public BuscarCredito() {

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

		lblHeader = new JLabel("Buscar Cliente");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				fillTable();
			}
		});
		txtSearch.setForeground(Color.WHITE);
		txtSearch.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtSearch.setBounds(100, 79, 359, 60);
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
		table = new JTable(){
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		btnNext.setEnabled(false);
		
		table.setBorder(null);
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		scrollPane.setVisible(false);
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Credito", "Cliente", "Nombre", "A. Paterno", "A. Materno", "Cantidad" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		

		table.addMouseListener(this);

		

		btnPersonal = new JButton("Personal");

		btnGrupal = new JButton("Grupal");
		btnGrupal = new JButton("Grupal");
		btnGrupal.setForeground(Color.WHITE);
		btnGrupal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnGrupal.setBorder(null);
		btnGrupal.setBounds(537, 107, 46, 32);
		pnHeader.add(btnGrupal);
		btnGrupal.addActionListener(this);
		btnGrupal.addMouseListener(this);
		s.btnHover(btnGrupal, s.blue, s.blue, Color.white);

		mcm.lblCantidad.setText("Total");
		
		btnPersonal = new JButton("Personal");
		btnPersonal.setForeground(Color.WHITE);
		btnPersonal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnPersonal.setBorder(null);
		btnPersonal.setBounds(491, 107, 46, 32);
		s.btnHover(btnPersonal, Color.white, Color.WHITE, s.blue);
		pnHeader.add(btnPersonal);
		btnPersonal.addActionListener(this);
		btnPersonal.addMouseListener(this);

		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				btnNext.setEnabled(!lsm.isSelectionEmpty());
			}
		});
		
		mt.btnBack.addActionListener(this);

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
		} else if (e.getSource() == btnGrupal) {
			if (tipoCredito == 1) {
				s.btnHover(btnGrupal, Color.WHITE, s.blue, Color.white);
			} else {
				s.btnHover(btnGrupal, Color.white, Color.WHITE, s.blue);
			}

		} else if (e.getSource() == btnPersonal) {
			if (tipoCredito == 2) {
				s.btnHover(btnPersonal, Color.WHITE, s.blue, Color.white);
			} else {
				s.btnHover(btnPersonal, Color.white, Color.WHITE, s.blue);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnNext) {
			btnNext.setBorder(null);
		} else if (e.getSource() == btnBack) {
			btnBack.setBorder(null);
		} else if (e.getSource() == btnPersonal) {
			if (tipoCredito == 1) {
				s.btnHover(btnPersonal, Color.white, Color.WHITE, s.blue);
			} else {
				s.btnHover(btnPersonal, s.blue, s.blue, Color.white);
			}
		} else if (e.getSource() == btnGrupal) {
			if (tipoCredito == 2) {
				s.btnHover(btnGrupal, Color.white, Color.WHITE, s.blue);
			} else {
				s.btnHover(btnGrupal, s.blue, s.blue, Color.white);
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
			
			this.setVisible(false);
			int index = table.getSelectedRow();
			int id = Integer.parseInt(table.getModel().getValueAt(index,0).toString());
			tipoDuracion = tipoDuracionPorCredito(id,tipoCredito);
			ResultSet cred = clienteCreditoPorCredito(id,tipoCredito);
			if(tipoCredito == 1) {
				
				if(tipoDuracion == 1) {
					mt.llenarTabla(buscarTarjetonPersonal());

					mt.setVisible(true);
				}else {
					try {
						mcm.llenarDatos(cred.getString("cp.id"), cred.getString("clip.Nombre") +" " +cred.getString("clip.Apellido_Paterno") +" " +cred.getString("clip.Apellido_Materno"), cred.getString("cp.Total"),cred.getString("cp.Intereses") , cred.getString("cp.fecha_Inicio"));
						mcm.setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
			}else {
				if(tipoDuracion == 1) {
					mt.llenarTabla(buscarTarjetonGrupal());

					mt.setVisible(true);
				}else{
					try {
						mcm.llenarDatos(cred.getString("cp.id"), cred.getString("clip.Nombre") ,cred.getString("cp.Total"),cred.getString("cp.Intereses") , cred.getString("cp.fecha_Inicio"));
						mcm.setVisible(true);
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					}
				}
				
			}

		} else if (e.getSource() == btnGrupal) {
			if (tipoCredito == 1) {
				tipoCredito = 2;
				table.getColumnModel().getColumn(1).setHeaderValue("Grupo");
				table.getColumnModel().getColumn(2).setHeaderValue("Nombre");
				table.getColumnModel().getColumn(3).setHeaderValue("Cantidad");
				table.getColumnModel().getColumn(4).setHeaderValue("");
				table.getColumnModel().getColumn(5).setHeaderValue("");
				s.btnHover(btnPersonal, s.blue, s.blue, Color.white);
				s.btnHover(btnGrupal, Color.white, Color.WHITE, s.blue);
				btnGrupal.setSelected(false);
				fillTable();
				table.getTableHeader().repaint();
			}
		} else if (e.getSource() == btnPersonal) {
			if (tipoCredito == 2) {
				table.getColumnModel().getColumn(1).setHeaderValue("Cliente");
				table.getColumnModel().getColumn(2).setHeaderValue("Nombre");
				table.getColumnModel().getColumn(3).setHeaderValue("A. Paterno");
				table.getColumnModel().getColumn(4).setHeaderValue("A. Materno");
				table.getColumnModel().getColumn(5).setHeaderValue("Can tidad");
				tipoCredito = 1;
				s.btnHover(btnGrupal, s.blue, s.blue, Color.white);
				s.btnHover(btnPersonal, Color.white, Color.WHITE, s.blue);
				btnPersonal.setSelected(false);
				fillTable();
				table.getTableHeader().repaint();
			}
		}else if(e.getSource() == mt.btnBack){
			this.setVisible(true);
			mt.setVisible(false);
		}

	}

	public ResultSet searchCredito() {
		try {
			String data = txtSearch.getText();
			String[] nombre = data.split(" ");
			if (nombre.length > 2) {
				return c.query(
						"SELECT * FROM clientes_personal cp LEFT JOIN credito_Personal c on cp.id = c.id_Cliente WHERE c.status = 1 AND cp.nombre LIKE '%"
								+ nombre[0] + "%' AND cp.apellido_paterno LIKE '%" + nombre[1]
								+ "%' AND cp.apellido_materno LIKE '%" + nombre[2] + "%';");
			} else if (nombre.length == 2) {
				return c.query(
						"SELECT * FROM clientes_personal cp LEFT JOIN credito_Personal c on cp.id = c.id_Cliente WHERE c.status = 1 AND  cp.nombre LIKE '%"
								+ nombre[0] + "%' AND cp.apellido_Paterno LIKE '%" + nombre[1]
								+ "%' OR (cp.apellido_Paterno LIKE '%" + nombre[0]
								+ "%' AND cp.apellido_Materno LIKE '%" + nombre[1] + "%');");
			} else if (nombre.length == 1) {

				try {
					int id = Integer.parseInt(data);
					if (tipoCredito == 1) {

						return c.query(
								"SELECT * FROM clientes_personal cp LEFT JOIN credito_Personal c on cp.id = c.id_Cliente WHERE c.status = 1 AND cp.id = "
										+ id + " OR c.id = " + id + ";");
					} else {
						return c.query(
								"SELECT * FROM grupos cp LEFT JOIN credito_grupal c on cp.id = c.id_Cliente WHERE c.status = 1 AND cp.id = "
										+ id + " OR c.id = " + id + ";");
					}

				} catch (NumberFormatException nfe) {
					if (tipoCredito == 1) {
						return c.query(
								"SELECT * FROM clientes_personal cp LEFT JOIN credito_Personal c on cp.id = c.id_Cliente WHERE c.status = 1 AND c.id IS NOT NULL AND (cp.nombre LIKE '%"
										+ nombre[0] + "%' OR cp.apellido_Paterno LIKE '%" + nombre[0]
										+ "%' OR cp.apellido_Materno LIKE '%" + nombre[0] + "%');");
					} else {
						return c.query(
								"SELECT * FROM grupos cp LEFT JOIN credito_grupal c on cp.id = c.id_grupo WHERE c.status = 1 AND c.id IS NOT NULL AND cp.nombre LIKE '%"
										+ data + "%';");
					}

				}
			} else {
				if (tipoCredito == 1) {
					return c.query(
							"SELECT * FROM clientes_personal cp LEFT JOIN credito_Personal c on cp.id = c.id_Cliente WHERE c.status = 1 AND c.id IS NOT NULL;");
				} else {
					System.out.println("aqui si llega");
					return c.query(
							"SELECT * FROM grupos cp LEFT JOIN credito_grupal c on cp.id = c.id_grupo WHERE c.status = 1 AND c.id IS NOT NULL;");
				}

			}
		} catch (Exception ex) {
			lblWarning.setText("No se encontraron resultados");
			return null;
		}
	}

	public void fillTable() {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		ResultSet res = searchCredito();
		try {
			if (tipoCredito == 1) {
				while (res.next()) {
					mod.addRow(new Object[] { res.getString("c.id"), res.getString("cp.id"), res.getString("nombre"),
							res.getString("apellido_Paterno"), res.getString("apellido_Materno"),
							res.getString("c.Cantidad_inicial") });
					scrollPane.setVisible(true);
					lblWarning.setText("");
				}

			} else {
				while (res.next()) {
					mod.addRow(new Object[] { res.getString("c.id"), res.getString("cp.id"), res.getString("cp.nombre"),
							res.getString("c.Cantidad_inicial") });
					scrollPane.setVisible(true);
					lblWarning.setText("");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			lblWarning.setText("No se encontraron resultados");
			scrollPane.setVisible(false);
		}

	}

	public ResultSet getClientById(int id) {
		try {
			return c.query("SELECT * FROM clientes_Personal WHERE id = " + id + ";");
		} catch (Exception ex) {
			ex.printStackTrace();
			lblWarning.setText("No se ha seleccionado algun elemento");
		}
		return null;
	}
	
	public ResultSet buscarTarjetonPersonal() {
		int index = table.getSelectedRow();
		 int id = Integer.parseInt(table.getModel().getValueAt(index,0).toString());
		try {
			return c.query("SELECT * FROM tarjeton_Personal tp LEFT JOIN clientes_personal cp on tp.id_Cliente = cp.id LEFT JOIN credito_Personal cep on cep.id = tp.id_credito WHERE tp.id_Credito = "+id+" ;");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ResultSet buscarTarjetonGrupal() {
		int index = table.getSelectedRow();
		 int id = Integer.parseInt(table.getModel().getValueAt(index,0).toString());
		try {
			return c.query("SELECT * FROM tarjeton_Grupal tp LEFT JOIN grupos cp on tp.id_Grupo = cp.id LEFT JOIN credito_Grupal cep on cep.id = tp.id_credito WHERE tp.id_Credito = "+id+" ;");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public int tipoDuracionPorCredito(int idCredito,int tipoCredito) {
		ResultSet rs;
		
		try {
			if(tipoCredito == 1) {
				rs = c.query("SELECT *FROM credito_personal WHERE id = "+idCredito+";");
				if(rs.next()) {
					return rs.getInt("Tipo_Credito");
				}
			}else {
				rs = c.query("SELECT * FROM credito_grupal WHERE id = "+idCredito+";");
				if(rs.next()) {
					return rs.getInt("Tipo_Credito");
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public ResultSet clienteCreditoPorCredito(int idCredito, int tipoCredito) {
		ResultSet rs;
		try {
			if(tipoCredito == 1) {
				rs = c.query("SELECT * FROM credito_personal cp LEFT JOIN clientes_Personal clip on cp.id_Cliente = clip.id WHERE cp.id = "+idCredito+";");
				if(rs.next()) {
					return rs;
				}
			}else {
				rs = c.query("SELECT * FROM credito_grupal cp LEFT JOIN clientes_grupo clip on cp.id_grupo = clip.id WHERE cp.id = "+idCredito+";");
				if(rs.next()) {
					return rs;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
