import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Perfil extends JFrame {

	private JPanel contentPane;
	private JTextField txtSal;
	private JTextField txtMartiVila;
	private JTextField textField;
	private JTextField txtSaulmartivilagmailcom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
	public Perfil() {
		setTitle("PERFIL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSal = new JTextField();
		txtSal.setText("Sa\u00FAl");
		txtSal.setBounds(10, 49, 86, 20);
		contentPane.add(txtSal);
		txtSal.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 24, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 80, 66, 14);
		contentPane.add(lblApellidos);
		
		txtMartiVila = new JTextField();
		txtMartiVila.setText("Marti Vila");
		txtMartiVila.setBounds(10, 105, 86, 20);
		contentPane.add(txtMartiVila);
		txtMartiVila.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 136, 46, 14);
		contentPane.add(lblEdad);
		
		textField = new JTextField();
		textField.setText("18");
		textField.setBounds(10, 161, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 192, 46, 14);
		contentPane.add(lblEmail);
		
		txtSaulmartivilagmailcom = new JTextField();
		txtSaulmartivilagmailcom.setText("saulmartivila@gmail.com");
		txtSaulmartivilagmailcom.setBounds(10, 217, 157, 20);
		contentPane.add(txtSaulmartivilagmailcom);
		txtSaulmartivilagmailcom.setColumns(10);
	}
}
