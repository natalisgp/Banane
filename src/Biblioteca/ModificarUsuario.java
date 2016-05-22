package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ModificarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	static String ndni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarUsuario frame = new ModificarUsuario();
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
	public ModificarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton label_2 = new JButton(new ImageIcon(getClass().getResource("/Imagenes/flecha.jpg")));
		label_2.setBorderPainted(false);
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new Administrador().setVisible(true);
				ModificarUsuario.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(381, 201, 29, 14);
		contentPane.add(label_2);
		
		JLabel label = new JLabel("DNI");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(Color.WHITE);
		label.setBounds(101, 113, 46, 14);
		contentPane.add(label);
		
		JButton btnEliminar = new JButton("Modificar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 ndni = textField_1.getText();
				
				 
				
				if(ndni.length()>0){ // y exista dicho dni
					
					try{
						String[] usuario = funciones.getUsuario(ndni);
						
						if(ndni.equals(usuario[2])){
							
							new ModificarUsuario1().setVisible(true);
							ModificarUsuario.this.dispose();
							System.out.println("Voy a modificar los datos de un usuario");
							
							
						}else {
							
							JOptionPane.showMessageDialog(null, "Error el dni no existe en la base de datos.");
							
							
						}
						
						
						
					} catch (SQLException er) {
						// TODO Auto-generated catch block
						er.printStackTrace();
					}
					
				
				}else{
					JOptionPane.showMessageDialog(null, "Error el campo esta vacio o el DNI no existe en la base de datos");
				}
				
			}
		});
		btnEliminar.setBounds(164, 179, 89, 23);
		contentPane.add(btnEliminar);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(196, 110, 114, 20);
		contentPane.add(textField_1);
		
		
		
		JLabel lblModificarUsuario = new JLabel("Modificar usuario");
		lblModificarUsuario.setForeground(Color.BLACK);
		lblModificarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModificarUsuario.setBounds(143, 23, 149, 14);
		contentPane.add(lblModificarUsuario);
		
		JButton button = new JButton(new ImageIcon(getClass().getResource("/Imagenes/ayuda.jpg")));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaModificarUsuario().setVisible(true);
				ModificarUsuario.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		button.setBounds(381, 23, 29, 23);
		contentPane.add(button);
		
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
