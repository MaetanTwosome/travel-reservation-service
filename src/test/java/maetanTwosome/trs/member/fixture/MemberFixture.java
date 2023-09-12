package maetanTwosome.trs.member.fixture;

import maetanTwosome.trs.member.dto.MemberRequest;
import maetanTwosome.trs.member.entity.Member;
import maetanTwosome.trs.member.entity.Provider;
import maetanTwosome.trs.member.entity.Role;

public class MemberFixture {

    public static Member createMemberByEmail() {
            return Member.builder()
                    .id(1L)
                    .name("홍길동")
                    .nickname("길동이밥먹자")
                    .password("absd@1fsa")
                    .email("trashyou@naver.com")
                    .phoneNumber("01012345678")
                    .role(Role.MEMBER)
                    .provider(Provider.NONE)
                    .build();
    };

    public static Member createMemberBySNS() {
            return Member.builder()
                    .id(2L)
                    .name("예진아씨")
                    .nickname("예진")
                    .password("absd@1fsa")
                    .email("yejin@naver.com")
                    .phoneNumber("01012345679")
                    .role(Role.MEMBER)
                    .provider(Provider.KAKAO)
                    .providerId("1234")
                    .build();
    }

    public static MemberRequest createMemberRequest(Member member) {
        return new MemberRequest(member.getNickname(), member.getName(), member.getEmail(), member.getPhoneNumber(), member.getPassword());
    }
}
