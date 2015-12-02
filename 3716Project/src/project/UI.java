package project;

import java.awt.EventQueue;

public class UI {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				StudentSys studentManager = new StudentSys();
				SocietySys societyManager = new SocietySys();
				try {

					societyManager.loadSocietyList();
					studentManager.loadStuList();

					testUI frame = new testUI(societyManager, studentManager);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

