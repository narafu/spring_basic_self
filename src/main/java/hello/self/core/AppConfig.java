package hello.self.core;

import hello.self.core.member.MemberService;
import hello.self.core.member.MemberServiceImpl;
import hello.self.core.member.MemoryMemberRepository;
import hello.self.core.order.OrderService;
import hello.self.core.order.OrderServiceImpl;
import hello.self.core.order.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    @Bean
    public RateDiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }

}
