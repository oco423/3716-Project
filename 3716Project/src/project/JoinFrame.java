package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class JoinFrame extends JFrame {
	

	private JButton jButton1;
	private JButton jButton2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JoinFrame frame = new JoinFrame();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public JoinFrame() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Join a society");
		setBounds(100, 100, 631, 381);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(394, 120, 89, 23);
		getContentPane().setLayout(null);
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(394, 188, 89, 23);
		getContentPane().add(btnNewButton_1);
		getContentPane().add(btnNewButton);
		

	}
}
