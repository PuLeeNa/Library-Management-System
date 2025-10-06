package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookControler {
    @GetMapping("health")
    public String healthTest() {
        return "Book Controller is Working";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO){
        System.out.println(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestParam ("bookId") String bookId){
        System.out.println(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{bookId}", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBook(@PathVariable String bookId, @RequestBody BookDTO bookDTO){
        System.out.println(bookId);
        System.out.println(bookDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getSelectedBook(@PathVariable String bookId){
        System.out.println(bookId);
        BookDTO bookDTO = new BookDTO(
                "B001",
                "Java Programming",
                "Herbert Schildt",
                "8th",
                "McGraw-Hill Education",
                "978-1260440232",
                45.99,
                10,
                7,
                "2023-10-01",
                "10:30:00"
        );
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }
}
