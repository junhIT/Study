package class7.array;

import java.util.*;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Student> studentArrayList = new ArrayList<Student>();
		
		studentArrayList.add(new Student(1001, "James"));
		studentArrayList.add(new Student(1002, "Tomas"));
		studentArrayList.add(new Student(1003, "Edward"));
		
		for(Student student : studentArrayList) {
			student.showStudentInfo();
		}
	}
}
