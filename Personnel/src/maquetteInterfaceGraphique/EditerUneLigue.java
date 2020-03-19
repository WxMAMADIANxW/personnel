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

public class EditerUneLigue extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditerUneLigue frame = new EditerUneLigue();
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
	public EditerUneLigue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLaLigue = new JLabel("La ligue : la petanque");
		lblLaLigue.setBounds(151, 11, 106, 14);
		contentPane.add(lblLaLigue);
		
		JButton btnAfficherDetail = new JButton("Afficher detail la petanque");
		btnAfficherDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAfficherDetail.setBounds(40, 76, 163, 23);
		contentPane.add(btnAfficherDetail);
		
		JButton btnGererLesEmploy = new JButton("gerer les employé");
		btnGererLesEmploy.setBounds(40, 110, 119, 23);
		contentPane.add(btnGererLesEmploy);
		
		JButton btnRenommerLaLigue = new JButton("Renommer la ligue");
		btnRenommerLaLigue.setBounds(40, 153, 125, 23);
		contentPane.add(btnRenommerLaLigue);
		
		JButton btnSupprimerLaLigue = new JButton("Supprimer la ligue");
		btnSupprimerLaLigue.setBounds(40, 197, 121, 23);
		contentPane.add(btnSupprimerLaLigue);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(303, 208, 89, 23);
		contentPane.add(btnRetour);
	}

}
