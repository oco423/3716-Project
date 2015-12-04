package project;
import java.io.Serializable;
import java.util.ArrayList;

public class Society implements Serializable {
	/* includes all information about a society and many methods to change and
	 * update said information.
	 * @author Sam, Shehzaib, Osede, Lucas
	 */
    
	// general society info
	private String name;
    private String contact_info;
    private String major;
    private double fee = 0;
    private String description;
    private boolean sanctioned;
    
    // society contents, including vote counting and tracking
    // and a list of eligible candidates
    private ArrayList<Student> members;
    private ArrayList<Student> board;
    private ArrayList<Boolean> voted;
    private ArrayList<Integer> votes;
    private ArrayList<Student> ballot;
    private Student president;
    
    // additional society contents and info
    private ArrayList<Meeting> meetings;
    private ArrayList<Event> events;
    
    // ----->>>>>    don't forget about SOCIETYSPEC class   <<<<<-----------
    
	Society(Student s, String n, String info, String m, String desc){
		if (s.isStudent()){
            s.setMemberRole(new memberRole());
            s.setBoardRole(new boardMemberRole());
            s.setPresRole(new presidentRole());
            meetings = new ArrayList<Meeting>();
            events = new ArrayList<Event>();
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
	
//************ Accessors and mutators for Society information ***********
	String getName(){
		return name;
	}
	
	void setName(String n){
		name = n;
	}
	
	String getContact(){
		return contact_info;
	}
	
	void setContact(String c){
		contact_info = c;
	}
	
	String getMajor(){
		return major;
	}
	
	void setMajor(String m){
		major = m;
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
	
	boolean getSanctionStatus(){
		return sanctioned;
	}
	
//************ Accessors and mutators for Society contents ***********
	
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
		board.add(s);
		president = s;
	}
	
//************ Advanced Society methods and functions ***********

//************ Election methods and functions ***********
	
	int getVotesFor(Student s) throws MemberPermissionException{
    	return votes.get(getMembers().indexOf(s));
    }
	
	void updateVote(Student you, Student them) throws MemberPermissionException{
		voted.set(getMembers().indexOf(you), true);
		votes.set(getMembers().indexOf(them), votes.get(getMembers().indexOf(them))+1);
	}
	
	void haveElection() throws MemberPermissionException{
		//called by presidentRole.callElection
        Election e = new Election(this);
    }
	
	void resetVotes(){
		for (boolean b:voted){
			b = false;
		}
		for (int x:votes){
			x = 0;
		}
		ballot = new ArrayList<Student>();
	}
	
//************ Meetings and Events methods and functions ***********
	
	ArrayList<Meeting> upcomingMeetings(){
		return meetings;
	}
	
	void addMeeting(Meeting m){
		meetings.add(m);
	}
	
	void haveMeeting(String date, String time, String location, String purpose){
		 Meeting m = new Meeting(date, time, location, purpose);
		 addMeeting(m);
	}
	
	void cancelMeeting(String date, String time, String location){
		Meeting x = new Meeting();
		for (Meeting m:upcomingMeetings()){
			if (m.getDate().equalsIgnoreCase(date) && m.getTime().equalsIgnoreCase(time) && m.getLocation().equalsIgnoreCase(location)){
				x = m;
			}
		}
		meetings.remove(x);
	}
	
	ArrayList<Event> upcomingEvents(){
		return events;
	}
	
	void addEvent(Event e){
		events.add(e);
	}
	
	void haveEvent(String name, String date, String time, String location, String purpose){
		 Event e = new Event(name, date, time, location, purpose);
		 addEvent(e);
	 }
	
	void cancelEvent(String name){
		Event x = new Event();
		for (Event e:upcomingEvents()){
			if (e.getName().equalsIgnoreCase(name)){
				x = e;
			}
		}
		events.remove(x);
	}
	
//************ Members and Board Members functions and handling ***********

	void addMember(Student s){
		s.setMemberRole(new memberRole());
        members.add(s);
        voted.add(false);
        votes.add(0);
        System.out.println(s.getName() + "'s application to join " + this.getName() + " has been reviewed and accepted.");
        Sanction();
    }
	
	void addBoardMember(Student s){
		//called by presidentRole.appoint
		s.setBoardRole(new boardMemberRole());
		board.add(s);
		System.out.println(s.getName() + " has been appointed to the board of " + this.getName() + ".");
	}
	
	void removeMember(Student s){
		//only board members can call this method
		//or a member can by leaving
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
	
//************ Other Society functions ***********

	void Sanction(){
		if (members.size() >= 20){
			sanctioned = true;
		}else{
			sanctioned = false;
		}
	}
	
	void Promote(){
		//Post society poster (filename) on TV screens in University Centre and around campus
		//Emails to students who may be interested
        System.out.println("Society created and promoted!");
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
	public Student getStudent (String s) {
		for (Student stu : members) {
			if (stu.getName().equalsIgnoreCase(s))
				return stu;
		}
		return null;
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