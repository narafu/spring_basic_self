package hello.self.core.order;

import hello.self.core.member.Grade;
import hello.self.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int dicountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * dicountPercent / 100;
        } else {
            return 0;
        }
    }
}
