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

public class createPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnBack;
	private JButton btnCreate;
	private JLabel lblYourName;
	private JTextField textField_4;
	private JLabel lblSocietyCreation;

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

		lblSocietyCreation = new JLabel("Society creation");
		lblSocietyCreation.setFont(new Font("Tahoma", Font.PLAIN, 26));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addContainerGap(465, Short.MAX_VALUE)
												.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 109,
														GroupLayout.PREFERRED_SIZE)
										.addGap(52)
										.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 113,
												GroupLayout.PREFERRED_SIZE).addGap(39))
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
.addGap(51).addComponent(lblSocietyName)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(193)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblSocietyMajor)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_1,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblSocietyEmail)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_2,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(
												groupLayout.createSequentialGroup().addComponent(lblOneLineDescription)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(textField_3, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblYourName)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_4,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(391, Short.MAX_VALUE)).addGroup(
								groupLayout
										.createSequentialGroup().addGap(144).addComponent(lblSocietyCreation,
												GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(333, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
.addGap(57)
								.addComponent(lblSocietyCreation, GroupLayout.PREFERRED_SIZE, 53,
										GroupLayout.PREFERRED_SIZE)
						.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSocietyName))
				.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSocietyMajor))
				.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSocietyEmail))
				.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOneLineDescription))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYourName))
				.addPreferredGap(ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
				.addGap(56))
		);
		setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}
}
