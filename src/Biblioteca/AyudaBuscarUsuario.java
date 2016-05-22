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


public class AyudaBuscarUsuario extends JFrame {

	private JPanel AyudaBuscarUsua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaBuscarUsuario frame = new AyudaBuscarUsuario();
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
	public AyudaBuscarUsuario() {
		setTitle("Ayuda Buscar Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		AyudaBuscarUsua = new JPanel();
		AyudaBuscarUsua.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AyudaBuscarUsua);
		AyudaBuscarUsua.setLayout(null);
		
		JLabel labelAyuda = new JLabel("AYUDA");
		labelAyuda.setForeground(Color.BLACK);
		labelAyuda.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelAyuda.setBounds(186, 35, 65, 14);
		AyudaBuscarUsua.add(labelAyuda);
		
		JTextPane textAyuBuscarUsu = new JTextPane();
		textAyuBuscarUsu.setText("\tDesde la pantalla \"Buscar usuario\", el administrador puede buscar el usuario que desee. Para ello, tiene que meter el DNI del usuario al que quiere buscar, y pulsar el bot\u00F3n \"Buscar\". Si el DNI introducido es erronero, le saltar\u00E1 una ventana en la que se lo indicar\u00E1.  \r\n\r\n\tSi no le hemos ayudado, estaremos encantados de poder atenderle y solucionar cualquiera problema o consulta que pudiera surgir.  Nuestro n\u00FAmero de atenci\u00F3n al cliente es el 987 50 49 22 en horario comercial o bien enviando un correo electr\u00F3nico a nernat@rovina.net desde el cual contestaremos con la mayor brevedad posible.");
		textAyuBuscarUsu.setBounds(48, 79, 349, 160);
		AyudaBuscarUsua.add(textAyuBuscarUsu);
		
		JButton label_1 = new JButton(new ImageIcon("/Imagenes/flecha.jpg"));
		label_1.setBorderPainted(false);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				new BuscarUsuario().setVisible(true);
				AyudaBuscarUsuario.this.dispose(); //hago "invisible la clase login"
			}
			
		});
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(365, 250, 32, 14);
		AyudaBuscarUsua.add(label_1);
		
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

