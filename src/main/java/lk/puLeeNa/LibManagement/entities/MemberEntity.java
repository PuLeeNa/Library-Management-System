package lk.puLeeNa.LibManagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Member")
public class MemberEntity {
    @Id
    private String memberId;
    private String name;
    private String email;
    private LocalDate membershipDate;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    // "member" refers to the field in LendingEntity that owns many in Member(one)->(Many)Lending relationship
    private List<LendingEntity> lendings;
}
