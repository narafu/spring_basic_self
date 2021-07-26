package hello.self.core;

import hello.self.core.member.Grade;
import hello.self.core.member.Member;
import hello.self.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "홍길동", Grade.BASIC);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
