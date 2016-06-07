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


public class  EmailProfesor1 extends JFrame {

	private JPanel contentPane;
	
	private JTextField email;
	private JTextArea text_Area;
	private JLabel receiver_Label,subject_Label;
	private JTextField subject_Field;
	String asunto;
	String texto ;
	String gmail ;
	JButton send;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailProfesor1 frame = new EmailProfesor1();
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
	public EmailProfesor1() {
		
		try{
			//cogo el dni que me ha pasado la ventana anterior
			String[] datos = funciones.getProfe(EmailProfesor.ndni);

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
					
					new EmailProfesor().setVisible(true);
					EmailProfesor1.this.dispose(); //hago "invisible la clase login"
				}
			});
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			label_2.setBackground(Color.WHITE);
			label_2.setBounds(378, 212, 30, 14);
			contentPane.add(label_2);
			
			
			getContentPane().setLayout(null);

			receiver_Label = new JLabel("DESTINATARIO");
			receiver_Label.setBounds(37, 27, 100 ,20);
		
			subject_Label = new JLabel("ASUNTO");
			subject_Label.setBounds(37, 58, 100 ,30);
			
			subject_Field = new JTextField(20);
			subject_Field.setBounds(103, 63, 266 ,20);
			
			text_Area = new JTextArea();
			text_Area.setBounds(47, 99, 322, 92);
			
			send = new JButton("Enviar");
			send.setBounds(157, 212, 89, 23);
			contentPane.add(send);
		
			
		
			
			getContentPane().add( receiver_Label );
		
			getContentPane().add( subject_Label );
			getContentPane().add( subject_Field);
			getContentPane().add(text_Area);
			
			
			email = new JTextField();
			email.setColumns(10);
			email.setBounds(127, 28, 242, 17);
			contentPane.add(email);
			email.setText(datos[5]);
			
			
			send.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					
					asunto = subject_Field.getText();
					texto = text_Area.getText();
					gmail = email.getText();
		
						
					funciones m = new funciones();
					m.SendMail(texto,gmail,asunto);
							
				}
			});
			
			
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
	}
}

