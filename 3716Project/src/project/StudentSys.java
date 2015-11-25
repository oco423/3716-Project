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

public class StudentSys {
	
	private ArrayList <Student> stuList;
	private File fileName = new File("stuList.txt");
	
	public StudentSys() {
		
		stuList = new ArrayList <Student>();
	}
	
	public boolean findStudent(String name) {
		for (Student s : stuList) {
			if (s.getName().equals(name))
				return true;
		}
		return false;
	}

	public Student getStudent(Student s) {
		for (Student stu : stuList) {
			if (stu.getName().equalsIgnoreCase(s.getName()))
				return stu;
		}
		return null;
	}

	public ArrayList <Student> getstuList() {
		return stuList;
	}
	
	public void addStudent(Student s) {
		stuList.add(s);
	}
	
	public void saveStuList() {
		try {
			if (!fileName.exists()) {
				fileName.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(stuList); // write MenuArray to
											// ObjectOutputStream
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void loadStuList() {
		try(
InputStream file = new FileInputStream(fileName);
			      InputStream buffer = new BufferedInputStream(file);
			      ObjectInput input = new ObjectInputStream (buffer);
			    ){
			      //deserialize the List
			      ArrayList <Student> sList = (ArrayList<Student>)input.readObject();
			      //display its data
			      for(Student s : sList ){

				System.out.println("Recovered Student: " + s.getName()); // for
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
