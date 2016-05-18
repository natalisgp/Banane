package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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


public class AñadirUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField dni;
	private JTextField apellidos;
	private JTextField username;
	private JTextField password;
	private JTextField permisos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirUsuario frame = new AñadirUsuario();
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
	public AñadirUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminarUsuario = new JLabel("A\u00F1adir usuario");
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEliminarUsuario.setForeground(Color.LIGHT_GRAY);
		lblEliminarUsuario.setBounds(10, 11, 95, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("DNI");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(Color.LIGHT_GRAY);
		label.setBounds(74, 42, 46, 14);
		contentPane.add(label);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(206, 69, 114, 20);
		contentPane.add(nombre);
	
		
		JButton btnEliminar = new JButton("A\u00F1adir");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ndni = dni.getText();
				String nnombre = nombre.getText();
				String napellidos = apellidos.getText();
				String nusername = username.getText();
				String npermisos =permisos.getText();
				String npassword = password.getText();
				
				if(ndni.length()>0 && nnombre.length()>0 && napellidos.length()>0 && nusername.length()>0 && npassword.length()>0){ 
					
					if(ndni.equals(nusername)){
						
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
						
					}else{
						JOptionPane.showMessageDialog(null, "Error: El DNI tiene que ser igual que el USERNAME");
					}		
						
						

					//new Usuario().setVisible(true);
					//CrearUsuario.this.dispose();
					System.out.println("Estoy creando un nuevo usuario");
					
				
				}else{
					JOptionPane.showMessageDialog(null, "Error algun campo esta vacio ");
				}
				
			}
		});
		btnEliminar.setBounds(144, 228, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(Color.LIGHT_GRAY);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(74, 72, 69, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.LIGHT_GRAY);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(74, 104, 69, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(74, 137, 69, 14);
		contentPane.add(lblUsername);
		
		JLabel lblAtras = new JLabel("ATRAS");
		lblAtras.setBackground(Color.WHITE);
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new Administrador().setVisible(true);
				AñadirUsuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		lblAtras.setForeground(Color.LIGHT_GRAY);
		lblAtras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAtras.setBounds(359, 232, 69, 14);
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
		
		JButton button = new JButton("Ayuda");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAñadirUsuario().setVisible(true); //Voy a crear usuario
				AñadirUsuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(349, 201, 75, 23);
		contentPane.add(button);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setBounds(74, 205, 69, 14);
		contentPane.add(lblPassword);
		
		permisos = new JTextField();
		permisos.setEditable(false);
		permisos.setBackground(SystemColor.control);
		permisos.setText("1");
		permisos.setBounds(206, 171, 114, 20);
		contentPane.add(permisos);
		permisos.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\diam.jpg"));
		label_1.setBounds(-29, -49, 568, 365);
		contentPane.add(label_1);
	}
}
