package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Control;
import logical.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JTextField txtNombre;
	private JTextField txtContraseña;
	private JTextField txtConfContraseña;
	private JComboBox cbxTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUsuario() {
		setTitle("Registrar Usuario");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Tipo:");
			lblNewLabel.setBounds(30, 33, 46, 14);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Usuario: ");
			lblNewLabel_1.setBounds(30, 80, 79, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_2.setBounds(30, 127, 79, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Confirmar contrase\u00F1a:");
			lblNewLabel_3.setBounds(30, 174, 138, 14);
			panel.add(lblNewLabel_3);
			
			cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Secretario"}));
			cbxTipo.setBounds(188, 30, 213, 20);
			panel.add(cbxTipo);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(188, 77, 213, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtContraseña = new JTextField();
			txtContraseña.setBounds(188, 124, 213, 20);
			panel.add(txtContraseña);
			txtContraseña.setColumns(10);
			
			txtConfContraseña = new JTextField();
			txtConfContraseña.setBounds(188, 171, 213, 20);
			panel.add(txtConfContraseña);
			txtConfContraseña.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String tipo = String.valueOf(cbxTipo.getSelectedItem().toString());
						String nombre = txtNombre.getText();
						String contraseña = txtContraseña.getText();
						String conficontraseña = txtConfContraseña.getText();
						if((tipo.equalsIgnoreCase("Administrador") || tipo.equalsIgnoreCase("Secretario")) && contraseña.equalsIgnoreCase(conficontraseña) && !contraseña.equalsIgnoreCase("")) {
							User usuario = new User(tipo,nombre,contraseña);
							Control.getInstance().regUser(usuario);
							JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	private void clean() {
		cbxTipo.setSelectedIndex(0);
		txtNombre.setText("");
		txtContraseña.setText("");
		txtConfContraseña.setText("");
	}
}
