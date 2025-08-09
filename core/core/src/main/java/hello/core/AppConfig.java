package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    //생성자 주입
    public MemberService memberService(){   //memberService 메서드를 호출하므로서 , 객체가 생성된다
        return new MemberServiceImpl(memberRepository());  //역할과 구현클래스가 한눈에 보인다
    }
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
