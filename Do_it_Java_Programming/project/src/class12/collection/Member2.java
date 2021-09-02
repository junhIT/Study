package class12.collection;

import java.util.Comparator;

public class Member2 implements Comparator<Member2> {
	private int memberId; 		// 회원 아이디
	private String memberName; 	// 회원 이름
	
	public Member2(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	public Member2() {
		// TODO Auto-generated constructor stub
	}

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return memberName + " 회원님의 아이디는 " + memberId + "입니다";
	}
	
	@Override
	public int hashCode() {
		return memberId; // hashCode()메서드가 회원 아이디를 반환하도록 재정의
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member2 member = (Member2)obj;
			if(this.memberId == member.memberId) // memberId가 동일하면 true
				return true;
			else
				return false;
		}
		return false;
	}

	// compare() 메서드 재정의. 전달받은 두 매개변수를 비교함
	@Override
	public int compare(Member2 mem1, Member2 mem2) {
		return mem2.getMemberId() - mem1.getMemberId();
	}
}
