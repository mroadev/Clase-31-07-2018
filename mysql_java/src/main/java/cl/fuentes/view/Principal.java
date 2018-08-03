package cl.fuentes.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cl.fuentes.db.Mysqlconn;

public class Principal extends JFrame {

	JButton btnUsuariogui;
	private Mysqlconn conn;
	  JMenu menu, submenu;  
	    JMenuItem i1, i2, i3, i4, i5;          
	    JMenuBar mb;
	
	public Principal(Mysqlconn con) {
		super("Principal");
		conn = con;
		iniciaPrincipal();
	}
	
	public void iniciaPrincipal() {
		this.setLayout(null);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null); // centra la ventana
		
		btnUsuariogui = new JButton("Abrir usuario");
		btnUsuariogui.setLocation(20, 20);
		btnUsuariogui.setSize(200, 20);
		btnUsuariogui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirUsuariogui();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent e) {
		        salirAplicacion();
		    }
		});
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.add(btnUsuariogui);
		
		 this.setTitle("Sistema Ventas");
	        this.setLayout(null);
	        this.setSize(800, 150);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        mb=new JMenuBar();  
	        menu=new JMenu("PGestion");  
	        i1=new JMenuItem("Usuarios"); 
	        i1.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	                proceso1();        
	            }
	        });
	        i2=new JMenuItem("Clientes");  
	        i2.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	                proceso2();        
	            }
	        });
	        i3=new JMenuItem("Productos");  
	        i3.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	                proceso3();        
	            }
	        }); 
	        menu.add(i1);
	        menu.add(i2);
	        menu.add(i3);  
	        mb.add(menu); 
	        this.setJMenuBar(mb);
	        this.setBackground(Color.white);
	}
	
	  public void proceso1(){
		  abrirUsuariogui();
	    }
	    public void proceso2(){
	       
	    }
	    public void proceso3(){
	    	abrirProductogui();
	    }        
	
	public void abrirUsuariogui(){
		Usuariogui ugui = new Usuariogui(conn);
		ugui.setVisible(true);
	}
	
	public void abrirProductogui(){
		Productogui ugui = new Productogui(conn);
		ugui.setVisible(true);
	}
	
	public void salirAplicacion() {
	    this.dispose();
	    System.exit(0);
	}
	
}