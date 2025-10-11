package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.MemberDTO;
import lk.puLeeNa.LibManagement.exception.MemberNotFoundException;
import lk.puLeeNa.LibManagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDTO memberDTO) {
        if (memberDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        memberService.addMember(memberDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteMember(@RequestParam ("memberId") String memberId){
        if (memberId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            memberService.deleteMember(memberId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (MemberNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(value = "/{memberId}", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateMember(@PathVariable String memberId, @RequestBody MemberDTO memberDTO) {
        memberService.updateMember(memberId, memberDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDTO> getSelectedMember(@PathVariable String memberId) {
        MemberDTO memberDTO = memberService.getSelectedMember(memberId);
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<MemberDTO> memberDTOList = memberService.getAllMembers();
        return new ResponseEntity<>(memberDTOList, HttpStatus.OK);
    }
}
