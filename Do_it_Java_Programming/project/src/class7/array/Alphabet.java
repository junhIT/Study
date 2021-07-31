package class7.array;

public class Alphabet {
	public static void main(String[] args) {
			char[][] arr = new char[13][2];
			char val = 'a';
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arr[i][j] = val++;
				}
			}
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
	}
}
