package project;

public class presidentRole {
	
	void setSocietyFee(Society soc, double f){
		soc.setFee(f);
	}
	void Appoint(Student s, Society soc){
		if (soc.getMembers().contains(s)){
			soc.addBoardMember(s);
		}
	}
	void demoteBoard(Student s, Society soc){
		if (s.isBoardMember()){
			soc.removeBoardMember(s);
		}
	}
    /*void callElection(Society s, String date){
        s.haveElection(date);
    }*/
    String Disband(Society s){
        return s.Disband() + "Disbanded by President.";
    }
    
}
