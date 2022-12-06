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
import logical.Personal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListPersonal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JTable table;
	private DefaultTableModel model;
	private Object[] rows;
	private Personal selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListPersonal dialog = new ListPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListPersonal() {
		setTitle("Listado de Personal");
		setBounds(100, 100, 596, 389);
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
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane, BorderLayout.CENTER);
			
			model = new DefaultTableModel();
			String[] columnas = {"Codigo" , "Nombre", "Ciudad", "Telefono", "Contratado"};
			model.setColumnIdentifiers(columnas);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int rowSelected = -1;
					rowSelected = table.getSelectedRow();
					if(rowSelected >= 0) {
						btnEliminar.setEnabled(true);
						selected = Empresa.getInstance().buscarPersonalByCedula(table.getValueAt(rowSelected, 0).toString());
					}
				}
			});
			table.setModel(model);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option;
						if(selected != null) {
							option = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas borrar la cuenta con el codigo: "+selected.getCedula(), "Confirmacion", JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.OK_OPTION) {
								JOptionPane.showMessageDialog(null, "Se elimino la cuenta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								Empresa.getInstance().eliminarPersonal(selected);
								loadPersonal();
								btnEliminar.setEnabled(false);
							}
						}
					}
				});
				btnEliminar.setEnabled(false);
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
		loadPersonal();
	}

	private void loadPersonal() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Personal personal : Empresa.getInstance().getListPersonal()) {
			rows[0] = personal.getCedula();
			rows[1] = personal.getNombre();
			rows[2] = personal.getCiudad();
			rows[3] = personal.getTelefono();
			rows[4] = personal.isEmpleado();
			
			model.addRow(rows);
		}
	}
}
