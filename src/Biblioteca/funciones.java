package Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class funciones {
	static String gdni;
	static String gname;
	static String gid;
	static String gcantidad;
	static Connection db = Connect("BANANE6", "natalia3");
  
	public static Connection Connect(String username, String password){
		Connection connection=null;
		String database="jdbc:oracle:thin:@localhost:1521/XE";
	  
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("The driver has been loaded");
		  	
			connection=DriverManager.getConnection(database, username, password);
		  	System.out.println("Connection was established");
		  	
		}catch (Exception e){
			System.out.println(e.toString());
		}
	  
		return connection;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Datos correo de verificacion de peticiones de ingreso
		final String Username = "bibliobanane@gmail.com";
		final String PassWord = "natabarnere3";

		public void SendMail(String Mensage, String To, String Subject) {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Username, PassWord);
				}
			});

			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(Username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
				message.setSubject(Subject);
				message.setText(Mensage);

				Transport.send(message);
				JOptionPane.showMessageDialog(null,"Su mensaje ha sido enviado");
				

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	
	

		
		
	
	static ResultSet ejecutar(String query, Connection db) throws SQLException{
		
		Statement stmt = db.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
		
	}
	
	static ResultSet alquilarTablet() throws SQLException{
		
		String query="SELECT TABLET FROM TABLET";
		ResultSet rs = ejecutar(query, db);

		return rs;
	}
	
	static ResultSet devoAsignatura() throws SQLException{
		
		String query="SELECT ASIGNATURA FROM LIBROS";
		ResultSet rs = ejecutar(query, db);

		return rs;
	}
	

	static ResultSet devoTitulo(String asig) throws SQLException{
		
		String query="SELECT TITULO FROM LIBROS WHERE ASIGNATURA ='"+asig+"'";
		ResultSet rs = ejecutar(query, db);

		return rs;
	}
	
	
	static ResultSet devoTitulos() throws SQLException{
		String dni = "NO";
		
		String query="SELECT TITULO FROM LIBROS"; // WHERE RESERVA= = '"+dni+"'" ;
		ResultSet rs = ejecutar(query, db);

		return rs;
	}
	
	
	static ResultSet eliminarSala() throws SQLException{
		
		String query="SELECT NOMBRE FROM SALASTRABAJO";
		ResultSet rs = ejecutar(query, db);

		return rs;
	}
	
	static ResultSet alquilarLibro() throws SQLException{
		
		String query="SELECT SIGNATURA FROM LIBROS";
		ResultSet rs = ejecutar(query, db);
		return rs;
		
	}
	
	static ResultSet eliminarLibro() throws SQLException{
		
		String query="SELECT TITULO FROM LIBROS";
		ResultSet rs = ejecutar(query, db);
		return rs;
		
	}
	
	
	
	//get SIGNARUTE DE LIBRO
	
	static ArrayList<String> getSignature() throws SQLException{
	    
	      String query="SELECT * FROM LIBROS WHERE SIGNATURE";
	      ResultSet rs = ejecutar(query, db);
	    
	    ArrayList<String> resultado = new ArrayList<String>();
	    while (rs.next()){
	      
	      java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	      int numberOfColumns = rsmd.getColumnCount();
	      String data = null;
	      
	      for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
	        data = data+"-"+rs.getObject(columnIndex);
	      }
	      resultado.add(data.substring(2, data.length()));
	      
	    }
	    return resultado;
	  }

	
	//Funcion que coge los datos de la base de datos de la tabla administrador
	static String[] getAdministrador(String dni) throws SQLException{
		
		gdni=dni;
	  	String query="SELECT * FROM ADMINISTRADOR WHERE DNI = '"+dni+"'";
		ResultSet rs = ejecutar(query, db);
		String nombre = null;
		String apellidos = null;
		String username =null;
		String permisos = null;
		String password = null;
		String email = null;
		
		
		while (rs.next()){
			nombre = rs.getString("nombre");
			apellidos = rs.getString("apellidos");
			username = rs.getString("username");
			permisos= rs.getInt("permisos")+"";
			password= rs.getString("password");
			email=rs.getString("email");
		}
		gname=nombre;
		String[] result ={nombre, apellidos, username,permisos,password,email};
		return result;
	}
	
	

	//getUsuarios
	
	static String[] getUsuario(String dni) throws SQLException{
		
		gdni=dni;
	  	String query="SELECT * FROM USUARIO WHERE DNI = '"+dni+"'";
		ResultSet rs = ejecutar(query, db);
		String nombre = null;
		String apellidos = null;
		String username =null;
		String permisos = null;
		String password = null;
		String email = null;
		
		
		while (rs.next()){
			nombre = rs.getString("nombre");
			apellidos = rs.getString("apellidos");
			username = rs.getString("username");
			permisos= rs.getInt("permisos")+"";
			password= rs.getString("password");
			email=rs.getString("email");
		}
		gname=nombre;
		String[] result ={nombre, apellidos, username,permisos,password,email};
		return result;
	}
	
	//bibliotecario
	
	//getUsuarios
	
		static String[] getBibliotecario(String dni) throws SQLException{
			
			gdni=dni;
		  	String query="SELECT * FROM BIBLIOTECARIO WHERE DNI = '"+dni+"'";
			ResultSet rs = ejecutar(query, db);
			String nombre = null;
			String apellidos = null;
			String username =null;
			String permisos = null;
			String password = null;
			
			
			while (rs.next()){
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				username = rs.getString("username");
				permisos= rs.getInt("permisos")+"";
				password= rs.getString("password");
				
			}
			gname=nombre;
			String[] result ={nombre, apellidos, username,permisos,password};
			return result;
		}
		
		
    static String[] getProfe(String dni) throws SQLException{
			
			gdni=dni;
		  	String query="SELECT * FROM PROFESOR WHERE DNI = '"+dni+"'";
			ResultSet rs = ejecutar(query, db);
			String nombre = null;
			String apellidos = null;
			String username =null;
			String permisos = null;
			String password = null;
			String email = null;
			String reserva = null;
			String multa = null;
			String hora_reserva = null;
			
			
			
			while (rs.next()){
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				username = rs.getString("username");
				permisos= rs.getInt("permisos")+"";
				password= rs.getString("password");
				email=rs.getString("email");
				reserva= rs.getString("reserva");
				multa=rs.getString("multa");
				hora_reserva=rs.getString("hora_reserva");
				
			}
			gname=nombre;
			String[] result ={nombre, apellidos, username,permisos,password,email,reserva,multa,hora_reserva};
			return result;
		}
    
