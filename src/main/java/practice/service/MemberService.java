package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.domain.Member;
import practice.exception.repository.MemberRepository;

import java.util.List;

@Service    //스프링 빈에 등록
@Transactional  //스프링 프레임워크는 이 어노테이션이 붙어 있는 클래스나 메소드에 트랜잭션을 적용
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member);    //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
