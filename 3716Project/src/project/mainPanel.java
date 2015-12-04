package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class mainPanel extends JPanel {

	JButton joinButton = new JButton("Join Society");
	JButton createButton = new JButton("Create Society");



	public mainPanel(final SocietySys socList, StudentSys stuList, Student stu) {


		socList.loadSocietyList();
		stuList.loadStuList();

		JLabel welcomeLabel = new JLabel("Welcome to the Memorial University Society System");
		welcomeLabel.setBounds(10, 34, 682, 32);
		welcomeLabel.setForeground(new Color(128, 0, 0));
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 26));


		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				socList.loadSocietyList();
				setVisible(false);
				testUI.joinP.setVisible(true);
				DefaultListModel model1 = new DefaultListModel();
				for (Society s : socList.getSocietyList()) {
					model1.addElement(s.getName());
				}
				testUI.joinP.list.setModel(model1);
				testUI.joinP.scrollPane.repaint();
				testUI.joinP.scrollPane.revalidate();
				testUI.joinP.list.repaint();
				testUI.joinP.list.revalidate();

			}
		});
		joinButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		joinButton.setBounds(631, 338, 180, 80);
		this.add(joinButton);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.createP.setVisible(true);
				testUI.joinP.list.repaint();
				testUI.joinP.list.revalidate();
				testUI.joinP.list.updateUI();
			}
		});


		createButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createButton.setBounds(631, 232, 180, 80);
		this.add(createButton);



		JButton btnCreateAStudent = new JButton("Create a student");
		btnCreateAStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.stuP.setVisible(true);

			}
		});
		btnCreateAStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup().addGap(154)
										.addComponent(createButton, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE)
										.addGap(113).addComponent(joinButton, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup().addGap(71).addComponent(welcomeLabel))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btnCreateAStudent,
								GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(90, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
.addGap(73).addComponent(welcomeLabel)
								.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(createButton, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(joinButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
				.addGap(111).addComponent(btnCreateAStudent, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
				.addGap(78)));
		setLayout(groupLayout);



	}
}
