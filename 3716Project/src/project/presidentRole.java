package project;

import java.io.Serializable;

public class presidentRole implements Serializable {
	/* includes all methods the president of a Society can call or execute.
	 * any student can call these functions if they are the president of that
	 * particular society. See MemberPermissionException.java
	 * @author Sam, Osede
	 */
	
	void setSocietyFee(Society soc, double f){
		soc.setFee(f);
	}
	void Appoint(Student s, Society soc){
		if (soc.getMembers().contains(s)){
			soc.addBoardMember(s);
		}
	}
	void demoteBoard(Student s, Society soc){
		if (s.isBoardMember()){
			soc.removeBoardMember(s);
		}
	}
    void callElection(Society s) throws MemberPermissionException{
        s.haveElection();
    }
    String Disband(Society s){
        return s.Disband() + "Disbanded by President.";
    }
    
}
