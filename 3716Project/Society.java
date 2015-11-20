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
 
import java.lang.*;
import java.util.*;
public class Society{
    
    Scanner in = new Scanner(System.in);
	private String name;
    private String contact_info;
    private double president_id;
    private String major;
    private String description;
    private ArrayList<Member> members;
    private boolean sanctioned;
    
	Society(Student s, String n, String info, double id, String m, String desc){
		if (s.isStudent()){
            Member mem = new Member(s);
            President p = new President(mem);
            members = new ArrayList<Member>();
			members.add(p);
			name = n;
			contact_info = info;
			president_id = id;
			major = m;
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
	double getPresidentID(){
		return president_id;
	}
	String getMajor(){
		return major;
	}
	ArrayList<Member> getMembers(){
        return members;
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
	void setPresidentID(double id){
		president_id = id;
	}
	void setMajor(String m){
		major = m;
	}
	void addMember(Student s){
        String application = "denied";
		if (s.isStudent()){
            for (BoardMember x:getMembers()){
                if (x.reviewApplication(s)){
                    Member m = new Member(s);
                    members.add(m);
                    application = "accepted";
                }
            }
		}else{
			System.out.println(s.getName() + " is not recognized as a student at MUN and therefore cannot join the society " + this.getName() + ".");
        }
        System.out.println(s.getName() + "'s application to join " + this.getName() + " has been reviewed and " + application + ".");
    }
	void removeMember(Member m){
		//only board members can call this method
        for (Member x:members){
			if (x.getID() == m.getID()){
				members.remove(x);
			}
		}
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
    void haveElection(String date){
        Election e = new Election(this, date, president_id);
        for (Member x:members){
            if (x.getID() == getPresidentID()){
                System.out.println("The new President of the society is " + x.getName() + ".");
            }
        }
    }
    void haveMeeting(String date, String time, String location, String purpose){
        Meeting m = new Meeting(date, time, location, purpose);
    }
    void haveEvent(String name, String date, String time, String location, String purpose){
        Event e = new Event(name, date, time, location, purpose);
    }
    void collectFees(){ //optional call
        if (sanctioned){
            System.out.println("Enter society fee, for 12 months membership:");
            double fee = in.nextDouble();
            //email all members to pay society fees
        }else{
            System.out.println("Society must first be sanctioned to collect fees.");
        }
    }
	String Disband(){
		name = null;
		contact_info = null;
		president_id = 0;
		major = null;
		description = null;
		members = null;
		return ("Society " + this.getName() + " disbanded.");
	}
}
