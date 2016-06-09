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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;


public class AlquilerLibro extends JFrame {

	private JPanel contentPane;
	 static JComboBox<String> cmbBD;
	 Calendar calendario = new GregorianCalendar();
	 String dia,mes,anio;
	 String fecha;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	

	
	/**
	 * Create the frame.
	 */
	
	static void cargarcombogenero() {

		
		
		try {
			
		
		ResultSet rs = funciones.alquilarLibro();
		
		
//		while(rs.next()){
//			System.out.println(rs.getString("TABLET"));
//		}

			
		cmbBD.removeAllItems();
		cmbBD.addItem("---Selecionar Genero---");
		while(rs.next())
		{
		cmbBD.addItem(rs.getString("SIGNATURA"));
		}

		} catch (SQLException ex) {
		
		}

		}
	
	public AlquilerLibro() {
		
		//AlquilerTablet frame = new AlquilerTablet();
		
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
				
				new Alumno().setVisible(true);
				AlquilerLibro.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(377, 212, 26, 14);
		contentPane.add(label_2);
		
		JLabel lblEliminarUsuario = new JLabel("Elige un libro");
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setBounds(146, 25, 161, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("TABLET");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setForeground(Color.WHITE);
		label.setBounds(68, 87, 89, 14);
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
	
		
		JButton btnEliminar = new JButton("Alquilar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//coo el dni del alumno de login
				String[] datos = null;
				try {
					datos = funciones.getAlumno(login.ndni);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//busco en reserva si tiene alguna reserva no podra reservar
				
				String libro = (String)cmbBD.getSelectedItem();
				
				
				//CONSULTA ID LIBRO
				String [] datosLibro = null;
				try {
					datosLibro = funciones.getIdLibro(libro);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 
				
					
				
				if(datos[6]==null){ //si no tiene ninguna reserva reservar
				
					
					
					try {
						funciones.reservalibro(datosLibro[4],login.ndni);
						
						JOptionPane.showMessageDialog(null, "Has alquilado un libro");
						JOptionPane.showMessageDialog(null, "DEBES DEVOLVERLO ANTES DE QUE PASEN 3 DIAS.");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//guardo en la tabla del alumno la hora de reserva
					
					dia = Integer.toString(calendario.get(Calendar.DATE));
				    mes = Integer.toString(calendario.get(Calendar.MONTH));
				    anio = Integer.toString(calendario.get(Calendar.YEAR));
				    
				    fecha = dia+"/"+mes+"/"+anio;
					
					try {
						funciones.horaReseAlumno(fecha,login.ndni);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				
				}else{
					JOptionPane.showMessageDialog(null, "Tienes alguna reserva y no se puede realizar otra");
				}
				
			}
		});
		btnEliminar.setBounds(170, 170, 89, 23);
		contentPane.add(btnEliminar);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	    
	    cmbBD = new JComboBox<String>();
	    cmbBD.setBounds(162, 85, 175, 20);
	    contentPane.add(cmbBD);
	   
	    
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	    
		
		cargarcombogenero();
		setVisible(true);
	 
	}
	

	
	
}