static String[] getTabletReser(String dni) throws SQLException{
		
		gdni=dni;
	  	String query="SELECT * FROM TABLET WHERE TABLET = '"+dni+"'";
		ResultSet rs = ejecutar(query, db);
		String tablet = null;
		String reserva =null;
		
		
		
		while (rs.next()){
			tablet= rs.getString("tablet");
			reserva= rs.getString("reserva");
			
			
			
		}
		String[] result ={tablet, reserva};
		return result;
	}
        
    
    
    
    
static String[] getSignaRese(String dni) throws SQLException{
		
		gdni=dni;
	  	String query="SELECT * FROM LIBROS WHERE SIGNATURA = '"+dni+"'";
		ResultSet rs = ejecutar(query, db);
		String asignatura = null;
		String titulo = null;
		String autor = null;
		String signatura =null;
		String reserva =null;
		
		
		
		while (rs.next()){
			asignatura = rs.getString("asignatura");
			titulo = rs.getString("titulo");
			autor = rs.getString("autor");
			signatura= rs.getString("signatura");
			reserva= rs.getString("reserva");
			
			
			
		}
		String[] result ={asignatura, titulo, autor, signatura, reserva};
		return result;
	}
    
    
    
    
    
    
 static String[] getIdLibro(String dni) throws SQLException{
		
		gdni=dni;
	  	String query="SELECT * FROM LIBROS WHERE TITULO = '"+dni+"'";
		ResultSet rs = ejecutar(query, db);
		String asignatura = null;
		String titulo = null;
		String autor = null;
		String signatura =null;
		String reserva =null;
		
		
		
		while (rs.next()){
			asignatura = rs.getString("asignatura");
			titulo = rs.getString("titulo");
			autor = rs.getString("autor");
			signatura= rs.getString("signatura");
			reserva= rs.getString("reserva");
			
			
			
		}
		String[] result ={asignatura, titulo, autor, signatura, reserva};
		return result;
	}
 
 
 static String[] getIdTablet(String dni) throws SQLException{
		
		gdni=dni;
	  	String query="SELECT * FROM TABLET WHERE TABLET = '"+dni+"'";
		ResultSet rs = ejecutar(query, db);
		String tablet = null;
		String reserva = null;
	
		
		
		while (rs.next()){
			
			tablet= rs.getString("tablet");
			reserva= rs.getString("reserva");

			
			
		}
		String[] result ={tablet, reserva};
		return result;
	}
    
    
    
    
    
    
    static String[] getLibros(String dni) throws SQLException{
		
		gdni=dni;
	  	String query="SELECT * FROM LIBROS WHERE ID = '"+dni+"'";
		ResultSet rs = ejecutar(query, db);
		String titulo = null;
		String autor = null;
		String signatura =null;
		String reserva =null;
		
		
		
		while (rs.next()){
			titulo = rs.getString("titulo");
			autor = rs.getString("autor");
			signatura= rs.getString("signatura");
			reserva= rs.getString("reserva");
			
			
			
		}
		String[] result ={titulo, autor, signatura, reserva};
		return result;
	}
    //get tablet
    
    //get sala
    static String[] getTablet(String dni) throws SQLException{
		
		gdni=dni;
	  	String query="SELECT * FROM TABLET WHERE ID = '"+dni+"'";
		ResultSet rs = ejecutar(query, db);
		String tablet = null;
		String reserva = null;
	
		
		
		while (rs.next()){
			tablet = rs.getString("tablet");
			reserva= rs.getString("reserva");
			
			
			
		}
		String[] result ={tablet, reserva};
		return result;
	}
    
    
    

    //get sala
    static String[] getSala(String dni) throws SQLException{
		
		gdni=dni;
	  	String query="SELECT * FROM SALASTRABAJO WHERE ID = '"+dni+"'";
		ResultSet rs = ejecutar(query, db);
		String nombre = null;
		String alumnos = "0";
		String reserva = null;

		String tiempo =null;
		
		
		while (rs.next()){
			nombre = rs.getString("nombre");
			alumnos = rs.getString("alumnos");
			reserva= rs.getString("reserva");
			tiempo= rs.getString("tiempo");
			
			
		}
		String[] result ={nombre, alumnos, reserva, tiempo};
		return result;
	}
		
		static String[] getAlumno(String dni) throws SQLException{
			
			gdni=dni;
		  	String query="SELECT * FROM ALUMNO WHERE DNI = '"+dni+"'";
			ResultSet rs = ejecutar(query, db);
			String nombre = null;
			String apellidos = null;
			String username =null;
			String permisos = null;
			String password = null;
			String email = null;
			String reserva = null;
			String multa = null;
			String hora_reserva = null;
			
			
			
			while (rs.next()){
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				username = rs.getString("username");
				permisos= rs.getInt("permisos")+"";
				password= rs.getString("password");
				email=rs.getString("email");
				reserva= rs.getString("reserva");
				multa=rs.getString("multa");
				hora_reserva = rs.getString("hora_reserva");
				
			}
			gname=nombre;
			String[] result ={nombre, apellidos, username,permisos,password,email,reserva,multa,hora_reserva};
			return result;
		}

	
	
	
	
	//getCatalogos
	
	static ArrayList<String> getCatalogos() throws SQLException{
		
	  	String query="SELECT * FROM CATALOGODEPRODUCTOS";
		ResultSet rs = ejecutar(query, db);
		
		ArrayList<String> resultado = new ArrayList<String>();
		while (rs.next()){
			
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			String data = null;
			
			for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
				data = data+"-"+rs.getObject(columnIndex);
			}
			resultado.add(data.substring(2, data.length()));
			
		}
		return resultado;
	}

	
	

	
	
	
	
	
	
	
	
	public static int checkUser(String dni, char[] password) throws SQLException {
		
		String pass = new String(password);
		
		if(dni.length()>0 && pass.length()>0){
			
			String[] emp = getAdministrador(dni);
			
			if(emp[3] != null){
				if(emp[2].equals(pass)){
					if(emp[3].equals("Empleado")){
						return 1;
					}else{
						return 10;
					}
				}else{
					return 0;
				}
			}else{
				return 0;
			}
		}else{
			return 0;
		}
		
	}
	
	//Profesor
	
	//BIBLIOTECARIO
	public static void anadirNuevoProfesor(String dni, String nombre, String apellidos, String username,String permisos, String npassword,String email) throws SQLException {
		String query="INSERT INTO PROFESOR (DNI, NOMBRE, APELLIDOS, USERNAME,PERMISOS,PASSWORD,EMAIL) VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+username+"', "+permisos+" , '"+npassword+"', '"+email+"')";
		ejecutar(query, db);
				
				
	}
	
	public static void anadirNuevoAlumno(String dni, String nombre, String apellidos, String username, String permisos , String password, String email) throws SQLException {
		String query="INSERT INTO ALUMNO (DNI, NOMBRE, APELLIDOS, USERNAME,PERMISOS,PASSWORD,EMAIL) VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+username+"', "+permisos+" , '"+password+"', '"+email+"')";
		ejecutar(query, db);
		
	}
	
	public static void crearNuevoUsuario(String dni, String nombre, String apellidos, String username,String permisos, String npassword, String email) throws SQLException {
		String query="INSERT INTO USUARIO (DNI, NOMBRE, APELLIDOS, USERNAME,PERMISOS,PASSWORD,EMAIL) VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+username+"', "+permisos+" , '"+npassword+"','"+email+"')";
		ejecutar(query, db);
		
	}
	
	//reservaLibroProfesor
		public static void reservalibroPro(String reserva, String ndni) throws SQLException {

			String query="UPDATE PROFESOR SET RESERVA = '"+reserva+"' WHERE DNI ='"+ndni+"'";
			ejecutar(query, db);
		
		}
		
	
	
	
	//reservaLibro
	public static void reservalibro(String reserva, String ndni) throws SQLException {

		String query="UPDATE ALUMNO SET RESERVA = '"+reserva+"' WHERE DNI ='"+ndni+"'";
		ejecutar(query, db);
	
	}
	
	//recoger fecha de la reserva del libro del alumno
	
	public static void horaReseAlumno(String fecha, String ndni)throws SQLException {
		
		String query="UPDATE ALUMNO SET HORA_RESERVA = '"+fecha+"' WHERE DNI ='"+ndni+"'";
		ejecutar(query, db);
		
	}
	
	public static void alquilaAlumnoLibro(String signatura,String fecha,String dni)throws SQLException {
		
		String query="UPDATE ALUMNO SET RESERVA = '"+signatura+"',HORA_RESERVA = '"+fecha+"' WHERE DNI ='"+dni+"'";
		ejecutar(query, db);
		
	}
	
	public static void devolverTabletAl(String signatura,String fecha,String multa, String dni)throws SQLException {
		
		String query="UPDATE ALUMNO SET RESERVA = '"+signatura+"',MULTA = '"+multa+"',HORA_RESERVA = '"+fecha+"' WHERE DNI ='"+dni+"'";
		ejecutar(query, db);
		
	}
	
	public static void devolverTabletProfe(String signatura,String fecha,String multa, String dni)throws SQLException {
		
		String query="UPDATE PROFESOR SET RESERVA = '"+signatura+"',MULTA = '"+multa+"',HORA_RESERVA = '"+fecha+"' WHERE DNI ='"+dni+"'";
		ejecutar(query, db);
		
	}

	public static void alquilaProfeLibro(String signatura,String fecha,String dni)throws SQLException {
		
		String query="UPDATE PROFESOR SET RESERVA = '"+signatura+"', HORA_RESERVA = '"+fecha+"' WHERE DNI ='"+dni+"'";
		ejecutar(query, db);
		
	}
	
	

	//recoger fecha de la reserva del libro del profesor
	public static void horaReseProfe(String sig,String fecha, String ndni)throws SQLException {
		
		String query="UPDATE PROFESOR SET RESERVA= '"+sig+"' HORA_RESERVA = '"+fecha+"' WHERE DNI ='"+ndni+"'";
		ejecutar(query, db);
		
	}
	
	
	
	
	//BIBLIOTECARIO
	public static void crearNuevoBibliotecario(String dni, String nombre, String apellidos, String username,String permisos, String npassword) throws SQLException {
		String query="INSERT INTO BIBLIOTECARIO (DNI, NOMBRE, APELLIDOS, USERNAME,PERMISOS,PASSWORD) VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+username+"', "+permisos+" , '"+npassword+"')";
		ejecutar(query, db);
		
		
	}
	
	//ANADIR SALAS
	public static void anadirSala(String nnombre, int nalumnos, String nreservas, int nnumRese, String ntiempo) throws SQLException {
		String query="INSERT INTO SALASTRABAJO (NOMBRE,ALUMNOS,RESERVA,NUMERO_RESERVAS,TIEMPO) VALUES ('"+nnombre+"','"+nalumnos+"', '"+nreservas+"', '"+nnumRese+"', '"+ntiempo+"')";
		ejecutar(query, db);
		
	}

	//ANADIR LIBROS
		public static void anadirLibros(String asignatura,String titulo, String autor, String signatura, String reserva) throws SQLException {
			String query="INSERT INTO LIBROS (ASIGNATURA,TITULO,AUTOR,SIGNATURA,RESERVA) VALUES ('"+asignatura+"','"+titulo+"', '"+autor+"', '"+signatura+"', '"+reserva+"')";
			ejecutar(query, db);
			
			
		}
	//ANADIR TABLET
		public static void anadirTablet(String tablet, String reserva) throws SQLException {
			String query="INSERT INTO TABLET (TABLET,RESERVA) VALUES ('"+tablet+"', '"+reserva+"')";
			ejecutar(query, db);
					
					
		}	
	
	//BIBLIOTECARIO
		public static void anadirNuevoBibliotecario(String dni, String nombre, String apellidos, String username,String permisos, String npassword) throws SQLException {
			String query="INSERT INTO BIBLIOTECARIO (DNI, NOMBRE, APELLIDOS, USERNAME,PERMISOS,PASSWORD) VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+username+"', "+permisos+" , '"+npassword+"')";
			ejecutar(query, db);
			
			
		}
		
		public static void modificarAlumno(String dni,String nombre, String apellidos, String username, String permisos , String password, String email) throws SQLException {

			String query="UPDATE ALUMNO SET NOMBRE = '"+nombre+"', APELLIDOS= '"+apellidos+"', USERNAME= '"+username+"', PERMISOS= "+permisos+" , PASSWORD= '"+password+"', EMAIL= '"+email+"' WHERE DNI= '"+dni+"'";
			ejecutar(query, db);
		
	}	
		
		
	public static void modificarProfe(String dni,String nombre, String apellidos, String username, String permisos , String password, String email) throws SQLException {

			String query="UPDATE PROFESOR SET NOMBRE = '"+nombre+"', APELLIDOS= '"+apellidos+"', USERNAME= '"+username+"', PERMISOS= "+permisos+" , PASSWORD= '"+password+"', EMAIL= '"+email+"' WHERE DNI= '"+dni+"'";
			ejecutar(query, db);
		
	}	
	

	public static void modificarUsuarios(String dni,String nombre, String apellidos, String username, String permisos , String password, String email) throws SQLException {

			String query="UPDATE USUARIO SET NOMBRE = '"+nombre+"', APELLIDOS= '"+apellidos+"', USERNAME= '"+username+"', PERMISOS= "+permisos+" , PASSWORD= '"+password+"', EMAIL= '"+email+"' WHERE DNI= '"+dni+"'";
			ejecutar(query, db);
		
	}
	
	public static void modificarBibliotecario(String dni,String nombre, String apellidos, String username, String permisos , String password) throws SQLException {

		String query="UPDATE BIBLIOTECARIO SET NOMBRE = '"+nombre+"', APELLIDOS= '"+apellidos+"', USERNAME= '"+username+"', PERMISOS= "+permisos+" , PASSWORD= '"+password+"' WHERE DNI= '"+dni+"'";
		ejecutar(query, db);
	
	}
	
	//consulta signa reserva
	
	public static void cambiarReserva(String reserva,String sign) throws SQLException {

		String query="UPDATE LIBROS SET RESERVA = '"+reserva+"' WHERE SIGNATURA= '"+sign+"'";
		ejecutar(query, db);
	
	}
	
	public static void cambiarTablet(String reserva,String sign) throws SQLException {

		String query="UPDATE TABLET SET RESERVA = '"+reserva+"' WHERE TABLET= '"+sign+"'";
		ejecutar(query, db);
	
	}
	

	public static void removeUser(String dni) throws SQLException {
		String query="DELETE FROM USUARIO WHERE DNI = '"+dni+"'";
		ejecutar(query, db);
	}
	
	public static void removeBibliotecario(String dni) throws SQLException {
		String query="DELETE FROM BIBLIOTECARIO WHERE DNI = '"+dni+"'";
		ejecutar(query, db);
	}
	
	public static void removeProfe(String dni) throws SQLException {
		String query="DELETE FROM PROFESOR WHERE DNI = '"+dni+"'";
		ejecutar(query, db);
	}
	
	public static void removeAlumno(String dni) throws SQLException {
		String query="DELETE FROM ALUMNO WHERE DNI = '"+dni+"'";
		ejecutar(query, db);
	}
	
	//Eliminar libro
	
	public static void removeLibro(String dni) throws SQLException {
		String query="DELETE FROM LIBROS WHERE TITULO = '"+dni+"'";
		ejecutar(query, db);
	}
	
	//Eliminar sala
	
	public static void removeSala(String dni) throws SQLException {
		String query="DELETE FROM SALASTRABAJO WHERE NOMBRE = '"+dni+"'";
		ejecutar(query, db);
	}
	
	//Eliminar tablet
	
		public static void removeTablet(String dni) throws SQLException {
			String query="DELETE FROM TABLET WHERE TABLET = '"+dni+"'";
			ejecutar(query, db);
		}
	

	//Funcion que me hace el backup catalogo
	public static void hacerBackupBibliotecario(File archivo) throws IOException, SQLException {
		
		//Creo el bufer de escritura
		 FileWriter fw = new FileWriter(archivo.getAbsoluteFile());
		 BufferedWriter bw = new BufferedWriter(fw);
		 		
		 //Descargo la tabla de usuarios entera
		 ArrayList<String> datos = funciones.getCatalogos();
		 
		 //Guardo los datos en el nuevo fichero
		 for(int i=0; i<datos.size(); i++){
			String s =datos.get(i);
			 bw.write(s); bw.newLine();
		 }
		 
		 bw.close();
		
	}
	
	
	static ArrayList<String> getUsuarios() throws SQLException{
	    
	      String query="SELECT * FROM USUARIO";
	    ResultSet rs = ejecutar(query, db);
	    
	    ArrayList<String> resultado = new ArrayList<String>();
	    while (rs.next()){
	      
	      java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	      int numberOfColumns = rsmd.getColumnCount();
	      String data = null;
	      
	      for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
	        data = data+"-"+rs.getObject(columnIndex);
	      }
	      resultado.add(data.substring(2, data.length()));
	      
	    }
	    return resultado;
	  }
	
	static ArrayList<String> getAd() throws SQLException{
	    
	      String query="SELECT * FROM ADMINISTRADOR";
	    ResultSet rs = ejecutar(query, db);
	    
	    ArrayList<String> resultado = new ArrayList<String>();
	    while (rs.next()){
	      
	      java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	      int numberOfColumns = rsmd.getColumnCount();
	      String data = null;
	      
	      for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
	        data = data+"-"+rs.getObject(columnIndex);
	      }
	      resultado.add(data.substring(2, data.length()));
	      
	    }
	    return resultado;
	  }
	
	
	static ArrayList<String> getAlu() throws SQLException{

		
	      String query="SELECT * FROM ALUMNO";
	    ResultSet rs = ejecutar(query, db);
	    
	    ArrayList<String> resultado = new ArrayList<String>();
	    while (rs.next()){
	      
	      java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	      int numberOfColumns = rsmd.getColumnCount();
	      String data = null;
	      
	      for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
	        data = data+"-"+rs.getObject(columnIndex);
	      }
	      resultado.add(data.substring(2, data.length()));
	      
	    }
	    return resultado;
	  }

	
	static ArrayList<String> getPro() throws SQLException{
	    
	      String query="SELECT * FROM PROFESOR";
	    ResultSet rs = ejecutar(query, db);
	    
	    ArrayList<String> resultado = new ArrayList<String>();
	    while (rs.next()){
	      
	      java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	      int numberOfColumns = rsmd.getColumnCount();
	      String data = null;
	      
	      for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
	        data = data+"-"+rs.getObject(columnIndex);
	      }
	      resultado.add(data.substring(2, data.length()));
	      
	    }
	    return resultado;
	  }
	static ArrayList<String> getSalas() throws SQLException{
	    
	      String query="SELECT * FROM SALASTRABAJO";
	    ResultSet rs = ejecutar(query, db);
	    
	    ArrayList<String> resultado = new ArrayList<String>();
	    while (rs.next()){
	      
	      java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	      int numberOfColumns = rsmd.getColumnCount();
	      String data = null;
	      
	      for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
	        data = data+"-"+rs.getObject(columnIndex);
	      }
	      resultado.add(data.substring(2, data.length()));
	      
	    }
	    return resultado;
	  }

	static ArrayList<String> getTa() throws SQLException{
	    
	      String query="SELECT * FROM TABLET";
	    ResultSet rs = ejecutar(query, db);
	    
	    ArrayList<String> resultado = new ArrayList<String>();
	    while (rs.next()){
	      
	      java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	      int numberOfColumns = rsmd.getColumnCount();
	      String data = null;
	      
	      for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
	        data = data+"-"+rs.getObject(columnIndex);
	      }
	      resultado.add(data.substring(2, data.length()));
	      
	    }
	    return resultado;
	  }

	static ArrayList<String> getLi() throws SQLException{
	    
	      String query="SELECT * FROM LIBROS";
	    ResultSet rs = ejecutar(query, db);
	    
	    ArrayList<String> resultado = new ArrayList<String>();
	    while (rs.next()){
	      
	      java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	      int numberOfColumns = rsmd.getColumnCount();
	      String data = null;
	      
	      for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
	        data = data+"-"+rs.getObject(columnIndex);
	      }
	      resultado.add(data.substring(2, data.length()));
	      
	    }
	    return resultado;
	  }

	
	
	static ArrayList<String> getBibliotecario() throws SQLException{
	    
	      String query="SELECT * FROM BIBLIOTECARIO";
	    ResultSet rs = ejecutar(query, db);
	    
	    ArrayList<String> resultado = new ArrayList<String>();
	    while (rs.next()){
	      
	      java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	      int numberOfColumns = rsmd.getColumnCount();
	      String data = null;
	      
	      for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
	        data = data+"-"+rs.getObject(columnIndex);
	      }
	      resultado.add(data.substring(2, data.length()));
	      
	    }
	    return resultado;
	  }
	
	
	public static void hacerBackupBiblio(File archivo2) throws IOException, SQLException {
		
		//Creo el bufer de escritura
		 FileWriter fw = new FileWriter(archivo2.getAbsoluteFile());
		 BufferedWriter bw = new BufferedWriter(fw);
		 		
		 //Descargo la tabla de usuarios entera
		 ArrayList<String> datosBi = funciones.getBibliotecario();
		 
		//Guardo los datos en el nuevo fichero
		 for(int i=0; i<datosBi.size(); i++){
			String s =datosBi.get(i);
			 bw.write(s); bw.newLine();
		 }
		  
		 bw.close();
		
	}
	
