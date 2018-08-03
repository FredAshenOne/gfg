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
import javax.swing.JTextField;

public class Penalizacion extends JFrame implements ActionListener, MouseListener{
	Style s = new Style();
	private JPanel contentPane;
	JPanel pnHeader;
	JLabel lblBack,lblHeader;
	JButton btnBack,btnNext,btnGrupal,btnPersonal;
	JTextField txtCredito,txtComentario;
	int tipoCredito = 1;
	ConfirmarPenalizacion cp = new ConfirmarPenalizacion();
	Conexion c = new Conexion();
	private JLabel lblWarning;
	Alert alOk = new Alert();
	public Penalizacion() {
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

		lblHeader = new JLabel("Penalizaci\u00F3n");
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
		btnNext.addActionListener(this);
		
		txtCredito = new JTextField();
		txtCredito.setHorizontalAlignment(SwingConstants.CENTER);
		txtCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtCredito.setBounds(152, 213, 282, 42);
		mainPanel.add(txtCredito);
		txtCredito.setColumns(10);
		s.mdTextField(txtCredito, s.blue, Color.white);
		
		txtComentario = new JTextField();
		txtComentario.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtComentario.setHorizontalAlignment(SwingConstants.CENTER);
		txtComentario.setColumns(10);
		txtComentario.setBounds(152, 296, 282, 42);
		mainPanel.add(txtComentario);
		s.mdTextField(txtComentario, s.blue, Color.white);
		
		JLabel lblCredito = new JLabel("ID Credito");
		lblCredito.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblCredito.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredito.setBounds(152, 192, 282, 20);
		mainPanel.add(lblCredito);
		
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentario.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblComentario.setBounds(152, 277, 282, 20);
		mainPanel.add(lblComentario);
		
		btnGrupal = new JButton("Grupal");
		btnGrupal = new JButton("Grupal");
		btnGrupal.setForeground(Color.WHITE);
		btnGrupal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnGrupal.setBorder(null);
		btnGrupal.setBounds(537, 107, 46, 32);
		pnHeader.add(btnGrupal);
		btnGrupal.addActionListener(this);
		btnGrupal.addMouseListener(this);
		s.btnHover(btnGrupal, s.blue, s.blue, Color.white);

		btnPersonal = new JButton("Personal");
		btnPersonal.setForeground(Color.WHITE);
		btnPersonal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnPersonal.setBorder(null);
		btnPersonal.setBounds(491, 107, 46, 32);
		s.btnHover(btnPersonal, Color.white, Color.WHITE, s.blue);
		pnHeader.add(btnPersonal);
		
		lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblWarning.setBounds(52, 64, 489, 32);
		pnHeader.add(lblWarning);
		btnPersonal.addActionListener(this);
		btnPersonal.addMouseListener(this);
		
		cp.btnCancelar.addActionListener(this);
		cp.btnConfirmar.addActionListener(this);
		
		alOk.btnCancel.setVisible(false);
		alOk.btnOk.setBounds(97, alOk.btnOk.getY(), alOk.btnOk.getWidth(), alOk.btnOk.getHeight());
		alOk.lblMessage.setText("Datos guardados con exito");
		alOk.lblAlertIcon.setIcon(new ImageIcon("views/checked.png"));
		alOk.btnOk.setText("Ok");
		alOk.btnOk.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		}else if (e.getSource() == btnGrupal) {
			if (tipoCredito == 1) {
				s.btnHover(btnGrupal, Color.WHITE, s.blue, Color.white);
			} else {
				s.btnHover(btnGrupal, Color.white, Color.WHITE, s.blue);
			}

		} else if (e.getSource() == btnPersonal) {
			if (tipoCredito == 2) {
				s.btnHover(btnPersonal, Color.WHITE, s.blue, Color.white);
			} else {
				s.btnHover(btnPersonal, Color.white, Color.WHITE, s.blue);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnNext) {
			btnNext.setBorder(null);
		} else if (e.getSource() == btnBack) {
			btnBack.setBorder(null);
		}else if (e.getSource() == btnPersonal) {
			if (tipoCredito == 1) {
				s.btnHover(btnPersonal, Color.white, Color.WHITE, s.blue);
			} else {
				s.btnHover(btnPersonal, s.blue, s.blue, Color.white);
			}
		} else if (e.getSource() == btnGrupal) {
			if (tipoCredito == 2) {
				s.btnHover(btnGrupal, Color.white, Color.WHITE, s.blue);
			} else {
				s.btnHover(btnGrupal, s.blue, s.blue, Color.white);
			}
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
		if (e.getSource() == btnGrupal) {
			if (tipoCredito == 1) {
				tipoCredito = 2;				
				s.btnHover(btnPersonal, s.blue, s.blue, Color.white);
				s.btnHover(btnGrupal, Color.white, Color.WHITE, s.blue);
				
			}
		} else if (e.getSource() == btnPersonal) {
			if (tipoCredito == 2) {
				tipoCredito = 1;
				s.btnHover(btnGrupal, s.blue, s.blue, Color.white);
				s.btnHover(btnPersonal, Color.white, Color.WHITE, s.blue);
			}
		}else if(e.getSource() == cp.btnCancelar) {
			cp.setVisible(false);
		}else if(e.getSource() == btnNext) {
			if(txtCredito.getText().length()>0) {
				int idCredito = Integer.parseInt(txtCredito.getText());
				if(creditoExistente(idCredito)) {
					cp.llenarDatos(creditoClientePorIdCredito(idCredito));
					cp.txtComentarios.setText(txtComentario.getText());
				}
			}
			cp.setVisible(true);
		}else if(e.getSource() == cp.btnConfirmar) {
			int idCredito = Integer.parseInt(txtCredito.getText());
			cargarPenalizacion(getTarjeton(idCredito));
			txtCredito.setText("");
			txtComentario.setText("");
			alOk.setVisible(true);
			cp.setVisible(false);
		}else if(e.getSource() == alOk.btnOk) {
			alOk.setVisible(false);
		}
	}
	
	public ResultSet creditoClientePorIdCredito(int idCredito) {
		try {
			if(tipoCredito == 1) {
				return c.query("SELECT * FROM credito_Personal cp LEFT JOIN clientes_personal clp ON cp.id_Cliente = clp.id WHERE cp.id = "+idCredito+";");
			}else {
				return c.query("SELECT * FROM credito_Grupal cp LEFT JOIN grupos clp ON cp.id_grupo = clp.id WHERE cp.id = "+idCredito+";");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	 
	public boolean creditoExistente(int idCredito){
		try {
			if(tipoCredito == 1) {
				return c.query("SELECT * FROM credito_personal WHERE id = "+idCredito+"; ").next();
			}else {
				return c.query("SELECT * FROM credito_grupal WHERE id = "+idCredito+";").next();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
			
		return false;
		
	}
	
	public void cargarPenalizacion(ResultSet rs) {
		try { 
			if(rs.next()) {
				System.out.println(rs.getInt("np")+1);
				if(tipoCredito == 1) {
					
					c.update("INSERT INTO tarjeton_personal (id_Cliente,id_Credito,numero_pago,fecha_Asignada,cantidad,status,observaciones) VALUES ("+rs.getInt("id_Cliente")+","+rs.getInt("id_Credito")+","+(rs.getInt("np")+1)+",DATE_ADD('"+rs.getString("f")+"',INTERVAL 7 DAY),"+rs.getInt("cantidad")+",2,'"+txtComentario.getText()+"')");
					c.update("UPDATE credito_personal SET capital = capital +"+rs.getInt("cantidad")+" WHERE id = "+rs.getInt("id_Credito")+"; ");
				}else {
					c.update("INSERT INTO tarjeton_grupal (id_Grupo,id_Credito,numero_pago,fecha_Asignada,cantidad,status,observaciones) VALUES ("+rs.getInt("id_Grupo")+","+rs.getInt("id_Credito")+","+(rs.getInt("np")+1)+",DATE_ADD('"+rs.getString("f")+"',INTERVAL 7 DAY),"+rs.getInt("cantidad")+",2,'"+txtComentario.getText()+"')");
					c.update("UPDATE credito_grupal SET capital = capital +"+rs.getInt("cantidad")+" WHERE id = "+rs.getInt("id_Credito")+"; ");
				}
			}else{
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public ResultSet getTarjeton(int idCredito) {
		try {
			if(tipoCredito == 1) {
				return c.query("SELECT id_Cliente,id_Credito,MAX(numero_Pago) np,MAX(fecha_Asignada) f,cantidad FROM tarjeton_personal WHERE id_credito = "+idCredito+" GROUP BY id_credito;");
			}else {
				return c.query("SELECT id_grupo,id_Credito,MAX(numero_Pago) np,MAX(fecha_Asignada) f,cantidad  FROM tarjeton_grupal WHERE id_credito = "+idCredito+" GROUP BY id_credito;"); 
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null; 
	}
	
}
