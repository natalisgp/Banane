package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.aeat.valida.Validador;

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
import java.awt.SystemColor;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class InsertarTablet extends JFrame {

	private JPanel contentPane;

	private JTextField tablet;
	private JTextField reserva;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarTablet frame = new InsertarTablet();
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
	public InsertarTablet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminarUsuario = new JLabel("Añadir Tablet");
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setBounds(144, 14, 133, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("TABLET");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(Color.WHITE);
		label.setBounds(75, 85, 46, 14);
		contentPane.add(label);
		
		tablet = new JTextField();
		tablet.setColumns(10);
		tablet.setBounds(206, 85, 114, 14);
		contentPane.add(tablet);
	
		
		JButton btnEliminar = new JButton("Insertar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ntablet= tablet.getText();
	
				String nreserva = "NO";
				
			
			

				
				if(ntablet.length()>0 &&  nreserva.length()>0) { 
					
		
						
							try{
							
					
								funciones.anadirTablet(ntablet, nreserva);							
								//new Usuario().setVisible(true);
								//	ModificarUsuario1.this.dispose();
								
							
								JOptionPane.showMessageDialog(null, "Se ha añadido una nueva tablet");
							
							
							
							} catch (SQLException er) {
								// TODO Auto-generated catch block
								er.printStackTrace();
							}
							//new Usuario().setVisible(true);
							//CrearUsuario.this.dispose();
							System.out.println("Estoy añadiendo un nueva tablet");
							
							
					
				}else{
					JOptionPane.showMessageDialog(null, "Error algun campo esta vacio ");
				}
				
			}

			private boolean checkalumnos(String s) {
				  Validador validador = new Validador();
			        int e = validador.checkNif(s);
			 
			        if (e > 0)
			            return true;
			        else
			            return false;
			}
		});
		btnEliminar.setBounds(144, 228, 89, 23);
		contentPane.add(btnEliminar);
		
		
		
		JLabel lblApellidos = new JLabel("RESERVA");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		//lblApellidos.setPrompt("Escriba aquí",20);
		lblApellidos.setBounds(74, 125, 69, 14);
		contentPane.add(lblApellidos);
		
	
		
		JButton lblAtras = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/flecha.jpg")));
		lblAtras.setBorderPainted(false);
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new Materiales().setVisible(true);
				InsertarTablet.this.dispose(); //hago "invisible la clase login"
			}
		});
		lblAtras.setForeground(Color.WHITE);
		lblAtras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAtras.setBounds(359, 232, 35, 14);
		contentPane.add(lblAtras);
		
		
		
		reserva = new JTextField();
		reserva.setColumns(10);
		reserva.setEditable(false);
		reserva.setText("NO");
		reserva.setBounds(206, 125, 114, 14);
		contentPane.add(reserva);
		
		
		
		JButton button = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/ayuda.jpg")));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAnadirUsuario().setVisible(true); //Voy a crear usuario
				InsertarTablet.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(370, 11, 24, 23);
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

