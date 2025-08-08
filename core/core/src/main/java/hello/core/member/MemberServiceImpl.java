package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository= new MemoryMemberRepository();  //여기서 OCP가 깨진다
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
