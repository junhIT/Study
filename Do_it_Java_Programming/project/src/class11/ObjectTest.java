package class11;

import class7.array.Student;

public class ObjectTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		TestObject testObj1 = new TestObject(0);
		TestObject testObj2 = testObj1;
		TestObject testObj3 = new TestObject(0);
		TestObject cloneObj = (TestObject) testObj1.clone();
		
		System.out.println(cloneObj);
		
		System.out.println(testObj1.equals(testObj2));
		System.out.println(testObj1.equals(testObj3));
	}

}
