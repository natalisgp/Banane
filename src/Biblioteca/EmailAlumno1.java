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
import javax.swing.JTextArea;


public class EmailAlumno1 extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField dnis;
	private JTextField surname;
	private JTextField username;
	private JTextField permisos;
	private JPasswordField password;
	private JTextField email;
	private JTextField textField;
	private boolean flag;
	
	

	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailAlumno1 frame = new EmailAlumno1();
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
	public EmailAlumno1() {
		
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
					
					new EmailAlumno().setVisible(true);
					EmailAlumno1.this.dispose(); //hago "invisible la clase login"
				}
			});
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			label_2.setBackground(Color.WHITE);
			label_2.setBounds(381, 233, 30, 14);
			contentPane.add(label_2);
			
			
			//ETIQUETA
			JLabel lblEliminarUsuario = new JLabel("Enviar email al alumno");
			lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEliminarUsuario.setForeground(Color.BLACK);
			lblEliminarUsuario.setBounds(114, 11, 183, 20);
			contentPane.add(lblEliminarUsuario);
			
			flag=true;
			/*
			//funcion enviar
			JButton btnEliminar = new JButton("Enviar Email");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					
					Email e;		
					
					if(flag){
						//email con archivo adjunto
						//logger.info("nuevo email sin archivo adjunto");
						e = new Email(sender,password,filePath,fileName,receiver_Field.getText(),subject_Field.getText(),text_Area.getText());
					}else{
						//email sin archivo
						logger.info("nuevo email con archivo adjunto");
						e = new Email(sender,password,receiver_Field.getText(),subject_Field.getText(),text_Area.getText());
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
					logger.info("email cancelado");
					System.exit(0);
				}
			});
			this.attach.addActionListener( new ActionListener(){
				
				public void actionPerformed(ActionEvent evento ) {
				
					logger.info("adjuntando archivo");	
					JFileChooser chooser = new JFileChooser();
					chooser.setApproveButtonText("Adjuntar Archivo");
					chooser.showOpenDialog(null);
					File file = chooser.getSelectedFile();
					filePath = file.getPath();
					
					fileName  = file.getName();		
				
					attached_Field.setText(fileName);
					
					flag = true;
					
				}
			});	
		
			btnEliminar.setBounds(124, 224, 133, 23);
			contentPane.add(btnEliminar);
			*/
			
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
		    
		    textField_1 = new JTextField();
		    textField_1.setText((String) null);
		    textField_1.setColumns(10);
		    textField_1.setBounds(149, 186, 220, 14);
		    contentPane.add(textField_1);
		    
		    
		    
		    
		    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
		    JLabel fondo= new JLabel(); 
		    fondo.setIcon(uno); 
		    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
		    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		}catch (Exception e){
			
		}
	}
}

