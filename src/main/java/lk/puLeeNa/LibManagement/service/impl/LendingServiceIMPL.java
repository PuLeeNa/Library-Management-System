package lk.puLeeNa.LibManagement.service.impl;

import lk.puLeeNa.LibManagement.dto.LendingDTO;
import lk.puLeeNa.LibManagement.service.LendingService;
import lk.puLeeNa.LibManagement.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendingServiceIMPL implements LendingService {

    @Override
    public void addLendingData(LendingDTO lendingDTO) {
        lendingDTO.setLendingId(UtilData.generateLendingId());
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
}
