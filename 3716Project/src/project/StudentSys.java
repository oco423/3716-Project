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
	private Student stuLoggedIn = new Student("Lucas Critch", "CS", 20, 40056);
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

	public Student getStudent(String stu) {
		for (Student s : stuList) {
			if (stu.equalsIgnoreCase(s.getName()))
				return s;
		}
		return null;
	}

	public ArrayList<Student> getStuList() {
		return stuList;
	}
	
	public void addStudent(Student s) {
		stuList.add(s);
	}
	
	public void saveStuList() {
		try {

			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(stuList);
			oos.reset();
			oos.flush();
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
			this.stuList = (ArrayList<Student>) input.readObject();
			      //display its data
			for (Student s : stuList) {

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

	public Student getStuLoggedIn() {
		return stuLoggedIn;
	}

	public void setStuLoggedIn(Student stuLoggedIn) {
		this.stuLoggedIn = stuLoggedIn;
	}


}
