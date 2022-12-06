package visual;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Control;
import logical.Empresa;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Principal extends JFrame {

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new FileOutputStream("empresa.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Control.getInstance());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Salvar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Empresa.getInstance().save();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(776, 593, 97, 25);
			contentPanel.add(btnNewButton);
		}
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
			{
				JMenu mnAdministracion = new JMenu("Administracion");
				if(!(Control.getLoginUser().getTipo().equalsIgnoreCase("Administrador"))) {
					mnAdministracion.setEnabled(false);
				}
				menuBar.add(mnAdministracion);
				
				JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registrar Usuario");
				mntmNewMenuItem_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegUsuario regUsuario = new RegUsuario();
						regUsuario.setVisible(true);
					}
				});
				mnAdministracion.add(mntmNewMenuItem_4);
			}
		}
	}
}
