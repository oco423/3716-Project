/**************************************************************************************************
    Member is a Student who has access to the basic functions any Member of a Society has.
    A Student must be a Member to be part of a Society.
    A Member is created when:
        a Student is accepted into a Society
        a new President is elected (old President is reset to a Member)
 
    Member's functions include:
 
    * setPresident
        originally called by Election.conductVote(Society, date, old president id)
        searches for all Presidents in Society.getMembers() and makes them a Member
        constructs a new President based upon this
 
    * setBoardMember
        originally called by President.appoint(Member)
        constructs a new BoardMember based upon this
 
    * Declare
        >not originally called by anything
        makes this available as a candidate in Elections
 
    * Withdraw
        >not originally called by anything
        makes this unavailable as a candidate in Elections
 
    * createEvent
        calls Society.createEvent(name, date, time, location, purpose)
 
    * Promote
        calls Society.Promote()
 
    * Leave
        constructs a new Student(this)
        calls Society.removeMember(this)
        sets all variables of this to null
 
 ******************************************************************************************/

import java.lang.*;
import java.util.*;
public class Member extends Student{
    
    Scanner in = new Scanner(System.in);
    private boolean president;
    private boolean boardMember;
    private boolean eligible;

    Member(){
        super.setName(null);
        super.setID(0);
        super.setMajor(null);
        president = false;
        boardMember = false;
        eligible = false;
    }
    
	Member(Student s){
		super.setName(s.getName());
		super.setID(s.getID());
		super.setMajor(s.getMajor());
		president = false;
		boardMember = false;
		eligible = false;
	}
    boolean isPresident(){
        return president;
    }
    boolean isBoardMember(){
        return boardMember;
    }
    boolean isEligible(){
        return eligible;
    }
    void setPresident(Society s){
    	Member m = new Member(s.getPresident());
        s.addMember(m);
        s.setPresident(this);
        s.removeMember(this);
        president = true;
	}
	void setBoardMember(Society s){
        BoardMember b = new BoardMember(this);
        s.removeMember(this);
        s.addMember(b);
        s.addBoardMember(b);
        boardMember = true;
	}
	void Declare(){
		eligible = true;
	}
    void Withdraw(){
        eligible = false;
    }
    void createEvent(Society s, String name, String date, String time, String location, String purpose){
        s.haveEvent(name, date, time, location, purpose);
    }
    void Promote(Society s){
        s.Promote();
    }
	void Leave(Society soc){
		Student s = new Student(this.getName(), this.getID());
        soc.removeMember(this);
		s.setMajor(this.getMajor());
		setName(null);
		setID(0);
		setMajor(null);
	}
}