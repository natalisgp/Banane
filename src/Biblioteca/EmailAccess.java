package Biblioteca;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.apache.log4j.Logger;


public class EmailAccess extends JDialog{
	
	
	//un objeto de typo password 
	 Logger logger = Logger.getLogger(EmailAccess.class.getName());
	private JLabel user_Label = new JLabel( "Email" );
	private JLabel password_Label = new JLabel( "Clave" );
	
	private JLabel user_Field;
	private JPasswordField password_Field = new JPasswordField( 25 );

	private JButton access_Button = new JButton( "Enter" );
	private JButton cancel_Button = new JButton( "Delete" );
	
	private String email,receiver;
	Boolean timetable;
	
	
	public EmailAccess(String receiverr,Boolean timetable){
		
		logger.info("nueva EmailAccess");
		this.receiver = receiverr;
		this.timetable = timetable;
		
		
		
		try {
			try {
				//aqui cogemos la funcion de buscar
				email = funciones.searchAdminEmail();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				logger.warn("NoSuchAlgorithmException");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			logger.warn("SQLException");
			e.printStackTrace();
			
		}
		
		user_Field = new JLabel(email);
		
		//Propiedades de la ventana
		setTitle( "Login" );
		setLocation( 250 , 200 );
		setSize( 500 , 500 );
		//setResizable( false );
		setDefaultCloseOperation( JDialog.HIDE_ON_CLOSE);
		setVisible(true);
		
		coloca();
		actions();
		
		
	}
		
	public void actions(){
		access_Button.addActionListener( new ActionListener(){
			
			public void actionPerformed(ActionEvent evento ){ 
				logger.info("accediendo a email");
				EmailWindow em = new EmailWindow(email,String.valueOf( password_Field.getPassword()),receiver,timetable);
				em.setVisible(true);
			}	
				
		});
		
		cancel_Button.addActionListener( new ActionListener(){
		
			public void actionPerformed(ActionEvent event ){
				logger.info("acceso a email cancelado");
				password_Field.setText( "" );

			}
		});
		
	}
		
	public void coloca(){
		
		//Se crea el contenedor

		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout( layout );
		
		/*
		cancel_Button.setPreferredSize( new Dimension( 68 , 64 ) );
		access_Button.setPreferredSize( new Dimension( 68 , 64 ) );
		*/
		//Se colocan los elemntos en coordenadas
		layout.putConstraint( SpringLayout.WEST , user_Label , 50 , SpringLayout.WEST , container );
		layout.putConstraint(SpringLayout.NORTH , user_Label , 50 , SpringLayout.NORTH , container );
		
		layout.putConstraint(SpringLayout.WEST , user_Field , 150 , SpringLayout.WEST , container );
		layout.putConstraint(SpringLayout.NORTH , user_Field , 50, SpringLayout.NORTH , container );
		
		layout.putConstraint(SpringLayout.WEST , password_Label , 50 , SpringLayout.WEST, container );
		layout.putConstraint(SpringLayout.NORTH , password_Label , 100 , SpringLayout.NORTH, container );
		
		layout.putConstraint(SpringLayout.WEST , password_Field , 150 , SpringLayout.WEST, container );
		layout.putConstraint(SpringLayout.NORTH , password_Field , 100  , SpringLayout.NORTH, container );
		
		layout.putConstraint(SpringLayout.WEST , access_Button , 150 , SpringLayout.WEST, container );
		layout.putConstraint(SpringLayout.NORTH , access_Button, 150 , SpringLayout.NORTH, container );
		
		layout.putConstraint(SpringLayout.WEST , cancel_Button , 300 , SpringLayout.WEST, container );
		layout.putConstraint(SpringLayout.NORTH , cancel_Button, 150 , SpringLayout.NORTH, container );
		
	
		//Se adhieren los elementos en el contendor
		container.add( user_Label );
		container.add( user_Field );
		container.add( password_Label );
		container.add( password_Field );
		container.add( access_Button );
		container.add( cancel_Button );
		
		
	}

}