public static void hacerBackupAlumno(File archivo2) throws IOException, SQLException {
		
		//Creo el bufer de escritura
		 FileWriter fw = new FileWriter(archivo2.getAbsoluteFile());
		 BufferedWriter bw = new BufferedWriter(fw);
		 		
		 //Descargo la tabla de usuarios entera
		 ArrayList<String> datosBi = funciones.getAlu();
		 
		//Guardo los datos en el nuevo fichero
		 for(int i=0; i<datosBi.size(); i++){
			String s =datosBi.get(i);
			 bw.write(s); bw.newLine();
		 }
		  
		 bw.close();
		
	}

public static void hacerBackupAdmin(File archivo2) throws IOException, SQLException {
	
	//Creo el bufer de escritura
	 FileWriter fw = new FileWriter(archivo2.getAbsoluteFile());
	 BufferedWriter bw = new BufferedWriter(fw);
	 		
	 //Descargo la tabla de usuarios entera
	 ArrayList<String> datosBi = funciones.getAd();
	 
	//Guardo los datos en el nuevo fichero
	 for(int i=0; i<datosBi.size(); i++){
		String s =datosBi.get(i);
		 bw.write(s); bw.newLine();
	 }
	  
	 bw.close();
	
}

public static void hacerBackupProfe(File archivo2) throws IOException, SQLException {
	
	//Creo el bufer de escritura
	 FileWriter fw = new FileWriter(archivo2.getAbsoluteFile());
	 BufferedWriter bw = new BufferedWriter(fw);
	 		
	 //Descargo la tabla de usuarios entera
	 ArrayList<String> datosBi = funciones.getPro();
	 
	//Guardo los datos en el nuevo fichero
	 for(int i=0; i<datosBi.size(); i++){
		String s =datosBi.get(i);
		 bw.write(s); bw.newLine();
	 }
	  
	 bw.close();
	
}

