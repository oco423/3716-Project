package project;

public class boardMemberRole {
	
	boolean reviewApplication(Student s){
        //send each board member an email or other form of communication for them to view the application of a Student to join the society, and either accept or reject the application (or ignore it and do nothing)
        return true;
    }
    void createEvent(Society s, String name, String date, String time, String location, String purpose){
        s.haveEvent(name, date, time, location, purpose);
    }
    void callMeeting(Society s, String date, String time, String location, String purpose){
        s.haveMeeting(date, time, location, purpose);
    }
    void removeMember(Society soc, Student s){
        soc.removeMember(s);
    }
	
}