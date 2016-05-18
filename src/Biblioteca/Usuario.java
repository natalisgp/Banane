package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Usuario extends JFrame {

	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
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
	public Usuario() {
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
				Usuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(375, 247, 69, 14);
		contentPane.add(label_1);
		
		JButton btnBuscarCatlogo_1 = new JButton("Buscar cat\u00E1logo");
		btnBuscarCatlogo_1.setBounds(111, 170, 183, 23);
		contentPane.add(btnBuscarCatlogo_1);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(Color.LIGHT_GRAY);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(10, 11, 55, 14);
		contentPane.add(lblUsuario);
		
		JButton button = new JButton("Consultar datos personales");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(111, 136, 183, 23);
		contentPane.add(button);
		
		JButton btnModificarDatosPersonales = new JButton("Modificar datos personales");
		btnModificarDatosPersonales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Modificarme().setVisible(true); //Voy a crear usuario
				Usuario.this.dispose(); //hago "invisible la clase login"
				
				
				
				
			}
		});
		btnModificarDatosPersonales.setBounds(111, 92, 183, 23);
		contentPane.add(btnModificarDatosPersonales);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(111, 238, 183, 23);
		contentPane.add(btnLogout);
		
		JButton btnBuscarProducto = new JButton("Buscar producto");
		btnBuscarProducto.setBounds(111, 204, 183, 23);
		contentPane.add(btnBuscarProducto);
		
		JButton btnBuscarCatlogo = new JButton("Ver cat\u00E1logos");
		btnBuscarCatlogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			//	new VerCatálogos().setVisible(true); //Voy a crear usuario
				Usuario.this.dispose(); //hago "invisible la clase login"
				
				
			}
		});
		btnBuscarCatlogo.setBounds(111, 58, 183, 23);
		contentPane.add(btnBuscarCatlogo);
		
		JButton ayuda = new JButton("Ayuda");
		ayuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaUsuario().setVisible(true); //Voy a crear usuario
				Usuario.this.dispose(); //hago "invisible la clase login"
				
				
				
			}
		});
		ayuda.setBounds(349, 212, 85, 23);
		contentPane.add(ayuda);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\diam.jpg"));
		label.setBounds(-92, -48, 568, 365);
		contentPane.add(label);
	}
}

