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
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NuevoGrupo extends JFrame implements ActionListener, MouseListener {

	Style s = new Style();
	JButton btnBack, btnNext, btnAsignar, btnRemover, btnEditarGrupo, btnRemoverGrupo;
	JLabel lblHeader, lblClientesHeader, lblNombre, lblNombreWarning, lblEliminar, lblEdit, lblClientesEnGrupo;
	JPanel contentPane, pnHeader, mainPanel;
	JScrollPane scrollPane;
	int idUser;
	Conexion c = new Conexion();
	Alert alRemoverGrupo = new Alert();
	Alert alOk = new Alert();
	Alert alOk2 = alOk;
	Alert alEliminado = new Alert();
	Alert alEditarNombre = new Alert();
	JTextField txtNombre, txtBuscarDisponibles, txtBuscarAgregados, txtEditar;
	String nombreActual;
	JScrollPane spClientesExistentes, spClientesAgregados;
	JTable tableClientesExistentes, tableClientesAgregados;
	TextPrompt tpName;
	private JLabel lblWarning;

	NuevoGrupo() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 593, 380);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.WHITE);

		pnHeader = new JPanel();
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
				mostrarClientesDisponibles(txtNombre.getText());
				if (grupoExistente()) {
					lblNombreWarning.setText("* Grupo Activo");
					mostrarGrupo(txtNombre.getText());
					btnEditarGrupo.setVisible(true);
					btnRemoverGrupo.setVisible(true);
					lblEdit.setVisible(true);
					lblEliminar.setVisible(true);
					lblNombreWarning.setForeground(Color.white);

				} else if (txtNombre.getText().length() == 0) {
					lblNombreWarning.setText("");
					btnEditarGrupo.setVisible(false);
					btnRemoverGrupo.setVisible(false);
					lblEdit.setVisible(false);
					lblEliminar.setVisible(false);
				} else {
					btnEditarGrupo.setVisible(false);
					lblEdit.setVisible(false);
					lblEliminar.setVisible(false);
					btnRemoverGrupo.setVisible(false);
					lblNombreWarning.setText("Nombre disponible");
					DefaultTableModel mod = (DefaultTableModel) tableClientesAgregados.getModel();
					mod.setRowCount(0);
					lblNombreWarning.setForeground(Color.green);
				}

			}
		});
		txtNombre.setCaretColor(Color.white);
		txtNombre.setBounds(10, 106, 410, 33);
		pnHeader.add(txtNombre);
		txtNombre.setColumns(10);
		s.mdTextField(txtNombre, Color.white, s.blue);
		tpName = new TextPrompt("Buscar Grupo", txtNombre);
		tpName.setFont(txtNombre.getFont());
		tpName.setForeground(Color.WHITE);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNombre.setBounds(10, 81, 210, 14);
		pnHeader.add(lblNombre);

		lblNombreWarning = new JLabel("");
		lblNombreWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNombreWarning.setBounds(285, 81, 135, 14);
		pnHeader.add(lblNombreWarning);

		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblWarning.setBounds(62, 56, 426, 14);
		pnHeader.add(lblWarning);
		lblWarning.setForeground(s.red);

		btnEditarGrupo = new JButton("");
		btnEditarGrupo.setBounds(481, 106, 32, 33);
		pnHeader.add(btnEditarGrupo);
		s.btnIcon(btnEditarGrupo, "views/edit.png");
		btnEditarGrupo.addActionListener(this);
		btnEditarGrupo.addMouseListener(this);
		btnEditarGrupo.setVisible(false);

		btnRemoverGrupo = new JButton("");
		btnRemoverGrupo.setBounds(539, 106, 32, 33);
		pnHeader.add(btnRemoverGrupo);
		s.btnIcon(btnRemoverGrupo, "views/trashWhite.png");

		lblEdit = new JLabel("Renombrar");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblEdit.setBounds(455, 84, 74, 12);
		lblEdit.setVisible(false);
		pnHeader.add(lblEdit);

		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblEliminar.setBounds(523, 83, 66, 12);
		pnHeader.add(lblEliminar);
		lblEliminar.setVisible(false);
		btnRemoverGrupo.addActionListener(this);
		btnRemoverGrupo.addMouseListener(this);
		btnRemoverGrupo.setVisible(false);

		lblClientesHeader = new JLabel("Clientes Existentes");
		lblClientesHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblClientesHeader.setBounds(10, 161, 212, 27);
		mainPanel.add(lblClientesHeader);

		spClientesExistentes = new JScrollPane();
		spClientesExistentes.setBounds(10, 211, 230, 158);
		mainPanel.add(spClientesExistentes);

		tableClientesExistentes = new JTable() {
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		tableClientesExistentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableClientesExistentes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id", "Nombre", "Apellido P", "Apellido M", "Celular" }));
		spClientesExistentes.setViewportView(tableClientesExistentes);

		spClientesAgregados = new JScrollPane();
		spClientesAgregados.setBounds(353, 211, 230, 158);
		mainPanel.add(spClientesAgregados);
		tableClientesAgregados = new JTable(){
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		tableClientesAgregados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableClientesAgregados.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id", "Nombre", "A.Paterno", "A.Materno", "Celular" }));
		spClientesAgregados.setViewportView(tableClientesAgregados);
		spClientesAgregados.getViewport().setBackground(Color.white);
		spClientesExistentes.getViewport().setBackground(Color.white);

		btnAsignar = new JButton("Asignar");
		btnAsignar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnAsignar.setBounds(250, 247, 93, 33);
		mainPanel.add(btnAsignar);
		s.mdButton(btnAsignar, s.blue);
		btnAsignar.setEnabled(false);
		btnAsignar.addActionListener(this);
		btnAsignar.addMouseListener(this);

		btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnRemover.setBounds(250, 303, 93, 33);
		mainPanel.add(btnRemover);
		btnRemover.setEnabled(false);
		s.mdButton(btnRemover, s.red);
		btnRemover.addActionListener(this);
		btnRemover.addMouseListener(this);

		lblClientesEnGrupo = new JLabel("Clientes en grupo");
		lblClientesEnGrupo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblClientesEnGrupo.setBounds(353, 161, 212, 27);
		mainPanel.add(lblClientesEnGrupo);

		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Grupo creado con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);

		alEliminado.btnCancel.setVisible(false);
		alEliminado.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alEliminado.lblMessage.setText("Datos eliminados correctamente");
		alEliminado.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alEliminado.btnOk.setText("Ok");
		alEliminado.btnOk.addActionListener(this);

		alRemoverGrupo.lblMessage.setText("Se borrara el grupo, desea continuar?");
		alRemoverGrupo.btnCancel.setText("Cancelar");
		alRemoverGrupo.btnOk.setText("Continuar");
		alRemoverGrupo.btnOk.addActionListener(this);
		alRemoverGrupo.btnCancel.addActionListener(this);
		alRemoverGrupo.lblAlertIcon.setIcon(new ImageIcon("views/alert.png"));

		alEditarNombre.btnCancel.setText("Cancelar");
		alEditarNombre.btnOk.setText("Guardar");
		alEditarNombre.btnOk.addActionListener(this);
		alEditarNombre.btnCancel.addActionListener(this);
		alEditarNombre.lblMessage.setVisible(false);
		
		txtEditar = new JTextField();
		txtEditar.setBounds(alEditarNombre.lblMessage.getBounds());
		alEditarNombre.mainPanel.add(txtEditar);
		s.mdTextField(txtEditar, s.blue, Color.WHITE);
		s.myTextPrompt(txtEditar, "Nuevo Nombre", Color.LIGHT_GRAY);
		
		s.mdTable(tableClientesExistentes, Color.WHITE, Color.white);
		s.mdTable(tableClientesAgregados, Color.WHITE, Color.white);

		txtBuscarDisponibles = new JTextField();
		txtBuscarDisponibles.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		txtBuscarDisponibles.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				buscarExistente(txtNombre.getText());
			}
		});
		txtBuscarDisponibles.setBounds(10, 186, 149, 20);
		mainPanel.add(txtBuscarDisponibles);
		txtBuscarDisponibles.setColumns(10);
		s.mdTextField(txtBuscarDisponibles, s.blue, Color.white);
		s.myTextPrompt(txtBuscarDisponibles, "Buscar", Color.LIGHT_GRAY);

		txtBuscarAgregados = new JTextField();
		txtBuscarAgregados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				buscarAgregado(txtNombre.getText());
			}
		});
		txtBuscarAgregados.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		txtBuscarAgregados.setColumns(10);
		txtBuscarAgregados.setBounds(353, 186, 149, 20);
		mainPanel.add(txtBuscarAgregados);
		s.mdTextField(txtBuscarAgregados, s.blue, Color.WHITE);
		s.myTextPrompt(txtBuscarAgregados, "Buscar", Color.LIGHT_GRAY);

		ListSelectionModel listSelectionModel = tableClientesExistentes.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				btnAsignar.setEnabled(!lsm.isSelectionEmpty());
			}
		});

		ListSelectionModel listSelectionModel1 = tableClientesAgregados.getSelectionModel();
		listSelectionModel1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm1 = (ListSelectionModel) e.getSource();
				btnRemover.setEnabled(!lsm1.isSelectionEmpty());
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
		} else if (e.getSource() == btnRemover) {
			if (btnRemover.isEnabled()) {
				s.hoverBorder(btnRemover, Color.WHITE);
				s.btnPointer(btnRemover);
			}
		} else if (e.getSource() == btnAsignar) {
			if (btnAsignar.isEnabled()) {
				s.hoverBorder(btnAsignar, Color.WHITE);
				s.btnPointer(btnAsignar);
			}
		} else if (e.getSource() == btnRemoverGrupo) {
			s.hoverBorder(btnRemoverGrupo, Color.WHITE);
			s.btnPointer(btnRemoverGrupo);
		} else if (e.getSource() == btnEditarGrupo) {
			s.hoverBorder(btnEditarGrupo, Color.WHITE);
			s.btnPointer(btnEditarGrupo);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnAsignar) {
			btnAsignar.setBorder(null);
		} else if (e.getSource() == btnRemover) {
			btnRemover.setBorder(null);
		} else if (e.getSource() == btnBack) {
			btnBack.setBorder(null);
		} else if (e.getSource() == btnRemoverGrupo) {
			btnRemoverGrupo.setBorder(null);
		} else if (e.getSource() == btnEditarGrupo) {
			btnEditarGrupo.setBorder(null);
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
		if (e.getSource() == btnAsignar) {
			if (grupoExistente()) {
				asignarCliente(idGrupoPorNombre(txtNombre.getText()));
				mostrarClientesDisponibles(txtNombre.getText());
				mostrarGrupo(txtNombre.getText());
			} else {
				if (txtNombre.getText().length() > 0) {
					crearGrupo(txtNombre.getText());
					asignarCliente(idGrupoPorNombre(txtNombre.getText()));
					alOk.setVisible(true);
					mostrarClientesDisponibles(txtNombre.getText());
					mostrarGrupo(txtNombre.getText());
					lblNombreWarning.setText("* Grupo Activo");
					lblNombreWarning.setForeground(Color.white);
					btnEditarGrupo.setVisible(true);
					btnRemoverGrupo.setVisible(true);;
				}
			}

		} else if (e.getSource() == alOk.btnOk) {
			mostrarClientesDisponibles(txtNombre.getText());
			alOk.setVisible(false);

		} else if (e.getSource() == btnRemover) {
			removerCliente(idGrupoPorNombre(txtNombre.getText()));
			mostrarGrupo(txtNombre.getText());
			mostrarClientesDisponibles(txtNombre.getText());
		} else if (e.getSource() == btnRemoverGrupo) {
			alRemoverGrupo.setVisible(true);
		} else if (e.getSource() == alRemoverGrupo.btnOk) {
			removerGrupo();
			alRemoverGrupo.setVisible(false);
			alEliminado.setVisible(true);
		} else if (e.getSource() == alEliminado.btnOk) {
			alEliminado.setVisible(false);
			txtNombre.setText("");
			lblNombreWarning.setText("");
			btnRemoverGrupo.setVisible(false);
			btnEditarGrupo.setVisible(false);
			mostrarClientesExistentes();
			DefaultTableModel mod = (DefaultTableModel) tableClientesAgregados.getModel();
			mod.setRowCount(0);
		} else if (e.getSource() == btnEditarGrupo) {
			nombreActual = txtNombre.getText();
			alEditarNombre.setVisible(true);
			mainPanel.setEnabled(false);
		} else if (e.getSource() == alEditarNombre.btnCancel) {
			alEditarNombre.setVisible(false);
			mainPanel.setEnabled(true);
		} else if (e.getSource() == alEditarNombre.btnOk) {
			editarGrupo();
			System.out.println(nombreActual +" nombre actual " + txtEditar.getText());
			txtNombre.setText(txtEditar.getText());
			alEditarNombre.setVisible(false);
			alOk2.setVisible(true);
			alOk2.lblMessage.setText("Datos guardados exitosamente");
		}
	}

	public Boolean grupoExistente() {
		try {
			return c.query("SELECT * FROM grupos where nombre = '" + txtNombre.getText() + "';").next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public void mostrarClientesExistentes() {
		DefaultTableModel mod = (DefaultTableModel) tableClientesExistentes.getModel();
		mod.setRowCount(0);
		ResultSet res = c.query("SELECT * FROM clientes_personal");
		try {
			while (res.next()) {
				if (res.getString("nombre") != null) {
					mod.addRow(new Object[] { res.getString("id"), res.getString("nombre"),
							res.getString("apellido_Paterno"), res.getString("apellido_Materno"),
							res.getString("Telefono_Cel") });
					spClientesExistentes.setVisible(true);
					lblWarning.setText("");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void mostrarClientesDisponibles(String nombreGrupo) {

		DefaultTableModel mod = (DefaultTableModel) tableClientesExistentes.getModel();
		mod.setRowCount(0);
		try {
			ResultSet res = c.query(
					"SELECT * FROM clientes_Personal cp WHERE cp.id NOT IN (SELECT cps.id FROM clientes_Personal cps LEFT JOIN clientes_grupo cgs ON cps.id = cgs.id_Cliente WHERE cgs.id_Grupo = "
							+ idGrupoPorNombre(nombreGrupo) + ");");

			while (res.next()) {
				if (res.getString("cp.nombre") != null) {
					mod.addRow(new Object[] { res.getString("id"), res.getString("nombre"),
							res.getString("apellido_Paterno"), res.getString("apellido_Materno"),
							res.getString("Telefono_Cel") });
					spClientesExistentes.setVisible(true);
					lblWarning.setText("");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void mostrarGrupo(String nombre) {
		DefaultTableModel mod = (DefaultTableModel) tableClientesAgregados.getModel();
		mod.setRowCount(0);
		ResultSet res = c.query(
				"SELECT cp.id,cp.nombre,cp.Apellido_Paterno ap1,cp.Apellido_Materno ap2 ,cp.Telefono_Cel tel FROM grupos g LEFT JOIN clientes_grupo cg on g.id = cg.id_grupo LEFT JOIN clientes_Personal cp on  cg.id_Cliente = cp.id WHERE g.nombre = '"
						+ nombre + "';");
		try {
			while (res.next()) {
				if (res.getString("cp.nombre") != null) {
					mod.addRow(new Object[] { res.getString("id"), res.getString("nombre"), res.getString("ap1"),
							res.getString("ap2"), res.getString("tel") });
					lblWarning.setText("");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			mod.setRowCount(0);
		}

	}

	public void crearGrupo(String nombre) {
		try {
			c.update("INSERT INTO grupos (nombre,fecha_Creacion) VALUES ('" + nombre + "',CURDATE())");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void asignarCliente(int idGrupo) {
		int row = tableClientesExistentes.getSelectedRow();
		int idCliente = Integer.parseInt(tableClientesExistentes.getModel().getValueAt(row, 0).toString());
		try {
			System.out.println(idGrupo);
			c.update("INSERT INTO clientes_Grupo (id_Grupo,id_Cliente) VALUES (" + idGrupo + "," + idCliente + ");");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int idGrupoPorNombre(String nombre) {
		try {

			ResultSet rs = c.query("SELECT id FROM grupos WHERE nombre = '" + nombre + "';");
			rs.next();
			return rs.getInt("id");
		} catch (Exception ex) {
			return 0;
		}
	}

	public void removerCliente(int idGrupo) {
		int row = tableClientesAgregados.getSelectedRow();
		int idCliente = Integer.parseInt(tableClientesAgregados.getModel().getValueAt(row, 0).toString());
		try {
			c.update("DELETE FROM clientes_Grupo WHERE id_Cliente = " + idCliente + " AND id_Grupo = " + idGrupo + ";");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void removerGrupo() {
		try {
			c.update("DELETE FROM grupos WHERE nombre = '" + txtNombre.getText() + "';");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void editarGrupo() {

		if (txtEditar.getText().length() > 0) {
			c.update("UPDATE grupos SET nombre = '" + txtEditar.getText() + "' WHERE nombre = '" + nombreActual
					+ "' AND id = " + idGrupoPorNombre(nombreActual) + ";");
		} else {
			lblWarning.setText("El nombre no es valido");
		}
	}

	public void buscarExistente(String nombreGrupo) {
		if (txtBuscarDisponibles.getText().length() > 0) {

			DefaultTableModel mod = (DefaultTableModel) tableClientesExistentes.getModel();
			mod.setRowCount(0);
			try {
				ResultSet res = c.query(
						"SELECT * FROM clientes_Personal cp WHERE cp.id NOT IN (SELECT cps.id FROM clientes_Personal cps LEFT JOIN clientes_grupo cgs ON cps.id = cgs.id_Cliente WHERE cgs.id_Grupo = "
								+ idGrupoPorNombre(nombreGrupo) + ")  AND cp.nombre like '%"
								+ txtBuscarDisponibles.getText() + "%';");

				while (res.next()) {
					mod.addRow(new Object[] { res.getString("id"), res.getString("nombre"),
							res.getString("apellido_Paterno"), res.getString("apellido_Materno"),
							res.getString("Telefono_Cel") });
					spClientesExistentes.setVisible(true);
					lblWarning.setText("");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			mostrarClientesExistentes();
		}

	}
	
	
	public void buscarAgregado(String nombreGrupo) {
		if (txtBuscarAgregados.getText().length() > 0) {

			DefaultTableModel mod = (DefaultTableModel) tableClientesAgregados.getModel();
			mod.setRowCount(0);
			try {
				ResultSet res = c.query(
						"SELECT cp.id,cp.nombre,cp.Apellido_Paterno ap1,cp.Apellido_Materno ap2 ,cp.Telefono_Cel tel FROM grupos g LEFT JOIN clientes_grupo cg on g.id = cg.id_grupo LEFT JOIN clientes_Personal cp on  cg.id_Cliente = cp.id WHERE g.nombre = '"
								+ nombreGrupo + "' AND cp.nombre like '%"
								+ txtBuscarAgregados.getText() + "%';");

				while (res.next()) {
					mod.addRow(new Object[] { res.getString("cp.id"), res.getString("nombre"),
							res.getString("cp.ap1"), res.getString("cp.ap2"),
							res.getString("cp.Tel") });
					spClientesExistentes.setVisible(true);
					lblWarning.setText("");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			mostrarGrupo(txtNombre.getText());
		}
	}
}
