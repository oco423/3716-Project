package project;

public class Student {
	private String name;
	private int age;
	private String major;
	private int sid;

	public Student(String name, String major, int age, int sid) {
		this.name = name;
		this.age = age;
		this.major = major;
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

}
