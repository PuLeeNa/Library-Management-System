package lk.puLeeNa.LibManagement.dao;

import lk.puLeeNa.LibManagement.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity, String> {

}

