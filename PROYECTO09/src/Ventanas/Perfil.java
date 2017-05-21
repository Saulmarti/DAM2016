package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.border.LineBorder;

import JUEGO.ConexionDB;
import JUEGO.Jugador;
import JUEGO.JugadorDB;

import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.Insets;
import java.awt.Font;

/*Clase que busca por el nombre todos los usuarios que aparecen
 * en una BBDD con dicho nombre, los muestra en un JComboBox y permite elegir
 * en caso de que haya varios casos y actualizar los datos
 */
public class Perfil extends JPanel {

	
	    //Contenedor Principal 
		private JPanel contentPane;
		
		//Contenedores secundarios
		private JPanel campos;
		private JPanel panel;
		
		//Campos de registro, botones y áreas de texto
		private JLabel lblUsuarios;
		private JTextField nombreTxt;
		private JTextField apellido1Txt;
		private JTextField apellido2Txt;
		private JTextField edadTxt;
		private JLabel lblNombre;
		private JLabel lblApellido1;
		private JLabel lblApellido2;
		private JLabel lblEdad;
		private JButton btnBuscar;
		private JButton btnActualizar;
		private JTextArea textMensajes;
		

		//Manejadores de la base de datos
		private ConexionDB db;
		private JugadorDB jdb;
		private Connection conexion; //Conexión
		private boolean connected =false; //Conexión con éxito
		
		//JCOmbobox de usuarios
		private JComboBox comboBox;
		private int numero_de_items; //numero de elementos en el ComboBox

		
		//Objeto usuario, a nivel de clase para que sea visible a toda		
		private Jugador j;
		private JPanel panel_1;
		private JLabel label;
		private JLabel label_1;
		private JLabel label_2;
		private JLabel label_3;
		private JLabel label_4;
		private JLabel label_5;
		private JLabel label_6;
		private JLabel label_7;
		private JLabel label_8;
		private JLabel label_9;
		private JLabel label_10;
		private JLabel label_11;
		private JLabel label_12;
		private JLabel label_13;
		private JLabel label_14;
		private JLabel lblPerfil;

