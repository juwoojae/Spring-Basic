package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    //@return 할인 대상 에 따라서 할인되는 금액이 얼만지 1000 / 0
    int discount(Member member, int price);

}
