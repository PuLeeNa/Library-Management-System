package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import lk.puLeeNa.LibManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookControler {

    @Autowired
    private BookService bookService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO){
        bookService.addBook(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestParam ("bookId") String bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{bookId}", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBook(@PathVariable String bookId, @RequestBody BookDTO bookDTO){
        bookService.updateBook(bookId, bookDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getSelectedBook(@PathVariable String bookId){
        BookDTO bookDTO = bookService.getSelectedBook(bookId);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> bookDTOList = bookService.getAllBooks();
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }
}
