package Principal;
import Ventanas.Juego;
import Ventanas.Login;
import JUEGO.Jugador;

public class VentanaPrincipal {
	
	public static void main (String[] args) {
		
		//Ventana del juego
		Juego vJuego=new Juego();
		
		//Ventana de login
		
		Login Login=new Login();
		Login.setVisible(true);
	}
}