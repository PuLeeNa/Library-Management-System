package lk.puLeeNa.LibManagement.service.impl;

import lk.puLeeNa.LibManagement.dto.StaffDTO;
import lk.puLeeNa.LibManagement.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // This annotation indicates that this class is a service component in the Spring context
public class StaffServiceIMPL implements StaffService {
    @Override
    public void addStaffMember(StaffDTO staffDTO) {

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
