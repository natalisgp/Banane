package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AyudaUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaUsuario frame = new AyudaUsuario();
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
	public AyudaUsuario() {
		setTitle("Ayuda Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton label_1 = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/flecha.jpg")));
		label_1.setBorderPainted(false);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new Alumno().setVisible(true);
				AyudaUsuario.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(365, 245, 33, 14);
		contentPane.add(label_1);
		
		JLabel AyudaUsu = new JLabel("AYUDA");
		AyudaUsu.setForeground(Color.BLACK);
		AyudaUsu.setFont(new Font("Tahoma", Font.BOLD, 15));
		AyudaUsu.setBounds(188, 31, 65, 14);
		contentPane.add(AyudaUsu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 65, 355, 169);
		contentPane.add(scrollPane);
		
		JTextPane txtoAyudUsu = new JTextPane();
		scrollPane.setViewportView(txtoAyudUsu);
		txtoAyudUsu.setText("\tDesde la pantalla Usuario, puede acceder a modificar los datos personales si lo desea, para ello pulse el bot\u00F3n \"Modificar datos personales\", o si lo prefiere, puede solo consultarlos pulsando el bot\u00F3n \"Consultar datos personales\". Si quiere buscar un producto en concreto, pulse el bot\u00F3n \"Buscar producto\". Para buscar un cat\u00E1logo, punse el bot\u00F3n \"Buscar catalogo\". Si desea salir de la aplicaci\u00F3n, pulse el bot\u00F3n \"Logout\".\r\n\r\n\tSi no le hemos ayudado, estaremos encantados de poder atenderle y solucionar cualquiera problema o consulta que pudiera surgir.  Nuestro n\u00FAmero de atenci\u00F3n al cliente es el 987 50 49 22 en horario comercial o bien enviando un correo electr\u00F3nico a nernat@rovina.net desde el cual contestaremos con la mayor brevedad posible.");
		
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

