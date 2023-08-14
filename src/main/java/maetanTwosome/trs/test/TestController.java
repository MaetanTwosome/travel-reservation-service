package maetanTwosome.trs.test;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestRepository testRepository;

    @PostConstruct
    public void init() {
        TestUser testUser = new TestUser();
        testUser.setUsername("test");
        testUser.setPassword("1234");

        testRepository.save(testUser);
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("TestController.test");

        return "ok!";
    }

    @GetMapping("/select")
    public String select() {
        System.out.println("TestController.test");
        TestUser testUser = testRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("몰라"));
        System.out.println(testUser);

        return "ok!";
    }
}
