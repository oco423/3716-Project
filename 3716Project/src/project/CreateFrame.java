package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CreateFrame extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SocietySys socList = new SocietySys();
			StudentSys stuList = new StudentSys();
			socList.loadSocietyList();
			stuList.loadStuList();
			Student stu = new Student("lucas", "cs", 20, 40056);
			CreateFrame frame = new CreateFrame(socList, stuList, stu);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public CreateFrame(final SocietySys socList, StudentSys stuList, final Student s) {  //change to not pass a Student object, when we get log in

		stuList.getStudent(s.getName()); // change when log in finished
		setTitle("Create a society");
		setBounds(100, 100, 549, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(145, 28, 189, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}

		JLabel socNamelbl = new JLabel("Society name:");
		socNamelbl.setBounds(10, 24, 99, 28);
		contentPanel.add(socNamelbl);

		JLabel emaillbl = new JLabel("Email: ");
		emaillbl.setBounds(10, 73, 99, 28);
 		contentPanel.add(emaillbl);

		JLabel majorlbl = new JLabel("Major: ");
		majorlbl.setBounds(10, 126, 99, 28);
		contentPanel.add(majorlbl);
		
		JLabel descriptlbl = new JLabel("One line description: ");
		descriptlbl.setBounds(10, 177, 125, 28);
 		contentPanel.add(descriptlbl);



		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 77, 189, 20);
		contentPanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 130, 189, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 181, 189, 20);
		contentPanel.add(textField_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						socList.loadSocietyList();
						if(textField.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter the society name", "Error", JOptionPane.ERROR_MESSAGE);
						} else if(textField_1.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter your email", "Error", JOptionPane.ERROR_MESSAGE);
						} else if(textField_2.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter a major", "Error", JOptionPane.ERROR_MESSAGE);
						} else if(textField_3.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter a 1 line description", "Error", JOptionPane.ERROR_MESSAGE);
						} else if(socList.findSociety(textField.getText())) {
							JOptionPane.showMessageDialog(null, "That Society already exists", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							Society newSociety = new Society(s, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
							socList.loadSocietyList();
							socList.addSociety(newSociety);
							socList.saveSocietyList();
							JOptionPane.showMessageDialog(null, "Society '" + textField.getText() + "' successfully created");
							setVisible(false);
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						dispose();
					}
				});
			}
		}
		}
	}

