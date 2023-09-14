package maetanTwosome.trs.member.service;

import maetanTwosome.trs.member.dto.MemberRequest;
import maetanTwosome.trs.member.entity.Member;
import maetanTwosome.trs.member.entity.Provider;
import maetanTwosome.trs.member.fixture.MemberFixture;
import maetanTwosome.trs.member.repository.MemberRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @InjectMocks
    MemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @DisplayName("회원을_저장한다")
    @Test
    void saveMember() {

        //given
        Member memberByEmail = MemberFixture.createMemberByEmail();

        MemberRequest memberByEmailRequest = new MemberRequest(
                memberByEmail.getNickname(),
                memberByEmail.getName(),
                memberByEmail.getEmail(),
                memberByEmail.getPhoneNumber(),
                memberByEmail.getPassword()
        );

        given(memberRepository.save(any()))
                .willReturn(memberByEmail);

        given(memberRepository.findById(1L))
                .willReturn(Optional.of(memberByEmail));

        //when
        Long savedId = memberService.saveMember(memberByEmailRequest);

        //then
        Member foundMember = memberRepository.findById(savedId).orElse(null);
        assertThat(foundMember).isNotNull();

        assertThat(foundMember.getEmail()).isEqualTo(memberByEmailRequest.getEmail());
    }

}