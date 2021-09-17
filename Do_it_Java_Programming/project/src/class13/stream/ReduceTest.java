package class13.stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

// Binaroy Operator를 구현한 클래스 정의
class CompareString implements BinaryOperator<String> {
	@Override
	// reduce 메서드가 호출될 때 불리는 메서드, 두 문자열의 길이를 비교
	public String apply(String s1, String s2) {
		if(s1.getBytes().length >= s2.getBytes().length) return s1;
		else return s2;
	}
}

public class ReduceTest {
	public static void main(String[] args) {
		String[] greetings = {"안녕하세요~~~", "hello", "Good morning", "반갑습니다^^"};
		
		// 람다식을 직접 구현
		System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) -> {
			if(s1.getBytes().length >= s2.getBytes().length) return s1;
			else return s2;
		}));
		
		// Binary Operator를 구현하 클래스 사용
		String str = Arrays.stream(greetings).reduce(new CompareString()).get();
		System.out.println(str);
	}
}
