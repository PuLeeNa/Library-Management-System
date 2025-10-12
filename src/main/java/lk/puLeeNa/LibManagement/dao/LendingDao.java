package lk.puLeeNa.LibManagement.dao;

import lk.puLeeNa.LibManagement.dto.LendingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingDao extends JpaRepository<LendingDTO,String> {
}
