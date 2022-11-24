package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Empresa;
import logical.Obrero;
import logical.Personal;
import logical.Tecnico;
import logical.Universitario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JLabel lblCarrera;
	private JTextField txtCarrera;
	private JPanel panelUniversitario;
	private JTextField txtAreaTec;
	private JSpinner spnAgno;
	private JPanel panelObrero;
	private JLabel lblOficio;
	private JTextField txtOficio;
	private JLabel lblAgnoExp;
	private JLabel lblAreaTec;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;
	private JPanel panelTecnico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPersonal dialog = new RegPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPersonal() {
		setTitle("Registro de Personal");
		setBounds(100, 100, 455, 470);
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
			
			JLabel lblNewLabel = new JLabel("Cedula: ");
			lblNewLabel.setBounds(22, 25, 75, 14);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(124, 22, 137, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(124, 61, 225, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(22, 64, 75, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Direccion:");
			lblNewLabel_2.setBounds(22, 103, 75, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Telefono:");
			lblNewLabel_3.setBounds(22, 142, 75, 14);
			panel.add(lblNewLabel_3);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(124, 100, 225, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(124, 139, 225, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Tipo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(22, 180, 373, 60);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			rdbtnUniversitario = new JRadioButton("Universitario");
			rdbtnUniversitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnTecnico.setSelected(false);
					rdbtnObrero.setSelected(false);
					panelTecnico.setVisible(false);
					panelObrero.setVisible(false);
					panelUniversitario.setVisible(true);
				}
			});
			rdbtnUniversitario.setSelected(true);
			rdbtnUniversitario.setBounds(17, 25, 98, 23);
			panel_1.add(rdbtnUniversitario);
			
			rdbtnTecnico = new JRadioButton("Tecnico");
			rdbtnTecnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnUniversitario.setSelected(false);
					rdbtnObrero.setSelected(false);
					panelUniversitario.setVisible(false);
					panelObrero.setVisible(false);
					panelTecnico.setVisible(true);
				}
			});
			rdbtnTecnico.setBounds(134, 25, 91, 23);
			panel_1.add(rdbtnTecnico);
			
			rdbtnObrero = new JRadioButton("Obrero");
			rdbtnObrero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnUniversitario.setSelected(false);
					rdbtnTecnico.setSelected(false);
					panelUniversitario.setVisible(false);
					panelTecnico.setVisible(false);
					panelObrero.setVisible(true);
				}
			});
			rdbtnObrero.setBounds(245, 25, 109, 23);
			panel_1.add(rdbtnObrero);
			
			panelUniversitario = new JPanel();
			panelUniversitario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelUniversitario.setBounds(22, 251, 373, 113);
			panel.add(panelUniversitario);
			panelUniversitario.setLayout(null);
			
			lblCarrera = new JLabel("Carrera:");
			lblCarrera.setBounds(10, 11, 68, 14);
			panelUniversitario.add(lblCarrera);
			
			txtCarrera = new JTextField();
			txtCarrera.setBounds(107, 8, 217, 20);
			panelUniversitario.add(txtCarrera);
			txtCarrera.setColumns(10);
			
			panelTecnico = new JPanel();
			panelTecnico.setBounds(22, 251, 373, 113);
			panel.add(panelTecnico);
			panelTecnico.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTecnico.setLayout(null);
			panelTecnico.setVisible(false);
			
			lblAgnoExp = new JLabel("A\u00F1os de experiencia:");
			lblAgnoExp.setBounds(10, 11, 138, 14);
			panelTecnico.add(lblAgnoExp);
			
			lblAreaTec = new JLabel("Area tecnica:");
			lblAreaTec.setBounds(10, 52, 112, 14);
			panelTecnico.add(lblAreaTec);
			
			spnAgno = new JSpinner();
			spnAgno.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnAgno.setBounds(205, 8, 138, 20);
			panelTecnico.add(spnAgno);
			
			txtAreaTec = new JTextField();
			txtAreaTec.setBounds(205, 49, 138, 20);
			panelTecnico.add(txtAreaTec);
			txtAreaTec.setColumns(10);
			
			panelObrero = new JPanel();
			panelObrero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelObrero.setBounds(22, 251, 373, 113);
			panel.add(panelObrero);
			panelObrero.setLayout(null);
			panelObrero.setVisible(false);
			
			lblOficio = new JLabel("Oficio:");
			lblOficio.setBounds(10, 25, 60, 14);
			panelObrero.add(lblOficio);
			
			txtOficio = new JTextField();
			txtOficio.setBounds(132, 23, 180, 17);
			panelObrero.add(txtOficio);
			txtOficio.setColumns(10);
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
						Personal auxPersonal = null;
						String cedula = txtCedula.getText();
						String nombre = txtNombre.getText();
						String direccion = txtDireccion.getText();
						String telefono = txtTelefono.getText();
						
						if(rdbtnUniversitario.isSelected()) {
							auxPersonal = new Universitario(cedula,nombre,direccion,telefono,txtCarrera.getText());
						}
						
						if(rdbtnTecnico.isSelected()) {
							auxPersonal = new Tecnico(cedula,nombre,direccion,telefono,Integer.valueOf(spnAgno.getValue().toString()),txtAreaTec.toString());
						}
						
						if(rdbtnObrero.isSelected()) {
							auxPersonal = new Obrero(cedula,nombre,direccion,telefono,txtOficio.getText());
						}
						Empresa.getInstance().insertarPersonal(auxPersonal);
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
		txtCarrera.setText("");
		txtAreaTec.setText("");
		spnAgno.setValue(1);
		txtOficio.setText("");
		rdbtnTecnico.setSelected(false);
		rdbtnObrero.setSelected(false);
		rdbtnUniversitario.setSelected(true);
		panelTecnico.setVisible(false);
		panelObrero.setVisible(false);
		panelUniversitario.setVisible(true);
	}
}