public static void hacerBackupSalas(File archivo2) throws IOException, SQLException {
	
	//Creo el bufer de escritura
	 FileWriter fw = new FileWriter(archivo2.getAbsoluteFile());
	 BufferedWriter bw = new BufferedWriter(fw);
	 		
	 //Descargo la tabla de usuarios entera
	 ArrayList<String> datosBi = funciones.getSalas();
	 
	//Guardo los datos en el nuevo fichero
	 for(int i=0; i<datosBi.size(); i++){
		String s =datosBi.get(i);
		 bw.write(s); bw.newLine();
	 }
	  
	 bw.close();
	
}

public static void hacerBackupLibros(File archivo2) throws IOException, SQLException {
	
	//Creo el bufer de escritura
	 FileWriter fw = new FileWriter(archivo2.getAbsoluteFile());
	 BufferedWriter bw = new BufferedWriter(fw);
	 		
	 //Descargo la tabla de usuarios entera
	 ArrayList<String> datosBi = funciones.getLi();
	 
	//Guardo los datos en el nuevo fichero
	 for(int i=0; i<datosBi.size(); i++){
		String s =datosBi.get(i);
		 bw.write(s); bw.newLine();
	 }
	  
	 bw.close();
	
}

public static void hacerBackupTablet(File archivo2) throws IOException, SQLException {
	
	//Creo el bufer de escritura
	 FileWriter fw = new FileWriter(archivo2.getAbsoluteFile());
	 BufferedWriter bw = new BufferedWriter(fw);
	 		
	 //Descargo la tabla de usuarios entera
	 ArrayList<String> datosBi = funciones.getTa();
	 
	//Guardo los datos en el nuevo fichero
	 for(int i=0; i<datosBi.size(); i++){
		String s =datosBi.get(i);
		 bw.write(s); bw.newLine();
	 }
	  
	 bw.close();
	
}
	

	public static void cargarBackupBibliotecario(File archivo) throws IOException, SQLException {
		
		ArrayList<String> datos = new ArrayList<String>();
		
		//Leo los datos del archivo
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
        while((linea=br.readLine())!=null){
        	datos.add(linea);
        }
        
        String query="TRUNCATE TABLE BIBLIOTECARIO";
		ejecutar(query, db);
        
		for(int i=0; i<datos.size(); i++){
			String algo = datos.get(i);
			String[] tb = algo.split("-");
			
			String query1="INSERT INTO BIBLIOTECARIO (NOMBRE,APELLIDOS,USERNAME,DNI,PERMISOS,PASSWORD) VALUES ('"+tb[1]+"', '"+tb[2]+"','"+tb[3]+"', '"+tb[4]+"','"+tb[5]+"', '"+tb[6]+"')";
			ejecutar(query1, db);
		}
        
        
		
	}
	
	//Cargar usuarios
	
	public static void cargarBackupAlumno(File archivo2) throws IOException, SQLException {
		
		ArrayList<String> datos = new ArrayList<String>();
		
		//Leo los datos del archivo
		FileReader fr = new FileReader(archivo2);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
        while((linea=br.readLine())!=null){
        	datos.add(linea);
        }
        
        
        
        String query="TRUNCATE TABLE ALUMNO";
		ejecutar(query, db);
        
		for(int i=0; i<datos.size(); i++){
			String algo = datos.get(i);
			String[] tb = algo.split("-");
			
			String query1="INSERT INTO ALUMNO (NOMBRE,APELLIDOS,USERNAME,DNI,PERMISOS,PASSWORD,EMAIL,RESERVA,MULTA,HORA_RESERVA) VALUES ('"+tb[1]+"', '"+tb[2]+"','"+tb[3]+"', '"+tb[4]+"','"+tb[5]+"', '"+tb[6]+"','"+tb[7]+"','"+tb[8]+"', '"+tb[9]+"','"+tb[10]+"')";
			ejecutar(query1, db);
		}
        
		
		
		
		
		
	}



