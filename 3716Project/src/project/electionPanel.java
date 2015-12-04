package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class electionPanel extends JPanel {
	
	JLabel lblElectionsFor = new JLabel("Elections for <Society name>");
	JList list = new JList();
	JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblYourName = new JLabel("Your name:");
	private JTextField textField;
	Society soc;
	private final JButton btnDecalreEligibleTo = new JButton("Declare eligible to be voted for");
	private final JLabel lblMemberList = new JLabel("Member List");
	
	public electionPanel(final SocietySys socList, final StudentSys stuList) {
		lblMemberList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		socList.loadSocietyList();
		stuList.loadStuList();
		btnDecalreEligibleTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDecalreEligibleTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
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

							e.printStackTrace();
						}
				
					}
				}
			});
		
		socList.loadSocietyList();
		stuList.loadStuList();

		lblElectionsFor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				testUI.socP.setVisible(true);
				socList.loadSocietyList();
				testUI.socP.lblIsThePresident.setText(soc.getPresident().getName() + " is the president");
			}
		});
		

		
		JButton btnVote = new JButton("Vote");
		btnVote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
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

					} catch (MemberPermissionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Hold Election");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					soc.haveElection();

					socList.saveSocietyList();
					socList.loadSocietyList();
				} catch (MemberPermissionException e1) {

					e1.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(68)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE).addGap(273)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE).addGap(99))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
.addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 167,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnVote, GroupLayout.PREFERRED_SIZE, 94,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblElectionsFor, GroupLayout.PREFERRED_SIZE, 313,
										GroupLayout.PREFERRED_SIZE))
								.addContainerGap(346, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblMemberList, GroupLayout.PREFERRED_SIZE, 136,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 227, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
.addComponent(lblYourName)
										.addPreferredGap(ComponentPlacement.UNRELATED)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 131,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDecalreEligibleTo))
								.addGap(117))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblElectionsFor, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblMemberList, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblYourName, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDecalreEligibleTo)
								.addGap(101)
								.addComponent(btnVote, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
				.addGap(31))
		);
		

		scrollPane.setViewportView(list);
		setLayout(groupLayout);

	}
}
