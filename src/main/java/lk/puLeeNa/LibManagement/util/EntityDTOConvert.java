package lk.puLeeNa.LibManagement.util;

import lk.puLeeNa.LibManagement.dto.BookDTO;
import lk.puLeeNa.LibManagement.entities.BookEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // to make this class as a Spring Bean which means the control of creating the object is given to the Spring Container
@RequiredArgsConstructor // to create a constructor for the final fields // dependency injection so we don't need to use @Autowired
public class EntityDTOConvert {
    private final ModelMapper modelMapper;

    // Book
    public BookEntity convertBookDTOToEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, BookEntity.class);
    } // this is for converting BookDTO to BookEntity for the addBook() and updateBook() methods in the BookService class
    public BookDTO convertBookEntityToDTO(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDTO.class);
    } // this is for converting BookEntity to BookDTO for the getBookById() method in
    public List<BookDTO> toBookDTOList(List<BookEntity> bookEntityList) {
        return modelMapper.map(bookEntityList, new TypeToken<List<BookDTO>>(){}.getType());
    }  // this is for converting List<BookEntity> to List<BookDTO> for the getAllBooks() method in the BookService class
}
