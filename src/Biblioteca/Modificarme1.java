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
	private JTextField password;
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
			
			JLabel label_2 = new JLabel("ATRAS");
			label_2.addMouseListener(new MouseAdapter() {
				@Override
			
				public void mouseClicked(MouseEvent e) {
					new Modificarme().setVisible(true);
					Modificarme1.this.dispose(); //hago "invisible la clase login"
				}
			});
			label_2.setForeground(Color.LIGHT_GRAY);
			label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			label_2.setBackground(Color.WHITE);
			label_2.setBounds(355, 237, 69, 14);
			contentPane.add(label_2);
			
			dnis = new JTextField();
			dnis.setEditable(false);
			dnis.setColumns(10);
			dnis.setBounds(206, 39, 114, 20);
			contentPane.add(dnis);
			dnis.setText(Modificarme.ndni);
			
			JLabel lblEliminarUsuario = new JLabel("Modificar mis datos");
			lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblEliminarUsuario.setForeground(Color.LIGHT_GRAY);
			lblEliminarUsuario.setBounds(10, 11, 154, 20);
			contentPane.add(lblEliminarUsuario);
			
			JLabel label = new JLabel("DNI");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setForeground(Color.LIGHT_GRAY);
			label.setBounds(74, 42, 46, 14);
			contentPane.add(label);
			
			name = new JTextField();
			name.setColumns(10);
			name.setBounds(206, 69, 114, 20);
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
					String npassword = password.getText();
					
					if(nnombre.length()>0 && napellidos.length()>0 && nusername.length()>0 && npermisos.length()>0 && npassword.length()>0){ 
						
						
						if(ndni.equals(nusername)){
							
						
						try{
							
							funciones.modificarUsuarios(ndni,nnombre, napellidos, nusername, npermisos, npassword);
							
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
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblUsername.setForeground(Color.LIGHT_GRAY);
			lblUsername.setBounds(74, 137, 69, 14);
			contentPane.add(lblUsername);
			
			JLabel lblPermisos = new JLabel("PERMISOS");
			lblPermisos.setForeground(Color.LIGHT_GRAY);
			lblPermisos.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPermisos.setBounds(74, 174, 69, 14);
			contentPane.add(lblPermisos);
			
			surname = new JTextField();
			surname.setColumns(10);
			surname.setBounds(206, 101, 114, 20);
			contentPane.add(surname);
			surname.setText(datos[1]);
			
			username = new JTextField();
			username.setColumns(10);
			username.setBounds(206, 134, 114, 20);
			contentPane.add(username);
			username.setText(datos[2]);
			
			permisos = new JTextField();
			permisos.setColumns(10);
			permisos.setBounds(206, 171, 114, 20);
			contentPane.add(permisos);
			permisos.setText(datos[3]);
			
			password = new JTextField();
			password.setColumns(10);
			password.setBounds(206, 202, 114, 20);
			contentPane.add(password);
			password.setText(datos[4]);
			
			JLabel lblPassword = new JLabel("PASSWORD");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPassword.setForeground(Color.LIGHT_GRAY);
			lblPassword.setBounds(74, 205, 69, 14);
			contentPane.add(lblPassword);
			
			JLabel label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\diam.jpg"));
			label_1.setBounds(-50, -89, 568, 365);
			contentPane.add(label_1);
		}catch (Exception e){
			
		}
	}
}

