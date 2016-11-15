package JUEGO;

public class Jugador {
	
	private String Nombre;
	private String Apellidos;
	private int Edad;
	private int id;
	private int puntos=0;
	




	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellidos() {
		return Apellidos;
	}


	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}


	public int getEdad() {
		return Edad;
	}


	public void setEdad(int edad) {
		Edad = edad;
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
	
	
	
	public String toString()
	{ return this.Nombre+" "+this.Apellidos+" "   +this.Edad+ " Años, con Id "+this.id;	}

}
