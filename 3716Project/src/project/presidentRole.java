package project;

public class presidentRole {
	
	void setSocietyFee(Society soc, double f){
		soc.setFee(f);
	}
	void Appoint(Student s){
		s.setBoardRole(new boardMemberRole());
	}
    /*void callElection(Society s, String date){
        s.haveElection(date);
    }*/
    String Disband(Society s){
        return s.Disband() + "Disbanded by President.";
    }
    
}
