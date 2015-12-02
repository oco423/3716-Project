package project;
import java.util.*;
public class Event extends Meeting{
    
    //Scanner in = new Scanner(System.in);
	private String name;
    
	Event(String n, String d, String t, String l, String p){
		super.setDate(d);
		super.setTime(t);
        super.setLocation(l);
		super.setPurpose(p);
		name = n;
		//book a lecture or seminar room, or a public area, if necessary
		//notify all members of the meeting by email, including all information
	}
	String getName(){
		return name;
	}
	void setName(String n){
		name = n;
	}
	void cancelEvent(){
		//email members, students of the cancellation
		//notify any locations booked of the cancellation
		setName(null);
		setDate(null);
		setTime(null);
		setLocation(null);
		setPurpose(null);
	}
}