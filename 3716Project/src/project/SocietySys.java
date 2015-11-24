package project;

import java.util.ArrayList;

public class SocietySys {
	
	private ArrayList <Society> societyList;
	
	public SocietySys() {
		
		societyList = new ArrayList <Society>();
	}
	
	public ArrayList <Society> getSocietyList() {
		return societyList;
	}
	
	public void addSociety(Society s) {
		societyList.add(s);
	}
	
	
}
