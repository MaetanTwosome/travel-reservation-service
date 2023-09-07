package maetanTwosome.trs.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maetanTwosome.trs.member.entity.Member;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSaveResponse
{
    private Long id;

    public static MemberSaveResponse from(Member member) {
        return new MemberSaveResponse(member.getId());
    }
}
