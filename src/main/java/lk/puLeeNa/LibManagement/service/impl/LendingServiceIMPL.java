package lk.puLeeNa.LibManagement.service.impl;

import lk.puLeeNa.LibManagement.dao.BookDao;
import lk.puLeeNa.LibManagement.dao.LendingDao;
import lk.puLeeNa.LibManagement.dao.MemberDao;
import lk.puLeeNa.LibManagement.dto.LendingDTO;
import lk.puLeeNa.LibManagement.entities.BookEntity;
import lk.puLeeNa.LibManagement.entities.MemberEntity;
import lk.puLeeNa.LibManagement.exception.BookNotFoundException;
import lk.puLeeNa.LibManagement.exception.EnoughBooksNotFoundException;
import lk.puLeeNa.LibManagement.exception.MemberNotFoundException;
import lk.puLeeNa.LibManagement.service.LendingService;
import lk.puLeeNa.LibManagement.util.EntityDTOConvert;
import lk.puLeeNa.LibManagement.util.LendingMapping;
import lk.puLeeNa.LibManagement.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LendingServiceIMPL implements LendingService {
    @Value("${perDayFine}") // Injecting the value from application.properties
    private Double perDayAmount;

    private final LendingMapping lendingMapping;
    private final BookDao bookDao;
    private final MemberDao memberDao;
    private final LendingDao lendingDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addLendingData(LendingDTO lendingDTO) {
        // relevant book
        // relevant member
        String bookId = lendingDTO.getBook();
        String member = lendingDTO.getMember();
        BookEntity bookEntity = bookDao.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book Not Found"));
        MemberEntity memberEntity = memberDao.findById(member).orElseThrow(() -> new MemberNotFoundException("Member Not Found"));
        // Check the availability
        if(bookDao.availQty(bookId)>0){
            // Books are available
        }else{
            throw new EnoughBooksNotFoundException("Not Enough Books Available");
        }

        lendingDTO.setLendingId(UtilData.generateLendingId());
        lendingDTO.setLendingDate(UtilData.generateTodayDate());
        lendingDTO.setReturnDate(UtilData.generateReturnDate());
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
