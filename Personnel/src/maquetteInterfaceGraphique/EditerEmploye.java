package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EditerEmploye extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditerEmploye frame = new EditerEmploye();
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
	public EditerEmploye() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFicheEmploy = new JLabel("Fiche Employé : Gerard DUPOND");
		lblFicheEmploy.setBounds(126, 11, 158, 14);
		contentPane.add(lblFicheEmploy);
		
		JButton btnInformationsEmploy = new JButton("Informations employé");
		btnInformationsEmploy.setBounds(46, 71, 139, 23);
		contentPane.add(btnInformationsEmploy);
		
		JButton btnDateFinDe = new JButton("Date fin de contrat");
		btnDateFinDe.setBounds(46, 121, 125, 23);
		contentPane.add(btnDateFinDe);
		
		JButton btnSupprimerLemploy = new JButton("Supprimer l'employé");
		btnSupprimerLemploy.setBounds(46, 171, 131, 23);
		contentPane.add(btnSupprimerLemploy);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(304, 200, 89, 23);
		contentPane.add(btnRetour);
	}

}
