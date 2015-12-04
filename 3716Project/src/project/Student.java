package project;

import java.io.Serializable;

public class Student implements Serializable {
	/* includes all information about a student and the root of the execution
	 * of all methods of memberRole, boardMemberRole, and presidentRole.
	 * @author Lucas, Sam, Shehzaib, Osede
	 */
	
	//basic student information
	private String name;
	private String major;	
	private int age;
	private int sid;
	
	//student information associated with any society activity
	private memberRole memRole = null;
	private boardMemberRole boardRole = null;
	private presidentRole presRole = null;

	public Student(String name, String major, int age, int sid) {
		this.name = name;
		this.major = major;
		this.age = age;	
		this.sid = sid;
	}

	public Student() {
		this.name = null;
		this.major = null;
		this.age = 0;	
		this.sid = 0;
	}

//************ Accessors and mutators for Student information ***********


	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//************ Methods and functions for student's society activity ***********
	
	public boolean isStudent(){
		return (getSid() != 0);
	}
	
	public boolean isMember() {
		return !(memRole == null);
	}
	
	public boolean isBoardMember() {
		return !(boardRole == null);
	}
	
	public boolean isPres() {
		return !(presRole == null);
	}
	
	public void setMemberRole(memberRole memRole) {
		this.memRole = memRole;
	}
	
	/* getMemberRole is a method called every time a student attempts to do
	 * anything a member of a society can do for a particular society.
	 * memberPermissionException checks to see if that student is a member
	 * of any society, and if that student is a member of the society
	 * they are attempting to execute member functions with.
	 */
	public memberRole getMemberRole(Society s) throws MemberPermissionException{
		if (memRole == null){ throw new MemberPermissionException("Student is not a member of a society."); }
		else if (!s.getMembers().contains(this)){ throw new MemberPermissionException("Student is not a member of this society."); }
		else{
			return memRole;
		}
	}
	
	public void setBoardRole(boardMemberRole boardRole) {
		this.boardRole = boardRole;
	}
	
	/* getBoardMemberRole is a method called every time a student attempts to do
	 * anything a board member of a society can do for a particular society.
	 * memberPermissionException makes the same checks for board members (ie
	 * if that student is a board member and if they are a board member for that
	 * particular society).
	 */
	public boardMemberRole getBoardMemberRole(Society s) throws MemberPermissionException{
		if (boardRole == null){ throw new MemberPermissionException("Student is not a board member of a society."); }
		else if (!s.getBoard().contains(this)){ throw new MemberPermissionException("Student is not a board member of this society."); }
		else{	
			return boardRole;
		}
	}
	
	public void setPresRole(presidentRole presRole) {
		this.presRole = presRole;
	}
	
	/* getPresidentRole is the same as the previous two roles, except for
	 * president methods. memberPermissionException makes the same checks
	 * but for a president.
	 */
	public presidentRole getPresidentRole(Society s) throws MemberPermissionException{
		if (presRole == null){ throw new MemberPermissionException("Student is not a president of a society."); }
		else if (s.getPresident() != this){ throw new MemberPermissionException("Student is not president of this society."); }
		else{	
			
			return presRole;
		}
	}
	
}
