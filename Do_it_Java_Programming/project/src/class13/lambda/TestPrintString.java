package class13.lambda;

public class TestPrintString {
	public static void main(String[] args) {
		PrintString printString = s -> System.out.println(s);
		printString.showString("Hello World");
	}
}
