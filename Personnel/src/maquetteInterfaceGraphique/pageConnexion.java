package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class pageConnexion extends JFrame {

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
					pageConnexion frame = new pageConnexion();
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
	public pageConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionDuPersonnel = new JLabel("Gestion du personnel de ligue");
		lblGestionDuPersonnel.setBounds(135, 0, 145, 14);
		contentPane.add(lblGestionDuPersonnel);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setBounds(73, 78, 52, 14);
		contentPane.add(lblIdentifiant);
		
		textField = new JTextField();
		textField.setBounds(135, 75, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("mot de passe");
		lblMotDePasse.setBounds(60, 110, 65, 14);
		contentPane.add(lblMotDePasse);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 110, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(191, 155, 118, 31);
		contentPane.add(btnNewButton);
	}
}
