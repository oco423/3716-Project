import java.lang.*;
import java.util.*;

public class Test_Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String name;
		int id;
		//String major;
		System.out.println("Name: ");
		name = in.next();
		System.out.println("ID: ");
		id = in.nextInt();
		//System.out.println("Major: ");
		//major = in.next();
		Student student = new Student(name, "test_major", 21, id);
		System.out.println("Student object created. Creating Society. All strings: 'testing'. ");
		Society society = new Society(student, "testing", "testing", "testing", "testing");
		Student s1 = new Student(name, "test_major1", 20, id);
		Student s2 = new Student(name, "test_major2", 23, id);
		society.addMember(s1);
		society.addMember(s2);
		society.showMembers();
	}
}