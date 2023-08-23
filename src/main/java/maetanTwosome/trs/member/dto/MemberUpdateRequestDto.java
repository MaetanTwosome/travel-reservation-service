package maetanTwosome.trs.member.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberUpdateRequestDto {

    private String nickname;
    private String name;
    private String phoneNumber;
    private String password;
    private String provider;
}
