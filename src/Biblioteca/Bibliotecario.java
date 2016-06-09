
package Biblioteca;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class Bibliotecario extends JFrame {


  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Bibliotecario frame = new Bibliotecario();
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
  public Bibliotecario() {
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 512, 292);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JButton label_1 = new JButton(new ImageIcon(getClass().getResource("/Imagenes/flecha.jpg")));
    label_1.setBorderPainted(false);
    label_1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        
      
          
          new login().setVisible(true);
          Bibliotecario.this.dispose(); //hago "invisible la clase login"
        
      }
    });
    label_1.setForeground(Color.BLACK);
    label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
    label_1.setBackground(Color.WHITE);
    label_1.setBounds(453, 225, 34, 14);
    contentPane.add(label_1);
    
    JLabel lblBibliotecario = new JLabel("BIBLIOTECARIO");
    lblBibliotecario.setForeground(Color.BLACK);
    lblBibliotecario.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblBibliotecario.setBounds(146, 36, 151, 14);
    contentPane.add(lblBibliotecario);
    
    JButton btnModificarDatosUsuario = new JButton("Modificar datos alumno");
    btnModificarDatosUsuario.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
        new BiblioModiAlumno().setVisible(true);
        Bibliotecario.this.dispose();
        System.out.println("Voy a modificar un alumno");
        
        
        
      }
    });
    btnModificarDatosUsuario.setBounds(249, 188, 183, 14);
    contentPane.add(btnModificarDatosUsuario);
    
    
    JButton b = new JButton("Modificar datos profesor");
    b.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		 new BiblioModiProfe().setVisible(true);
    	     Bibliotecario.this.dispose();
    	     System.out.println("Voy a modificar un profesor");
    		
    	}
    });
    b.setBounds(20, 191, 183, 14);
    contentPane.add(b);
    
    
    
    
    JButton btnBajaUsuario = new JButton("Dar de alta alumno");
    btnBajaUsuario.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        new DarDeAltaA().setVisible(true);
        Bibliotecario.this.dispose();
        System.out.println("Voy a añadir un nuevo alumno");
        
        
      }
    });
    btnBajaUsuario.setBounds(20, 141, 183, 14);
    contentPane.add(btnBajaUsuario);
    
    JButton btnEliminarUsuario = new JButton("Dar de baja profesor");
    btnEliminarUsuario.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        new DarDeBajaP().setVisible(true);
        Bibliotecario.this.dispose();
        System.out.println("Voy a eliminar a un usuario");
        
        
      }
    });
    btnEliminarUsuario.setBounds(20, 115, 183, 14);
    contentPane.add(btnEliminarUsuario);

    JButton btn= new JButton("Dar de baja alumno");
    btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        new DarDeBajaA().setVisible(true);
        Bibliotecario.this.dispose();
        System.out.println("Voy a eliminar a un usuario");
        
        
      }
    });
    btn.setBounds(20, 166, 183, 14);
    contentPane.add(btn);
    
    JButton btnAyuda = new JButton(new ImageIcon(getClass().getResource("/Imagenes/ayuda.jpg")));
    btnAyuda.setBorderPainted(false);
    btnAyuda.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        new AyudaAdministrador().setVisible(true); //Voy a crear usuario

Bibliotecario.this.dispose(); //hago "invisible la clase login"
      }
    });
    btnAyuda.setBounds(460, 36, 27, 23);
    contentPane.add(btnAyuda);
    
    //Icono
      setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Banane.jpg")).getImage());
      //Fondo
      ((JPanel)getContentPane()).setOpaque(false);
      
      JButton btnFicha = new JButton("Acceder ficha alumno");
      btnFicha.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            
            new BiblioAccedeFichaAlumno().setVisible(true);
            Bibliotecario.this.dispose();
            System.out.println("Voy a acceder a la ficha del alumno");
            
            
          }
        });
      btnFicha.setBounds(249, 90, 183, 14);
      contentPane.add(btnFicha);
      
      JButton btnEjemplares = new JButton("N\u00BA Ejemplares");
      btnEjemplares.setBounds(249, 115, 183, 14);
      contentPane.add(btnEjemplares);
      
      JButton btnSalas = new JButton("Alquiler de salas");
      btnSalas.setBounds(249, 141, 183, 14);
      contentPane.add(btnSalas);
      
     // JButton button = new JButton("Dar de alta profesor");
     // button.setBounds(20, 166, 183, 14);
     // contentPane.add(button);
      
      JButton button = new JButton("Dar de alta profesor");
       button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          
          new DarDeAltaP().setVisible(true);
          Bibliotecario.this.dispose();
          System.out.println("Voy a añadir un nuevo usuario");
          
          
        }
      });
       button.setBounds(20, 90, 183, 14);
       contentPane.add(button);
       
       JButton button_1 = new JButton("Acceder ficha profesor");
       button_1.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		
       		new BiblioAccedeFichaProfe().setVisible(true);
            Bibliotecario.this.dispose();
            System.out.println("Voy a acceder a la ficha a un profesor");
       		
       	}
       });
       button_1.setBounds(249, 163, 183, 14);
       contentPane.add(button_1);
       
       JButton button_2 = new JButton("Materiales");
       button_2.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
       		
       		new Materiales().setVisible(true);
            Bibliotecario.this.dispose();
            System.out.println("Voy a acceder a los materiales");
       		
       	}
       });
       button_2.setBounds(20, 216, 183, 14);
       contentPane.add(button_2);
       
      
      
      
      ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg")); 
      JLabel fondo= new JLabel(); 
      fondo.setIcon(uno); 
      getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
      fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
  }
}

