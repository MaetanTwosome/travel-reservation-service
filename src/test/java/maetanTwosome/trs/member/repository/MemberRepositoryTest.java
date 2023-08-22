package maetanTwosome.trs.member.repository;

import maetanTwosome.trs.member.entity.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void create() {

        //given
        Member member = Member.builder()
                .name("member")
                .build();

        //when
        Member findMember = memberRepository.save(member);

        //then
        Assertions.assertThat(findMember.getName()).isEqualTo("member");
    }

    @Test
    void read() {

        //given
        Member member = Member.builder()
                .name("member")
                .email("trashyou@naver.com")
                .build();

        //when
        memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId()).orElse(null);
        Assertions.assertThat(findMember).isNotNull();

        //then
        Assertions.assertThat(findMember.getName()).isEqualTo("member");
        Assertions.assertThat(findMember.getEmail()).isEqualTo("trashyou@naver.com");
    }

    @Test
    void update() {

        //given
        Member member = Member.builder()
                .name("member")
                .build();

        //when
        memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId()).orElse(null);
        Assertions.assertThat(findMember).isNotNull();

        findMember.update("update member");

        //then
        Member updateMember = memberRepository.findById(member.getId()).orElse(null);
        Assertions.assertThat(updateMember).isNotNull();
        Assertions.assertThat(updateMember.getName()).isEqualTo("update member");
    }

    @Test
    void delete() {

        //given
        Member member = Member.builder()
                .name("member")
                .build();

        //when
        memberRepository.save(member);
        memberRepository.delete(member);

        //then
        Member deleteMember = memberRepository.findById(member.getId()).orElse(null);
        Assertions.assertThat(deleteMember).isNull();
    }
}
