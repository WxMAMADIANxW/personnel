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

public class Accueil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
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
	public Accueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionDePersonnel = new JLabel("Accueil");
		lblGestionDePersonnel.setBounds(193, 0, 35, 14);
		contentPane.add(lblGestionDePersonnel);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(335, 227, 89, 23);
		contentPane.add(btnQuitter);
		
		JButton btnNewButton = new JButton("Gérer le compte Root");
		btnNewButton.setBounds(44, 83, 158, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gérer les ligues");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(234, 83, 158, 46);
		contentPane.add(btnNewButton_1);
	}
}
