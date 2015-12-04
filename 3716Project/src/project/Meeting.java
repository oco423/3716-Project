package project;
import java.io.Serializable;

public class Meeting implements Serializable{
	/* Meeting is an object associated with a society. A society
	 * can have any number of meetings. Meetings have the basic
	 * information originally set out by the client, and can be
	 * created into a society or cancelled at any time
	 * by a board member or the president.
	 * @author Sam, Osede
	 */
    
	private String date;
    private String time;
    private String location;
    private String purpose;
    
    Meeting(){
        date = null;
        time = null;
        location = null;
        purpose = null;
    }
	Meeting(String d, String t, String l, String p){
		date = d;
		time = t;
		location = l;
		purpose = p;
		//book a lecture or seminar room, if necessary
		//notify all members of the meeting by email, including all information
	}
	String getDate(){
		return date;
	}
	String getTime(){
		return time;
	}
	String getLocation(){
		return location;
	}
	String getPurpose(){
		return purpose;
	}
	void setDate(String d){
		date = d;
	}
	void setTime(String t){
		time = t;
	}
	void setLocation(String l){
		location = l;
	}
	void setPurpose(String p){
		purpose = p;
	}
	void cancelMeeting(){
		//email members of the cancellation
        //notify any locations booked of the cancellation
		date = null;
		time = null;
		location = null;
		purpose = null;
	}
}