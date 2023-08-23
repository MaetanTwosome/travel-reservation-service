package maetanTwosome.trs.member.repository;

import maetanTwosome.trs.member.dto.MemberUpdateRequestDto;
import maetanTwosome.trs.member.entity.Member;

import maetanTwosome.trs.member.entity.Provider;
import maetanTwosome.trs.member.entity.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static maetanTwosome.trs.member.entity.Provider.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("계정 정보를 등록한다.")
    @Test
    void create() {

        //given
        Member member = getMemberByProvider(NONE);

        //when
        Member findMember = memberRepository.save(member);

        //then
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @DisplayName("계정 정보를 조회한다.")
    @Test
    void read() {

        //given
        Member member = getMemberByProvider(NONE);

        //when
        memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId()).orElse(null);
        assertThat(findMember).isNotNull();

        //then
        assertThat(findMember.getName()).isEqualTo(member.getName());
        assertThat(findMember.getEmail()).isEqualTo(member.getEmail());
    }

    @DisplayName("이메일 계정의 정보를 수정한다.")
    @Test
    void updateForEmailAccount() {

        //given
        Member member = getMemberByProvider(NONE);

        MemberUpdateRequestDto dto = new MemberUpdateRequestDto();
        dto.setNickname("길동이다이어트하자");
        dto.setPassword("1234abcd");

        //when
        memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId()).orElse(null);
        assertThat(findMember).isNotNull();

        findMember.update(dto);

        //then
        Member updateMember = memberRepository.findById(member.getId()).orElse(null);
        assertThat(updateMember).isNotNull();
        assertThat(updateMember.getNickname()).isEqualTo(dto.getNickname());
        assertThat(updateMember.getPassword()).isEqualTo(dto.getPassword());
    }

    @DisplayName("OAuth 계정의 정보를 수정한다.")
    @Test
    void updateForOAuthAccount() {

        //given
        Member member = getMemberByProvider(KAKAO);

        MemberUpdateRequestDto dto = new MemberUpdateRequestDto();
        dto.setNickname("길동이다이어트하자");
        dto.setPassword("1234abcd");

        //when
        memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId()).orElse(null);
        assertThat(findMember).isNotNull();

        findMember.update(dto);

        //then
        Member updateMember = memberRepository.findById(member.getId()).orElse(null);
        assertThat(updateMember).isNotNull();
        assertThat(updateMember.getNickname()).isEqualTo(dto.getNickname());
        assertThat(updateMember.getPassword()).isNotEqualTo(dto.getPassword());
    }

    @DisplayName("계정 정보를 삭제한다.")
    @Test
    void delete() {

        //given
        Member member = getMemberByProvider(NONE);

        //when
        memberRepository.save(member);
        memberRepository.delete(member);

        //then
        Member deleteMember = memberRepository.findById(member.getId()).orElse(null);
        assertThat(deleteMember).isNull();
    }

    private static Member getMemberByProvider(Provider provider) {

        return Member.builder()
                .name("홍길동")
                .nickname("길동이밥먹자")
                .password("1234")
                .email("trashyou@naver.com")
                .phoneNumber("01012345678")
                .role(Role.MEMBER)
                .provider(provider)
                .build();
    }
}
