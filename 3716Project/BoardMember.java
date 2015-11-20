/**************************************************************************************************
    BoardMember is a Member which has access to advanced functions of a Society.
 
    BoardMember's functions include:
 
    * reviewApplication
    >currently does not have any functionality but in theory would allow a BoardMember to
    review an application to join from a Student and either accept, reject, or pass
 
    * callMeeting
    calls Society.haveMeeting(date, time, location, purpose)
 
    * removeMember
    calls Society.removeMember(Member)
 
 ******************************************************************************************/

import java.lang.*;
import java.util.*;
public class BoardMember extends Member{
    
    Scanner in = new Scanner(System.in);
    
    BoardMember(){
        super.setName(null);
        super.setID(0);
        super.setMajor(null);
    }
	BoardMember(Member m){
		super.setName(m.getName());
		super.setID(m.getID());
		super.setMajor(m.getMajor());
	}
    boolean reviewApplication(Student s){
        //send each board member an email or other form of communication for them to view the application of a Student to join the society, and either accept or reject the application (or ignore it and do nothing)
        return true;
    }
    void callMeeting(Society s, String date, String time, String location, String purpose){
        s.haveMeeting(date, time, location, purpose);
    }
    void removeMember(Society s, Member m){
        s.removeMember(m);
    }
}