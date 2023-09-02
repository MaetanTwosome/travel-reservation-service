package maetanTwosome.trs.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WHITE LIST : ["/", "/static/**", "/js/**", "/image/**", "/auth/**"]
 */
@AutoConfigureMockMvc
@SpringBootTest
class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("WHITE LIST 외의 URL은 접근할 수 없다.")
    @Test
    void access403() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get("/member"))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @DisplayName("WHITE LIST의 URL은 접근할 수 있다.")
    @Test
    void access404() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get("/auth"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}