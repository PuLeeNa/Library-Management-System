package lk.puLeeNa.LibManagement.service.impl;

import jakarta.transaction.Transactional;
import lk.puLeeNa.LibManagement.dao.MemberDao;
import lk.puLeeNa.LibManagement.dto.MemberDTO;
import lk.puLeeNa.LibManagement.exception.MemberNotFoundException;
import lk.puLeeNa.LibManagement.service.MemberService;
import lk.puLeeNa.LibManagement.util.EntityDTOConvert;
import lk.puLeeNa.LibManagement.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceIMPL implements MemberService {

    private final MemberDao memberDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addMember(MemberDTO memberDTO) {
        memberDTO.setMemberId(UtilData.generateMemberId());
        memberDTO.setMembershipDate(UtilData.generateTodayDate());
        memberDao.save(entityDTOConvert.convertMemberDTOToEntity(memberDTO));
    }

    @Override
    public void deleteMember(String memberId) {
        if(!memberDao.findById(memberId).isPresent()){
            throw new MemberNotFoundException("Member not exist");
        }
        memberDao.deleteById(memberId);
    }

    @Override
    public void updateMember(String memberId, MemberDTO memberDTO) {
        var selectedMember = memberDao.findById(memberId);
        if(!selectedMember.isPresent()){
            throw new MemberNotFoundException("Member not exist");
        }
        selectedMember.get().setName(memberDTO.getName());
        selectedMember.get().setEmail(memberDTO.getEmail());
        selectedMember.get().setMembershipDate(UtilData.generateTodayDate());
    }

    @Override
    public MemberDTO getSelectedMember(String memberId) {
        if(!memberDao.findById(memberId).isPresent()){
            throw new MemberNotFoundException("Member not exist");
        }
        return entityDTOConvert.convertMemberEntityToDTO(memberDao.getReferenceById(memberId));
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        return List.of(new MemberDTO());
    }
}
