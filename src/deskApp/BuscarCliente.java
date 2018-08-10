package deskApp;

import java.awt.Color;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;

public class BuscarCliente extends JFrame implements ActionListener{
	Style s = new Style();
	JButton btnBack,btnNext;
	JLabel lblHeader;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	JScrollPane scrollPane;
	MdHeader pnHeader;
	int idUser;
	Conexion c = new Conexion();
	private JLabel lblWarning;
	MostrarCliente sc = new MostrarCliente();
	public BuscarCliente() {
		setBounds(100, 100, 1135, 827);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1133, 798);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, Color.WHITE);
		
		pnHeader = new MdHeader(s.blue,Color.white);
		mainPanel.add(pnHeader);
		pnHeader.lblTitle.setText("Buscar Cliente");
		pnHeader.lblWarning.setBounds(10, 65, 1104, 32);
		pnHeader.btnNext.addActionListener(this);
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				fillTable();
			}
		});
		txtSearch.setForeground(Color.WHITE);
		txtSearch.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 23));
		txtSearch.setBounds(100, 95, 961, 44);
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
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(54, 179, 1014, 549);
		mainPanel.add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setBackground(Color.WHITE);
		
		table = new JTable(){
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};		
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "Nombre", "Apellido Paterno", "Apellido Materno", "Direccion"
				}
			) {
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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setVisible(false);
		
		sc.pnHeader.btnBack.addActionListener(this);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		pnHeader.btnNext.setEnabled(false);
		
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
		        public void valueChanged(ListSelectionEvent e) { 
		            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		            pnHeader.btnNext.setEnabled(!lsm.isSelectionEmpty());
		        }
		});
		sc.alUpdate.btnOk.addActionListener(this);
		sc.pnHeader.btnBack.addActionListener(this);
		sc.sad.btnBack.addActionListener(this);
		sc.sjd.btnBack.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pnHeader.btnNext) {
			int index = table.getSelectedRow();
			sc.rs = c.query("SELECT * FROM clientes_personal cp LEFT JOIN clientes_empleo ce ON cp.id = ce.id_Cliente WHERE cp.id = "+Integer.parseInt(table.getModel().getValueAt(index,0).toString())+";");
			
//			sc.rs = getClientById(Integer.parseInt(table.getModel().getValueAt(index,0).toString()));
			sc.sad.rs = sc.rs;
			sc.fillFields();
			sc.setEditableFields(false);
			sc.etiquetasVisibles(true);
			sc.setVisible(true);
			sc.btnSave.setVisible(false);
			sc.pnHeader.btnNext.setVisible(true);
			sc.idUser = idUser;
		}else if(e.getSource() == sc.pnHeader.btnBack) {
			this.setVisible(true);
			sc.setVisible(false);
			sc.pnHeader.btnNext.setVisible(true);
			sc.btnSave.setVisible(false);
			fillTable();
		}
		
	}

	public ResultSet searchClient() {
		String data = txtSearch.getText();
		String[] nombre = data.split(" ");
		try {
			
			if (nombre.length == 3) { 
				return c.query("SELECT * FROM clientes_personal WHERE nombre = '" + nombre[0]
						+ "' AND paterno = '" + nombre[1] + "' AND materno = '" + nombre[2] + "';");
			} else if (nombre.length == 2) {
				return c.query("SELECT * FROM clientes_personal WHERE  nombre = '" + nombre[0]
						+ "' AND Paterno = '" + nombre[1] + "' OR (Paterno = '"+nombre[0]+"' AND Materno = '"+nombre[1]+"');");
			} else if (nombre.length == 1) {
				try {
					int id = Integer.parseInt(data);
					return c.query("SELECT * FROM clientes_personal WHERE id LIKE " + id + ";");
				} catch (NumberFormatException nfe) {					
					return c.query("SELECT * FROM clientes_personal WHERE nombre LIKE '%" + nombre[0] + "%' OR Paterno LIKE '%"+nombre[0]+"%' OR Materno LIKE '%"+nombre[0]+"%';");
				}
			} else {
				pnHeader.lblWarning.setText("No se encontraron resultados");
				return null;
			}
		} catch (Exception ex) {
			pnHeader.lblWarning.setText("No se encontraron resultados");
			return null;
		}
	}

	public void fillTable() {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		ResultSet res = searchClient();
		ResultSet resv = searchClient();
		try {
			while (res.next()) {	
					mod.addRow(
							new Object[] { res.getString("id"), res.getString("nombre"), res.getString("Paterno"),
									res.getString("Materno"), res.getString("Direccion") });
					scrollPane.setVisible(true);
					pnHeader.lblWarning.setText("");
				}
		}catch(Exception ex){
			pnHeader.lblWarning.setText("No se encontraron resultados");
		}
	}
	
	public ResultSet getClientById(int id) {
		try {
			return c.query("SELECT * FROM clientes_Personal WHERE id = "+id+";");			
		}catch(Exception ex) {
			ex.printStackTrace();
			pnHeader.lblWarning.setText("No se ha seleccionado algun elemento");
		}
		return null;
	}
	
}
