package hello.self.core;

import hello.self.core.member.Grade;
import hello.self.core.member.Member;
import hello.self.core.member.MemberService;
import hello.self.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "홍길동", Grade.BASIC);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
