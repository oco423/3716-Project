package project;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class electionPanel extends JPanel {
	public electionPanel() {
	}

	private JTextField text;
	private JTextField text_1;
	private JTextField text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			electionPanel window = new electionPanel();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		
		Label lblMunSocieties = new Label();
		lblMunSocieties.setBounds(286, 34, 120, 35);
		lblMunSocieties.setText("MUN Societies");
		
		Label lblElectionPanel = new Label();
		lblElectionPanel.setBounds(286, 63, 100, 35);
		lblElectionPanel.setText("Election Panel");
		
		text = new JTextField();
		text.setBounds(239, 273, 220, 23);
		
		JLabel lblWhoAreYou = new JLabel();
		lblWhoAreYou.setBounds(30, 276, 166, 23);
		lblWhoAreYou.setText("Who are you voting for?");
		
		JButton btnVote = new JButton();
		btnVote.setBounds(93, 373, 90, 30);
		btnVote.setText("Vote");
		
		JLabel lblName = new JLabel();
		lblName.setBounds(30, 134, 70, 20);
		lblName.setText("Name: ");
		
		text_1 = new JTextField();
		text_1.setBounds(239, 131, 220, 26);
		
		text_2 = new JTextField();
		text_2.setBounds(239, 200, 220, 26);
		
		JLabel lblStudentId = new JLabel();
		lblStudentId.setBounds(30, 206, 70, 20);
		lblStudentId.setText("Student ID");
		
		JButton btnBack = new JButton();
		
		btnBack.setBounds(418, 373, 90, 30);
		btnBack.setText("Back");

	}
}
