package cl.fuentes.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.querys.LoginQuery;

public class Login extends JFrame{

	
	private Mysqlconn conn;
	private LoginQuery lq;
	
	JTextField txtUsuario;
	JPasswordField txtClave;
	JButton btnLogin;

	public Login(Mysqlconn con){
		super("Login");
		this.conn = con;
		lq = new LoginQuery(conn);
		this.iniciarLogin();
	}
	
	public void iniciarLogin() {
		
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null); // centra la ventana
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
		txtUsuario = new JTextField();
		txtUsuario.setLocation(20, 20);
		txtUsuario.setSize(100, 20);
		txtUsuario.setText("");
		txtClave = new JPasswordField();
		txtClave.setLocation(20, 60);
		txtClave.setSize(100, 20);
		txtClave.setText("");
		
		btnLogin = new JButton();
		btnLogin.setLocation(20, 100);
		btnLogin.setSize(100, 20);
		btnLogin.setText("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginCheck();
			}
		});
		
        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
            	btnLogin.setBackground(Color.GRAY);
            }
            public void mouseExited(MouseEvent e){
            	//btnLogin.setBackground(Color.GRAY);
            	btnLogin.setBackground(null);
            }            
        });
		
		this.add(txtUsuario);
		this.add(txtClave);
		this.add(btnLogin);
	}
	
	public void loginCheck() {
		String clave = new String(txtClave.getPassword());
		if (lq.loginCheck(txtUsuario.getText(), clave)) {
			System.out.println("Login correcto");
			this.setVisible(false);
			Principal principal = new Principal(conn);
			principal.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(this, "Login incorrecto", "Mensaje",JOptionPane.ERROR_MESSAGE);
		}		
		
	}
	
}
