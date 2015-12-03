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
import javax.swing.JLabel;
import javax.swing.JTextField;

public class joinPanel extends JPanel {

	private JList list = new JList();
	private JTextField textField;
	public joinPanel(final SocietySys socList, final StudentSys stuList, final Student stu) {



		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		socList.loadSocietyList();
		stuList.loadStuList();
		JButton joinBtn = new JButton("Join");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = (String) list.getSelectedValue();
				String Stu = textField.getText();
				Student s1 = new Student();
				Society s = socList.getSociety(str);
				for (Student student : stuList.getStuList()) {
					if (Stu.equalsIgnoreCase(student.getName())) {
						s1 = student;
						
					}			
				}
				if (!s.isMember(s1)) {
					s.addMember(s1);
					System.out.println(s1.getName() + " has joined " + s.getName());
					stuList.saveStuList();
					socList.saveSocietyList();
					repaint();
					revalidate();
					updateUI();
					testUI.mainP.repaint();
					testUI.mainP.revalidate();
					testUI.mainP.updateUI();
				}
				else {
					JOptionPane.showMessageDialog(null, s1.getName() + " is already a member of " + s.getName(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}			
			}
		});

		JButton leaveBtn = new JButton("Leave");
		leaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = (String) list.getSelectedValue();
				String Stu = textField.getText();
				Student s1 = new Student();
				Society s = socList.getSociety(str);
				for (Student student : stuList.getStuList()) {
					if (Stu.equalsIgnoreCase(student.getName())) {
						s1 = student;	
					}				
				}
				if (s.isMember(s1)) {
					s.removeMember(s1);
					System.out.println(s1.getName() + " has left " + s.getName());
					stuList.saveStuList();
					socList.saveSocietyList();
					repaint();
					revalidate();
					updateUI();
					testUI.mainP.repaint();
					testUI.mainP.revalidate();
					testUI.mainP.updateUI();
				}
				else {
					JOptionPane.showMessageDialog(null, s1.getName() + " is not a member of " + s.getName(), "Error",
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
				socList.saveSocietyList();
				repaint();
				revalidate();
				updateUI();
				testUI.mainP.repaint();
				testUI.mainP.revalidate();
				testUI.mainP.updateUI();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Your name:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String str = (String) list.getSelectedValue();
				String Stu = textField.getText();
				Society s = socList.getSociety(str);
				socList.deleteSociety(s);
				System.out.println(s.getName() + " deleted");
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(leaveBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(joinBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
					.addGap(109))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(138)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(212, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(128)
							.addComponent(joinBtn)
							.addGap(42)
							.addComponent(leaveBtn)
							.addGap(34)
							.addComponent(btnDelete)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(92, Short.MAX_VALUE))
		);


		scrollPane.setViewportView(list);
		DefaultListModel model = new DefaultListModel();
		for (Society s : socList.getSocietyList()) {
			model.addElement(s.getName());
		}
		list.setModel(model);
		setLayout(groupLayout);

	}
}
