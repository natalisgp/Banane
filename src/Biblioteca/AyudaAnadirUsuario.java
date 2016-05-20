package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AyudaAnadirUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaAnadirUsuario frame = new AyudaAnadirUsuario();
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
	public AyudaAnadirUsuario() {
		setTitle("Ayuda A\u00F1adir Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("AYUDA");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(192, 22, 65, 14);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 67, 364, 169);
		contentPane.add(scrollPane);
		
		JTextPane txtpnDesdeLaPantalla = new JTextPane();
		scrollPane.setViewportView(txtpnDesdeLaPantalla);
		txtpnDesdeLaPantalla.setText("\tDesde la pantalla A\u00F1adir Usuario, puede registrarse en nuestra aplicaci\u00F3n. Para ello, rellene los diferentes campos, el \"DNI\" (Documento Nacional de Identidad) de la persona que se va a registrar, se pedir\u00E1 siempre que quiera acceder a la aplicaci\u00F3n. El \"Nombre\" y los dos \"Apellidos\" del nuevo usuario. El \"Username\" tiene que coincidir con el \"DNI\". Dentro de la casilla \"Permisos\", aparece \"1\" por defecto ya que va a ser un usuario el que va a registrarse. Dentro de la casilla \"Password\" introduzca una contrase\u00F1a, \u00E9sta se va a pedir cada vez que quiera acceder a nuestra aplicaci\u00F3n, por lo que es recomendable poner una que sepa que la va a recordar.\r\n\r\n\tSi no le hemos ayudado, estaremos encantados de poder atenderle y solucionar cualquiera problema o consulta que pudiera surgir.  Nuestro n\u00FAmero de atenci\u00F3n al cliente es el 987 50 49 22 en horario comercial o bien enviando un correo electr\u00F3nico a nernat@rovina.net desde el cual contestaremos con la mayor brevedad posible.");
		
		JLabel label_2 = new JLabel("ATRAS");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				new AnadirUsuario().setVisible(true);
				AyudaAnadirUsuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(365, 247, 69, 14);
		contentPane.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\diam.jpg"));
		label_1.setBounds(-455, -227, 932, 620);
		contentPane.add(label_1);
	}
}
