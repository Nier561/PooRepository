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

import logical.Centro;
import logical.Empresa;
import logical.SolicitudCentro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListSoliciutdCentro extends JDialog {

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
	private SolicitudCentro selected = null;
	private JButton btnMatches;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListSoliciutdCentro dialog = new ListSoliciutdCentro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListSoliciutdCentro() {
		setTitle("Listado de Centro");
		setBounds(100, 100, 650, 389);
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
			String[] columnas = {"Codigo" , "CodigoCentro", "TipoPersonal", "TipoContrato", "SueldoPropuesto", "CantDeseado"};
			model.setColumnIdentifiers(columnas);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int rowSelected = -1;
					rowSelected = table.getSelectedRow();
					if(rowSelected >= 0) {
						btnEliminar.setEnabled(true);
						btnMatches.setEnabled(true);
						selected = Empresa.getInstance().buscarSolicitudCentroByCod(table.getValueAt(rowSelected, 0).toString());
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
							option = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas borrar la solicitud con el codigo: "+selected.getCodigo(), "Confirmacion", JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.OK_OPTION) {
								Empresa.getInstance().eliminarSolicitudCentro(selected);
								loadSolCentro();
								btnEliminar.setEnabled(false);
								btnMatches.setEnabled(false);
							}
						}
					}
				});
				{
					btnMatches = new JButton("Listar Matches");
					btnMatches.setEnabled(false);
					btnMatches.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListMatchPersonal match = new ListMatchPersonal(Empresa.getInstance().buscarIndBySolicitudCentro(selected.getCodigo()));
							match.setVisible(true);
						}
					});
					buttonPane.add(btnMatches);
				}
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
		loadSolCentro();
	}

	private void loadSolCentro() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (SolicitudCentro solCentro : Empresa.getInstance().getListSolicitudCentro()) {
			rows[0] = solCentro.getCodigo();
			rows[1] = solCentro.getCodCentro();
			rows[2] = solCentro.getTipoPersonal();
			rows[3] = solCentro.getTipoContrato();
			rows[4] = solCentro.getSueldo();
			rows[5] = solCentro.getCantPersonal();
			
			model.addRow(rows);
		}
	}
}
