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


public class Materiales extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Materiales frame = new Materiales();
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
	public Materiales() {
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
					Materiales.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(417, 200, 34, 14);
		contentPane.add(label_1);
		
		JLabel lblAdministrador = new JLabel("Elegir una opción");
		lblAdministrador.setForeground(Color.BLACK);
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdministrador.setBounds(142, 22, 288, 23);
		contentPane.add(lblAdministrador);
		
		JButton btnModificarDatosUsuario = new JButton("Insertar Sala");
		btnModificarDatosUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new InsertarSala().setVisible(true);
				Materiales.this.dispose();
				System.out.println("Voy a insertar una nueva sala");
				
				
				
			}
		});
		btnModificarDatosUsuario.setBounds(26, 70, 126, 23);
		contentPane.add(btnModificarDatosUsuario);
		
		JButton btnAyuda = new JButton(new ImageIcon (this.getClass().getResource("/Imagenes/ayuda.jpg")));
		btnAyuda.setBorderPainted(false);
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAdministrador().setVisible(true); //Voy a crear usuario
				Materiales.this.dispose(); //hago "invisible la clase login"
			}
		});
		btnAyuda.setBounds(424, 11, 27, 23);
		contentPane.add(btnAyuda);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	    JButton button = new JButton("Eliminar Sala");
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		new EliminarSala().setVisible(true);
				Materiales.this.dispose();
				System.out.println("Voy eliminar una sala");
				
				
	    	}
	    });
	    button.setBounds(26, 120, 126, 23);
	    contentPane.add(button);
	    
	    JButton button_1 = new JButton("Insertar Libro");
	    button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new InsertarLibro().setVisible(true);
				Materiales.this.dispose();
				System.out.println("Voy insertar un nuevo libro");
				
				
				
			}
		});
	    button_1.setBounds(168, 70, 126, 23);
	    contentPane.add(button_1);
	    
	    JButton button_2 = new JButton("Insertar Tablet");
	    button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new InsertarTablet().setVisible(true);
				Materiales.this.dispose();
				System.out.println("Voy a insertar una nueva tablet");
				
				
				
			}
		});
	    button_2.setBounds(304, 70, 126, 23);
	    contentPane.add(button_2);
	    
	    JButton button_4 = new JButton("Eliminar Libro");
	    button_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		new EliminarLibro().setVisible(true);
				Materiales.this.dispose();
				System.out.println("Voy eliminar un libro");
				
				
	    	}
	    });
	    button_4.setBounds(168, 120, 126, 23);
	    contentPane.add(button_4);
	    
	    JButton button_6 = new JButton("Eliminar Tablet");
	    button_6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		new EliminarTablet().setVisible(true);
				Materiales.this.dispose();
				System.out.println("Voy eliminar una tablet");
				
				
	    	}
	    });
	    button_6.setBounds(304, 120, 126, 23);
	    contentPane.add(button_6);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}




