package project;
/**************************************************************************************************

    Society is a class which acts as a go between in all interactions between
    students/members and their derivatives (board members, president).
 
    Society's functions include:
 
    * addMember
        originally called by Student.joinSociety(this)
        calls Student.isStudent()
        for all BoardMembers, calls BoardMember.reviewApplication(), and if true for any BoardMember
            creates a new Member(Student)
            calls addMember(Member)
        outputs a message based upon the application (denied/accepted)
 
    * removeMember
        originally called by BoardMember.removeMember(this, Member)
        searches members for Member, and if found
            executes members(Arraylist).remove(Member)
 
    * Sanction
        >not originally called by anything
        if members.size is bigger than or equal to 20, society is sanctioned
 
    * Promote
        originally called in construction, can be called by Member.Promote(this)
        >does not do anything yet, is meant to send emails to possibly interested
        students and to post ads on TV screens across campus, and possibly more
        in the future
 
    * haveElection
        originally called by President.callElection(this)
        constructs an Election(this, date, president_id)
        searches for the member with the new president_id and outputs a message
        declaring them the president
 
    * haveMeeting
        originally called by BoardMember.callMeeting(this, date, time, location, purpose)
        constructs a Meeting(date, time, location, purpose)
 
    * haveEvent
        originally called by Member.createEvent(this, name, date, time, location, purpose)
        constructs an Event(name, date, time, location, purpose)
 
    * collectFees
        >not originally called by anything
        verifies that this is sanctioned
        creates a double; fees
        >emails members about paying the fees. Currently, there is no method for a member
        to pay society fee
 
    * Disband
        can be originally called by President.Disband(Society)
        sets all variables in the society to null
        outputs a short message saying the society has been disbanded
 
 ******************************************************************************************/
 
import java.util.ArrayList;
import java.util.Scanner;
public class Society{
    
    Scanner in = new Scanner(System.in);
	private String name;
    private String contact_info;
    private String major;
    private double fee = 0;
    private String description;
    private ArrayList<Student> members; //map???
    private ArrayList<Student> board;
    private Student president;
    private boolean sanctioned;
    
	Society(Student s, String n, String info, String m, String desc){
		if (s.isStudent()){
            s.setMemberRole(new memberRole());
            s.setBoardRole(new boardMemberRole());
            s.setPresRole(new presidentRole());
            members = new ArrayList<Student>();
			name = n;
			contact_info = info;
			major = m;
			president = s;
			description = desc;
			sanctioned = false;
			Promote();
		}else{
			System.out.println(Disband() + "Reason: " + s.getName() + " is not recognized as a student at MUN.");
		}
	}
	
	String getName(){
		return name;
	}
	
	String getContact(){
		return contact_info;
	}
	
	String getMajor(){
		return major;
	}
	
	ArrayList<Student> getMembers(){
        return members;
	}
	
	void showMembers(){
		for (Student x: members){
			System.out.println(x.getName());
		}
	}
	
	ArrayList<Student> getBoard(){
		return board;
	}
	
	void showBoard(){
		for (Student x: board){
			System.out.println(x.getName());
		}
	}
	Student getPresident(){
		return president;
	}
	
	boolean getSanctionStatus(){
		return sanctioned;
	}
	
	void setName(String n){
		name = n;
	}
	
	void setContact(String c){
		contact_info = c;
	}
	
	void setMajor(String m){
		major = m;
	}
	
	void addMember(Student s){
		s.setMemberRole(new memberRole());
        members.add(s);     
        System.out.println(s.getName() + "'s application to join " + this.getName() + " has been reviewed and accepted");
    }
	
	void removeMember(Student s){
		//only board members can call this method
        for (Student x:members){
			if (x.getSid() == s.getSid()){
				s.setMemberRole(null);
			}
		}
	}
	
	void setPresident(Student s){
		s.setPresRole(new presidentRole());
	}
	
	void Sanction(){
		if (members.size() >= 20){
			sanctioned = true;
		}else{
			sanctioned = false;
		}
	}
	
	void Promote(){
		//Post society poster (filename) on TV screens in University Centre and around campus
		//Possible emails to students who may be interested
        System.out.println("Society created and promoted!");
	}
	
    /*void haveElection(String date){
        Election e = new Election(this, date, president.getSid());
        for (Student x:members){
            if (x.getSid() == president.getSid()){
                System.out.println("The new President of the society is " + x.getName() + ".");
            }
        }
    }*/
	
    void haveMeeting(String date, String time, String location, String purpose){
        Meeting m = new Meeting(date, time, location, purpose);
    }
    
    void haveEvent(String name, String date, String time, String location, String purpose){
        Event e = new Event(name, date, time, location, purpose);
    }
    
  /* void collectFees(){ //optional call
        if (sanctioned){
            System.out.println("Enter society fee, for 12 months membership:");
            double fee = in.nextDouble();
            //email all members to pay society fees
        }else{
            System.out.println("Society must first be sanctioned to collect fees.");
        }
    }*/
    
	String Disband(){
		String message = "Society " + this.getName() + " disbanded.";
		name = null;
		contact_info = null;
		major = null;
		description = null;
		members = null;
		president = null;
		return message;
	}
	
	public boolean isMember(Student s){
		for(Student i : members) {
			if (s.getName().equals(i.getName()))
				return true;
		}
		return false;
	}
	
	public double getFee() {
		return fee;
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}
	
}