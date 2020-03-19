package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class afficherLesLigues extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afficherLesLigues frame = new afficherLesLigues();
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
	public afficherLesLigues() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListeDesLigues = new JLabel("Liste des ligues");
		lblListeDesLigues.setBounds(170, 11, 75, 14);
		contentPane.add(lblListeDesLigues);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(323, 195, 89, 23);
		contentPane.add(btnRetour);
		
		JLabel lblLaPtanque = new JLabel("La pétanque");
		lblLaPtanque.setBounds(35, 54, 60, 14);
		contentPane.add(lblLaPtanque);
		
		JLabel lblLeGoupeDes = new JLabel("Le groupe des BG");
		lblLeGoupeDes.setBounds(35, 79, 84, 14);
		contentPane.add(lblLeGoupeDes);
		
		JLabel label = new JLabel("");
		label.setBounds(35, 117, 48, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("...");
		label_1.setBounds(35, 104, 48, 14);
		contentPane.add(label_1);
	}
}
