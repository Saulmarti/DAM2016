package Ventanas;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import JUEGO.Jugador;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

public class Perfil extends JPanel {
	
	private Jugador jugador;
	

	private JPanel panelDatos = new JPanel();
	private Perfil referencia;
	

	private JLabel etiquetaNombre;
	private JLabel etiquetaApellidos;
	private JLabel etiquetaEdad;
	private JTextField cajaNombre;
	private JTextField cajaApellidos;
	private JTextField cajaEdad;
	private JButton botonActualizar;
	
	
	private JTextField cajaInfo;
	private JLabel etiquetaPuntuacion;
	
	

	public Perfil() {
		setBackground(Color.WHITE);
	
		referencia = this;
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_panelDatos = new GridBagConstraints();
		gbc_panelDatos.insets = new Insets(0, 0, 0, 15);
		gbc_panelDatos.weightx = 0.65;
		gbc_panelDatos.fill = GridBagConstraints.BOTH;
		gbc_panelDatos.gridx=1;															//Comenzará desde fila 0 y columna 0
		gbc_panelDatos.gridy=0;
		gbc_panelDatos.gridwidth=1;														//Ocupará 2 filas y 2 columnas
		gbc_panelDatos.gridheight=1;
		panelDatos.setBackground(Color.WHITE);
		add(panelDatos, gbc_panelDatos);
		
		GridBagConstraints gbc_panelImagen = new GridBagConstraints();
		gbc_panelImagen.insets = new Insets(0, 0, 20, 0);
		gbc_panelImagen.weightx = 0.35;
		gbc_panelImagen.fill = GridBagConstraints.BOTH;
		gbc_panelImagen.gridx=0;															//Comenzará desde fila 0 y columna 0
		gbc_panelImagen.gridy=0;
		gbc_panelImagen.gridwidth=1;														//Ocupará 2 filas y 2 columnas
		gbc_panelImagen.gridheight=1;
	
		
		cajaInfo = new JTextField();
		cajaInfo.setBackground(Color.WHITE);
		cajaInfo.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		cajaInfo.setHorizontalAlignment(SwingConstants.CENTER);
		cajaInfo.setEditable(false);
		GridBagConstraints gbc_cajaInfo = new GridBagConstraints();
		gbc_cajaInfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cajaInfo.gridwidth = 1;
		gbc_cajaInfo.gridx=1;
		gbc_cajaInfo.gridy=1;
		add(cajaInfo, gbc_cajaInfo);
		
		etiquetaPuntuacion = new JLabel();
		etiquetaPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_etiquetaPuntuacion = new GridBagConstraints();
		gbc_etiquetaPuntuacion.gridwidth = 1;
		gbc_etiquetaPuntuacion.gridx=0;
		gbc_etiquetaPuntuacion.gridy=1;
		add(etiquetaPuntuacion, gbc_etiquetaPuntuacion);
		
		
		
		GridBagLayout gridBagLayout3 = new GridBagLayout();
		gridBagLayout3.columnWidths = new int[]{0};
		gridBagLayout3.rowHeights = new int[]{0};
		gridBagLayout3.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout3.rowWeights = new double[]{Double.MIN_VALUE};
		panelDatos.setLayout(gridBagLayout3);
		

		etiquetaNombre = new JLabel();
		etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNombre.setText("Nombre");
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.weighty = 0.09;
		gbc_etiquetaNombre.anchor = GridBagConstraints.WEST;
		gbc_etiquetaNombre.gridx=0;															//Comenzará desde fila 0 y columna 0
		gbc_etiquetaNombre.gridy=0;
		panelDatos.add(etiquetaNombre, gbc_etiquetaNombre);
		

		etiquetaApellidos = new JLabel();
		etiquetaApellidos.setText("Primer apellido");
		GridBagConstraints gbc_etiquetaApellido1 = new GridBagConstraints();
		gbc_etiquetaApellido1.weighty = 0.09;
		gbc_etiquetaApellido1.anchor = GridBagConstraints.NORTHWEST;
		gbc_etiquetaApellido1.gridx=0;															//Comenzará desde fila 0 y columna 0
		gbc_etiquetaApellido1.gridy=2;
		panelDatos.add(etiquetaApellidos, gbc_etiquetaApellido1);


		etiquetaEdad = new JLabel();
		etiquetaEdad.setText("Edad");
		GridBagConstraints gbc_etiquetaEdad = new GridBagConstraints();
		gbc_etiquetaEdad.weighty = 0.09;
		gbc_etiquetaEdad.anchor = GridBagConstraints.WEST;
		gbc_etiquetaEdad.gridx=0;															//Comenzará desde fila 0 y columna 0
		gbc_etiquetaEdad.gridy=6;
		panelDatos.add(etiquetaEdad, gbc_etiquetaEdad);
		

		cajaNombre = new JTextField();
		cajaNombre.setName("Nombre");
		GridBagConstraints gbc_cajaNombre = new GridBagConstraints();
		gbc_cajaNombre.weighty = 0.09;
		gbc_cajaNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_cajaNombre.gridx=0;															//Comenzará desde fila 0 y columna 0
		gbc_cajaNombre.gridy=1;
		panelDatos.add(cajaNombre, gbc_cajaNombre);

		cajaApellidos = new JTextField();
		cajaApellidos.setName("Apellido 1");
		GridBagConstraints gbc_cajaApellido1 = new GridBagConstraints();
		gbc_cajaApellido1.weighty = 0.09;
		gbc_cajaApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_cajaApellido1.gridx=0;															//Comenzará desde fila 0 y columna 0
		gbc_cajaApellido1.gridy=3;
		panelDatos.add(cajaApellidos, gbc_cajaApellido1);


		cajaEdad = new JTextField();
		cajaEdad.setName("Edad");
		GridBagConstraints gbc_cajaEdad = new GridBagConstraints();
		gbc_cajaEdad.weighty = 0.09;
		gbc_cajaEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cajaEdad.gridx=0;																//Comenzará desde fila 0 y columna 0
		gbc_cajaEdad.gridy=7;
		panelDatos.add(cajaEdad, gbc_cajaEdad);
		
		
		

		botonActualizar = new JButton();
		botonActualizar.setBackground(new Color(204, 255, 255));
		botonActualizar.setName("Actualizar");
		botonActualizar.setText("Actualizar");
		botonActualizar.setEnabled(false);
		if(!botonActualizar.isEnabled()){
			botonActualizar.setToolTipText("Debes actualizar algún campo de tu perfil");
		}
		GridBagConstraints gbc_botonActualizar = new GridBagConstraints();
		gbc_botonActualizar.insets = new Insets(10, 0, 0, 0);
		gbc_botonActualizar.gridx=0;														//Comenzará desde fila 0 y columna 0
		gbc_botonActualizar.gridy=10;
		panelDatos.add(botonActualizar, gbc_botonActualizar);
		
		//Añadiendo listeners
		cajaNombre.addActionListener(new ListenerCajasTexto());
		cajaApellidos.addActionListener(new ListenerCajasTexto());
		cajaEdad.addActionListener(new ListenerCajaEdad());
		botonActualizar.addActionListener(new ListenerBotonActualizar());
	
		
		
		GridBagLayout gridBagLayout2 = new GridBagLayout();
		gridBagLayout2.columnWidths = new int[]{0};
		gridBagLayout2.rowHeights = new int[]{0};
		gridBagLayout2.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout2.rowWeights = new double[]{Double.MIN_VALUE};

		
		
	}
	

	
	//Método para importar el jugador desde otra ventana
	public void setJugador_Perfil(Jugador jugador){
		this.jugador=jugador;
	}
	
	
	
	


