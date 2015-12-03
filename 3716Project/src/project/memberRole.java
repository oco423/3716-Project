
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
	
	void Declare(Society soc, Student you){
		eligible = true;
		soc.addToBallot(you);
	}
    void Withdraw(Society soc, Student you){
        eligible = false;
        soc.removeFromBallot(you);
    }
    boolean isEligible(){
    	return eligible;
    }
    void Promote(Society s){
        s.Promote();
    }
    void vote(Society soc, Student you, Student them) throws MemberPermissionException{
    	if (them.getMemberRole(soc).isEligible() == false){
    		System.out.println("That student has not declared themselves eligible, thus you cannot vote for them.");
    		return;
    	}
    	if (soc.getVoted().get(soc.getMembers().indexOf(you)) == true){
    		System.out.println("You cannot vote more than once per election.");
    		return;
    	}
    	soc.updateVote(you, them);
    }
	void Leave(Society soc){
		//memberRole must become null
		//Student is not in list of Society members anymore
	}
	
}