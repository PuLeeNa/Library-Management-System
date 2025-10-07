package lk.puLeeNa.LibManagement.service;

import lk.puLeeNa.LibManagement.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    void addMember(MemberDTO memberDTO);
    void deleteMember(String memberId);
    void updateMember(String memberId, MemberDTO memberDTO);
    MemberDTO getSelectedMember(String memberId);
    List<MemberDTO> getAllMembers();
}
