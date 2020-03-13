package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gererRoot extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gererRoot frame = new gererRoot();
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
	public gererRoot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGererLeCompte = new JLabel("Gerer le compte Root");
		lblGererLeCompte.setBounds(155, 0, 104, 14);
		contentPane.add(lblGererLeCompte);
		
		JButton btnAfficherLemploye = new JButton("Afficher l'employe");
		btnAfficherLemploye.setBounds(27, 80, 153, 23);
		contentPane.add(btnAfficherLemploye);
		
		JButton btnChangerLeNom = new JButton("Changer le nom");
		btnChangerLeNom.setBounds(215, 80, 153, 23);
		contentPane.add(btnChangerLeNom);
		
		JButton btnChangerLePrenom = new JButton("Changer le prenom");
		btnChangerLePrenom.setBounds(27, 114, 153, 23);
		contentPane.add(btnChangerLePrenom);
		
		JButton btnChangerLe = new JButton("Changer le mail");
		btnChangerLe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChangerLe.setBounds(215, 114, 153, 23);
		contentPane.add(btnChangerLe);
		
		JButton btnChangerLeMot = new JButton("Changer le mot de passe");
		btnChangerLeMot.setBounds(27, 148, 153, 23);
		contentPane.add(btnChangerLeMot);
		
		JButton btnQuitter = new JButton("Retour");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuitter.setBounds(311, 209, 89, 23);
		contentPane.add(btnQuitter);
	}

}
