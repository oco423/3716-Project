package project;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SocietySys {
	
	private ArrayList <Society> societyList;
	private File fileName = new File("socList.txt");
	
	public SocietySys() {
		
		societyList = new ArrayList <Society>();
	}
	
	public boolean findSociety(String name) {
		for (Society s : societyList) {
			if (s.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	public Society getSociety(String soc) {  //inputs the name as a String
		for (Society s : societyList) {
			if (soc.equalsIgnoreCase(s.getName()))
				return s;
		}
		return null;
	}

	public ArrayList <Society> getSocietyList() {
		return societyList;
	}
	
	public void addSociety(Society s) {
		societyList.add(s);
	}
	
	public void saveSocietyList() {

		try {

			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(societyList);
			oos.reset();		
			oos.flush();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void loadSocietyList() {
		try(
InputStream file = new FileInputStream(fileName);
			      InputStream buffer = new BufferedInputStream(file);
			      ObjectInput input = new ObjectInputStream (buffer);
			    ){
			      //deserialize the List
			      this.societyList = (ArrayList<Society>)input.readObject();
			      //display its data
			      for(Society s : societyList ){

				System.out.println("Recovered society: " + s.getName()); // for
																			// testing
																			// purposes
			      }
			    }
			    catch(ClassNotFoundException ex){
			    	System.out.println("Class not found");
			    }
			    catch(IOException ex){
			System.out.println("IO error");

			    }
	}


}
