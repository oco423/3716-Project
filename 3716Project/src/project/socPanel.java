package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class socPanel extends JPanel{
	
	JList list = new JList();
	Society s;
	JLabel label = new JLabel("<Society name>");
	JLabel label_1 = new JLabel("<description>");
	JLabel label_2 = new JLabel("<contact info>");
	JLabel lblNewLabel = new JLabel("<major>");
	
	public socPanel(SocietySys socList, StudentSys stuList, Student stu) {
		socList.loadSocietyList();
		stuList.loadStuList();
		for (Society soc : socList.getSocietyList()) {
			if (soc.getName().equalsIgnoreCase(label.getText())) {
				s = soc;

				repaint();
				revalidate();
				updateUI();
			}
			//else { 
			//	JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
			//}
		
		}
		
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.joinP.setVisible(true);
			}
		});
		
		JButton btnViewElectionStuff = new JButton("View Election Stuff");
		btnViewElectionStuff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				testUI.elecP.setVisible(true);
				testUI.elecP.lblElectionsFor.setText("Elections for " + testUI.socP.getSociety().getName());
				DefaultListModel model = new DefaultListModel();
				for (Student s : (testUI.socP.s.getMembers())) {
					model.addElement(s.getName());
				}
				testUI.elecP.list.setModel(model);
				testUI.elecP.soc = testUI.socP.getSociety();
			}
		});
		
		

		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblMemberList = new JLabel("Member List");
		lblMemberList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(115)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(47)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMemberList, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(btnViewElectionStuff, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
					.addGap(96))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(144))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMemberList)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addGap(78)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnViewElectionStuff, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(42))
		);
		


		scrollPane.setViewportView(list);
		setLayout(groupLayout);
	}
	
	public Society getSociety() {
		return s;
	}
	public void setSociety(Society soc) {
		s = soc;
	}
}
