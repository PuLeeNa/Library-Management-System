package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.LendingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lendings")
public class LengdingController {
    @GetMapping("health")
    public String healthTest() {
        return "Lending Controller is Working";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLending(@RequestBody LendingDTO lendingDTO) {
        System.out.println(lendingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteLending(@RequestParam ("lendingId") String lendingId){
        System.out.println(lendingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value ="/{lendingId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> handOverBook(@PathVariable String lendingId, @RequestBody LendingDTO lendingDTO){
        System.out.println(lendingId);
        System.out.println(lendingDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{lendingId}")
    public ResponseEntity<LendingDTO> getSelectedLending(@PathVariable String lendingId){
        System.out.println(lendingId);
        LendingDTO lendingDTO = new LendingDTO();
        return new ResponseEntity<>(lendingDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<LendingDTO>> getAllLendings(){
        List<LendingDTO> lendingDTOList = new ArrayList<>();
        return new ResponseEntity<>(lendingDTOList, HttpStatus.OK);
    }
}
