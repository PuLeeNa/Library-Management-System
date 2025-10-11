package lk.puLeeNa.LibManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO implements Serializable {
    private String bookId;
    private String bookName;
    private String author;
    private String edition;
    private String publisher;
    private String isbn;
    private Double price;
    private Integer totalQty;
    private Integer availableQty;
    private LocalDate lastUpdateDate;
    private Time lastUpdateTime;
}

// {
// "bookName": "Java Programming",
// "author": "John Doe",
// "edition": "3rd",
// "publisher": "Tech Books Publishing",
// "isbn": "978-3-16-148410-0",
// "price": 49.99,
// "totalQty": 100,
// "availableQty": 100
// }
