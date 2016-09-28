import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BAILANDOTEXTO extends JFrame {

	private JPanel contentPane;
	private JTextField TextoIzquierda;
	private JTextField TextoDerecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BAILANDOTEXTO frame = new BAILANDOTEXTO();
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
	public BAILANDOTEXTO() {
		setTitle("INTERCAMBIO TEXTOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextoIzquierda = new JTextField();
		TextoIzquierda.setBounds(10, 101, 133, 32);
		contentPane.add(TextoIzquierda);
		TextoIzquierda.setColumns(10);
		
		TextoDerecha = new JTextField();
		TextoDerecha.setColumns(10);
		TextoDerecha.setBounds(291, 101, 133, 32);
		contentPane.add(TextoDerecha);
		
		JButton button = new JButton("---->");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TextoDerecha.setText(TextoIzquierda.getText());
				TextoIzquierda.setText("");
				
				
			}
		});
		button.setBounds(170, 59, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("<----");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoIzquierda.setText(TextoDerecha.getText());
				TextoDerecha.setText("");
			}
		});
		button_1.setBounds(170, 150, 89, 23);
		contentPane.add(button_1);
	}
}
