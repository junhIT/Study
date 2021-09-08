package class12.map.treeMap;

import class12.collection.Member;

public class MemberTreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberTreeMap memberTreeMap = new MemberTreeMap();
		
		Member memberLee = new Member(1001, "이지원");
		Member memberSon = new Member(1002, "손민국");
		Member memberPark = new Member(1003, "박서훤");
		Member memberHong = new Member(1004, "홍길동");
		
		memberTreeMap.addMember(memberSon);      
		memberTreeMap.addMember(memberPark);     
		memberTreeMap.addMember(memberLee);      
		memberTreeMap.addMember(memberHong);  
		
		memberTreeMap.showAllMember();
		
		memberTreeMap.removeMember(1002);
		memberTreeMap.showAllMember();
	}

}
