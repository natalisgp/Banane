package Biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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


public class EliminarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarUsuario frame = new EliminarUsuario();
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
	public EliminarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_2 = new JLabel("ATRAS");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new Administrador().setVisible(true);
				EliminarUsuario.this.dispose(); //hago "invisible la clase login"
				
			}
		});
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(336, 237, 69, 14);
		contentPane.add(label_2);
		
		JLabel lblEliminarUsuario = new JLabel("Eliminar usuario");
		lblEliminarUsuario.setForeground(Color.LIGHT_GRAY);
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEliminarUsuario.setBounds(10, 11, 95, 20);
		contentPane.add(lblEliminarUsuario);
		
		JLabel label = new JLabel("DNI");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setForeground(Color.LIGHT_GRAY);
		label.setBounds(95, 88, 46, 14);
		contentPane.add(label);
		
		JButton button = new JButton("Ayuda");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AyudaEliminarUsuario().setVisible(true); //Voy a crear usuario
				EliminarUsuario.this.dispose(); //hago "invisible la clase login"
			}
		});
		button.setBounds(336, 203, 85, 23);
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
						String[] comprobar = funciones.getAdministrador(ndni);
						
						if(ndni.equals(comprobar[2])){
							
							//new ().setVisible(true);
							EliminarUsuario.this.dispose();
							System.out.println("Voy a eliminar al usuario");
							funciones.removeUser(ndni);
							
							JOptionPane.showMessageDialog(null, "Se a eliminado el usuario.");
							
							
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
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Natalia\\Desktop\\diam.jpg"));
		label_1.setBounds(-72, -11, 568, 365);
		contentPane.add(label_1);
	}
}

