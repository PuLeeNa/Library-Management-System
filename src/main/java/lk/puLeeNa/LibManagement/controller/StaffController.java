package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import lk.puLeeNa.LibManagement.dto.StaffDTO;
import lk.puLeeNa.LibManagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staffs")
public class StaffController {
    @Autowired // This annotation is used for automatic dependency injection // Injecting the StaffService implementation // It allows us to use the service methods in this controller class without manually instantiating the service
    private StaffService staffService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaffMember(@RequestBody StaffDTO staffDTO){
        staffService.addStaffMember(staffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteStaffMember(@RequestParam ("staffId") String staffId){
        staffService.deleteStaffMember(staffId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{staffId}", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaffMember(@PathVariable String staffId, @RequestBody StaffDTO staffDTO){
        staffService.updateStaffMember(staffId, staffDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{staffId}")
    public ResponseEntity<StaffDTO> getSelectedStaffMember(@PathVariable String staffId){
        StaffDTO staffDTO = staffService.getSelectedStaffMember(staffId);
        return new ResponseEntity<>(staffDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<StaffDTO>> getAllStaffMembers(){
        List<StaffDTO> staffDTOList = staffService.getAllStaffMembers();
        return new ResponseEntity<>(staffDTOList, HttpStatus.OK);
    }
}
