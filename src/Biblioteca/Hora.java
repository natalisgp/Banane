package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;



import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Hora extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	Calendar calendario = new GregorianCalendar();
	int hora,minutos,segundos;
	String dia,mes,anio;
	String reloj;
	String suma;
	String fecha;
	private JTextField textField_1;

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hora frame = new Hora();
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
	public Hora() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblAdministrador = new JLabel("Hora");
		lblAdministrador.setForeground(Color.BLACK);
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdministrador.setBounds(78, 20, 288, 14);
		contentPane.add(lblAdministrador);
		
		//Hora
		
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		
		System.out.println(hora + ":" + minutos + ":" + segundos);
	
		if(hora==22){
			hora=0;
		}else if(hora==23){
			hora=1;
		}else if(hora==24){
			hora=2;
		}else{
			hora+=2;
		}
	    reloj = Integer.toString(hora)+":"+Integer.toString(minutos);
			
	    dia = Integer.toString(calendario.get(Calendar.DATE));
	    mes = Integer.toString(calendario.get(Calendar.MONTH));
	    anio = Integer.toString(calendario.get(Calendar.YEAR));
	    
	    fecha = dia+"/"+mes+"/"+anio;
	    
	    
	    
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    
	    textField = new JTextField();
	    textField.setBounds(129, 73, 158, 20);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    textField.setText(reloj);
	    
	    textField_1 = new JTextField();
	    textField_1.setText(fecha);
	    textField_1.setColumns(10);
	    textField_1.setBounds(129, 104, 158, 20);
	    contentPane.add(textField_1);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}




