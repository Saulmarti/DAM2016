package JUEGO;

public class Jugador {
	
	private String nombre="";
	private String apellidos="";
	private int edad=0;
	private int id;
	private int puntos=0;
	



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Jugador() {
		
	}
	//PARA COMPROBAR SI ES UN NÚMERO
	
	public  boolean isNumeric(String cadena){
		try {Integer.parseInt(cadena);
		return true;
		}catch (NumberFormatException nfe) {
			return false;
		}
		}
		
	
	//PARA COMPROBAR SI HAY UNA CADENA DE ESPACIOS
	
	public boolean sonEspacios(String cad)
	{
		for(int i =0; i<cad.length(); i++)
			if(cad.charAt(i) != ' ')
				return false;
				
				return true;
			}
				
	
	
	public String toString()
	{ return this.nombre+" "+this.apellidos+" "   +this.edad+ " años ";	}

}
