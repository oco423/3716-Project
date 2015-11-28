/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.ListSelectionModel;
import java.awt.Component;
/**
 *
 * @author Lucas
 */
public class testUI extends JFrame {

	/**
	 * Creates new form testUI
	 */

	public testUI(SocietySys societyManager, StudentSys studentManager) {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		setResizable(false);
		new JPopupMenu();
		jMenuItem1 = new JMenuItem();
		new JCheckBoxMenuItem();
		jLabel1 = new JLabel();
		jScrollPane1 = new JScrollPane();
		jList1 = new JList<>();

		jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList1.setValueIsAdjusting(true);
		jButton1 = new JButton();
		jButton2 = new JButton();
		jLabel2 = new JLabel();
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenu2 = new JMenu();
		joinFrame = new JoinFrame();
		SocietySys socList = new SocietySys();
		StudentSys stuList = new StudentSys();
		socList.loadSocietyList();
		stuList.loadStuList();
		Student stu = new Student("Lucas", "cs", 20, 40056);		
		createFrame = new CreateFrame(socList, stuList, stu);

		jMenuItem1.setText("jMenuItem1");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(153, 0, 0));
		jLabel1.setText("Welcome to the Memorial University Society System");

		jList1.setFont(new java.awt.Font("Tahoma", 0, 24));
		
		DefaultListModel model = new DefaultListModel();
		for (Society s : socList.getSocietyList()) {
			if (s.isMember(stu))
				model.addElement(s.getName());
		}
		jList1.setModel(model);
		
		jList1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {

		        	//what happens when list item is clicked??
		            System.out.println("Double clicked on: " + list.getSelectedValue());
		        }
		    }
		});
		
		
		jScrollPane1.setViewportView(jList1);

		jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jButton1.setText("Create a society");
		jButton1.setToolTipText("");
		jButton1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				jButton1MousePressed(evt);
			}
		});
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jButton2.setText("Join a society");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
		jLabel2.setText("My Societies");

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(26, 26, 26)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jScrollPane1)
										.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jButton2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 174,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 174,
										GroupLayout.PREFERRED_SIZE))
						.addGap(171, 171, 171))
				.addGroup(layout
						.createSequentialGroup().addContainerGap().addComponent(jLabel1,
 GroupLayout.PREFERRED_SIZE, 966, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(162, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(79, 79, 79)
										.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 102,
												GroupLayout.PREFERRED_SIZE)
										.addGap(42, 42, 42)
										.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 102,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51,
												Short.MAX_VALUE)
										.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 391,
												GroupLayout.PREFERRED_SIZE)
										.addGap(21, 21, 21)))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		joinFrame.setVisible(true);
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jMenuItem1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jMenuItem1ActionPerformed

	private void jButton1MousePressed(MouseEvent evt) {// GEN-FIRST:event_jButton1MousePressed

	}// GEN-LAST:event_jButton1MousePressed

	private void jButton1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		createFrame.setVisible(true);
	}// GEN-LAST:event_jButton1ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(testUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(testUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(testUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(testUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				SocietySys socList = new SocietySys();
				StudentSys stuList = new StudentSys();
				socList.loadSocietyList();
				stuList.loadStuList();
				new testUI(socList, stuList).setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables

	public static Student user;
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JList<String> jList1;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem1;
	private JScrollPane jScrollPane1;
	private JoinFrame joinFrame;
	private CreateFrame createFrame;
}

