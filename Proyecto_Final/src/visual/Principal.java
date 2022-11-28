package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JDialog {

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
			}
		}
	}

}
