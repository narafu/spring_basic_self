package hello.self.core.order;

import hello.self.core.member.Member;
import hello.self.core.member.MemberService;
import hello.self.core.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService {

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberService memberService = new MemberServiceImpl();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberService.findMember(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
