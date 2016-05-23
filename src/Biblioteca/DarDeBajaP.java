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
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DarDeBajaP extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarDeBajaP frame = new DarDeBajaP();
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
	public DarDeBajaP() {
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
				DarDeBajaP.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(377, 212, 26, 14);
		contentPane.add(label_2);
		
		JLabel lblEliminarUsuario = new JLabel("Dar de baja profesor");
		lblEliminarUsuario.setForeground(Color.BLACK);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEliminarUsuario.setBounds(139, 11, 131, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("DNI");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setForeground(Color.WHITE);
		label.setBounds(95, 88, 46, 14);
		contentPane.add(label);
		
		JButton button = new JButton(new ImageIcon(getClass().getResource("/Imagenes/ayuda.jpg")));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaEliminarUsuario().setVisible(true); //Voy a crear usuario
				DarDeBajaP.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(377, 22, 26, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(193, 85, 114, 20);
		contentPane.add(textField);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ndni = textField.getText();
				
				if(ndni.length()>0){ // y exista dicho dni
					
					try{
						String[] comprobar = funciones.getProfe(ndni);
						
						if(ndni.equals(comprobar[2])){
							
							//new ().setVisible(true);
							DarDeBajaP.this.dispose();
							System.out.println("Voy a eliminar al profe");
							funciones.removeProfe(ndni);
							
							JOptionPane.showMessageDialog(null, "Se ha eliminado el profe.");
							
							
						}else {
							
							JOptionPane.showMessageDialog(null, "Error el dni no existe en la base de datos.");
							
							
						}
						
						
						
					} catch (SQLException er) {
						// TODO Auto-generated catch block
						er.printStackTrace();
					}
					
				
				}else{
					JOptionPane.showMessageDialog(null, "Error el campo esta vacio o el DNI no existe en la base de datos");
				}
				
			}
		});
		btnEliminar.setBounds(170, 170, 89, 23);
		contentPane.add(btnEliminar);
		
		//Icono
	    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
	    //Fondo
	    ((JPanel)getContentPane()).setOpaque(false);
	    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
	    JLabel fondo= new JLabel(); 
	    fondo.setIcon(uno); 
	    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
	    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	}
}