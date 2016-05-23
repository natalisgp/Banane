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


public class Buscar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eliminar frame = new Eliminar();
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
	public Buscar() {
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
					Buscar.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(417, 200, 34, 14);
		contentPane.add(label_1);
		
		JLabel lblAdministrador = new JLabel("Elegir usuario a eliminar");
		lblAdministrador.setForeground(Color.BLACK);
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdministrador.setBounds(167, 11, 102, 14);
		contentPane.add(lblAdministrador);
		
		JButton btnModificarDatosUsuario = new JButton("PROFESOR");
		btnModificarDatosUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new BuscarProfe().setVisible(true);
				Buscar.this.dispose();
				System.out.println("Voy a buscar a un profesor");
				
				
				
			}
		});
		btnModificarDatosUsuario.setBounds(118, 75, 183, 23);
		contentPane.add(btnModificarDatosUsuario);
		
		JButton btnEliminarUsuario = new JButton("ALUMNO");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new BuscarAlumno().setVisible(true);
				Buscar.this.dispose();
				System.out.println("Voy a buscar a un usuario");
				
				
			}
		});
		btnEliminarUsuario.setBounds(118, 119, 183, 23);
		contentPane.add(btnEliminarUsuario);
		
		JButton btnAyuda = new JButton(new ImageIcon (this.getClass().getResource("/Imagenes/ayuda.jpg")));
		btnAyuda.setBorderPainted(false);
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAdministrador().setVisible(true); //Voy a crear usuario
				Buscar.this.dispose(); //hago "invisible la clase login"
			}
		});
		btnAyuda.setBounds(424, 11, 27, 23);
		contentPane.add(btnAyuda);
		
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



