package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class stuCreatePanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public stuCreatePanel(final SocietySys socList, final StudentSys stuList) {

		JLabel lblStudentCreation = new JLabel("Student Creation");
		lblStudentCreation.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				testUI.mainP.setVisible(true);
			}
		});
		
		JLabel lblStudentName = new JLabel("Student name:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblMajor = new JLabel("Major:");
		
		JLabel lblAge = new JLabel("Age:");
		
		JLabel lblStudentId = new JLabel("Student ID:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Create");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stuList.loadStuList();

					if (textField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter a name", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter your major", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter your age", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (textField_3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter your student ID", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (stuList.findStudent(textField.getText())) {
						JOptionPane.showMessageDialog(null, "That Society already exists", "Error",
								JOptionPane.ERROR_MESSAGE);
					}  else {
					Student s1 = new Student(textField.getText(), textField_1.getText(),
							Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()));
					stuList.addStudent(s1);
					stuList.saveStuList();
						repaint();
						revalidate();
						updateUI();
						testUI.mainP.repaint();
						testUI.mainP.revalidate();
						testUI.mainP.updateUI();
						testUI.joinP.repaint();
						testUI.joinP.revalidate();
						testUI.joinP.updateUI();
					JOptionPane.showMessageDialog(null, "Student '" + textField.getText() + "' successfully created");
						testUI.joinP.list.updateUI();
						setVisible(false);
					}

			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(56).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblStudentCreation,GroupLayout.PREFERRED_SIZE,164,GroupLayout.PREFERRED_SIZE).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblStudentName).addComponent(lblMajor).addComponent(lblAge).addComponent(lblStudentId)).addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(textField_3,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE).addComponent(textField_2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE).addComponent(textField_1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE).addComponent(textField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)))).addContainerGap(489,Short.MAX_VALUE)).addGroup(Alignment.TRAILING,groupLayout.createSequentialGroup().addContainerGap(391,Short.MAX_VALUE).addComponent(btnNewButton,GroupLayout.PREFERRED_SIZE,115,GroupLayout.PREFERRED_SIZE).addGap(27).addComponent(btnNewButton_1,GroupLayout.PREFERRED_SIZE,117,GroupLayout.PREFERRED_SIZE).addGap(70)));groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(47).addComponent(lblStudentCreation,GroupLayout.PREFERRED_SIZE,44,GroupLayout.PREFERRED_SIZE).addGap(71).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblStudentName).addComponent(textField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)).addGap(39).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(textField_1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE).addGroup(groupLayout.createSequentialGroup().addComponent(lblMajor).addGap(49).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblAge).addComponent(textField_2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)).addGap(46).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblStudentId).addComponent(textField_3,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)).addGap(117).addGroup(groupLayout.createParallelGroup(Alignment.LEADING,false).addComponent(btnNewButton_1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE).addComponent(btnNewButton,GroupLayout.DEFAULT_SIZE,44,Short.MAX_VALUE)))).addGap(61)));
		setLayout(groupLayout);

	}
}
