package deskApp;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import deskApp.TextPrompt;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener,MouseListener{
	
	
	
	Style s =  new Style();	
	MenuPrincipal mp = new MenuPrincipal();
	Conexion c = new Conexion();
	MenuUser mu =  new MenuUser();

	private JPanel contentPane;
	JTextField txtUser;
	JLabel lblHeader,lblLook,lblWarning;
	JButton btnIniciar;
	JPasswordField txtPassword;
	
	int userType,idUser;
	
	public Login() {
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
		
		//header 
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 1124, 151);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		

		lblHeader = new JLabel("");
		lblHeader.setBounds(388, 11, 332, 129);
		lblHeader.setIcon(new ImageIcon("views/gfgHeader.png"));
		pnHeader.add(lblHeader);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 20));
		
		// panel de entradas 
		
		JPanel logPanel = new JPanel();
		logPanel.setBounds(390, 262, 332, 359);
		mainPanel.add(logPanel);
		logPanel.setLayout(null);
		s.mdPanel(logPanel,Color.WHITE);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		txtUser.setBounds(51, 111, 267, 61);
		logPanel.add(txtUser);
		txtUser.setColumns(10);
		txtUser.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1,Color.LIGHT_GRAY));
		txtUser.setBorder(BorderFactory.createCompoundBorder(txtUser.getBorder(),BorderFactory.createEmptyBorder(7,10,10,5)));
		
		TextPrompt tpUser = new TextPrompt("Usuario",txtUser);
		tpUser.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpUser.setForeground(Color.gray);
		
		lblLook = new JLabel("");
		lblLook.setHorizontalAlignment(SwingConstants.CENTER);
		lblLook.setBounds(286, 197, 32, 52);
		logPanel.add(lblLook);
		lblLook.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.LIGHT_GRAY));
		lblLook.setIcon(new ImageIcon("views/eyeBlue.png"));
		lblLook.addMouseListener(this);		

		btnIniciar = new JButton("Iniciar Sesi\u00F3n");
		btnIniciar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		btnIniciar.setBounds(10, 294, 308, 54);
		logPanel.add(btnIniciar);
		btnIniciar.addActionListener(this);
		s.mdButton(btnIniciar,s.blue);		
		btnIniciar.addMouseListener(this);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		txtPassword.setBounds(51, 197, 236, 52);
		logPanel.add(txtPassword);
		txtPassword.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0,Color.LIGHT_GRAY));
		txtPassword.setBorder(BorderFactory.createCompoundBorder(txtPassword.getBorder(),BorderFactory.createEmptyBorder(7,10,10,10)));
		
		TextPrompt tpPass = new TextPrompt("Contraseña", txtPassword);
		tpPass.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpPass.setForeground(Color.gray);
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserIcon.setBounds(10, 111, 45, 61);
		lblUserIcon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.LIGHT_GRAY));
		lblUserIcon.setIcon(new ImageIcon("views/user.png"));
		logPanel.add(lblUserIcon);
		
		JLabel lblPassIcon = new JLabel("");
		lblPassIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassIcon.setBounds(10, 197, 45, 52);
		logPanel.add(lblPassIcon);
		lblPassIcon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.LIGHT_GRAY));
		lblPassIcon.setIcon(new ImageIcon("views/key.png"));
		
		JLabel lblLogHeader = new JLabel("Inicia Sesi\u00F3n");
		lblLogHeader.setBounds(0, 0, 344, 72);
		logPanel.add(lblLogHeader);
		lblLogHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 23));
		lblLogHeader.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblWarning.setBounds(0, 257, 332, 26);
		logPanel.add(lblWarning);		
		
		mp.pnHeader.btnBack.addActionListener(this);
		mu.btnBack.addActionListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent a) {
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==lblLook) {
			s.lblPointer(lblLook);
		}else if(e.getSource()==btnIniciar) {
			s.btnHover(btnIniciar, s.blue, Color.white, s.blue);
			s.btnPointer(btnIniciar);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnIniciar) {
			s.mdButton(btnIniciar, s.blue);
		}		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == lblLook) {
			txtPassword.setEchoChar((char)0);
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		txtPassword.setEchoChar(('•'));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIniciar) {
			if(userExists()) {
				if(userType == 1) {
					mp.setVisible(true);
					this.setVisible(false);
					cargarInteresesMensuales();
					lblWarning.setText("");
				}else {
					mu.setVisible(true);
					this.setVisible(false);
					lblWarning.setText("");
				}
			}
		}else if(e.getSource() == mp.pnHeader.btnBack){
			mp.setVisible(false);
			this.setVisible(true);
		}else if(e.getSource() == mu.btnBack) {
			this.setVisible(true);
			mu.setVisible(false);
		}
	}
	
	public Boolean userExists() {
		String pass = new String(txtPassword.getPassword());
		try {
			
			ResultSet rs = c.query("SELECT * FROM usuarios WHERE usuario = '"+txtUser.getText()+"' AND contraseña = '"+pass+"'; ");

			if(rs.next()){
				userType = rs.getInt("tipo_usuario");
				mp.idUser = rs.getInt("id");
				return true;
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
		lblWarning.setText("Usuario o contraseña invalidos");
		return false;
		
		
	}
	
	public void cargarInteresesMensuales() {
		
		try {
			ResultSet mensualP = c.query("SELECT * FROM intereses_mensuales_personal imp LEFT JOIN credito_personal cp ON imp.id_Credito = cp.id LEFT JOIN tipos_interes ti ON cp.tipo_interes = ti.id WHERE CURDATE() = DATE_ADD(imp.fecha,interval 1 MONTH)");
			ResultSet mensualG = c.query("SELECT * FROM intereses_mensuales_Grupal img LEFT JOIN credito_grupal cg ON img.id_Credito = cg.id LEFT JOIN tipos_interes ti ON cg.tipo_interes = ti.id WHERE CURDATE() = DATE_ADD(img.fecha,interval 1 MONTH)");
			while(mensualP.next()) {
				int intereses = mensualP.getInt("cp.total") * mensualP.getInt("ti.Descripcion")/100;
				c.update("UPDATE intereses_mensuales_personal SET cantidad = "+intereses+", fecha = CURDATE();");
				c.update("UPDATE credito_personal SET intereses = intereses + "+intereses+",total = capital + intereses ;");
			}
			
			
			while(mensualG.next()) {
				int intereses = mensualP.getInt("cg.total") * mensualP.getInt("ti.Descripcion")/100;
				c.update("UPDATE intereses_mensuales_grupal SET cantidad = "+intereses+", fecha = CURDATE();");
				c.update("UPDATE credito_grupal SET intereses = intereses + "+intereses+",total = capital + intereses ;");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
	
