package lk.puLeeNa.LibManagement.service.impl;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import lk.puLeeNa.LibManagement.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceIMPL implements BookService {

    @Override
    public void addBook(BookDTO bookDTO) {
        System.out.println("Book Added");
    }

    @Override
    public void deleteBook(String bookId) {

    }

    @Override
    public void updateBook(String bookId, BookDTO bookDTO) {

    }

    @Override
    public BookDTO getSelectedBook(String bookId) {
        return null;
    }

    @Override
    public List<BookDTO> getSelectedBooks() {
        return List.of();
    }
}
