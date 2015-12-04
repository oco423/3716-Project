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
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap(458, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addGap(188))
				.addGroup(groupLayout.createSequentialGroup().addGap(52)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(10)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 236,
												GroupLayout.PREFERRED_SIZE)
										.addGap(54).addComponent(textArea, GroupLayout.PREFERRED_SIZE, 174,
												GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEventsPageFor, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(245, Short.MAX_VALUE)));
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
				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE).addGap(38)));


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
