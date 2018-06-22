package deskApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MainAdminMenu extends JFrame implements ActionListener,MouseListener {
	Style s = new Style();
	private JPanel contentPane;
	JPanel pnClientes,pnMovimientos,pnCreditos,pnHeader;
	JLabel lblBack;
	JButton btnClient,btnMoves,btnCredits,btnBack,btnSettings;
	AdminClientes ac = new AdminClientes();
	public MainAdminMenu() {
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
		
		pnClientes = new JPanel();
		pnClientes.setBounds(21, 161, 155, 180);
		mainPanel.add(pnClientes);
		pnClientes.setLayout(null);
		s.mdPanel(pnClientes,Color.WHITE);
		
		JLabel lblClientIcon = new JLabel("");
		lblClientIcon.setBounds(10, 11, 135, 135);
		pnClientes.add(lblClientIcon);
		lblClientIcon.setIcon(new ImageIcon("views/users.png"));
		
		JLabel lblClient = new JLabel("Clientes");
		lblClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblClient.setBounds(10, 157, 135, 23);
		pnClientes.add(lblClient);
		lblClient.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		
		btnClient = new JButton("");
		btnClient.setBounds(0, 0, 155, 180);
		pnClientes.add(btnClient);
		s.btnTransparent(btnClient);
		btnClient.addActionListener(this);
		btnClient.addMouseListener(this);
		
		pnCreditos = new JPanel();
		pnCreditos.setBounds(220, 161, 155, 180);
		mainPanel.add(pnCreditos);
		pnCreditos.setLayout(null);
		s.mdPanel(pnCreditos,Color.white);
		
		JLabel lblCredits = new JLabel("Creditos");
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredits.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblCredits.setBounds(10, 157, 135, 23);
		pnCreditos.add(lblCredits);
		
		JLabel lblIconCredits = new JLabel("");
		lblIconCredits.setBounds(10, 11, 135, 135);
		pnCreditos.add(lblIconCredits);
		lblIconCredits.setIcon(new ImageIcon("views/file.png"));
		
		btnCredits = new JButton("");
		btnCredits.setBounds(0, 0, 155, 180);
		pnCreditos.add(btnCredits);
		s.btnTransparent(btnCredits);
		btnCredits.addActionListener(this);
		btnCredits.addMouseListener(this);
		
		pnMovimientos = new JPanel();
		pnMovimientos.setBounds(417, 161, 155, 181);
		mainPanel.add(pnMovimientos);
		pnMovimientos.setLayout(null);
		s.mdPanel(pnMovimientos,Color.white);
		
		JLabel lblIconMoves = new JLabel("");
		lblIconMoves.setBounds(10, 11, 135, 135);
		pnMovimientos.add(lblIconMoves);
		lblIconMoves.setIcon(new ImageIcon("views/checklist.png"));
		JLabel lblMoves = new JLabel("Movimientos");
		lblMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoves.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblMoves.setBounds(10, 157, 135, 23);
		pnMovimientos.add(lblMoves);
		
		btnMoves = new JButton("");
		btnMoves.setBounds(0, 0, 155, 180);
		pnMovimientos.add(btnMoves);
		s.btnTransparent(btnMoves);
		btnMoves.addActionListener(this);
		btnMoves.addMouseListener(this);
		
		pnHeader = new JPanel();
		pnHeader.setBounds(0, 0, 593, 100);
		mainPanel.add(pnHeader);
		pnHeader.setLayout(null);
		s.mdPanel(pnHeader, s.blue);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 32, 32);
		pnHeader.add(btnBack);
		s.btnTransparent(btnBack);
		btnBack.addMouseListener(this);
		s.btnIcon(btnBack, "views/back.png");
		btnBack.setBorder(null);
		
		btnSettings = new JButton("");
		btnSettings.setBounds(551, 11, 32, 32);
		pnHeader.add(btnSettings);
		s.btnTransparent(btnSettings);
		btnSettings.setIcon(new ImageIcon("views/settings.png"));
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setBounds(52, 11, 489, 32);
		pnHeader.add(lblHeader);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnSettings.addActionListener(this);
		btnSettings.addMouseListener(this);
		ac.btnBack.addActionListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btnClient){
			s.imgBtnHover(s.blue,pnClientes);
			s.panelPointer(pnClientes);
		}else if(e.getSource()==btnCredits){
			s.imgBtnHover(s.blue,pnCreditos);
			s.panelPointer(pnCreditos);
		}else if(e.getSource()==btnMoves){
			s.panelPointer(pnMovimientos);
			s.imgBtnHover(s.blue,pnMovimientos);
		}else if(e.getSource() == btnBack) {
			btnBack.setBorder(new LineBorder(s.blue,2,true));
			s.btnPointer(btnBack);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnClient){
			pnClientes.setBorder(null);
		}else if(e.getSource()==btnCredits){
			pnCreditos.setBorder(null);
		}else if(e.getSource()==btnMoves){
			pnMovimientos.setBorder(null);
		}else if(e.getSource() == btnBack) {
			btnBack.setBorder(null);
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnClient) {
			ac.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == btnBack) {
			this.setVisible(true);
			ac.setVisible(false);
		}		
	}
	
	
	
}
