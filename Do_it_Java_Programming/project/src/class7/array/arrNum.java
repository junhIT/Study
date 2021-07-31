package class7.array;

public class arrNum {
	public static void main(String[] args) {
		int[] arr = new int[5];
		
		for(int n = 1, i = 0; n <= 10; n++) {
			if(n % 2 == 0) {
				arr[i++] = n;
			}
		}
		
		int sum = 0;
		
		for(int n = 0; n < arr.length; n++) {
			System.out.print(arr[n]+" ");
			sum += arr[n];
		}
		
		System.out.println(sum);
	}
}
