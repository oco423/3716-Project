package project;
import java.lang.*;
import java.util.*;
public class Election{
    
    Scanner in = new Scanner(System.in);
    
	private ArrayList<Student> ballot;
    
	Election(Society s) throws MemberPermissionException{
		createBallot(s);
		conductVote(s);
	}
	ArrayList<Student> getBallot(){
		return ballot;
	}
	void createBallot(Society soc) throws MemberPermissionException{ //currently, all members declared eligible are placed on ballot
		for (Student x:soc.getMembers()){
			if (x.getMemberRole(soc).isEligible()){
				ballot.add(x);
			}
		}
	}
	void conductVote(Society soc) throws MemberPermissionException{
		
		//email every member to vote, displaying the ballot
		
		//this calls every Student in the list of members to vote
		/*for (Student s:soc.getMembers()){
		*	s.getMemberRole(soc).vote(getBallot());
		*}
		*/
		
		Student winner = new Student("Name", "Major", 20, 201599999); //winner must be initialized
		int mostVotes = 0;
		boolean tie = false;
		for (Student s:soc.getMembers()){
			if (s.getMemberRole(soc).getVotes() > mostVotes){
				winner = s;
				mostVotes = s.getMemberRole(soc).getVotes();
				tie = false;
			}else if (s.getMemberRole(soc).getVotes() == mostVotes){
				tie = true;
			}
		}
		//as of now, the system declares the first name in the list with the highest number of votes the winner.
		//in the case of a tie, this person is the President and the other person/people are left out in the cold.
		if (tie == true){
			System.out.println("There was a tie!");
		}
		//if the new President is not the same as before, the new President is set and the old President
		//has his/her presidentRole and boardMemberRole set to null
        if (winner != soc.getPresident()){
        	System.out.println("The new President of " + soc.getName() + " is " + winner.getName() + ".");
        	soc.getPresident().setPresRole(null);
        	soc.getPresident().setBoardRole(null);
        	soc.setPresident(winner);
        }
    }
}