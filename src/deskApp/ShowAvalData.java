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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowAvalData extends JFrame implements ActionListener,MouseListener{

	ResultSet rs;
	private JPanel contentPane;
	JButton btnBack,btnInfoAvales,btnInfoEmpleo,btnInfoCliente;
	Style s = new Style();
	private JTable table;
	public ShowAvalData() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 119, 432, 187);
		mainPanel.add(scrollPane);
		
		table = new JTable();
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
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
			s.hoverBorder(btnBack, s.blue);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnInfoCliente) {
			btnInfoCliente.setBorder(null);
			
		}else if(e.getSource() == btnInfoEmpleo) {
			btnInfoEmpleo.setBorder(null);
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
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
	
}
