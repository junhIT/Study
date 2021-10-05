package class15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest3 {

	public static void main(String[] args) {
		
		
		try(FileInputStream fis = new FileInputStream("D:\\jh\\study\\Do_it_Java_Programming\\project\\src\\class15\\input2.txt")) {
			byte[] bs = new byte[10];
			int i;
			while((i = fis.read(bs)) != -1) {
				for(byte b : bs) {
					System.out.print((char)b);
				}
				System.out.println(": " + i + "바이트 읽음");
			}
		} catch (IOException e) {
			System.out.println(e);
		} 
		System.out.println("end");
	}
}
