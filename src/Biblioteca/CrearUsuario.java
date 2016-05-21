package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
import com.aeat.valida.Validador;
import javax.swing.JComboBox;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField dni;
	private JTextField apellidos;
	private JTextField username;
	private JTextField password;
	private JRadioButton men,woman;
	JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	
public JRadioButton getMenOrWoman(String s){
		
		if(s.equals("woman")){
			return woman;
		}else if(s.equals("men")){
			return men;
		}else{
			return null;
		}
		
	}
	
	
	
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
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setBounds(10, 11, 95, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("DNI");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
	
		label.setForeground(Color.BLACK);
		label.setBounds(74, 42, 46, 14);
		contentPane.add(label);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(206, 69, 114, 20);
		contentPane.add(nombre);
	
		
		JButton btnEliminar = new JButton("Crear");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ndni = dni.getText();
				String nnombre = nombre.getText();
				String napellidos = apellidos.getText();
				String nusername = username.getText();
				String npermisos = (String)comboBox.getSelectedItem();
				String npassword = password.getText();
				boolean valid = checkDNI(dni.getText());
				
				if(ndni.length()>0 && nnombre.length()>0 && napellidos.length()>0 && nusername.length()>0 && npassword.length()>0){ 
					
					if(ndni.equals(nusername)){
						
						if(valid){
						
						    //Usuario
							if(npermisos.equals("2")){
								try{
							
					    
									funciones.crearNuevoUsuario(ndni, nnombre, napellidos, nusername, npermisos, npassword);							
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
		btnEliminar.setBounds(144, 228, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(74, 72, 69, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(74, 104, 69, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(74, 137, 69, 14);
		contentPane.add(lblUsername);
		
		JLabel lblAtras = new JLabel("ATRAS");
		lblAtras.setBackground(Color.BLACK);
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new login().setVisible(true);
				CrearUsuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		lblAtras.setForeground(Color.BLACK);
		lblAtras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAtras.setBounds(365, 232, 69, 14);
		contentPane.add(lblAtras);
		
		JLabel lblPermisos = new JLabel("PERMISOS");
		lblPermisos.setForeground(new Color(192, 192, 192));
		lblPermisos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPermisos.setBounds(74, 174, 69, 14);
		contentPane.add(lblPermisos);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(206, 39, 114, 20);
		contentPane.add(dni);
		
		apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBounds(206, 101, 114, 20);
		contentPane.add(apellidos);
		
		JButton button = new JButton("Ayuda");
		button.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				new AyudaCrearUsuario().setVisible(true); //Voy a crear usuario
				CrearUsuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		

		
		comboBox.addItem("2");
        comboBox.addItem("3");
		comboBox.setBounds(206, 171, 114, 20);
		contentPane.add(comboBox);
		button.setBounds(339, 201, 85, 23);
		contentPane.add(button);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(206, 134, 114, 20);
		contentPane.add(username);
		
	/*	permisos = new JTextField();
		permisos.setColumns(10);
		permisos.setBounds(206, 202, 114, 20);
		contentPane.add(permisos);*/
	
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(206, 202, 114, 20);
		contentPane.add(password);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(74, 205, 69, 14);
		contentPane.add(lblPassword);
		
		
		
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\fondo.jpg"));
		label_1.setBounds(-29, -49, 568, 365);
		contentPane.add(label_1);
	}
}
