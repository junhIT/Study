package class8.temp;

public class Temp {
	public static void main(String[] args) {
		Temp temp = new Temp();
		Parent parent = temp.new Child();
		
		parent.introduce();
	}
	class Parent {
		public void introduce() {
			System.out.println("I'm Parent");
		}
	}

	class Child extends Parent {
		@Override
		public void introduce() {
			System.out.println("I'm Child");
		}
	}
}

