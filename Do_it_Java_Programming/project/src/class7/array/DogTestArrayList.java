package class7.array;

import java.util.ArrayList;

public class DogTestArrayList {
	public static void main(String[] args) {
		ArrayList<Dog> dogArrayList = new ArrayList<Dog>();
		
		dogArrayList.add(new Dog("쪼꼬", "요크셔테리어"));
		dogArrayList.add(new Dog("후추", "개냥이"));
		dogArrayList.add(new Dog("예삐", "시고르자브종"));
		dogArrayList.add(new Dog("찰스", "달마시안"));
		dogArrayList.add(new Dog("시바", "시바견"));
		
		for(Dog dog : dogArrayList) {
			System.out.println(dog.showDogInfo());
		}
	}
}
