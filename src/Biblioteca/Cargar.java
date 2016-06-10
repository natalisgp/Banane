package Biblioteca;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

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


public class Cargar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cargar frame = new Cargar();
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
	public Cargar() {
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
				
					
					new Administrador().setVisible(true);
					Cargar.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(417, 200, 34, 14);
		contentPane.add(label_1);
		
		JLabel lblAdministrador = new JLabel("Cargar copias de seguridad");
		lblAdministrador.setForeground(Color.BLACK);
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdministrador.setBounds(142, 22, 288, 23);
		contentPane.add(lblAdministrador);
		
		JButton btnModificarDatosUsuario = new JButton("Administrador");
		btnModificarDatosUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JFileChooser chooser = new JFileChooser("Cargar Backup");
					chooser.showOpenDialog(null);
					File archivo2 = chooser.getSelectedFile();
					
					try {
						funciones.cargarBackupAdm(archivo2);
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
			});
		btnModificarDatosUsuario.setBounds(26, 70, 126, 23);
		contentPane.add(btnModificarDatosUsuario);
		
		JButton btnAyuda = new JButton(new ImageIcon (this.getClass().getResource("/Imagenes/ayuda.jpg")));
		btnAyuda.setBorderPainted(false);
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAdministrador().setVisible(true); //Voy a crear usuario
				Cargar.this.dispose(); //hago "invisible la clase login"
			}
		});
		btnAyuda.setBounds(424, 11, 27, 23);
		contentPane.add(btnAyuda);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	    JButton button = new JButton("Bibliotecario");
	    button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("Cargar Backup");
				chooser.showOpenDialog(null);
				File archivo2 = chooser.getSelectedFile();
				
				try {
					funciones.cargarBackupBiblio(archivo2);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	    button.setBounds(26, 120, 126, 23);
	    contentPane.add(button);
	    
	    JButton button_1 = new JButton("Alumno");
	    button_1.addActionListener(new ActionListener() {
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
	    button_1.setBounds(168, 70, 126, 23);
	    contentPane.add(button_1);
	    
	    JButton button_2 = new JButton("Profesor");
	    button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("Cargar Backup");
				chooser.showOpenDialog(null);
				File archivo2 = chooser.getSelectedFile();
				
				try {
					funciones.cargarBackupProfesor(archivo2);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	    button_2.setBounds(304, 70, 126, 23);
	    contentPane.add(button_2);
	    
	    JButton button_4 = new JButton("Salas");
	    button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("Cargar Backup");
				chooser.showOpenDialog(null);
				File archivo2 = chooser.getSelectedFile();
				
				try {
					funciones.cargarBackupSalas(archivo2);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	    button_4.setBounds(168, 120, 126, 23);
	    contentPane.add(button_4);
	    
	    JButton button_6 = new JButton("Tablet");
	    button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("Cargar Backup");
				chooser.showOpenDialog(null);
				File archivo2 = chooser.getSelectedFile();
				
				try {
					funciones.cargarBackupTablet(archivo2);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	    button_6.setBounds(304, 120, 126, 23);
	    contentPane.add(button_6);
	    
	    JButton button_5 = new JButton("Libros");
	    button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser("Cargar Backup");
				chooser.showOpenDialog(null);
				File archivo2 = chooser.getSelectedFile();
				
				try {
					funciones.cargarBackupLibros(archivo2);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	    button_5.setBounds(168, 169, 126, 23);
	    contentPane.add(button_5);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}






