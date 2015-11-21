
package project;
public class Test_Main{
	public static void main(String[] args) throws MemberPermissionException{
		String name;
		int id;
		name = "Lucas";
		id = 40056;
		String major = "CS";
		int age = 20;
		Student stu1 = new Student(name, major, age, id);
		Student stu2 = new Student("Sam", "test_major", 21, 4356);
		Society soc1 = new Society(stu1, "testing", "testing", "testing", "testing");
		Student stu3 = new Student("Osede", "major_3", 21, 45356);
		soc1.addMember(stu1);
		soc1.addMember(stu3);
		//soc1.addMember(stu2);
		soc1.showMembers();
		System.out.println("Is " + stu2.getName() + " a member of " + soc1.getName() + " ?" + soc1.isMember(stu2));
		
		
		System.out.println(soc1.getName());
		//System.out.println(soc1.getPresident().getName());
		
		stu1.getPresidentRole(soc1).setSocietyFee(soc1, 54367);
		System.out.println(soc1.getFee());
		
		System.out.println(stu1.getMajor());
		
		stu3.getMemberRole(soc1).Promote(soc1);
		
		stu1.getBoardMemberRole(soc1).callMeeting(soc1, "November 21", "7:50 pm", "EN 2036", "Project Discussion");
		stu1.getMemberRole(soc1).Promote(soc1);
	}
}