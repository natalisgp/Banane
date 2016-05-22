package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.SwingConstants;


public class login extends JFrame {
	//
	private JPanel contentPane;
	private JTextField DNI;
	private JTextField Contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.shadow"));
		contentPane.setBorder(new EmptyBorder(1, 1, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CrearUsuario().setVisible(true); //Voy a crear usuario
				login.this.dispose(); //hago "invisible la clase login"
				
	            
				
				
			}
		});
		
		JButton ayuda = new JButton("Ayuda");
		ayuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaLogin().setVisible(true); //Voy a crear usuario
				login.this.dispose(); //hago "invisible la clase login"
				
				
				
				
			}
		});
		ayuda.setBounds(345, 234, 89, 23);
		contentPane.add(ayuda);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\fondo.jpg"));
		label.setBounds(85, -136, 327, 365);
		contentPane.add(label);
		btnCrearUsuario.setBackground(Color.WHITE);
		btnCrearUsuario.setForeground(Color.BLUE);
		btnCrearUsuario.setBounds(147, 234, 131, 23);
		contentPane.add(btnCrearUsuario);
		
		DNI = new JTextField();
		DNI.setBounds(217, 106, 114, 20);
		contentPane.add(DNI);
		DNI.setColumns(10);
		
		Contraseña = new JTextField();
		Contraseña.setBounds(217, 147, 114, 20);
		contentPane.add(Contraseña);
		Contraseña.setColumns(10);
		
		JButton BotonEntrar = new JButton("Entrar");
		BotonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ndni = DNI.getText();
				String pass = Contraseña.getText();
				
				if(ndni.length()>0 && pass.length()>0){
					
					//llamo a la funcion obtener usuario
					try {
						String[] admin = funciones.getAdministrador(ndni);
						String[] usuario =funciones.getUsuario(ndni);
						String[] bibliotecario =funciones.getBibliotecario(ndni);
						
						System.out.println(admin[4]);
						System.out.println(usuario[4]);
						System.out.println(bibliotecario[4]);
						
						//si el dni es el del administrador
						if(pass.equals(admin[4])){
							

							//ADMINISTRADOR
							if(admin[3].equals("1")){  //El permiso 1 para el usuario
								
								new Administrador().setVisible(true);
								login.this.dispose(); //hago "invisible la clase login"
								
								//new nombredelaclase.setVisible(true);
								System.out.println("Hola soy el administrador");
							}
							//USUARIO	
						}
						if(pass.equals(usuario[4])){ //El permiso 2 para el administrador
								  	
								new Usuario().setVisible(true);
								login.this.dispose();
								System.out.println("Hola soy el usuario");
						
						}			
								
							//BIBLIOTECARIO	
						if(pass.equals(bibliotecario[4])){ //El permiso 2 para el administrador
								
								new Bibliotecario().setVisible(true);
								login.this.dispose(); //hago "invisible la clase login"
								
								//new nombredelaclase.setVisible(true);
								System.out.println("Hola soy el bibliotecario");
									
								
							
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else{
					JOptionPane.showMessageDialog(null, "Error los campos estan vacios.");
				}
				
			}
		});
		BotonEntrar.setBounds(167, 200, 89, 23);
		contentPane.add(BotonEntrar);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.LIGHT_GRAY);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDni.setBounds(131, 108, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.LIGHT_GRAY);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBounds(110, 150, 97, 14);
		contentPane.add(lblContrasea);
		
		JLabel ImagenLogin = new JLabel("");
		ImagenLogin.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\fondo.jpg"));
		ImagenLogin.setBounds(-15, -78, 568, 365);
		contentPane.add(ImagenLogin);
	}
}

