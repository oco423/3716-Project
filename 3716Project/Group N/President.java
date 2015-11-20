/**************************************************************************************************
    President is a BoardMember which has access to all possible functions of a Society.
 
    President's functions include:
 
    * appoint
    calls Member.setBoardMember(Society)
 
    * callElection
    calls Society.haveElection(date)
 
    * Disband
    calls Society.Disband()
 
 ******************************************************************************************/

import java.lang.*;
import java.util.*;
public class President extends BoardMember{
    
    Scanner in = new Scanner(System.in);
    
    President(){
        super.setName(null);
        super.setID(0);
        super.setMajor(null);
    }
	President(Member m){
		super.setName(m.getName());
		super.setID(m.getID());
		super.setMajor(m.getMajor());
	}
	void Appoint(Society s, Member m){
        m.setBoardMember(s);
	}
    void callElection(Society s, String date){
        s.haveElection(date);
    }
    String Disband(Society s){
        return s.Disband() + "Disbanded by President " + super.getName() + ".";
    }
}