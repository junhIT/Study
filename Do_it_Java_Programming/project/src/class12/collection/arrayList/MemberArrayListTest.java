package class12.collection.arrayList;

import class12.collection.Member;

public class MemberArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberArrayList memberArrayList = new MemberArrayList();
		
		// 회원 인스턴스 생성
		Member memberLee = new Member(1001, "이지원"); 
		Member memberSon = new Member(1002, "손흥민");
		Member memberYun = new Member(1003, "윤서원");
		Member memberKim = new Member(1004, "김준희");
		
		// ArrayList에 회원 추가
		memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberSon);
		memberArrayList.addMember(memberYun);
		memberArrayList.addMember(memberKim);
		
		memberArrayList.showAllMember();
		
		memberArrayList.removeMEmber(memberKim.getMemberId());
		memberArrayList.showAllMember();		
	}

}
