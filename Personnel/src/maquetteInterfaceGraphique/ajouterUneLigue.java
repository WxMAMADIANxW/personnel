package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ajouterUneLigue extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouterUneLigue frame = new ajouterUneLigue();
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
	public ajouterUneLigue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNouvelleLigue = new JLabel("Nouvelle Ligue");
		lblNouvelleLigue.setBounds(171, 11, 71, 14);
		contentPane.add(lblNouvelleLigue);
		
		JLabel lblNomDeLigue = new JLabel("Nom de ligue");
		lblNomDeLigue.setBounds(62, 72, 64, 14);
		contentPane.add(lblNomDeLigue);
		
		JLabel lblAdminDeLigue = new JLabel("Admin de ligue");
		lblAdminDeLigue.setBounds(62, 115, 73, 14);
		contentPane.add(lblAdminDeLigue);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(164, 167, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(306, 205, 89, 23);
		contentPane.add(btnRetour);
		
		textField = new JTextField();
		textField.setBounds(171, 69, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 112, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
