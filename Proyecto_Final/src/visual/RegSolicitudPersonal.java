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
import logical.SolicitudPersonal;
import logical.Tecnico;
import logical.Universitario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegSolicitudPersonal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JComboBox cbxTipoContrato;
	private JComboBox cbxSueldoDeseado;
	private JRadioButton rdbtnMudarse;
	private JRadioButton rdbtnLicencia;
	private JRadioButton rdbtnIngles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegSolicitudPersonal dialog = new RegSolicitudPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegSolicitudPersonal() {
		setTitle("Registro de Solicitud de Personal");
		setBounds(100, 100, 450, 400);
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
			{
				JLabel lblNewLabel = new JLabel("Codigo:");
				lblNewLabel.setBounds(10, 24, 64, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Cedula:");
				lblNewLabel_1.setBounds(10, 62, 64, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tipo de contrato:");
				lblNewLabel_2.setBounds(10, 100, 92, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Sueldo deseado:");
				lblNewLabel_3.setBounds(10, 138, 92, 14);
				panel.add(lblNewLabel_3);
			}
			{
				rdbtnMudarse = new JRadioButton("Dispuesto a mudarse");
				rdbtnMudarse.setBounds(10, 176, 175, 23);
				panel.add(rdbtnMudarse);
			}
			{
				rdbtnIngles = new JRadioButton("Sabe ingles");
				rdbtnIngles.setBounds(10, 223, 109, 23);
				panel.add(rdbtnIngles);
			}
			{
				rdbtnLicencia = new JRadioButton("Licencia de conducir");
				rdbtnLicencia.setBounds(10, 270, 164, 23);
				panel.add(rdbtnLicencia);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(157, 21, 218, 20);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
				txtCodigo.setText("PRSNL-"+String.valueOf(Empresa.getInstance().getGeneradorSolicitudPersonal()));
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(157, 59, 218, 20);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				cbxTipoContrato = new JComboBox();
				cbxTipoContrato.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Tiempo completo", "Medio tiempo", "Por ajuste"}));
				cbxTipoContrato.setBounds(157, 97, 218, 20);
				panel.add(cbxTipoContrato);
			}
			{
				cbxSueldoDeseado = new JComboBox();
				cbxSueldoDeseado.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "5000-10000", "10001-15000", "15001-20000", "20001-25000", "25001-30000"}));
				cbxSueldoDeseado.setBounds(157, 135, 218, 20);
				panel.add(cbxSueldoDeseado);
			}
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
						String codigo = txtCodigo.getText();
						String cedulaPersonal = txtCedula.getText();
						String tipoContrato = cbxTipoContrato.getSelectedItem().toString();
						String sueldoDeseado = cbxSueldoDeseado.getSelectedItem().toString();
						Boolean licencia = false;
						Boolean ingles = false;
						Boolean mudarse = false;
						String carrera = null;
						int agnosExp = 0;
						String areaTec = null;
						String oficio = null;
						if(Empresa.getInstance().buscarPersonalByCedula(cedulaPersonal) == null) {
							JOptionPane.showMessageDialog(null, "La cedula digitada no se encuentra en el registro", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							Personal auxPersonal = Empresa.getInstance().buscarPersonalByCedula(cedulaPersonal);
							if(auxPersonal instanceof Universitario) {
								carrera = ((Universitario) auxPersonal).getCarrera();
							}
							
							if(auxPersonal instanceof Tecnico) {
								agnosExp = ((Tecnico) auxPersonal).getAnoExp();
								areaTec = ((Tecnico) auxPersonal).getAreaTecnica();
							}
							
							if(auxPersonal instanceof Obrero) {
								oficio = ((Obrero) auxPersonal).getOficio();
							}
							if(rdbtnMudarse.isSelected()) {
								mudarse = true;
							}
							
							if(rdbtnLicencia.isSelected()) {
								licencia = true;
							}
							
							if(rdbtnIngles.isSelected()) {
								ingles = true;
							}
							SolicitudPersonal SP = new SolicitudPersonal(codigo,cedulaPersonal,tipoContrato,sueldoDeseado,mudarse,licencia,ingles,carrera,agnosExp,areaTec,oficio);
							Empresa.getInstance().insertarSolicitudPersonal(SP);
							JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						}
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
		txtCodigo.setText("PRSNL-"+String.valueOf(Empresa.getInstance().getGeneradorSolicitudPersonal()));
		txtCedula.setText("");
		cbxTipoContrato.setSelectedIndex(0);
		cbxTipoContrato.setSelectedIndex(0);
		rdbtnMudarse.setSelected(false);
		rdbtnLicencia.setSelected(false);
		rdbtnIngles.setSelected(false);
	}

}
