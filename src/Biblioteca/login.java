package Biblioteca;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.UIManager;
import java.awt.Font;



public class login extends JFrame {

	public static String ndni;
	private JPanel contentPane;
	private JTextField DNI;
	private JTextField Contrasena;
	char[] pass;

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
		
		JButton ayuda = new JButton(new ImageIcon(getClass().getResource("/Imagenes/ayuda.jpg")));
		ayuda.setBorderPainted(false);
		ayuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaLogin().setVisible(true); //Voy a crear usuario
				login.this.dispose(); //hago "invisible la clase login"
				
				
				
				
			}
		});
		ayuda.setBounds(387, 24, 25, 23);
		contentPane.add(ayuda);
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\fondo.jpg"));
		label.setBounds(85, -136, 327, 365);
		contentPane.add(label);
		
		DNI = new JTextField();
		DNI.setBounds(217, 106, 114, 20);
		contentPane.add(DNI);
		DNI.setColumns(10);
		
		Contrasena = new JPasswordField();
		//Contrasena = new JTextField();
		Contrasena.setBounds(217, 147, 114, 20);
		contentPane.add(Contrasena);
		Contrasena.setColumns(10);
		
		JButton BotonEntrar = new JButton("Entrar");
		BotonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ndni = DNI.getText();
			pass =((JPasswordField) Contrasena).getPassword();
				//String pass = Contrasena.getText();
				
				if(ndni.length()>0 && pass.length>0){
					
					//llamo a la funcion obtener usuario
					try {
						String[] admin = funciones.getAdministrador(ndni);
						String[] alumno =funciones.getAlumno(ndni);
						String[] profesor =funciones.getProfe(ndni);
						//String[] usuario =funciones.getUsuario(ndni);
						String[] bibliotecario =funciones.getBibliotecario(ndni);
						String con = String.valueOf(pass);
						
						//si el dni es el del administrador
						if(ndni.equals(admin[2])){
							if(con.equals(admin[4])){
								
								//ADMINISTRADOR
								if(admin[3].equals("1")){  //El permiso 1 para el usuario
									
									new Administrador().setVisible(true);
									login.this.dispose(); //hago "invisible la clase login"
									
									//new nombredelaclase.setVisible(true);
									System.out.println("Hola soy el administrador");
								}
							}	
							JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.");
						
							
						}
						//Alumno	
						if(ndni.equals(alumno[2])){ //El permiso 2 para el administrador
							if(con.equals(alumno[4])){	  	
								new Alumno().setVisible(true);
								login.this.dispose();
								System.out.println("Hola soy el alumno");
							}else{	
								JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.");	
							}	
						}	
						//Profesor
						if(ndni.equals(profesor[2])){ //El permiso 2 para el administrador
							if(con.equals(profesor[4])){
								new Profesor().setVisible(true);
								login.this.dispose();
								System.out.println("Hola soy el profesor");
							}else{	
								JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.");	
							}	
					
					    }	
								
						//BIBLIOTECARIO	
						if(ndni.equals(bibliotecario[2])){ //El permiso 2 para el administrador
							
						    if(con.equals(bibliotecario[4])){
								new Bibliotecario().setVisible(true);
								login.this.dispose(); //hago "invisible la clase login"
								
								//new nombredelaclase.setVisible(true);
								System.out.println("Hola soy el bibliotecario");
							}else{	
								JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.");	
							}	
							
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
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDni.setBounds(131, 108, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBounds(110, 150, 97, 14);
		contentPane.add(lblContrasea);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}

