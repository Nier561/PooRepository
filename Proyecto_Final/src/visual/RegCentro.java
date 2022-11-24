package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Centro;
import logical.Empresa;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RegCentro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCentro dialog = new RegCentro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCentro() {
		setResizable(false);
		setTitle("Registro de Centro");
		setBounds(100, 100, 455, 270);
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
			
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setBounds(22, 25, 75, 14);
			panel.add(lblCodigo);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(124, 22, 137, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(124, 61, 225, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(22, 64, 75, 14);
			panel.add(lblNombre);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(22, 103, 75, 14);
			panel.add(lblDireccion);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(22, 142, 75, 14);
			panel.add(lblTelefono);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(124, 100, 225, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(124, 139, 225, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
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
						Centro auxCentro = null;
						String cedula = txtCedula.getText();
						String nombre = txtNombre.getText();
						String direccion = txtDireccion.getText();
						String telefono = txtTelefono.getText();
						
						auxCentro = new Centro(cedula,nombre,direccion,telefono);
						
						Empresa.getInstance().insertarCentro(auxCentro);
						JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						clean();
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
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
}
