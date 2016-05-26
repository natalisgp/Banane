package Biblioteca;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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


public class EmailA extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField correo;
	private JPasswordField password;
	private String email;
	private String contra;
	
	private JButton access = new JButton( "Enter" );
	private JButton cancel = new JButton( "Delete" );
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailA frame = new EmailA();
		
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
	public EmailA() {
		
		try{
			String[] datos = funciones.getAdministrador(login.ndni);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			//ATRAS
			JButton label_2 = new JButton(new ImageIcon(getClass().getResource("/Imagenes/flecha.jpg")));
			label_2.setBorderPainted(false);
			label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					new ModificarBibliotecario().setVisible(true);
					EmailA.this.dispose(); //hago "invisible la clase login"
				}
			});
			//ACABA ATRAS
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			label_2.setBackground(Color.WHITE);
			label_2.setBounds(381, 233, 30, 14);
			contentPane.add(label_2);
			
			
			JLabel lblEliminarUsuario = new JLabel("Introduce contraseña");
			lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEliminarUsuario.setForeground(Color.BLACK);
			lblEliminarUsuario.setBounds(114, 11, 245, 20);
			contentPane.add(lblEliminarUsuario);
			
			JLabel label = new JLabel("Email");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setForeground(Color.WHITE);
			label.setBounds(74, 102, 46, 14);
			contentPane.add(label);
			
			correo = new JTextField();
			correo.setColumns(10);
			correo.setBounds(134, 102, 186, 14);
			contentPane.add(correo);
			correo.setText(datos[5]);
			email=datos[5];
			
			
			
			
			
			access.setBounds(84, 206, 80, 23);
			contentPane.add(access);
			
		    cancel.setBounds(225, 206, 80, 23);
			contentPane.add(cancel);
						
			password = new JPasswordField();
			password.setColumns(10);
			password.setBounds(153, 142, 167, 14);
			contentPane.add(password);
			
			//password.setText(datos[4]);
			
		
			
			JLabel lblPassword = new JLabel("PASSWORD");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setBounds(74, 142, 69, 14);
			contentPane.add(lblPassword);
			
			//Icono
		    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
		    //Fondo
		    ((JPanel)getContentPane()).setOpaque(false);
		    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
		    JLabel fondo= new JLabel(); 
		    fondo.setIcon(uno); 
		    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
		    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		}catch (Exception e){
			
		}
		
		actions();
	}

	public void actions(){
		access.addActionListener( new ActionListener(){
			
			public void actionPerformed(ActionEvent evento ){ 
				char[] nopassword = password.getPassword();
				contra =String.valueOf(nopassword);
				System.out.println("soy la contraseña"+contra);
				
				EmailWindow em = new EmailWindow(email,contra);
				em.setVisible(true);
			}	
				
		});
		
		cancel.addActionListener( new ActionListener(){
		
			public void actionPerformed(ActionEvent event ){
				
				password.setText( "" );

			}
		});
		
	}

	
	
	
}



