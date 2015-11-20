/**************************************************************************************************
    Student is a class which is the "parent" of all other classes based upon people.
    Any type of Member must be a Student, after all.
 
    Student's functions include:
 
    * declareMajor
        the same as setMajor except it does not change the Student's major
        if one is already declared
 
    * createSociety
        outputs a call for all of the essential information for a Society
        to be created
        once these are fulfilled, constructs a Society based upon these
 
    * joinSociety
        calls Society.addMember(this)
 
    * isStudent()
        checks to see if the student has a valid Student Number and Major (undeclared is valid)
        and if true, returns true, else returns false
 
 ******************************************************************************************/

import java.lang.*;
import java.util.*;
public class Student{
    
    Scanner in = new Scanner(System.in);
	private String name;
    private double student_id;
    private String major;
    
    Student(){
        name = null;
        student_id = 0;
        major = null;
    }
	Student(String n, double id){
		name = n;
		student_id = id;
		major = "undeclared";
	}
	Student(String n, double id, String m){
		name = n;
		student_id = id;
		major = m;
	}
	String getName(){
		return name;
	}
	double getID(){
		return student_id;
	}
	String getMajor(){
		return major;
	}
	void setName(String n){
		name = n;
	}
	void setID(double id){
		student_id = id;
	}
	void setMajor(String m){
		major = m;
	}
	void declareMajor(String m){
		if (major == null){
			major = m;
		}else{
			System.out.println("Major already declared.");
		}
	}
    void createSociety(){
        String name;
        String info;
        String maj;
        String desc;
        System.out.println("The following information is required to create a society. Please enter it as prompted.");
        System.out.println("Society name: "); name = in.next();
        System.out.println("Society description(50-200 characters): "); desc = in.next();
        while (desc.length() < 50 || desc.length() > 200){
            System.out.println("Description was invalid length. Society description(50-200 characters): ");
            desc = in.next();
        }
        System.out.println("Society contact info: "); info = in.next();
        System.out.println("Society major: "); maj = in.next();
        Society s = new Society(this, name, info, this.getID(), maj, desc);
    }
	void joinSociety(Society s){
        s.addMember(this); //unsure if this will work, or what will work
    }
	boolean isStudent(){
		boolean b;
		if (this.getID() != 0 && this.getMajor() != null){
			b = true;
		}else{
			b = false;
		}
		return b;
	}
}

/*
public class President extends Student{ //possibly the way to go, not sure

}
*/