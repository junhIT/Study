package class13.lambda;

public class TestStringConcat {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "World";
		interfaceToClass(s1, s2);
		interfaceToLambda(s1, s2);
	}
	
	static void interfaceToClass(String s1, String s2) {
		StringConcatImpl concat1 = new StringConcatImpl();
		concat1.makeString(s1, s2);
	}
	
	static void interfaceToLambda(String s1, String s2) {
		int i = 100;
		StringConcat concat1 = (s, v) -> {
			// i = 10; -> 오류 발생
			System.out.println(i);
			System.out.println(s + "," + v);
		};
		concat1.makeString(s1, s2);
	}
}