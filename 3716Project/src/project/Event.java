package project;
import java.util.*;
import java.io.Serializable;

public class Event extends Meeting implements Serializable{
	/* Event is an extension of Meeting. An event behaves in the same
	 * fashion as a meeting, but also includes an event name. A society
	 * also has a list of events, separate from its list of meetings.
	 * Events can be created or cancelled at any time by a board member
	 * or the president.
	 * @author Osede, Sam
	 */
    
	private String name;
    
	Event(){
		super.setDate(null);
		super.setTime(null);
        super.setLocation(null);
		super.setPurpose(null);
		name = null;
	}
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