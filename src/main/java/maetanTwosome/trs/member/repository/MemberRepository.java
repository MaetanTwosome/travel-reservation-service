package maetanTwosome.trs.member.repository;

import maetanTwosome.trs.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByEmail(String email);

}
