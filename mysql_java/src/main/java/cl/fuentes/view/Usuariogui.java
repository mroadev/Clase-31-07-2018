package cl.fuentes.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Usuario;
import cl.fuentes.querys.UsuarioQuery;

public class Usuariogui extends JFrame{
  
	private Mysqlconn conn;
	
	JLabel lbUsuario;
	JTextField txtUsuario;
	JLabel lbClave;
	JPasswordField txtPassword;
	JLabel lbNombre;
	JTextField txtNombre;
	JButton btnAgregar;
	JButton btnGuardar;
	JButton btnEliminar;
	JLabel lbTipousuario;
	JComboBox<String> cbTipousuario;
	JButton btnBuscar;
	
	UsuarioQuery usuquery;
	
	public Usuariogui(Mysqlconn con) {
		super("Formulario Usuario");
		conn = con;
		usuquery = new UsuarioQuery(con);
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setLayout(null);
		this.setLocationRelativeTo(null);  
		
		this.setSize(400, 300);
		
		lbUsuario = new JLabel("Usuario");
		lbUsuario.setLocation(20, 20);
		lbUsuario.setSize(100, 20);
		lbClave = new JLabel("Clave");
		lbClave.setLocation(20, 60);
		lbClave.setSize(100, 20);
		lbNombre = new JLabel("Nombre");
		lbNombre.setLocation(20, 100);
		lbNombre.setSize(100, 20);
		
		txtUsuario = new JTextField();
		txtUsuario.setLocation(100, 20);
		txtUsuario.setSize(100, 20);
		
		txtPassword = new JPasswordField();
		txtPassword.setLocation(100, 60);
		txtPassword.setSize(100, 20);
		
		txtNombre = new JTextField();
		txtNombre.setLocation(100, 100);
		txtNombre.setSize(100, 20);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setLocation(20, 180);
		btnAgregar.setSize(80, 20);
		btnGuardar = new JButton("Guardar");
		btnGuardar.setLocation(100, 180);
		btnGuardar.setSize(100, 20);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setLocation(200, 180);
		btnEliminar.setSize(80, 20);
		
		btnBuscar = new JButton("Leer");
		btnBuscar.setLocation(250, 20);
		btnBuscar.setSize(100, 20);
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscarUsuario();
			}
		});
		
		
		
		lbTipousuario = new JLabel("Tipo usuario");
		lbTipousuario.setLocation(20,140);
		lbTipousuario.setSize(100, 20);
		

		
		Vector<String> tipousuario = new Vector<String>();
		tipousuario.addElement("Administrador");
		tipousuario.addElement("Operador");
		tipousuario.addElement("Vendedor");
		
		//String[] tipousuario = new String[] {"Administrador", "Vendedor"};
		cbTipousuario = new JComboBox<String>(tipousuario);
		cbTipousuario.setLocation(100,140);
		cbTipousuario.setSize(100, 20);
		
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarUsuario();
				
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarUsuario();				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarUsuario();
				
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
        
            @Override
            public void windowClosing(WindowEvent e)
            {
            	try {
					//conn.close();
				} catch (Exception e1) {
					System.out.println("No ha sido posible cerrar la coneión a la db.");
				}
                System.out.println("Ventana cerrada");
                e.getWindow().dispose();
            }
		
		});
		
		
		this.add(lbClave);
		this.add(lbNombre);
		this.add(lbUsuario);

		this.add(txtNombre);
		this.add(txtPassword);
		this.add(txtUsuario);
		
		this.add(btnAgregar);
		this.add(btnEliminar);
		this.add(btnGuardar);
		
		this.add(lbTipousuario);
		this.add(cbTipousuario);
		this.add(btnBuscar);
		
	}
	
	public void agregarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setUsuario(txtUsuario.getText());
		String clave = new String(txtPassword.getPassword());
		usuario.setClave(clave);
		usuario.setNombre(txtNombre.getText());
		usuario.setTipousuario(cbTipousuario.getSelectedItem().toString());
		usuario.setEstado("V"); // usuario vigente
		usuquery.create(usuario);
		System.out.println("Usuario creado.");
		JOptionPane.showMessageDialog(this, "Usuario creado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void guardarUsuario() {
		Usuario usuario = new Usuario();
		String clave = new String(txtPassword.getPassword());
		usuario.setClave(clave);
		usuario.setTipousuario(cbTipousuario.getSelectedItem().toString());
		usuquery.update(usuario);
		JOptionPane.showMessageDialog(this, "Usuario modificado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void eliminarUsuario() {
		// cambiar estado ='N'
		usuquery.delete(txtUsuario.getText());
		JOptionPane.showMessageDialog(this, "Usuario eliminado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}

	public void buscarUsuario() {
		//Usuario usuario = new Usuario();
		Usuario usuario = usuquery.read(txtUsuario.getText());
		txtUsuario.setText(usuario.getUsuario());
		txtNombre.setText(usuario.getNombre());
		txtPassword.setText(usuario.getClave());
		cbTipousuario.setSelectedItem(usuario.getTipousuario());
	}

}
