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


public class InsertarLibro extends JFrame {

	private JPanel contentPane;

	private JTextField titulo;
	private JTextField autor;
	private JTextField signature;
	private JTextField id;
	private JTextField reserva;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarLibro frame = new InsertarLibro();
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
	public InsertarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminarUsuario = new JLabel("Añadir libro");
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setBounds(130, 11, 133, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("TITULO");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(Color.WHITE);
		label.setBounds(74, 42, 46, 14);
		contentPane.add(label);
		
		titulo = new JTextField();
		titulo.setColumns(10);
		titulo.setBounds(206, 42, 114, 14);
		contentPane.add(titulo);
	
		
		JButton btnEliminar = new JButton("Insertar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ntitulo= titulo.getText();
				
				String nautor = autor.getText();
				String nreservas = reserva.getText();
				String nsignatura =signature.getText();
				String nid = id.getText();
			

				
				if(ntitulo.length()>0 &&  nautor.length()>0 &&  nsignatura.length()>0&& nid.length()>0) { 
					
		
						
							try{
							
					
								funciones.anadirLibros(ntitulo, nautor, nsignatura, nreservas, nid);							
								//new Usuario().setVisible(true);
								//	ModificarUsuario1.this.dispose();
								
							
								JOptionPane.showMessageDialog(null, "Se ha añadido una nuevo libro");
							
							
							
							} catch (SQLException er) {
								// TODO Auto-generated catch block
								er.printStackTrace();
							}
							//new Usuario().setVisible(true);
							//CrearUsuario.this.dispose();
							System.out.println("Estoy añadiendo un nuevo libro");
							
							
					
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
		
		
		
		JLabel lblApellidos = new JLabel("AUTOR");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		//lblApellidos.setPrompt("Escriba aquí",20);
		lblApellidos.setBounds(74, 68, 69, 14);
		contentPane.add(lblApellidos);
		
	
		
		JButton lblAtras = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/flecha.jpg")));
		lblAtras.setBorderPainted(false);
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new Materiales().setVisible(true);
				InsertarLibro.this.dispose(); //hago "invisible la clase login"
			}
		});
		lblAtras.setForeground(Color.WHITE);
		lblAtras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAtras.setBounds(359, 232, 35, 14);
		contentPane.add(lblAtras);
		
		JLabel lblPermisos = new JLabel("SIGNATURE");
		lblPermisos.setForeground(Color.WHITE);
		lblPermisos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPermisos.setBounds(74, 96, 69, 14);
		contentPane.add(lblPermisos);
		
		
		
		autor = new JTextField();
		autor.setColumns(10);
		autor.setBounds(206, 68, 114, 14);
		contentPane.add(autor);
		
		
		
		JButton button = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/ayuda.jpg")));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAnadirUsuario().setVisible(true); //Voy a crear usuario
				InsertarLibro.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(370, 11, 24, 23);
		contentPane.add(button);
		
		JLabel lblPassword = new JLabel("ID");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(74, 146, 69, 14);
		contentPane.add(lblPassword);
		
		signature = new JTextField();
		
		signature.setBounds(206, 96, 114, 14);
		contentPane.add(signature);
		signature.setColumns(10);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	    id = new JTextField();
	    id.setColumns(10);
	    id.setBounds(206, 146, 114, 14);
	    contentPane.add(id);
	    
	    JLabel label_1 = new JLabel("RESERVA");
	    label_1.setForeground(Color.WHITE);
	    label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
	    label_1.setBounds(74, 121, 69, 14);
	    contentPane.add(label_1);
	    
	    reserva = new JTextField();
	    reserva.setBounds(206, 121, 114, 14);
	    reserva.setEditable(false);
		reserva.setText("NO");
	    contentPane.add(reserva);
	    
	    reserva.setColumns(10);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}

