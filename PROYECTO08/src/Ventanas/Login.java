package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.sql.Connection;

import JUEGO.ConexionDB;
import JUEGO.JugadorDB;

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
	private JButton btn_registro;
	//Crea una etiqueta de referencia a un objeto tipo Login
	private Login referencia;

	

	private ConexionDB db;
	private JugadorDB jdb;
	private Connection conexion;
	private boolean connected =false;

	
	public Login() {
		
		//Generar jugador
		
		setResizable(true);
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
		
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(149, 99, 148, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		
		txtEdad = new JTextField();
		txtEdad.setBounds(149, 130, 148, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		

		
		
		
		textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setBounds(10, 205, 296, 45);
		contentPane.add(textArea);
		
		//	

	

		
		btn_registro = new JButton("REGISTRO");
		Ventanas.Ventana vVentana;
		btn_registro.addActionListener(new miBotonRegistrar());
		btn_registro.setBounds(316, 206, 89, 23);
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
				private class miBotonRegistrar implements ActionListener {

					@Override
					public void actionPerformed(ActionEvent e) {

						
						//Insertamos nuevo usuario en la BBDD y después cerramos la conexión
						try{
							jdb.insertarJugador(txtNombre.getText(), txtApellidos.getText(), Integer.valueOf(txtEdad.getText()));
							Ventana Ventana=new Ventana();
							setVisible(false);
							Ventana.setVisible(true);
						}
						catch(Exception e1)
						{
							textArea.setText( " Debe haber algún problema con la BBDD o con la conexión.");
							
						}
						}
				}
	

	
				}
