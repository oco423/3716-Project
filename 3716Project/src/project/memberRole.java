
package project;

import java.io.Serializable;
import java.util.ArrayList;

public class memberRole implements Serializable {
	
	// Scanner in = new Scanner(System.in);
	
	private boolean eligible;
	private int votes;
	void Declare(){
		eligible = true;
	}
    void Withdraw(){
        eligible = false;
    }
    void Promote(Society s){
        s.Promote();
    }
    boolean isEligible(){
    	return eligible;
    }
    int getVotes(){
    	return votes;
    }
    void addVote(){
    	votes += 1;
    }
    void vote(ArrayList<Student> ballot){
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