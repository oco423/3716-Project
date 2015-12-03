package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class loginPanel extends JPanel {
	private JTextField textField;

	public loginPanel(SocietySys socList, final StudentSys stuList) {

		JLabel lblEnerYourFull = new JLabel("Ener your full name to log in:");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Student s : stuList.getStuList()) {
					if (s.getName().equalsIgnoreCase(textField.getText())) {
						stuList.setStuLoggedIn(s);
						setVisible(false);
						testUI.mainP.setVisible(true);
						testUI.mainP.list.revalidate();
						testUI.mainP.list.repaint();

					}
				}


			}
		});

		JLabel lblDontHaveAn = new JLabel("Don't have an account?");

		JButton btnClickHere = new JButton("Click here");

		JLabel lblMemorialUniversitySociety = new JLabel("Memorial University Society Sysem Log in");
		lblMemorialUniversitySociety.setForeground(new Color(128, 0, 0));
		lblMemorialUniversitySociety.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(141).addComponent(btnLogIn))
						.addGroup(groupLayout.createSequentialGroup().addGap(113).addComponent(lblEnerYourFull)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(481, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(569, Short.MAX_VALUE)
								.addComponent(lblDontHaveAn).addGap(190))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(646, Short.MAX_VALUE)
								.addComponent(btnClickHere).addGap(137))
				.addGroup(groupLayout
						.createSequentialGroup().addGap(86).addComponent(lblMemorialUniversitySociety,
								GroupLayout.PREFERRED_SIZE, 636, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(150, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(38)
						.addComponent(lblMemorialUniversitySociety, GroupLayout.PREFERRED_SIZE, 106,
								GroupLayout.PREFERRED_SIZE)
				.addGap(60)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblEnerYourFull)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnLogIn).addGap(18).addComponent(lblDontHaveAn)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnClickHere)
						.addContainerGap(316, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}

}
