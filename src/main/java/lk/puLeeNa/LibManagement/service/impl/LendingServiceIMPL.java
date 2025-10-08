package lk.puLeeNa.LibManagement.service.impl;

import lk.puLeeNa.LibManagement.dto.LendingDTO;
import lk.puLeeNa.LibManagement.service.LendingService;
import lk.puLeeNa.LibManagement.util.UtilData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LendingServiceIMPL implements LendingService {
    @Value("${perDayFine}") // Injecting the value from application.properties
    private Double perDayAmount;

    @Override
    public void addLendingData(LendingDTO lendingDTO) {
        lendingDTO.setLendingId(UtilData.generateLendingId());
        lendingDTO.setLendingDate(String.valueOf(UtilData.generateTodayDate()));
        lendingDTO.setReturnDate(String.valueOf(UtilData.generateReturnDate()));
        lendingDTO.setIsActiveLending(true);
        lendingDTO.setFineAmount(0.00);
        lendingDTO.setOverdueDays(0L);
        System.out.println(lendingDTO);
    }

    @Override
    public void deleteLendingData(String lendingId) {

    }

    @Override
    public void handOverBook(String lendingId, LendingDTO lendingDTO) {

    }

    @Override
    public LendingDTO getSelectedLendingData(String lendingId) {
        return null;
    }

    @Override
    public List<LendingDTO> getAllLendingData() {
        return List.of();
    }

    private Long calcOverDue() {
        LocalDate today = UtilData.generateTodayDate();
        LocalDate returnDate = UtilData.generateReturnDateCalc();
        if(returnDate.isBefore(today)){
            return ChronoUnit.DAYS.between(today,returnDate);
        }
        return 0L;
    }
    private Double calcFine(long dayCount){
        return dayCount * perDayAmount;
    }
}
