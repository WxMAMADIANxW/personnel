package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class pageQuitter extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageQuitter frame = new pageQuitter();
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
	public pageQuitter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnregistrerEtQuitter = new JButton("Enregistrer et quitter");
		btnEnregistrerEtQuitter.setBounds(43, 98, 148, 49);
		contentPane.add(btnEnregistrerEtQuitter);
		
		JButton btnQuitterSansSauver = new JButton("Quitter sans sauver ");
		btnQuitterSansSauver.setBounds(244, 98, 131, 49);
		contentPane.add(btnQuitterSansSauver);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(314, 205, 89, 23);
		contentPane.add(btnRetour);
		
		JLabel lbltesvousSurDe = new JLabel("Êtes-vous sur de vraiment vouloir quitter ?");
		lbltesvousSurDe.setBounds(107, 31, 206, 14);
		contentPane.add(lbltesvousSurDe);
	}

}
