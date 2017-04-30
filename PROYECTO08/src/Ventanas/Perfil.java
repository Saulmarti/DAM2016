package Ventanas;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import JUEGO.Jugador;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Component;

public class Perfil extends JPanel {
	
	private Jugador player;
	private Perfil referencia;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextArea textArea;
	private JLabel lblNombre;
	public Perfil() {
		referencia = this;
		setLayout(null);
		
		JLabel lblDatosDelJugador = new JLabel("DATOS DEL JUGADOR");
		lblDatosDelJugador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDelJugador.setBounds(149, 11, 181, 14);
		add(lblDatosDelJugador);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(19, 71, 89, 14);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(19, 102, 89, 14);
		add(lblApellidos);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(19, 133, 89, 14);
		add(lblEdad);

		
		txtNombre = new JTextField();
		txtNombre.setBounds(149, 68, 148, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		//LISTENER ESPERANDO EL INTRO
		txtNombre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//AL HACER INTRO SE RELLENA EL DATO DEL JUGADOR
				player.setNombre(txtNombre.getText());
			}
		});
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(149, 99, 148, 20);
		add(txtApellidos);
		txtApellidos.setColumns(10);
		//LISTENER ESPERANDO EL INTRO
				txtApellidos.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						//AL HACER INTRO SE RELLENA EL DATO DEL JUGADOR
						player.setApellidos(txtApellidos.getText());
					}
				});
		
		txtEdad = new JTextField();
		txtEdad.setBounds(149, 130, 148, 20);
		add(txtEdad);
		txtEdad.setColumns(10);
		//LISTENER ESPERANDO EL INTRO
				txtEdad.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						//COMPRUEBA QUE SEA NUMERICO
						if(player.isNumeric(txtEdad.getText())==true)
							player.setEdad(Integer.parseInt(txtEdad.getText()));
						else player.setEdad(999);
					}
					
				});

		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setBounds(19, 205, 296, 45);
		add(textArea);
		
		//	

	
		JButton btnNewButton = new JButton("Actualizar");

		btnNewButton.addActionListener(new ActionListener() {
		
		
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(player.getEdad()==999)
					textArea.setText("EDAD NO CORRECTA, PON LA EDAD Y DALE A INTRO");
				else if(player.sonEspacios(player.getNombre()))
					textArea.setText("FALTA EL NOMBRE, PON EL NOMBRE Y DALE A INTRO");
				else if(player.sonEspacios(player.getApellidos()))
				textArea.setText("FALTAN APELLIDOS, PON LOS APELLIDOS Y DALE A INTRO");
				else{
				textArea.setText("Jugador actualizado "+player.getNombre()+" "+player.getApellidos()+" de "+player.getEdad()+" años" );
				
				}
			}
			
		});
		btnNewButton.setBounds(335, 206, 89, 23);
		add(btnNewButton);
			}
	//Método para importar el jugador desde otra ventana
			public void setJugador(Jugador player){
				this.player=player;
				txtNombre.setText(player.getNombre());
				txtApellidos.setText(player.getNombre());
				txtEdad.setText(player.getNombre());
			}

			
			
	}

	