package maetanTwosome.trs.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    MEMBER("ROLE_MEMBER"), ADMIN("ROLE_ADMIN");

    private String value;
}
