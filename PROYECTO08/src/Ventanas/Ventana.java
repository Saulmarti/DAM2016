package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JUEGO.Jugador;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Ventana extends JFrame {


	private JPanel contentPane;
	//identificadores
	
	final static String Juego = "Juego";
	final static String Perfil = "Perfil";
	
	Ventanas.Juego vJuego= new Juego();
	Ventanas.Perfil vPerfil= new Perfil();
	private Jugador player;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1000,550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuVentanas = new JMenu("Ventanas");
		menuBar.add(menuVentanas);
		
		JMenuItem menuJuego = new JMenuItem("Juego");
		menuVentanas.add(menuJuego);
		
		menuJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane,  Juego);				
				
			}
			});
		
		JMenuItem menuPerfil = new JMenuItem("Perfil");
		menuVentanas.add(menuPerfil);
		
		menuPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane,  Perfil);

			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(vJuego, Juego);
		contentPane.add(vPerfil,Perfil);

	
	}

	
	public void setJugador(JUEGO.Jugador player) {
		this.player=player;
		vJuego.setJugador(player);
		vPerfil.setJugador(player);
	}
	}

