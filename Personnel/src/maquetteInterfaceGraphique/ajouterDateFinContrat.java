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
import javax.swing.JTextField;

public class ajouterDateFinContrat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouterDateFinContrat frame = new ajouterDateFinContrat();
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
	public ajouterDateFinContrat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDateDeContrat = new JLabel("Date de Contrat");
		lblDateDeContrat.setBounds(147, 11, 78, 14);
		contentPane.add(lblDateDeContrat);
		
		JLabel lblNewLabel = new JLabel("Date de début");
		lblNewLabel.setBounds(38, 65, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDateDeFin = new JLabel("Date de fin");
		lblDateDeFin.setBounds(227, 65, 54, 14);
		contentPane.add(lblDateDeFin);
		
		JLabel lblIdentifiantAdmin = new JLabel("Identifiant Admin");
		lblIdentifiantAdmin.setBounds(38, 135, 86, 14);
		contentPane.add(lblIdentifiantAdmin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(235, 135, 48, 14);
		contentPane.add(lblPassword);
		
		JButton btnValiderLesModifications = new JButton("Valider les modifications");
		btnValiderLesModifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValiderLesModifications.setBounds(147, 174, 153, 23);
		contentPane.add(btnValiderLesModifications);
		
		textField = new JTextField();
		textField.setText("10/03/2020");
		textField.setBounds(121, 62, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("11/03/2020");
		textField_1.setBounds(293, 62, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(129, 132, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(293, 132, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(313, 215, 89, 23);
		contentPane.add(btnRetour);
	}

}
