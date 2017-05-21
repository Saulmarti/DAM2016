package JUEGO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import JUEGO.Jugador;

import java.sql.SQLException;

public class JugadorDB {
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String edad;
	private Connection conexion;
	private Statement orden = null;
	private Jugador j;
	private Statement instruccion = null;
	private PreparedStatement instruccionPreparada = null;
	private ResultSet resultados = null;
	private String sentencia = "";
	
	public JugadorDB(Connection c) {
		this.conexion=c;
	}
	


	public void insertarJugador(String nombre, String apellido1, String apellido2, int edad) {
		try{
			orden = conexion.createStatement();
		    String sql = "INSERT INTO player (nombre ,apellido1, apellido2,edad) " +
		                   "VALUES ('"+nombre+"', '"+apellido1+"','"+apellido2+"', "+edad+")";
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
	public Jugador buscarJugador(String nombreBuscar){
		ResultSet rs;
		Jugador j=new Jugador();
		try{
		  orden = conexion.createStatement();
	      String sql = "SELECT id, nombre, apellido1, apellido2, edad FROM player WHERE nombre='"+nombreBuscar+"'";
	      rs = orden.executeQuery(sql);
	      //Cogemos los usuarios y recorremos la BBDD mientras haya datos
	      while(rs.next()){
	    	  j.setId(rs.getInt("id"));
	    	  j.setNombre(rs.getString("nombre"));
	    	  j.setApellido1(rs.getString("apellido1"));
	    	  j.setApellido2(rs.getString("apellido2"));
	    	  j.setEdad(rs.getInt("edad"));
		      //Cogera todos los usuarios que coincidan en nombre, pero solo devolverá el último encontrado
		      //porqué va reescribiendo u
		      System.out.println(j.getId()+" "+j.getNombre()+" "+j.getApellido1()+" "+j.getApellido2()+" "+j.getEdad()+"\n");
	      }
	      //Debemos cerrar la conexion
	      rs.close();
	      return j;
		}catch(SQLException se){
			      //Se produce un error con la consulta
			      se.printStackTrace();
			      return j;
		}catch(Exception e){
			      //Se produce cualquier otro error
			      e.printStackTrace();
			      return j;
		}finally{
		      //Cerramos los recursos
		      try{
		         if(orden!=null)
		        	 conexion.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conexion!=null)
		        	 conexion.close();
		      	 }catch(SQLException se){
		         se.printStackTrace();
		      	 }//end finally try
		}
}
	
//Método que permite buscar un usuario en la base de datos devolviendolos en un JComboBox
//Busca los usuarios por el nombre y devuelve todos los que tienen el mismo nombre
//Método sobrecargado
	public void buscarJugador(String nombreBuscar,JComboBox jc){
		ResultSet rs;
		try{
			orden = conexion.createStatement();
			  /*Si quisiésemos que devolviese todos los usuarios de la BBDD en el COMBOX haríamos
			   * String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM usuarios";
			   * y eliminaríamos el input de nombreBuscar en el método
			   */
		      String sql = "SELECT id, nombre, apellido1, apellido2, edad FROM player WHERE nombre='"+nombreBuscar+"'";
		      rs = orden.executeQuery(sql);
			//Cogemos los usuarios
			      while(rs.next()){
			    	  Jugador j=new Jugador(); //Se generará un usuario por cada coincidencia
			    	  j.setId(rs.getInt("id"));
			    	  j.setNombre(rs.getString("nombre"));
			    	  j.setApellido1(rs.getString("apellido1"));
			    	  j.setApellido2(rs.getString("apellido2"));
			    	  j.setEdad(rs.getInt("edad"));
				      //Añadimos el usuario encontrado al JComboBox
				      //El usuario no "será destruido" al salir del método porque se almacena en un objeto
				      //superior que lo guarda, que es el jc (un objeto ComboBox)
				      jc.addItem(j);
				      //Comprobación por monitor
				      System.out.println("Coincidencias: "+j.toString()+"\n");
			      }
			    //Debemos cerrar la conexion
			      rs.close();
			      
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
				        	 conexion.close();
				      }catch(SQLException se){
				      }
				      try{
				         if(conexion!=null)
				        	 conexion.close();
				      	 }catch(SQLException se){
				         se.printStackTrace();
				      	 }//end finally try
				}
	}
	
