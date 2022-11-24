package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Empresa;
import logical.SolicitudCentro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegSolicitudCentro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JTextField txtCodigo;
	private JTextField txtCodigoCentro;
	private JComboBox cbxTipoContrato;
	private JComboBox cbxSueldoDeseado;
	private JRadioButton rdbtnMudarse;
	private JRadioButton rdbtnLicencia;
	private JRadioButton rdbtnIngles;
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
	private JSpinner spnCantPerson;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegSolicitudCentro dialog = new RegSolicitudCentro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegSolicitudCentro() {
		setResizable(false);
		setTitle("Registro de Solicitud de Centro");
		setBounds(100, 100, 450, 575);
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
				JLabel lblCodigo = new JLabel("Codigo:");
				lblCodigo.setBounds(10, 24, 64, 14);
				panel.add(lblCodigo);
			}
			{
				JLabel lblCodigoCentro = new JLabel("Codigo Centro:");
				lblCodigoCentro.setBounds(10, 62, 86, 14);
				panel.add(lblCodigoCentro);
			}
			{
				JLabel lblTipoContrato = new JLabel("Tipo de contrato:");
				lblTipoContrato.setBounds(10, 298, 109, 14);
				panel.add(lblTipoContrato);
			}
			{
				JLabel lblSueldo = new JLabel("Sueldo Propuesto:");
				lblSueldo.setBounds(10, 336, 109, 14);
				panel.add(lblSueldo);
			}
			{
				rdbtnMudarse = new JRadioButton("Dispuesto a mudarse");
				rdbtnMudarse.setBounds(10, 374, 175, 23);
				panel.add(rdbtnMudarse);
			}
			{
				rdbtnIngles = new JRadioButton("Sabe ingles");
				rdbtnIngles.setBounds(10, 421, 109, 23);
				panel.add(rdbtnIngles);
			}
			{
				rdbtnLicencia = new JRadioButton("Licencia de conducir");
				rdbtnLicencia.setBounds(10, 468, 164, 23);
				panel.add(rdbtnLicencia);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(157, 21, 218, 20);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
				txtCodigo.setText("CNTR-"+String.valueOf(Empresa.generadorSolicitudCentro));
			}
			{
				txtCodigoCentro = new JTextField();
				txtCodigoCentro.setBounds(157, 59, 218, 20);
				panel.add(txtCodigoCentro);
				txtCodigoCentro.setColumns(10);
			}
			{
				cbxTipoContrato = new JComboBox();
				cbxTipoContrato.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Tiempo completo", "Medio tiempo", "Por ajuste"}));
				cbxTipoContrato.setBounds(157, 295, 218, 20);
				panel.add(cbxTipoContrato);
			}
			{
				cbxSueldoDeseado = new JComboBox();
				cbxSueldoDeseado.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "5000-10000", "10001-15000", "15001-20000", "20001-25000", "25001-30000"}));
				cbxSueldoDeseado.setBounds(157, 333, 218, 20);
				panel.add(cbxSueldoDeseado);
			}
			
			JLabel lblCantPerson = new JLabel("Cantidad de Personal Deseado:");
			lblCantPerson.setBounds(157, 424, 185, 16);
			panel.add(lblCantPerson);
			
			JPanel panelTipo = new JPanel();
			panelTipo.setBorder(new TitledBorder(null, "Tipo de Personal Deseado:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTipo.setBounds(20, 89, 375, 60);
			panel.add(panelTipo);
			panelTipo.setLayout(null);
			
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
			rdbtnUniversitario.setBounds(8, 25, 98, 23);
			panelTipo.add(rdbtnUniversitario);
			
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
			panelTipo.add(rdbtnTecnico);
			
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
			panelTipo.add(rdbtnObrero);
			
			panelUniversitario = new JPanel();
			panelUniversitario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelUniversitario.setBounds(22, 150, 373, 113);
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
			panelTecnico.setBounds(22, 150, 373, 113);
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
			panelObrero.setBounds(22, 150, 373, 113);
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
			
			spnCantPerson = new JSpinner();
			spnCantPerson.setBounds(345, 421, 50, 22);
			panel.add(spnCantPerson);
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
						int cantPersonal = (Integer) spnCantPerson.getValue();
						String tipoPersonal = null;
						String carrera = null;
						String oficio = null;
						int anoExp = 0;
						String areaTecnica = null;
						if(rdbtnUniversitario.isSelected()) {
							tipoPersonal = "Universitario";
							carrera = txtCarrera.getText();
						}
						if(rdbtnObrero.isSelected()) {
							tipoPersonal = "Obrero";
							oficio = txtOficio.getText();
							anoExp = (Integer) spnAgno.getValue();
						}
						if(rdbtnTecnico.isSelected()) {
							tipoPersonal = "Tecnico";
							areaTecnica = txtAreaTec.getText();
						}
						String codigoCentro = txtCodigoCentro.getText();
						String tipoContrato = cbxTipoContrato.getSelectedItem().toString();
						String sueldoDeseado = cbxSueldoDeseado.getSelectedItem().toString();
						Boolean licencia = rdbtnLicencia.isSelected();
						Boolean ingles = rdbtnIngles.isSelected();
						Boolean mudarse = rdbtnMudarse.isSelected();
						SolicitudCentro auxSol = new SolicitudCentro(codigo, codigoCentro, tipoPersonal, cantPersonal,tipoContrato, sueldoDeseado, mudarse, licencia, ingles, carrera, oficio, anoExp, areaTecnica);
						Empresa.getInstance().insertarSolicitudCentro(auxSol);
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
		txtCodigo.setText("CNTR-"+String.valueOf(Empresa.generadorSolicitudCentro));
		txtCodigoCentro.setText("");
		txtCarrera.setText("");
		txtAreaTec.setText("");
		txtOficio.setText("");
		spnAgno.setValue(0);
		cbxTipoContrato.setSelectedIndex(0);
		cbxTipoContrato.setSelectedIndex(0);
		rdbtnMudarse.setSelected(false);
		rdbtnLicencia.setSelected(false);
		rdbtnIngles.setSelected(false);
		spnCantPerson.setValue(0);
	}
}
