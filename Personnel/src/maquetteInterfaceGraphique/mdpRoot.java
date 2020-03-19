package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class mdpRoot extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mdpRoot frame = new mdpRoot();
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
	public mdpRoot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modification du mdp Root");
		lblNewLabel.setBounds(134, 11, 125, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAncienMotDe = new JLabel("Ancien mot de passe : ");
		lblAncienMotDe.setBounds(39, 69, 111, 14);
		contentPane.add(lblAncienMotDe);
		
		JLabel lblNouveauMotDe = new JLabel("Nouveau mot de passe :");
		lblNouveauMotDe.setBounds(39, 110, 117, 14);
		contentPane.add(lblNouveauMotDe);
		
		JLabel lblConfirmer = new JLabel("Confirmer le nouvau mot de passe :");
		lblConfirmer.setBounds(39, 150, 174, 14);
		contentPane.add(lblConfirmer);
		
		textField = new JTextField();
		textField.setBounds(224, 66, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(224, 107, 135, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(224, 147, 135, 20);
		contentPane.add(textField_2);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(170, 175, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(320, 211, 89, 23);
		contentPane.add(btnRetour);
	}

}
