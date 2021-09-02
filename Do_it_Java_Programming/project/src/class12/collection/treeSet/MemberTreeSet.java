package class12.collection.treeSet;

import java.util.Iterator;
import java.util.TreeSet;

import class12.collection.Member;

public class MemberTreeSet {
	private TreeSet<Member> treeSet;		// TreeSet 선언
	
	public MemberTreeSet() {
		treeSet = new TreeSet<Member>(); 	// TreeSet에 생성
	}
	
	// treeSet에 회원을 추가하는 메서드
	public void addMember(Member member) {
		treeSet.add(member);
	}
	
	public boolean removeMember(int memberId) {
		Iterator<Member> ir = treeSet.iterator();
		
		while(ir.hasNext()) {
			Member member = ir.next();
			int tempId = member.getMemberId();
			if(memberId == tempId) {
				treeSet.remove(member);
				return true;
			}
		}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllmember() {
		for(Member member : treeSet) {
			System.out.print(member);
		}
		System.out.println();
	}
}