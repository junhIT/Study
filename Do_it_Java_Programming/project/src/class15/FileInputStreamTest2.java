package class15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest2 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("D:\\jh\\study\\Do_it_Java_Programming\\project\\src\\class15\\input.txt");
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				fis.close();
			} catch (NullPointerException e) {
				System.out.println(e);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end");
	}
}
