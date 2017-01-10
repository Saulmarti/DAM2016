package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JUEGO.Jugador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Juego extends JFrame {

	private JPanel contentPane;

	//Array de los dados
	private ImageIcon[] dados3=new ImageIcon[3];
	private ImageIcon[] dados6=new ImageIcon[6];
	private ImageIcon[] dados12=new ImageIcon[12];
	private ImageIcon dadogris;
	private Random dado=new Random(); //variable para crear la aleatoriedad de los dados
	
	//Almacena los numeros aleatorios para poder realizar el calculo
	private int[] numerodados3=new int[3];
	private int[] numerodados6=new int[6];
	private int numerodados12;
	
	//Almacena el Jugador
	private Jugador jugador;
	JLabel nombrejugador;
	JLabel puntuacion;
	
	//Imágenes
	private JLabel dado1,dado2,dado3;
	private JLabel dado4,dado5;
	private JLabel dado6;
	
	//Botones de suma, resta y ejecución
	private JButton suma,resta,mathdice;
	//Resultado
	private JTextField resultado;
	
	//variables del juego
	private boolean tocanumero=true;
	private int operacion=0;
	private int numerosintroducidos=0;
	private boolean sumar=true;
	
	//Muestra de resultados
	private JLabel resultadook;
	private JLabel resultadolbl;
	//Botón repetir
	private JButton repetir;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Juego() {
		setResizable(false);
		//Panel principal
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		//Configuración de los dados
		
		 dado1 = new JLabel("");
		 dado1.setBounds(20, 10,150, 150);
		 contentPane.add(dado1);
		
		
		 dado2 = new JLabel("");
		 dado2.setBounds(190, 10, 150, 150);
		 contentPane.add(dado2);
			
			
		 dado3= new JLabel("");
		 dado3.setBounds(357, 10, 150, 150);
		 contentPane.add(dado3);
		
			
		 dado4 = new JLabel("");
		 dado4.setBounds(20, 171, 150, 150);
		 contentPane.add(dado4);
		
		 dado5 = new JLabel("");
		 dado5.setBounds(190, 171, 150, 150);
		 contentPane.add(dado5);
		
		 dado6 = new JLabel("");
		 dado6.setBounds(20, 325, 226, 170);
		 contentPane.add(dado6);
		 
		
		
		//Boton de suma
		suma = new JButton("+");
		suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tocanumero){resultado.setText(resultado.getText()+"+");
				tocanumero=true;
				sumar=true;
				}
			}
		});
		suma.setBounds(547, 189, 89, 23);
		contentPane.add(suma);

		
		//Boton de resta
		resta = new JButton("-");
		resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tocanumero){resultado.setText(resultado.getText()+"-");
				tocanumero=true;
				sumar=false;
				}
				
			}
		});
		resta.setBounds(761, 189, 89, 23);
		contentPane.add(resta);
		
		//Bienvenida
				nombrejugador = new JLabel("BIENVENIDO");
				nombrejugador.setHorizontalAlignment(SwingConstants.CENTER);
				nombrejugador.setFont(new Font("Segoe UI Historic", Font.BOLD, 15));
				nombrejugador.setBounds(496, 75, 406, 85);
				contentPane.add(nombrejugador);
		
		
		//Caja de resultados
		
				resultado = new JTextField();
				resultado.setEditable(false);
				resultado.setBounds(547, 223, 303, 20);
				contentPane.add(resultado);
				resultado.setColumns(10);
		
		//Boton de resultado
		
		mathdice = new JButton("MATHDICE");
		mathdice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numerosintroducidos>1){ resultadolbl.setText("Tu operación es "+String.valueOf(operacion));
				repetir.setEnabled(true);
				if((numerodados12+1)==operacion){
			resultadook.setText("Correcto"); //Resultado correcto
			
			//Desactivamos el boton para no aumentar puntos indefinidamente
			mathdice.setEnabled(false);
			jugador.setPuntos(jugador.getPuntos()+5);
			puntuacion.setText("Tu puntuación es "+jugador.getPuntos());
			
			}else{resultadook.setText("Inténtalo de nuevo");
			//Desactivar boton para forzar repetir
			mathdice.setEnabled(false);
			}
		
		}
			
		}
		});
		mathdice.setBounds(547, 264, 303, 23);
		contentPane.add(mathdice);	

		
		
		
	
		//Boton de repetir
		repetir = new JButton("REPETIR");
		repetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarBotones();
				//Al apretar reactivamos boton mathdice
				mathdice.setEnabled(true);
				repetir.setEnabled(false);
				
				
				
			}});
		repetir.setEnabled(false);
		repetir.setBounds(547, 298, 303, 23);
		contentPane.add(repetir);
		
		
		
		//Caja de puntuación
		puntuacion = new JLabel("Tu puntuacion es: 0");
		puntuacion.setBounds(646, 183, 121, 35);
		contentPane.add(puntuacion);
		
		//Cajas de resultados
		resultadolbl = new JLabel("");
		resultadolbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultadolbl.setBounds(547, 376, 303, 23);
		contentPane.add(resultadolbl);
		
		//Caja de resultado correcto
		resultadook = new JLabel("");
		resultadook.setHorizontalAlignment(SwingConstants.CENTER);
		resultadook.setBounds(547, 332, 303, 43);
		contentPane.add(resultadook);
		
		
		inicializarBotones();
	
	}
	
	//Setter para pasar a este JPANEL los datos de jugador 
	public void setJugador(Jugador jugador){
		this.jugador=jugador;
		nombrejugador.setText("Bienvenido al juego "+jugador.getNombre());
		puntuacion.setText("Tu puntuación es: "+jugador.getPuntos());
		
	}
	//Operaciones aritmeticas
	
	private void setOperacion(int num){
		numerosintroducidos++;
		if(numerosintroducidos>1){
			if(sumar) operacion=operacion+num;
			else operacion=operacion-num;
		}else{operacion=num;
		}
		
	}
	private void inicializarBotones() {
		//Cargamos las imagenes en los array
		for(int i=0;i<dados3.length;i++){
			dados3[i]=new ImageIcon(getClass().getResource("imagenes/dado"+String.valueOf(i+1)+"_3.png"));
		}
		for(int i=0;i<dados6.length;i++){
			dados6[i]=new ImageIcon(getClass().getResource("imagenes/dado"+String.valueOf(i+1)+"_6.png"));
		}
		for(int i=0;i<dados12.length;i++){
			dados12[i]=new ImageIcon(getClass().getResource("imagenes/dadodoce_"+String.valueOf(i+1)+".png"));
		}
		dadogris=new ImageIcon(getClass().getResource("imagenes/dadogris.png"));
	
	
	//Los dados de 3 caras
	
	for(int i=0;i<numerodados3.length;i++) numerodados3[i]=dado.nextInt(3); //Numero aleatorio
			
			//Imagen dentro de los JLabel
			dado1.setIcon(dados3[numerodados3[0]]);
			dado1.setName("1");
			dado2.setIcon(dados3[numerodados3[1]]);
			dado2.setName("2");
			dado3.setIcon(dados3[numerodados3[2]]);
			dado3.setName("3");
			dado1.addMouseListener(new ListenerDados());
			dado2.addMouseListener(new ListenerDados());
			dado3.addMouseListener(new ListenerDados());
	

	//Los dados de 6 caras
	
	for(int i=0;i<numerodados6.length;i++) numerodados6[i]=dado.nextInt(6); //Numero aleatorio
					
			//Imagen dentro de los JLabel
			dado4.setIcon(dados6[numerodados6[0]]);
			dado4.setName("4");	
			dado5.setIcon(dados6[numerodados6[1]]);
			dado5.setName("5");	
			dado4.addMouseListener(new ListenerDados());
			dado5.addMouseListener(new ListenerDados());	
			
	//Los dados de 12 cartas
			
			numerodados12=dado.nextInt(12); //Numero aleatorio
			dado6.setIcon(dados12[numerodados12]);
			//Reseteamos cajas
			resultadolbl.setText("");
			resultadook.setText("");
			resultado.setText("");
			
			//Reseteamos valores
			tocanumero=true;
			operacion=0;
			numerosintroducidos=0;
			sumar=true;
					
	}	
	//ActionListener
	
	private class ListenerDados implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e){
			JLabel dado=(JLabel) e.getSource();
			int numeroDado=Integer.valueOf(dado.getName());
			if(tocanumero){
			if(numeroDado<4)
				resultado.setText(resultado.getText()+String.valueOf(numerodados3[numeroDado-1]+1));
			else
				resultado.setText(resultado.getText()+String.valueOf(numerodados6[numeroDado-4]+1));
			dado.removeMouseListener(this);
			dado.setIcon(dadogris);
			tocanumero=false;
			if(numeroDado<4)
				setOperacion(numerodados3[numeroDado-1]+1);
			else
				setOperacion(numerodados6[numeroDado-4]+1);
				
			}}
		@Override
		public void mouseEntered(MouseEvent e){
		
	}
		@Override
		public void mouseExited(MouseEvent e) {
			
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}
	
	
	}
}
