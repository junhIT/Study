package class12.collection.treeSet;

import class12.collection.Member;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeSet<String> treeSet = new TreeSet<String>();
//		treeSet.add("홍길동");
//		treeSet.add("이순신");
//		treeSet.add("강감찬");
		
//		System.out.println(treeSet.toString());
		
		MemberTreeSet memberTreeSet = new MemberTreeSet();
		
		Member memberPark = new Member(1003, "박서훤");
		Member memberLee = new Member(1001, "이지원");
		Member memberSon = new Member(1002, "손민수");
		memberTreeSet.addMember(memberPark);
		memberTreeSet.addMember(memberSon);
		memberTreeSet.addMember(memberLee);
		memberTreeSet.showAllmember();
		
		Member memberHong = new Member(1003, "홍준표");
		memberTreeSet.addMember(memberHong);
		memberTreeSet.showAllmember();
	}

}
