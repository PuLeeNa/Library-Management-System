package lk.puLeeNa.LibManagement.service.impl;

import lk.puLeeNa.LibManagement.dto.LendingDTO;
import lk.puLeeNa.LibManagement.service.LendingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendingServiceIMPL implements LendingService {

    @Override
    public void addLendingData(LendingDTO lendingDTO) {

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
}
