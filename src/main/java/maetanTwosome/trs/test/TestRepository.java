package maetanTwosome.trs.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestUser, Long> {
}
