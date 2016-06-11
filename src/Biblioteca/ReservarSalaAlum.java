
	package Biblioteca;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.Panel;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.sql.SQLException;

	import javax.swing.ButtonGroup;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JLayeredPane;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;

	public class ReservarSalaAlum extends JFrame{
	  
	  Panel table;
	  JTable salas;
	  funciones f;
	  String sala ;
	  private JButton btnReservar;
	  private JButton btnSalir;
	  int [] salaSeleccionada;
	  String selection;
	  
	  ReservarSalaAlum () throws SQLException{
	    
	    f = new funciones();
	    
	    setBounds(400,150,558,357);
	    setVisible(true);

	    initTable(false);
	    crearBotones();
	    
	  }
	  
	  
	  private void crearBotones() {
	    
	    //CREAMOS UN NUEVO GRUPO PARA LOS BOTONES
	      ButtonGroup bg=new ButtonGroup();
	    
	    btnReservar = new JButton("Reservar");
	     btnReservar.addMouseListener(new MouseAdapter() {
	            @Override
	          
	            public void mouseClicked(MouseEvent e) {
	              
	              /* new BiblioAccedeFichaAlumno().setVisible(true);
	                ReservarSalaAlum.this.dispose(); //hago "invisible la clase login"*/
	              //System.out.println(sala);
	              if(selection == null){
	                //System.out.println("ohh");
	                JOptionPane.showMessageDialog( getParent() , "No ha seleccionado seminario" , "Acceso incorrecto" ,JOptionPane.ERROR_MESSAGE );

	              }else{
	                try {
	              funciones.reservarSalas(selection);
	            
	              
	            } catch (SQLException e1) {
	              // TODO Auto-generated catch block
	              e1.printStackTrace();
	            }
	                try {
	              initTable(true);
	              setVisible(true);
	              crearBotones();
	            
	            } catch (SQLException x) {
	              x.printStackTrace();
	            }

	              }
	            }
	     });
	     btnReservar.setBounds(150, 198, 115, 29);
	     table.add(btnReservar);
	     
	     JButton ayuda = new JButton(new ImageIcon(getClass().getResource("/Imagenes/ayuda.jpg")));
	     table.add(ayuda);
	      ayuda.setBorderPainted(false);
	      ayuda.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          
	          new AyudaUsuario().setVisible(true); //Voy a crear usuario
	          ReservarSalaAlum.this.dispose(); //hago "invisible la clase login"
	                    
	        }
	      });
	      ayuda.setBounds(453, 5, 63, 65);
	      
	      
	      JButton label_1 = new JButton(new ImageIcon(getClass().getResource("/Imagenes/flecha.jpg")));
	      label_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          new Alumno().setVisible(true);
	          ReservarSalaAlum.this.dispose(); //hago "invisible la clase login"
	        }
	      });
	      label_1.setBorderPainted(false);
	      
	      label_1.setForeground(Color.BLACK);
	      label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
	      label_1.setBackground(Color.WHITE);
	      label_1.setBounds(384, 238, 35, 14);
	      getContentPane().add(label_1, BorderLayout.SOUTH);
	      
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

	  private void initTable(Boolean flag) throws SQLException {
		    
		    if (flag){
		      this.remove(table);
		      btnSalir = new JButton("Salir");
		      btnSalir.addMouseListener(new MouseAdapter() {
		              @Override
		            
		              public void mouseClicked(MouseEvent e) {
		                /* new BiblioAccedeFichaAlumno().setVisible(true);
		                  ReservarSalaAlum.this.dispose(); //hago "invisible la clase login"*/
		              }
		       });
		      btnSalir.setBounds(300, 203, 115, 29);
		       table.add(btnSalir);
		    }

		    
		    table = new Panel();
		    table.setVisible(false);
		    
		    //array bidimencional de objetos con los datos de la tabla
		    String[][] data =  funciones.getSalasTabla();
		    
		    
		     
		     //array de String's con los títulos de las columnas
		     String[] col = {"Nombre de sala", "Numero de personas", "Reservada", "Numero de reservas", "Tiempo"};
		     
		     //se crea la Tabla
		     salas = new JTable(data, col);
		     
		     
		     //Creamos un JscrollPane y le agregamos la JTable
		     JScrollPane scroll = new JScrollPane(salas);
		     scroll.setBounds(13, 5, 402, 160);
		     salas.setPreferredScrollableViewportSize(new Dimension(400, 100));
		     
		     //String[] col2 = {"Reservar"};
		     // JButton array[] = new JButton[data.length];
		     table.setLayout(null);
		     
		     
		     //Agregamos el JScrollPane al contenedor
		     this.table.add(scroll);
		     
		     this.table.setBounds(150,20,430,130);
		     getContentPane().add(table, BorderLayout.CENTER);
		     //this.repaint();
		     this.paintAll(this.getGraphics());  
		     table.setVisible(true);

		     salas.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		       
		      @Override
		      public void valueChanged(ListSelectionEvent arg0) {
		        // TODO Auto-generated method stub
		        selection="";
		        salaSeleccionada=salas.getSelectedRows();  
		        selection=(String) salas.getValueAt(salas.getSelectedRow(), 0);
		        //System.out.println(selection);
		      }
		    });
		     
		     }
		  }