package lk.puLeeNa.LibManagement.service.impl;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import lk.puLeeNa.LibManagement.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return new BookDTO(
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
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        bookDTOList.add(new BookDTO(
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
        ));
        bookDTOList.add(new BookDTO(
                "B002",
                "Effective Java",
                "Joshua Bloch",
                "3rd",
                "Addison-Wesley Professional",
                "978-0134686097",
                54.99,
                8,
                5,
                "2023-09-15",
                "14:20:00"
        ));
        return bookDTOList;
    }
}
