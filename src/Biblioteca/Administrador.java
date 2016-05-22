package Biblioteca;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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


public class Administrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
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
	public Administrador() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton label_1 = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/flecha.jpg")));
		label_1.setBorderPainted(false);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
					
					new login().setVisible(true);
					Administrador.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(417, 200, 34, 14);
		contentPane.add(label_1);
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setForeground(Color.BLACK);
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdministrador.setBounds(167, 11, 102, 14);
		contentPane.add(lblAdministrador);
		
		JButton btnModificarDatosUsuario = new JButton("Modificar datos usuario");
		btnModificarDatosUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new ModificarUsuario().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a modificar un usuario");
				
				
				
			}
		});
		btnModificarDatosUsuario.setBounds(20, 89, 183, 14);
		contentPane.add(btnModificarDatosUsuario);
		
		JButton btnEliminarUsuario = new JButton("Eliminar usuario");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new EliminarUsuario().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a eliminar a un usuario");
				
				
			}
		});
		btnEliminarUsuario.setBounds(20, 114, 183, 14);
		contentPane.add(btnEliminarUsuario);
		
		JButton btnAltaUsuario = new JButton("Buscar usuario");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new BuscarUsuario().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a buscar un usuario");
			
			}
		});
		btnAltaUsuario.setBounds(20, 61, 183, 14);
		contentPane.add(btnAltaUsuario);
		
		JButton btnBajaUsuario = new JButton("Añadir usuario");
		btnBajaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AnadirUsuario().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a añadir un nuevo usuario");
				
				
			}
		});
		btnBajaUsuario.setBounds(20, 36, 183, 14);
		contentPane.add(btnBajaUsuario);
		
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
		btnBackupUsuarios.setBounds(20, 189, 186, 14);
		contentPane.add(btnBackupUsuarios);
		
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
		btnCargarBackupUsuario.setBounds(20, 164, 186, 14);
		contentPane.add(btnCargarBackupUsuario);
		
		JButton btnAyuda = new JButton(new ImageIcon (this.getClass().getResource("/Imagenes/ayuda.jpg")));
		btnAyuda.setBorderPainted(false);
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAdministrador().setVisible(true); //Voy a crear usuario
				Administrador.this.dispose(); //hago "invisible la clase login"
			}
		});
		btnAyuda.setBounds(424, 11, 27, 23);
		contentPane.add(btnAyuda);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	    JButton button = new JButton("Añadir bibliotecario");
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		new AnadirBibliotecario().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a añadir un nuevo bibliotecario");
	    	}
	    });
	    button.setBounds(229, 36, 183, 14);
	    contentPane.add(button);
	    
	    JButton button_1 = new JButton("Buscar bibliotecario");
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		new ModificarBibliotecario().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a modificar un bibliotecario");
	    	}
	    });
	    button_1.setBounds(229, 61, 183, 14);
	    contentPane.add(button_1);
	    
	    JButton button_2 = new JButton("Modificar datos bibliotecario");
	    button_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		new ModificarBibliotecario().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a modificar un usuario");
	    		
	    	}
	    });
	    button_2.setBounds(229, 89, 183, 14);
	    contentPane.add(button_2);
	    
	    JButton button_3 = new JButton("Eliminar bibliotecario");
	    button_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		new EliminarBibliotecario().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a eliminar a un Bibliotecario");
	    	}
	    });
	    button_3.setBounds(229, 114, 183, 14);
	    contentPane.add(button_3);
	    
	    JButton button_4 = new JButton("Cargar copia bibliotecario");
	    button_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    button_4.setBounds(229, 164, 186, 14);
	    contentPane.add(button_4);
	    
	    JButton button_5 = new JButton("Copia seguridad bibliotecario");
	    button_5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    button_5.setBounds(229, 189, 186, 14);
	    contentPane.add(button_5);
	    
	    JButton button_6 = new JButton("Enviar email usuario");
	    button_6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    button_6.setBounds(20, 139, 183, 14);
	    contentPane.add(button_6);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}

