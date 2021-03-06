package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Modificarme1 extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField dnis;
	private JTextField surname;
	private JTextField username;
	private JTextField permisos;
	private JTextField email;
	
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificarme1 frame = new Modificarme1();
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
	public Modificarme1() {
		
		try{
			String[] datos = funciones.getAdministrador(Modificarme.ndni);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton label_2 = new JButton(new ImageIcon(getClass().getResource("/Imagenes/flecha.jpg")));
			label_2.setBorderPainted(false);
			label_2.addMouseListener(new MouseAdapter() {
				@Override
			
				public void mouseClicked(MouseEvent e) {
					new Modificarme().setVisible(true);
					Modificarme1.this.dispose(); //hago "invisible la clase login"
				}
			});
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			label_2.setBackground(Color.WHITE);
			label_2.setBounds(383, 233, 28, 14);
			contentPane.add(label_2);
			
			dnis = new JTextField();
			dnis.setEditable(false);
			dnis.setColumns(10);
			dnis.setBounds(206, 39, 114, 14);
			contentPane.add(dnis);
			dnis.setText(Modificarme.ndni);
			
			JLabel lblEliminarUsuario = new JLabel("Modificar mis datos");
			lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEliminarUsuario.setForeground(Color.BLACK);
			lblEliminarUsuario.setBounds(126, 8, 154, 20);
			contentPane.add(lblEliminarUsuario);
			
			JLabel label = new JLabel("DNI");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setForeground(Color.WHITE);
			label.setBounds(74, 42, 46, 14);
			contentPane.add(label);
			
			name = new JTextField();
			name.setColumns(10);
			name.setBounds(206, 69, 114, 14);
			contentPane.add(name);
			name.setText(datos[0]);
			
			JButton btnEliminar = new JButton("Modificar datos");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String ndni = dnis.getText();
					String nnombre = name.getText();
					String napellidos = surname.getText();
					String nusername = username.getText();
					String npermisos = permisos.getText();
					String nemail = email.getText();
					char[] nopassword = password.getPassword();
					String npassword =String.valueOf(nopassword);
					
					if(nnombre.length()>0 && napellidos.length()>0 && nusername.length()>0 && npermisos.length()>0 && npassword.length()>0 && nemail.length()>0){ 
						
						
						if(ndni.equals(nusername)){
							
						
						try{
							
							funciones.modificarUsuarios(ndni,nnombre, napellidos, nusername, npermisos, npassword,nemail);
							
							//new Usuario().setVisible(true);
							Modificarme1.this.dispose();
							System.out.println("Estoy modificando los datos del usuario");
							
							
							
						} catch (SQLException er) {
							// TODO Auto-generated catch block
							er.printStackTrace();
						}
						
						}else{
							JOptionPane.showMessageDialog(null, "Error: El DNI tiene que ser igual que el USERNAME");
						}
					
					}else{
						JOptionPane.showMessageDialog(null, "Error algun campo esta vacio ");
					}
					
				}
			});
			btnEliminar.setBounds(134, 233, 133, 23);
			contentPane.add(btnEliminar);
			
			JLabel lblNombre = new JLabel("NOMBRE");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNombre.setBounds(74, 69, 69, 14);
			contentPane.add(lblNombre);
			
			JLabel label1 = new JLabel("EMAIL");
			label1.setForeground(Color.WHITE);
			label1.setFont(new Font("Tahoma", Font.BOLD, 11));
			label1.setBounds(76, 205, 69, 14);
			contentPane.add(label1);
			
			
			JLabel lblApellidos = new JLabel("APELLIDOS");
			lblApellidos.setForeground(Color.WHITE);
			lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblApellidos.setBounds(74, 94, 69, 14);
			contentPane.add(lblApellidos);
			
			JLabel lblUsername = new JLabel("USERNAME");
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setBounds(74, 119, 69, 14);
			contentPane.add(lblUsername);
			
			JLabel lblPermisos = new JLabel("PERMISOS");
			lblPermisos.setForeground(Color.WHITE);
			lblPermisos.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPermisos.setBounds(74, 144, 69, 14);
			contentPane.add(lblPermisos);
			
			
			
			surname = new JTextField();
			surname.setColumns(10);
			surname.setBounds(206, 94, 114, 14);
			contentPane.add(surname);
			surname.setText(datos[1]);
			
			username = new JTextField();
			username.setColumns(10);
			username.setBounds(206, 119, 114, 14);
			contentPane.add(username);
			username.setText(datos[2]);
			
			permisos = new JTextField();
			permisos.setColumns(10);
			permisos.setBounds(206, 144, 114, 14);
			contentPane.add(permisos);
			permisos.setText(datos[3]);
			
			email = new JTextField();
			email.setColumns(10);
			email.setBounds(206, 205, 114, 14);
			contentPane.add(email);
			
			password = new JPasswordField();
			password.setColumns(10);
			password.setBounds(206, 174, 114, 14);
			contentPane.add(password);
			password.setText(datos[4]);
			
			JLabel lblPassword = new JLabel("PASSWORD");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setBounds(74, 174, 69, 14);
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
		}catch (Exception e){
			
		}
	}
}

