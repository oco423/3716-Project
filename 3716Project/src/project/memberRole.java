
package project;

import java.io.Serializable;
import java.util.ArrayList;

public class memberRole implements Serializable {
	/* includes all methods that society members have permission to execute in
	 * a society, as well as all data associated with a member.
	 * @author Sam
	 */
	
	// Scanner in = new Scanner(System.in);
	
	private boolean eligible;
	private int votes;
	
	void Declare(){
		eligible = true;
	}
    void Withdraw(){
        eligible = false;
    }
    boolean isEligible(){
    	return eligible;
    }
    void Promote(Society s){
        s.Promote();
    }
    int getVotes(){
    	return votes;
    }
    void addVote(){
    	votes += 1;
    }
    void vote(Society soc, Student s) throws MemberPermissionException{
    	if (s.getMemberRole(soc).isEligible() == false){
    		System.out.println("That student has not declared themselves eligible, thus you cannot vote for them.");
    	}
    	if (soc.getVotes().get(soc.getMembers().indexOf(s)) == true){
    		System.out.println("You cannot vote more than once per election.");
    		return;
    	}
    	s.getMemberRole(soc).addVote();
    	soc.updateVote(s);
		// System.out.println("Enter the name of the member you are voting
		// for:");
		// String n = in.next();
    	//NOT FINISHED
    	//find the student in the Society list with the name n
    	//addVote() for that student
    }
	void Leave(Society soc){
		//memberRole must become null
		//Student is not in list of Society members anymore
	}
	
}