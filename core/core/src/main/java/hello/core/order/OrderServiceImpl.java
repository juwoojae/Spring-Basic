package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//구현체가 DiscountPolicy 에 의존하는것이 아니라 , FixDiscountPolicy 에도 의존한다 (추상에 의존해야하는 데, 구현체에도 의존해버림)

@Component//컴포넌트 스캔을 통해서 스프링빈으로 등록한다 - > 생성자 호출 -> @Autowired 가 있으면 스프링 컨테이너에서 같은 타입의 memberRepository를 꺼내서 의존관계 주입을 해준다.
public class OrderServiceImpl implements OrderService {
    //private final 는 생성자에서 무조건 값이 할당이 되어야한다
    private final MemberRepository memberRepository;//회원 저장소
    private final DiscountPolicy discountPolicy;   //할인 정책 결정

    //생성자 주입
    //생성자가 하나만있으면 @Autowired 생략이 가능하다
    //@Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
