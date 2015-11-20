package project;

public abstract class Person {

		int age;
		String name;
		String description = "Unknown person";
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getDescription() {
			return description;
		}
		
		public void join() {
			
		}
}
