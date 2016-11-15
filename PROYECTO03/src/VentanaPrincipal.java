import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JUEGO.Jugador;



public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
	
//Generar jugador
	
	Jugador player=new Jugador();
	player.setNombre("Saul");
	player.setApellidos("Marti Vila");
	player.setEdad(18);
	player.setId(68769);
	System.out.println(player.toString());
	
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
