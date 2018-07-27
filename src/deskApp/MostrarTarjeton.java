package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MostrarTarjeton extends JFrame implements ActionListener,MouseListener{
	JButton btnBack,btnNext;
	Style s = new Style();
	private JPanel contentPane;
	int tipoCredito;
	JScrollPane scrollPane;
	JLabel lblWarning;
	private JTable table;
	JTextField txtNombre,txtPrestamo,txtRestante,txtPago;
	JLabel lblNombre,lblPrestamo,lblRestante,lblPago;
	JLabel lblCredito;

	public MostrarTarjeton() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblHeader = new JLabel("Tarjeton");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);
		
		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		btnNext.addMouseListener(this);
		btnNext.setVisible(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 151, 384, 200);
		mainPanel.add(scrollPane);
		
		table = new JTable(){
		    
				private static final long serialVersionUID = 1L;

		        public boolean isCellEditable(int row, int column) {                
		                return false;               
		        }
		        
		};
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "F.Esperada", "F.Pago", "Status", "Observaciones"
			}
		));
		scrollPane.setViewportView(table);
		
		lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setForeground(Color.WHITE);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblWarning.setBounds(52, 43, 489, 21);
		pnHeader.add(lblWarning);
		
		lblCredito = new JLabel("");
		lblCredito.setForeground(Color.WHITE);
		lblCredito.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblCredito.setBounds(52, 68, 490, 21);
		pnHeader.add(lblCredito);
		
		JLabel lblPagos = new JLabel("Pagos");
		lblPagos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblPagos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagos.setBounds(199, 111, 384, 29);
		mainPanel.add(lblPagos);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(10, 155, 179, 29);
		mainPanel.add(txtNombre);
		txtNombre.setColumns(10);
		s.mdTextField(txtNombre, s.blue, Color.white);
		
		txtPrestamo = new JTextField();
		txtPrestamo.setEditable(false);
		txtPrestamo.setColumns(10);
		txtPrestamo.setBounds(10, 210, 179, 29);
		mainPanel.add(txtPrestamo);
		s.mdTextField(txtPrestamo, s.blue, Color.WHITE);
		
		txtRestante = new JTextField();
		txtRestante.setEditable(false);
		txtRestante.setColumns(10);
		txtRestante.setBounds(10, 267, 179, 29);
		mainPanel.add(txtRestante);
		s.mdTextField(txtRestante, s.blue, Color.white);
		
		txtPago = new JTextField();
		txtPago.setEditable(false);
		txtPago.setColumns(10);
		txtPago.setBounds(10, 322, 179, 29);
		mainPanel.add(txtPago);
		s.mdTextField(txtPago, s.blue, Color.white);
		
		lblNombre = new JLabel("Cliente");
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNombre.setBounds(10, 141, 179, 14);
		mainPanel.add(lblNombre);
		
		lblPrestamo = new JLabel("Cantidad Inicial");
		lblPrestamo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblPrestamo.setBounds(10, 195, 179, 14);
		mainPanel.add(lblPrestamo);
		
		lblRestante = new JLabel("Restante");
		lblRestante.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblRestante.setBounds(10, 250, 179, 14);
		mainPanel.add(lblRestante);
		
		lblPago = new JLabel("Pago Semanal");
		lblPago.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblPago.setBounds(10, 307, 179, 14);
		mainPanel.add(lblPago);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnBack) {
			s.hoverBorder(btnBack, Color.white);
			s.btnPointer(btnBack);
		}else if(e.getSource() == btnNext) {
			s.hoverBorder(btnNext, Color.white);
			s.btnPointer(btnNext);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnBack) {
			btnBack.setBorder(null);
		}else if(e.getSource() == btnNext) {
			btnNext.setBorder(null);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*el resultSet de esta funcion debe ser la union de las tablas 
	cliente_Personal cp		grupos cp
	credito_Personal cep	credito grupal cep
	Tarjeton_Personal tp  	tarjeton_grupal tp
	*/
	
	public void llenarTabla(ResultSet rs) {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		
		try {
			while(rs.next()) {
				mod.addRow(new Object[] { rs.getString("tp.numero_pago"), rs.getString("tp.fecha_Asignada"),
						rs.getString("tp.fecha_pago"), rs.getString("tp.status"),
						rs.getString("tp.observaciones") });
				scrollPane.setVisible(true);
				lblWarning.setText("");
				if(tipoCredito == 1) {
					txtNombre.setText(rs.getString("cp.Nombre")+" "+rs.getString("cp.Apellido_Paterno")+" "+rs.getString("cp.Apellido_Materno"));						
				}else {
					txtNombre.setText(rs.getString("cp.Nombre"));
				}
				txtPrestamo.setText(rs.getString("cep.cantidad_Inicial"));
				txtRestante.setText(rs.getString("capital"));
				txtPago.setText(rs.getString("tp.cantidad"));
				lblCredito.setText("Credito : " + rs.getString("cep.id"));
				
			}
			
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
