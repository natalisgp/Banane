package Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	static ResultSet ejecutar(String query, Connection db) throws SQLException{
		
		Statement stmt = db.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
		
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

	
	
	//Funcion que coge los datos de la base de datos de la tabla catalogo
	static String[] getCatalogo(String id) throws SQLException{
		
		gid=id;
	  	String query="SELECT * FROM CATALOGODEPRODUCTOS WHERE CATALOGOID = '"+id+"'";
		ResultSet rs = ejecutar(query, db);
		String cantidad = null;
	
		
		while (rs.next()){
			cantidad = rs.getString("cantidad");
			
		}
		gcantidad=cantidad;
		String[] result ={id,cantidad};
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
	
	
	public static void añadirNuevoUsuario(String dni, String nombre, String apellidos, String username, String permisos , String password) throws SQLException {
		String query="INSERT INTO USUARIO (DNI, NOMBRE, APELLIDOS, USERNAME,PERMISOS,PASSWORD) VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+username+"', "+permisos+" , '"+password+"')";
		ejecutar(query, db);
		
	}
	
	public static void crearNuevoUsuario(String dni, String nombre, String apellidos, String username,String permisos, String password) throws SQLException {
		String query="INSERT INTO USUARIO (DNI, NOMBRE, APELLIDOS, USERNAME,PERMISOS,PASSWORD) VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+username+"', "+permisos+" , '"+password+"')";
		ejecutar(query, db);
		
	}
	
	//BIBLIOTECARIO
	public static void crearNuevoBibliotecario(String dni, String nombre, String apellidos, String username,String permisos, String password) throws SQLException {
		String query="INSERT INTO BIBLIOTECARIO (DNI, NOMBRE, APELLIDOS, USERNAME,PERMISOS,PASSWORD) VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+username+"', "+permisos+" , '"+password+"')";
		ejecutar(query, db);
		
		
	}
	

	public static void modificarUsuarios(String dni,String nombre, String apellidos, String username, String permisos , String password) throws SQLException {

		
			String query="UPDATE USUARIO SET NOMBRE = '"+nombre+"', APELLIDOS= '"+apellidos+"', USERNAME= '"+username+"', PERMISOS= "+permisos+" , PASSWORD= '"+password+"' WHERE DNI= '"+dni+"'";
			ejecutar(query, db);
		
	}

	public static void removeUser(String dni) throws SQLException {
		String query="DELETE FROM USUARIO WHERE DNI = '"+dni+"'";
		ejecutar(query, db);
	}

	//Funcion que me hace el backup catalogo
	public static void hacerBackupCatalogo(File archivo) throws IOException, SQLException {
		
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
	
	
	
	public static void hacerBackupUsuarios(File archivo2) throws IOException, SQLException {
		
		//Creo el bufer de escritura
		 FileWriter fw = new FileWriter(archivo2.getAbsoluteFile());
		 BufferedWriter bw = new BufferedWriter(fw);
		 		
		 //Descargo la tabla de usuarios entera
		 ArrayList<String> datos = funciones.getUsuarios();
		 
		 //Guardo los datos en el nuevo fichero
		 for(int i=0; i<datos.size(); i++){
			String s =datos.get(i);
			 bw.write(s); bw.newLine();
		 }
		 
		 bw.close();
		
	}
	

	public static void cargarBackupCatalogo(File archivo) throws IOException, SQLException {
		
		ArrayList<String> datos = new ArrayList<String>();
		
		//Leo los datos del archivo
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
        while((linea=br.readLine())!=null){
        	datos.add(linea);
        }
        
        String query="TRUNCATE TABLE CATALOGODEPRODUCTOS";
		ejecutar(query, db);
        
		for(int i=0; i<datos.size(); i++){
			String algo = datos.get(i);
			String[] tb = algo.split("-");
			
			String query1="INSERT INTO CATALOGODEPRODUCTOS (CATALOGOID, CANTIDAD) VALUES ('"+tb[1]+"', '"+tb[2]+"')";
			ejecutar(query1, db);
		}
        
        
		
	}
	
	//Cargar usuarios
	
	public static void cargarBackupUsuario(File archivo2) throws IOException, SQLException {
		
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
			
			String query1="INSERT INTO ADMINISTRADOR (NOMBRE,APELLIDOS,USERNAME,DNI,PERMISOS,PASSWORD) VALUES ('"+tb[1]+"', '"+tb[2]+"','"+tb[3]+"', '"+tb[4]+"','"+tb[5]+"', '"+tb[6]+"')";
			ejecutar(query1, db);
		}
        
        
		
	}

	
	
	


  
}