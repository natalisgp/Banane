package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;

import java.awt.SystemColor;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AyudaLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaLogin frame = new AyudaLogin();
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
	public AyudaLogin() {
		setTitle("Ayuda Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("ATRAS");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new login().setVisible(true);
				AyudaLogin.this.dispose(); //hago "invisible la clase login"
			}
		});
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(365, 257, 69, 14);
		contentPane.add(label_1);
		
		JLabel lblAyuda = new JLabel("AYUDA");
		lblAyuda.setForeground(Color.LIGHT_GRAY);
		lblAyuda.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAyuda.setBounds(179, 26, 65, 14);
		contentPane.add(lblAyuda);
		
		JTextPane txtpnDesdeEstaPantalla = new JTextPane();
		txtpnDesdeEstaPantalla.setBackground(SystemColor.control);
		txtpnDesdeEstaPantalla.setText("\tDesde la pantalla Login, introduciendo su DNI y Contrase\u00F1a, accede a nuestra aplicaci\u00F3n, en la cual podr\u00E1 consultar los productos que desee. Si le ha dado error, compruebe que ha escrito bien el usuario y la contrase\u00F1a, si aun as\u00ED sigue sin poder acceder, puede que sea porque no se encuentra registrado en nuestra base de datos, en tal caso consulte con nosotros. \r\n\r\n\tSi no le hemos ayudado, estaremos encantados de poder atenderle y solucionar cualquiera problema o consulta que pudiera surgir.  Nuestro n\u00FAmero de atenci\u00F3n al cliente es el 987 50 49 22 en horario comercial o bien enviando un correo electr\u00F3nico a nernat@rovina.net desde el cual contestaremos con la mayor brevedad posible.");
		txtpnDesdeEstaPantalla.setBounds(23, 51, 394, 195);
		contentPane.add(txtpnDesdeEstaPantalla);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\diam.jpg"));
		label.setBounds(-12, 0, 568, 365);
		contentPane.add(label);
	}
}

