package class15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest1 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("D:\\jh\\study\\Do_it_Java_Programming\\project\\src\\class15\\input.txt");
			int i;
			// i 값이 -1이 아닌 동안 read() 메서드로 한 바이트를 반복해 읽음
			while((i = fis.read()) != -1) {
				System.out.println((char)i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
