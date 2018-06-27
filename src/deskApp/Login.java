package deskApp;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import deskApp.TextPrompt;
import javax.swing.JLabel;
import java.awt.Font;
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
	
	
	private JPanel contentPane;
	Style s =  new Style();
	private JTextField txtUser;
	Usuario u = new Usuario();
	Conexion c = new Conexion();
	JLabel lblHeader,lblLook,lblWarning;
	JButton btnIniciar;
	JPasswordField txtPassword;
	MainAdminMenu mam = new MainAdminMenu();
	int userType,idUser;
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 609, 455);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel,Color.white);
		
		JPanel logPanel = new JPanel();
		logPanel.setBounds(201, 143, 214, 223);
		mainPanel.add(logPanel);
		logPanel.setLayout(null);
		s.mdPanel(logPanel,Color.WHITE);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtUser.setBounds(37, 48, 167, 32);
		logPanel.add(txtUser);
		txtUser.setColumns(10);
		txtUser.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1,Color.LIGHT_GRAY));
		txtUser.setBorder(BorderFactory.createCompoundBorder(txtUser.getBorder(),BorderFactory.createEmptyBorder(7,10,10,5)));
		
		TextPrompt tpUser = new TextPrompt("Usuario",txtUser);
		tpUser.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpUser.setForeground(Color.gray);
		
		lblLook = new JLabel("");
		lblLook.setBounds(179, 91, 25, 33);
		logPanel.add(lblLook);
		lblLook.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.LIGHT_GRAY));
		lblLook.setIcon(new ImageIcon("views/eyeBlue.png"));
		btnIniciar = new JButton("Iniciar Sesi\u00F3n");
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		btnIniciar.setBounds(10, 178, 194, 34);
		logPanel.add(btnIniciar);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(37, 91, 143, 33);
		logPanel.add(txtPassword);
		txtPassword.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0,Color.LIGHT_GRAY));
		txtPassword.setBorder(BorderFactory.createCompoundBorder(txtPassword.getBorder(),BorderFactory.createEmptyBorder(7,10,10,10)));
		
		TextPrompt tpPass = new TextPrompt("Contraseña", txtPassword);
		tpPass.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpPass.setForeground(Color.gray);
		
		s.mdButton(btnIniciar,s.blue);
		
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setBounds(10, 48, 27, 32);
		logPanel.add(lblUserIcon);
		
		JLabel lblPassIcon = new JLabel("");
		lblPassIcon.setBounds(10, 91, 32, 33);
		logPanel.add(lblPassIcon);
		lblUserIcon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.LIGHT_GRAY));
		lblPassIcon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.LIGHT_GRAY));
		lblUserIcon.setIcon(new ImageIcon("views/user.png"));
		lblPassIcon.setIcon(new ImageIcon("views/key.png"));
		
		JLabel lblLogHeader = new JLabel("Inicia Sesi\u00F3n");
		lblLogHeader.setBounds(0, 0, 214, 37);
		logPanel.add(lblLogHeader);
		lblLogHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblLogHeader.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblWarning.setBounds(10, 135, 194, 20);
		logPanel.add(lblWarning);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 609, 100);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		
		lblHeader = new JLabel("");
		lblHeader.setBounds(10, 11, 589, 40);
		pnHeader.add(lblHeader);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 20));
		
		btnIniciar.addActionListener(this);
		lblLook.addMouseListener(this);
		btnIniciar.addMouseListener(this);
		mam.btnBack.addActionListener(this);
		
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
					mam.setVisible(true);
					this.setVisible(false);
					lblWarning.setText("");
				}				
			}
		}else if(e.getSource() == mam.btnBack){
			mam.setVisible(false);
			this.setVisible(true);
		}
	}
	
	public Boolean userExists() {
		String pass = new String(txtPassword.getPassword());
		try {
			ResultSet rs = c.query("SELECT * FROM usuarios WHERE usuario = '"+txtUser.getText()+"' AND contraseña = '"+pass+"'; ");
			if(rs.next()){
				userType = rs.getInt("tipo_usuario");
				mam.idUser = rs.getInt("id");
				return true;
				
			}
		}catch(Exception ex) {
		
		}	
		lblWarning.setText("Usuario o contraseña invalidos");
		return false;
		
		
	}
}
	
