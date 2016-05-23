package Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class Query {
	Logger logger = Logger.getLogger(Query.class.getName());
	Conection start = new Conection();
	boolean flag = true;
	
	public String encode (String ms) throws NoSuchAlgorithmException{
		
		byte[] encoded = Base64.encodeBase64(ms.getBytes());
		 
	      
	     return new String(encoded);
	}
	public String decode(String ms) {

		byte[] decoded = Base64.decodeBase64(ms.getBytes());
		 
		//System.out.println("Desicfrado de ms: "+new String(encoded));
	      
	    return new String(decoded);
	}
	
	public boolean searchKey( String user , String key ) throws NoSuchAlgorithmException{
	
		start.getConection();
		
		start.executeQuery( "SELECT USUARIO , CONTRASEÑA FROM ADMIN WHERE USUARIO = '" + encode(user) + "' AND CONTRASEÑA = '"+ encode(key) + "' ");
		
		try {
			
			if( start.getResult().next() ){
				logger.info("usuario dado de alta en la clase QUERY");
				return true;
			}
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return false;
	}
	/*
	public String[] refillComboBoxUser( )
	{
		String fix[] = new String [ 20 ];
		int cont = 0;
		
		start.getConection();
		
		start.executeQuery( "SELECT * FROM TABLA");
		
		try
		{
			
			while( start.getResult().next() )
			{
				for (int i = 1; i < 11; i++) {
					fix [ cont ] = start.getResult().getString( i );
					++cont;
				}
			}
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
		
		return fix;
	}
		*/
	
	public void getTroubles() throws SQLException, IOException, URISyntaxException{
			
		Calendar a = new GregorianCalendar();
		
		int day,month,year;
		String smonth,sday;
		//day = a.getTime();
		day = a.get(Calendar.DAY_OF_MONTH);
		month = a.get(Calendar.MONTH);
		year = a.get(Calendar.YEAR);
		
		if(day < 10)
			sday= "0"+day;
		else
			sday = Integer.toString(day);
		if(month < 10)
			smonth = "0"+month;
		else
			smonth = Integer.toString(month);		
	
		
		String date = ""+sday+smonth+year;
/*
		String path = Query.class.getProtectionDomain().getCodeSource().
				getLocation().toURI().getPath();
		
		path = path.substring(0, path.lastIndexOf('/')+1);
		
		File root = new File(path);
		
		File myFile = new File(root, "troubles"+date+".txt");
				
		myFile.delete();
		
		FileWriter fw = new FileWriter(myFile,true);
*/
		File file = new File("troubles"+date+".txt");
		
		if(file.exists()){
			file.delete();
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		bw.write("DNI           "+"FECHA       "+"TIPO");
		bw.write("\n");
		
		start.getConection();
		
		start.executeQuery("SELECT * FROM TROUBLES");
		
		while(start.getResult().next()){
			
			for(int i=1;i<4;i++){
				
				if(i==3){
					bw.append(decode(start.getResult().getString(i)));
					bw.write("\n");
				}else
					bw.append(decode(start.getResult().getString(i)+"    "));
				
				
			}
			
		}
		
		bw.close();
		
		
	}
	public void getHours() throws SQLException, IOException, URISyntaxException{
		
		Calendar a = new GregorianCalendar();
		
		int day,month,year;
		String smonth,sday;
		//day = a.getTime();
		day = a.get(Calendar.DAY_OF_MONTH);
		month = a.get(Calendar.MONTH);
		year = a.get(Calendar.YEAR);
		
		if(day < 10)
			sday= "0"+day;
		else
			sday = Integer.toString(day);
		if(month < 10)
			smonth = "0"+month;
		else
			smonth = Integer.toString(month);		
	
		
		String date = ""+sday+smonth+year;

		File file = new File("hours"+date+".txt");
		
		if(file.exists()){
			file.delete();
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		bw.write("DNI           "+"HORAS");
		bw.write("\n");
		
		String dni;
		
		start.getConection();
		
		start.executeQuery("SELECT DNI FROM WORKERS");
		
		while(start.getResult().next()){
			
			dni = start.getResult().getString(1);
			
			bw.append(decode(start.getResult().getString(1))+"      ");
		
			start.executeQuery("SELECT HORAS_TRABAJADAS FROM WORKERS WHERE DNI = '"+dni+"'");
			
			start.getResult().next();
				
			bw.append(decode(start.getResult().getString(1)));
			bw.write("\n");
					
				

		}
		bw.close();
		
		
	}
	public boolean newAdmin (String data[]) throws SQLException, NoSuchAlgorithmException{
		

		int after;
		int before;
		
		start.getConection();
		
		//Contamos el numero de filas antes de eliminar
		start.executeQuery( "Select count(USUARIO) from ADMIN");		
		start.getResult().next();	
		before =  start.getResult().getInt("count(USUARIO)" ) ;
		
		
		    		
		start.executeQuery( "INSERT INTO ADMIN (CONTRASEÑA,USUARIO,EMAIL)VALUES ('"+encode(data[1])+"','"+encode(data[0])+"','"+encode(data[2])+"')");
		
		//Cntamos en numero de filas despues
		start.executeQuery( "Select count(USUARIO) from ADMIN");		
		start.getResult().next();	
		after =  start.getResult().getInt("count(USUARIO)" ) ;
	
		
		//Si son diferentes se elimino correctamente
		if(after != before){
			logger.info("nuevo administrador correcto");
			return true;
		}
		
		return false;
	}
	public void signUp(String [] data) throws SQLException, NoSuchAlgorithmException{
		
		
		start.getConection();
		
		//LLamo desde information
		if (flag == true){
			
			start.executeQuery( "Select count(ID) from workers");
			
			start.getResult().next();	
			
			int workers = start.getResult().getInt("count(ID)" );
			
			//System.out.println(workers);
			
			int ID[]= new int [workers];
			int id = 1;
			
			if(workers != 0 ){
	
				start.executeQuery("SELECT ID FROM WORKERS");
	
				int k= 0;
				while(start.getResult().next()){	
					
						if(k<workers){
							//String a = start.getResult().getString(1);
							//System.out.println("ID => "+a);
							ID[k] = Integer.parseInt(decode(start.getResult().getString(1))) ;
							//start.getResult().next();
							k++;
						}
					
				}
				ID = ordenaBurbuja(ID);
				
				Boolean bol = false;
				
				//la posible id = 0,mientras no encontremos buscamos
				while(!bol){
					
					for(int i=0;i<workers;i++){
						
						//si encontramos la id no nos vale, salimos del for
						if(ID[i]==id){
							id++;
							break;
						}
						//Si llegamos aqui no nos hemos salido, por lo tanto no existe id
						if(i == workers-1){	
							bol = true;
							break;
						}
					}	
				}
			}
			data[8] = Integer.toString(id);
		}
		
		start.executeQuery( "INSERT INTO workers (NOMBRE,APELLIDOS,DNI,EMAIL,DIRECCION,NACIMIENTO,SEXO,PUESTO,ID,HORAS_TRABAJADAS)VALUES ('"+encode(data[0])+"','"+encode(data[1])+"','"+encode(data[2])+"','"+encode(data[3])+"','"+encode(data[4])+"','"+encode(data[5])+"','"+encode(data[6])+"','"+encode(data[7])+"','"+encode(data[8])+"','"+encode(data[9])+"')");
		//start.executeQuery( "INSERT INTO workers (NOMBRE,APELLIDOS,DNI,EMAIL,DIRECCION,NACIMIENTO,SEXO,PUESTO,ID,HORAS_TRABAJADAS,SALARIO)VALUES ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"','"+data[7]+"','"+data[8]+"','"+data[9]+"','"+data[10]+"')");
		
		
		if(start.getResult().next()){
			logger.info("Trabajador dado de alta correctamente");
			JOptionPane.showMessageDialog( null,"Trabajador dado de alta correctamente" , "Acceso correcto" ,
					JOptionPane.INFORMATION_MESSAGE );
			
		}
			
	}
	public boolean delete(String dni) throws SQLException, NoSuchAlgorithmException {
		
		int after;
		int before;
		
		start.getConection();
		
		//Contamos el numero de filas antes de eliminar
		start.executeQuery( "Select count(DNI) from workers");		
		start.getResult().next();	
		before =  start.getResult().getInt("count(DNI)" ) ;
		    		
		start.executeQuery( "DELETE FROM workers WHERE DNI = '" + encode(dni) +"'");
		
		//Cntamos en numero de filas despues
		start.executeQuery( "Select count(DNI) from workers");		
		start.getResult().next();		
		after = start.getResult().getInt("count(DNI)" ) ;
		
		//Si son diferentes se elimino correctamente
		if(after != before)
		{
			logger.info("trabajador eliminado correctamente");
			return true;
		}
			
		return false;
	}
	public boolean comprueba(String dni) throws SQLException, NoSuchAlgorithmException{
		
		start.getConection();
		
		String dni2 = encode(dni);
		//System.out.println(dni2);
		
		start.executeQuery( "SELECT * FROM WORKERS WHERE DNI = '" + dni2 + "' ");
		
		if(start.getResult().next())
			return true;
		else
			return false;
		
	}
	
	public String[] getInfo(String dni) throws NoSuchAlgorithmException{
		
		String info[] = new String [8];
		int cont =0;
		
		
		start.getConection();
		
		start.executeQuery( "SELECT * FROM WORKERS WHERE DNI = '" + encode(dni) + "' ");
		
		try{
		
			
			while( start.getResult().next() ){
			
				for (int i = 1; i < 9; i++) {
					
					String aux = start.getResult().getString( i );
					//descodificamos la info
					info [ cont ] = decode(aux);
					cont++;
				}
			}
		}catch( SQLException e ){
		
			e.printStackTrace();
		}
		logger.info("información de trabajador obtenida con exito");
		return info;

	}
	public void updateInfo(String name,String surname,String dni,String email,String direccion,String gender,String date,String place) throws NoSuchAlgorithmException{
		
		start.getConection();
			
		//start.executeQuery( "UPDATE WORKERS SET NOMBRE = '"+name+"', APELLIDOS ='"+surname+" WHERE DNI = '"+dni+"'");
		start.executeQuery( "UPDATE WORKERS SET NOMBRE = '"+encode(name)+"' WHERE DNI = '"+encode(dni)+"'");
		start.executeQuery( "UPDATE WORKERS SET APELLIDOS ='"+encode(surname)+"' WHERE DNI = '"+encode(dni)+"'");
		start.executeQuery( "UPDATE WORKERS SET EMAIL = '"+encode(email)+"' WHERE DNI = '"+encode(dni)+"'");
		start.executeQuery( "UPDATE WORKERS SET DIRECCION = '"+encode(direccion)+"' WHERE DNI = '"+encode(dni)+"'");
		start.executeQuery( "UPDATE WORKERS SET SEXO = '"+encode(gender)+"' WHERE DNI = '"+encode(dni)+"'");
		start.executeQuery( "UPDATE WORKERS SET NACIMIENTO ='"+encode(date)+"' WHERE DNI = '"+encode(dni)+"'");
		start.executeQuery( "UPDATE WORKERS SET puesto = '"+encode(place)+"' WHERE DNI = '"+encode(dni)+"'");
		logger.info("informacion de trabajador actualizada");
			
	}
	public String [][] workers() throws SQLException{
		
		start.getConection();
		
		start.executeQuery( "Select count(USUARIO) from liveworkers");
		
		start.getResult().next();	
		
		int x = start.getResult().getInt("count(USUARIO)" ) ;
		
		String[][] data = new String[x][4];

		start.executeQuery("SELECT * FROM LIVEWORKERS");
		
		int cont = 0;
		
		
		try{
		
			String ID,DNI,time,place;
			while( start.getResult().next() ){
			
				
				ID =  start.getResult().getString( 1 );
				data[ cont ][0] = decode(ID);
				
				DNI =  start.getResult().getString( 2 );
				data[ cont ][2] = decode(DNI);
				
				time =  start.getResult().getString( 3 );
				data[ cont ][1] = decode(time);
				
				place =  start.getResult().getString( 4 );
				data[ cont ][3] = decode(place);
				
				
				cont++;
				
			}
		}catch( SQLException e ){
		
			e.printStackTrace();
		}
		
		
		return data;
		
	}
	public String searchAdminEmail() throws SQLException, NoSuchAlgorithmException{
		
		start.getConection();
		
		start.executeQuery( "SELECT USUARIO FROM CURRENTADMIN ");
		
		start.getResult().next();
		
		String user = start.getResult().getString(1);
		
		start.executeQuery("SELECT EMAIL FROM ADMIN WHERE USUARIO = '"+user+"'");
		
		start.getResult().next();
		
		//Descodificamos el email para mostrarlo
		String email = decode(start.getResult().getString(1));
		
		logger.info("email de administrador proporcionado");
		return email;
		
		
		
	}
	public void saveAdmin(String text) throws NoSuchAlgorithmException {
		
		start.getConection();
		
		start.executeQuery("INSERT INTO  CURRENTADMIN (USUARIO) VALUES ('"+encode(text)+"')");

		
		
	}
	public void logOut(String admin) throws NoSuchAlgorithmException {

		start.getConection();
		
		start.executeQuery("DELETE FROM CURRENTADMIN where USUARIO = '"+encode(admin)+"'");
			
	}
	public void backup() throws SQLException{
		
		//ArrayList <String> workers  = new ArrayList<String>();

		int n = cuentaTrabajadores();
		
		
		start.executeQuery( "Select count(USUARIO) from admin");
		
		start.getResult().next();
		
		int n2 = start.getResult().getInt("count(USUARIO)");
		
		
		saveWorkersDatabase(n);
		saveAdminDatabase(n2);
		
		logger.info("base de datos guardada");
		JOptionPane.showMessageDialog( null,"Base de datos guardada" , "Correcto" ,
				JOptionPane.INFORMATION_MESSAGE );
		
	}
	
	
	private int cuentaTrabajadores() throws SQLException {
		
		start.getConection();
		
		start.executeQuery( "Select count(NOMBRE) from workers");
		
		start.getResult().next();
		
		return start.getResult().getInt("count(NOMBRE)");
	}
	private void saveAdminDatabase(int n2) throws SQLException {
		
		String admin[][] = new String [n2][3];
		
		start.executeQuery("Select * from admin");
		
		try{
			String aux;
			
			while( start.getResult().next() ){
			
				for(int i=0;i<n2;i++){
					for (int j = 1; j < 4; j++) {
						
						aux = (start.getResult().getString( j ));
						
						admin[i][j-1] = aux;
						
					}
					//avanzamos
					start.getResult().next();

				}
			}
			
		}catch( SQLException e ){
		
			e.printStackTrace();
		}
		
		new SaveDatabase(admin,2);
		
		
	}
	private void saveWorkersDatabase(int n) throws SQLException {
		 
		String workers[][] = new String [n][11];
		
		start.executeQuery("Select * from workers");
		
		try{
			String aux;
			
			while( start.getResult().next() ){
			
				for(int i=0;i<n;i++){
					for (int j = 1; j < 12; j++) {
						
						aux = (start.getResult().getString( j ));
						
						workers[i][j-1] = aux;
						
					}
					//avanzamos
					start.getResult().next();

				}
			}
			
		}catch( SQLException e ){
		
			e.printStackTrace();
		}
		
		new SaveDatabase(workers,1);
		

		
	}

	public int[] ordenaBurbuja ( int[] nums){
		

		for(int i=1;i < nums.length; i++){
			for(int j=nums.length-1; j>=i; j--){
				if(nums[j-1] > nums[j]){
					int aux = nums [j-1];
					nums [j-1] = nums[j];
					nums[j]= aux;
				}
			}
			
		}
		return nums;
	}
	public boolean sameDni(String dni) throws SQLException, NoSuchAlgorithmException{
		
		String s;
		
		start.getConection();
		
		start.executeQuery( "SELECT dni FROM workers");
		
		while (start.getResult().next()){
		
			s = decode (start.getResult().getString(1));
		
			if(s.equals(dni))
				return false;
		}	

			return true;
		
	}

	public void load() throws URISyntaxException, IOException, SQLException {
		
		LoadDatabase l = new LoadDatabase();
		
		
		String workers [][] = l.load(1);
		String admin[][] = l.load(2);
		
		try {
			createNewDatabase(admin,workers);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void createNewDatabase(String[][] admin, String[][] workers) throws SQLException, NoSuchAlgorithmException {
		
		this.flag = false;
		
		//Workers
		for(int i=0;i<workers.length;i++)
			this.signUp(workers[i]);
		//Admin
		for(int i=0;i<admin.length;i++)
			this.newAdmin(admin[i]);	
		
		JOptionPane.showMessageDialog( null,"Base de datos actualizada" , "Correcto" ,
				JOptionPane.INFORMATION_MESSAGE );
		
		
	}
	public String getEmail(String dni) throws SQLException, NoSuchAlgorithmException {
		
		start.getConection();
		
		start.executeQuery( "SELECT email FROM workers where DNI = '"+encode(dni)+"'");
		
		start.getResult().next();
		
		String email = decode(start.getResult().getString(1));
		
		return email;
	}

	
	
}
