package class7.array;

public class Student {
	private int studentID;
	private String name;
	
	public Student(int studentID, String name) {
		this.studentID = studentID;
		this.name = name;
	}
	
	public void showStudentInfo() {
		System.out.println(this.studentID+","+name);
	}
}
