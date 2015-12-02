
/**************************************************************************************************

    Society is a class which acts as a go between in all interactions between
    students/members and their derivatives (board members, president).
 
    Society's functions include:
 
    * addMember
        originally called by Student.joinSociety(this)
        calls Student.isStudent()
        for all BoardMembers, calls BoardMember.reviewApplication(), and if true for any BoardMember
            creates a new Member(Student)
            calls addMember(Member)
        outputs a message based upon the application (denied/accepted)
 
    * removeMember
        originally called by BoardMember.removeMember(this, Member)
        searches members for Member, and if found
            executes members(Arraylist).remove(Member)
 
    * Sanction
        >not originally called by anything
        if members.size is bigger than or equal to 20, society is sanctioned
 
    * Promote
        originally called in construction, can be called by Member.Promote(this)
        >does not do anything yet, is meant to send emails to possibly interested
        students and to post ads on TV screens across campus, and possibly more
        in the future
 
    * haveElection
        originally called by President.callElection(this)
        constructs an Election(this, date, president_id)
        searches for the member with the new president_id and outputs a message
        declaring them the president
 
    * haveMeeting
        originally called by BoardMember.callMeeting(this, date, time, location, purpose)
        constructs a Meeting(date, time, location, purpose)
 
    * haveEvent
        originally called by Member.createEvent(this, name, date, time, location, purpose)
        constructs an Event(name, date, time, location, purpose)
 
    * collectFees
        >not originally called by anything
        verifies that this is sanctioned
        creates a double; fees
        >emails members about paying the fees. Currently, there is no method for a member
        to pay society fee
 
    * Disband
        can be originally called by President.Disband(Society)
        sets all variables in the society to null
        outputs a short message saying the society has been disbanded
 
 ******************************************************************************************/
 package project;
import java.io.Serializable;
import java.util.ArrayList;

public class Society implements Serializable {
	/* includes all information about a society and many methods to change and
	 * update said information.
	 * @author Sam, Osede, Lucas, Shehzaib
	 */
    
	// Scanner in = new Scanner(System.in);
	private String name;
    private String contact_info;
    private String major;
    private double fee = 0;
    private String description;
    private ArrayList<Student> members;
    private ArrayList<Student> board;
    private ArrayList<Boolean> voted;
    private ArrayList<Integer> votes;
    private ArrayList<Student> ballot;
    private Student president;
    private boolean sanctioned;
    private ArrayList<Meeting> meetings;
    private ArrayList<Event> events;
    
    // ----->>>>>    don't forget about SOCIETYSPEC class   <<<<<-----------
    
	Society(Student s, String n, String info, String m, String desc){
		if (s.isStudent()){
            s.setMemberRole(new memberRole());
            s.setBoardRole(new boardMemberRole());
            s.setPresRole(new presidentRole());
            members = new ArrayList<Student>();
            members.add(s);
            board = new ArrayList<Student>();
            board.add(s);
            voted = new ArrayList<Boolean>();
            voted.add(false);
            votes = new ArrayList<Integer>();
            votes.add(0);
            ballot = new ArrayList<Student>();
			name = n;
			president = s;
			contact_info = info;
			major = m;
			setDescription(desc);
			sanctioned = false;
			Promote();
			
		}else{
			System.out.println(Disband() + "Reason: " + s.getName() + " is not recognized as a student at MUN.");
		}
	}
	
	Society(){
		name = null;
		contact_info = null;
		major = null;
	}
	
	String getName(){
		return name;
	}
	
	String getContact(){
		return contact_info;
	}
	
	String getMajor(){
		return major;
	}
	
	public double getFee() {
		return fee;
	}
	
