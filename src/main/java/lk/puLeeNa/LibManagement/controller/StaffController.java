package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import lk.puLeeNa.LibManagement.dto.StaffDTO;
import lk.puLeeNa.LibManagement.exception.StaffNotFoundException;
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
        if (staffDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        staffService.addStaffMember(staffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteStaffMember(@RequestParam ("staffId") String staffId){
        if (staffId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            staffService.deleteStaffMember(staffId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // return ResponseEntity.noContent().build();
        }catch (StaffNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaffMember(@RequestParam String staffId, @RequestBody StaffDTO staffDTO){
        if (staffId == null || staffDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            staffService.updateStaffMember(staffId, staffDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (StaffNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<StaffDTO> getSelectedStaffMember(@RequestParam String staffId){
        if(staffId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            StaffDTO staffDTO = staffService.getSelectedStaffMember(staffId);
            return new ResponseEntity<>(staffDTO, HttpStatus.OK);
        }catch (StaffNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("getallstaffs")
    public ResponseEntity<List<StaffDTO>> getAllStaffMembers(){
        List<StaffDTO> staffDTOList = staffService.getAllStaffMembers();
        return new ResponseEntity<>(staffDTOList, HttpStatus.OK);
    }
}
