package lk.puLeeNa.LibManagement.service.impl;

import jakarta.transaction.Transactional;
import lk.puLeeNa.LibManagement.dao.BookDao;
import lk.puLeeNa.LibManagement.dao.LendingDao;
import lk.puLeeNa.LibManagement.dao.MemberDao;
import lk.puLeeNa.LibManagement.dto.LendingDTO;
import lk.puLeeNa.LibManagement.entities.BookEntity;
import lk.puLeeNa.LibManagement.entities.LendingEntity;
import lk.puLeeNa.LibManagement.entities.MemberEntity;
import lk.puLeeNa.LibManagement.exception.*;
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

@Transactional
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
            if(bookDao.deductBasedOnLending(bookId)>0){
                // proceed the lending
                lendingDTO.setLendingId(UtilData.generateLendingId());
                lendingDTO.setLendingDate(UtilData.generateTodayDate());
                lendingDTO.setReturnDate(UtilData.generateReturnDate());
                lendingDTO.setIsActiveLending(true);
                lendingDTO.setFineAmount(0.00);
                lendingDTO.setOverdueDays(0L);
                lendingDao.save(LendingMapping.toLendingEntity(lendingDTO, bookEntity, memberEntity));
            }else{
                throw new DataPersistException("Cannot update book data with 0 available qty");
            }
        }else{
            throw new EnoughBooksNotFoundException("Not Enough Books Available");
        }
    }

    @Override
    public void deleteLendingData(String lendingId) {
        // validation of ID
        var foundLending = lendingDao.findById(lendingId).orElseThrow(() -> new LendingDataNotFoundException("Lending data not found"));
        lendingDao.deleteById(lendingId);
        // add the book when the lending data is deleted
        bookDao.addBasedOnReturning(foundLending.getBook().getBookId());
    }

    @Override
    public void handOverBook(String lendingId) {
        // Check the details of the lending record
        LendingEntity foundLending = lendingDao.findById(lendingId).orElseThrow(() -> new LendingDataNotFoundException("Lending data not found"));
        // Check overdue days and fine amount
        var returnDate = foundLending.getReturnDate();
        var overDue = calcOverDue(returnDate);
        var fineAmount = calcFine(overDue);

        foundLending.setOverdueDays(overDue);
        foundLending.setFineAmount(fineAmount);
        foundLending.setIsActiveLending(false);

        // update book qty against bookId
        bookDao.addBasedOnReturning(foundLending.getBook().getBookId());
    }

    @Override
    public LendingDTO getSelectedLendingData(String lendingId) {
        return null;
    }

    @Override
    public List<LendingDTO> getAllLendingData() {
        return List.of();
    }

    private Long calcOverDue(LocalDate returnDate) {
        LocalDate today = UtilData.generateTodayDate();
        if(returnDate.isBefore(today)){
            return ChronoUnit.DAYS.between(today,returnDate);
        }
        return 0L;
    }
    private Double calcFine(long dayCount){
        return dayCount * perDayAmount;
    }
}
