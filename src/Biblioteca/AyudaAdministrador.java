package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AyudaAdministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaAdministrador frame = new AyudaAdministrador();
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
	public AyudaAdministrador() {
		setResizable(false);
		setTitle("Ayuda Administrador");
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
				
				new Administrador().setVisible(true);
				AyudaAdministrador.this.dispose(); //hago "invisible la clase login"
			}
		});
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(375, 258, 69, 14);
		contentPane.add(label_1);
		
		JLabel Ayuda = new JLabel("AYUDA");
		Ayuda.setForeground(Color.LIGHT_GRAY);
		Ayuda.setFont(new Font("Tahoma", Font.BOLD, 15));
		Ayuda.setBounds(182, 23, 65, 14);
		contentPane.add(Ayuda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 48, 388, 202);
		contentPane.add(scrollPane);
		
		JTextPane TextoAyudaAdmin = new JTextPane();
		scrollPane.setViewportView(TextoAyudaAdmin);
		TextoAyudaAdmin.setBackground(SystemColor.control);
		TextoAyudaAdmin.setText("\tDesde la pantalla Administrador, puede acceder a modificar los datos personales del usuario, para ello pulse el bot\u00F3n \"Modificar datos usuario\". Para eliminar un usuario de la base de datos, pulse \"Eliminar usuario\". Si desea buscar a un usuario en concreto, pulse el bot\u00F3n \"Buscar usuario\". Para a\u00F1adir a la base de datos a un nuevo usuario, pulse el bot\u00F3n \"A\u00F1adir usuario\".  Si desea modificar alg\u00FAn cat\u00E1logo, pulse el bot\u00F3n \"Modificar cat\u00E1logo\". Para eliminar o a\u00F1adir un producto a un cat\u00E1logo, pulse el bot\u00F3n \"Eliminar producto de catalogo\" o \"A\u00F1adir producto a cat\u00E1logo\" respectivamente. Para modificar un producto en concreto, pulse el bot\u00F3n \"Modificar producto\". Si lo que desea es a\u00F1adir o eliminar un cat\u00E1logo, pulse el bot\u00F3n \"A\u00F1adir catalogo\" o \"Eliminar catalogo\" respectivamente. Para hacer una copia de seguridad, pulse el bot\u00F3n \"Copia\".\r\n\r\n\tSi no le hemos ayudado, estaremos encantados de poder atenderle y solucionar cualquiera problema o consulta que pudiera surgir.  Nuestro n\u00FAmero de atenci\u00F3n al cliente es el 987 50 49 22 en horario comercial o bien enviando un correo electr\u00F3nico a nernat@rovina.net desde el cual contestaremos con la mayor brevedad posible.");
		
		JLabel label = new JLabel("");
		label.setBounds(-22, -18, 932, 620);
		contentPane.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\diam.jpg"));
	}
}
