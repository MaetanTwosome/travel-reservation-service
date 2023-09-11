package maetanTwosome.trs.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import maetanTwosome.trs.member.dto.MemberRequest;
import maetanTwosome.trs.member.service.MemberService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static maetanTwosome.trs.member.fixture.MemberFixture.createMemberRequestByEmail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    MemberService memberService;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new MemberController(memberService))
                .build();
    }

    @DisplayName("회원가입을 저장한다")
    @Test
    void join() throws Exception {

        MemberRequest memberByEmailRequest = createMemberRequestByEmail();

        given(memberService.saveMember(memberByEmailRequest))
                .willReturn(1L);

        mockMvc.perform(post("/api/member/join")
                                .content(objectMapper.writeValueAsString(memberByEmailRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

}
