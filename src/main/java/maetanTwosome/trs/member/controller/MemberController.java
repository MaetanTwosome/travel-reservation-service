package maetanTwosome.trs.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import maetanTwosome.trs.member.dto.MemberSaveRequest;
import maetanTwosome.trs.member.dto.MemberSaveResponse;
import maetanTwosome.trs.member.service.MemberService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/api/member")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody @Valid MemberSaveRequest memberSaveRequest) {

        MemberSaveResponse memberSaveResponse = memberService.saveMember(memberSaveRequest);
        return ResponseEntity.ok("POST request successful");
    }

}
