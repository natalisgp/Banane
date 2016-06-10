package Biblioteca;



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


public class DisponiLibro1 extends JFrame {

	private JPanel contentPane;
	 static JComboBox<String> conTitulo; 
	 Calendar calendario = new GregorianCalendar();
		int hora,minutos,segundos;
		String reloj;
		String suma;
		String asig ;
		private JTextField textField;
		String reserva;
		String signatura;
		String autor;
		String solucion;
	
		private JTextField Tautor;
		private JTextField Tsignatura;

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
	 * @param consulta 
	 */
		
		static void cargarTitulos(String asigna) {

			
			
			try {
		
			
				ResultSet rs = funciones.devoTitulo(asigna);
				
				
			while(rs.next()){
					//System.out.println(rs.getString("TITULO"));
					conTitulo.addItem(rs.getString("TITULO"));
					
		    }
	
					
				//conTitulo.removeAllItems();
				//conTitulo.addItem("---Selecionar Genero---");
				while(rs.next()){
				conTitulo.addItem(rs.getString("TITULO"));
				}

			} catch (SQLException ex) {
			
			}

			}	
		
		
		
		
	
	/*static void cargarcombogenero() {

		
		
		try {
			
		
		ResultSet rs = funciones.devoAsignatura();
		while(rs.next())
		{
		cmbBD.addItem(rs.getString("ASIGNATURA"));
		}

		} catch (SQLException ex) {
		
		}

		}*/
	
	public DisponiLibro1(String asigna) {
		
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
				
				new DisponiLibro().setVisible(true);
				DisponiLibro1.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(377, 212, 26, 14);
		contentPane.add(label_2);
		
		JLabel lblEliminarUsuario = new JLabel("Busca la el libro");
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setBounds(139, 11, 161, 20);
		contentPane.add(lblEliminarUsuario);
		
		JButton button = new JButton(new ImageIcon(getClass().getResource("/Imagenes/ayuda.jpg")));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaEliminarUsuario().setVisible(true); //Voy a crear usuario
				DisponiLibro1.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(377, 22, 26, 23);
		contentPane.add(button);
	
		
		JButton btnEliminar = new JButton("Consultar");
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
				
				//String asigna = (String)cmbBD.getSelectedItem();
				String titulo = (String)conTitulo.getSelectedItem();
				
				//Consulta ID TABLET
				String [] datosTablet = null;
				try {
					datosTablet = funciones.getIdLibro(titulo);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 
			
				//LOS DATOS DEL LIBRO QUE HEMOS SELECIONADO
				
				autor = datosTablet[2];
				
				signatura = datosTablet[3];
				reserva = datosTablet[4];
				//System.out.println(reserva);
				//System.out.println(reserva);
				
				if(reserva.equals("NO")){
					solucion="SI";
					JOptionPane.showMessageDialog(null, "EL LIBRO ESTA DISPONIBLE");
			    }else if(reserva.equals("SI")){
			    	reserva.equals("NO");
			    	solucion="NO";
			    	JOptionPane.showMessageDialog(null, "EL LIBRO NO ESTA DISPONIBLE");
			    }
				
				
				 textField = new JTextField();
				 textField.setBounds(239, 172, 51, 20);
				 textField.setEditable(false);
				 textField.setText(solucion);
				 contentPane.add(textField);
				 textField.setColumns(10);
				 
				 
				 Tsignatura = new JTextField();
				   // Tsignatura.setText((String) null);
				    Tsignatura.setEditable(false);
				    Tsignatura.setColumns(10);
				    Tsignatura.setBounds(178, 130, 167, 20);
				    Tsignatura.setText(signatura);
				    contentPane.add(Tsignatura);
				    
				    Tautor = new JTextField();
				   // Tautor.setText((String) null);
				    Tautor.setEditable(false);
				    Tautor.setColumns(10);
				    Tautor.setBounds(178, 104, 167, 20);
				    Tautor.setText(autor);
				    contentPane.add(Tautor);
				 
				 
				    
				   // JOptionPane.showMessageDialog(null, "LA TABLET"+solucion"");
				
				/*
				
				if(datos[6]==null){ //si no tiene ninguna reserva reservar
				

					try {
						funciones.reservalibro(tablet,login.ndni);
						
						JOptionPane.showMessageDialog(null, "Has alquilado una tablet.");
						JOptionPane.showMessageDialog(null, "DEBES DEVOLVERLA ANTES DE QUE PASEN 2 HORAS.");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					//guardo en la tabla del alumno la hora de reserva
					
					hora =calendario.get(Calendar.HOUR_OF_DAY);
					minutos = calendario.get(Calendar.MINUTE);
					segundos = calendario.get(Calendar.SECOND);
						
				    reloj = Integer.toString(hora)+":"+Integer.toString(minutos);
					
					try {
						funciones.horaReseAlumno(reloj,login.ndni);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					
					
				
				}else{
					JOptionPane.showMessageDialog(null, "Tienes alguna reserva y no se puede realizar otra");
				}
				*/
			}
		});
		btnEliminar.setBounds(148, 212, 89, 23);
		contentPane.add(btnEliminar);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	    JLabel label_1 = new JLabel("DISPONIBLE");
	    label_1.setForeground(Color.WHITE);
	    label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	    label_1.setBounds(68, 172, 89, 14);
	    contentPane.add(label_1);
	    
	    textField = new JTextField();
	    textField.setBounds(239, 172, 51, 20);
	    textField.setEditable(false);
	    textField.setText(reserva);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    
	    JLabel label_3 = new JLabel("TITULO");
	    label_3.setForeground(Color.WHITE);
	    label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
	    label_3.setBounds(68, 75, 89, 14);
	    contentPane.add(label_3);
	    

	    conTitulo = new JComboBox<String>();
	    conTitulo.setBounds(178, 73, 167, 20);
	    contentPane.add(conTitulo);
	    
	    JLabel label_4 = new JLabel("AUTOR");
	    label_4.setForeground(Color.WHITE);
	    label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
	    label_4.setBounds(68, 107, 89, 14);
	    contentPane.add(label_4);
	    
	    JLabel label_5 = new JLabel("SIGNATURA");
	    label_5.setForeground(Color.WHITE);
	    label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
	    label_5.setBounds(68, 132, 89, 14);
	    contentPane.add(label_5);
	    
	    Tsignatura = new JTextField();
	   // Tsignatura.setText((String) null);
	    Tsignatura.setEditable(false);
	    Tsignatura.setColumns(10);
	    Tsignatura.setBounds(178, 130, 167, 20);
	    Tsignatura.setText(signatura);
	    contentPane.add(Tsignatura);
	    
	    Tautor = new JTextField();
	   // Tautor.setText((String) null);
	    Tautor.setEditable(false);
	    Tautor.setColumns(10);
	    Tautor.setBounds(178, 104, 167, 20);
	    Tautor.setText(autor);
	    contentPane.add(Tautor);
	    
	    
	   
	    
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	    
		
		//cargarcombogenero();
		cargarTitulos(asigna);
		setVisible(true);
	 
	}
}