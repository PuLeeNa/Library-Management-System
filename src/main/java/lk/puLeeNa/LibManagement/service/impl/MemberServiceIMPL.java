package lk.puLeeNa.LibManagement.service.impl;

import lk.puLeeNa.LibManagement.dto.MemberDTO;
import lk.puLeeNa.LibManagement.service.MemberService;
import lk.puLeeNa.LibManagement.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceIMPL implements MemberService {

    @Override
    public void addMember(MemberDTO memberDTO) {
        memberDTO.setMemberId(UtilData.generateMemberId());
        memberDTO.setMembershipDate(String.valueOf(UtilData.generateTodayDate()));
        System.out.println(memberDTO);
    }

    @Override
    public void deleteMember(String memberId) {

    }

    @Override
    public void updateMember(String memberId, MemberDTO memberDTO) {

    }

    @Override
    public MemberDTO getSelectedMember(String memberId) {
        return new MemberDTO();
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        return List.of(new MemberDTO());
    }
}
