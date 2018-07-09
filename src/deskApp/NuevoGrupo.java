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
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NuevoGrupo extends JFrame implements ActionListener, MouseListener {

	Style s = new Style();
	JButton btnBack, btnNext, btnAsignar, btnRemover;
	JLabel lblHeader, lblClientesHeader, lblNombre, lblNombreWarning;
	private JPanel contentPane;
	JScrollPane scrollPane;
	int idUser;
	Conexion c = new Conexion();
	Alert alCreate = new Alert();
	Alert alOk = new Alert();
	JTextField txtNombre;
	JScrollPane spClientesExistentes, spClientesAgregados;
	JTable tableClientesExistentes, tableClientesAgregados;
	private JLabel lblWarning;

	NuevoGrupo() {

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

		lblHeader = new JLabel("Nuevo Grupo");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);

		txtNombre = new JTextField();
		txtNombre.setForeground(Color.WHITE);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent k) {
				if (grupoExistente()) {
					lblNombreWarning.setText("Este grupo ya existe");
					mostrarGrupo(txtNombre.getText());

				} else {
					lblNombreWarning.setText("Nombre disponible");
					DefaultTableModel mod = (DefaultTableModel) tableClientesAgregados.getModel();
					mod.setRowCount(0);
				}
			}
		});
		txtNombre.setBounds(10, 106, 410, 33);
		pnHeader.add(txtNombre);
		txtNombre.setColumns(10);
		s.mdTextField(txtNombre, Color.white, s.blue);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNombre.setBounds(10, 81, 210, 14);
		pnHeader.add(lblNombre);

		lblNombreWarning = new JLabel("");
		lblNombreWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNombreWarning.setBounds(430, 125, 135, 14);
		pnHeader.add(lblNombreWarning);

		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblWarning.setBounds(62, 56, 426, 14);
		pnHeader.add(lblWarning);
		lblWarning.setForeground(s.red);

		lblClientesHeader = new JLabel("Clientes Existentes");
		lblClientesHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblClientesHeader.setBounds(10, 161, 212, 27);
		mainPanel.add(lblClientesHeader);

		spClientesExistentes = new JScrollPane();
		spClientesExistentes.setBounds(10, 211, 230, 158);
		mainPanel.add(spClientesExistentes);

		tableClientesExistentes = new JTable();
		tableClientesExistentes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id", "Nombre", "Apellido P", "Apellido M", "Celular" }));
		spClientesExistentes.setViewportView(tableClientesExistentes);

		spClientesAgregados = new JScrollPane();
		spClientesAgregados.setBounds(353, 211, 230, 158);
		mainPanel.add(spClientesAgregados);
		tableClientesAgregados = new JTable();
		spClientesAgregados.setViewportView(tableClientesAgregados);
		spClientesAgregados.getViewport().setBackground(Color.white);
		spClientesExistentes.getViewport().setBackground(Color.white);

		btnAsignar = new JButton("Asignar");
		btnAsignar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnAsignar.setBounds(250, 247, 93, 33);
		mainPanel.add(btnAsignar);
		s.mdButton(btnAsignar, s.blue);

		btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnRemover.setBounds(250, 303, 93, 33);
		mainPanel.add(btnRemover);
		s.mdButton(btnRemover, s.red);

		JLabel lblClientesEnGrupo = new JLabel("Clientes en grupo");
		lblClientesEnGrupo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblClientesEnGrupo.setBounds(353, 161, 212, 27);
		mainPanel.add(lblClientesEnGrupo);

		s.mdTable(tableClientesExistentes, Color.WHITE, Color.white);
		s.mdTable(tableClientesAgregados, Color.WHITE, Color.white);

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

	public Boolean grupoExistente() {
		try {
			return c.query("SELECT * FROM grupos WHERE nombre ='" + txtNombre.getText() + "'").next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public ResultSet clientesExistentes() {
		try {
			return c.query("SELECT * FROM clientes_personal");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void mostrarClientesExistentes() {
		DefaultTableModel mod = (DefaultTableModel) tableClientesExistentes.getModel();
		mod.setRowCount(0);
		ResultSet res = clientesExistentes();
		try {
			while (res.next()) {
				mod.addRow(
							new Object[] { res.getString("id"), res.getString("nombre"), res.getString("apellido_Paterno"),
									res.getString("apellido_Materno"), res.getString("Telefono_Cel") });
					spClientesExistentes.setVisible(true);
					lblWarning.setText("");
				
			}
	
		} catch (SQLException e) {
				e.printStackTrace();
				lblWarning.setText("No se encontraron resultados");
				spClientesExistentes.setVisible(false);
		}
		
		
	}

	public ResultSet clientesPorGrupo(String nombre) {
		try {
			return c.query(
					"SELECT cp.id,cp.nombre,cp.Apellido_Paterno ap1,cp.Apellido_Materno ap2 ,cp.Telefono_Cel tel FROM grupos g LEFT JOIN clientes_grupo cg on g.id = cg.id_grupo LEFT JOIN clientes_Personal cp on  cg.id_Cliente = cp.id WHERE g.nombre = '"
							+ nombre + "';");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void mostrarGrupo(String nombre) {
		DefaultTableModel mod = (DefaultTableModel) tableClientesAgregados.getModel();
		mod.setRowCount(0);
		ResultSet res = clientesPorGrupo(nombre);
		try {
			while (res.next()) {
				mod.addRow(
						new Object[] { res.getString("id"), res.getString("nombre"), res.getString("ap1"),
								res.getString("ap2"), res.getString("tel") });
				lblWarning.setText("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			mod.setRowCount(0);
		}
	}

	public void crearGrupo(String nombre) {
		try {
			c.update("INSERT INTO grupos (nombre,fecha_Creacion) VALUES ('" + nombre + "',CURDATE())");
			ResultSet idGrupo = c.query("SELECT id FROM grupos WHERE nombre = '" + nombre + "';");
			if (idGrupo.next()) {
				DefaultTableModel mod = (DefaultTableModel) tableClientesAgregados.getModel();
				mod.setRowCount(0);
				for (int i = 0; i < mod.getRowCount(); i++) {
					
						c.update("INSERT INTO clientes_grupo (id_Grupo,id_Cliente) VALUES (" + idGrupo.getInt("id")
								+ "," + Integer.parseInt(mod.getValueAt(i, 0).toString()) + ")");
					

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean clienteYaEnGrupo(String nombre, String ap1, String ap2, int idGrupo) {
		try {
			return c.query(
					"SELECT * FROM clientes_grupo cg LEFT JOIN clientes_Personal cp on cp.id = cg.id_Cliente WHERE cp.nombre = '"
							+ nombre + "' AND cp.apellido_Paterno = '" + ap1 + "' AND cp.apellido_Materno = '" + ap2
							+ "' AND cg.id_Grupo = '" + idGrupo + "';")
					.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public void asignarCliente() {

	}

	public int idGrupoPorNombre(String nombre) {
		try {
			ResultSet rs = c.query("SELECT * FROM grupos WHERE nombre = '" + nombre + "';");
			return rs.getInt("id");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

}