		/**
		 * Create the frame.
		 */
		public Perfil() {


			
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 539, 334);
			contentPane = this;
			//El JPanel General del JFRAME es un BorderLayout
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));

			
			
			setBounds(50, 50, 1000, 530);
			contentPane = this;
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			 contentPane.setLayout(null);
				setLayout(null);
				//Al JPanel general se le añade un JPanel "campos" tipo GridLayout
				//para los campos: ComboBox, nombre, apellido1, apellido2, edad.
				
				campos = new JPanel();
				campos.setBounds(188, 155, 196, 203);
				contentPane.add(campos);
								campos.setLayout(new BoxLayout(campos, BoxLayout.PAGE_AXIS));
							
							
							lblNombre = new JLabel("Nombre");
							campos.add(lblNombre);
							
							label = new JLabel("");
							campos.add(label);
							
							nombreTxt = new JTextField();
							nombreTxt.setColumns(10);
							campos.add(nombreTxt);
							
							label_1 = new JLabel("");
							campos.add(label_1);
							
							lblApellido1 = new JLabel("Primer apellido");
							campos.add(lblApellido1);
							
							label_2 = new JLabel("");
							campos.add(label_2);
							
							apellido2Txt = new JTextField();
							apellido2Txt.setColumns(10);
							campos.add(apellido2Txt);
							
							label_3 = new JLabel("");
							campos.add(label_3);
							
							label_4 = new JLabel("");
							campos.add(label_4);
							
							
							lblEdad = new JLabel("Edad");
							campos.add(lblEdad);
							
							edadTxt = new JTextField();
							edadTxt.setColumns(10);
							campos.add(edadTxt);
							
							label_5 = new JLabel("");
							campos.add(label_5);
							
							label_6 = new JLabel("");
							campos.add(label_6);
							
							lblApellido2 = new JLabel("Segundo apellido");
							campos.add(lblApellido2);
							
							label_7 = new JLabel("");
							campos.add(label_7);
							
							label_8 = new JLabel("");
							campos.add(label_8);
							
							label_9 = new JLabel("");
							campos.add(label_9);
							
							apellido1Txt = new JTextField();
							campos.add(apellido1Txt);
							apellido1Txt.setColumns(10);
							//Al JPanel general se le añade un JPanel "campos" tipo GridLayout
								//para los campos: ComboBox, nombre, apellido1, apellido2, edad.
								
								
								
								lblUsuarios = new JLabel("Jugador");
								campos.add(lblUsuarios);
							
							//Añadimos un JComboBox al lado del label usuarios para mostrar el resultado
							//de la búsqueda sobre la base de datos
							comboBox = new JComboBox();
							//Listener sobre los items para permitir seleccionar el que queramos del Combo Box
							//Y rellenar los datos de la ventana
							comboBox.addActionListener(new miComboBox());
							comboBox.setFocusable(true);
							comboBox.setFocusTraversalKeysEnabled(true);
							campos.add(comboBox);
							
							label_10 = new JLabel("");
							campos.add(label_10);
							
							label_11 = new JLabel("");
							campos.add(label_11);
							
							label_12 = new JLabel("");
							campos.add(label_12);
							
							label_13 = new JLabel("");
							campos.add(label_13);
			
			panel_1 = new JPanel();
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0};
			gbl_panel_1.rowHeights = new int[]{0};
			gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
				

			
			//Al JPanel Principal añadimos otro Panel para los botones y una area de texto de información
			
			panel = new JPanel();
			panel.setBounds(392, 155, 522, 106);
			contentPane.add(panel);
			
			//Botón para Buscar usuario por nombre y los encontrados los pondremos en el Combox
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new miBotonBuscar());
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(btnBuscar);
			
			//Botón para actualizar los datos de un jugador
			btnActualizar = new JButton("Actualizar");
			panel.add(btnActualizar);
			btnActualizar.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnActualizar.addActionListener(new miBotonActualizar());
			
			//Area para mensajes
			textMensajes = new JTextArea();
			textMensajes.setTabSize(5);
			textMensajes.setRows(3);
			textMensajes.setEditable(false);
			textMensajes.setBorder(new LineBorder(Color.RED));
			textMensajes.setWrapStyleWord(true);
			textMensajes.setText("Pon tu nombre y búscate en la BBDD de usuarios.");
			panel.add(textMensajes);
			
			label_14 = new JLabel("");
			panel.add(label_14);
			
			lblPerfil = new JLabel("PERFIL");
			lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblPerfil.setBounds(479, 87, 126, 57);
			add(lblPerfil);

			

	}
		private void setDefaultCloseOperation(int exitOnClose) {
			// TODO Auto-generated method stub
			
		}
		private void setResizable(boolean b) {
			// TODO Auto-generated method stub
			
		}
		private void setContentPane(JPanel contentPane2) {
			// TODO Auto-generated method stub
			
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
				jdb=new JugadorDB(conexion);}
			catch(Exception e)
			{
				textMensajes.setText( " Debe haber algún problema con la BBDD o con la conexión.");	
			}
		}
		public void mostrarDatos(){
			nombreTxt.setText(j.getNombre());
			apellido1Txt.setText(j.getApellido1());
			apellido2Txt.setText(j.getApellido2());
			edadTxt.setText(String.valueOf(j.getEdad()));

		}
		//Método para comprobar los datos del usuario si se modifican
		private boolean ComprobarDatos()
		{   if (j==null)
		       {textMensajes.setText(" No hay datos que actualizar.");return false;}		
		    else if (!j.isNumeric(edadTxt.getText()))
				{textMensajes.setText("EDAD no correcta."); return false;}
			else if (j.sonEspacios(nombreTxt.getText()))
				{textMensajes.setText("Falta el nombre."); return false;}
			else if (j.sonEspacios(apellido1Txt.getText()))
				{textMensajes.setText("Falta el primer apellido."); return false;}
			else if (j.sonEspacios(apellido2Txt.getText()))
				{textMensajes.setText("Falta el segundo apellido apellido."); return false;}
			else{
			return true;}
		
		}
		
		
		//Inner Clases para los diferentes listeners
		
		//Listener para el ComboBox
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
				textMensajes.setText(" Si el usuario mostrado no eres tu, mira la lista de usuarios.\n Puedes modificar y actualizar tus datos o buscarte con otro nombre.");
				//Comprobacion
				System.out.println("El usuario seleccionado es: "+j.toString());}
				
			}

		}
		
		//Listener para el boton Buscar
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
				
				numero_de_items=comboBox.getItemCount(); //Número de ítems en el ComboBox
				//Sirve para el caso en que el nombre buscado no esté en la lista
				if (numero_de_items==0){
				apellido1Txt.setText("Usuario no encontrado");
				apellido2Txt.setText("Usuario no encontrado");
				edadTxt.setText("Usuario no encontrado");
				textMensajes.setText(" Lo siento no estás registrado o no has introducido un nombre.\n Puedes volver a buscar con otro nombre.");
				}		
				}
		}
		
		//Listener para el boton Actualizar
		private class miBotonActualizar implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				    //Antes de realizar la consulta a la base de datos debemos actualizar el objeto usuario
				    //Si los datos modificados son correctos
					
				if (ComprobarDatos())	
					{j.setNombre(nombreTxt.getText());
					j.setApellido1(apellido1Txt.getText());
					j.setApellido2(apellido2Txt.getText());
					j.setEdad(Integer.valueOf(edadTxt.getText()));
					//Conectamos y actualizamos usuario
					Conectar();
					//udb.actualizarUsuario(u);
					jdb.actualizarJugadorPreparada(j);
					//Comprobacion
					textMensajes.setText("Tu usuario se ha actualizado como: "+j.toString()+"\n Puedes hacer una nueva búsqueda");
					System.out.println("El usuario se ha actualizado a: "+j.toString());
					//Vaciamos el ComboBox u los campos de texto
					comboBox.removeAllItems();
					nombreTxt.setText("");
					apellido1Txt.setText("");
					apellido2Txt.setText("");
					edadTxt.setText("");

			        }
				}
			}
	}



