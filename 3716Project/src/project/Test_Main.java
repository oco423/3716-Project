
package project;


import java.util.ArrayList;


public class Test_Main{
	/* a console-focused testing class. Can be edited a number of ways to test the basic
	 * methods of society and the various roles.
	 * @author everyone
	 * 
	 * in its current state, this tester will run and the following will occur:
	 * 4 students will be created, based upon the 4 members of our group.
	 * soc1, a new society, will be created. stu1 is the creator (president)
	 * and all other students are added to it.
	 * stu4 is appointed to the board of soc1 by stu1
	 * all students declare themselves eligible except for stu2.
	 * stu2 attempts to vote for themselves and gets an error because of
	 * his eligibility.
	 * all students vote.
	 * stu4 withdraws his candidacy and stu2 declares his.
	 * stu2 votes for himself. stu3 attempts to vote again and is given an error
	 * because you may only vote once per electon.
	 * an election is called and stu3 is now the president of soc1.
	 * 2 meetings and 1 event are created by stu3 and stu4. one is cancelled.
	 * all the students are saved to the file.
	 * a second society is created and both are save to that file.
	 */
	
	public static void main(String[] args) throws MemberPermissionException{
		
		/*Scanner s = new Scanner(new File(  PATH TO FILE  ));
		SocietySys socList = new SocietySys();
		while (s.hasNextLine()){
			socList.addSociety(s.nextLine());
		} */

		SocietySys socList = new SocietySys();
		String name;
		int id;
		name = "Lucas";
		id = 40056;
		String major = "Computer Science";
		int age = 20;
		Student stu1 = new Student(name, major, age, id);
		Student stu2 = new Student("Sam", "Computer Science", 21, 4356);
		Society soc1 = new Society(stu1, "earth science club", "testing", "testing", "testing");
		Student stu4 = new Student("Shehzaib", "Computer Science", 20, 37373);
		
		//Society soc2 = new Society(stu2, "cs club", "testing", "testing", "testing");
		Student stu3 = new Student("Osede", "Computer Science", 21, 45356);
		soc1.addMember(stu2);
		soc1.addMember(stu3);
		soc1.addMember(stu4);
		
		soc1.showMembers();
		System.out.println("Is " + stu2.getName() + " a member of " + soc1.getName() + " ? " + soc1.isMember(stu2));
		
		stu1.getPresidentRole(soc1).Appoint(stu4, soc1);
		stu1.getMemberRole(soc1).Declare(soc1, stu1);
		//stu2.getMemberRole(soc1).Declare();
		stu3.getMemberRole(soc1).Declare(soc1, stu3);
		stu4.getMemberRole(soc1).Declare(soc1, stu4);
		stu1.getMemberRole(soc1).vote(soc1, stu1, stu3);
		stu2.getMemberRole(soc1).vote(soc1, stu2, stu2);
		stu3.getMemberRole(soc1).vote(soc1, stu3, stu3);
		stu4.getMemberRole(soc1).vote(soc1, stu4, stu3);
		soc1.showBallot();
		stu4.getMemberRole(soc1).Withdraw(soc1, stu4);
		stu2.getMemberRole(soc1).Declare(soc1, stu2);
		stu2.getMemberRole(soc1).vote(soc1, stu2, stu2);
		stu3.getMemberRole(soc1).vote(soc1, stu3, stu2);
		soc1.showBallot();
		soc1.showVoted();
		soc1.showVotes();
		stu1.getPresidentRole(soc1).callElection(soc1);
		
		stu3.getBoardMemberRole(soc1).callMeeting(soc1, "December 4th", "9:00AM", "EN-2036", "Project presentation.");
		stu4.getBoardMemberRole(soc1).createEvent(soc1, "Snowstorm!", "December 4th", "7:00AM", "at home", "go back to bed!");
		stu3.getBoardMemberRole(soc1).callMeeting(soc1, "December 5th", "8:00AM", "EN-2006", "Project presentation.");
		soc1.cancelMeeting("december 5th", "8:00AM", "EN-2006");
		for (Meeting x : soc1.upcomingMeetings()){
			System.out.println(x.getDate() + ", at " + x.getTime() + ", in " + x.getLocation() + ", for " + x.getPurpose());
		}
		for (Event x : soc1.upcomingEvents()){
			System.out.println(x.getDate() + ", we are having " + x.getName() + ", at " + x.getTime() + ", in " + x.getLocation() + ", for " + x.getPurpose());
		}
		
		
		
		
		System.out.println(soc1.getName());
		//System.out.println(soc1.getPresident().getName());
		
		/*stu1.getPresidentRole(soc1).setSocietyFee(soc1, 54367);
		System.out.println(soc1.getFee());
		
		System.out.println(stu1.getMajor());
		
		stu3.getMemberRole(soc1).Promote(soc1);
		

		// stu1.getBoardMemberRole(soc1).callMeeting(soc1, "November 21", "7:50
		// pm", "EN 2036", "Project Discussion");

		
		stu1.getMemberRole(soc1).Promote(soc1);
		System.out.println(stu3.isBoardMember());
		
		stu1.getPresidentRole(soc1).Appoint(stu3, soc1);
		//stu2.getPresidentRole(soc2).Appoint(stu3, soc2);
		
		System.out.println(stu3.isBoardMember());

		socList.loadSocietyList();
		
		//socList.addSociety(soc2);*/
		socList.addSociety(soc1);
		socList.saveSocietyList();
		
		StudentSys stuList = new StudentSys();
		stuList.addStudent(stu1);
		stuList.addStudent(stu2);
		stuList.addStudent(stu3);
		stuList.addStudent(stu4);
		stuList.saveStuList();
		Society soc3 = new Society(stu3, "tester society", "email", "major", "descript");
		socList.addSociety(soc3);
		ArrayList <Society> list = new ArrayList<Society>(socList.getSocietyList());
		for (Society s : list) {
			System.out.println(s.getName());
		}
		
		socList.saveSocietyList();
		//socList.loadSocietyList();
		
		for (Society s : list) {
			System.out.println(s.getName());
		}
		
		socList.loadSocietyList();
		
		
		
		//System.out.println(socList.getSociety("cs club").isMember(stu3));
		

	}
}