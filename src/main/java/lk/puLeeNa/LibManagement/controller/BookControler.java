package lk.puLeeNa.LibManagement.controller;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import lk.puLeeNa.LibManagement.exception.BookNotFoundException;
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
        if(bookDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bookService.addBook(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestParam ("bookId") String bookId){
        if(bookId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            bookService.deleteBook(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // return ResponseEntity.noContent().build();
        }catch (BookNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBook(@RequestParam ("bookId") String bookId, @RequestBody BookDTO bookDTO){
        if(bookId == null || bookDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            bookService.updateBook(bookId, bookDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (BookNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @GetMapping("/{bookId}")
//    public ResponseEntity<BookDTO> getSelectedBook(@PathVariable String bookId){
    @GetMapping
    public ResponseEntity<BookDTO> getSelectedBook(@RequestParam String bookId){
        if(bookId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            BookDTO bookDTO = bookService.getSelectedBook(bookId);
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
        }catch (BookNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("getallbooks")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> bookDTOList = bookService.getAllBooks();
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }
}
