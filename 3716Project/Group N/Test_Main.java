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
		Student student = new Student(name, id);
		System.out.println("Student object created. Creating Society. All strings: 'testing'. ");
		Society society = new Society(student, "testing", "testing", id, "testing", "testing");
	}
}