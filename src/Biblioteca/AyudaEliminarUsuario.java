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
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AyudaEliminarUsuario extends JFrame {

	private JPanel AyudaEliminarUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaEliminarUsuario frame = new AyudaEliminarUsuario();
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
	public AyudaEliminarUsuario() {
		setTitle("Ayuda Eliminar Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		AyudaEliminarUsuario = new JPanel();
		AyudaEliminarUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AyudaEliminarUsuario);
		AyudaEliminarUsuario.setLayout(null);
		
		JLabel labelAyuda = new JLabel("AYUDA");
		labelAyuda.setForeground(Color.BLACK);
		labelAyuda.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelAyuda.setBounds(185, 32, 65, 14);
		AyudaEliminarUsuario.add(labelAyuda);
		
		JTextPane txtEliminarUsuario = new JTextPane();
		txtEliminarUsuario.setText("\tDesde la pantalla \"Eliminar usuario\", el administrador puede eliminar el usuario que desee. Para ello, tiene que meter el DNI del usuario al que quiere eliminar, y pulsar el bot\u00F3n \"Eliminar\", y autom\u00E1ticamente, ese usuario se borrara de la base de datos.  \r\n\r\n\tSi no le hemos ayudado, estaremos encantados de poder atenderle y solucionar cualquiera problema o consulta que pudiera surgir.  Nuestro n\u00FAmero de atenci\u00F3n al cliente es el 987 50 49 22 en horario comercial o bien enviando un correo electr\u00F3nico a nernat@rovina.net desde el cual contestaremos con la mayor brevedad posible.");
		txtEliminarUsuario.setBounds(43, 68, 349, 160);
		AyudaEliminarUsuario.add(txtEliminarUsuario);
		
		JButton label_1 = new JButton(new ImageIcon("/Imagenes/flecha.jpg"));
		label_1.setBorderPainted(false);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new EliminarUsuario().setVisible(true);
				AyudaEliminarUsuario.this.dispose(); //hago "invisible la clase login"
				
				
			}
		});
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(357, 239, 35, 14);
		AyudaEliminarUsuario.add(label_1);
		
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
