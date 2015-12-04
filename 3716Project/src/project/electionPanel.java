package project;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class electionPanel extends JPanel {
	
	JLabel lblElectionsFor = new JLabel("Elections for <Society name>");
	JList list = new JList();
	JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblYourName = new JLabel("Your name:");
	private JTextField textField;
	Society soc;
	private final JButton btnDecalreEligibleTo = new JButton("Declare eligible to be voted for");
	
	public electionPanel(final SocietySys socList, final StudentSys stuList) {
		socList.loadSocietyList();
		stuList.loadStuList();
		btnDecalreEligibleTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student s1 = new Student();
				String Stu = textField.getText();
				for (Student student : soc.getMembers()) {
					if (Stu.equalsIgnoreCase(student.getName())) {
						s1 = student;
						
					}			
				}
				try {
					s1.getMemberRole(soc).Declare(soc, s1);
					socList.saveSocietyList();
					stuList.saveStuList();
				} catch (MemberPermissionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		socList.loadSocietyList();
		stuList.loadStuList();

		lblElectionsFor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				testUI.socP.setVisible(true);
			}
		});
		

		
		JButton btnVote = new JButton("Vote");
		btnVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				socList.loadSocietyList();
				stuList.loadStuList();
				System.out.println(soc.getName());
				String str = (String) list.getSelectedValue();
				String Stu = textField.getText();
				Student s1 = new Student();
				Student s = soc.getStudent(str);
				
				for (Student student : soc.getMembers()) {
					if (Stu.equalsIgnoreCase(student.getName())) {
						s1 = student;
						
					}			
				}
				for (boolean b : soc.getVoted()) {
					System.out.println(b);
				}
				try {
					s1.getMemberRole(soc).vote(soc, s1, s);
					socList.saveSocietyList();
					stuList.saveStuList();
					//JOptionPane.showMessageDialog(null, "You have voted", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (MemberPermissionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				

			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(183))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnVote))
						.addComponent(lblElectionsFor, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(263, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(314, Short.MAX_VALUE)
					.addComponent(lblYourName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDecalreEligibleTo)
					.addGap(65))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblElectionsFor, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(btnBack)
							.addGap(44))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYourName)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDecalreEligibleTo))
							.addGap(71)
							.addComponent(btnVote)
							.addContainerGap())))
		);
		

		scrollPane.setViewportView(list);
		setLayout(groupLayout);

	}
}
