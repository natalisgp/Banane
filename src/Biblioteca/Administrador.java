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
		label_1.setBounds(424, 211, 34, 14);
		contentPane.add(label_1);
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setForeground(Color.BLACK);
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdministrador.setBounds(164, 11, 102, 14);
		contentPane.add(lblAdministrador);
		
		JButton btnModificarDatosUsuario = new JButton("Modificar datos usuario");
		btnModificarDatosUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Modificar().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a modificar un usuario");
				
				
				
			}
		});
		btnModificarDatosUsuario.setBounds(20, 89, 183, 14);
		contentPane.add(btnModificarDatosUsuario);
		
		JButton btnEliminarUsuario = new JButton("Eliminar usuario");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Eliminar().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a eliminar a un usuario");
				
				
			}
		});
		btnEliminarUsuario.setBounds(20, 114, 183, 14);
		contentPane.add(btnEliminarUsuario);
		
		JButton btnAltaUsuario = new JButton("Buscar usuario");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Buscar().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a buscar un usuario");
			
			}
		});
		btnAltaUsuario.setBounds(20, 61, 183, 14);
		contentPane.add(btnAltaUsuario);
		
		JButton btnBajaUsuario = new JButton("Añadir usuario");
		btnBajaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AnadirElegir().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a añadir un nuevo usuario");
				
				
			}
		});
		btnBajaUsuario.setBounds(20, 36, 183, 14);
		contentPane.add(btnBajaUsuario);
		
		JButton btnCargarBackupUsuario = new JButton("Cargar copia seguridad usuario");
		btnCargarBackupUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("Cargar Backup");
				chooser.showOpenDialog(null);
				File archivo2 = chooser.getSelectedFile();
				
				try {
					funciones.cargarBackupAlumno(archivo2);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnCargarBackupUsuario.setBounds(20, 175, 186, 14);
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
	    button_4.setBounds(20, 200, 186, 14);
	    contentPane.add(button_4);
	    
	    JButton button_6 = new JButton("Enviar email usuario");
	    button_6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		new EnviarEmaill().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a enviar un email");
	    		
	    	}
	    });
	    button_6.setBounds(20, 139, 183, 14);
	    contentPane.add(button_6);
	    
	    JButton button_7 = new JButton("Ejemplares");
	    button_7.setBounds(20, 150, 183, 14);
	    button_7.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		new Materiales().setVisible(true);
				Administrador.this.dispose();
				System.out.println("Voy a ver el materia");
	    		
	    	}
	    });
	    contentPane.add(button_7);
	    
	    JButton button_8 = new JButton("Copias de seguridad");
	    button_8.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		new Copias().setVisible(true);
				Administrador.this.dispose();
	    	}
	    });
	    button_8.setBounds(229, 139, 186, 14);
	    contentPane.add(button_8);
	    
	    JButton button_5 = new JButton("Cargar copias de seguridad");
	    button_5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		new Cargar().setVisible(true);
				Administrador.this.dispose();
	    	}
	    });
	    button_5.setBounds(229, 171, 186, 14);
	    contentPane.add(button_5);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}

