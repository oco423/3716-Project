
package project;

import java.io.Serializable;

public class boardMemberRole implements Serializable {
	/* includes all methods a board member has permission to execute
	 * in the running of a society.
	 * @author Sam, Osede
	 */
	
	private double proposedFee;
	
	boolean reviewApplication(Student s){
        //send each board member an email or other form of communication for them to view the application of a Student to join the society, and either accept or reject the application (or ignore it and do nothing)
        return true;
    }
	
	double getProposedFee(){
		return proposedFee;
	}
	void setProposedFee(double fee){
		proposedFee = fee;
	}
	
	/*void proposeSocietyFee(Society soc, double fee){
		while (fee > 100.00){
			System.out.println("Please enter a reasonable amount...");
			fee = in.nextDouble();
		}
		setProposedFee(fee);
	}*/

	void callMeeting(Society soc){
		 //Entry of the following JTextFields to create a meeting and append it to the list of meetings in soc
		 //String date
		 //String time
		 //String location
		 //String purpose
		 //soc.haveMeeting(date, time, location, purpose);
	 }
	
	 void createEvent(Society soc){
		 //Entry of the following JTextFields to create an event and append it to the list of events in soc
		 //String name
		 //String date
		 //String time
		 //String location
		 //String purpose
		 //soc.haveEvent(name, date, time, location, purpose);
	 }
	 
    void removeMember(Society soc, Student s){
        soc.removeMember(s);
    }
	
}