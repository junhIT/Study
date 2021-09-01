package class12.collection.hashSet;

import java.util.HashSet;
import java.util.Iterator;

import class12.collection.Member;

public class MemberHashSet {
	private HashSet<Member> hashSet; // HashSet 선언
	
	// HashSet 생성
	public MemberHashSet() {
		hashSet = new HashSet<Member> (); 
	}
	
	// HashSet에 회원 추가
	public void addMember(Member member) { 
		hashSet.add(member);
	}
	
	// 매개변수로 받은 회원 아이디에 해당하는 회원 삭제
	public boolean removeMember(int memberId) {
		Iterator<Member> ir = hashSet.iterator(); // Iterator을 활용해 순환
		
		while(ir.hasNext()) {
			Member member = ir.next();			// 회원을 하나씩 가져와서
			int tempId = member.getMemberId();	// ID 비교
			if(tempId == memberId) {			// 같은 ID일 경우
				hashSet.remove(member);			// 회원 삭제
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	// 모든 회원 출력
	public void showAllMember( ) {
		for(Member member : hashSet) {
			System.out.println(member);
		}
	}
}

