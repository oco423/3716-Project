package project;

import java.util.ArrayList;

public class memberRole {
	
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
    void addVote(){
    	votes += 1;
    }
    void vote(ArrayList<Member> ballot){
    	System.out.println("Enter the name of the member you are voting for:");
    	String n = in.next();
    	//NOT FINISHED
    	//find the student in the Society list with the name n
    	//addVote() for that student
    }
	void Leave(Society soc){
		//memberRole must become null
		//Student is not in list of Society members anymore
	}
	
}
