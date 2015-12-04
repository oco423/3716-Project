package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class createEventPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel lblEventCreationFor = new JLabel("Event Creation for <society name> ");
	private JTextField textField_5;
	Society s;

	public createEventPanel(final SocietySys socList, final StudentSys stuList) {


		lblEventCreationFor.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblName = new JLabel("Event Name:");

		JLabel lblDate = new JLabel("Date:");

		JLabel lblTime = new JLabel("Time:");

		JLabel lblLocation = new JLabel("Location:");

		JLabel lblPurpose = new JLabel("Purpose:");

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.socP.setVisible(true);
			}
		});

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				socList.loadSocietyList();
				stuList.loadStuList();
				Student s1 = new Student();
				if (!stuList.findStudent(textField_5.getText())) {
					JOptionPane.showMessageDialog(null, "Not a student", "Error",
						JOptionPane.ERROR_MESSAGE);
				}
				else {
					s1 = stuList.getStudent(textField_5.getText());
					if (textField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter event name", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter date", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter a time", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (textField_3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter location", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (textField_4.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter purpose of event", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						s.haveEvent(textField.getText(), textField_1.getText(), textField_2.getText(),
								textField_3.getText(), textField_4.getText());
						// s1.getBoardMemberRole(s).createEvent(s,
						// textField.getText(), textField_1.getText(),
						// textField_2.getText(), textField_3.getText(),
						// textField_4.getText());

						socList.saveSocietyList();

						repaint();
						revalidate();
						updateUI();
						testUI.mainP.repaint();
						testUI.mainP.revalidate();
						testUI.mainP.updateUI();
						testUI.joinP.repaint();
						testUI.joinP.revalidate();
						testUI.joinP.updateUI();

						JOptionPane.showMessageDialog(null, "Event '" + textField.getText() + "' successfully created");

					}
				}
			}

		});

		JLabel lblYourName = new JLabel("Your name:");

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,groupLayout.createSequentialGroup().addGap(50).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(btnCreate,GroupLayout.PREFERRED_SIZE,101,GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED,385,Short.MAX_VALUE).addComponent(btnBack,GroupLayout.PREFERRED_SIZE,91,GroupLayout.PREFERRED_SIZE).addGap(144)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblName).addComponent(lblDate).addComponent(lblTime).addComponent(lblLocation).addComponent(lblPurpose).addComponent(lblYourName)).addGap(32).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(textField_5,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE).addComponent(textField_4,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE).addComponent(textField_3,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE).addComponent(textField_2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE).addComponent(textField_1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE).addComponent(textField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)).addContainerGap(541,Short.MAX_VALUE)))).addGroup(Alignment.LEADING,groupLayout.createSequentialGroup().addGap(38).addComponent(lblEventCreationFor,GroupLayout.PREFERRED_SIZE,346,GroupLayout.PREFERRED_SIZE).addContainerGap(387,Short.MAX_VALUE)));groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(33).addComponent(lblEventCreationFor,GroupLayout.PREFERRED_SIZE,44,GroupLayout.PREFERRED_SIZE).addGap(53).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblYourName).addComponent(textField_5,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)).addGap(29).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblName).addComponent(textField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)).addGap(37).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblDate).addComponent(textField_1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)).addGap(35).addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lblTime).addComponent(textField_2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)).addGap(36).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblLocation).addComponent(textField_3,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(39).addComponent(lblPurpose)).addGroup(groupLayout.createSequentialGroup().addGap(26).addComponent(textField_4,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))).addGap(69).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnBack,GroupLayout.PREFERRED_SIZE,44,GroupLayout.PREFERRED_SIZE).addComponent(btnCreate,GroupLayout.PREFERRED_SIZE,39,GroupLayout.PREFERRED_SIZE)).addContainerGap(100,Short.MAX_VALUE)));
		setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}
}
