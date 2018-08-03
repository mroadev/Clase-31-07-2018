package cl.fuentes.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Producto;
import cl.fuentes.querys.ProductoQuery;

public class Productogui extends JFrame{

	private Mysqlconn conn;
	
	JLabel lbCodigoProducto;
	JLabel lbNombre;
	JLabel lbPrecio;
	
	JTextField txtCodigoProducto;
	JTextField txtNombre;
	JTextField txtPrecio;
	
	JButton btnAgregar;
	JButton btnGuardar;
	JButton btnEliminar;
	JButton btnBuscar;
	
	ProductoQuery prodquery;
	
	public Productogui(Mysqlconn con) {
		super("Formulario Producto");
		conn = con;
		prodquery = new ProductoQuery(con);
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setLayout(null);
		this.setLocationRelativeTo(null);  
		
		this.setSize(400, 300);
		
		lbCodigoProducto = new JLabel("Codigo");
		lbCodigoProducto.setLocation(20, 20);
		lbCodigoProducto.setSize(100, 20);
		lbNombre = new JLabel("Nombre");
		lbNombre.setLocation(20, 60);
		lbNombre.setSize(100, 20);
		lbPrecio = new JLabel("Precio");
		lbPrecio.setLocation(20, 100);
		lbPrecio.setSize(100, 20);

		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setLocation(100, 20);
		txtCodigoProducto.setSize(100, 20);
		txtNombre = new JTextField();
		txtNombre.setLocation(100, 60);
		txtNombre.setSize(100, 20);
		txtPrecio = new JTextField();
		txtPrecio.setLocation(100, 100);
		txtPrecio.setSize(100, 20);
		
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
				buscarProducto();
			}
		});
			
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
				
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarProducto();				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarProducto();
				
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
		
		this.add(lbCodigoProducto);
		this.add(lbNombre);
		this.add(lbPrecio);
		
		this.add(txtCodigoProducto);
		this.add(txtNombre);
		this.add(txtPrecio);
		
		this.add(btnAgregar);
		this.add(btnEliminar);
		this.add(btnGuardar);
		this.add(btnBuscar);
		
	}
	
	public void agregarProducto() {
		Producto producto = new Producto();
		
		producto.setProducto(txtNombre.getText());
		producto.setPrecio(Integer.parseInt(txtPrecio.getText()));

		prodquery.create(producto);
		
		System.out.println("Producto creado.");
		JOptionPane.showMessageDialog(this, "Producto creado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void guardarProducto() {
		Producto producto = new Producto();
		
		producto.setCodProducto(Integer.parseInt(txtCodigoProducto.getText()));
		producto.setProducto(txtNombre.getText());
		producto.setPrecio(Integer.parseInt(txtPrecio.getText()));

		prodquery.update(producto);

		JOptionPane.showMessageDialog(this, "Producto modificado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void eliminarProducto() {
		prodquery.delete(txtCodigoProducto.getText());
		JOptionPane.showMessageDialog(this, "Producto eliminado",
				"Información",JOptionPane.INFORMATION_MESSAGE);
	}

	public void buscarProducto() {

		Producto producto = prodquery.read(txtCodigoProducto.getText());
		
		//txtCodigoProducto.setText(producto.getCodProducto());
		txtNombre.setText(producto.getProducto());
		txtPrecio.setText(String.valueOf(producto.getPrecio()));
	}
}
