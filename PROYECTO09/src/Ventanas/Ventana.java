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
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class Ventana extends JFrame {


	private JPanel contentPane;
	//identificadores
	
	final static String Juego = "Juego";
	final static String Perfil = "Perfil";
	
	Ventanas.Juego vJuego= new Juego();
	Ventanas.Perfil vPerfil= new Perfil();

	private Jugador jug1;

	

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
		vPerfil.setLayout(null);

	
	}

	
	public void setJugador(JUEGO.Jugador jug1) {
		this.jug1=jug1;

	}
	}

