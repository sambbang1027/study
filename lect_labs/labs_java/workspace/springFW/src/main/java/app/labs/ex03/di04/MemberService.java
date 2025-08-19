package app.labs.ex03.di04;


public class MemberService implements IMemberService {

	@Override
	public Member getMemberInfo() {
		Member member = new Member();
		member.setMemberId("1234");
		member.setName("포챠코");
		member.setAge(19);
		member.setEmail("pocha@com");
		return member;
	}

}
