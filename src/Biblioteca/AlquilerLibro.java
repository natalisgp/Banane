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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AlquilerLibro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static String ndni;
	Calendar calendario = new GregorianCalendar();
	 String dia,mes,anio;
	 String fecha;
	 String nsignatura ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlquilerLibro frame = new AlquilerLibro();
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
	public AlquilerLibro() {
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
				
				new Bibliotecario().setVisible(true);
				AlquilerLibro.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(377, 212, 26, 14);
		contentPane.add(label_2);
		
		JLabel lblEliminarUsuario = new JLabel("Alquilar libro");
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setBounds(139, 11, 161, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("DNI USUARIO");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setForeground(Color.WHITE);
		label.setBounds(62, 122, 99, 14);
		contentPane.add(label);
		
		JButton button = new JButton(new ImageIcon(getClass().getResource("/Imagenes/ayuda.jpg")));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaEliminarUsuario().setVisible(true); //Voy a crear usuario
				AlquilerLibro.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(377, 22, 26, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(186, 120, 114, 20);
		contentPane.add(textField);
		
		JButton btnEliminar = new JButton("Alquilar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nsignatura = textField_1.getText();
				
				//consulta para cambiar el reservado del libro
				String [] datosLibro = null;
				try {
					datosLibro= funciones.getSignaRese(nsignatura);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String reserva = datosLibro[4];
				String solucion = null ;
				if(reserva.equals("NO")){
					solucion="SI";
					//JOptionPane.showMessageDialog(null, "EL LIBRO ESTA DISPONIBLE");
			    }else if(reserva.equals("SI")){
			    	reserva.equals("NO");
			    	solucion="NO";
			    	//JOptionPane.showMessageDialog(null, "EL LIBRO NO ESTA DISPONIBLE");
			    }
				
				try {
					funciones.cambiarReserva(solucion,nsignatura);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//MIRAR EL DNI
				
				
				ndni = textField.getText();
				
									
					try{
						String[] alumno =funciones.getAlumno(ndni);
						String[] profesor =funciones.getProfe(ndni);
						
						//fecha
						dia = Integer.toString(calendario.get(Calendar.DATE));
					    mes = Integer.toString(calendario.get(Calendar.MONTH));
					    anio = Integer.toString(calendario.get(Calendar.YEAR));
					    
					    fecha = dia+"/"+mes+"/"+anio;
						
						//Alumno	
						if(ndni.equals(alumno[2])){ //El permiso 2 para el administrador  	
							
							if(alumno[6]==null){	
								//pongo la reserva del alumno a si
								
								funciones.alquilaAlumnoLibro(nsignatura, fecha, alumno[2]);
								
							}else{
								solucion="NO";
								try {
									funciones.cambiarTablet(solucion,nsignatura);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								JOptionPane.showMessageDialog(null, "Ya tiene alguna reserva y no se puede realizar otra");
							}
							
							
							//le paso la signatura del libro a reservas y la hora
							
							
						}	
						//Profesor
						if(ndni.equals(profesor[2])){ //El permiso 2 para el administrador
							
							if(profesor[6]==null){	
								 //funciones.horaReseProfe(fecha, ndni);
								funciones.alquilaProfeLibro(nsignatura, fecha, ndni);
								
							}else{
								solucion="NO";
								try {
									funciones.cambiarTablet(solucion,nsignatura);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								JOptionPane.showMessageDialog(null, "Ya tiene alguna reserva y no se puede realizar otra");
							}
					
					    }	
						
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		//}else{
		//	JOptionPane.showMessageDialog(null, "Error los campos estan vacios.");
	//	}
		
	}
});
		btnEliminar.setBounds(170, 170, 89, 23);
		contentPane.add(btnEliminar);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(186, 70, 114, 20);
	    contentPane.add(textField_1);
	    
	    JLabel label_1 = new JLabel("SIGNATURA");
	    label_1.setForeground(Color.WHITE);
	    label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	    label_1.setBounds(62, 72, 80, 14);
	    contentPane.add(label_1);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}
