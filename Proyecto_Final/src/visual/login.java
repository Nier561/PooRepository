package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Control;
import logical.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream("empresa.dat");
					empresaRead = new ObjectInputStream(empresa);
					Control temp = (Control)empresaRead.readObject();
					Control.setControl(temp);
					empresa.close();
					empresaRead.close();
				}catch (FileNotFoundException e) {
					try {
						empresa2 = new FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						User aux = new User("Administrador", "Admin", "Admin");
						Control.getInstance().regUser(aux);
						empresaWrite.writeObject(Control.getInstance());
						empresa2.close();
						empresaWrite.close();
					} catch(FileNotFoundException e1) {
					} catch(IOException e1) {	
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				try {
					login frame = new login();
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
	public login() {
		setTitle("login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 257);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(36, 39, 58, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(36, 106, 87, 14);
		panel.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(150, 36, 244, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String myPass = String.valueOf(passwordField.getPassword());
				if(Control.getInstance().confirmLogin(txtUsuario.getText(),myPass)) {
					System.out.println(Control.getLoginUser().getTipo());
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(36, 158, 89, 23);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 103, 244, 20);
		panel.add(passwordField);
	}
}