	//Método para mostrar los datos del jugador
	public void mostrarDatos(){
		cajaNombre.setText(jugador.getNombre());
		cajaApellidos.setText(jugador.getApellidos());
		cajaEdad.setText(String.valueOf(jugador.getEdad()));
	
	}
	
	//Método para actualizar las propiedades del jugador
	public void actualizarPropiedades(Jugador jug){
		jug.setNombre(cajaNombre.getText());
		jug.setApellidos(cajaApellidos.getText());
		jug.setEdad(Integer.valueOf(cajaEdad.getText()));
		cajaInfo.setText("Perfil actualizado");
	}
	
	
	
	public void limpiarCajaInfo(){
		cajaInfo.setText("");
	}
	
	
	
	
	
	class ListenerCajasTexto implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent c) {
			JTextField caja = (JTextField)c.getSource();
			//Realizamos las comprobaciones
			if (caja.getText().length()==0){															//Si está en blanco
				cajaInfo.setText("Datos no válidos");										//Mostramos mensaje de error
			}
			else if (caja.getText().matches("\\d*")){													//Si es un numero
				cajaInfo.setText("Datos no válidos");									//Mostramos mensaje de error
			}
			else if (!caja.getText().matches("\\w*")){													//Si son espacios en blanco
				cajaInfo.setText("Datos no válidos"); 										//Mostramos mensaje de error
			}
			else{
				cajaInfo.setText("");																	//Limpiamos la caja del resultado
				botonActualizar.setEnabled(true);
				if(caja.getName().equals("Nombre")){	
					cajaApellidos.requestFocus();
				}
			
				else if(caja.getName().equals("Apellido 2")){
					cajaEdad.requestFocus();
				}
				else if(caja.getName().equals("Apodo")){
					//cajaInfo.setText("Ya puedes actualizar tus datos");
				}
			}
		}
	}
	
	class ListenerCajaEdad implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(cajaEdad.getText().matches("\\d*")){
				cajaInfo.setText("");
			}
			else{
				cajaInfo.setText("Datos no válidos");
			}
		}
	}
	
	class ListenerBotonActualizar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			actualizarPropiedades(jugador);
			botonActualizar.setEnabled(false);
		}
	}
}
