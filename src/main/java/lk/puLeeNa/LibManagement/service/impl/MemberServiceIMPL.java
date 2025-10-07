package lk.puLeeNa.LibManagement.service.impl;

import lk.puLeeNa.LibManagement.dto.MemberDTO;
import lk.puLeeNa.LibManagement.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceIMPL implements MemberService {

    @Override
    public void addMember(MemberDTO memberDTO) {

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
