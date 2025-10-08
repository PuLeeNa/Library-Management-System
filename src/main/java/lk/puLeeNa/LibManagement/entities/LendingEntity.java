package lk.puLeeNa.LibManagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Lending")
public class LendingEntity {
    @Id
    private String lendingId;
    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private BookEntity book;
    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private MemberEntity member;
    private String lendingDate;
    private String returnDate;
    private Boolean isActiveLending;
    private Long overdueDays;
    private Double fineAmount;
}
