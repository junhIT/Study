package class15;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("이름:");
		String name = scanner.nextLine();	// 문자열일 읽는 메서드
		System.out.println("직업:");
		String job = scanner.nextLine();
		System.out.println("사번:");
		int num = scanner.nextInt();	// int형을 읽는 메서드
		
		System.out.println(name);
		System.out.println(job);
		System.out.println(num);
	}
}
