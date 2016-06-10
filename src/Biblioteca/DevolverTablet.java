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


	public class DevolverTablet extends JFrame {

		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		public static String ndni;
		 Calendar calendario = new GregorianCalendar();
			int horaAct,minutos,segundos;
			String relojActual;
			String minutosActual;
		
			String suma;
		 String tablet ;
		
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DevolverTablet frame = new DevolverTablet();
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
		public DevolverTablet() {
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
					DevolverTablet.this.dispose(); //hago "invisible la clase login"
					
				}
			});
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			label_2.setBackground(Color.WHITE);
			label_2.setBounds(377, 212, 26, 14);
			contentPane.add(label_2);
			
			JLabel lblEliminarUsuario = new JLabel("Devolver tablet");
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
					DevolverTablet.this.dispose(); //hago "invisible la clase login"
				}
			});
			button.setBounds(377, 22, 26, 23);
			contentPane.add(button);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(186, 120, 114, 20);
			contentPane.add(textField);
			
			JButton btnEliminar = new JButton("Devolver");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					tablet = textField_1.getText();
					
					//consulta para cambiar el reservado del libro
					String [] datosLibro = null;
					try {
						datosLibro= funciones.getTabletReser(tablet);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					String reserva = datosLibro[1];
					String solucion = null ;
					if(reserva.equals("NO")){
						solucion="SI";
						//JOptionPane.showMessageDialog(null, "EL LIBRO ESTA DISPONIBLE");
				    }else if(reserva.equals("SI")){
				    	solucion="NO";
				    	//JOptionPane.showMessageDialog(null, "EL LIBRO NO ESTA DISPONIBLE");
				    }
					
					try {
						funciones.cambiarTablet(solucion,tablet);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//MIRAR EL DNI
					
					
					ndni = textField.getText();
					
										
						try{
							String[] alumno =funciones.getAlumno(ndni);
							String[] profesor =funciones.getProfe(ndni);
							
							//hora

							horaAct =calendario.get(Calendar.HOUR_OF_DAY);
							minutos = calendario.get(Calendar.MINUTE);
							segundos = calendario.get(Calendar.SECOND);
							
							//horaActual =Integer.toString(hora);
							minutosActual =Integer.toString(minutos);
							System.out.println(horaAct);
							
						
						    //relojActual = Integer.toString(hora)+":"+Integer.toString(minutos);
							
							//Alumno	
							if(ndni.equals(alumno[2])){ //El permiso 2 para el administrador  	
								
							    //leo la hora y si se ha pasado multa
								String hora = alumno[8];
								
								int inicio = hora.indexOf(":");
								int horaPasa=Integer.parseInt(hora.substring(0, inicio));
								horaPasa+=2;
								System.out.println(horaPasa);
								
								if(horaAct>horaPasa){
									
									//Le pongo una multa porque ha entregado la tablet tarde
									tablet="";
									String ho= "";
									String multa = "SI";
									funciones.devolverTabletAl(tablet,ho,multa,alumno[2]);
									
									//le mando un correo porque le he puesto una multa
									String emailA=alumno[5];
									System.out.println(emailA);
									String asunto="MULTA";
									String texto = "Se le ha multado por no entregar el ejemplar alquilado a tiempo. En un periodo de tres dias no podra realizar un alquiler";
									funciones m = new funciones();
									m.SendMail(texto,emailA,asunto);
									
									
									
								}else{
									tablet="";
									String ho= "";
									String multa = "NO";
									
									funciones.devolverTabletAl(tablet,ho,multa,alumno[2]);
								}
									
								//}
								//String horaPasada = 
								
								
									//pongo la reserva del alumno a si
									//funciones.alquilaAlumnoLibro(tablet, reloj, alumno[2]);
							}	
							//Profesor
							if(ndni.equals(profesor[2])){ //El permiso 2 para el administrador
								
								String hora = profesor[8];
								
								int inicio = hora.indexOf(":");
								int horaPasa=Integer.parseInt(hora.substring(0, inicio));
								horaPasa+=2;
								System.out.println(horaPasa);
								
								if(horaAct>horaPasa){
									
									tablet="";
									String ho= "";
									String multa = "SI";
									funciones.devolverTabletProfe(tablet,ho,multa,profesor[2]);
									
									//le mando un correo porque le he puesto una multa
									String emailProfesor=profesor[5];
									System.out.println(emailProfesor);
									String asunto="MULTA";
									String texto = "Se le ha multado por no entregar el ejemplar alquilado a tiempo. En un periodo de tres dias no podra realizar un alquiler";
									funciones m = new funciones();
									m.SendMail(texto,emailProfesor,asunto);
									
									
								}else{
									tablet="";
									String ho= "";
									String multa = "NO";
									
									funciones.devolverTabletProfe(tablet,ho,multa,profesor[2]);
									
									//le mando un correo porque le he puesto una multa
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
		    
		    JLabel label_1 = new JLabel("TABLET");
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
