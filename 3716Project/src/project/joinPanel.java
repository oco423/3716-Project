package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
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
import javax.swing.ListSelectionModel;

public class joinPanel extends JPanel {

	JList list = new JList();
	JScrollPane scrollPane = new JScrollPane();
	private JTextField textField;
	DefaultListModel model = new DefaultListModel();
	public joinPanel(final SocietySys socList, final StudentSys stuList, final Student stu) {



		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		socList.loadSocietyList();
		stuList.loadStuList();
		JButton joinBtn = new JButton("Join");
		joinBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your name", "Error",
								JOptionPane.ERROR_MESSAGE);
				} else {
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
			}
		});
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList listt = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {

		            // Double-click detected
		            int index = listt.locationToIndex(evt.getPoint());
		            setVisible(false);
		            testUI.socP.setVisible(true);
		            testUI.socP.setSociety(socList.getSociety((String) listt.getSelectedValue()));
					DefaultListModel model = new DefaultListModel();
					for (Student s : (testUI.socP.s.getMembers())) {
						model.addElement(s.getName());
					}
					testUI.socP.list.setModel(model);

		           // testUI.socP.s = socList.getSociety((String) listt.getSelectedValue());
		            testUI.socP.label.setText(testUI.socP.s.getName());
		            testUI.socP.label_1.setText(testUI.socP.s.getDescription());
		            testUI.socP.label_2.setText(testUI.socP.s.getContact());
		            testUI.socP.lblNewLabel.setText(testUI.socP.s.getMajor());
		            testUI.socP.repaint();
		            testUI.socP.revalidate();
					testUI.socP.updateUI();
				}
		     
		    }
		});

		JButton leaveBtn = new JButton("Leave");
		leaveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		leaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your name", "Error",
								JOptionPane.ERROR_MESSAGE);
				} else {
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
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String str = (String) list.getSelectedValue();
				String Stu = textField.getText();
				Society s = socList.getSociety(str);
				socList.deleteSociety(s);
				DefaultListModel model1 = new DefaultListModel();
				for (Society soc : socList.getSocietyList()) {
					model1.addElement(soc.getName());
				}
				testUI.joinP.list.setModel(model1);
				System.out.println(s.getName() + " deleted");
				
			}
		});

		JLabel lblDoubleClickOn = new JLabel("Double click on an item to view it in detail");

		JLabel lblSocieties = new JLabel("Societies");
		lblSocieties.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSocieties, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDoubleClickOn))
				.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 146,
												GroupLayout.PREFERRED_SIZE)
										.addGap(304))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(joinBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(leaveBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176,
												Short.MAX_VALUE))
								.addContainerGap(296, Short.MAX_VALUE))))
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addContainerGap(631, Short.MAX_VALUE).addComponent(btnBack,
												GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addGap(108))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addGap(92)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 31,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(joinBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(leaveBtn, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(17))
						.addGroup(groupLayout.createSequentialGroup().addGap(101).addComponent(lblSocieties)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
.addComponent(lblDoubleClickOn)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);


		scrollPane.setViewportView(list);

		setLayout(groupLayout);

	}
}
