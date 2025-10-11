package lk.puLeeNa.LibManagement.service.impl;

import jakarta.transaction.Transactional;
import lk.puLeeNa.LibManagement.dao.BookDao;
import lk.puLeeNa.LibManagement.dto.BookDTO;
import lk.puLeeNa.LibManagement.entities.BookEntity;
import lk.puLeeNa.LibManagement.exception.BookNotFoundException;
import lk.puLeeNa.LibManagement.service.BookService;
import lk.puLeeNa.LibManagement.util.EntityDTOConvert;
import lk.puLeeNa.LibManagement.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // dependency injection for final fields, so we don't need to use @Autowired
@Transactional // to manage transactions automatically
public class BookServiceIMPL implements BookService {
    // Dependency Injection
    // @Autowired
    private final BookDao bookDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addBook(BookDTO bookDTO) {
        // Business Process
        bookDTO.setBookId(UtilData.generateBookId());
        bookDTO.setLastUpdateDate(UtilData.generateTodayDate());
        bookDTO.setLastUpdateTime(UtilData.generateCurrentTime());
        // Pass to Dao
        var bookEntity = entityDTOConvert.convertBookDTOToEntity(bookDTO);
        bookDao.save(bookEntity);
    }

    @Override
    public void deleteBook(String bookId) {
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if(!foundBook.isPresent()){
            throw new BookNotFoundException("Book not found");
        }
        bookDao.deleteById(bookId);
    }

    @Override
    public void updateBook(String bookId, BookDTO bookDTO) {
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if(!foundBook.isPresent()){
            throw new BookNotFoundException("Book not found");
        }
        foundBook.get().setBookName(bookDTO.getBookName()); // .get() gives access for setters
        foundBook.get().setAuthor(bookDTO.getAuthor());
        foundBook.get().setEdition(bookDTO.getEdition());
        foundBook.get().setPublisher(bookDTO.getPublisher());
        foundBook.get().setIsbn(bookDTO.getIsbn());
        foundBook.get().setPrice(bookDTO.getPrice());
        foundBook.get().setTotalQty(bookDTO.getTotalQty());
        foundBook.get().setAvailableQty(bookDTO.getAvailableQty());
        foundBook.get().setLastUpdateDate(UtilData.generateTodayDate());
        foundBook.get().setLastUpdateTime(UtilData.generateCurrentTime());
    }

    @Override
    public BookDTO getSelectedBook(String bookId) {
        return null;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return null;
    }
}