public static void cargarBackupProfesor(File archivo2) throws IOException, SQLException {
		
		ArrayList<String> datos = new ArrayList<String>();
		
		//Leo los datos del archivo
		FileReader fr = new FileReader(archivo2);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
        while((linea=br.readLine())!=null){
        	datos.add(linea);
        }
        
        
        
        String query="TRUNCATE TABLE PROFESOR";
		ejecutar(query, db);
        
		for(int i=0; i<datos.size(); i++){
			String algo = datos.get(i);
			String[] tb = algo.split("-");
			
			String query1="INSERT INTO PROFESOR (NOMBRE,APELLIDOS,USERNAME,DNI,PERMISOS,PASSWORD,EMAIL,RESERVA,MULTA,HORA_RESERVA) VALUES ('"+tb[1]+"', '"+tb[2]+"','"+tb[3]+"', '"+tb[4]+"','"+tb[5]+"', '"+tb[6]+"','"+tb[7]+"','"+tb[8]+"', '"+tb[9]+"','"+tb[10]+"')";
			ejecutar(query1, db);
		}
        
		
		
		
		
		
	}



public static void cargarBackupSalas(File archivo2) throws IOException, SQLException {
	
	ArrayList<String> datos = new ArrayList<String>();
	
	//Leo los datos del archivo
	FileReader fr = new FileReader(archivo2);
	BufferedReader br = new BufferedReader(fr);
	
	String linea;
    while((linea=br.readLine())!=null){
    	datos.add(linea);
    }
    
    
    
    String query="TRUNCATE TABLE SALASTRABAJO";
	ejecutar(query, db);
    
	for(int i=0; i<datos.size(); i++){
		String algo = datos.get(i);
		String[] tb = algo.split("-");
		
		String query1="INSERT INTO SALASTRABAJO (NOMBRE,ALUMNOS,RESERVA,NUMERO_RESERVAS,TIEMPO) VALUES ('"+tb[1]+"', '"+tb[2]+"','"+tb[3]+"', '"+tb[4]+"','"+tb[5]+"')";
		ejecutar(query1, db);
	}
    
	
	
	
	
	
}

