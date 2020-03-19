package maquetteInterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SelectionnerLigue extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionnerLigue frame = new SelectionnerLigue();
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
	public SelectionnerLigue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListeDesLigues = new JLabel("Liste des ligues");
		lblListeDesLigues.setBounds(179, 11, 75, 14);
		contentPane.add(lblListeDesLigues);
		
		JLabel lblRechercher = new JLabel("Rechercher");
		lblRechercher.setBounds(56, 55, 55, 14);
		contentPane.add(lblRechercher);
		
		textField = new JTextField("pet");
		textField.setBounds(121, 52, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLaPetanque = new JLabel("la petanque");
		lblLaPetanque.setBounds(56, 106, 58, 14);
		contentPane.add(lblLaPetanque);
		
		JButton btnSelectionner = new JButton("selectionner");
		btnSelectionner.setBounds(138, 102, 89, 23);
		contentPane.add(btnSelectionner);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(310, 205, 89, 23);
		contentPane.add(btnRetour);
	}

}
