package maetanTwosome.trs.test;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TestUser {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String password;
}
