package project;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class socPanel extends JPanel{
	
	Society s;
	JLabel label = new JLabel("<Society name>");
	JLabel label_1 = new JLabel("<description>");
	
	public socPanel(SocietySys socList, StudentSys stuList, Student stu) {
		socList.loadSocietyList();
		stuList.loadStuList();
		for (Society soc : socList.getSocietyList()) {
			if (soc.getName().equalsIgnoreCase(label.getText())) {
				s = soc;
				testUI.socP.label_1.setText(s.getDescription());
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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnViewElectionStuff)
							.addPreferredGap(ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
							.addComponent(btnBack)
							.addGap(99))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(353, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(137)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(329, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnViewElectionStuff))
					.addGap(71))
		);
		setLayout(groupLayout);
	}
	
	public Society getSociety() {
		return s;
	}
	public void setSociety(Society soc) {
		s = soc;
	}
}
