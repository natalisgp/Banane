package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;
//
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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


public class Profesor extends JFrame {

	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profesor frame = new Profesor();
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
	public Profesor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton label_1 = new JButton(new ImageIcon(getClass().getResource("/Imagenes/flecha.jpg")));
		label_1.setBorderPainted(false);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new login().setVisible(true);
				Profesor.this.dispose(); //hago "invisible la clase login"
			}
		});
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(384, 238, 35, 14);
		contentPane.add(label_1);
		
		JLabel lblUsuario = new JLabel("PROFESOR");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(157, 11, 98, 14);
		contentPane.add(lblUsuario);
		
		JButton button = new JButton("Consultar datos personales");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new ProfesorDatos().setVisible(true); //Voy a crear usuario
				Profesor.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		button.setBounds(111, 114, 183, 23);
		contentPane.add(button);
		
		JButton btnModificarDatosPersonales = new JButton("Modificar datos personales");
		btnModificarDatosPersonales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ProfesorModificar().setVisible(true); //Voy a crear usuario
				Profesor.this.dispose(); //hago "invisible la clase login"
								
			}
		});
		btnModificarDatosPersonales.setBounds(111, 80, 183, 23);
		contentPane.add(btnModificarDatosPersonales);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new login().setVisible(true); //Voy a crear usuario
				Profesor.this.dispose(); //hago "invisible la clase login"
				
				
			}
		});
		btnLogout.setBounds(111, 148, 183, 23);
		contentPane.add(btnLogout);
		
		JButton ayuda = new JButton(new ImageIcon(getClass().getResource("/Imagenes/ayuda.jpg")));
		ayuda.setBorderPainted(false);
		ayuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaUsuario().setVisible(true); //Voy a crear usuario
				Profesor.this.dispose(); //hago "invisible la clase login"
				
				
				
			}
		});
		ayuda.setBounds(393, 22, 26, 23);
		contentPane.add(ayuda);
		
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

