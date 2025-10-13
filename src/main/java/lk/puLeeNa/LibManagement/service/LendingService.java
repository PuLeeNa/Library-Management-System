package lk.puLeeNa.LibManagement.service;

import lk.puLeeNa.LibManagement.dto.LendingDTO;

import java.util.List;

public interface LendingService {
    void addLendingData(LendingDTO lendingDTO);
    void deleteLendingData(String lendingId);
    void handOverBook(String lendingId);
    LendingDTO getSelectedLendingData(String lendingId);
    List<LendingDTO> getAllLendingData();
}
