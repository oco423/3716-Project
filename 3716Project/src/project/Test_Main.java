
package project;


import java.util.ArrayList;


public class Test_Main{
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
		Student stu2 = new Student("Sam", "Computer Sciencer", 21, 4356);
		Society soc1 = new Society(stu1, "earth science club", "testing", "testing", "testing");
		Student stu4 = new Student("Kelsi", "Psychology", 19, 37373);
		
		Society soc2 = new Society(stu2, "cs club", "testing", "testing", "testing");
		Student stu3 = new Student("Osede", "Computer Science", 21, 45356);
		soc1.addMember(stu2);
		soc1.addMember(stu3);
		soc2.addMember(stu4);
		
		soc1.showMembers();
		System.out.println("Is " + stu2.getName() + " a member of " + soc1.getName() + " ? " + soc1.isMember(stu2));
		
		
		System.out.println(soc1.getName());
		//System.out.println(soc1.getPresident().getName());
		
		stu1.getPresidentRole(soc1).setSocietyFee(soc1, 54367);
		System.out.println(soc1.getFee());
		
		System.out.println(stu1.getMajor());
		
		stu3.getMemberRole(soc1).Promote(soc1);
		

		// stu1.getBoardMemberRole(soc1).callMeeting(soc1, "November 21", "7:50
		// pm", "EN 2036", "Project Discussion");

		
		stu1.getMemberRole(soc1).Promote(soc1);
		System.out.println(stu3.isBoardMember());
		
		stu1.getPresidentRole(soc1).Appoint(stu3, soc1);
		stu2.getPresidentRole(soc2).Appoint(stu3, soc2);
		
		System.out.println(stu3.isBoardMember());

		socList.loadSocietyList();
		
		socList.addSociety(soc2);
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
		socList.loadSocietyList();
		
		for (Society s : list) {
			System.out.println(s.getName());
		}
		
		//socList.loadSocietyList();
		
		
		
		//System.out.println(socList.getSociety("cs club").isMember(stu3));


	}
}