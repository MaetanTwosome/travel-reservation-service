package maetanTwosome.trs.member.service;

import lombok.RequiredArgsConstructor;

import maetanTwosome.trs.member.dto.MemberSaveRequest;
import maetanTwosome.trs.member.dto.MemberSaveResponse;
import maetanTwosome.trs.member.entity.Member;
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
    public Long saveMember(MemberSaveRequest memberSaveRequest) {
        validateDuplicateEmail(memberSaveRequest.getEmail());

        String encodedPassword = passwordEncoder.encode(memberSaveRequest.getPassword());
        memberSaveRequest.setPassword(encodedPassword);

        return memberRepository.save(memberSaveRequest.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    private void validateDuplicateEmail(final String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }
}
