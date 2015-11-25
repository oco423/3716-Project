package project;

import java.io.BufferedInputStream;
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
	
	public SocietySys() {
		
		societyList = new ArrayList <Society>();
	}
	
	public boolean findSociety(String name) {
		for (Society s : societyList) {
			if (s.getName().equals(name))
				return true;
		}
		return false;
	}

	public Society getSociety(Society s) {
		for (Society soc : societyList) {
			if (soc.getName().equalsIgnoreCase(s.getName()))
				return soc;
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
			FileOutputStream fos = new FileOutputStream("test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(societyList); // write MenuArray to
											// ObjectOutputStream
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void loadSocietyList() {
		try(
			      InputStream file = new FileInputStream("test.txt");
			      InputStream buffer = new BufferedInputStream(file);
			      ObjectInput input = new ObjectInputStream (buffer);
			    ){
			      //deserialize the List
			      ArrayList <Society> sList = (ArrayList<Society>)input.readObject();
			      //display its data
			      for(Society s : sList ){
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
