package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class BuscarRenovacion extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	Style s = new Style();
	JButton btnBack, btnNext, btnPersonal, btnGrupal;
	JLabel lblHeader;
	public JTextField txtSearch;
	private JTable table;
	JScrollPane scrollPane;
	int idUser;
	int tipoCredito = 1, tipoDuracion = 1;
	Conexion c = new Conexion();
	private JLabel lblWarning;
	Alert alCreate = new Alert();

	public BuscarRenovacion() {

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
		table = new JTable() {
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

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void fillTable() {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		ResultSet res = searchCredito();
		
		try {
			if(res.next()) {
				System.out.println("si tiene elementos"+res.getString("nombre"));
			}
			if (tipoCredito == 1) {
				while (res.next()) {
					System.out.println(res.getString("nombre") + "si hay resultset");
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

	public ResultSet searchCredito() {
		try {
			String data = txtSearch.getText();
			String[] nombre = data.split(" ");
			if (nombre.length > 2) {
				return c.query("SELECT * FROM credito_personal cp"
						+ "LEFT JOIN clientes_personal c ON c.id = cp.id_cliente"
						+ "LEFT JOIN (SELECT COUNT(STATUS) pagos,id_cliente,id_credito FROM tarjeton_personal WHERE STATUS = 1 GROUP BY id_credito ) AS tabla ON cp.id = tabla.id_credito"
						+ "WHERE pagos > 5 AND (c.nombre LIKE '%" + nombre[0] + "%' AND c.apellido_paterno LIKE '%"+ nombre[1] + "%' "
						+ "AND c.apellido_materno LIKE '%" + nombre[2] + "%');");
			} else if (nombre.length == 2) {
				return c.query("SELECT * FROM credito_personal cp"
						+ "LEFT JOIN clientes_personal c ON c.id = cp.id_cliente"
						+ "LEFT JOIN (SELECT COUNT(STATUS) pagos,id_cliente,id_credito FROM tarjeton_personal WHERE STATUS = 1 GROUP BY id_credito ) AS tabla ON cp.id = tabla.id_credito"
						+ "WHERE pagos > 5 AND (c.nombre LIKE '%" + nombre[0] + "%' AND c.apellido_Paterno LIKE '%"
						+ nombre[1] + "%' OR (c.apellido_Paterno LIKE '%" + nombre[0]+"%'"
						+ "AND c.apellido_Materno LIKE '%" + nombre[1] + "%'));");
			} else if (nombre.length == 1) {
				System.out.println(nombre[0]);

				try {
					int id = Integer.parseInt(data);
					if (tipoCredito == 1) {
						return c.query("SELECT * FROM credito_personal cp"
								+ "LEFT JOIN clientes_personal c ON c.id = cp.id_cliente"
								+ "LEFT JOIN (SELECT COUNT(STATUS) pagos,id_cliente,id_credito FROM tarjeton_personal WHERE STATUS = 1 GROUP BY id_credito ) AS tabla ON cp.id = tabla.id_credito"
								+ "WHERE pagos > 5 AND (c.id = " + id + " OR cp.id = " + id + ");");
					} else {
						return c.query("SELECT * FROM credito_grupal cp LEFT JOIN grupos c ON c.id = cp.id_grupo"
								+ "LEFT JOIN (SELECT COUNT(STATUS) pagos,id_grupo,id_credito FROM tarjeton_grupal WHERE STATUS = 1 GROUP BY id_credito ) AS tabla ON cp.id = tabla.id_credito"
								+ "WHERE pagos > 5  AND (cp.id = " + id + " OR c.id = " + id + ");");
					}

				} catch (NumberFormatException nfe) {
					if (tipoCredito == 1) {
						ResultSet rs;
						rs = c.query("SELECT * FROM credito_personal cp LEFT JOIN clientes_personal c ON c.id = cp.id_cliente "
								+ "LEFT JOIN (SELECT COUNT(STATUS) pagos,id_cliente,id_credito FROM tarjeton_personal WHERE STATUS = 1 GROUP BY id_credito ) AS tabla ON cp.id = tabla.id_credito"
								+ "WHERE pagos > 5  AND (c.nombre LIKE '%"+ nombre[0]+"%' OR c.apellido_Paterno LIKE '%"+ nombre[0]+"%'"
								+ "OR c.apellido_Materno LIKE '%"+ nombre[0] +"%');");
						System.out.println("aca termina");
						try {
							if(rs.next()) {
								
								System.out.println("si tiene resultados "+ rs.getString("nombre"));
								
							}
						}catch(Exception ex) {
							ex.printStackTrace();
						}
						return rs;
					} else {
						return c.query("SELECT * FROM credito_grupal cp LEFT JOIN grupos c ON c.id = cp.id_grupo"
								+ "LEFT JOIN (SELECT COUNT(STATUS) pagos,id_grupo,id_credito FROM tarjeton_grupal WHERE STATUS = 1 GROUP BY id_credito ) AS tabla ON cp.id = tabla.id_credito"
								+ "WHERE pagos > 5  AND c.nombre LIKE '%" + data + "%';");
					}

				}
			} else {
				if (tipoCredito == 1) {
					return c.query(
							"SELECT * FROM credito_personal cp LEFT JOIN clientes_personal c ON c.id = cp.id_cliente"
									+ "LEFT JOIN (SELECT COUNT(STATUS) pagos,id_cliente,id_credito FROM tarjeton_personal WHERE STATUS = 1 GROUP BY id_credito ) AS tabla ON cp.id = tabla.id_credito\r\n"
									+ "WHERE pagos > 5 ");
				} else {

					return c.query("SELECT * FROM credito_grupal cp LEFT JOIN grupos c ON c.id = cp.id_grupo "
							+ "LEFT JOIN (SELECT COUNT(STATUS) pagos,id_grupo,id_credito FROM tarjeton_grupal WHERE STATUS = 1 GROUP BY id_credito ) AS tabla ON cp.id = tabla.id_credito"
							+ "WHERE pagos > 5 ;");
				}

			}
		} catch (Exception ex) {
			lblWarning.setText("No se encontraron resultados");
			return null;
		}
	}
}