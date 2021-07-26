package hello.self.core;

import hello.self.core.member.*;
import hello.self.core.order.Order;
import hello.self.core.order.OrderService;
import hello.self.core.order.OrderServiceImpl;
import hello.self.core.order.RateDiscountPolicy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

//    private static AppConfig appConfig = new AppConfig();

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Member memberVIP = new Member(1L, "홍길동", Grade.VIP);
        Member memberBasic = new Member(2L, "임꺽정", Grade.BASIC);

        memberService.join(memberVIP);
        memberService.join(memberBasic);

        String itemName = "연필";
        int itemPrice = 20000;

        Order orderVIP = orderService.createOrder(memberVIP.getId(), itemName, itemPrice);
        Order orderBasic = orderService.createOrder(memberBasic.getId(), itemName, itemPrice);

        System.out.println("orderVIP = " + orderVIP);
        System.out.println("orderBasic = " + orderBasic);
    }
}
