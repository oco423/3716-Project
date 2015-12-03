package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

public class joinPanel extends JPanel {

	private JList list = new JList();
	public joinPanel(final SocietySys socList, StudentSys stuList, final Student stu) {



		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		socList.loadSocietyList();
		stuList.loadStuList();
		JButton joinBtn = new JButton("Join");

		JButton leaveBtn = new JButton("Leave");
		leaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = (String) list.getSelectedValue();
				Society s = socList.getSociety(str);
				if (s.isMember(stu)) {
					s.removeMember(stu);
					System.out.println(stu.getName() + " has left " + s.getName());
				}
				else {
					JOptionPane.showMessageDialog(null, stu.getName() + " is not a member of " + s.getName(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		/*
		 * leaveBtn.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * 
		 * 
		 * if (!s.isMember(stu)) JOptionPane.showMessageDialog(null,
		 * stu.getName() + " is not a member of " + s.getName(), "Error",
		 * JOptionPane.ERROR_MESSAGE); s.removeMember(stu);
		 * System.out.println(stu.getName() + " has left " + s.getName());
		 * 
		 * 
		 * } });
		 */

		JScrollPane scrollPane = new JScrollPane();

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.mainP.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(90)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(leaveBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(joinBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
				.addGap(109)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addGap(128).addComponent(joinBtn)
										.addGap(42).addComponent(leaveBtn)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup().addGap(118).addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(96, Short.MAX_VALUE)));


		scrollPane.setViewportView(list);
		DefaultListModel model = new DefaultListModel();
		for (Society s : socList.getSocietyList()) {
			model.addElement(s.getName());
		}
		list.setModel(model);
		setLayout(groupLayout);

	}
}
