package Biblioteca;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.apache.log4j.Logger;


public class EmailWindow extends JDialog{
	static Logger logger = Logger.getLogger(EmailWindow.class.getName());

	private static final long serialVersionUID = 1L;

	String sender,password;
	
	private JTextArea text_Area;
	private JButton send,cancel,attach;
	private JLabel receiver_Label,subject_Label,attached_File,receiver_Field;
	private JTextField subject_Field,attached_Field;
	private Boolean flag,timetable;
	private String receiver;
	
	
	private String filePath,fileName;
	
	
	public EmailWindow(String user,String password,String receiver,Boolean timetable){
		
		logger.info("nueva EmailWindoww");
		this.sender = user;
		this.password = password;
		this.receiver = receiver;
		flag = false;
		this.timetable = timetable;
		
		setTitle( "Mandar Email" );
		setLocation( 250 , 200 );
		setSize( 500 , 600 );
		setResizable( false );
		setDefaultCloseOperation( JDialog.HIDE_ON_CLOSE);
		
	
		this.setLayout(null);

		receiver_Label = new JLabel("DESTINATARIO");
		receiver_Label.setBounds(50, 50, 100 ,20);
		
		receiver_Field = new JLabel(this.receiver);
		receiver_Field.setBounds(160, 50, 290 ,20);
	
		subject_Label = new JLabel("ASUNTO");
		subject_Label.setBounds(50, 90, 100 ,30);
		
		subject_Field = new JTextField(20);
		subject_Field.setBounds(160, 90, 290 ,20);
		
		text_Area = new JTextArea();
		text_Area.setBounds(50, 130, 400, 300);
		
		attached_File = new JLabel("Archivo: ");
		attached_File.setBounds(50,450,100,30);
	
		attached_Field = new JTextField(20);
		attached_Field.setBounds(160, 450, 290 ,20);
	
		
		send = new JButton("Enviar");
		send.setBounds(50, 500, 90, 20);
		cancel = new JButton("Cancelar");
		cancel.setBounds(200, 500, 90, 20);
		attach = new JButton("Adjuntar"); 
		attach.setBounds(350,500,90,20);
		
		this.add( receiver_Label );
		this.add( receiver_Field);
	
		this.add( subject_Label );
		this.add( subject_Field);
		this.add(text_Area);	
		this.add(attached_File);
		this.add(attached_Field);
		this.add( send );
		this.add( cancel);
		this.add(attach);
		
		actions();
		ayuda();
		
		if(this.timetable){
			
			this.filePath = "table.png";
			this.fileName = "table.png";
			subject_Field.setText("Timetable");
			attached_Field.setText("table.png");
			flag = true;
		} 
		
		
	}
	private void ayuda() {

		File fichero = new File("help/help_set.hs");
		URL hsURL = null;
		try {
			hsURL = fichero.toURI().toURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Crea el HelpSet
		HelpSet helpset = null;
		try {
			helpset = new HelpSet(getClass().getClassLoader(), hsURL);
		} catch (HelpSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HelpBroker hb = helpset.createHelpBroker();
		hb.enableHelpKey(this.getContentPane(), "emailWindow", helpset);
		
	}

	public void actions(){
		
		this.send.addActionListener( new ActionListener(){
			
			public void actionPerformed(ActionEvent evento ) {
			
			Email e;		
				
				if(flag){
					//email con archivo adjunto
					logger.info("nuevo email sin archivo adjunto");
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
		}
	
}
