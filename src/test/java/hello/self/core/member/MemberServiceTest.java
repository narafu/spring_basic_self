package hello.self.core.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    private MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "홍길동", Grade.BASIC);
        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // then
        assertThat(member).isEqualTo(findMember);
    }
}