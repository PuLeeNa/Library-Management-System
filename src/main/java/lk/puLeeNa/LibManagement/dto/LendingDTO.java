package lk.puLeeNa.LibManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LendingDTO implements Serializable {
    private String lendingId;
    private String book;
    private String member;
    private LocalDate lendingDate;
    private LocalDate returnDate;
    private String isActiveLending;
    private Long overdueDays;
    private Double fineAmount;
}
