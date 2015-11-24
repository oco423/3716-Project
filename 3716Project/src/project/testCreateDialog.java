package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class testCreateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			testCreateDialog dialog = new testCreateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public testCreateDialog() {
		setTitle("Create a society");
		setBounds(100, 100, 549, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(92, 28, 189, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}

		JLabel lblNewLabel = new JLabel("Society name:");
		lblNewLabel.setBounds(10, 24, 99, 28);
		contentPanel.add(lblNewLabel);

		JLabel lblSocietyThing = new JLabel("Society thing 2");
		lblSocietyThing.setBounds(10, 73, 99, 28);
		contentPanel.add(lblSocietyThing);

		JLabel lblSocietyThing_1 = new JLabel("Society thing 3");
		lblSocietyThing_1.setBounds(10, 126, 99, 28);
		contentPanel.add(lblSocietyThing_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(92, 77, 189, 20);
		contentPanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 130, 189, 20);
		contentPanel.add(textField_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
						dispose();
					}
				});
			}
		}
		}
	}

