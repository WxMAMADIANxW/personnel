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

public class GererEmployeLigue extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GererEmployeLigue frame = new GererEmployeLigue();
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
	public GererEmployeLigue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGererLesEmploy = new JLabel("Gerer les employé de la ligue");
		lblGererLesEmploy.setBounds(126, 11, 142, 14);
		contentPane.add(lblGererLesEmploy);
		
		JButton btnListeDesEmpoy = new JButton("Liste des empoyé de la ligue");
		btnListeDesEmpoy.setBounds(30, 65, 171, 23);
		contentPane.add(btnListeDesEmpoy);
		
		JButton btnAjouterUnEmploy = new JButton("ajouter un employé");
		btnAjouterUnEmploy.setBounds(30, 114, 127, 23);
		contentPane.add(btnAjouterUnEmploy);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRetour.setBounds(303, 205, 89, 23);
		contentPane.add(btnRetour);
	}

}
