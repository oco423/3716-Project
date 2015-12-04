package project;
import java.util.*;
import java.io.Serializable;

public class Election implements Serializable{
	/* includes all methods to display the ballot of eligible members and conduct a vote.
	 * Election will change the president upon the conclusion of voting (if necessary).
	 * Election will not change the board members.
	 * At the moment, in the event of a tie, the first person to have achieved
	 * the highest number of votes is the winner. Ties can be changed to be dealt
	 * with in other ways.
	 * @author Sam
	 */
    
	Election(Society soc) throws MemberPermissionException{
		soc.showBallot();
		conductVote(soc);
	}
	
	void conductVote(Society soc) throws MemberPermissionException{
		
		//email every member to vote, displaying the ballot
		
		//this calls every Student in the list of members to vote
		/*for (Student s:soc.getMembers()){
		*	s.getMemberRole(soc).vote(getBallot());
		*}
		*/
		
		Student winner = new Student("[Error, No Votes Counted]", "Major", 20, 201599999); //winner must be initialized
		int mostVotes = 0;
		boolean tie = false;
		for (Student s:soc.getBallot()){
			if (soc.getVotesFor(s) > mostVotes){
				winner = s;
				mostVotes = soc.getVotesFor(s);
				tie = false;
			}else if (soc.getVotesFor(s) == mostVotes){
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
        soc.resetVotes();
    }
}