package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AyudaModificarUsuario extends JFrame {

	private JPanel AyudaModifDatosPerso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaModificarUsuario frame = new AyudaModificarUsuario();
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
	public AyudaModificarUsuario() {
		setTitle("Ayuda Modicar Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 291);
		AyudaModifDatosPerso = new JPanel();
		AyudaModifDatosPerso.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AyudaModifDatosPerso);
		AyudaModifDatosPerso.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 64, 356, 170);
		AyudaModifDatosPerso.add(scrollPane);
		
		JTextPane txtAyudaModifDatos = new JTextPane();
		scrollPane.setViewportView(txtAyudaModifDatos);
		txtAyudaModifDatos.setText("\tDesde la pantalla \"Modificar Usuario\", puede acceder a sus datos para modificar los campos que deseemos, excepto el DNI que solo lo podr\u00E1 modificar el administrador a trav\u00E9s de la base de datos. Si el DNI que introduce es incorrecto, le saltar\u00E1 una ventana advirtiendole que el DNI es incorrecto y no le dejar\u00E1 entrar a modificar los datos personales.\r\n\r\n\tSi no le hemos ayudado, estaremos encantados de poder atenderle y solucionar cualquiera problema o consulta que pudiera surgir.  Nuestro n\u00FAmero de atenci\u00F3n al cliente es el 987 50 49 22 en horario comercial o bien enviando un correo electr\u00F3nico a nernat@rovina.net desde el cual contestaremos con la mayor brevedad posible.");
		
		JLabel labelAyuda = new JLabel("AYUDA");
		labelAyuda.setForeground(Color.LIGHT_GRAY);
		labelAyuda.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelAyuda.setBounds(178, 32, 65, 14);
		AyudaModifDatosPerso.add(labelAyuda);
		
		JLabel label_1 = new JLabel("ATRAS");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new ModificarUsuario().setVisible(true);
				AyudaModificarUsuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(366, 245, 69, 14);
		AyudaModifDatosPerso.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(-38, -50, 932, 620);
		AyudaModifDatosPerso.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\diam.jpg"));
	}
}

