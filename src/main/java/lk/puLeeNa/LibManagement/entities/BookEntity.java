package lk.puLeeNa.LibManagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Book")
public class BookEntity {
    @Id
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
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true) // One-to-Many relationship with LendingEntity
    // "book" refers to the field in LendingEntity that owns many in this Book(one)->(Many)Lending relationship
    private List<LendingEntity> lendings;
}
