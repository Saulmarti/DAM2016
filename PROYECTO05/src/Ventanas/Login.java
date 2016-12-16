package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import JUEGO.Jugador;
import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextArea;



public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextArea textArea;
	private JUEGO.Jugador j;
	//Genera un nuevo jugador
	Jugador Jugador=new Jugador();
	//Crea una etiqueta de referencia a un objeto tipo Login
	private Login referencia;
	//Permite acceso desde esta ventana a la ventana Juego
	private Juego vJuego;
	
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	
	public Login() {
		
		//Generar jugador
		
		Jugador player=new Jugador();
		player.setNombre("");
		player.setApellidos("");
		player.setEdad(999);
		player.setId(0);
		System.out.println(player.toString());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDelJugador = new JLabel("DATOS DEL JUGADOR");
		lblDatosDelJugador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDelJugador.setBounds(149, 11, 181, 14);
		contentPane.add(lblDatosDelJugador);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(19, 71, 89, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(19, 102, 89, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(19, 133, 89, 14);
		contentPane.add(lblEdad);

		
		txtNombre = new JTextField();
		txtNombre.setBounds(149, 68, 148, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		//LISTENER ESPERANDO EL INTRO
		txtNombre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//AL HACER INTRO SE RELLENA EL DATO DEL JUGADOR
				Jugador.setNombre(txtNombre.getText());
			}
		});
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(149, 99, 148, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		//LISTENER ESPERANDO EL INTRO
				txtApellidos.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						//AL HACER INTRO SE RELLENA EL DATO DEL JUGADOR
						Jugador.setApellidos(txtApellidos.getText());
					}
				});
		
		txtEdad = new JTextField();
		txtEdad.setBounds(149, 130, 148, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		//LISTENER ESPERANDO EL INTRO
				txtEdad.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						//COMPRUEBA QUE SEA NUMERICO
						if(Jugador.isNumeric(txtEdad.getText())==true)
							Jugador.setEdad(Integer.parseInt(txtEdad.getText()));
						else Jugador.setEdad(999);
					}
					
				});

		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setBounds(19, 205, 296, 45);
		contentPane.add(textArea);
		
		//	
		Jugador.setNombre(textArea.getText());
		Jugador.setApellidos(textArea.getText());
		
		
		JButton btnNewButton = new JButton("PLAY");
		btnNewButton.addActionListener(new ActionListener() {
		
			private JUEGO.Jugador j;
			public void actionPerformed(ActionEvent arg0) {
				j=new Jugador();
				j.setNombre(txtNombre.getText());
				
				if(Jugador.getEdad()==999)
					textArea.setText("EDAD NO CORRECTA, PON LA EDAD Y DALE A INTRO");
				else if(Jugador.sonEspacios(Jugador.getNombre()))
					textArea.setText("FALTA EL NOMBRE, PON EL NOMBRE Y DALE A INTRO");
				else if(Jugador.sonEspacios(Jugador.getApellidos()))
				textArea.setText("FALTAN APELLIDOS, PON LOS APELLIDOS Y DALE A INTRO");
				else
				textArea.setText("Nuevo jugador creado "+Jugador.getNombre()+" "+Jugador.getApellidos()+" de "+Jugador.getEdad()+" años" );
				
				
				vJuego.setJugador(j);
		
				vJuego.setVisible(true);
				
				setVisible(false);
			}
			
		});
		btnNewButton.setBounds(335, 206, 89, 23);
		contentPane.add(btnNewButton);
		vJuego=new Juego();
	
		
	}
}
