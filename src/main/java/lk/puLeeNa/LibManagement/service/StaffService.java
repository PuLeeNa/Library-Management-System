package lk.puLeeNa.LibManagement.service;

import lk.puLeeNa.LibManagement.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void addStaffMember(StaffDTO staffDTO);
    void deleteStaffMember(String staffId);
    void updateStaffMember(String staffId, StaffDTO staffDTO);
    StaffDTO getSelectedStaffMember(String staffId);
    List<StaffDTO> getAllStaffMembers();
}
