package class13.stream;

import java.util.ArrayList;
import java.util.List;

public class TravelTest {
	public static void main(String[] args) {
		// 고객 생성
		TravelCustomer custoemerLee = new TravelCustomer("이순신", 40, 100);
		TravelCustomer custoemerKim = new TravelCustomer("김유신", 20, 100);
		TravelCustomer custoemerYun = new TravelCustomer("윤정수", 13, 50);
		
		List<TravelCustomer> customerList = new ArrayList();
		
		// ArrayList에 고객 추가
		customerList.add(custoemerLee);
		customerList.add(custoemerKim);
		customerList.add(custoemerYun);
		
		System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
		customerList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));
		
		int total = customerList.stream().mapToInt(c -> c.getPrice()).sum();
		System.out.println("총 여행 비용은 : " + total + "입니다");
		
		System.out.println("== 20세 이상 고객 명단 정렬하여 출력 == ");
		customerList.stream().filter(c -> c.getAge() >= 20).map(c -> c.getName()).sorted().forEach(s -> System.out.println(s));
	}
}
