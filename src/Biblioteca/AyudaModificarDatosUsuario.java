package Biblioteca;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AyudaModificarDatosUsuario extends JFrame {

	private JPanel Ayuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaModificarDatosUsuario frame = new AyudaModificarDatosUsuario();
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
	public AyudaModificarDatosUsuario() {
		setTitle("Ayuda Modificar Datos Personales");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Ayuda = new JPanel();
		Ayuda.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Ayuda);
		Ayuda.setLayout(null);
		
		JLabel labelAyuda = new JLabel("AYUDA");
		labelAyuda.setForeground(Color.BLACK);
		labelAyuda.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelAyuda.setBounds(184, 29, 65, 14);
		Ayuda.add(labelAyuda);
		
		JTextPane txtAyudaModifUsu = new JTextPane();
		txtAyudaModifUsu.setText("\tDesde la pantalla \"Modificar Datos Personales\", el administrador puede acceder a los datos del usuario para modificar los campos que desee. Si el DNI del usuario que introduce es incorrecto, le saltar\u00E1 una ventana advirtiendole que el DNI es incorrecto y no le dejar\u00E1 entrar a modificar los datos personales del usuario.\r\n\r\n\tSi no le hemos ayudado, estaremos encantados de poder atenderle y solucionar cualquiera problema o consulta que pudiera surgir.  Nuestro n\u00FAmero de atenci\u00F3n al cliente es el 987 50 49 22 en horario comercial o bien enviando un correo electr\u00F3nico a nernat@rovina.net desde el cual contestaremos con la mayor brevedad posible.");
		txtAyudaModifUsu.setBounds(38, 69, 360, 160);
		Ayuda.add(txtAyudaModifUsu);
		
		JButton label_1 = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/flecha.jpg")));
		label_1.setBorderPainted(false);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new Modificarme().setVisible(true);
				AyudaModificarDatosUsuario.this.dispose(); //hago "invisible la clase login"
				
				
			}
		});
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(364, 240, 34, 14);
		Ayuda.add(label_1);
		
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
