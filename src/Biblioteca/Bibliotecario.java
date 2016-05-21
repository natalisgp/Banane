package Biblioteca;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class Bibliotecario extends JFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bibliotecario frame = new Bibliotecario();
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
	public Bibliotecario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("ATRAS");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
					
					new login().setVisible(true);
					Bibliotecario.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(397, 321, 69, 14);
		contentPane.add(label_1);
		
		JLabel lblBibliotecario = new JLabel("BIBLIOTECARIO");
		lblBibliotecario.setForeground(Color.LIGHT_GRAY);
		lblBibliotecario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBibliotecario.setBounds(10, 11, 102, 14);
		contentPane.add(lblBibliotecario);
		
		JButton btnModificarDatosUsuario = new JButton("Modificar datos usuario");
		btnModificarDatosUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new ModificarUsuario().setVisible(true);
				Bibliotecario.this.dispose();
				System.out.println("Voy a modificar un usuario");
				
				
				
			}
		});
		btnModificarDatosUsuario.setBounds(61, 36, 183, 23);
		contentPane.add(btnModificarDatosUsuario);
		
		JButton btnEliminarUsuario = new JButton("Eliminar usuario");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new EliminarUsuario().setVisible(true);
				Bibliotecario.this.dispose();
				System.out.println("Voy a eliminar a un usuario");
				
				
			}
		});
		btnEliminarUsuario.setBounds(61, 74, 183, 23);
		contentPane.add(btnEliminarUsuario);
		
		JButton btnAadirProducto = new JButton("A\u00F1adir producto a cat\u00E1logo");
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAadirProducto.setBounds(280, 36, 186, 23);
		contentPane.add(btnAadirProducto);
		
		JButton btnCargarBackupCatlogo = new JButton("Cargar copia seguridad cat\u00E1logo");
		btnCargarBackupCatlogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser("Cargar Backup");
				chooser.showOpenDialog(null);
				File archivo = chooser.getSelectedFile();
				
				try {
					funciones.cargarBackupCatalogo(archivo);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCargarBackupCatlogo.setBounds(61, 261, 197, 23);
		contentPane.add(btnCargarBackupCatlogo);
		
		JButton btnEliminarProducto = new JButton("Eliminar producto de cat\u00E1logo");
		btnEliminarProducto.setBounds(280, 74, 186, 23);
		contentPane.add(btnEliminarProducto);
		
		JButton btnAltaUsuario = new JButton("Buscar usuario");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new BuscarUsuario().setVisible(true);
				Bibliotecario.this.dispose();
				System.out.println("Voy a buscar un usuario");
			
			}
		});
		btnAltaUsuario.setBounds(61, 118, 186, 23);
		contentPane.add(btnAltaUsuario);
		
		JButton btnBajaUsuario = new JButton("Añadir usuario");
		btnBajaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AnadirUsuario().setVisible(true);
				Bibliotecario.this.dispose();
				System.out.println("Voy a añadir un nuevo usuario");
				
				
			}
		});
		btnBajaUsuario.setBounds(61, 164, 183, 23);
		contentPane.add(btnBajaUsuario);
		
		JButton btnAadirProductoAl = new JButton("A\u00F1adir cat\u00E1logo");
		btnAadirProductoAl.setBounds(280, 118, 186, 23);
		contentPane.add(btnAadirProductoAl);
		
		JButton btnEliminarProductoDel = new JButton("Eliminar cat\u00E1logo");
		btnEliminarProductoDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnBackupUsuarios = new JButton("Copia seguridad usuarios");
		btnBackupUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Dialogo para escoger donde guardar y con que nombre y extension
				JFileChooser choose = new JFileChooser("Guardar Backup");
				choose.showSaveDialog(null);
				File archivo2 = choose.getSelectedFile();
				
				try {
					funciones.hacerBackupUsuarios(archivo2);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnBackupUsuarios.setBounds(280, 261, 186, 23);
		contentPane.add(btnBackupUsuarios);
		btnEliminarProductoDel.setBounds(280, 164, 186, 23);
		contentPane.add(btnEliminarProductoDel);
		
		JButton btnCargarBackupUsuario = new JButton("Cargar copia seguridad usuario");
		btnCargarBackupUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("Cargar Backup");
				chooser.showOpenDialog(null);
				File archivo2 = chooser.getSelectedFile();
				
				try {
					funciones.cargarBackupUsuario(archivo2);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnCargarBackupUsuario.setBounds(58, 312, 186, 23);
		contentPane.add(btnCargarBackupUsuario);
		
		JButton btnModificarCatlogo = new JButton("Modificar cat\u00E1logo");
		btnModificarCatlogo.setBounds(61, 211, 186, 23);
		contentPane.add(btnModificarCatlogo);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAdministrador().setVisible(true); //Voy a crear usuario
			    Bibliotecario.this.dispose(); //hago "invisible la clase login"
			}
		});
		
		JButton btnBackupCatlogo = new JButton("Copia seguridad cat\u00E1logo");
		btnBackupCatlogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Dialogo para escoger donde guardar y con que nombre y extension
				JFileChooser choose = new JFileChooser("Guardar Backup");
				choose.showSaveDialog(null);
				File archivo = choose.getSelectedFile();
				
				try {
					funciones.hacerBackupCatalogo(archivo);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBackupCatlogo.setBounds(280, 211, 186, 23);
		contentPane.add(btnBackupCatlogo);
		btnAyuda.setBounds(463, 317, 75, 23);
		contentPane.add(btnAyuda);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\diam.jpg"));
		label.setBounds(-25, -45, 591, 426);
		contentPane.add(label);
	}

}

