package class15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {
	public static void main(String[] args) {
		// 자바 9부터 제공하는 향상된 try-with-resources 문
		try(FileOutputStream fos = new FileOutputStream("D:\\jh\\study\\Do_it_Java_Programming\\project\\src\\class15\\output.txt", true)) {
			fos.write(65);
			fos.write(66);
			fos.write(67);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("출력이 완료되었습니다.");
	}
}