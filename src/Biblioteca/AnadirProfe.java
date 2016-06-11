package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.aeat.valida.Validador;

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

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AnadirProfe extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField dni;
	private JTextField apellidos;
	private JTextField username;
	private JPasswordField password;
	private JTextField permisos;
	private JTextField email;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirProfe frame = new AnadirProfe();
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
	public AnadirProfe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminarUsuario = new JLabel("A\u00F1adir profesor");
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setBounds(130, 11, 133, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("DNI");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(Color.WHITE);
		label.setBounds(74, 42, 46, 14);
		contentPane.add(label);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(206, 69, 114, 14);
		contentPane.add(nombre);
	
		
		JButton btnEliminar = new JButton("A\u00F1adir");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ndni = dni.getText();
				String nnombre = nombre.getText();
				String napellidos = apellidos.getText();
				String nusername = username.getText();
				String npermisos =permisos.getText();
				char[] nopassword = password.getPassword();
				String npassword =String.valueOf(nopassword);
				String nemail = email.getText();
				
				
				boolean valid = checkDNI(dni.getText());
				
				if(ndni.length()>0 && nnombre.length()>0 && napellidos.length()>0 && nusername.length()>0 && npassword.length()>0 && nemail.length()>0){ 
					
					if(ndni.equals(nusername)){
						
						if(valid){
						
							try{
							
					
								funciones.anadirNuevoProfesor(ndni, nnombre, napellidos, nusername, npermisos, npassword,nemail);							
								//new Usuario().setVisible(true);
								//	ModificarUsuario1.this.dispose();
								String texto ="Buenos días usted se ha dado de alta con exito en el servicio de alta bibliotecario BANANE";
								String asunto = "Alta en BIBLIOBANANE";
								funciones m = new funciones();
								String correo = email.getText();
								m.SendMail(texto,correo,asunto);
								
								System.out.println("Estoy modificando los datos del profesor");
							
								JOptionPane.showMessageDialog(null, "Se ha creado un nuevo profesor");
							
							
							
							} catch (SQLException er) {
								// TODO Auto-generated catch block
								er.printStackTrace();
							}
							//new Usuario().setVisible(true);
							//CrearUsuario.this.dispose();
							System.out.println("Estoy creando un nuevo profesor");
							
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
		btnEliminar.setBounds(144, 228, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(74, 72, 69, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		//lblApellidos.setPrompt("Escriba aquí",20);
		lblApellidos.setBounds(74, 97, 69, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(74, 122, 69, 14);
		contentPane.add(lblUsername);
		
		JButton lblAtras = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/flecha.jpg")));
		lblAtras.setBorderPainted(false);
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new AnadirElegir().setVisible(true);
				AnadirProfe.this.dispose(); //hago "invisible la clase login"
			}
		});
		lblAtras.setForeground(Color.WHITE);
		lblAtras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAtras.setBounds(359, 232, 35, 14);
		contentPane.add(lblAtras);
		
		JLabel lblPermisos = new JLabel("PERMISOS");
		lblPermisos.setForeground(Color.WHITE);
		lblPermisos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPermisos.setBounds(74, 147, 69, 14);
		contentPane.add(lblPermisos);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(206, 39, 114, 14);
		contentPane.add(dni);
		
		apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBounds(206, 92, 114, 14);
		contentPane.add(apellidos);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(206, 122, 114, 14);
		contentPane.add(username);
		
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(206, 180, 114, 14);
		contentPane.add(password);
		
		JButton button = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/ayuda.jpg")));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAnadirUsuario().setVisible(true); //Voy a crear usuario
				AnadirProfe.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(370, 11, 24, 23);
		contentPane.add(button);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(74, 180, 69, 14);
		contentPane.add(lblPassword);
		
		JLabel label_2 = new JLabel("EMAIL");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(76, 205, 69, 14);
		contentPane.add(label_2);
		
		permisos = new JTextField();
		permisos.setEditable(false);
		permisos.setBackground(SystemColor.control);
		permisos.setText("3");
		permisos.setBounds(206, 147, 114, 20);
		contentPane.add(permisos);
		permisos.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(206, 203, 114, 14);
		contentPane.add(email);
		
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
