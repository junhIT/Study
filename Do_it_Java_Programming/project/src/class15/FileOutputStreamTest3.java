package class15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest3 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("D:\\jh\\study\\Do_it_Java_Programming\\project\\src\\class15\\output.txt");
		try { 
			byte[] bs = new byte[26];
			byte data = 65; // ASCII 'A'
			
			for(int i = 0; i < bs.length; i++) {
				bs[i] = data;
				data++;
			}
			fos.write(bs, 3, 6);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("출력이 완료되었습니다.");
	}
}