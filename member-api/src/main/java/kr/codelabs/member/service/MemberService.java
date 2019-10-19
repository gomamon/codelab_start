package kr.codelabs.member.service;

import kr.codelabs.member.entity.Member;
import kr.codelabs.member.repository.MemberRepository;
import kr.codelabs.member.util.RedisUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member createMember(Member member) {
        member.setMemberSeq(RedisUtil.generateMemberSeq());
        member.setCurrentTime();

        return memberRepository.save(member);
    }
}
