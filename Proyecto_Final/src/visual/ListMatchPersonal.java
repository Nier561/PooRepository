package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logical.Control;
import logical.Empresa;
import logical.SolicitudPersonal;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListMatchPersonal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnContratar;
	private JButton btnCancelar;
	private JTable table;
	private DefaultTableModel model;
	private Object[] rows;
	private SolicitudPersonal selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			int ind = 0;
			ListMatchPersonal dialog = new ListMatchPersonal(ind);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListMatchPersonal(final int ind) {
		setResizable(false);
		setTitle("Listado de Matches");
		setBounds(100, 100, 675, 420);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = {"Cedula" , "Nombre", "Match Percent"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected >= 0 && !(Control.getLoginUser().getTipo().equalsIgnoreCase("Administrador"))) {
								btnContratar.setEnabled(true);
								selected = Empresa.getInstance().buscarSolicitudPersonalByCodigo(table.getValueAt(rowSelected, 0).toString());
							}
						}
					});
					table.setModel(model);
					scrollPane.setViewportView(table);
					
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnContratar = new JButton("Contratar");
				btnContratar.setEnabled(false);
				btnContratar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option;
						if(selected != null) {
							option = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas contratar a "+ Empresa.getInstance().buscarPersonalByCedula(selected.getCedulaPersonal()).getNombre(), "Confirmacion", JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.OK_OPTION) {
								Empresa.getInstance().eliminarSolicitudPersonal(selected);
								Empresa.getInstance().buscarPersonalByCedula(selected.getCedulaPersonal()).setEmpleado(true);
								loadMatches(ind);
								btnContratar.setEnabled(false);
							}
						}
					}
				});
				btnContratar.setActionCommand("OK");
				buttonPane.add(btnContratar);
				getRootPane().setDefaultButton(btnContratar);
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
		loadMatches(ind);
	}
	
	private void loadMatches(int ind) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (SolicitudPersonal solicitudPersonal : Empresa.getInstance().getListSolicitudPersonal()) {
			if(!Empresa.getInstance().buscarPersonalByCedula(solicitudPersonal.getCedulaPersonal()).isEmpleado()) {
				rows[0] = solicitudPersonal.getCedulaPersonal();
				rows[1] = Empresa.getInstance().buscarPersonalByCedula(solicitudPersonal.getCedulaPersonal()).getNombre();
				rows[2] = Empresa.getInstance().match(Empresa.getInstance().getListSolicitudCentro().get(ind), solicitudPersonal);
				
				model.addRow(rows);
			}
		}
	}

}
