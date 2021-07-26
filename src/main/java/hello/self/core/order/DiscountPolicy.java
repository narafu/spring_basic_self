package hello.self.core.order;

import hello.self.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
