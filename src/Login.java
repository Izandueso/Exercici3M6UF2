import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JRadioButton;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private boolean esTrue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Login() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuari = new JLabel("Usuari:");
		lblUsuari.setBounds(173, 11, 59, 14);
		contentPane.add(lblUsuari);
		
		textField = new JTextField();
		textField.setBounds(104, 36, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String usuari = textField.getText();
		
		JLabel lblContrasenya = new JLabel("Contrasenya: ");
		lblContrasenya.setBounds(160, 97, 129, 14);
		contentPane.add(lblContrasenya);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 122, 185, 20);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel("");
		label.setBounds(331, 173, 93, 34);
		contentPane.add(label);
		
		String contrasenya = textField_1.getText();
		
		JRadioButton rdbtnPreparation = new JRadioButton("Preparation");
		rdbtnPreparation.setBounds(6, 187, 129, 20);
		contentPane.add(rdbtnPreparation);
		
		JButton btnIniciarSessio = new JButton("Iniciar Sessio");
		btnIniciarSessio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnPreparation.isSelected()){
					try {
						IniciDeSessio login = new IniciDeSessio(textField.getText(), textField_1.getText());
						label.setText(login.haIniciado2());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
				}else{
					try {
						IniciDeSessio login = new IniciDeSessio(textField.getText(), textField_1.getText());
						label.setText(login.haIniciado());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			

			}
		});
		btnIniciarSessio.setBounds(136, 173, 128, 37);
		contentPane.add(btnIniciarSessio);
		
		

		
	}
	

	
}
