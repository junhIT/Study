package class7.array;

public class Alhphabet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alphabet = new char[26];
		char value = 'a'-32;
		
		for(int n = 0; n < alphabet.length; n++) {
			alphabet[n] = value++;
		}
		
		for(int n = 0; n < alphabet.length; n++) {
			System.out.println(alphabet[n]);
		}
		

	}

}
