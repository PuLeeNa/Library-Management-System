package lk.puLeeNa.LibManagement.dao;

import lk.puLeeNa.LibManagement.entities.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDao extends JpaRepository<StaffEntity,String> {
}
