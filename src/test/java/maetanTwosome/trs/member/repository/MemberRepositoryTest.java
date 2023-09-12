package maetanTwosome.trs.member.repository;

import maetanTwosome.trs.member.dto.MemberUpdateRequestDto;
import maetanTwosome.trs.member.entity.Member;

import maetanTwosome.trs.member.fixture.MemberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("계정 정보를 등록한다.")
    @Test
    void create() {

        //given
        Member member = MemberFixture.createMemberByEmail();

        //when
        Member foundMember = memberRepository.save(member);

        //then
        assertThat(foundMember.getName()).isEqualTo(member.getName());
    }

    @DisplayName("계정 정보를 조회한다.")
    @Test
    void read() {

        //given
        Member member = MemberFixture.createMemberByEmail();

        //when
        Member savedMember = memberRepository.save(member);
        
        Member foundMember = memberRepository.findById(savedMember.getId()).orElse(null);
        assertThat(foundMember).isNotNull();

        //then
        assertThat(foundMember.getName()).isEqualTo(savedMember.getName());
        assertThat(foundMember.getEmail()).isEqualTo(savedMember.getEmail());
    }

    @DisplayName("이메일 계정의 정보를 수정한다.")
    @Test
    void updateEmailAccount() {

        //given
        Member memberByEmail = MemberFixture.createMemberByEmail();

        MemberUpdateRequestDto dto = new MemberUpdateRequestDto();
        dto.setNickname("길동이다이어트하자");
        dto.setPassword("1234abcd");

        //when
        Member savedMember = memberRepository.save(memberByEmail);
        Member foundMember = memberRepository.findById(savedMember.getId()).orElse(null);
        assertThat(foundMember).isNotNull();

        foundMember.update(dto);

        //then
        Member updateMember = memberRepository.findById(foundMember.getId()).orElse(null);
        assertThat(updateMember).isNotNull();
        assertThat(updateMember.getNickname()).isEqualTo(dto.getNickname());
        assertThat(updateMember.getPassword()).isEqualTo(dto.getPassword());
    }

    @DisplayName("OAuth 계정의 정보를 수정한다.")
    @Test
    void updateOAuthAccount() {

        //given
        Member memberBySNS = MemberFixture.createMemberBySNS();

        MemberUpdateRequestDto dto = new MemberUpdateRequestDto();
        dto.setNickname("길동이다이어트하자");
        dto.setPassword("1234abcd");

        //when
        Member savedMember = memberRepository.save(memberBySNS);
        Member foundMember = memberRepository.findById(savedMember.getId()).orElse(null);
        assertThat(foundMember).isNotNull();

        foundMember.update(dto);

        //then
        Member updateMember = memberRepository.findById(foundMember.getId()).orElse(null);
        assertThat(updateMember).isNotNull();
        assertThat(updateMember.getNickname()).isEqualTo(dto.getNickname());
        assertThat(updateMember.getPassword()).isNotEqualTo(dto.getPassword());
    }

    @DisplayName("계정 정보를 삭제한다.")
    @Test
    void delete() {

        //given
        Member memberByEmail = MemberFixture.createMemberByEmail();

        //when
        memberRepository.save(memberByEmail);
        memberRepository.delete(memberByEmail);

        //then
        Member deleteMember = memberRepository.findById(memberByEmail.getId()).orElse(null);
        assertThat(deleteMember).isNull();
    }

}
