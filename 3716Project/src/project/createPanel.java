package project;

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

public class createPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnBack;
	private JButton btnCreate;
	private JLabel lblYourName;
	private JTextField textField_4;

	public createPanel(final SocietySys socList, final StudentSys stuList, Student stu) {

		socList.loadSocietyList();
		JLabel lblSocietyName = new JLabel("Society name:");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblSocietyMajor = new JLabel("Society major:");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lblSocietyEmail = new JLabel("Society email:");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel lblOneLineDescription = new JLabel("One line description:");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.mainP.setVisible(true);
			}
		});

		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				socList.loadSocietyList();
				Student s1 = new Student();
				if (!stuList.findStudent(textField_4.getText())) {
					JOptionPane.showMessageDialog(null, "Not a student", "Error",
						JOptionPane.ERROR_MESSAGE);
				}
				else {
					s1 = stuList.getStudent(textField_4.getText());
					if (textField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter the society name", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter your email", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter a major", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (textField_3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter a 1 line description", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (socList.findSociety(textField.getText())) {
						JOptionPane.showMessageDialog(null, "That Society already exists", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!stuList.findStudent(textField_4.getText())) {
						JOptionPane.showMessageDialog(null, "Not a student", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Society newSociety = new Society(s1, textField.getText(),
						textField_1.getText(),
						textField_2.getText(), textField_3.getText());
						socList.addSociety(newSociety);
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
						JOptionPane.showMessageDialog(null, "Society '" + textField.getText() + "' successfully created");
						testUI.joinP.list.updateUI();
						setVisible(false);
					}
				}
			}
		});
		
		lblYourName = new JLabel("Your name: ");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOneLineDescription)
						.addComponent(lblSocietyEmail)
						.addComponent(lblSocietyMajor)
						.addComponent(lblSocietyName)
						.addComponent(lblYourName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
							.addComponent(btnBack)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCreate))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSocietyName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSocietyMajor)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSocietyEmail)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOneLineDescription)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnCreate)
						.addComponent(lblYourName)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}
}
