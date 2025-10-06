package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import lk.puLeeNa.LibManagement.dto.StaffDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staffs")
public class StaffController {
    @GetMapping("health")
    public String healthTest() {
        return "Staff Controller is Working";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaffMember(@RequestBody StaffDTO staffDTO){
        System.out.println(staffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteStaffMember(@RequestParam ("staffId") String staffId){
        System.out.println(staffId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{staffId}", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaffMember(@PathVariable String staffId, @RequestBody StaffDTO staffDTO){
        System.out.println(staffId);
        System.out.println(staffDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{staffId}")
    public ResponseEntity<StaffDTO> getSelectedStaffMember(@PathVariable String staffId){
        System.out.println(staffId);
        StaffDTO staffDTO = new StaffDTO();
        return new ResponseEntity<>(staffDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<StaffDTO>> getAllStaffMembers(){
        List<StaffDTO> staffDTOList = new ArrayList<>();
        return new ResponseEntity<>(staffDTOList, HttpStatus.OK);
    }
}
