package class7.array;

public class DogTest {
	public static void main(String[] args) {
		Dog[] dogArr = new Dog[5];
		
		dogArr[0] = new Dog("쪼꼬", "요크셔테리어");
		dogArr[1] = new Dog("후추", "개냥이");
		dogArr[2] = new Dog("예삐", "시고르자브종");
		dogArr[3] = new Dog("찰스", "달마시안");
		dogArr[4] = new Dog("시바", "시바견");
		
		for(int i = 0; i < dogArr.length; i++) {
			System.out.println(dogArr[i].showDogInfo());
		}
	}
}
