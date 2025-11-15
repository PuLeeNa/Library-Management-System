package lk.puLeeNa.LibManagement.dao;

import lk.puLeeNa.LibManagement.entities.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffDao extends JpaRepository<StaffEntity, String> {
    Optional<StaffEntity> findByUsername(String username);
}
