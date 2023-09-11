package maetanTwosome.trs.member.service;

import maetanTwosome.trs.member.dto.MemberRequest;
import maetanTwosome.trs.member.entity.Member;
import maetanTwosome.trs.member.entity.Provider;
import maetanTwosome.trs.member.repository.MemberRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static maetanTwosome.trs.member.fixture.MemberFixture.*;
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
        MemberRequest memberByEmailRequest = createMemberRequestByEmail();
        
        Member member = Member.builder()
                .id(1L)
                .nickname(memberByEmailRequest.getNickname())
                .name(memberByEmailRequest.getName())
                .email(memberByEmailRequest.getEmail())
                .phoneNumber(memberByEmailRequest.getPhoneNumber())
                .password(memberByEmailRequest.getPassword())
                .provider(Provider.NONE)
                .build();

        given(memberRepository.save(any()))
                .willReturn(member);

        given(memberRepository.findById(1L))
                .willReturn(Optional.of(member));

        //when
        Long savedId = memberService.saveMember(memberByEmailRequest);

        //then
        Member foundMember = memberRepository.findById(savedId).orElse(null);
        assertThat(foundMember).isNotNull();

        assertThat(foundMember.getEmail()).isEqualTo(memberByEmail.getEmail());
    }

}