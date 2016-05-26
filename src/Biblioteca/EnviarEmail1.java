package Biblioteca;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.net.SyslogAppender;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JTextArea;


public class EnviarEmail1 extends JFrame {

	private JPanel contentPane;
	private String alumnoEmail;
	private JTextArea textArea;
	//private JPasswordField password;
	private JTextField email,gmail;
	private JTextField textField;
	private Boolean flag;
	
	private String filePath;
	private static String fileName;
	
	JButton send = new JButton("Enviar");
	JButton cancel = new JButton("Cancelar");
	JButton attach = new JButton("Adjuntar");
	
	

	private JTextField attached_Field;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarEmail1 frame = new EnviarEmail1();
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
	public EnviarEmail1() {
		

		
		
		
		try{
			//cogo el dni que me ha pasado la ventana anterior
			String[] datos = funciones.getAlumno(EmailAlumno.ndni);

			//panel
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
				
				new EnviarEmail().setVisible(true);
				EnviarEmail1.this.dispose(); //hago "invisible la clase login"
			}
		});
		
		
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(381, 233, 30, 14);
		contentPane.add(label_2);
		
		
		//ETIQUETA
		JLabel lblEliminarUsuario = new JLabel("Enviar email al usuario");
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setBounds(114, 11, 183, 20);
		contentPane.add(lblEliminarUsuario);
		
		flag=true;
		
		
		
		
		JLabel label = new JLabel("ASUNTO");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(81, 88, 69, 14);
		contentPane.add(label);
		
		
		
		JLabel label2 = new JLabel("DESTINATARIO");
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label2.setBounds(81, 63, 84, 14);
		contentPane.add(label2);
		
		JLabel label_1 = new JLabel("ADJUNTAR");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(81, 189, 69, 14);
		contentPane.add(label_1);
		
		
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(187, 63, 182, 14);
		contentPane.add(email);
		email.setText(datos[5]);
		System.out.println(email);
		
		alumnoEmail=datos[5];
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	
	    
	    textField = new JTextField(20);
	    textField.setBounds(141, 88, 228, 14);
	    contentPane.add(textField);
	    
	    JTextArea textArea = new JTextArea();
	    textArea.setBounds(81, 123, 288, 55);
	    contentPane.add(textArea);
	    
	    gmail = new JTextField();
	    gmail.setText((String) null);
	    gmail.setColumns(10);
	    gmail.setBounds(187, 42, 182, 14);
	    gmail.setText(datos[5]);
	    contentPane.add(gmail);
	    
	    attached_Field = new JTextField();
	    attached_Field.setText((String) null);
	    attached_Field.setColumns(10);
	    attached_Field.setBounds(149, 186, 220, 14);
	    contentPane.add(attached_Field);
	    
		}catch (Exception e){
			
	    }
	    
	    
	    
	    
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	    
flag = false;
		
		
		send.setBounds(81, 224, 84, 23);
		contentPane.add(send);
		
		
		cancel.setBounds(175, 224, 93, 23);
		contentPane.add(cancel);
		
		
		attach.setBounds(278, 224, 84, 23);
		contentPane.add(attach);
		
		
		actions();
		
			
	}
	
	

	public void actions() {

		//si le doy a enviar
			this.send.addActionListener( new ActionListener(){
				
				
			
			public void actionPerformed(ActionEvent evento ) {
				
				System.out.println("le de dado a enviarrrrrr");
				
				System.out.println(gmail.getText());
				
				System.out.println(filePath);
				System.out.println(fileName);

				System.out.println(email.getText());
				System.out.println(textField.getText());
				System.out.println(textArea.getText());
				
				Email e;		
				
				if(flag){
					System.out.println(gmail.getText());
					
					System.out.println(filePath);
					System.out.println(fileName);

					System.out.println(email.getText());
					System.out.println(textField.getText());
					System.out.println(textArea.getText());
					//email con archivo adjunto
					
					e = new Email(gmail.getText(),filePath,fileName,email.getText(),textField.getText(),textArea.getText());
				}else{
					//email sin archivo
					
					e = new Email(gmail.getText(),email.getText(),textField.getText(),textArea.getText());
				}
				

				
			if (e.sendMail()){
	            JOptionPane.showMessageDialog(null,"El email se ha enviado correctamente");
	            dispose();
	        }else{
	            JOptionPane.showMessageDialog(null,"El email no se ha enviado correctamente");
	        }		
					
				
			}
		});
		this.cancel.addActionListener( new ActionListener(){
		
			public void actionPerformed(ActionEvent evento ) {
				
				System.exit(0);
			}
		});
		this.attach.addActionListener( new ActionListener(){
			
			public void actionPerformed(ActionEvent evento ) {
			
				
				JFileChooser chooser = new JFileChooser();
				chooser.setApproveButtonText("Adjuntar Archivo");
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				filePath = file.getPath();
				System.out.println(filePath);
				
				fileName  = file.getName();		
			
				attached_Field.setText(fileName);
				System.out.println(fileName);
				
				flag = true;
				
			}
		});	
		}
	}		
	
	
	
	
			
			
			
			
		
	


