package project;

public class presidentRole {
	
	void Appoint(Society s, Member m){
        m.setBoardMember(s);
	}
    void callElection(Society s, String date){
        s.haveElection(date);
    }
    String Disband(Society s){
        return s.Disband() + "Disbanded by President " + super.getName() + ".";
    }
    
}