public static void cargarBackupTablet(File archivo2) throws IOException, SQLException {
	
	ArrayList<String> datos = new ArrayList<String>();
	
	//Leo los datos del archivo
	FileReader fr = new FileReader(archivo2);
	BufferedReader br = new BufferedReader(fr);
	
	String linea;
    while((linea=br.readLine())!=null){
    	datos.add(linea);
    }
    
    
    
    String query="TRUNCATE TABLE TABLET";
	ejecutar(query, db);
    
	for(int i=0; i<datos.size(); i++){
		String algo = datos.get(i);
		String[] tb = algo.split("-");
		
		String query1="INSERT INTO TABLET (TABLET,RESERVA) VALUES ('"+tb[1]+"', '"+tb[2]+"')";
		ejecutar(query1, db);
	}
    
	
	
	
	
	
}
public static void cargarBackupLibros(File archivo2) throws IOException, SQLException {
	
	ArrayList<String> datos = new ArrayList<String>();
	
	//Leo los datos del archivo
	FileReader fr = new FileReader(archivo2);
	BufferedReader br = new BufferedReader(fr);
	
	String linea;
    while((linea=br.readLine())!=null){
    	datos.add(linea);
    }
    
    
    
    String query="TRUNCATE TABLE LIBROS";
	ejecutar(query, db);
    
	for(int i=0; i<datos.size(); i++){
		String algo = datos.get(i);
		String[] tb = algo.split("-");
		
		String query1="INSERT INTO LIBROS (ASIGNATURA,TITULO,AUTOR,SIGNATURA,RESERVA) VALUES ('"+tb[1]+"', '"+tb[2]+"','"+tb[3]+"', '"+tb[4]+"','"+tb[5]+"')";
		ejecutar(query1, db);
	}
    
	
	
	
	
	
}	

