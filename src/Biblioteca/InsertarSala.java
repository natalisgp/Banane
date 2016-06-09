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


public class InsertarSala extends JFrame {

	private JPanel contentPane;
	private JTextField alumnos;
	private JTextField nombre;
	private JTextField reservas;
	private JTextField numReserva;
	private JTextField tiempo;
	private JTextField id;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarSala frame = new InsertarSala();
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
	public InsertarSala() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminarUsuario = new JLabel("Añadir sala");
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setBounds(130, 11, 133, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("NOMBRE");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(Color.WHITE);
		label.setBounds(74, 42, 46, 14);
		contentPane.add(label);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(206, 42, 114, 14);
		contentPane.add(nombre);
	
		
		JButton btnEliminar = new JButton("Insertar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nnombre = nombre.getText();
				int nalumnos = Integer.parseInt(alumnos.getText());
				String nreservas = reservas.getText();
				int nnumRese =  Integer.parseInt(numReserva.getText());
				String ntiempo =tiempo.getText();
				String nid = id.getText();
				
			

				
				if(nnombre.length()>0 && nreservas.length()>0 && nid.length()>0) { 
					
		
						
							try{
							
					
								funciones.anadirSala(nnombre, nalumnos, nreservas, nnumRese, ntiempo, nid);							
								//new Usuario().setVisible(true);
								//	ModificarUsuario1.this.dispose();
								
							
								JOptionPane.showMessageDialog(null, "Se ha creado una nueva sala");
							
							
							
							} catch (SQLException er) {
								// TODO Auto-generated catch block
								er.printStackTrace();
							}
							//new Usuario().setVisible(true);
							//CrearUsuario.this.dispose();
							System.out.println("Estoy añadiendo una nueva sala");
							
							
					
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
		
		JLabel lblNombre = new JLabel("ALUMNOS");
		
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(74, 72, 69, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("RESERVA");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		//lblApellidos.setPrompt("Escriba aquí",20);
		lblApellidos.setBounds(74, 97, 69, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblUsername = new JLabel("NUMERO_RESERVAS");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(74, 122, 122, 14);
		contentPane.add(lblUsername);
		
		JButton lblAtras = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/flecha.jpg")));
		lblAtras.setBorderPainted(false);
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new Materiales().setVisible(true);
				InsertarSala.this.dispose(); //hago "invisible la clase login"
			}
		});
		lblAtras.setForeground(Color.WHITE);
		lblAtras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAtras.setBounds(359, 232, 35, 14);
		contentPane.add(lblAtras);
		
		JLabel lblPermisos = new JLabel("TIEMPO");
		lblPermisos.setForeground(Color.WHITE);
		lblPermisos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPermisos.setBounds(74, 147, 69, 14);
		contentPane.add(lblPermisos);
		
		alumnos = new JTextField();
		alumnos.setColumns(10);
		alumnos.setBounds(206, 67, 114, 14);
		contentPane.add(alumnos);
		
		reservas = new JTextField();
		reservas.setColumns(10);
		reservas.setEditable(false);
		reservas.setText("NO");
		reservas.setBounds(206, 92, 114, 14);
		contentPane.add(reservas);
		
		numReserva = new JTextField();
		numReserva.setEditable(false);
		numReserva.setColumns(10);
		numReserva.setText("0");
		numReserva.setBounds(206, 122, 114, 14);
		contentPane.add(numReserva);
		
		JButton button = new JButton(new ImageIcon(this.getClass().getResource("/Imagenes/ayuda.jpg")));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaAnadirUsuario().setVisible(true); //Voy a crear usuario
				InsertarSala.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(370, 11, 24, 23);
		contentPane.add(button);
		
		JLabel lblPassword = new JLabel("ID");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(74, 180, 69, 14);
		contentPane.add(lblPassword);
		
		tiempo = new JTextField();
		tiempo.setEditable(false);
		tiempo.setBackground(SystemColor.control);
		tiempo.setText("null");
		tiempo.setBounds(206, 147, 114, 20);
		contentPane.add(tiempo);
		tiempo.setColumns(10);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	    id = new JTextField();
	    id.setColumns(10);
	    id.setBounds(206, 177, 114, 14);
	    contentPane.add(id);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}

