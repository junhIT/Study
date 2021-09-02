package class12.collection.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

import class12.collection.Member2;

public class ComparatorTest implements Comparator<String>{ // Comparator 인터페이스 구현
		
	TreeSet<Member2> treeSet = new TreeSet<Member2>(new Member2( ));
	
	
	public static void main(String[] args) {
		TreeSet<String> treeSet2 = new TreeSet<String>(new ComparatorTest());
		ComparatorTest ct = new ComparatorTest();
		
		ct.treeSet.add(new Member2(1002, "이클"));
		ct.treeSet.add(new Member2(1001, "도지"));
		ct.treeSet.add(new Member2(1003, "밀크"));
		ct.treeSet.add(new Member2(1004, "골렘"));
		ct.treeSet.add(new Member2(1005, "보라"));
		ct.treeSet.add(new Member2(1006, "퀀텀"));
		
//		System.out.println(ct.treeSet.toString());
		
		treeSet2.add("aaa");
		treeSet2.add("ccc");
		treeSet2.add("bbb");
		
		System.out.println(treeSet2);
	}

	@Override
	public int compare(String o1, String o2) { // compare 메서드 재정의
		return (o1.compareTo(o2)) * -1; // 내림차순으로 정렬
	}
}
