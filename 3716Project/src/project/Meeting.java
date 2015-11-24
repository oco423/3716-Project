package project;
public class Meeting{
    
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