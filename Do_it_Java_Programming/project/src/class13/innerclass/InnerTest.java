package class13.innerclass;

class OutClass {				// 외부 클래스
	private int num = 10;			// 외부 클래스 private 변수
	private static int sNum = 20;	// 외부 클래스 정적 변수
	
	private InClass inClass;		// 내부 클래스 자료형 변수를 먼저 선언
	
	// 외부 클래스 디폴트 생성자. 외부 클래스가 생성된 후에 내부 클래스 생성 가능
	public OutClass() {				
		inClass = new InClass();
	}
	
	// 인스턴스 내부 클래스
	class InClass {					
		int inNum = 100;			// 내부 클래스의 인스턴스 변수
		//static int sInNum = 200;	// 인스턴스 내부 클래스에 정적 변수 선언 불가능. >> 오류 발생
		
		// 인스턴스 내부 클래스의 일반 메서드
		void inTest() {
			System.out.println("OutClass num = " + num + " (외부 클래스의 인스턴스 변수)");
			System.out.println("OutClass sNum = " + sNum + " (외부 클래스의 정적 변수)");		
		}
		
		// 정적 메서드 역시 정의 불가능. 오류가 발생하므로 주석 처리
		//static void sTest() {	
		//}
	}
	
	// 정적 내부 클래스
	static class InStaticClass {	
		int inNum = 100;			// 정적 내부 클래스의 인스턴스 변수
		static int sInNum = 200;	// 정적 내부 클래스의 정적 변수
		
		// 정적 내부 클래스의 일반 메서드
		void inTest() {				
			//num += 10;			// 외부 클래스의 인스턴스변수는 사용할 수 없으므로 주석 처리
			System.out.println("InStaticClass inNum = " + inNum++ + " (내부클래스의 인스턴스 변수 사용)");
			System.out.println("InStaticClass sInNum = " + sInNum + " (내부클래스의 정적 변수 사용)");
			System.out.println("OutClass sNum = " + sNum + " (외부클래스의 정적변수 사용)");
		}
		
		// 정적 내부 클래스의 정적 메서드
		static void sTest() {
			// num+=10;				// 외부 클래스의 내부 클래스의 인스턴스 변수는 사용할수 없으므로 주석처리
			// inNum += 10;			//
			
			System.out.println("OutClass sNum = " + sNum + " (외부클래스의 정적변수 사용)");
			System.out.println("InStaticClass sInNum = " + sInNum + " (내부클래스의 정적 변수 사용)");
		}
		
	}
	
	public void usinClass() {
		inClass.inTest();
	}
}

public class InnerTest {
	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		System.out.println("외부클래스를 이용하여 내부클래스 기능 호출");
		outClass.usinClass();
		System.out.println();
		
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass(); // 외부 클래스를 생성하지 않고 바로 정적 내부 클래스 생성 가능
		System.out.println("정적 내부 클래스 일반 메서드 호출");
		sInClass.inTest();
		System.out.println();
		System.out.println("정적 내부 클래스 정적 메서드 호출");
		sInClass.sTest();
	}
}
