package hello.self.core.order;

import hello.self.core.member.Grade;
import hello.self.core.member.Member;
import hello.self.core.member.MemberService;
import hello.self.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class OrderServiceTest {

    private final MemberService memberService = new MemberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        Member memberVIP = new Member(1L, "홍길동", Grade.VIP);
        Member memberBasic = new Member(2L, "임꺽정", Grade.BASIC);

        memberService.join(memberVIP);
        memberService.join(memberBasic);

        String itemName = "연필";
        int itemPrice = 10000;

        Order orderVIP = orderService.createOrder(1L, itemName, itemPrice);
        Order orderBasic = orderService.createOrder(2L, itemName, itemPrice);

        Assertions.assertThat(orderVIP.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(orderBasic.getDiscountPrice()).isEqualTo(0);

    }
}