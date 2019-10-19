package kr.codelabs.member.controller;

import kr.codelabs.member.entity.Member;
import kr.codelabs.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<?> getAllMembers() {
        List<Member> members = memberService.getAllMembers();

        return ResponseEntity.ok(members);
    }

    @PostMapping("/members")
    public ResponseEntity<?> createMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.createMember(member), HttpStatus.CREATED);
    }
}
