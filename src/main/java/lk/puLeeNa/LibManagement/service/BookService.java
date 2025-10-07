package lk.puLeeNa.LibManagement.service;

import lk.puLeeNa.LibManagement.dto.BookDTO;

import java.util.List;

public interface BookService {
    void addBook(BookDTO bookDTO);
    void deleteBook(String bookId);
    void updateBook(String bookId, BookDTO bookDTO);
    BookDTO getSelectedBook(String bookId);
    List<BookDTO> getAllBooks();
}
