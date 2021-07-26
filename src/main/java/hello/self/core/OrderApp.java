package hello.self.core;

import hello.self.core.member.Grade;
import hello.self.core.member.Member;
import hello.self.core.member.MemberService;
import hello.self.core.member.MemberServiceImpl;
import hello.self.core.order.Order;
import hello.self.core.order.OrderService;
import hello.self.core.order.OrderServiceImpl;

public class OrderApp {

    private static MemberService memberService = new MemberServiceImpl();
    private static OrderService orderService = new OrderServiceImpl();

    public static void main(String[] args) {

        Member memberVIP = new Member(1L, "홍길동", Grade.VIP);
        Member memberBasic = new Member(2L, "임꺽정", Grade.BASIC);

        memberService.join(memberVIP);
        memberService.join(memberBasic);

        String itemName = "연필";
        int itemPrice = 10000;

        Order orderVIP = orderService.createOrder(memberVIP.getId(), itemName, itemPrice);
        Order orderBasic = orderService.createOrder(memberBasic.getId(), itemName, itemPrice);

        System.out.println("orderVIP = " + orderVIP);
        System.out.println("orderBasic = " + orderBasic);
    }
}