	public void setFee(double f) {
		this.fee = f;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	ArrayList<Student> getMembers(){
        return members;
	}
	
	void showMembers(){
		for (Student x: members){
			System.out.println(x.getName());
		}
	}
	
	ArrayList<Student> getBoard(){
		return board;
	}
	
	void showBoard(){
		for (Student x: board){
			System.out.println(x.getName());
		}
	}
	
	ArrayList<Boolean> getVoted(){
		return voted;
	}
	
	void showVoted(){
		for (Student x: members){
			System.out.print(x.getName() + " : ");
			System.out.println(voted.get(members.indexOf(x)));
		}
	}
	
	ArrayList<Integer> getVotes(){
		return votes;
	}
	
	void showVotes(){
		for (Student x: members){
			System.out.print(x.getName() + " : ");
			System.out.println(votes.get(members.indexOf(x)));
		}
	}
	
	int getVotesFor(Student s) throws MemberPermissionException{
    	return votes.get(getMembers().indexOf(s));
    }
	
	void updateVote(Student you, Student them) throws MemberPermissionException{
		voted.set(getMembers().indexOf(you), true);
		votes.set(getMembers().indexOf(them), votes.get(getMembers().indexOf(them))+1);
	}
	
	void resetVotes(){
		for (boolean b:voted){
			b = false;
		}
		for (int x:votes){
			x = 0;
		}
	}
	
	ArrayList<Student> getBallot(){
		return ballot;
	}
	
	void showBallot(){
		//System.out.println("Vote for one of the following members:");
		for (Student x: ballot){
			System.out.println(x.getName());
		}
	}
	
	void addToBallot(Student s){
		ballot.add(s);
	}
	
	void removeFromBallot(Student s){
		ballot.remove(s);
	}
	
	Student getPresident(){
		return president;
	}
	
	void setPresident(Student s){
		//called by Election
		s.setBoardRole(new boardMemberRole());
		s.setPresRole(new presidentRole());
		president = s;
	}
	
	boolean getSanctionStatus(){
		return sanctioned;
	}
	
	void setName(String n){
		name = n;
	}
	
	void setContact(String c){
		contact_info = c;
	}
	
	void setMajor(String m){
		major = m;
	}
	
	ArrayList<Meeting> upcomingMeetings(){
		return meetings;
	}
	
	void addMeeting(Meeting m){
		meetings.add(m);
	}
	
	ArrayList<Event> upcomingEvents(){
		return events;
	}
	
	void addEvent(Event e){
		events.add(e);
	}
	
	void addMember(Student s){
		s.setMemberRole(new memberRole());
        members.add(s);
        voted.add(false);
        votes.add(0);
        System.out.println(s.getName() + "'s application to join " + this.getName() + " has been reviewed and accepted.");
    }
	
	void addBoardMember(Student s){
		//called by presidentRole.appoint
		s.setBoardRole(new boardMemberRole());
		board.add(s);
		System.out.println(s.getName() + " has been appointed to the board of " + this.getName() + ".");
	}
	
	void removeMember(Student s){
		//only board members can call this method
        if (this.getMembers().contains(s)){
        	members.remove(s);
        }
	}
	
	void removeBoardMember(Student s){
		//only the president can call this method
		if (this.getBoard().contains(s)){
        	board.remove(s);
        }
	}
	
	void Sanction(){
		if (members.size() >= 20){
			sanctioned = true;
		}else{
			sanctioned = false;
		}
	}
	
	void Promote(){
		//Post society poster (filename) on TV screens in University Centre and around campus
		//Possible emails to students who may be interested
        System.out.println("Society created and promoted!");
	}
	
    void haveElection() throws MemberPermissionException{
        Election e = new Election(this);
    }
	
	
	 void haveMeeting(String date, String time, String location, String purpose){
		 Meeting m = new Meeting(date, time, location, purpose);
		 addMeeting(m);
	 }
	
	 void haveEvent(String name, String date, String time, String location, String purpose){
		 Event e = new Event(name, date, time, location, purpose);
		 addEvent(e);
	 }
	 
	 /* 
	 * void collectFees(){ //optional call if (sanctioned){
	 * System.out.println("Enter society fee, for 12 months membership:");
	 * double fee = in.nextDouble(); //email all members to pay society fees
	 * }else{ System.out.println(
	 * "Society must first be sanctioned to collect fees."); } }
	 */
	
	public boolean isMember(Student s){
		for(Student i : members) {
			if (s.getName().equals(i.getName()))
				return true;
		}
		return false;
	}

	public void calculateFee() throws MemberPermissionException{
		double newFee = 0;
		for (Student x:getBoard()){
			newFee += x.getBoardMemberRole(this).getProposedFee();
		}
		newFee = newFee/getBoard().size();
	}
	
	String Disband(){
		String message = "Society " + this.getName() + " disbanded.";
		name = null;
		contact_info = null;
		major = null;
		setDescription(null);
		members = null;
		president = null;
		return message;
	}
	
}