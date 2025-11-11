package lk.puLeeNa.LibManagement.service.impl;

import jakarta.transaction.Transactional;
import lk.puLeeNa.LibManagement.dao.StaffDao;
import lk.puLeeNa.LibManagement.dto.StaffDTO;
import lk.puLeeNa.LibManagement.exception.StaffNotFoundException;
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
        staffDTO.setJoinDate(UtilData.generateTodayDate());
        staffDTO.setLastUpdateDate(UtilData.generateTodayDate());
        staffDTO.setLastUpdateTime(UtilData.generateCurrentTime());
        staffDao.save(entityDTOConvert.convertStaffDTOToEntity(staffDTO));
    }

    @Override
    public void deleteStaffMember(String staffId) {
        if(!staffDao.findById(staffId).isPresent()){
            throw new StaffNotFoundException("Staff Not Found");
        }
        staffDao.deleteById(staffId);
    }

    @Override
    public void updateStaffMember(String staffId, StaffDTO staffDTO) {
        var foundStaff = staffDao.findById(staffId);
        if(!foundStaff.isPresent()){
            throw new StaffNotFoundException("Staff Not Found");
        }
        foundStaff.get().setFirstName(staffDTO.getFirstName());
        foundStaff.get().setLastName(staffDTO.getLastName());
        foundStaff.get().setEmail(staffDTO.getEmail());
        foundStaff.get().setJoinDate(staffDTO.getJoinDate());
        foundStaff.get().setPhone(staffDTO.getPhone());
        foundStaff.get().setLastUpdateDate(UtilData.generateTodayDate());
        foundStaff.get().setLastUpdateTime(UtilData.generateCurrentTime());
        foundStaff.get().setRole(staffDTO.getRole());
    }

    @Override
    public StaffDTO getSelectedStaffMember(String staffId) {
        if(!staffDao.findById(staffId).isPresent()){
            throw new StaffNotFoundException("Staff Not Found");
        }
        return entityDTOConvert.convertStaffEntityToDTO(staffDao.getReferenceById(staffId));
    }

    @Override
    public List<StaffDTO> getAllStaffMembers() {
        return entityDTOConvert.toStaffDTOList(staffDao.findAll());
    }
}
