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

import logical.Empresa;
import logical.SolicitudPersonal;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListSolicitudPersonal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnEliminar;
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
			ListSolicitudPersonal dialog = new ListSolicitudPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListSolicitudPersonal() {
		setTitle("Listado de Solicitudes de Personal");
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
					String[] columnas = {"Codigo" , "Cedula", "TipoPersonal", "TipoContrato", "SueldoDeseado"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected >= 0) {
								btnEliminar.setEnabled(true);
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
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option;
						if(selected != null) {
							option = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas borrar la cuenta con el codigo: "+selected.getCodigo(), "Confirmacion", JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.OK_OPTION) {
								JOptionPane.showMessageDialog(null, "Se elimino la solicitud", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								Empresa.getInstance().eliminarSolicitudPersonal(selected);
								loadSolicitudPersonal();
								btnEliminar.setEnabled(false);
							}
						}
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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
		loadSolicitudPersonal();
	}
	
	private void loadSolicitudPersonal() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (SolicitudPersonal solicitudPersonal : Empresa.getInstance().getListSolicitudPersonal()) {
			rows[0] = solicitudPersonal.getCodigo();
			rows[1] = solicitudPersonal.getCedulaPersonal();
			rows[2] = Empresa.getInstance().identificarTipo(Empresa.getInstance().buscarPersonalByCedula(solicitudPersonal.getCedulaPersonal()));
			rows[3] = solicitudPersonal.getTipoContrato();
			rows[4] = solicitudPersonal.getSueldoDeseado();
			
			model.addRow(rows);
		}
	}

}
