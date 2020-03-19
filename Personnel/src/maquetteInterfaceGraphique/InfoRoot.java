package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class InfoRoot extends JFrame {

	private JPanel contentPane;
	private JTextField txtRoot;
	private JTextField txtRoot_1;
	private JTextField txtRootmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoRoot frame = new InfoRoot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InfoRoot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformationsRoot = new JLabel("Informations ROOT");
		lblInformationsRoot.setBounds(157, 11, 95, 14);
		contentPane.add(lblInformationsRoot);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(36, 90, 48, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom:");
		lblPrenom.setBounds(36, 115, 48, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblMail = new JLabel("mail:");
		lblMail.setBounds(36, 140, 48, 14);
		contentPane.add(lblMail);
		
		JButton btnSauverLesModifications = new JButton("sauver les modifications");
		btnSauverLesModifications.setBounds(10, 208, 151, 23);
		contentPane.add(btnSauverLesModifications);
		
		txtRoot = new JTextField();
		txtRoot.setText("root");
		txtRoot.setBounds(69, 87, 96, 20);
		contentPane.add(txtRoot);
		txtRoot.setColumns(10);
		
		txtRoot_1 = new JTextField();
		txtRoot_1.setText("root");
		txtRoot_1.setBounds(79, 112, 96, 20);
		contentPane.add(txtRoot_1);
		txtRoot_1.setColumns(10);
		
		txtRootmail = new JTextField();
		txtRootmail.setText("root@mail ");
		txtRootmail.setBounds(69, 137, 96, 20);
		contentPane.add(txtRootmail);
		txtRootmail.setColumns(10);
		
		JButton btnRet = new JButton("Retour ");
		btnRet.setBounds(317, 208, 89, 23);
		contentPane.add(btnRet);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(181, 208, 89, 23);
		contentPane.add(btnAnnuler);
	}

}
