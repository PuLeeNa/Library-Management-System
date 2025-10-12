package lk.puLeeNa.LibManagement.dao;

import lk.puLeeNa.LibManagement.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity, String> {
    // JpaRepository<BookEntity, String> means that this repository will manage BookEntity objects and the primary key (ID) of BookEntity is of type String
    // JPQL query
    @Query("SELECT SUM(b.availableQty) FROM BookEntity b WHERE b.bookId = :bookId")
    int availQty(@Param("bookId") String bookId);
}

