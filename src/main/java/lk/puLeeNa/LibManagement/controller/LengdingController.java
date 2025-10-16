package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.LendingDTO;
import lk.puLeeNa.LibManagement.exception.*;
import lk.puLeeNa.LibManagement.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lendings")
public class LengdingController {
    @Autowired
    private LendingService lendingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLending(@RequestBody LendingDTO lendingDTO) {
        if(lendingDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            lendingService.addLendingData(lendingDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (BookNotFoundException | MemberNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (DataPersistException | EnoughBooksNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteLending(@RequestParam ("lendingId") String lendingId){
        if(lendingId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            lendingService.deleteLendingData(lendingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (LendingDataNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping
    public ResponseEntity<Void> handOverBook(@RequestParam ("lendingId") String lendingId){
        try{
            lendingService.handOverBook(lendingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (LendingDataNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<LendingDTO> getSelectedLending(@RequestParam ("lendingId") String lendingId){
        LendingDTO lendingDTO = lendingService.getSelectedLendingData(lendingId);
        return new ResponseEntity<>(lendingDTO, HttpStatus.OK);
    }
    @GetMapping("getalllendings")
    public ResponseEntity<List<LendingDTO>> getAllLendings(){
        List<LendingDTO> lendingDTOList = lendingService.getAllLendingData();
        return new ResponseEntity<>(lendingDTOList, HttpStatus.OK);
    }
}
