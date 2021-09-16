package class13.innerclass;

class Outer2 {
	int num = 100;
	
	// MyRunnable 클래스 이름을 빼고 클래스를 바로 생성하는 방법
	Runnable getRunnable(int i) {	// 익명 내부 클래스, Runnable 인터페이스 생성
		return new Runnable() {
			@Override
			public void run() {
				System.out.println(i);
				System.out.println(num);
			}	
		};
	}
	
	// 인터페이스나 추상 클래스형 변수를 선언하고 클래스를 생성해 대입하는 방법
	Runnable runner = new Runnable() {
		@Override
		public void run() {
			System.out.println("Runnable이 구현된 익명 클래스 변수");
		}
	};
}

public class AnonymousInnerTest {

	public static void main(String[] args) {
			Outer2 out = new Outer2();
			Runnable runnable = out.getRunnable(10);
			runnable.run();
			out.runner.run();
	}
}
