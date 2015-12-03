package project;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class mainPanel extends JPanel {

	JButton joinButton = new JButton("Join Society");
	JButton createButton = new JButton("Create Society");
	DefaultListModel model = new DefaultListModel();
	JScrollPane scrollPane = new JScrollPane();
	JList list = new JList();


	public mainPanel(final SocietySys socList, StudentSys stuList, Student stu) {


		socList.loadSocietyList();
		stuList.loadStuList();

		JLabel welcomeLabel = new JLabel("Welcome to the Memorial University Society System");
		welcomeLabel.setBounds(10, 34, 682, 32);
		welcomeLabel.setForeground(new Color(128, 0, 0));
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 26));


		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.joinP.setVisible(true);
			}
		});
		joinButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		joinButton.setBounds(631, 338, 180, 80);
		this.add(joinButton);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.createP.setVisible(true);
			}
		});


		createButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createButton.setBounds(631, 232, 180, 80);
		this.add(createButton);

		

		scrollPane.setBounds(54, 232, 195, 327);
		this.add(scrollPane);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		scrollPane.setViewportView(list);

		for (Society s : socList.getSocietyList()) {
			if (s.isMember(stu))
				model.addElement(s.getName());
		}
		list.setModel(model);
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList listt = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {

		            // Double-click detected
		        	Society soc = new Society();
		            int index = listt.locationToIndex(evt.getPoint());
		            setVisible(false);
		            testUI.socP.setVisible(true);
		            testUI.socP.label.setText((String) listt.getSelectedValue());
		        } else if (evt.getClickCount() == 3) {

		            // Triple-click detected
		            int index = listt.locationToIndex(evt.getPoint());
		        }
		    }
		});
		
		JLabel lblMySocieties = new JLabel("My Societies");
		lblMySocieties.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMySocieties.setBounds(54, 189, 156, 32);
		this.add(lblMySocieties);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(welcomeLabel))
				.addGroup(groupLayout.createSequentialGroup().addGap(54).addComponent(lblMySocieties,
						GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
				.addGroup(
						groupLayout.createSequentialGroup().addGap(54)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addGap(382)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(createButton, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(joinButton, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(11).addComponent(welcomeLabel).addGap(146)
						.addComponent(lblMySocieties, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(createButton, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(joinButton, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE)))));
		setLayout(groupLayout);



	}


}
