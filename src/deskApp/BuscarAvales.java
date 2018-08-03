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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class BuscarAvales extends JFrame implements ActionListener,MouseListener{

	ResultSet rs;
	private JPanel contentPane;
	JButton btnBack,btnInfoAvales,btnInfoEmpleo,btnInfoCliente,btnNext,btnAddAval;
	Style s = new Style();
	private JTable table;
	int idCliente;
	Conexion c = new Conexion();
	NuevoAval ca = new NuevoAval();
	MostarAval sa = new MostarAval();
	Alert alAnother = new Alert();
	public BuscarAvales() {
		setResizable(false);
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
		
		JLabel lblHeader = new JLabel("Avales Registrados");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);
		
		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 119, 432, 187);
		mainPanel.add(scrollPane);
		btnNext.addActionListener(this);
		btnNext.setEnabled(false);
		s.btnIcon(btnNext, "views/next.png");
		
		btnAddAval = new JButton("");
		btnAddAval.setBorder(null);
		btnAddAval.setBounds(551, 54, 32, 32);
		pnHeader.add(btnAddAval);
		s.btnIcon(btnAddAval, "views/addAvalWhite.png");
		btnAddAval.addMouseListener(this);
		btnAddAval.addActionListener(this);
		
		
		table = new JTable(){
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido Paterno", "Apellido Materno", "Direccion", "Num Exterior"
			}
		));
		scrollPane.setViewportView(table);
		
		table.getTableHeader().setBackground(Color.white);
		table.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.white);
		scrollPane.setBackground(Color.WHITE);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBounds(475, 317, 96, 32);
		mainPanel.add(menuPanel);
		
		btnInfoCliente = new JButton("");
		btnInfoCliente.setOpaque(true);
		btnInfoCliente.setBackground(new Color(3, 155, 229));
		btnInfoCliente.setBounds(0, 0, 32, 32);
		menuPanel.add(btnInfoCliente);
		s.btnIcon(btnInfoCliente, "views/userBlue.png");
		
		btnInfoEmpleo = new JButton("");
		btnInfoEmpleo.setBounds(32, 0, 32, 32);
		menuPanel.add(btnInfoEmpleo);
		s.btnIcon(btnInfoEmpleo, "views/job.png");
		
		btnInfoAvales = new JButton("");
		btnInfoAvales.setBounds(64, 0, 32, 32);
		menuPanel.add(btnInfoAvales);
		btnInfoAvales.setIcon(new ImageIcon("views/avalesWhite.png"));
		btnInfoAvales.setBackground(s.blue);
		
		btnInfoAvales.addMouseListener(this);
		btnInfoEmpleo.addMouseListener(this);
		btnInfoCliente.addMouseListener(this);
		
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
		        public void valueChanged(ListSelectionEvent e) { 
		            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		            btnNext.setEnabled(!lsm.isSelectionEmpty());
		        }
		});
		
		ca.alSave.btnOk.addActionListener(this);
		btnNext.addMouseListener(this);
		
		alAnother.lblMessage.setText("<html><body>Datos guardados correctamente<br> desea campturar mas avales?</body></html>");
		alAnother.btnOk.setText("Si");
		alAnother.btnCancel.setText("No");
		alAnother.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alAnother.btnCancel.addActionListener(this);
		alAnother.btnOk.addActionListener(this);
		
		sa.btnBack.addActionListener(this);
		ca.btnBack.addActionListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnInfoAvales) {
			s.btnPointer(btnInfoAvales);
		}
		else if(e.getSource() == btnInfoEmpleo) {
			s.btnPointer(btnInfoEmpleo);
			s.hoverBorder(btnInfoEmpleo, s.blue);
		}else if(e.getSource() == btnInfoCliente) {
			s.btnPointer(btnInfoCliente);
			s.hoverBorder(btnInfoCliente, s.blue);
		}else if(e.getSource() == btnBack) {
			s.btnPointer(btnBack);
			s.hoverBorder(btnBack, Color.white);
		}else if(e.getSource() == btnNext) {
			if(btnNext.isEnabled()) {
				s.hoverBorder(btnNext, Color.WHITE);
				s.btnPointer(btnNext);
			} 
		}else if(e.getSource() == btnAddAval) {
			s.hoverBorder(btnAddAval, Color.WHITE);
			s.btnPointer(btnAddAval);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnInfoCliente) {
			btnInfoCliente.setBorder(null);			
		}else if(e.getSource() == btnInfoEmpleo) {
			btnInfoEmpleo.setBorder(null);
		}else if(e.getSource() == btnNext) {
			btnNext.setBorder(null);
		}else if(e.getSource() == btnAddAval) {
			btnAddAval.setBorder(null);
		}else if(e.getSource() == btnBack) {
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
		
		if(e.getSource() == btnNext) {
			int index = table.getSelectedRow();
			sa.fillAvalData(table.getValueAt(index,0).toString(),table.getValueAt(index, 1).toString(),table.getValueAt(index, 2).toString());
			sa.setVisible(true);
			try {
				sa.idCliente = rs.getInt("id");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			sa.camposEditables(false);
			this.setVisible(false);
		}else if(e.getSource() == btnAddAval) {
			try {
				ca.lblHeader.setText(rs.getString("nombre")+" "+rs.getString("Apellido_Paterno")+" "+rs.getString("Apellido_Materno")+" : Agregar Aval");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ca.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == ca.alSave.btnOk) {
			try {
				ca.addAval(rs.getString("nombre"), rs.getString("Apellido_Paterno"),rs.getString("Apellido_materno"));
				alAnother.setVisible(true);
				ca.alSave.setVisible(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == ca.btnBack) {
			this.setVisible(true);
			ca.setVisible(false);
			llenarTabla();
		}else if(e.getSource() == alAnother.btnOk) {
			ca.clearFields();
			alAnother.setVisible(false);
		}else if (e.getSource() == sa.btnBack) {
			this.setVisible(true);
			sa.setVisible(false);
			llenarTabla();
			sa.btnGuardar.setVisible(false);
			sa.btnNext.setVisible(true);
		}
	}	
	
	public void fillTableAvales(ResultSet rs) {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		try {
			while(rs.next()) {
				mod.addRow(new Object[] {rs.getString("nombre"),rs.getString("Apellido_Paterno"),rs.getString("Apellido_Materno"),rs.getString("Direccion"),rs.getString("Num_Exterior")
				});
			}					
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void llenarTabla() {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		
		try {
			System.out.println(rs.getInt("id" )+ " Cliente");
			ResultSet myRs = c.query("SELECT * FROM avales WHERE id_Cliente = "+rs.getInt("id")+" AND status = 1;");
			while(myRs.next()) {
				mod.addRow(new Object[] {myRs.getString("nombre"),myRs.getString("Apellido_Paterno"),myRs.getString("Apellido_Materno"),myRs.getString("Direccion"),myRs.getString("Num_Exterior")
				});
			}					
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}
