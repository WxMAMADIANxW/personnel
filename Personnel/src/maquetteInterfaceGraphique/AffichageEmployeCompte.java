package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AffichageEmployeCompte extends JFrame {

	private JPanel contentPane;
	private JTextField txtDupond;
	private JTextField txtGerard;
	private JTextField txtGerarddupond;
	private JLabel lblContrat;
	private JLabel lblDateDbut;
	private JLabel lblDateFin;
	private JButton btnSauverLesModificatoin;
	private JButton btnAnnuler;
	private JButton btnRetour;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageEmployeCompte frame = new AffichageEmployeCompte();
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
	public AffichageEmployeCompte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformationsEmploye = new JLabel("Informations Employe");
		lblInformationsEmploye.setBounds(153, 11, 107, 14);
		contentPane.add(lblInformationsEmploye);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(16, 70, 48, 14);
		contentPane.add(lblNom);
		
		txtDupond = new JTextField();
		txtDupond.setText("DUPOND");
		txtDupond.setBounds(46, 67, 96, 20);
		contentPane.add(txtDupond);
		txtDupond.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom:");
		lblPrenom.setBounds(153, 70, 48, 14);
		contentPane.add(lblPrenom);
		
		txtGerard = new JTextField();
		txtGerard.setText("Gerard");
		txtGerard.setBounds(193, 67, 96, 20);
		contentPane.add(txtGerard);
		txtGerard.setColumns(10);
		
		JLabel lblMail = new JLabel("mail:");
		lblMail.setBounds(291, 70, 48, 14);
		contentPane.add(lblMail);
		
		txtGerarddupond = new JTextField();
		txtGerarddupond.setText("gerardupond@mail");
		txtGerarddupond.setBounds(320, 67, 104, 20);
		contentPane.add(txtGerarddupond);
		txtGerarddupond.setColumns(10);
		
		lblContrat = new JLabel("Contrat");
		lblContrat.setBounds(160, 159, 48, 14);
		contentPane.add(lblContrat);
		
		lblDateDbut = new JLabel("date début: ");
		lblDateDbut.setBounds(16, 192, 60, 14);
		contentPane.add(lblDateDbut);
		
		lblDateFin = new JLabel("date fin:");
		lblDateFin.setBounds(193, 192, 48, 14);
		contentPane.add(lblDateFin);
		
		btnSauverLesModificatoin = new JButton("sauver les modification");
		btnSauverLesModificatoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSauverLesModificatoin.setBounds(56, 108, 145, 23);
		contentPane.add(btnSauverLesModificatoin);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(221, 108, 89, 23);
		contentPane.add(btnAnnuler);
		
		btnRetour = new JButton("Retour");
		btnRetour.setBounds(320, 227, 89, 23);
		contentPane.add(btnRetour);
		
		label = new JLabel("10/03/2020");
		label.setBounds(77, 192, 56, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("11/03/2020");
		label_1.setBounds(240, 192, 56, 14);
		contentPane.add(label_1);
	}

}