public static void cargarBackupBiblio(File archivo2) throws IOException, SQLException {
	
	ArrayList<String> datos = new ArrayList<String>();
	
	//Leo los datos del archivo
	FileReader fr = new FileReader(archivo2);
	BufferedReader br = new BufferedReader(fr);
	
	String linea;
    while((linea=br.readLine())!=null){
    	datos.add(linea);
    }
    
    
    
    String query="TRUNCATE TABLE BIBLIOTECARIO";
	ejecutar(query, db);
    
	for(int i=0; i<datos.size(); i++){
		String algo = datos.get(i);
		String[] tb = algo.split("-");
		
		String query1="INSERT INTO BIBLIOTECARIO (NOMBRE,APELLIDOS,USERNAME,DNI,PERMISOS,PASSWORD) VALUES ('"+tb[1]+"', '"+tb[2]+"','"+tb[3]+"', '"+tb[4]+"','"+tb[5]+"','"+tb[6]+"')";
		ejecutar(query1, db);
	}
    
	
	
	
	
	
}



public static void cargarBackupAdm(File archivo2) throws IOException, SQLException {
	
	ArrayList<String> datos = new ArrayList<String>();
	
	//Leo los datos del archivo
	FileReader fr = new FileReader(archivo2);
	BufferedReader br = new BufferedReader(fr);
	
	String linea;
    while((linea=br.readLine())!=null){
    	datos.add(linea);
    }
    
    
    
    String query="TRUNCATE TABLE ADMINISTRADOR";
	ejecutar(query, db);
    
	for(int i=0; i<datos.size(); i++){
		String algo = datos.get(i);
		String[] tb = algo.split("-");
		
		String query1="INSERT INTO ADMINISTRADOR (NOMBRE,APELLIDOS,USERNAME,DNI,PERMISOS,PASSWORD,EMAIL) VALUES ('"+tb[1]+"', '"+tb[2]+"','"+tb[3]+"', '"+tb[4]+"','"+tb[5]+"','"+tb[6]+"','"+tb[7]+"')";
		ejecutar(query1, db);
	}
    
	
	
	
	
	
}

















	



	



	
  
}