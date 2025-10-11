package lk.puLeeNa.LibManagement.service.impl;

import jakarta.transaction.Transactional;
import lk.puLeeNa.LibManagement.dao.StaffDao;
import lk.puLeeNa.LibManagement.dto.StaffDTO;
import lk.puLeeNa.LibManagement.service.StaffService;
import lk.puLeeNa.LibManagement.util.EntityDTOConvert;
import lk.puLeeNa.LibManagement.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // This annotation indicates that this class is a service component in the Spring context
@Transactional
@RequiredArgsConstructor
public class StaffServiceIMPL implements StaffService {

    private final StaffDao staffDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addStaffMember(StaffDTO staffDTO) {
        staffDTO.setStaffId(UtilData.generateStaffId());
        staffDTO.setLastUpdateDate(UtilData.generateTodayDate());
        staffDao.save(entityDTOConvert.convertStaffDTOToEntity(staffDTO));
    }

    @Override
    public void deleteStaffMember(String staffId) {

    }

    @Override
    public void updateStaffMember(String staffId, StaffDTO staffDTO) {

    }

    @Override
    public StaffDTO getSelectedStaffMember(String staffId) {
        return null;
    }

    @Override
    public List<StaffDTO> getAllStaffMembers() {
        return List.of();
    }
}
