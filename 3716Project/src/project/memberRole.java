
package project;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class memberRole implements Serializable {
	/* includes all methods that society members have permission to execute in
	 * a society, as well as all data associated with a member.
	 * @author Sam
	 */
	
	// Scanner in = new Scanner(System.in);
	
	private boolean eligible;
	
	void Declare(Society soc, Student you){
		if (eligible == true){
			return;
		}
		eligible = true;
		soc.addToBallot(you);
	}
    void Withdraw(Society soc, Student you){
        eligible = false;
    }
    boolean isEligible(){
    	return eligible;
    }
    void Promote(Society s){
        s.Promote();
    }
    void vote(Society soc, Student you, Student them) throws MemberPermissionException{
    	if (them.getMemberRole(soc).isEligible() == false){
			JOptionPane.showMessageDialog(null,
					"That student has not declared themselves eligible, thus you cannot vote for them.", "Error",
					JOptionPane.ERROR_MESSAGE);
    	}else if (soc.getVoted().get(soc.getMembers().indexOf(you)) == true){
			JOptionPane.showMessageDialog(null, "You cannot vote more than once per election.", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.out.println();
    	}else{
    		soc.updateVote(you, them);
    		JOptionPane.showMessageDialog(null, "You have voted.", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }
	void Leave(Society soc){
		//memberRole must become null
		//Student is not in list of Society members anymore
	}
	
}