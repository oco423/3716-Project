package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class eventPanel extends JPanel {
	JLabel lblEventsPageFor = new JLabel("Events Page for <Society name>");
	JList list = new JList();
	JTextArea textArea = new JTextArea();
	Society s;
	private final JButton btnNewButton_1 = new JButton("Create Event");
	public eventPanel(SocietySys socList, StudentSys stuList) {
		socList.loadSocietyList();
		stuList.loadStuList();


		lblEventsPageFor.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.socP.setVisible(true);
				textArea.setText("");
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		
		textArea.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(52)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(10)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 236,
												GroupLayout.PREFERRED_SIZE)
										.addGap(54).addComponent(textArea, GroupLayout.PREFERRED_SIZE, 174,
												GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEventsPageFor, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(245, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addGap(116)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 112,
										GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGap(164)));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.createEP.setVisible(true);
				testUI.createEP.s = s;
			}
		});
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(24)
										.addComponent(lblEventsPageFor, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
.addGap(18)
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 346,
														Short.MAX_VALUE)
												.addGap(65))
						.addGroup(groupLayout.createSequentialGroup()
.addGap(80)
										.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 163,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
				.addGap(2)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)).addGap(36)));


		scrollPane.setViewportView(list);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {

					for (Event e : s.upcomingEvents()) {
						if (e.getName().equalsIgnoreCase((String) list.getSelectedValue()))
							textArea.setText(e.getPurpose());
					}
				}
			}
		});

		setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}
}
