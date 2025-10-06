package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookControler {
    @GetMapping("health")
    public String healthTest() {
        return "Book Controller is Working";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO addBook(@RequestBody BookDTO bookDTO){
        System.out.println(bookDTO);
        return bookDTO;
    }
}
