package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.aeat.valida.Validador;
import javax.swing.JComboBox;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField dni;
	private JTextField apellidos;
	private JTextField username;
	private JPasswordField password;
	private JTextField email;
	JComboBox comboBox = new JComboBox();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario frame = new CrearUsuario();
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
	@SuppressWarnings("unchecked")
	public CrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminarUsuario = new JLabel("Crear usuario");
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setBounds(138, 8, 141, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("DNI");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
	
		label.setForeground(Color.WHITE);
		label.setBounds(76, 39, 46, 14);
		contentPane.add(label);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(206, 64, 114, 14);
		contentPane.add(nombre);
	
		
		JButton btnEliminar = new JButton("Crear");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ndni = dni.getText();
				String nnombre = nombre.getText();
				String napellidos = apellidos.getText();
				String nusername = username.getText();
				String npermisos = (String)comboBox.getSelectedItem();
				char[] nopassword = password.getPassword();
				String npassword =String.valueOf(nopassword);
				System.out.println(npassword);
				String nemail = email.getText();
				boolean valid = checkDNI(dni.getText());
				
				if(ndni.length()>0 && nnombre.length()>0 && napellidos.length()>0 && nusername.length()>0 && npassword.length()>0 && nemail.length()>0){ 
					
					if(ndni.equals(nusername)){
						
						if(valid){
						
						    //Usuario
							if(npermisos.equals("2")){
								try{
							
					    
									funciones.crearNuevoUsuario(ndni, nnombre, napellidos, nusername, npermisos, npassword,nemail);							
									//new Usuario().setVisible(true);
									//	ModificarUsuario1.this.dispose();
									System.out.println("Estoy modificando los datos del usuario");
							
									JOptionPane.showMessageDialog(null, "Se ha creado un nuevo usuario");
							
							
							
									} catch (SQLException er) {
										// TODO Auto-generated catch block
										er.printStackTrace();
									}
								//new Usuario().setVisible(true);
								//CrearUsuario.this.dispose();
								System.out.println("Estoy creando un nuevo usuario");
							
							//Bibliotecario	
							}else if(npermisos.equals("3")){
								
								try{
									
								    
									funciones.crearNuevoBibliotecario(ndni, nnombre, napellidos, nusername, npermisos, npassword);							
									//new Usuario().setVisible(true);
									//	ModificarUsuario1.this.dispose();
									System.out.println("Estoy modificando los datos del bibliotecario");
							
									JOptionPane.showMessageDialog(null, "Se ha creado un nuevo bibliotecario");
							
							
							
									} catch (SQLException er) {
										// TODO Auto-generated catch block
										er.printStackTrace();
									}
								//new Usuario().setVisible(true);
								//CrearUsuario.this.dispose();
								System.out.println("Estoy creando un nuevo bibliotecario");
								
							}
						}else{
							JOptionPane.showMessageDialog( null,"DNI no válido" , "DNI falso" ,JOptionPane.ERROR_MESSAGE );
						
						}
					
					
					}else{
						JOptionPane.showMessageDialog(null, "Error: El DNI tiene que ser igual que el USERNAME");
					
					
					}
				
				}else{
					JOptionPane.showMessageDialog(null, "Error algun campo esta vacio ");
				}
				
			}

			private boolean checkDNI(String s) {
				  Validador validador = new Validador();
			        int e = validador.checkNif(s);
			 
			        if (e > 0)
			            return true;
			        else
			            return false;
			}
		});
		btnEliminar.setBounds(152, 222, 69, 22);
		contentPane.add(btnEliminar);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(74, 64, 69, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(76, 89, 69, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(76, 114, 69, 14);
		contentPane.add(lblUsername);
		
		
		JButton lblAtras = new JButton(new ImageIcon(getClass().getResource("/Imagenes/flecha.jpg")));
		lblAtras.setBorderPainted(false);
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new login().setVisible(true);
				CrearUsuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		lblAtras.setForeground(Color.BLACK);
		lblAtras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAtras.setBounds(371, 230, 36, 14);
		contentPane.add(lblAtras);
		
		JButton button = new JButton(new ImageIcon(getClass().getResource("/Imagenes/ayuda.jpg")));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				new AyudaCrearUsuario().setVisible(true); //Voy a crear usuario
				CrearUsuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(383, 8, 24, 22);
		contentPane.add(button);
		
		JLabel lblPermisos = new JLabel("PERMISOS");
		lblPermisos.setForeground(Color.WHITE);
		lblPermisos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPermisos.setBounds(74, 142, 69, 14);
		contentPane.add(lblPermisos);
		
		JLabel label_2 = new JLabel("EMAIL");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(74, 198, 69, 12);
		contentPane.add(label_2);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(206, 39, 114, 14);
		contentPane.add(dni);
		
		apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBounds(206, 89, 114, 14);
		contentPane.add(apellidos);
		paintComponents(getGraphics());
		

		
		comboBox.addItem("2");
        comboBox.addItem("3");
		comboBox.setBounds(206, 139, 114, 20);
		contentPane.add(comboBox);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(206, 114, 114, 14);
		contentPane.add(username);
		
	/*	permisos = new JTextField();
		permisos.setColumns(10);
		permisos.setBounds(206, 202, 114, 20);
		contentPane.add(permisos);*/
	
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(206, 170, 114, 14);
		contentPane.add(password);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(206, 197, 114, 14);
		contentPane.add(email);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(74, 173, 69, 14);
		contentPane.add(lblPassword);	
		
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
