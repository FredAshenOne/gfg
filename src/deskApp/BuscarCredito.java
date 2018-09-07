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
	MostrarCreditoMensual mcm = new MostrarCreditoMensual();
	Conexion c = new Conexion();
	Alert alCreate = new Alert();
	MostrarTarjeton mt = new MostrarTarjeton();
	
	JButton btnPersonal, btnGrupal;
	private JPanel contentPane;
	public JTextField txtSearch;
	private JTable table;
	JScrollPane scrollPane;
	int idUser;
	MdHeader pnHeader;
	int tipoCredito = 1,tipoDuracion = 1;
	
	public BuscarCredito() {
		setBounds(100,100,1135,827);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1134, 800);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel,Color.white);
		
		//Header 
		
		pnHeader = new MdHeader(s.blue,Color.white);
		mainPanel.add(pnHeader);
		pnHeader.btnNext.setEnabled(false);

		// Panel de Contenido 
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(54, 267, 1034, 500);
		mainPanel.add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setBackground(Color.WHITE);
		table = new JTable(){
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};					
		scrollPane.setVisible(false);
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Credito", "Cliente", "Nombre", "A. Paterno", "A. Materno", "Cantidad" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		table.setModel(model);
		s.mdTable(table, s.w, s.blue, s.w);	
		table.addMouseListener(this);	

		btnPersonal = new JButton("Personal");
		btnPersonal.setBounds(996, 195, 46, 32);
		mainPanel.add(btnPersonal);
		btnPersonal.setForeground(s.blue);
		btnPersonal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnPersonal.setBorder(null);
		s.btnHover(btnPersonal, s.blue, s.blue, s.w);
		
		btnGrupal = new JButton("Grupal");
		btnGrupal.setBounds(1042, 195, 46, 32);
		mainPanel.add(btnGrupal);
		btnGrupal.setForeground(s.blue);
		btnGrupal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnGrupal.setBorder(null);
		btnGrupal.addActionListener(this);
		btnGrupal.addMouseListener(this);
		s.btnHover(btnGrupal, s.w,s.w,s.blue);
				
		JLabel lblSearchIcon = new JLabel("");
		lblSearchIcon.setBounds(54, 165, 46, 62);
		mainPanel.add(lblSearchIcon);
		lblSearchIcon.setIcon(new ImageIcon("views/search2.png"));
		lblSearchIcon.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
				
		txtSearch = new JTextField();
		txtSearch.setBounds(100, 167, 844, 60);
		mainPanel.add(txtSearch);
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(tipoCredito == 1) {
					fillTable(buscarCreditoPersonal());	
				}else {
						fillTable(buscarCreditoGrupal());
					}
				}
			});
		txtSearch.setForeground(s.blue);
		txtSearch.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtSearch.setColumns(10);
		s.mdTextField(txtSearch, s.blue, s.w);
		txtSearch.setCaretColor(s.blue);
		s.myTextPrompt(txtSearch, "Buscar: (id cliente o Nombre)", s.blue);
		txtSearch.setBorder(BorderFactory.createCompoundBorder(txtSearch.getBorder(),
				BorderFactory.createEmptyBorder(7, 10, 10, 5)));
		btnPersonal.addActionListener(this);
		btnPersonal.addMouseListener(this);
		mcm.lblCantidad.setText("Total");
		
		
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				pnHeader.btnNext.setEnabled(!lsm.isSelectionEmpty());
			}
		});
		
		mt.btnBack.addActionListener(this);
		mcm.btnBack.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnGrupal) {
			if (tipoCredito == 1) {
				s.btnHover(btnGrupal, s.blue,s.w,s.blue);
			} else {
				s.btnHover(btnGrupal, s.blue, s.blue, s.w);
			}

		} else if (e.getSource() == btnPersonal) {
			if (tipoCredito == 2) {
				s.btnHover(btnPersonal, s.blue, s.w, s.blue);
			} else {
				s.btnHover(btnPersonal, s.blue, s.blue, s.w);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnPersonal) {
			if (tipoCredito == 1) {
				s.btnHover(btnPersonal, s.blue, s.blue, s.w);
			} else {
				s.btnHover(btnPersonal, s.w, s.w,s.blue);
			}
		} else if (e.getSource() == btnGrupal) {
			if (tipoCredito == 2) {
				s.btnHover(btnGrupal, s.blue, s.blue, s.w);
			} else {
				s.btnHover(btnGrupal, s.w, s.w, s.blue);
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
		if (e.getSource() == pnHeader.btnNext) {
			
			this.setVisible(false);
			int index = table.getSelectedRow();
			int id = Integer.parseInt(table.getModel().getValueAt(index,0).toString());
			tipoDuracion = tipoDuracionPorCredito(id,tipoCredito);
			ResultSet cred = clienteCreditoPorCredito(id,tipoCredito);
			if(tipoCredito == 1) {
				
				if(tipoDuracion != 3) {
					mt.llenarTabla(buscarTarjetonPersonal());

					mt.setVisible(true);
				}else {
					try {
						mcm.llenarDatos(cred.getString("cp.id"), cred.getString("clip.Nombre") +" " +cred.getString("clip.Paterno") +" " +cred.getString("clip.Materno"), cred.getString("cp.Total"),cred.getString("cp.Intereses") , cred.getString("cp.fecha_Inicio"));
						mcm.setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
			}else {
				if(tipoDuracion !=3) {
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
				table.getColumnModel().getColumn(1) .setHeaderValue("Grupo");
				table.getColumnModel().getColumn(2).setHeaderValue("Nombre");
				table.getColumnModel().getColumn(3).setHeaderValue("Cantidad");
				table.getColumnModel().getColumn(4).setHeaderValue("");
				table.getColumnModel().getColumn(5).setHeaderValue("");
				s.btnHover(btnPersonal, s.w, s.w, s.blue);
				s.btnHover(btnGrupal, s.blue, s.blue, s.w);
				btnGrupal.setSelected(false);
				fillTable(buscarCreditoGrupal());
				table.getTableHeader().repaint();
			}
		} else if (e.getSource() == btnPersonal) {
			if (tipoCredito == 2) {
				tipoCredito = 1;
				table.getColumnModel().getColumn(1).setHeaderValue("Cliente");
				table.getColumnModel().getColumn(2).setHeaderValue("Nombre");
				table.getColumnModel().getColumn(3).setHeaderValue("A. Paterno");
				table.getColumnModel().getColumn(4).setHeaderValue("A. Materno");
				table.getColumnModel().getColumn(5).setHeaderValue("Cantidad");				
				s.btnHover(btnGrupal, s.w, s.w, s.blue);
				s.btnHover(btnPersonal, s.blue, s.blue, s.w);
				btnPersonal.setSelected(false);
				table.getTableHeader().repaint();
				fillTable(buscarCreditoPersonal());
				
			
			}
		}else if(e.getSource() == mt.btnBack){
			this.setVisible(true);
			mt.setVisible(false);
		}else if(e.getSource() == mcm.btnBack) {
			this.setVisible(true);
			mcm.setVisible(false);
		}

	}

// busca los la informacion de los clientes que tengan credito activo dependiendo lo que este escrito en la barra
	public ResultSet buscarCreditoPersonal() {
		String data = txtSearch.getText();
		try {
			if(data.length()>0) {
				String[] nombre = data.split(" ");
				if(nombre.length >= 2) {
					return c.query(
							"SELECT * FROM clientes_personal cp LEFT JOIN credito_Personal c on cp.id = c.id_Cliente WHERE c.status = 1 AND cp.nombre LIKE '%"
									+ nombre[0] + "%' AND cp.paterno LIKE '%" + nombre[1]
									+ "%' AND cp.materno LIKE '%" + nombre[2] + "%';");
					
				}else if(nombre.length == 1) {
					if(Style.isNumeric(data)) {
						int id = Integer.parseInt(data);
							return c.query(
									"SELECT * FROM clientes_personal cp LEFT JOIN credito_Personal c on cp.id = c.id_Cliente WHERE c.status = 1 AND cp.id = "
											+ id + " OR c.id = " + id + ";");
					}else {
						return c.query(
								"SELECT * FROM clientes_personal cp LEFT JOIN credito_Personal c on cp.id = c.id_Cliente WHERE c.status = 1 AND c.id IS NOT NULL AND (cp.nombre LIKE '%"
										+ data + "%' OR cp.Paterno LIKE '%" + data
										+ "%' OR cp.Materno LIKE '%" + data + "%');");
					}
				}
				
			}else {
				return c.query(
						"SELECT * FROM clientes_personal cp LEFT JOIN credito_Personal c on cp.id = c.id_Cliente WHERE c.status = 1 AND c.id IS NOT NULL;");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	// busca en la informacion de creditos dependiendo lo que este escrito 
	
	public ResultSet buscarCreditoGrupal() {
		String data = txtSearch.getText();
		try {
			if(data.length()>0) {
				if(Style.isNumeric(data)) {
					Integer id = Integer.valueOf(data);
					return c.query(
							"SELECT * FROM grupos cp LEFT JOIN credito_grupal c on cp.id = c.id_Cliente WHERE c.status = 1 AND cp.id = "
									+ id + " OR c.id = " + id + ";");
				}else {
					return c.query(
							"SELECT * FROM grupos cp LEFT JOIN credito_grupal c on cp.id = c.id_grupo WHERE c.status = 1 AND c.id IS NOT NULL AND cp.nombre LIKE '%"
									+ data + "%';");
				}
			}else {
				return c.query(
						"SELECT * FROM grupos cp LEFT JOIN credito_grupal c on cp.id = c.id_grupo WHERE c.status = 1 AND c.id IS NOT NULL;");
			}
		}catch(Exception ex) {
			
		}
		return null;
	}
	
	public void fillTable(ResultSet res) {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		
		try {
			if (tipoCredito == 1) {
				while (res.next()) {
					mod.addRow(new Object[] { res.getString("c.id"), res.getString("cp.id"), res.getString("nombre"),
							res.getString("Paterno"), res.getString("Materno"),
							res.getString("c.Cantidad_inicial") });
					scrollPane.setVisible(true);
					pnHeader.lblWarning.setText("");
				}

			} else {
				while (res.next()) {
					mod.addRow(new Object[] { res.getString("c.id"), res.getString("cp.id"), res.getString("cp.nombre"),
							res.getString("c.Cantidad_inicial") });
					scrollPane.setVisible(true);
					pnHeader.lblWarning.setText("");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			pnHeader.lblWarning.setText("No se encontraron resultados");
			scrollPane.setVisible(false);
		}

	}

	public ResultSet getClientById(int id) {
		try {
			return c.query("SELECT * FROM clientes_Personal WHERE id = " + id + ";");
		} catch (Exception ex) {
			ex.printStackTrace();
			pnHeader.lblWarning.setText("No se ha seleccionado algun elemento");
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
				rs = c.query("SELECT * FROM credito_grupal cp LEFT JOIN grupos clip on cp.id_grupo = clip.id"
						+ " WHERE cp.id = "+idCredito+";");
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
