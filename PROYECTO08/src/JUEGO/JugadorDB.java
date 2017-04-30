package JUEGO;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class JugadorDB {
	
	
	private Connection conexion;
	private Statement orden = null;
	
	public JugadorDB(Connection c) {
		this.conexion=c;
	}
	


	public void insertarJugador(String nombre, String apellidos, int edad) {
		try{
			orden = conexion.createStatement();
		    String sql = "INSERT INTO player (nombre,apellidos,edad) " +
		                   "VALUES ('"+nombre+"', '"+apellidos+"', "+edad+")";
		    orden.executeUpdate(sql);
		    System.out.println("Jugador registrado con exito");
		    
		   }catch(SQLException se){
			      //Se produce un error con la consulta
			      se.printStackTrace();
		   }catch(Exception e){
			      //Se produce cualquier otro error
			      e.printStackTrace();
		   }finally{
			      //Cerramos los recursos
			      try{
			         if(orden!=null)
			        	 orden.close();
			      }catch(SQLException se){
			    	  se.printStackTrace();
			      }
			      try{
			         if(conexion!=null)
			        	 conexion.close();
			      	 }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			}//end try
	}
		
	}
