package class8.temp;

import java.util.ArrayList;

class Animal {
	int age;
	String name;
}

class Human extends Animal{
	public void thinking() {
		System.out.println("인간은 생각을 합니다.");
	}
}

class Tiger extends Animal {
	public void hunting() {
		System.out.println("호랑이는 사냥을 합니다.");
	}
}

public class DowncastingTest {
	public static void main(String[] args) {
		ArrayList<Animal> aniList = new ArrayList<Animal>();
		
		aniList.add(new Human());
		aniList.add(new Tiger());
		
		for(Animal ani : aniList) {
			if(ani instanceof Human){
				((Human) ani).thinking();
			} 
			else if(ani instanceof Tiger) {
				((Tiger) ani).hunting();
			}
		}
	}
}
