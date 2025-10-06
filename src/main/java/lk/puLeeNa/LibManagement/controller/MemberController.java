package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    @GetMapping("health")
    public String healthTest() {
        return "Member Controller is Working";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDTO memberDTO) {
        System.out.println(memberDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteMember(@RequestParam ("memberId") String memberId){
        System.out.println(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/{memberId}", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> upddateMember(@PathVariable String memberId, @RequestBody MemberDTO memberDTO) {
        System.out.println(memberId);
        System.out.println(memberDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDTO> getSelectedMember(@PathVariable String memberId) {
        System.out.println(memberId);
        MemberDTO memberDTO = new MemberDTO();
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<MemberDTO> memberDTOList = new ArrayList<>();
        return new ResponseEntity<>(memberDTOList, HttpStatus.OK);
    }
}
