package commandLine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectionnerEmployé extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnRetour;
	private JLabel lblListeDesEmploys;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionnerEmployé frame = new SelectionnerEmployé();
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
	public SelectionnerEmployé() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRechercher = new JLabel("Rechercher");
		lblRechercher.setBounds(65, 64, 55, 14);
		contentPane.add(lblRechercher);
		
		textField = new JTextField();
		textField.setBounds(123, 61, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDupondGerard = new JLabel("DUPOND Gerard");
		lblDupondGerard.setBounds(36, 113, 78, 14);
		contentPane.add(lblDupondGerard);
		
		JButton btnEditer = new JButton("Selectionner");
		btnEditer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditer.setBounds(123, 109, 93, 23);
		contentPane.add(btnEditer);
		
		btnRetour = new JButton("Retour");
		btnRetour.setBounds(303, 197, 89, 23);
		contentPane.add(btnRetour);
		
		lblListeDesEmploys = new JLabel("Liste des employés de la ligue");
		lblListeDesEmploys.setBounds(123, 11, 146, 14);
		contentPane.add(lblListeDesEmploys);
	}

}