	//Método que permite buscar actualizar un usuario en la base de datos usando la
	//sentencia SQL UPDATE
			public void actualizarJugador(Jugador j){
				try{
				  orden = conexion.createStatement();
				  //Configuramos la sentencia sql para actualizar el usuario en la tabla usuario
				  //El usuario se busca por su clave primaria, que es única.
			      String sql = "UPDATE player " +
		                       "SET nombre = '"+j.getNombre()+"'"+
		                       ",apellido1 = '"+j.getApellido1()+"'"+
		                       ",apellido2 = '"+j.getApellido2()+"'"+
		                       ",edad = "+j.getEdad()+" "+
			    		       "WHERE id = "+j.getId();
			      
			      orden.executeUpdate(sql); //Ejecutamos la sentencia SQL de UPDATE
			      //Comprobación por monitor
			      System.out.println(sql+"\n");
			      System.out.println("Actualizado: "+j.toString()+"\n");
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
				      }
				      try{
				         if(conexion!=null)
				        	 conexion.close();
				      	 }catch(SQLException se){
				         se.printStackTrace();
				      	 }//end finally try
				}			
	}

			
			public void actualizarJugadorPreparada(Jugador j){
				try{
				  orden = conexion.createStatement();
				// create the java mysql update preparedstatement
				// Creamos la sentencia "tipo" que queremos ejecutar
			      String sql = "UPDATE player " +
		                       "SET nombre = ?"+
		                       ",apellido1 = ?"+
		                       ",apellido2 = ?"+
		                       ",edad = ? "+
			    		       "WHERE id = "+j.getId();
			      PreparedStatement preparedStmt = conexion.prepareStatement(sql);
			      
			      //Asignamos valores concretos a ?
			      preparedStmt.setString(1, j.getNombre());
			      preparedStmt.setString(2, j.getApellido1());
			      preparedStmt.setString(3, j.getApellido2());
			      preparedStmt.setInt(4, j.getEdad());
			 
			      // Se ejecuta la consulta y el update
			      
			      preparedStmt.executeUpdate();
			      
			      //Comprobación por monitor
			      System.out.println(sql+"\n");
			      System.out.println("Actualizado: "+j.toString()+"\n");
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
				      }
				      try{
				         if(conexion!=null)
				        	 conexion.close();
				      	 }catch(SQLException se){
				         se.printStackTrace();
				      	 }//end finally try
				}			
			}
			public void asignarPropiedades(Jugador j, String nombre){
				try{
					sentencia = "SELECT * FROM player WHERE nombre='"+nombre+"'";
					instruccion = this.conexion.createStatement();
					resultados = instruccion.executeQuery(sentencia);
					
					
					if(resultados.next()){
						j.setId(resultados.getInt("id"));
						j.setNombre(resultados.getString("nombre"));
						j.setApellido1(resultados.getString("apellido1"));
						j.setApellido2(resultados.getString("apellido2"));
						j.setEdad(resultados.getInt("edad"));
						j.setPuntuacion(resultados.getInt("puntuacion"));
												
					}
					else{
						System.out.println("Error recogiendo los datos del jugador"); 
					}
				}
				catch(SQLException exc){
					exc.printStackTrace();
				}
				finally{
					try{
						resultados.close();
						instruccion.close();
						conexion.close();
						System.out.println("\nConexion cerrada");
					}
					catch(SQLException exc){
						exc.printStackTrace();
					}
				}
			}
			public void actualizarPuntuacion(Jugador j, int puntuacion){
				try{
					instruccion = conexion.createStatement();
					sentencia = "UPDATE player SET puntuacion=" + puntuacion + " WHERE id=" + j.getId();
					instruccion.executeUpdate(sentencia);
					System.out.println("Nueva puntuación de" + j.getNombre());
				}
				catch(SQLException excepcionSQL){
					excepcionSQL.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error en la consulta");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					try{
						instruccion.close();
						conexion.close();
					}
					catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
	}
