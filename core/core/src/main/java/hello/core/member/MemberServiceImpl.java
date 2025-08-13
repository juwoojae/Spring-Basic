package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;   //멤버로서 선언을 한뒤, 생성자를 통해서 구현체를 유동적으로 주입할수있다

    @Autowired  //자동 의존관계 주입
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    //private final MemberRepository memberRepository= new MemoryMemberRepository();  //여기서 OCP가 깨진다
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
