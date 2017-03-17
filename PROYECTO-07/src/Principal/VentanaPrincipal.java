package Principal;
import Ventanas.Juego;
import Ventanas.Login;
import Ventanas.Perfil;
import JUEGO.Jugador;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	
	private JPanel contentPane;															
	
	private Jugador jugador;
	
	private final static String JUEGO="Ventana de juego";
	private final static String PERFIL="Modificar perfil";
	
	//Generamos las ventanas
	
	private Juego vJuego = new Juego();
	private Perfil vPerfil = new Perfil();
	
	
	
	//Componentes menú
	private JMenuBar barraMenu;
	private JMenu menuVentanas;
	private JMenuItem menuPerfil;
	private JMenuItem menuJuego;
	

	public VentanaPrincipal() {
		
		
		
		setPreferredSize(new Dimension(600, 420));								//Tamaño predeterminado del Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 411);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));							//CARDLAYOUT
		vJuego.setBackground(Color.WHITE);
				
				
				
		


		contentPane.add(vJuego, JUEGO);
	
		contentPane.add(vPerfil, PERFIL);
		
		
		barraMenu = new JMenuBar();
		barraMenu.setForeground(new Color(255, 255, 255));
		barraMenu.setBackground(new Color(153, 153, 153));
		setJMenuBar(barraMenu);
		
		menuVentanas = new JMenu("Ventanas");
		barraMenu.add(menuVentanas);
		
		
	
		menuPerfil = new JMenuItem("Editar perfil");
		menuPerfil.setName("Perfil");
		menuVentanas.add(menuPerfil);
	
		menuJuego = new JMenuItem("Jugar");
		menuJuego.setName("Juego");
		menuVentanas.add(menuJuego);
		
		
		menuPerfil.addActionListener(new ListenerMenuItems());
		menuJuego.addActionListener(new ListenerMenuItems());
		
		
		
		
		
	}
	

	public void setJugador_ventanaPrincipal(Jugador jugador){
		this.jugador = jugador;
	}
	
	public void lanzarJuego(){
		CardLayout c1 = (CardLayout)(contentPane.getLayout());
		c1.show(contentPane, JUEGO);	
		vJuego.setJugador(jugador); 								
		setBounds(100, 100, 525, 394);
	}
	
	
	
	
	public void lanzarPerfil(){
		CardLayout c1 = (CardLayout)(contentPane.getLayout());
		c1.show(contentPane, PERFIL);
		vPerfil.setJugador_Perfil(jugador);										//Pasamos el jugador allí para poder acceder a él
		vPerfil.mostrarDatos();
		vPerfil.limpiarCajaInfo();
	}
	
	

class ListenerMenuItems implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem item = (JMenuItem)arg0.getSource(); 									//Comprobamos en que item hemos hecho click
		if(item.getName().equals("Jugar")){
			lanzarJuego();	
	
		}
		else if(item.getName().equals("Perfil")){
			lanzarPerfil();
	
		}
	
		
	}
	
}
			
public static void main (String[] args) {
	
	
	//Ventana del juego
		Juego vJuego= new Juego();

	//Ventana de login
	
	Login Login=new Login(vJuego);
	Login.setVisible(true);
	
}
}
			
			
		
		
	

