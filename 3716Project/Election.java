import java.lang.*;
import java.util.*;
public class Election{
    
    Scanner in = new Scanner(System.in);
    
	private ArrayList<Member> ballot;
    
	Election(Society s, String date, double p){
		createBallot(s);
		conductVote(s, date, p);
	}
	void createBallot(Society s){ //currently, all members declared eligible are placed on ballot
		for (Member x:s.getMembers()){
			if (x.isEligible()){
				ballot.add(x);
			}
		}
	}
	void conductVote(Society s, String date, double p){
		//email every member to vote, displaying the ballot
		//conduct vote via email response, with date as the deadline
        Member winner;
        if (winner.getID() != p){ //if the new President is not the same as before
            for (Member x:s.getMembers()){
                if (winner.getID() == x.getID()){
                    x.setPresident(s);
                    s.setPresidentID(x.getID());
                }
            }
        }
    }
}