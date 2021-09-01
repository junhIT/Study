package class12.collection.arrayList;

import java.util.ArrayList;
import java.util.Iterator;

import class12.collection.Member;

public class MemberArrayList {
	private ArrayList<Member> arrayList; // ArrayList 선언
	
	public MemberArrayList() { // Member형으로 선언한 ArrayList 생성
		arrayList = new ArrayList<Member>();
	}
	
	public void addMember(Member member) {
		arrayList.add(member);
	}
	
	public boolean removeMEmber(int memberId) {
		for(int i = 0; i < arrayList.size(); i++) {
			Member member = arrayList.get(i);
			
			int tempId = member.getMemberId();
			if(tempId == memberId) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	//iterator를 사용한 removeMember
	public boolean removeMember(int memberId) {
		Iterator<Member> ir = arrayList.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			int tmpeId = member.getMemberId();
			if(tmpeId == memberId) {
				arrayList.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(Member member : arrayList) {
			System.out.println(member);
		}
	}
}
