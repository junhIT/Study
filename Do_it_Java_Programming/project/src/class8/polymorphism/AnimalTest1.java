package class8.polymorphism;
	
class Animal {
	public void move() {
		System.out.println("동물이 걷습니다.");
	}
}

class Human extends Animal {
	public void move() {
		System.out.println("사람이 두 발로 걷습니다");
	}
}

class Tiger extends Animal {
	public void move() {
		System.out.println("호랑이가 네 발로 걷습니다.");
	}
}

class Eagle extends Animal {
	public void move() {
		System.out.println("독수리가 하늘을 납니다.");
	}
}

public class AnimalTest1 {
	public static void main(String[] args) {
		AnimalTest1 animalTest = new AnimalTest1();
		animalTest.moveAnimal(new Human());
		animalTest.moveAnimal(new Tiger());
		animalTest.moveAnimal(new Eagle());

	}
	
	public void moveAnimal(Animal animal) {
		animal.move();
	}
}
