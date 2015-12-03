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
				//socList.loadSocietyList();
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
				} else {
					Society newSociety = new Society(stuList.getStuLoggedIn(), textField.getText(),
							textField_1.getText(),
							textField_2.getText(), textField_3.getText());
					//socList.loadSocietyList();
					socList.addSociety(newSociety);
					socList.saveSocietyList();
					JOptionPane.showMessageDialog(null, "Society '" + textField.getText() + "' successfully created");
					setVisible(false);
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(51)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblOneLineDescription)
						.addComponent(lblSocietyEmail).addComponent(lblSocietyMajor).addComponent(lblSocietyName))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(211, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(256, Short.MAX_VALUE).addComponent(btnBack)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCreate)
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(62)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSocietyName).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(32)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSocietyMajor)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(37)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSocietyEmail)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(36)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblOneLineDescription)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnBack)
						.addComponent(btnCreate))
				.addContainerGap(12, Short.MAX_VALUE)));
		setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}
}
