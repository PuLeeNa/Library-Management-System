package lk.puLeeNa.LibManagement.dao;

import lk.puLeeNa.LibManagement.entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<MemberEntity,String> {
}
