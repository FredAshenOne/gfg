package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class RegistrarPago extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane,pnHeader;
	Style s = new Style();
	JButton btnNext,btnBack,btnPersonal,btnGrupal,btnRegistrar;
	int tipoCredito = 1;
	
	JTextField txtId,txtNumPago;
	JTextPane txtObservaciones;
	
	public RegistrarPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 593, 379);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel,Color.WHITE);
		
		pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 593, 100);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		btnBack.addMouseListener(this);
		
		s.btnIcon(btnBack, "views/back.png");
		
		btnNext = new JButton("");
		btnNext.setBorder(null);
		btnNext.setBounds(551, 11, 32, 32);
		pnHeader.add(btnNext);
		s.btnIcon(btnNext, "views/next.png");
		
		btnPersonal = new JButton("Personal");
		btnPersonal.setForeground(Color.WHITE);
		btnPersonal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnPersonal.setBorder(null);
		btnPersonal.setBounds(491, 57, 46, 32);
		pnHeader.add(btnPersonal);
		
		btnGrupal = new JButton("Grupal");
		btnGrupal.setForeground(Color.WHITE);
		btnGrupal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnGrupal.setBorder(null);
		btnGrupal.setBounds(537, 57, 46, 32);
		pnHeader.add(btnGrupal);
		
		txtId = new JTextField();
		txtId.setBounds(26, 152, 273, 34);
		mainPanel.add(txtId);
		txtId.setColumns(10);
		
		txtNumPago = new JTextField();
		txtNumPago.setColumns(10);
		txtNumPago.setBounds(26, 242, 273, 34);
		mainPanel.add(txtNumPago);
		
		JLabel lblNewLabel = new JLabel("Numero de Pago");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 214, 273, 22);
		mainPanel.add(lblNewLabel);
		
		JLabel lblIdCredito = new JLabel("ID Credito");
		lblIdCredito.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblIdCredito.setBounds(26, 127, 273, 22);
		mainPanel.add(lblIdCredito);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnRegistrar.setBounds(177, 334, 273, 34);
		mainPanel.add(btnRegistrar);
		
		JLabel lblObservaciones = new JLabel("ID Credito");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblObservaciones.setBounds(339, 127, 222, 22);
		mainPanel.add(lblObservaciones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(339, 152, 229, 124);
		mainPanel.add(scrollPane);
		
		txtObservaciones = new JTextPane();
		scrollPane.setViewportView(txtObservaciones);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void insertarPagoPersonalS(){
		
	}
}
