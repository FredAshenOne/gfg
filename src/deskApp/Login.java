package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import deskApp.TextPrompt;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	Style s =  new Style();
	private JTextField txtUser;
	JLabel lblHeader,lblEye;
	JButton btnIniciar;
	JPasswordField txtPassword;
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
		s.mdPanel(mainPanel);
		
		JPanel logPanel = new JPanel();
		logPanel.setBounds(201, 143, 214, 223);
		mainPanel.add(logPanel);
		logPanel.setLayout(null);
		s.mdPanel(logPanel);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtUser.setBounds(10, 48, 194, 32);
		logPanel.add(txtUser);
		txtUser.setColumns(10);
		txtUser.setBorder(BorderFactory.createCompoundBorder(txtUser.getBorder(),BorderFactory.createEmptyBorder(7,10,10,5)));
		
		TextPrompt tpUser = new TextPrompt("Usuario",txtUser);
		tpUser.setHorizontalAlignment(SwingConstants.LEFT);
		tpUser.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpUser.setForeground(Color.gray);
		
		
		JLabel lblLook = new JLabel("");
		lblLook.setBounds(179, 91, 25, 33);
		logPanel.add(lblLook);
		lblLook.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.gray));
		lblLook.setIcon(new ImageIcon("views/eye24.png"));
		btnIniciar = new JButton("Iniciar Sesi\u00F3n");
		btnIniciar.setBounds(10, 178, 194, 34);
		logPanel.add(btnIniciar);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(10, 91, 170, 33);
		logPanel.add(txtPassword);
		txtPassword.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0,Color.gray));
		txtPassword.setBorder(BorderFactory.createCompoundBorder(txtPassword.getBorder(),BorderFactory.createEmptyBorder(7,10,10,10)));
		
		TextPrompt tpPass = new TextPrompt("Contraseña", txtPassword);
		tpPass.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpPass.setForeground(Color.gray);
		
		
		lblHeader = new JLabel("Grupo Financiero Guerra");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 20));
		lblHeader.setBounds(10, 11, 589, 40);
		mainPanel.add(lblHeader);
//		
		
	}
}
	
