
package project;

import java.io.Serializable;

public class Student implements Serializable {
	
	private String name;
	private String major;	
	private int age;
	private int sid;
	
	private memberRole memRole = null;
	private boardMemberRole boardRole = null;
	private presidentRole presRole = null;

	public Student(String name, String major, int age, int sid) {
		
		this.name = name;
		this.major = major;
		this.age = age;	
		this.sid = sid;
	}



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
	
	public presidentRole getPresidentRole(Society s) throws MemberPermissionException{
		if (presRole == null){ throw new MemberPermissionException("Student is not a president of a society."); }
		else if (s.getPresident() != this){ throw new MemberPermissionException("Student is not president of this society."); }
		else{	
			
			return presRole;
		}
	}
	
}
