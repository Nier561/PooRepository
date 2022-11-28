package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Principal() {
		
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnPersonal = new JMenu("Personal");
				menuBar.add(mnPersonal);
				{
					JMenuItem mntmRegPersonal = new JMenuItem("Registrar Personal");
					mntmRegPersonal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegPersonal regPersonal = new RegPersonal();
							regPersonal.setVisible(true);
						}
					});
					mnPersonal.add(mntmRegPersonal);
				}
				{
					JMenuItem mntmRegistroSolPer = new JMenuItem("Registrar Solicitud de Personal");
					mntmRegistroSolPer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegSolicitudPersonal regSolPersonal = new RegSolicitudPersonal();
							regSolPersonal.setVisible(true);
						}
					});
					mnPersonal.add(mntmRegistroSolPer);
				}
				{
					JMenuItem mntmNewMenuItem = new JMenuItem("Listar Personal");
					mntmNewMenuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListPersonal listPersonal = new ListPersonal();
							listPersonal.setVisible(true);
						}
					});
					mnPersonal.add(mntmNewMenuItem);
				}
				{
					JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar Soicitudes de Personal");
					mntmNewMenuItem_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListSolicitudPersonal listSolPersonal = new ListSolicitudPersonal();
							listSolPersonal.setVisible(true);
						}
					});
					mnPersonal.add(mntmNewMenuItem_1);
				}
			}
			{
				JMenu mnCentro = new JMenu("Centro");
				menuBar.add(mnCentro);
				{
					JMenuItem mntmRegistroCentro = new JMenuItem("Registrar Centro");
					mntmRegistroCentro.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegCentro regCentro = new RegCentro();
							regCentro.setVisible(true);
						}
					});
					mnCentro.add(mntmRegistroCentro);
				}
				{
					JMenuItem mntmRegistroSolCentro = new JMenuItem("Registrar Solicitud de Centro");
					mntmRegistroSolCentro.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegSolicitudCentro regSolCentro = new RegSolicitudCentro();
							regSolCentro.setVisible(true);
						}
					});
					mnCentro.add(mntmRegistroSolCentro);
				}
				{
					JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar Centro");
					mntmNewMenuItem_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListCentro listCentro = new ListCentro();
							listCentro.setVisible(true);
						}
					});
					mnCentro.add(mntmNewMenuItem_2);
				}
				{
					JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listar Solicitud Centro");
					mntmNewMenuItem_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListSoliciutdCentro listSolCentro = new ListSoliciutdCentro();
							listSolCentro.setVisible(true);
						}
					});
					mnCentro.add(mntmNewMenuItem_3);
				}
			}
		}
	}

}
