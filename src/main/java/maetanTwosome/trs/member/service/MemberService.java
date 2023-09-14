package maetanTwosome.trs.member.service;

import lombok.RequiredArgsConstructor;

import maetanTwosome.trs.member.dto.MemberRequest;
import maetanTwosome.trs.member.repository.MemberRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long saveMember(MemberRequest memberRequest) {
        validateDuplicateEmail(memberRequest.getEmail());

        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        return memberRepository.save(memberRequest.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    private void validateDuplicateEmail(final String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }
}
