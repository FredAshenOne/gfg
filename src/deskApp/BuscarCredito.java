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

public class BuscarCredito extends JFrame implements ActionListener, MouseListener, KeyListener {

	Style s = new Style();
	JButton btnBack, btnNext;
	JLabel lblHeader;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	JScrollPane scrollPane;
	int idUser;
	Conexion c = new Conexion();
	private JLabel lblWarning;
	Alert alCreate = new Alert();
	Alert alOk = new Alert();

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
		txtSearch.setForeground(Color.WHITE);
		txtSearch.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtSearch.setBounds(100, 79, 447, 60);
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
		txtSearch.addKeyListener(this);
		table = new JTable();

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "id Cliente","id Credito", "Nombre", "Apellido Paterno", "Apellido Materno", "Cantidad" }) {
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
			
		}

	}

	public ResultSet searchCredito() {
		try {
			String data = txtSearch.getText();
			String[] nombre = data.split(" ");
			if (nombre.length > 2) {
				return c.query("SELECT * FROM clientes_personal cp LEFT JOIN credito c on cp.id = c.id_Cliente WHERE cp.nombre = '" + nombre[0]
						+ "' AND cp.apellido_paterno = '" + nombre[1] + "' AND cp.apellido_materno = '" + nombre[2] + "';");
			} else if (nombre.length == 2) {
				return c.query("SELECT * FROM clientes_personal cp LEFT JOIN credito c on cp.id = c.id_Cliente credito c WHERE  cp.nombre = '" + nombre[0]
						+ "' AND cp.apellido_Paterno = '" + nombre[1] + "' OR (cp.apellido_Paterno = '" + nombre[0]
						+ "' AND cp.apellido_Materno = '" + nombre[1] + "');");
			} else if (nombre.length == 1) {
				try {
					int id = Integer.parseInt(data);
					return c.query("SELECT * FROM clientes_personal cp LEFT JOIN credito c on cp.id = c.id_Cliente WHERE cp.id = " + id + " OR c.id = "+id+";");
				} catch (NumberFormatException nfe) {
					return c.query("SELECT * FROM clientes_personal cp LEFT JOIN credito c on cp.id = c.id_Cliente WHERE cp.nombre LIKE '%" + nombre[0]
							+ "%' OR cp.apellido_Paterno LIKE '%" + nombre[0] + "%' OR cp.apellido_Materno LIKE '%"
							+ nombre[0] + "%';");
				}
			} else {
				lblWarning.setText("No se encontraron resultados");
				return null;
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
		ResultSet resv = searchCredito();
		try {
			if (resv.next()) {
				while (res.next()) {
					mod.addRow(new Object[] { res.getString("id"),res.getString("c.id"), res.getString("nombre"),
							res.getString("apellido_Paterno"), res.getString("apellido_Materno"),
							res.getString("c.Cantidad_inicial") });
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

	public ResultSet getClientById(int id) {
		try {
			return c.query("SELECT * FROM clientes_Personal WHERE id = " + id + ";");
		} catch (Exception ex) {
			ex.printStackTrace();
			lblWarning.setText("No se ha seleccionado algun elemento");
		}
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_ENTER) {
			fillTable();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
