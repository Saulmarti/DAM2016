package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.sql.Connection;

import JUEGO.ConexionDB;
import JUEGO.Jugador;
import JUEGO.JugadorDB;


import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;



public class Login extends JFrame {
	private JPanel contentPane;
	private JLabel lblUsuarios;
	private JTextField nombreTxt;
	private JTextField apellido1Txt;
	private JTextField apellido2Txt;
	private JTextField edadTxt;
	private JTextArea textArea;
	private JButton btnBuscar;
	private JButton btnPlay;
	private JButton btn_registro;
	//Crea una etiqueta de referencia a un objeto tipo Login
	private Login referencia;
	private JComboBox comboBox;
	private int numero_de_items; //numero de elementos en el ComboBox

	
	//Objeto usuario, a nivel de clase para que sea visible a toda		
	
	private Jugador j = new Jugador();

	private ConexionDB db;
	private JugadorDB jdb;
	private Connection conexion;
	private boolean connected =false;

	
	public Login() {
		
		
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 600, 400);
		
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		
		JLabel lblDatosDelJugador = new JLabel("DATOS DEL JUGADOR");
		lblDatosDelJugador.setBounds(196, 11, 118, 14);
		lblDatosDelJugador.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblDatosDelJugador);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(43, 60, 121, 14);
		contentPane.add(lblNombre);
		
		nombreTxt = new JTextField();
		nombreTxt.setBounds(174, 57, 86, 20);
		contentPane.add(nombreTxt);
		nombreTxt.setColumns(10);
		
		
		JLabel lblApellido1 = new JLabel("PRIMER APELLIDO");
		lblApellido1.setBounds(287, 60, 158, 14);
		contentPane.add(lblApellido1);
		
		apellido1Txt = new JTextField();
		apellido1Txt.setBounds(406, 57, 86, 20);
		contentPane.add(apellido1Txt);
		apellido1Txt.setColumns(10);
		
		
		JLabel lblApellido2 = new JLabel("SEGUNDO APELLIDO");
		lblApellido2.setBounds(32, 91, 137, 14);
		contentPane.add(lblApellido2);
		
		apellido2Txt = new JTextField();
		apellido2Txt.setBounds(174, 88, 86, 20);
		contentPane.add(apellido2Txt);
		apellido2Txt.setColumns(10);
		
		
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(287, 94, 126, 14);
		contentPane.add(lblEdad);
	
		edadTxt = new JTextField();
		edadTxt.setBounds(406, 88, 86, 20);
		contentPane.add(edadTxt);
		edadTxt.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(96, 262, 317, 88);
		textArea.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(textArea);
		
		comboBox = new JComboBox();
		comboBox.setBounds(174, 145, 318, 20);
		//Listener sobre los items para permitir seleccionar el que queramos del Combo Box
		//Y rellenar los datos de la ventana
		comboBox.addActionListener(new miComboBox());
		//Al JPanel general se le añade un JPanel "campos" tipo GridLayout
			//para los campos: ComboBox, nombre, apellido1, apellido2, edad.
			
			
			
		lblUsuarios = new JLabel("Jugador");
		lblUsuarios.setBounds(43, 148, 74, 14);
		getContentPane().add(lblUsuarios);
		comboBox.setFocusable(true);
		comboBox.setFocusTraversalKeysEnabled(true);
		getContentPane().add(comboBox);
		
		//Botón para Buscar usuario por nombre y los encontrados los pondremos en el Combox
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(96, 220, 105, 23);
		btnBuscar.addActionListener(new miBotonBuscar());
		getContentPane().add(btnBuscar);
		
	
		btnPlay = new JButton("Play");
		btnPlay.setBounds(221, 220, 74, 23);
		getContentPane().add(btnPlay);
		btnPlay.addActionListener(new miBotonPlay() {
			public void actionPerformed(ActionEvent e) {
				miBotonPlay();
				
				btn_registro.setEnabled(false);

		
				
			}
			
			private void miBotonPlay() {
			
			Ventana vVentana=new Ventana();
			setVisible(false);
			vVentana.setVisible(true);
				
			}});
		btnPlay.setEnabled(false);
		
		//	

	

		
		btn_registro = new JButton("REGISTRO");
		btn_registro.setBounds(303, 220, 110, 23);
		Ventanas.Ventana vVentana;
		btn_registro.addActionListener(new miBotonRegistrar());
		contentPane.add(btn_registro);

		Conectar();
		
		}
		
		//Métodos de la Clase

				//Conectar con la base de datos
				private void Conectar(){
					//Conexión con la BBDD
					//Creamos nuestro objeto para el manejo de la base de datos
					try{
						db=new ConexionDB("localhost","players","root","");
						//Establecemos la conexion
						connected=db.connectDB();
						//Asignamos con el getter la conexion establecida
						conexion=db.getConexion();
						//Pasamos la conexión a un nuevo objeto UsuariosDB para insertar datos.
						jdb=new JugadorDB(conexion);
						
						if(connected==false) {
							textArea.setText("SIN EXITO EN LA CONEXION");
						}
						else textArea.setText("EXITO EN LA CONEXION");
						
						}
					catch(Exception e)
					{
						textArea.setText( " Debe haber algún problema con la BBDD o con la conexión.");	
					}
				}
				
				//Listener para el botón registrar
				//Listener para el boton Buscar
				private boolean ComprobarDatos()
				{   if (j==null)
				       {textArea.setText(" No hay datos que actualizar.");return false;}		
				    else if (!j.isNumeric(edadTxt.getText()))
						{textArea.setText("EDAD no correcta."); return false;}
					else if (j.sonEspacios(nombreTxt.getText()))
						{textArea.setText("Falta el nombre."); return false;}
					else if (j.sonEspacios(apellido1Txt.getText()))
						{textArea.setText("Falta el primer apellido."); return false;}
					else if (j.sonEspacios(apellido2Txt.getText()))
						{textArea.setText("Falta el segundo apellido apellido."); return false;}
					else{
					return true;}
				
				}
				private class miBotonRegistrar implements ActionListener {

					@Override
					public void actionPerformed(ActionEvent e) {

						
						//Insertamos nuevo usuario en la BBDD y después cerramos la conexión
						try{
							jdb.insertarJugador(nombreTxt.getText(), apellido1Txt.getText(), apellido2Txt.getText(), Integer.valueOf(edadTxt.getText()));
							textArea.setText( " Jugador registrado, dale al PLAY");
							btnPlay.setEnabled(true);
						}
						catch(Exception e1)
						{
							textArea.setText( " Debe haber algún problema con la BBDD o con la conexión.");
							
						}
						}
				}
				
				
				private class miBotonPlay implements ActionListener {

					private Jugador j;

					@Override
					public void actionPerformed(ActionEvent e) {
						
						try{
							
							Ventana vVentana=new Ventana();
							setVisible(false);
							vVentana.setVisible(true);
							this.j=j;
						}
						catch(Exception e1)
						{
							textArea.setText( " Debe haber algún problema con la BBDD o con la conexión.");

						}
						}
					
				}
				public void asignarPropiedades(){
					j.setNombre(nombreTxt.getText());
					j.setApellido1(apellido1Txt.getText());
					j.setApellido2(apellido2Txt.getText());
					j.setEdad(Integer.valueOf(edadTxt.getText()));

				}
				
				private class miBotonBuscar implements ActionListener {

					@Override
					public void actionPerformed(ActionEvent e) {
						//Vaciamos el ComboBox
						comboBox.removeAllItems(); //Vaciamos los Items anteriores del ComboBox
						apellido1Txt.setText("");
						apellido2Txt.setText("");
						edadTxt.setText("");
						//Conectamos con la BBDD
						Conectar();
						//Buscamos el usuario por el nombre y las coincidencias van a un ComboBox
						jdb.buscarJugador(nombreTxt.getText(),comboBox);
						btnPlay.setEnabled(true);
						numero_de_items=comboBox.getItemCount(); //Número de ítems en el ComboBox
						//Sirve para el caso en que el nombre buscado no esté en la lista
						if (numero_de_items==0){
						apellido1Txt.setText("Usuario no encontrado");
						apellido2Txt.setText("Usuario no encontrado");
						edadTxt.setText("Usuario no encontrado");
						textArea.setText(" Lo siento no estás registrado o no has introducido un nombre.\n Puedes volver a buscar con otro nombre.");
						}		
						}
				}
				private class miComboBox implements ActionListener {
					@Override
					   public void actionPerformed(ActionEvent e) {
							//Por defecto mostrará en pantalla la primera coincidencia con el
							//nombre encontrado en la BBDD
							//Seleccionando sobre el desplegable del JComboBox se podrá cambiar si hay varias coincidencias
							
							j=(Jugador)comboBox.getSelectedItem();
							
							if (j!=null) //Si la lista del combox no está vacía
							{
							nombreTxt.setText(j.getNombre());
							apellido1Txt.setText(j.getApellido1());	
							apellido2Txt.setText(j.getApellido2());
							edadTxt.setText(String.valueOf(j.getEdad()));
							textArea.setText(" Si el usuario mostrado no eres tu, mira la lista de usuarios.\n Puedes modificar y actualizar tus datos o buscarte con otro nombre.");
							//Comprobacion
							System.out.println("El usuario seleccionado es: "+j.toString());}
							
						}

					}
			
				}
